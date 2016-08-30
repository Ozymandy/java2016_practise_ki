package dao.H2Factory;

import customerproductorder.models.Product;
import dao.H2Factory.utils.ProductMapper;
import dao.ProductDaoInterface;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("h2ProductDao")
public class H2ProductDao implements ProductDaoInterface {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    H2ProductDao() {
    }

    public void create(Product newProduct) {
        String query = "insert into customerapplication"
                + ".product(productName,productCost) "
                + "values (:productName,:productCost)";
        Map namedParameters = new HashMap();
        namedParameters.put("productCost", newProduct.getProductCost());
        namedParameters.put("productName", newProduct.getName());
        jdbcTemplate.update(query, namedParameters);
    }

    public Product get(int id) {
        String query = "select * from customerapplication"
                + ".product where id=:productId";
        Map namedParameters = new HashMap();
        namedParameters.put("productId", id);
        Product gotProduct = (Product) jdbcTemplate
                .queryForObject(query, namedParameters, new ProductMapper());
        return gotProduct;
    }

    public List<Product> getAll() {
        String query = "select * from customerapplication"
                + ".product";
        List<Product> list = jdbcTemplate.query(query, new ProductMapper());
        return list;
    }

    public void delete(int id) {
        String query = "delete from customerapplication"
                + ".product where id=:productId";
        Map namedParameters = new HashMap();
        namedParameters.put("productId", id);
        jdbcTemplate.update(query, namedParameters);
    }

    public void save(Product changedProduct) {
        String query = "update customerapplication"
                + ".product set productname=:productName,"
                + "productcost=:productCost where id=:productId";
        Map namedParameters = new HashMap();
        namedParameters.put("productName", changedProduct.getName());
        namedParameters.put("productCost", changedProduct.getProductCost());
        namedParameters.put("productId", changedProduct.getProductId());
        jdbcTemplate.update(query, namedParameters);
    }
}
