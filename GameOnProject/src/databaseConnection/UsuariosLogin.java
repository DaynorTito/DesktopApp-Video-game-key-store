/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class UsuariosLogin extends ConnectionSQL {

    public boolean registrar_login(usuarios_login usr) {
        ConnectionSQL cn = new ConnectionSQL();
        Connection con = cn.getConnection();

        if (con != null) {
            try {
                String sql = "INSERT INTO Users (Email, Password, UserLevel) VALUES(?,?,?)";
                PreparedStatement statement = con.prepareStatement(sql);

                statement.setString(1, usr.getEmail());
                statement.setString(2, usr.getPassword());
                statement.setString(3, usr.getUserLevel());
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

    public int existeUsuario_login(String usuario_login) {
        ConnectionSQL cn = new ConnectionSQL();
        Connection con = cn.getConnection();
        ResultSet rs = null;

        if (con != null) {
            try {
                String sql = "SELECT count(id) FROM usuarios_register WHERE UserName = ?";
                PreparedStatement statement = con.prepareStatement(sql);

                statement.setString(1, usuario_login);
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
    
    public boolean esEmail(String Password) {
        
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
        
        Matcher matcher = pattern.matcher(Password);
        
        return matcher.find();
    }
}
