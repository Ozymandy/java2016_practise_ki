package dao.H2Factory;

import customerproductorder.models.User;
import dao.H2Factory.utils.UserMapper;
import dao.UserDaoInterface;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
class H2UserDao implements UserDaoInterface {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Resource(name = "userMapper")
    private RowMapper mapper;

    H2UserDao() {
    }

    public void create(User newUser) {
        String query = "insert into "
                + "customerapplication.account(username,password) "
                + "values(:username,:password)";
        Map params = new HashMap();
        params.put("username", newUser.getUsername());
        params.put("password", newUser.getPassword());
        jdbcTemplate.update(query, params);
    }

    public User get(int id) {
        String query = "select * from "
                + "customerapplication.account where id=:accountid";
        Map params = new HashMap();
        params.put("accountid", id);
        return (User) jdbcTemplate.queryForObject(query, params, mapper);
    }

    public List<User> getAll() {
        String query = "select * from customerapplication.account";
        return jdbcTemplate.query(query, mapper);
    }

    public void delete(int id) {
        String query = "delete from "
                + "customerapplication.account where id = :accountid";
        Map params = new HashMap();
        params.put("accountid", id);
        jdbcTemplate.update(query, params);
    }

    public void save(User changedUser) {
        String query = "update "
                + "customerapplication.account set username=:username,"
                + "password=:pass where id=:accountid";
        Map params = new HashMap();
        params.put("username", changedUser.getUsername());
        params.put("pass", changedUser.getPassword());
        params.put("accountid", changedUser.getId());
        jdbcTemplate.update(query, params);
    }

    @Override
    public User get(String username) {
        String query = "select * from "
                + "customerapplication.account where username=:username";
        Map params = new HashMap();
        params.put("username", username);
        return (User) jdbcTemplate.queryForObject(query, params, mapper);
    }
}
