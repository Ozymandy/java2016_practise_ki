package dao;

public interface DaoFactory {

    public CustomerDaoInterface getCustomerDao();

    public ProductDaoInterface getProductDao();

    public OrderDaoInterface getOrderDao();
}
