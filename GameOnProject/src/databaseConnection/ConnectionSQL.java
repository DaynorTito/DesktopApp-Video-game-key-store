package databaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSQL {
    
    Connection connection;

    public Connection getConnection() {
    try {
        String url = "jdbc:mysql://localhost:3306/GameStore?serverTimezone=UTC&characterEncoding=UTF-8";
        connection = (Connection) DriverManager.getConnection(url, "root", "123456");
        if (connection != null) {
            System.out.println("Successful connection");
        }
    } catch (SQLException e) {
        System.out.println("Error: " + e.getMessage());
    }
        return connection;
    }

}
