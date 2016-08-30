package services.users;

import customerproductorder.models.User;
import dao.UserDaoInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.Encryption.Encrypting;

@Service("userService")
public class UserService implements UserServiceInterface {

    @Autowired
    private UserDaoInterface userdao;
    @Autowired
    private Encrypting encryptService;

    @Override
    public void create(User newUser) {
        userdao.create(newUser);
    }

    @Override
    public User get(int id) {
        return userdao.get(id);
    }

    @Override
    public User get(String username) {
        return userdao.get(username);
    }

    @Override
    public List<User> getAll() {
        return userdao.getAll();
    }

    @Override
    public void delete(int id) {
        userdao.delete(id);
    }

    @Override
    public void save(User changedUser) {
        userdao.save(changedUser);
    }

    @Override
    public boolean isValid(User user) {
        User foundUser;
        foundUser = userdao.get(user.getUsername());
        return foundUser.getPassword().equals(encryptService
                .encrypt(user.getPassword()));
    }
}
