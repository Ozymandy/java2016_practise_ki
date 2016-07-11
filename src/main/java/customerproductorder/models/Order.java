package customerproductorder.models;

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
     * Ctor.
     *
     * @param customer
     * @param products
     */
    public Order(Customer customer, List<Product> products) {
        this.products = products;
        this.customer = customer;
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
}
