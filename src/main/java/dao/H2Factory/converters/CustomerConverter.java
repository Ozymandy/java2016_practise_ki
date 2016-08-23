package dao.H2Factory.converters;

import customerproductorder.models.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerConverter implements Converting<Customer> {

    private static Converting<Customer> instance;

    private CustomerConverter() {
    }

    public static Converting<Customer> getInstance() {
        if (instance == null) {
            instance = new CustomerConverter();
        }
        return instance;
    }

    @Override
    public List<Customer> convert(ResultSet rs) throws SQLException {
        List list = new ArrayList<Customer>();
        while (rs.next()) {
            int tempId = rs.getInt("id");
            String tempLastName = rs.getString("lastname");
            String tempFirstName = rs.getString("firstname");
            String tempAddress = rs.getString("address");
            list.add(new Customer(tempFirstName, tempLastName, tempAddress,
                    tempId));
        }
        return list;
    }

}
