package dao.H2Factory;

import customerproductorder.models.Product;
import dao.DaoException;
import dao.ProductDaoInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class H2ProductDao implements ProductDaoInterface {

    private final ConnectionProvider connectionProvider;

    protected H2ProductDao(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

    public void create(Product newProduct) throws DaoException {
        try {
            PreparedStatement st = connectionProvider.getConnection()
                    .prepareStatement("insert into customerapplication"
                            + ".product(productName,productCost) values (?,?)");
            st.setString(1, newProduct.getName());
            st.setInt(1, newProduct.getProductCost());
            st.executeUpdate();
        } catch (SQLException ex) {
            throw new DaoException("Database connection error", ex);
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
            gotProduct = this.convertToProduct(rs).get(0);
        } catch (SQLException ex) {
            throw new DaoException("Database connection error", ex);
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
            list = this.convertToProduct(rs);
        } catch (SQLException ex) {
            throw new DaoException("Database connection error", ex);
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
        } catch (SQLException ex) {
            throw new DaoException("Database connection error", ex);
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
        } catch (SQLException ex) {
            throw new DaoException("Database connection error", ex);
        }
    }

    private List<Product> convertToProduct(ResultSet rs) throws SQLException {
        List<Product> list = new ArrayList<Product>();
        while (rs.next()) {
            int tempId = rs.getInt("id");
            String tempName = rs.getString("productname");
            int tempCost = rs.getInt("productcost");
            list.add(new Product(tempName, tempCost, tempId));
        }
        return list;
    }
}
