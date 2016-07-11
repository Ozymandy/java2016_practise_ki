package customerproductorder;

import customerproductorder.models.Order;
import customerproductorder.models.Product;
import customerproductorder.models.Customer;
import java.util.List;
import java.util.ArrayList;

/**
 * <
 * p>
 * Class where we initialize our data collections.</p>
 */
public class DataContainer {

    /**
     * <p>
     * List of customers.</p>
     */
    private List<Customer> customers;

    /**
     * <
     * p>
     * Product list.</p>
     */
    private List<Product> products;

    /**
     * <
     * p>
     * Order list.</p>
     */
    private List<Order> orders;

    /**
     * <p>
     * Ctor of the class. Here we initialize fields when we store information of
     * our customers, orders and products.</p>
     */
    public DataContainer() {
        customers = new ArrayList<Customer>();
        orders = new ArrayList<Order>();
        products = new ArrayList<Product>();
    }

    /**
     * <p>
     * Method which search orders by customers.</p>
     *
     * @param keyword Search keyword to search by customer's last name
     * @return list of the found orders by customer
     */
    public final List<Order> searchBySecondName(final String keyword) {
        List<Order> temp = new ArrayList<Order>();
        for (Order order : orders) {
            if (order.getCustomer().getName().contains(keyword)) {
                temp.add(order);
            }
        }
        return temp;
    }

    /**
     * It's access method for customers field.
     *
     * @return customers field.
     */
    public List<Customer> getCustomers() {
        return customers;
    }

    /**
     * It's access method for orders field.
     *
     * @return orders field.
     */
    public List<Order> getOrders() {
        return orders;
    }

    /**
     * It's access method for products field.
     *
     * @return products field.
     */
    public List<Product> getProducts() {
        return products;
    }
}
