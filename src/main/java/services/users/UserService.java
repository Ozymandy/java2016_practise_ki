package services.users;

import customerproductorder.models.User;
import dao.DaoException;
import dao.H2Factory.H2DaoFactory;
import dao.UserDaoInterface;
import java.util.List;
import services.Encryption.Encrypting;
import services.Encryption.MD5EncryptService;

public class UserService implements UserServiceInterface {

    private static UserServiceInterface instance;
    private final UserDaoInterface userdao;
    private final Encrypting encryptService;

    private UserService() {
        userdao = H2DaoFactory.getInstance().getUserDao();
        encryptService = new MD5EncryptService();
    }

    public static UserServiceInterface getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    @Override
    public void create(User newUser) throws DaoException {
        userdao.create(newUser);
    }

    @Override
    public User get(int id) throws DaoException {
        return userdao.get(id);
    }

    @Override
    public User get(String username) throws DaoException {
        return userdao.get(username);
    }

    @Override
    public List<User> getAll() throws DaoException {
        return userdao.getAll();
    }

    @Override
    public void delete(int id) throws DaoException {
        userdao.delete(id);
    }

    @Override
    public void save(User changedUser) throws DaoException {
        userdao.save(changedUser);
    }

    @Override
    public boolean isValid(User user) throws DaoException {
        User foundUser = userdao.get(user.getUsername());
        return foundUser.getPassword().equals(encryptService
                .encrypt(user.getPassword()));
    }
}
