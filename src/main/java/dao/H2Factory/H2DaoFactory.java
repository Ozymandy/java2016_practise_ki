package dao.H2Factory;

import dao.CustomerDaoInterface;
import dao.DaoFactory;
import dao.OrderDaoInterface;
import dao.ProductDaoInterface;

public class H2DaoFactory implements DaoFactory {

    private ConnectionProvider connectionProvider;
    private static H2DaoFactory instance;

    private H2DaoFactory() {
        connectionProvider = ConnectionProvider.getConnectionProvider();
    }

    public CustomerDaoInterface getCustomerDao() {
        return new H2CustomerDao(connectionProvider);
    }

    public ProductDaoInterface getProductDao() {
        return new H2ProductDao(connectionProvider);
    }

    public OrderDaoInterface getOrderDao() {
        return new H2OrderDao(connectionProvider,
                new H2CustomerDao(connectionProvider));
    }

    public static H2DaoFactory getInstance() {
        if(instance==null){
            instance=new H2DaoFactory();
        }
        return instance;
    }
}
