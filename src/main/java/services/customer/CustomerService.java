package services.customer;

import customerproductorder.models.Customer;
import dao.CustomerDaoInterface;
import dao.DaoException;
import dao.H2Factory.H2DaoFactory;
import dao.InterfaceDao;
import java.util.List;

public class CustomerService implements CustomerServiceInterface {


    private static CustomerService instance;
    private final CustomerDaoInterface customerDao;


    private CustomerService() {
        customerDao = H2DaoFactory.getInstance().getCustomerDao();
    }


    public static CustomerService getInstance() {
        if (instance == null) {
            instance = new CustomerService();
        }
        return instance;
    }

    public void create(Customer newCustomer) throws DaoException {
        customerDao.create(newCustomer);
    }

    public Customer get(int id) throws DaoException {
        return (Customer) customerDao.get(id);
    }

    public List<Customer> getAll() throws DaoException {
        return customerDao.getAll();
    }

    public void delete(int id) throws DaoException {
        customerDao.delete(id);
    }

    public void save(Customer changedCustomer) throws DaoException {
        customerDao.save(changedCustomer);
    }
}
