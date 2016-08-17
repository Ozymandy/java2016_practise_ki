package services.customer;

import customerproductorder.models.Customer;
import dao.DaoException;
import java.util.List;

public interface CustomerServiceInterface {

    public void create(Customer newCustomer) throws DaoException;

    public Customer get(int id) throws DaoException;

    public List<Customer> getAll() throws DaoException;

    public void delete(int id) throws DaoException;

    public void save(Customer changedCustomer) throws DaoException;
}
