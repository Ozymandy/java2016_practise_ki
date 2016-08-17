package dao;

import java.util.List;

public interface InterfaceDao<T> {

    public void create(T t) throws DaoException;

    public T get(int id) throws DaoException;

    public List<T> getAll() throws DaoException;

    public void delete(int id) throws DaoException;

    public void save(T t) throws DaoException;
}
