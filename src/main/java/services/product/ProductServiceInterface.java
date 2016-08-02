package services.product;

import customerproductorder.models.Product;
import dao.DaoException;
import java.util.List;

public interface ProductServiceInterface {

    public void create(Product newProduct) throws DaoException;

    public Product get(int id) throws DaoException;

    public List<Product> getAll() throws DaoException;

    public void delete(int id) throws DaoException;

    public void save(Product changedProduct) throws DaoException;
}
