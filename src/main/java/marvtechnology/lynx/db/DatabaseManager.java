package marvtechnology.lynx.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private Connection connection;

    public void connect(String url, String user, String pass) throws SQLException {
        connection = DriverManager.getConnection(url, user, pass);
    }

    public Connection getConnection() {
        return connection;
    }
}
