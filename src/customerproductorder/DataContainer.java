
package customerproductorder;
import java.util.*;
import customerproductorder.Classes.*;

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
            if(order.getCustomer().getLastName().contains(keyword)){
                temp.add(order);
            }
        }
        return temp;
    }
}
