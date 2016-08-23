package services.product;

import customerproductorder.models.Product;
import java.util.List;
import services.ServiceException;

public interface ProductServiceInterface {

    public void create(Product newProduct) throws ServiceException;

    public Product get(int id) throws ServiceException;

    public List<Product> getAll() throws ServiceException;

    public void delete(int id) throws ServiceException;

    public void save(Product changedProduct) throws ServiceException;
}
