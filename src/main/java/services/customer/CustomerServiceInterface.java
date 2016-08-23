package services.customer;

import customerproductorder.models.Customer;
import dao.DaoException;
import java.util.List;
import services.ServiceException;

public interface CustomerServiceInterface {

    public void create(Customer newCustomer) throws ServiceException;

    public Customer get(int id) throws ServiceException;

    public List<Customer> getAll() throws ServiceException;

    public void delete(int id) throws ServiceException;

    public void save(Customer changedCustomer) throws ServiceException;
}
