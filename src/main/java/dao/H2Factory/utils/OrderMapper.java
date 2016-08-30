package dao.H2Factory.utils;

import customerproductorder.models.Customer;
import customerproductorder.models.Order;
import dao.CustomerDaoInterface;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

public class OrderMapper implements RowMapper {

    @Autowired
    private CustomerDaoInterface customerDao;

    @Override
    public Order mapRow(ResultSet rs, int RowNum) throws SQLException {
        int tempId = rs.getInt("id");
        Date tempDate = rs.getDate("orderdate");
        //Not sure if it's good idea or not: call Another dao from Mapper
        Customer customer = customerDao.get(rs.getInt("customerid"));
        return new Order(customer, tempId, tempDate);
    }

}
