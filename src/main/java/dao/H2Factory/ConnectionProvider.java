package dao.H2Factory;

import dao.DaoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

    private Connection databaseConnection;
    private final String CONNECTION_STRING = "jdbc:h2:tcp://localhost/~/"
            + "customers";
    private static ConnectionProvider instance;

    private ConnectionProvider() {
    }

    public static ConnectionProvider getConnectionProvider() {
        if(instance==null){
            instance = new ConnectionProvider();
        }
        return instance;
    }

    public void init() throws DaoException {
        try {
            Class.forName("org.h2.Driver");
            if (this.databaseConnection == null || this.databaseConnection
                    .isClosed()) {
                this.databaseConnection = DriverManager
                        .getConnection(CONNECTION_STRING, "root", "root");
            }
        } catch (ClassNotFoundException ex) {
            throw new DaoException(
                    "Not found h2 jdbc driver. Check maven dependencies",ex);
        } catch (SQLException ex) {
            throw new DaoException("Connection can not initialize",ex);
        }
    }

    public void destroy() throws DaoException {
        try {
            if (this.databaseConnection != null && !this.databaseConnection
                    .isClosed()) {
                this.databaseConnection.close();
            }
        } catch (SQLException ex) {
            throw new DaoException("Connection error",ex);
        }
    }

    public Connection getConnection() throws DaoException{
        this.init();
        return databaseConnection;
    }
}
