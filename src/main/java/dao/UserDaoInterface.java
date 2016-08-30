package dao;

import customerproductorder.models.User;
import java.util.List;

public interface UserDaoInterface {

    public void create(User newUser);

    public User get(int id);

    public User get(String username);

    public List<User> getAll();

    public void delete(int id);

    public void save(User changedUser);
}
