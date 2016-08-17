package dao.H2Factory;

import customerproductorder.models.Customer;
import customerproductorder.models.Order;
import customerproductorder.models.Product;
import dao.CustomerDaoInterface;
import dao.DaoException;
import dao.OrderDaoInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class H2OrderDao implements OrderDaoInterface {

    private final ConnectionProvider connectionProvider;
    private final CustomerDaoInterface customerDao;

    protected H2OrderDao(ConnectionProvider connectionProvider,
            CustomerDaoInterface customerDao) {
        this.connectionProvider = connectionProvider;
        this.customerDao = customerDao;
    }

    public void create(Order newOrder) throws DaoException {
        //TODO Try with resources
        try {
            PreparedStatement st = connectionProvider.getConnection()
                    .prepareStatement("insert into customerapplication."
                            + "ordertable(customerid,orderdate) values(?,?)");
            st.setInt(1, newOrder.getCustomer().getCardNumber());
            st.setDate(2, new java.sql.Date(new Date().getDate()));
            st.executeUpdate();
            ResultSet pk = st.getGeneratedKeys();
            long currentId = 0;
            if (pk.next()) {
                currentId = pk.getLong(1);
            }
            for (Product product : newOrder.getProducts()) {
                st = connectionProvider.getConnection().prepareStatement(
                        "set @idvar = ?; insert into customerapplication"
                        + ".product_order(orderid,"
                        + "productid) values(@idvar,?)");
                st.setLong(1, currentId);
                st.setInt(2, product.getProductId());
                st.executeUpdate();
                connectionProvider.destroy();
            }
        } catch (Exception e) {
            throw new DaoException("Inserting data error", e);
        }
    }

    public List<Order> getAll() throws DaoException {
        List<Order> list = new ArrayList<Order>();
        try {
            PreparedStatement st = connectionProvider.getConnection()
                    .prepareStatement("select * from customerapplication"
                            + ".ordertable");
            ResultSet rs = st.executeQuery();
            list = this.convertToOrder(rs);
            connectionProvider.destroy();
        } catch (SQLException e) {
            throw new DaoException("Getting data error", e);
        }
        return list;
    }

    public void delete(int id) throws DaoException {
        try {
            PreparedStatement st = connectionProvider.getConnection()
                    .prepareStatement("delete from customerapplication."
                            + "ordertable where id=?;"
                            + "delete from customerapplication."
                            + "order_product where orderId=?");
            st.setInt(1, id);
            st.setInt(2, id);
            st.executeUpdate();
            connectionProvider.destroy();
        } catch (SQLException e) {
            throw new DaoException("Deleting data error", e);
        }
    }

    public void save(Order changedOrder) throws DaoException {
        try {
            //TODO implementation of inserting new products in order
            PreparedStatement st = connectionProvider.getConnection()
                    .prepareStatement("update customerapplication.ordertable"
                            + "set orderdate=?,customerid=? where orderid=?");
            st.setInt(1, changedOrder.getCustomer().getCardNumber());
            st.setDate(2, new java.sql.Date(changedOrder.getOrderDate()
                    .getDate()));
            st.setInt(3, changedOrder.getOrderId());
            st.executeUpdate();
            connectionProvider.destroy();
        } catch (SQLException e) {
            throw new DaoException("Saving error", e);
        }
    }

    public List<Order> get(Customer customer) throws DaoException {
        List<Order> list = new ArrayList<Order>();
        try {
            PreparedStatement st = connectionProvider.getConnection()
                    .prepareStatement("select * "
                            + "from customerapplication.ordertable where id=?");
            ResultSet rs = st.executeQuery();
            list = this.convertToOrder(rs);
            connectionProvider.destroy();
        } catch (SQLException e) {
            throw new DaoException("Getting data error", e);
        }
        return list;
    }

    public Order get(int id) throws DaoException {
        //TODO Optional
        Order gotOrder = null;
        try {
            PreparedStatement st = connectionProvider.getConnection()
                    .prepareStatement("select * "
                            + "from customerapplication.ordertable where id=?");
            ResultSet rs = st.executeQuery();
            gotOrder = this.convertToOrder(rs).get(0);
            connectionProvider.destroy();
        } catch (SQLException e) {
            throw new DaoException("Getting data error", e);
        }
        return gotOrder;
    }

    private List<Product> getOrderProducts(int orderId) throws SQLException, DaoException {
        List<Product> list = new ArrayList<Product>();
        PreparedStatement st = connectionProvider.getConnection()
                .prepareStatement("select "
                        + "customerapplication.product.* from "
                        + "customerapplication.product as product"
                        + "inner join customerapplication.order_product"
                        + "as order_product"
                        + "on product.id = order_product.productid"
                        + "where order_product.productid=?");
        st.setInt(1, orderId);
        ResultSet rs = st.executeQuery();
        connectionProvider.destroy();
        while (rs.next()) {
            int tempId = rs.getInt("id");
            String tempName = rs.getString("productname");
            int tempCost = rs.getInt("productcost");
            list.add(new Product(tempName, tempCost, tempId));
        }
        return list;
    }

    private List<Order> convertToOrder(ResultSet rs) throws SQLException,DaoException {
        List<Order> list = new ArrayList<Order>();
        while (rs.next()) {
            int tempId = rs.getInt("id");
            Date tempDate = rs.getDate("orderdate");
            Customer tempCustomer = customerDao
                    .get(rs.getInt("customerid"));
            list.add(new Order(tempCustomer, this
                    .getOrderProducts(tempId), tempId, tempDate));
        }
        return list;
    }
}
