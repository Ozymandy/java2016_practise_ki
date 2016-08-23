package services.users;

import customerproductorder.models.User;
import dao.DaoException;
import dao.H2Factory.H2DaoFactory;
import dao.UserDaoInterface;
import java.util.List;
import services.Encryption.Encrypting;
import services.Encryption.MD5EncryptService;
import services.ServiceException;

public class UserService implements UserServiceInterface {

    private static UserServiceInterface instance;
    private final UserDaoInterface userdao;
    private final Encrypting encryptService;

    private UserService() {
        userdao = H2DaoFactory.getInstance().getUserDao();
        encryptService = MD5EncryptService.getInstance();
    }

    public static UserServiceInterface getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    @Override
    public void create(User newUser) throws ServiceException {
        try {
            userdao.create(newUser);
        } catch (DaoException ex) {
            throw new ServiceException("Cration error", ex);
        }
    }

    @Override
    public User get(int id) throws ServiceException {
        try {
            return userdao.get(id);
        } catch (DaoException ex) {
            throw new ServiceException("Getting error", ex);
        }
    }

    @Override
    public User get(String username) throws ServiceException {
        try {
            return userdao.get(username);
        } catch (DaoException ex) {
            throw new ServiceException("Getting error", ex);
        }
    }

    @Override
    public List<User> getAll() throws ServiceException {
        try {
            return userdao.getAll();
        } catch (DaoException ex) {
            throw new ServiceException("Getting error", ex);
        }
    }

    @Override
    public void delete(int id) throws ServiceException {
        try {
            userdao.delete(id);
        } catch (DaoException ex) {
            throw new ServiceException("Deleting error", ex);
        }
    }

    @Override
    public void save(User changedUser) throws ServiceException {
        try {
            userdao.save(changedUser);
        } catch (DaoException ex) {
            throw new ServiceException("Saving error", ex);
        }
    }

    @Override
    public boolean isValid(User user) throws ServiceException {
        try {
            User foundUser;
            foundUser = userdao.get(user.getUsername());
            return foundUser.getPassword().equals(encryptService
                    .encrypt(user.getPassword()));
        } catch (DaoException ex) {
            throw new ServiceException("Validation error", ex);
        }
    }
}
