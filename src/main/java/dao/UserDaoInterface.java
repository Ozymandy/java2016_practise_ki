package dao;

import customerproductorder.models.User;
import java.util.List;

public interface UserDaoInterface {

    public void create(User newUser) throws DaoException;

    public User get(int id) throws DaoException;

    public User get(String username) throws DaoException;

    public List<User> getAll() throws DaoException;

    public void delete(int id) throws DaoException;

    public void save(User changedUser) throws DaoException;
}
