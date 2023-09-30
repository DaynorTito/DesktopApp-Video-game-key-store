package logic;

import databaseConnection.ConnectionSQL;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CardPaymentChecker {
    private Connection con;

    public CardPaymentChecker() {
        // Establece la conexión con la base de datos al crear una instancia de la clase
        ConnectionSQL conexion = new ConnectionSQL();
        con = conexion.getConnection();
    }

    public boolean isDebitEnough(int userDataID, String cardNumber, float amount) {
        boolean isEnough = false;

        if (con != null) {
            try {
                // Consulta SQL para verificar si la cantidad de Debit es suficiente para el usuario y el número de tarjeta
                String sql = "SELECT Debit FROM CardPayments WHERE IDDataUser = ? AND CardNumber = ?";
                try (PreparedStatement statement = con.prepareStatement(sql)) {
                    statement.setInt(1, userDataID);
                    statement.setString(2, cardNumber);

                    // Ejecuta la consulta y obtiene el resultado en forma de ResultSet
                    try (ResultSet resultSet = statement.executeQuery()) {
                        if (resultSet.next()) {
                            float debit = resultSet.getFloat("Debit");

                            // Verifica si la cantidad de Debit es mayor o igual a la cantidad requerida
                            if (debit >= amount) {
                                isEnough = true;
                                
                                
                                
                            }
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Error de conexión a la base de datos.");
        }

        return isEnough;
    }
    

}
