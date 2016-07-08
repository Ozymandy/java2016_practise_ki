
package customerproductorder.models;
import java.util.*;

public class Order {
    private Customer customer;
    private List<Product> products;
    public Order(Customer customer, List<Product> products){
        //this.product = product;
        this.products = products;
        this.customer = customer;
    }
    @Override
    public String toString(){
        return "Customer " + customer.getFirstName() + " "+ customer.
                getName() + " ordered " + products.size() + " items";
    }
    public Customer getCustomer(){
        return this.customer;
    }
}
