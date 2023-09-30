package logic;

import databaseConnection.ConnectionSQL;
import java.sql.Timestamp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PurchaseHistoryUpdater {
    private Connection con;

    public PurchaseHistoryUpdater() {
        // Establece la conexión con la base de datos al crear una instancia de la clase
        ConnectionSQL conexion = new ConnectionSQL();
        con = conexion.getConnection();
    }

    public void updatePurchaseHistory(int userDataID) {
        if (con != null) {
            try {
                // Obtener los CartID y la cantidad de videojuegos de la tabla ShoppingCarts que cumplan con la condición (Bought = 0)
                String selectQuery = "SELECT CartID, NumberOfVideoGames FROM ShoppingCarts WHERE IDDataUser = ? AND Bought = 0";
                try (PreparedStatement selectStatement = con.prepareStatement(selectQuery)) {
                    selectStatement.setInt(1, userDataID);

                    try (ResultSet resultSet = selectStatement.executeQuery()) {
                        while (resultSet.next()) {
                            int cartID = resultSet.getInt("CartID");
                            int numberOfVideoGames = resultSet.getInt("NumberOfVideoGames");

                            // Insertar el CartID en la tabla PurchaseHistory
                            insertCartIDIntoPurchaseHistory(cartID, numberOfVideoGames);
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Error de conexión a la base de datos.");
        }
    }
    
    public void updatePurchaseHistoryFaild(int userDataID) {
        if (con != null) {
            try {
                // Obtener los CartID y la cantidad de videojuegos de la tabla ShoppingCarts que cumplan con la condición (Bought = 0)
                String selectQuery = "SELECT CartID, NumberOfVideoGames FROM ShoppingCarts WHERE IDDataUser = ? AND Bought = 0";
                try (PreparedStatement selectStatement = con.prepareStatement(selectQuery)) {
                    selectStatement.setInt(1, userDataID);

                    try (ResultSet resultSet = selectStatement.executeQuery()) {
                        while (resultSet.next()) {
                            int cartID = resultSet.getInt("CartID");
                            int numberOfVideoGames = resultSet.getInt("NumberOfVideoGames");

                            // Insertar el CartID en la tabla PurchaseHistory
                            insertInsufficientFundsIntoPurchaseHistory(cartID, numberOfVideoGames);
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Error de conexión a la base de datos.");
        }
    }
    

    private void insertCartIDIntoPurchaseHistory(int cartID, int numberOfVideoGames) {
        if (con != null) {
            try {
                // Obtener el IDKey de los VideoGameKeys disponibles para el juego en el carrito (Búsqueda por IDGame)
                String selectKeyQuery = "SELECT VideoGameKeysID FROM VideoGameKeys WHERE IDGame = (SELECT IDGames FROM ShoppingCarts WHERE CartID = ?) AND Activate = 1 LIMIT ?";
                try (PreparedStatement selectKeyStatement = con.prepareStatement(selectKeyQuery)) {
                    selectKeyStatement.setInt(1, cartID);
                    selectKeyStatement.setInt(2, numberOfVideoGames);

                    try (ResultSet keyResultSet = selectKeyStatement.executeQuery()) {
                        int keyCount = 0;
                        while (keyResultSet.next()) {
                            int keyID = keyResultSet.getInt("VideoGameKeysID");
                            keyCount++;

                            // Insertar el CartID, el IDKey y la fecha/hora actual en la tabla PurchaseHistory con IDStatus = 1
                            String insertQuery = "INSERT INTO PurchaseHistory (IDCart, IDKey, IDStatus, DateAndTime) VALUES (?, ?, 1, ?)";
                            try (PreparedStatement insertStatement = con.prepareStatement(insertQuery)) {
                                insertStatement.setInt(1, cartID);
                                insertStatement.setInt(2, keyID);

                                // Obtener la fecha y hora actual
                                Timestamp currentDateTime = new Timestamp(System.currentTimeMillis());
                                insertStatement.setTimestamp(3, currentDateTime);

                                insertStatement.executeUpdate();
                            }
                        }

                        if (keyCount < numberOfVideoGames) {
                            // No se encontraron suficientes VideoGameKeys disponibles para el juego en el carrito
                            System.out.println("No se encontraron suficientes VideoGameKeys disponibles para el juego en el carrito.");
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Error de conexión a la base de datos.");
        }
    }

    public void insertInsufficientFundsIntoPurchaseHistory(int cartID, int numberOfVideoGames) {
        if (con != null) {
            try {
                // Obtener el IDKey de los VideoGameKeys disponibles para el juego en el carrito (Búsqueda por IDGame)
                String selectKeyQuery = "SELECT VideoGameKeysID FROM VideoGameKeys WHERE IDGame = (SELECT IDGames FROM ShoppingCarts WHERE CartID = ?) AND Activate = 1 LIMIT ?";
                try (PreparedStatement selectKeyStatement = con.prepareStatement(selectKeyQuery)) {
                    selectKeyStatement.setInt(1, cartID);
                    selectKeyStatement.setInt(2, numberOfVideoGames);

                    try (ResultSet keyResultSet = selectKeyStatement.executeQuery()) {
                        int keyCount = 0;
                        while (keyResultSet.next()) {
                            int keyID = keyResultSet.getInt("VideoGameKeysID");
                            keyCount++;

                            // Insertar el CartID, el IDKey y la fecha/hora actual en la tabla PurchaseHistory con IDStatus = 3
                            String insertQuery = "INSERT INTO PurchaseHistory (IDCart, IDKey, IDStatus, DateAndTime) VALUES (?, ?, 3, ?)";
                            try (PreparedStatement insertStatement = con.prepareStatement(insertQuery)) {
                                insertStatement.setInt(1, cartID);
                                insertStatement.setInt(2, keyID);

                                // Obtener la fecha y hora actual
                                Timestamp currentDateTime = new Timestamp(System.currentTimeMillis());
                                insertStatement.setTimestamp(3, currentDateTime);

                                insertStatement.executeUpdate();
                            }
                        }

                        if (keyCount < numberOfVideoGames) {
                            // No se encontraron suficientes VideoGameKeys disponibles para el juego en el carrito
                            System.out.println("No se encontraron suficientes VideoGameKeys disponibles para el juego en el carrito.");
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Error de conexión a la base de datos.");
        }
    }
}
