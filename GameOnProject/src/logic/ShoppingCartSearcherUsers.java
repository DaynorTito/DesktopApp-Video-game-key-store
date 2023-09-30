package logic;

import databaseConnection.ConnectionSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartSearcherUsers {
    private Connection con;

    public ShoppingCartSearcherUsers() {
        // Establece la conexión con la base de datos al crear una instancia de la clase
        ConnectionSQL conexion = new ConnectionSQL();
        con = conexion.getConnection();
    }

    
    public void updateNumberOfVideoGames(int userDataID, int gameID, int updatedQuantity) {
        if (con != null) {
            try {
                // Actualizar la cantidad de NumberOfVideoGames sin verificar si el juego ha sido comprado
                String updateQuery = "UPDATE ShoppingCarts SET NumberOfVideoGames = ? WHERE IDDataUser = ? AND IDGames = ?";
                try (PreparedStatement updateStatement = con.prepareStatement(updateQuery)) {
                    updateStatement.setInt(1, updatedQuantity);
                    updateStatement.setInt(2, userDataID);
                    updateStatement.setInt(3, gameID);
                    updateStatement.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Error de conexión a la base de datos.");
        }
    }


    public List<Integer> getUnpurchasedGameIDs(int userDataID) {
        List<Integer> gameIDs = new ArrayList<>();

        if (con != null) {
            try {
                // Consulta SQL para obtener los IDGames de la tabla ShoppingCarts que no han sido comprados
                String sql = "SELECT IDGames FROM ShoppingCarts WHERE IDDataUser = ? AND Bought = 0";
                try (PreparedStatement statement = con.prepareStatement(sql)) {
                    statement.setInt(1, userDataID);

                    // Ejecuta la consulta y obtiene el resultado en forma de ResultSet
                    try (ResultSet resultSet = statement.executeQuery()) {
                        // Recorre el ResultSet y agrega los IDGames a la lista
                        while (resultSet.next()) {
                            int gameID = resultSet.getInt("IDGames");
                            gameIDs.add(gameID);
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Error de conexión a la base de datos.");
        }

        return gameIDs;
    }
    public void calculateTotalCost(int userDataID) {
        if (con != null) {
            try {
                // Consulta SQL para calcular y actualizar el costo total para cada juego en el carrito
                String updateQuery = "UPDATE ShoppingCarts SET TotalCost = " +
                        "(SELECT Games.Price FROM Games WHERE Games.IDGame = ShoppingCarts.IDGames) * ShoppingCarts.NumberOfVideoGames " +
                        "WHERE ShoppingCarts.IDDataUser = ? AND ShoppingCarts.Bought = 0";

                try (PreparedStatement updateStatement = con.prepareStatement(updateQuery)) {
                    updateStatement.setInt(1, userDataID);
                    updateStatement.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Error de conexión a la base de datos.");
        }
    }
    public double getTotalCost(int userDataID) {
        double totalCost = 0.0;

        if (con != null) {
            try {
                // Consulta SQL para obtener el costo total del carrito de compras
                String selectQuery = "SELECT SUM(ShoppingCarts.TotalCost) AS TotalCost FROM ShoppingCarts " +
                                     "WHERE ShoppingCarts.IDDataUser = ? AND ShoppingCarts.Bought = 0";
                try (PreparedStatement selectStatement = con.prepareStatement(selectQuery)) {
                    selectStatement.setInt(1, userDataID);

                    try (ResultSet resultSet = selectStatement.executeQuery()) {
                        if (resultSet.next()) {
                            totalCost = resultSet.getDouble("TotalCost");
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Error de conexión a la base de datos.");
        }

        return totalCost;
    }
    public int getNumberOfVideoGames(int userDataID) {
        int numberOfVideoGames = 0;

        if (con != null) {
            try {
                // Consulta SQL para obtener la cantidad de videojuegos en el carrito de compras
                String selectQuery = "SELECT SUM(NumberOfVideoGames) AS Total FROM ShoppingCarts " +
                                     "WHERE IDDataUser = ? AND Bought = 0";
                try (PreparedStatement selectStatement = con.prepareStatement(selectQuery)) {
                    selectStatement.setInt(1, userDataID);

                    try (ResultSet resultSet = selectStatement.executeQuery()) {
                        if (resultSet.next()) {
                            numberOfVideoGames = resultSet.getInt("Total");
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Error de conexión a la base de datos.");
        }

        return numberOfVideoGames;
    }
    public void updateBoughtStatus(int userDataID) {
        if (con != null) {
            try {
                // Consulta SQL para actualizar el valor de Bought a 1
                String updateQuery = "UPDATE ShoppingCarts SET Bought = 1 WHERE IDDataUser = ?";
                try (PreparedStatement updateStatement = con.prepareStatement(updateQuery)) {
                    updateStatement.setInt(1, userDataID);
                    updateStatement.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Error de conexión a la base de datos.");
        }
    }


}
