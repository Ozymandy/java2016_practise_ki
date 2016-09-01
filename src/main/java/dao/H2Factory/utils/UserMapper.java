package dao.H2Factory.utils;

import customerproductorder.models.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component("userMapper")
public class UserMapper implements RowMapper {

    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {
        int tempId = rs.getInt("id");
        String username = rs.getString("username");
        String password = rs.getString("password");
        return new User(username, password, tempId);
    }

}
