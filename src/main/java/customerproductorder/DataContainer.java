package customerproductorder;

import customerproductorder.models.Order;
import customerproductorder.models.Product;
import customerproductorder.models.Customer;
import customerproductorder.models.comparators.ModelComparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * <
 * p>
 * Class where we initialize our data collections.</p>
 */
public class DataContainer {

    /**
     * List of customers.
     */
    private List<Customer> customers;
    private static final DataContainer instance = new DataContainer();
    /**
     * Product list.
     */
    private List<Product> products;

    /**
     * Order list.
     */
    private List<Order> orders;

    /**
     * Ctor of the class. Here we initialize fields when we store information of
     * our customers, orders and products.
     */
    private DataContainer() {
        this.customers = new ArrayList<Customer>();
        this.orders = new ArrayList<Order>();
        this.products = new ArrayList<Product>();
        this.customers.add(new Customer("Constantine", "Ihnatsenka",
                "Krinichnaya st. 8-10", 1));
        this.customers.add(new Customer("Eugene", "Sergeev",
                "Pushkina st. 1-10", 2));
        this.customers.add(new Customer("Leonid", "Slutsky",
                "Lenina st.", 3));
        this.customers.add(new Customer("Marco", "Reus",
                "Pervomayskaya st.", 4));
        this.products.add(new Product("Ball", 15, 1));
        this.products.add(new Product("Coke", 12, 3));
        this.products.add(new Product("Hamburger", 100, 5));
        this.orders.add(new Order(customers.get(2),
                products));
        Collections.sort(customers, new ModelComparator());
    }

    /**
     * Method which search orders by customers.
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

    public final Customer searchCustomerByCardId(int cardId) {
        Customer temp = null;
        for (Customer customer : customers) {
            if (customer.getCardNumber() == cardId) {
                temp = customer;
                break;
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

    public static DataContainer getInstance() {
        return instance;
    }
}
