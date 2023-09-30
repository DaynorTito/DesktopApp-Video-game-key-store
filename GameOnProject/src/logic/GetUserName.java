/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import databaseConnection.ConnectionSQL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author university
 */
public class GetUserName {
    private Connection connection;
    
    public String GetUserName(int userId){
    String nameUser = null;
    ConnectionSQL conn = new ConnectionSQL();
    connection = conn.getConnection();

    try {
        
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT UserName FROM UserData WHERE UserID = " + userId);
        while(resultSet.next()){
            String name = resultSet.getString("UserName");
            nameUser = name;
            System.out.println(nameUser);
        
        }

        resultSet.close();
        statement.close();
    } catch (SQLException e) {
        e.printStackTrace();
        }
    return nameUser;
    }
}
