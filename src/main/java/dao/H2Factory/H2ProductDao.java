package dao.H2Factory;

import customerproductorder.models.Product;
import dao.DaoException;
import dao.H2Factory.converters.Converting;
import dao.H2Factory.converters.ProductConverter;
import dao.ProductDaoInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class H2ProductDao implements ProductDaoInterface {

    private final ConnectionProvider connectionProvider;
    private static final Logger LOG = LoggerFactory.getLogger(H2ProductDao.class);
    private final Converting<Product> converter;

    protected H2ProductDao(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
        converter = ProductConverter.getInstance();
    }

    public void create(Product newProduct) throws DaoException {
        try {
            PreparedStatement st = connectionProvider.getConnection()
                    .prepareStatement("insert into customerapplication"
                            + ".product(productName,productCost) values (?,?)");
            st.setString(1, newProduct.getName());
            st.setInt(1, newProduct.getProductCost());
            st.executeUpdate();
            connectionProvider.destroy();
        } catch (SQLException ex) {
            LOG.error(ex.getSQLState());
            throw new DaoException("Inserting data error", ex);
        }
    }

    public Product get(int id) throws DaoException {
        Product gotProduct = null;
        try {
            PreparedStatement st = connectionProvider.getConnection()
                    .prepareStatement("select * from customerapplication"
                            + ".product where id=?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            gotProduct = converter.convert(rs).get(0);
            connectionProvider.destroy();
        } catch (SQLException ex) {
            LOG.error(ex.getSQLState());
            throw new DaoException("Getting data error", ex);
        }
        return gotProduct;
    }

    public List<Product> getAll() throws DaoException {
        List<Product> list = new ArrayList<Product>();
        try {
            PreparedStatement st = connectionProvider.getConnection()
                    .prepareStatement("select * from customerapplication"
                            + ".product");
            ResultSet rs = st.executeQuery();
            list = converter.convert(rs);
            connectionProvider.destroy();
        } catch (SQLException ex) {
            LOG.error(ex.getSQLState());
            throw new DaoException("Getting data error", ex);
        }
        return list;
    }

    public void delete(int id) throws DaoException {
        try {
            PreparedStatement st = connectionProvider.getConnection()
                    .prepareStatement("delete from customerapplication"
                            + ".product where id=?");
            st.setInt(1, id);
            st.executeUpdate();
            connectionProvider.destroy();
        } catch (SQLException ex) {
            LOG.error(ex.getSQLState());
            throw new DaoException("Deleting data error", ex);
        }
    }

    public void save(Product changedProduct) throws DaoException {
        try {
            PreparedStatement st = connectionProvider.getConnection()
                    .prepareStatement("update customerapplication"
                            + ".product set productname=?,productcost=? where id=?");
            st.setInt(1, changedProduct.getProductCost());
            st.setInt(2, changedProduct.getProductId());
            st.executeUpdate();
            connectionProvider.destroy();
        } catch (SQLException ex) {
            LOG.error(ex.getSQLState());
            throw new DaoException("Saving error", ex);
        }
    }
}
