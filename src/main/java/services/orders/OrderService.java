package services.orders;

import customerproductorder.models.Customer;
import customerproductorder.models.Order;
import customerproductorder.models.Product;
import dao.DaoException;
import dao.H2Factory.H2DaoFactory;
import dao.OrderDaoInterface;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.ServiceException;
import services.customer.CustomerService;
import services.customer.CustomerServiceInterface;
import services.product.ProductService;
import services.product.ProductServiceInterface;

public class OrderService implements OrderServiceInterface {

    private static OrderService instance;
    private final OrderDaoInterface orderDao;
    private final CustomerServiceInterface customerService;
    private final ProductServiceInterface productService;

    private OrderService() {
        instance = new OrderService();
        orderDao = H2DaoFactory.getInstance().getOrderDao();
        customerService = CustomerService.getInstance();
        productService = ProductService.getInstance();
    }

    public static OrderService getInstance() {
        return instance;
    }

    public void create(Order newOrder) throws ServiceException {
        Customer dbTempCustomer = customerService.get(newOrder.getCustomer()
                .getCardNumber());
        Customer tempCustomer = newOrder.getCustomer();
        List<Product> products = newOrder.getProducts();
        boolean isValid
                = tempCustomer.getAddress() == dbTempCustomer.getAddress()
                && tempCustomer.getFirstName() == dbTempCustomer.getFirstName()
                && tempCustomer.getName() == dbTempCustomer.getName();
        Product tempProduct;
        try{
        for (Product product : products) {
                tempProduct = productService.get(product.getProductId());
            isValid = isValid && tempProduct.getName() == product.getName()
                    && tempProduct.getProductCost() == product.getProductCost();
        }
        if (isValid) {
            orderDao.create(newOrder);
        }}
        catch(DaoException ex){
            throw new ServiceException("Creating error",ex);
        }
    }

    @Override
    public Order get(Customer customer) throws ServiceException {
        try {
            return (Order) orderDao.get(customer);
        } catch (DaoException ex) {
            throw new ServiceException("Getting error",ex);
        }
    }

    public List<Order> getAll() throws ServiceException {
        try {
            return orderDao.getAll();
        } catch (DaoException ex) {
            throw new ServiceException("Getting error",ex);
        }

    }

    public void delete(int id) throws ServiceException {
        try {
            orderDao.delete(id);
        } catch (DaoException ex) {
            throw new ServiceException("Deleting error",ex);
        }
    }

    public void save(Order changedOrder) throws ServiceException {
        try {
            orderDao.save(changedOrder);
        } catch (DaoException ex) {
            throw new ServiceException("Saving error",ex);
        }
    }

    public Order get(int id) throws ServiceException {
        try {
            return (Order) orderDao.get(id);
        } catch (DaoException ex) {
            throw new ServiceException("Getting error",ex);
        }
    }
}
