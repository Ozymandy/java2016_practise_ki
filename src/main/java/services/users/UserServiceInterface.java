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

    public void create(User newUser) throws ServiceException;

    public User get(int id) throws ServiceException;

    public User get(String username) throws ServiceException;

    public List<User> getAll() throws ServiceException;

    public void delete(int id) throws ServiceException;

    public void save(User changedUser) throws ServiceException;

    public boolean isValid(User user) throws ServiceException;
}
