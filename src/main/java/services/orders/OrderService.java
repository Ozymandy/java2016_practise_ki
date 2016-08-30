package services.orders;

import customerproductorder.models.Customer;
import customerproductorder.models.Order;
import customerproductorder.models.Product;
import dao.OrderDaoInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.customer.CustomerServiceInterface;
import services.product.ProductServiceInterface;

@Service("orderService")
public class OrderService implements OrderServiceInterface {

    @Autowired
    private OrderDaoInterface orderDao;
    @Autowired
    private CustomerServiceInterface customerService;
    @Autowired
    private ProductServiceInterface productService;

    public void create(Order newOrder) {
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

    @Override
    public Order get(Customer customer) {
        return (Order) orderDao.get(customer);
    }

    public List<Order> getAll() {
        return orderDao.getAll();

    }

    public void delete(int id) {
        orderDao.delete(id);
    }

    public void save(Order changedOrder) {
        orderDao.save(changedOrder);
    }

    public Order get(int id) {
        return (Order) orderDao.get(id);
    }
}
