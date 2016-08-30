package services.customer;

import customerproductorder.models.Customer;
import java.util.List;

public interface CustomerServiceInterface {

    public void create(Customer newCustomer);

    public Customer get(int id);

    public List<Customer> getAll();

    public void delete(int id);

    public void save(Customer changedCustomer);
}
