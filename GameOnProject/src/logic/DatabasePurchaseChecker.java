package logic;
import databaseConnection.ConnectionSQL;
import java.sql.*;
import javax.swing.JOptionPane;

public class DatabasePurchaseChecker {
    public static void main(String[] args) {
        int IDDataUser = 1; // ID de usuario específico
        int IDGames = 2; // ID del juego específico

        ConnectionSQL connectionSQL = new ConnectionSQL();
        Connection connection = connectionSQL.getConnection();

        if (connection != null) {
            DatabasePurchaseChecker(connection, IDDataUser, IDGames);
        } else {
            System.out.println("Failed to establish connection.");
        }
    }

    public static void DatabasePurchaseChecker(Connection connection, int IDDataUser, int IDGames) {
        PreparedStatement statement = null;

        try {
            // Consulta para verificar si el juego ya está en el carrito de compras
            String query = "SELECT * FROM ShoppingCarts WHERE IDGames = ? AND IDDataUser = ? AND Bought = 0";
            statement = connection.prepareStatement(query);
            statement.setInt(1, IDGames);
            statement.setInt(2, IDDataUser);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // El juego ya se encuentra en el carrito de compras               
                JOptionPane.showMessageDialog(null, "El juego ya se añadio al carrito de compras", "Accion No Permitida", JOptionPane.ERROR_MESSAGE);
            } else {
                // Insertar el juego en el carrito de compras
                String insertQuery = "INSERT INTO ShoppingCarts (IDGames, Bought, Quantity, IDDataUser, NumberOfVideoGames) VALUES (?, 0, 1, ?, 1)";
                statement = connection.prepareStatement(insertQuery);
                statement.setInt(1, IDGames);
                statement.setInt(2, IDDataUser);
                statement.executeUpdate();

                // Mostrar mensaje de éxito
                JOptionPane.showMessageDialog(null, "El juego se añadio al carrito de compras! :D", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar los recursos
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

