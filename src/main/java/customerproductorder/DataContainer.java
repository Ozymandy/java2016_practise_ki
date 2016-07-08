
package customerproductorder;
import customerproductorder.models.Order;
import customerproductorder.models.Product;
import customerproductorder.models.Customer;
import java.util.*;

public class DataContainer {
    public List<Customer> customers;
    public List<Product> products;
    public List<Order> orders;
    public DataContainer(){
        customers = new ArrayList<Customer>();
        orders = new ArrayList<Order>();
        products = new ArrayList<Product>();
    }
    public List<Order> searchBySecondName(String keyword){
        List<Order> temp = new ArrayList<Order>();
        for(Order order:orders){
            if(order.getCustomer().getName().contains(keyword)){
                temp.add(order);
            }
        }
        return temp;
    }
}
