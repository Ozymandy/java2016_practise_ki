package dao.H2Factory;

import dao.DaoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionProvider {

    private Connection databaseConnection;
    private final String CONNECTION_STRING = "jdbc:h2:tcp://localhost/~/"
            + "customers";
    private static ConnectionProvider instance;
    private static final Logger LOG = LoggerFactory.getLogger(ConnectionProvider.class);

    private ConnectionProvider() {
    }

    public static ConnectionProvider getConnectionProvider() {
        if (instance == null) {
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
            LOG.error("JDBC Driver not found");
            throw new DaoException(
                    "Not found h2 jdbc driver. Check maven dependencies", ex);

        } catch (SQLException ex) {
            LOG.error("Connection could not be initialized");
            throw new DaoException("Connection could not be initialized", ex);
        }
    }

    public void destroy() throws DaoException {
        try {
            if (this.databaseConnection != null && !this.databaseConnection
                    .isClosed()) {
                this.databaseConnection.close();
            }
        } catch (SQLException ex) {
            LOG.error("Destroy connection error");
            throw new DaoException("Destroy connection error", ex);
        }
    }

    public Connection getConnection() throws DaoException {
        this.init();
        return databaseConnection;
    }
}
