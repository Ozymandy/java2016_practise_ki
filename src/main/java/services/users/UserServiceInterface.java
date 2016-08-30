/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.users;

import customerproductorder.models.User;
import dao.DaoException;
import java.util.List;
import services.ServiceException;

/**
 *
 * @author AS
 */
public interface UserServiceInterface {

    public void create(User newUser);

    public User get(int id);

    public User get(String username);

    public List<User> getAll();

    public void delete(int id);

    public void save(User changedUser);

    public boolean isValid(User user);
}
