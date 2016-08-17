package services.orders;

import customerproductorder.models.Customer;
import customerproductorder.models.Order;
import customerproductorder.models.Product;
import dao.DaoException;
import dao.H2Factory.H2DaoFactory;
import dao.OrderDaoInterface;
import java.util.List;
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

    public void create(Order newOrder) throws DaoException {
        Customer dbTempCustomer = customerService.get(newOrder.getCustomer()
                .getCardNumber());
        Customer tempCustomer = newOrder.getCustomer();
        List<Product> products = newOrder.getProducts();
        boolean isValid
                = tempCustomer.getAddress() == dbTempCustomer.getAddress()
                && tempCustomer.getFirstName() == dbTempCustomer.getFirstName()
                && tempCustomer.getName() == dbTempCustomer.getName();
        Product tempProduct;
        for (Product product : products) {
            tempProduct = productService.get(product.getProductId());
            isValid = isValid && tempProduct.getName() == product.getName()
                    && tempProduct.getProductCost() == product.getProductCost();
        }
        if (isValid) {
            orderDao.create(newOrder);
        }
    }

    public Order get(Customer customer) throws DaoException {
        return (Order) orderDao.get(customer);
    }

    public List<Order> getAll() throws DaoException {
        return orderDao.getAll();

    }

    public void delete(int id) throws DaoException {
        orderDao.delete(id);
    }

    public void save(Order changedOrder) throws DaoException {
        orderDao.save(changedOrder);
    }

    public Order get(int id) throws DaoException {
        return (Order) orderDao.get(id);
    }
}
