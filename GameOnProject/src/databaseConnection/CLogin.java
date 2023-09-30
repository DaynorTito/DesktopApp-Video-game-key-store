/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package databaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import view.Pagination;

public class CLogin {
    public static int userId; // Variable para almacenar el ID del usuario
    public static String levelUser="";
    public static boolean verificarLogin(String email, String password) {
        ConnectionSQL cn = new ConnectionSQL();
        Connection con = cn.getConnection();
        
        if (con != null) {
            try {
                String sql = "SELECT * FROM Users WHERE Email = ? AND Password = ?";
                PreparedStatement statement = con.prepareStatement(sql);
                statement.setString(1, email);
                statement.setString(2, password);
                
                ResultSet resultSet = statement.executeQuery();
                
                boolean loginExitoso = resultSet.next();
                
                if (loginExitoso) {
                    userId = resultSet.getInt("IDUser"); // Guardar el ID del usuario en la variable
                    levelUser = resultSet.getString("UserLevel");
                }
                
                resultSet.close();
                statement.close();
                
                return loginExitoso;
                
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Error de conexión a la base de datos.");
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        ConnectionSQL cn = new ConnectionSQL();
        Connection con = cn.getConnection();
        
        if (con != null) {
            try {
                String sql = "SELECT * FROM Users";
                PreparedStatement statement = con.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();
                
                while (resultSet.next()) {
                    String email = resultSet.getString("Email");
                    String password = resultSet.getString("Password");
                    
                    boolean loginExitoso = verificarLogin(email, password);       
                    
                }
                
                resultSet.close();
                statement.close();
                        
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Error de conexión a la base de datos.");
        }
    }
}
