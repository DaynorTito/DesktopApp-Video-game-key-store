/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;
import databaseConnection.ConnectionSQL;
import java.sql.*;


public class ResultSetProvider {
    private Connection con;

    public ResultSetProvider() {
        ConnectionSQL conexion = new ConnectionSQL();
        con = conexion.getConnection();
    }

    public ResultSet searchGames(String searchTerm) {
        ResultSet resultSet = null;

        if (con != null) {
            try {
                // Convertir el término de búsqueda a minúsculas
                String searchTermLower = searchTerm.toLowerCase();

                // Consulta SQL para buscar coincidencias en todas las tablas
                String sql = "SELECT DISTINCT g.Name, p.Name AS Platform, g.Price, g.ImagePath FROM Games g " +
                        "JOIN Categories c ON g.CategoryID = c.IDCategorie " +
                        "JOIN Plataforms p ON g.PlataformID = p.IDPlataform " +
                        "JOIN Audience a ON g.AudienceID = a.IDAudience " +
                        "JOIN Developments d ON g.DevelopmentID = d.IDDevelopment " +
                        "WHERE LOWER(g.Name) LIKE ? OR LOWER(c.Name) LIKE ? OR LOWER(p.Name) LIKE ? OR LOWER(a.Field) LIKE ? OR LOWER(d.NameDevelopment) LIKE ?";

                PreparedStatement statement = con.prepareStatement(sql);
                statement.setString(1, "%" + searchTermLower + "%");
                statement.setString(2, "%" + searchTermLower + "%");
                statement.setString(3, "%" + searchTermLower + "%");
                statement.setString(4, "%" + searchTermLower + "%");
                statement.setString(5, "%" + searchTermLower + "%");

                resultSet = statement.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Error de conexión a la base de datos.");
        }

        return resultSet;
    }
}