package services.orders;

import customerproductorder.models.Customer;
import customerproductorder.models.Order;
import dao.DaoException;
import java.util.List;
import services.ServiceException;

public interface OrderServiceInterface {

    public void create(Order newOrder) throws ServiceException;

    public Order get(Customer customer) throws ServiceException;

    public Order get(int id) throws ServiceException;

    public List<Order> getAll() throws ServiceException;

    public void delete(int id) throws ServiceException;

    public void save(Order changedOrder) throws ServiceException;
}
