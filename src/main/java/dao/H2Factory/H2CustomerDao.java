package dao.H2Factory;

import customerproductorder.models.Customer;
import dao.CustomerDaoInterface;
import dao.DaoException;
import dao.H2Factory.converters.Converting;
import dao.H2Factory.converters.CustomerConverter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class H2CustomerDao implements CustomerDaoInterface {

    private final ConnectionProvider connectionProvider;
    private static final Logger LOG = LoggerFactory
            .getLogger(H2CustomerDao.class);
    private Converting<Customer> converter;

    protected H2CustomerDao(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
        converter = CustomerConverter.getInstance();
    }

    public void create(Customer newCustomer) throws DaoException {
        try {
            PreparedStatement st = connectionProvider.getConnection()
                    .prepareStatement("insert into customerapplication"
                            + ".customer(firstname,lastname,"
                            + "address) values(?,?,?)");
            st.setString(1, newCustomer.getFirstName());
            st.setString(2, newCustomer.getName());
            st.setString(3, newCustomer.getAddress());
            st.executeUpdate();
            connectionProvider.destroy();
        } catch (SQLException ex) {
            LOG.error(ex.getSQLState());
            throw new DaoException("Inserting data error", ex);
        }
    }

    public Customer get(int id) throws DaoException {
        Customer gotCustomer = null;
        try {
            PreparedStatement st = connectionProvider.getConnection()
                    .prepareStatement("select * from customerapplication"
                            + ".customer where id=?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            gotCustomer = converter.convert(rs).get(0);
            connectionProvider.destroy();
        } catch (SQLException ex) {
            LOG.error(ex.getSQLState());
            throw new DaoException("Selection data error", ex);
        }
        return gotCustomer;
    }

    public List<Customer> getAll() throws DaoException {
        List<Customer> set = new ArrayList<Customer>();
        try {
            PreparedStatement st = connectionProvider.getConnection()
                    .prepareStatement("select * from customerapplication"
                            + ".customer");
            ResultSet rs = st.executeQuery();
            set = converter.convert(rs);
            connectionProvider.destroy();
        } catch (SQLException ex) {
            LOG.error(ex.getSQLState());
            throw new DaoException("Database connection error", ex);
        }
        return set;
    }

    public void delete(int id) throws DaoException {
        try {
            PreparedStatement st = connectionProvider.getConnection()
                    .prepareStatement("delete from customerapplication"
                            + ".customer where id=?");
            st.setInt(1, id);
            st.executeUpdate();
            connectionProvider.destroy();
        } catch (SQLException ex) {
            LOG.error(ex.getSQLState());
            throw new DaoException("Deleting data error", ex);
        }
    }

    public void save(Customer changedCustomer) throws DaoException {
        try {
            PreparedStatement st = connectionProvider.getConnection()
                    .prepareStatement("update customerapplication"
                            + ".customer set firstname=?,"
                            + "lastname=?,address=? where id=?");
            st.setString(1, changedCustomer.getFirstName());
            st.setString(2, changedCustomer.getName());
            st.setString(3, changedCustomer.getAddress());
            st.setInt(4, changedCustomer.getCardNumber());
            st.executeUpdate();
            connectionProvider.destroy();
        } catch (SQLException ex) {
            LOG.error(ex.getSQLState());
            throw new DaoException("Saving data error", ex);
        }
    }
}
