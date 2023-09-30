package logic;

import databaseConnection.ConnectionSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartDatas {
    private Connection con;

    public ShoppingCartDatas() {
        // Establece la conexión con la base de datos al crear una instancia de la clase
        ConnectionSQL conexion = new ConnectionSQL();
        con = conexion.getConnection();
    }

    public List<Integer> getUnpurchasedGameIDs(int userDataID) {
        List<Integer> gameIDs = new ArrayList<>();

        if (con != null) {
            try {
                // Consulta SQL para obtener los IDGames de la tabla ShoppingCarts que no han sido comprados
                String sql = "SELECT IDGames FROM ShoppingCarts WHERE IDDataUser = ? AND Bought = 0";
                PreparedStatement statement = con.prepareStatement(sql);
                statement.setInt(1, userDataID);

                // Ejecuta la consulta y obtiene el resultado en forma de ResultSet
                ResultSet resultSet = statement.executeQuery();

                // Recorre el ResultSet y agrega los IDGames a la lista
                while (resultSet.next()) {
                    int gameID = resultSet.getInt("IDGames");
                    gameIDs.add(gameID);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Error de conexión a la base de datos.");
        }

        return gameIDs;
    }
    
    public void removeGameFromShoppingCart(int userDataID, int gameID) {
        if (con != null) {
            try {
                // Verifica si el juego ya ha sido comprado
                String checkQuery = "SELECT Bought FROM ShoppingCarts WHERE IDDataUser = ? AND IDGames = ?";
                PreparedStatement checkStatement = con.prepareStatement(checkQuery);
                checkStatement.setInt(1, userDataID);
                checkStatement.setInt(2, gameID);
                ResultSet resultSet = checkStatement.executeQuery();

                if (resultSet.next()) {
                    boolean isBought = resultSet.getBoolean("Bought");

                    if (!isBought) {
                        System.out.println("No se puede eliminar un juego que ya ha sido comprado.");
                        return;
                    } else {
                        // Elimina el juego de la base de datos
                        String deleteQuery = "DELETE FROM ShoppingCarts WHERE IDDataUser = ? AND IDGames = ? AND Bought = 0";
                        PreparedStatement deleteStatement = con.prepareStatement(deleteQuery);
                        deleteStatement.setInt(1, userDataID);
                        deleteStatement.setInt(2, gameID);
                        deleteStatement.executeUpdate();
                        System.out.println("Juego eliminado del carrito de compras en la base de datos.");

                        // Actualiza la lista local de juegos en el carrito de compras
                        // ...
                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Error de conexión a la base de datos.");
        }
    }

    
    
    public void updateNumberOfVideoGames(int gameID, int numberOfVideoGames) {
        if (con != null) {
            try {
                // Consulta SQL para actualizar el número de juegos en la tabla ShoppingCarts
                String sql = "UPDATE ShoppingCarts SET NumberOfVideoGames = ? WHERE IDGames = ?";
                PreparedStatement statement = con.prepareStatement(sql);
                statement.setInt(1, numberOfVideoGames);
                statement.setInt(2, gameID);

                // Ejecuta la consulta de actualización
                int rowsAffected = statement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Número de juegos actualizado exitosamente en la base de datos.");
                } else {
                    System.out.println("Error al actualizar el número de juegos en la base de datos.");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Error de conexión a la base de datos.");
        }
    }

    public String[][][] generatePaginationArray(List<Integer> gameIDs) {
        if (gameIDs == null) {
            System.out.println("La lista de IDs de juegos es nula.");
            return new String[0][0][0]; // Devolver una matriz vacía o realizar la acción correspondiente
        }
        int numPages = (int) Math.ceil((double) gameIDs.size() / 5); // Calcula el número de páginas

        String[][][] paginationArray = new String[numPages][5][5];

        if (con != null) {
            try {
                // Consulta SQL para obtener los datos de los juegos de la tabla Games y ShoppingCarts
                String sql = "SELECT g.Name, g.Price, g.ImagePath, sc.NumberOfVideoGames, sc.TotalCost " +
                             "FROM Games g " +
                             "INNER JOIN ShoppingCarts sc ON g.IDGame = sc.IDGames " +
                             "WHERE g.IDGame = ?";
                PreparedStatement statement = con.prepareStatement(sql);

                // Recorre los IDGames y obtiene los datos correspondientes de las tablas Games y ShoppingCarts
                int pageIndex = 0;
                int gameIndex = 0;
                for (int gameID : gameIDs) {
                    statement.setInt(1, gameID);
                    ResultSet resultSet = statement.executeQuery();

                    if (resultSet.next()) {
                        String name = resultSet.getString("Name");
                        String price = resultSet.getString("Price");
                        String imagePath = resultSet.getString("ImagePath");
                        int numberOfVideoGames = resultSet.getInt("NumberOfVideoGames");
                        float totalCost = resultSet.getFloat("TotalCost");

                        paginationArray[pageIndex][gameIndex][0] = name;
                        paginationArray[pageIndex][gameIndex][1] = price;
                        paginationArray[pageIndex][gameIndex][2] = imagePath;
                        paginationArray[pageIndex][gameIndex][3] = String.valueOf(numberOfVideoGames);
                        paginationArray[pageIndex][gameIndex][4] = String.valueOf(totalCost);
                    }

                    gameIndex++;
                    if (gameIndex >= 5) {
                        pageIndex++;
                        gameIndex = 0;
                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Error de conexión a la base de datos.");
        }

        return paginationArray;
    }
    public void deleteShoppingCart(int userDataID) {
        if (con != null) {
            try {
                // Consulta SQL para eliminar el carrito de compras de un usuario específico
                String sql = "DELETE FROM ShoppingCarts WHERE IDDataUser = ?";
                PreparedStatement statement = con.prepareStatement(sql);
                statement.setInt(1, userDataID);

                // Ejecuta la consulta de eliminación
                int rowsAffected = statement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("El carrito de compras del usuario con ID " + userDataID + " ha sido eliminado de la base de datos.");
                } else {
                    System.out.println("No se encontró el carrito de compras del usuario con ID " + userDataID + ".");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Error de conexión a la base de datos.");
        }
    }


}
