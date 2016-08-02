package customerproductorder.models;

import java.util.Date;
import java.util.List;

/**
 * Class of Order's model.
 */
public class Order {

    /**
     * Field which contains customer.
     */
    private Customer customer;
    /**
     * Class that contains products of this order.
     */
    private List<Product> products;
    /**
     * Unique id
     */
    private int id;
    /**
     * OrderDate
     */
    private Date orderDate;

    /**
     * Ctor.
     *
     * @param customer
     * @param products
     */
    public Order(Customer customer, List<Product> products, int id, Date orderDate) {
        this.products = products;
        this.customer = customer;
        this.id = id;
        this.orderDate = orderDate;
    }

    /**
     * Our implementation of toString() method
     *
     * @return class view
     */
    @Override
    public String toString() {
        return "Customer " + customer.getFirstName() + " " + customer.
                getName() + " ordered " + products.size() + " items";
    }

    /**
     * Access method of field customer.
     *
     * @return customer
     */
    public Customer getCustomer() {
        return this.customer;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public int getOrderId() {
        return this.id;
    }

    public Date getOrderDate() {
        return this.orderDate;
    }
}
