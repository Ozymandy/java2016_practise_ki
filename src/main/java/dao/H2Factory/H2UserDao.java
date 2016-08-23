package dao.H2Factory;

import customerproductorder.models.User;
import dao.DaoException;
import dao.H2Factory.converters.UserConverter;
import dao.UserDaoInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class H2UserDao implements UserDaoInterface {

    private final ConnectionProvider connectionProvider;
    private static final Logger LOG = LoggerFactory.getLogger(H2UserDao.class);
    private final UserConverter converter;

    protected H2UserDao(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
        converter = UserConverter.getInstance();
    }

    public void create(User newUser) throws DaoException {
        try (Connection connection = connectionProvider.getConnection()) {
            PreparedStatement st = connection.prepareStatement("insert into "
                    + "customerapplication.account(username,password) "
                    + "values(?,?)");
            st.setString(1, newUser.getUsername());
            st.setString(2, newUser.getPassword());
            st.executeUpdate();
            connectionProvider.destroy();
        } catch (SQLException ex) {
            LOG.error(ex.getSQLState());
            throw new DaoException("Inserting data error", ex);
        }
    }

    public User get(int id) throws DaoException {
        User gotUser = null;
        try (Connection connection = connectionProvider.getConnection()) {
            PreparedStatement st = connection.prepareStatement("select * from "
                    + "customerapplication.account where id=?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            gotUser = converter.convert(rs).get(0);
            connectionProvider.destroy();
        } catch (SQLException ex) {
            LOG.error(ex.getSQLState());
            throw new DaoException("Select data error", ex);
        }
        return gotUser;
    }

    public List<User> getAll() throws DaoException {
        List<User> list = new ArrayList<User>();
        try (Connection connection = connectionProvider.getConnection()) {
            PreparedStatement st = connection.prepareStatement("select * from "
                    + "customerapplication.account");
            ResultSet rs = st.executeQuery();
            list = converter.convert(rs);
            connectionProvider.destroy();
        } catch (SQLException ex) {
            LOG.error(ex.getSQLState());
            throw new DaoException("Select data error", ex);
        }
        return list;
    }

    public void delete(int id) throws DaoException {
        try (Connection connection = connectionProvider.getConnection()) {
            PreparedStatement st = connection.prepareStatement("delete from "
                    + "customerapplication.account where id = ?");
            st.setInt(1, id);
            st.executeUpdate();
            connectionProvider.destroy();
        } catch (SQLException ex) {
            LOG.error(ex.getSQLState());
            throw new DaoException("Delete data error", ex);
        }
    }

    public void save(User changedUser) throws DaoException {
        try (Connection connection = connectionProvider.getConnection()) {
            PreparedStatement st = connection.prepareStatement("update "
                    + "customerapplication.account set username=?,"
                    + "password=? where id=?");
            st.setString(1, changedUser.getUsername());
            st.setString(2, changedUser.getPassword());
            st.setInt(3, changedUser.getId());
            st.executeUpdate();
            connectionProvider.destroy();
        } catch (SQLException ex) {
            LOG.error(ex.getSQLState());
            throw new DaoException("Saving data error", ex);
        }
    }

    @Override
    public User get(String username) throws DaoException {
        User gotUser = null;
        try (Connection connection = connectionProvider.getConnection()) {
            PreparedStatement st = connection.prepareStatement("select * from "
                    + "customerapplication.account where username=?");
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            gotUser = converter.convert(rs).get(0);
            connectionProvider.destroy();
        } catch (SQLException ex) {
            LOG.error(ex.getSQLState());
            throw new DaoException("Select data error", ex);
        }
        return gotUser;
    }
}
