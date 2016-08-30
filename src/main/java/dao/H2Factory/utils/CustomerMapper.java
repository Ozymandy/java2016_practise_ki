package dao.H2Factory.utils;

import customerproductorder.models.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class CustomerMapper implements RowMapper {

    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        int tempId = rs.getInt("id");
        String tempLastName = rs.getString("lastname");
        String tempFirstName = rs.getString("firstname");
        String tempAddress = rs.getString("address");
        return new Customer(tempFirstName,tempLastName,tempAddress,tempId);
    }

}
