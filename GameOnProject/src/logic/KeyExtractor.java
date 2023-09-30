package logic;

import databaseConnection.ConnectionSQL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KeyExtractor {
    private Connection con;

    public KeyExtractor() {
        ConnectionSQL conexion = new ConnectionSQL();
        con = conexion.getConnection();
    }
    
    // Método encargado de devolver una lista de llaves de un IDGame
    public  String[] retrieveGameKeys(int gameID) {
        List<String> gameKeys = new ArrayList<>();

        if (con != null) {
            try {
                String sql = "SELECT GameKey FROM VideoGameKeys WHERE IDGame = ?";
                PreparedStatement statement = con.prepareStatement(sql);
                statement.setInt(1, gameID);

                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String gameKey = resultSet.getString("GameKey");
                    gameKeys.add(gameKey);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Error de conexión a la base de datos.");
        }

        return gameKeys.toArray(new String[0]);
    }
    

    public String[] getGameKeys(int gameID) {
        return retrieveGameKeys(gameID);
    }
    
    // Método encargado de verificar si una llave está disponible en la base de datos
    public boolean isKeyAvailableInDatabase(String key) {
        boolean isAvailable = false;

        if (con != null) {
            try {
                String sql = "SELECT COUNT(*) AS Count FROM VideoGameKeys WHERE GameKey = ? AND Activate = 1";
                PreparedStatement statement = con.prepareStatement(sql);
                statement.setString(1, key);

                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    int count = resultSet.getInt("Count");
                    isAvailable = (count > 0);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Error de conexión a la base de datos.");
        }

        return isAvailable;
    } 
}
