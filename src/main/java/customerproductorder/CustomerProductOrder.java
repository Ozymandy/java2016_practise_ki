package customerproductorder;

import customerproductorder.models.Order;
import customerproductorder.models.Product;
import customerproductorder.models.Customer;
import customerproductorder.models.comparators.ModelComparator;
import java.util.Collections;
import java.util.List;

/**
 * Main class.
 */
public class CustomerProductOrder {

    /**
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        // TODO code application logic here
        DataContainer container = new DataContainer();
        List<Customer> customers = container.getCustomers();
        List<Order> orders = container.getOrders();
        List<Product> products = container.getProducts();
        customers.add(new Customer("Constantine", "Ihnatsenka",
                "Krinichnaya st. 8-10", "0001"));
        customers.add(new Customer("Eugene", "Sergeev",
                "Pushkina st. 1-10", "0002"));
        customers.add(new Customer("Leonid", "Slutsky",
                "Lenina st.", "0003"));
        customers.add(new Customer("Marco", "Reus",
                "Pervomayskaya st.", "0004"));
        products.add(new Product("Ball", 15, 1));
        products.add(new Product("Coke", 12, 3));
        products.add(new Product("Hamburger", 100, 5));
        orders.add(new Order(customers.get(2),
                products));
        Collections.sort(customers, new ModelComparator());
        for (Customer customer : customers) {
            System.out.println(customer);
        }
        for (Order order : container.searchBySecondName("Slutsky")) {
            System.out.println(order);
        }
    }

}
