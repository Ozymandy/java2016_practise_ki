package dao.H2Factory.converters;

import customerproductorder.models.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductConverter implements Converting<Product> {

    private static ProductConverter instance;

    private ProductConverter() {
    }

    public static ProductConverter getInstance() {
        if (instance == null) {
            instance = new ProductConverter();
        }
        return instance;
    }

    @Override
    public List<Product> convert(ResultSet rs) throws SQLException {
        List<Product> list = new ArrayList<Product>();
        while (rs.next()) {
            int tempId = rs.getInt("id");
            String tempName = rs.getString("productname");
            int tempCost = rs.getInt("productcost");
            list.add(new Product(tempName, tempCost, tempId));
        }
        return list;
    }

}
