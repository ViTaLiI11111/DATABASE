package database;

import java.sql.*;

public class DBManager implements AutoCloseable {
    private final String url;
    private final String username;
    private final String password;

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public DBManager(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;

        init();
    }

    public void init() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public boolean executeUpdate(String query) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            return true;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }



}