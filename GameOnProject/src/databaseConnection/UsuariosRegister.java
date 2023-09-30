/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class UsuariosRegister extends ConnectionSQL {

    public boolean registrar(usuarios_register usr) {
        ConnectionSQL cn = new ConnectionSQL();
        Connection con = cn.getConnection();
        int idU = 0;

        if (con != null) {
            try {
                //PreparedStatement statement1 = con.prepareStatement("SELECT UserID FROM UserData ORDER BY columna DESC LIMIT 1;");
                Statement statement1 = con.createStatement();
                ResultSet resultSet = statement1.executeQuery("SELECT UserID FROM UserData ORDER BY UserID DESC LIMIT 1");
                while(resultSet.next()){
                    int id = resultSet.getInt("UserID");
                    idU = id;
                    idU++;
                }
                String sql = "INSERT INTO UserData (UserName, FirstName, SecondName, FirstSurname, SecondLastName, DateOfBirth, NIT, UserID) VALUES(?,?,?,?,?,?,?,?)";
                PreparedStatement statement = con.prepareStatement(sql);

                statement.setString(1, usr.getUserName());
                statement.setString(2, usr.getFirstName());
                statement.setString(3, usr.getSecondName());
                statement.setString(4, usr.getFirstSurname());
                statement.setString(5, usr.getSecondLastName());
                statement.setString(6, usr.getDateOfBirth());
                statement.setString(7, usr.getNIT());
                statement.setInt(8, idU);
                statement.execute();
                return true;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Error de conexión a la base de datos.");
        }

        return false;
    }

    public int existeUsuario(String usuario_register) {
        ConnectionSQL cn = new ConnectionSQL();
        Connection con = cn.getConnection();
        ResultSet rs = null;

        if (con != null) {
            try {
                String sql = "SELECT count(IDUserDate) FROM UserData WHERE UserName = ?";
                PreparedStatement statement = con.prepareStatement(sql);

                statement.setString(1, usuario_register);
                rs = statement.executeQuery();

                if (rs.next()) {
                    return rs.getInt(1);
                }

                return 1;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Error de conexión a la base de datos.");
        }

        return 1;
    }
    
    public boolean sonSoloNumeros(String NIT) {
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(NIT);
    return matcher.matches();
}

    
    
}
