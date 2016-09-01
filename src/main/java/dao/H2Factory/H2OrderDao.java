package dao.H2Factory;

import customerproductorder.models.Customer;
import customerproductorder.models.Order;
import customerproductorder.models.Product;
import dao.H2Factory.utils.OrderMapper;
import dao.H2Factory.utils.ProductMapper;
import dao.OrderDaoInterface;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class H2OrderDao implements OrderDaoInterface {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Resource(name = "orderMapper")
    private RowMapper mapper;
    @Resource(name = "productMapper")
    private RowMapper productMapper;

    H2OrderDao() {
    }

    public void insertOrderSql(Order newOrder) {
        String queryOrderTable = "insert into customerapplication."
                + "ordertable(customerid,orderdate) "
                + "values(:customerid,:orderdate)";
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("customerid", newOrder
                .getCustomer().getCardNumber());
        parameters.addValue("orderdate", newOrder.getOrderDate());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(queryOrderTable, parameters, keyHolder,
                new String[]{"GENERATED_ID"});
        Number generatedId = keyHolder.getKey();
        int tempId = generatedId.intValue();
        String queryProductOrder = "insert into "
                + "customerapplication.product_order(orderid,"
                + "productid) values(:idvar,:productid)";
        Map namedParametersProductOrder = new HashMap();
        for (Product product : newOrder.getProducts()) {
            namedParametersProductOrder.put("idvar", tempId);
            namedParametersProductOrder.put(":productid",
                    product.getProductId());
            jdbcTemplate.update(queryProductOrder, namedParametersProductOrder);
            namedParametersProductOrder.clear();
        }
    }

    public List<Order> getAll() {
        String queryOrder = "select * from customerapplication.ordertable";
        List<Order> orders = jdbcTemplate.query(queryOrder, mapper);
        for (Order order : orders) {
            order.addProducts(this.getOrderProducts(order.getOrderId()));
        }
        return orders;
    }

    public void delete(int id) {
        String queryOrderTable = "delete from customerapplication."
                + "ordertable where id=:orderid;"
                + "delete from customerapplication."
                + "order_product where orderId=:orderid";
        Map params = new HashMap();
        params.put("orderid", id);
        jdbcTemplate.update(queryOrderTable, params);

    }

    public void save(Order changedOrder) {
        String query = "update customerapplication.ordertable"
                + "set orderdate=:orderdate,customerid=:customerid "
                + "where orderid=:orderid";
        Map params = new HashMap();
        params.put("orderdate", changedOrder.getOrderDate());
        params.put("customerid", changedOrder.getCustomer().getCardNumber());
        params.put("orderid", changedOrder.getOrderId());
        jdbcTemplate.update(query, params);
    }

    public List<Order> get(Customer customer) {
        String query = "select * from customerapplication.ordertable"
                + " where id=:customerid";
        Map params = new HashMap();
        params.put("customerid", customer.getCardNumber());
        List<Order> orders = jdbcTemplate.query(query,
                params, mapper);
        for (Order order : orders) {
            order.addProducts(this.getOrderProducts(order.getOrderId()));
        }
        return orders;
    }

    public Order get(int id) {
        String query = "select * "
                + "from customerapplication.ordertable "
                + "where id=:orderid";
        Map params = new HashMap();
        params.put("orderid", id);
        Order order = (Order) jdbcTemplate.query(query, params,
                mapper);
        order.addProducts(this.getOrderProducts(id));
        return order;
    }

    private List<Product> getOrderProducts(int orderId) {
        String query = "select "
                + "customerapplication.product.* from "
                + "customerapplication.product as product"
                + " inner join customerapplication.order_product"
                + "as order_product"
                + "on product.id = order_product.productid"
                + "where order_product.productid=:orderid";
        Map params = new HashMap();
        params.put("orderid", orderId);
        List<Product> products = jdbcTemplate.query(query, params,
                productMapper);
        return products;
    }
}
