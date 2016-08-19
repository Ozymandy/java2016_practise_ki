package dao.H2Factory;

import customerproductorder.models.Customer;
import dao.CustomerDaoInterface;
import dao.DaoException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class H2CustomerDao implements CustomerDaoInterface {

    private final ConnectionProvider connectionProvider;

    protected H2CustomerDao(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
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
        } catch (SQLException e) {
            throw new DaoException("Inserting data error", e);
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
            gotCustomer = this.convertToCustomer(rs).get(0);
            connectionProvider.destroy();
        } catch (SQLException e) {
            throw new DaoException("Selection data error", e);
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
            set = this.convertToCustomer(rs);
            connectionProvider.destroy();
        } catch (SQLException e) {
            throw new DaoException("Database connection error", e);
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
        } catch (SQLException e) {
            throw new DaoException("Deleting data error", e);
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
        } catch (SQLException e) {
            throw new DaoException("Saving data error", e);
        }
    }

    private List<Customer> convertToCustomer(ResultSet rs) throws SQLException {
        List list = new ArrayList<Customer>();
        while (rs.next()) {
            int tempId = rs.getInt("id");
            String tempLastName = rs.getString("lastname");
            String tempFirstName = rs.getString("firstname");
            String tempAddress = rs.getString("address");
            list.add(new Customer(tempFirstName, tempLastName, tempAddress,
                    tempId));
        }
        return list;
    }
}
