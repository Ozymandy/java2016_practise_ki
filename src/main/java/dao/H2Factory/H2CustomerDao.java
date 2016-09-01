package dao.H2Factory;

import customerproductorder.models.Customer;
import dao.CustomerDaoInterface;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class H2CustomerDao implements CustomerDaoInterface {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Resource(name="customerMapper")
    private RowMapper mapper;

    H2CustomerDao() {
    }

    public void create(Customer newCustomer) {
        String query = "insert into customerapplication"
                + ".customer(firstname,lastname,"
                + "address) values(:firstname,:lastname,:address)";
        Map namedParameters = new HashMap();
        namedParameters.put("firstname", newCustomer.getFirstName());
        namedParameters.put("lastname", newCustomer.getName());
        namedParameters.put("address", newCustomer.getAddress());
        jdbcTemplate.update(query, namedParameters);
    }

    public Customer get(int id) {
        String query = "select * from customerapplication"
                + ".customer where id=:customerId";
        Map namedParameters = new HashMap();
        namedParameters.put("customerId", id);
        Customer gotCustomer = (Customer) jdbcTemplate
                .queryForObject(query, namedParameters, mapper);
        return gotCustomer;
    }

    public List<Customer> getAll() {
        String query = "select * from customerapplication"
                + ".customer";
        List<Customer> list = jdbcTemplate.query(query, mapper);
        return list;
    }

    public void delete(int id) {
        String query = "delete from customerapplication"
                + ".customer where id=:customerId";
        Map namedParameters = new HashMap();
        namedParameters.put("customerId", id);
        jdbcTemplate.update(query, namedParameters);
    }

    public void save(Customer changedCustomer) {
        String query = "update customerapplication"
                + ".customer set firstname=:firstname,"
                + "lastname=:lastname,address=:address where id=:customerId";
        Map namedParameters = new HashMap();
        namedParameters.put("firstname", changedCustomer.getFirstName());
        namedParameters.put("lastname", changedCustomer.getName());
        namedParameters.put("address", changedCustomer.getAddress());
        namedParameters.put("customerId", changedCustomer.getCardNumber());
        jdbcTemplate.update(query, namedParameters);
    }
}
