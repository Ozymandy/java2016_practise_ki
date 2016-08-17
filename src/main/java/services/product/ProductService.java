package services.product;

import customerproductorder.models.Product;
import dao.DaoException;
import dao.H2Factory.H2DaoFactory;
import dao.ProductDaoInterface;
import java.util.List;

public class ProductService implements ProductServiceInterface {

    private static ProductService instance;
    private final ProductDaoInterface productDao;

    private ProductService() {
        instance = new ProductService();
        productDao = H2DaoFactory.getInstance().getProductDao();
    }

    public static ProductService getInstance() {
        return instance;
    }

    public void create(Product newProduct) throws DaoException {
        productDao.create(newProduct);
    }

    public Product get(int id) throws DaoException {
        return (Product) productDao.get(id);
    }

    public List<Product> getAll() throws DaoException {
        return productDao.getAll();
    }

    public void delete(int id) throws DaoException {
        productDao.delete(id);
    }

    public void save(Product changedProduct) throws DaoException {
        productDao.save(changedProduct);
    }
}
