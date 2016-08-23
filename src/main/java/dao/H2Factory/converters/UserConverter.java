package dao.H2Factory.converters;

import customerproductorder.models.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserConverter implements Converting<User> {

    private static UserConverter instance;

    private UserConverter() {

    }

    public static UserConverter getInstance() {
        if (instance == null) {
            instance = new UserConverter();
        }
        return instance;
    }

    @Override
    public List<User> convert(ResultSet rs) throws SQLException {
        List list = new ArrayList<User>();
        while (rs.next()) {
            int tempId = rs.getInt("id");
            String username = rs.getString("username");
            String password = rs.getString("password");
            list.add(new User(username, password, tempId));
        }
        return list;
    }

}
