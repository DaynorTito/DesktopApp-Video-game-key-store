package logic;

import databaseConnection.ConnectionSQL;
import java.sql.*;

public class ShoppingCartAggregator {
    private Connection con;

    public ShoppingCartAggregator() {
        ConnectionSQL conexion = new ConnectionSQL();
        con = conexion.getConnection();
    }

    public void addToShoppingCart(int gamesID, int userDataID, int purchased) {
        if (con != null) {
            try {
                String sql = "INSERT INTO ShoppingCarts (GamesID, UserDataID, Purchased) VALUES (?, ?, ?)";
                PreparedStatement statement = con.prepareStatement(sql);
                statement.setInt(1, gamesID);
                statement.setInt(2, userDataID);
                statement.setInt(3, purchased);

                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Error de conexión a la base de datos.");
        }
    }

    public void updateNumberOfVideoGames(int gameID, int numberOfVideoGames) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

