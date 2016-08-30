package services.customer;

import customerproductorder.models.Customer;
import dao.CustomerDaoInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("customerService")
public class CustomerService implements CustomerServiceInterface {

    @Autowired
    private CustomerDaoInterface customerDao;

    public void create(Customer newCustomer) {
        customerDao.create(newCustomer);
    }

    public Customer get(int id) {
        return (Customer) customerDao.get(id);
    }

    public List<Customer> getAll() {
        return customerDao.getAll();
    }

    public void delete(int id) {
        customerDao.delete(id);
    }

    public void save(Customer changedCustomer) {
        customerDao.save(changedCustomer);
    }
}
