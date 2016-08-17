package dao;

import customerproductorder.models.Product;
import java.util.List;

public interface ProductDaoInterface {

    public void create(Product newProduct) throws DaoException;

    public Product get(int id) throws DaoException;

    public List<Product> getAll() throws DaoException;

    public void delete(int id) throws DaoException;

    public void save(Product changedProduct) throws DaoException;
}
