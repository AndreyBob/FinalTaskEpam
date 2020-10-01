package main.java.by.epamtc.bobkov.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

    private static final ConnectionProvider instance = new ConnectionProvider();

    private Connection connection;

    private final String URL = "jdbc:mysql://127.0.0.1/travelagency-db?useSSL=false";
    private final String USER_NAME = "root";
    private final String PASSWORD = "root";

    private ConnectionProvider() {

    }

    public static ConnectionProvider getInstance() {
        if (instance == null) {
            return new ConnectionProvider();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            if (connection == null) {
                connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);

            }
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
