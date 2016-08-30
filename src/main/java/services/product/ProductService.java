package services.product;

import customerproductorder.models.Product;
import dao.ProductDaoInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("productService")
public class ProductService implements ProductServiceInterface {

    @Autowired
    private ProductDaoInterface productDao;

    public void create(Product newProduct) {
        productDao.create(newProduct);
    }

    public Product get(int id) {
        return (Product) productDao.get(id);
    }

    public List<Product> getAll() {
        return productDao.getAll();
    }

    public void delete(int id) {

        productDao.delete(id);
    }

    public void save(Product changedProduct) {
        productDao.save(changedProduct);

    }
}
