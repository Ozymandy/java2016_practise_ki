/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.users;

import customerproductorder.models.User;
import dao.DaoException;
import java.util.List;

/**
 *
 * @author AS
 */
public interface UserServiceInterface {

    public void create(User newUser) throws DaoException;

    public User get(int id) throws DaoException;

    public User get(String username) throws DaoException;

    public List<User> getAll() throws DaoException;

    public void delete(int id) throws DaoException;

    public void save(User changedUser) throws DaoException;

    public boolean isValid(User user) throws DaoException;
}
