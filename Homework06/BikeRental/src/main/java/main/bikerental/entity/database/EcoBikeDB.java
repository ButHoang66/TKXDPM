package main.bikerental.entity.database;

import java.sql.*;

public class EcoBikeDB {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/rentbike";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "admin";

    private static Connection connection;


    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
                System.out.println("Connected");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void close() throws SQLException {
        if (!connection.isClosed())
            connection.close();
    }


}
