package dao;

import customerproductorder.models.Customer;
import customerproductorder.models.Order;
import customerproductorder.models.Product;
import java.util.List;

public interface OrderDaoInterface {

    public void create(Order newOrder) throws DaoException;

    public List<Order> get(Customer customer) throws DaoException;

    public Order get(int id) throws DaoException;

    public List<Order> getAll() throws DaoException;

    public void delete(int id) throws DaoException;

    public void save(Order changedOrder) throws DaoException;
}
