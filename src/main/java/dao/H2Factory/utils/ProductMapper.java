package dao.H2Factory.utils;

import customerproductorder.models.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component("productMapper")
public class ProductMapper implements RowMapper {

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        int tempId = rs.getInt("id");
        String tempName = rs.getString("productname");
        int tempCost = rs.getInt("productcost");
        return new Product(tempName, tempCost, tempId);
    }

}
