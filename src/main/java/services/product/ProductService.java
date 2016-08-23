package services.product;

import customerproductorder.models.Product;
import dao.DaoException;
import dao.H2Factory.H2DaoFactory;
import dao.ProductDaoInterface;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.ServiceException;

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

    public void create(Product newProduct) throws ServiceException {
        try {
            productDao.create(newProduct);
        } catch (DaoException ex) {
            throw new ServiceException("Creating error", ex);
        }
    }

    public Product get(int id) throws ServiceException {
        try {
            return (Product) productDao.get(id);
        } catch (DaoException ex) {
            throw new ServiceException("Getting error", ex);
        }
    }

    public List<Product> getAll() throws ServiceException {
        try {
            return productDao.getAll();
        } catch (DaoException ex) {
            throw new ServiceException("Getting error", ex);
        }
    }

    public void delete(int id) throws ServiceException {
        try {
            productDao.delete(id);
        } catch (DaoException ex) {
            throw new ServiceException("Deleting error", ex);
        }
    }

    public void save(Product changedProduct) throws ServiceException {
        try {
            productDao.save(changedProduct);
        } catch (DaoException ex) {
            throw new ServiceException("Saving error", ex);
        }
    }
}
