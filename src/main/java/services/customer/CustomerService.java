package services.customer;

import customerproductorder.models.Customer;
import dao.CustomerDaoInterface;
import dao.DaoException;
import dao.H2Factory.H2DaoFactory;
import dao.InterfaceDao;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.ServiceException;

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

    public void create(Customer newCustomer) throws ServiceException {
        try {
            customerDao.create(newCustomer);
        } catch (DaoException ex) {
            throw new ServiceException("Creation error", ex);
        }
    }

    public Customer get(int id) throws ServiceException {
        try {
            return (Customer) customerDao.get(id);
        } catch (DaoException ex) {
            throw new ServiceException("Getting error", ex);
        }
    }

    public List<Customer> getAll() throws ServiceException {
        try {
            return customerDao.getAll();
        } catch (DaoException ex) {
            throw new ServiceException("Getting error", ex);
        }
    }

    public void delete(int id) throws ServiceException {
        try {
            customerDao.delete(id);
        } catch (DaoException ex) {
            throw new ServiceException("Deleting error", ex);
        }
    }

    public void save(Customer changedCustomer) throws ServiceException {
        try {
            customerDao.save(changedCustomer);
        } catch (DaoException ex) {
            throw new ServiceException("Saving error", ex);
        }
    }
}
