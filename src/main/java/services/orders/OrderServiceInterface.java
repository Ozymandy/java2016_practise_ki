package services.orders;

import customerproductorder.models.Customer;
import customerproductorder.models.Order;
import java.util.List;

public interface OrderServiceInterface {

    public void create(Order newOrder);

    public Order get(Customer customer);

    public Order get(int id);

    public List<Order> getAll();

    public void delete(int id);

    public void save(Order changedOrder);
}
