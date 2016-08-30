package dao;

import customerproductorder.models.Product;
import java.util.List;

public interface ProductDaoInterface {

    public void create(Product newProduct);

    public Product get(int id);

    public List<Product> getAll();

    public void delete(int id);

    public void save(Product changedProduct);
}
