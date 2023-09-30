/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;
import databaseConnection.ConnectionSQL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class ViewBilling extends javax.swing.JFrame {

public ViewBilling(List<String> dataGame) {

        initComponents();
        this.setLocationRelativeTo(null);

        IDNombre.setText(dataGame.get(0));
        IDPrecio.setText(dataGame.get(1));
        IDFecha.setText(dataGame.get(2));
        IDKey.setText(dataGame.get(3));
        IDDesarrolladora.setText(dataGame.get(4));
        IDNit.setText(dataGame.get(5));
        IDUser.setText(dataGame.get(6));
        IDTotal.setText(dataGame.get(1));
        String Factura = dataGame.get(7);
        int fact = Integer.parseInt(Factura);
        String factura = filterPurchaseHistoryByID(fact);
        IDFactura.setText(factura);
        
        
        
        // Obtener las filas con BillID vacío en la tabla
        List<Integer> emptyRows = getEmptyBillIDRows();

        // Generar y asignar números de factura aleatorios a cada fila vacía
        for (int rowID : emptyRows) {
            String billID = generateRandomBillID();
            updateBillIDInDatabase(rowID, billID);
        }

        // Asignar el número de factura al JLabel correspondiente
       // IDFactura.setText("Valores actualizados en BillID");
    } 

private String filterPurchaseHistoryByID(int filterValue) {
    StringBuilder filteredResult = new StringBuilder();

    try {
        ConnectionSQL connectionSQL = new ConnectionSQL();
        Connection connection = connectionSQL.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT PH.BillID " +
                "FROM PurchaseHistory PH " +
                "WHERE PH.PurchaseHistoryID = " + filterValue);

        while (resultSet.next()) {
            String purchaseHistoryID = resultSet.getString("BillID");
            filteredResult.append(purchaseHistoryID).append("\n");
        }

        resultSet.close();
        statement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return filteredResult.toString();
}


private String generateRandomBillID() {
        // Generar una cadena aleatoria de 10 dígitos
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int digit = random.nextInt(10);
            sb.append(digit);
        }
        return sb.toString();
    }

    private List<Integer> getEmptyBillIDRows() {
        List<Integer> rowList = new ArrayList<>();

        try {
            // Establecer la conexión con la base de datos
            ConnectionSQL connectionSQL = new ConnectionSQL();
            Connection connection = connectionSQL.getConnection();

            // Preparar la consulta SQL para obtener las filas con BillID vacío
            String query = "SELECT PurchaseHistoryID FROM PurchaseHistory WHERE BillID IS NULL OR BillID = ''";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Ejecutar la consulta
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int rowID = resultSet.getInt("PurchaseHistoryID");
                rowList.add(rowID);
            }

            // Cerrar el ResultSet, la declaración y la conexión
            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return rowList;
    }

    private void updateBillIDInDatabase(int rowID, String billID) {
        try {
            // Establecer la conexión con la base de datos
            ConnectionSQL connectionSQL = new ConnectionSQL();
            Connection connection = connectionSQL.getConnection();

            // Preparar la consulta SQL para actualizar el BillID en la fila específica
            String query = "UPDATE PurchaseHistory SET BillID = ? WHERE PurchaseHistoryID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, billID);
            preparedStatement.setInt(2, rowID);

            // Ejecutar la consulta
            preparedStatement.executeUpdate();

            // Cerrar la declaración y la conexión
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        ICONOGAMEON = new javax.swing.JLabel();
        MENSAJE = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        subkeyjuego = new javax.swing.JLabel();
        Subfacturado = new javax.swing.JLabel();
        IDUser = new javax.swing.JLabel();
        IDNit = new javax.swing.JLabel();
        SubFecha = new javax.swing.JLabel();
        SubNit = new javax.swing.JLabel();
        IDKey = new javax.swing.JLabel();
        IDFecha = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        ESTEESTUPEDIDO = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        SubNombre = new javax.swing.JLabel();
        SubDistribuidora = new javax.swing.JLabel();
        SubDesarrolladora = new javax.swing.JLabel();
        SubPrecio = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        IDNombre = new javax.swing.JLabel();
        GAMEON = new javax.swing.JLabel();
        IDDesarrolladora = new javax.swing.JLabel();
        IDPrecio = new javax.swing.JLabel();
        IDTotal = new javax.swing.JLabel();
        TOTAL = new javax.swing.JLabel();
        IDdelafactura = new javax.swing.JLabel();
        IDFactura = new javax.swing.JLabel();

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 780, 10));

        ICONOGAMEON.setFont(new java.awt.Font("Liberation Sans", 1, 48)); // NOI18N
        ICONOGAMEON.setText("GAMEON");
        jPanel1.add(ICONOGAMEON, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 220, 60));

        MENSAJE.setBackground(new java.awt.Color(0, 0, 0));
        MENSAJE.setText("GRACIAS POR ESCOGERNOS!!");
        jPanel1.add(MENSAJE, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 230, -1));

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 12)); // NOI18N
        jLabel1.setText("INFORMACON DE TU PEDIDO:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 190, -1));

        subkeyjuego.setText("Key del juego:");
        jPanel1.add(subkeyjuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 110, -1));

        Subfacturado.setText("Facturado a:");
        jPanel1.add(Subfacturado, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 290, 110, -1));

        IDUser.setText("xxxx-xxxx-xxxx-xxxx");
        jPanel1.add(IDUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 310, 260, 30));

        IDNit.setText("xxxx-xxxx-xxxx-xxxx");
        jPanel1.add(IDNit, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 410, 190, 30));

        SubFecha.setText("Fecha de compra:");
        jPanel1.add(SubFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, 130, -1));

        SubNit.setText("NIT:");
        jPanel1.add(SubNit, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 390, 40, -1));

        IDKey.setText("xxxx-xxxx-xxxx-xxxx");
        jPanel1.add(IDKey, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 190, 30));

        IDFecha.setText("xx/xx/xxxx");
        jPanel1.add(IDFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, 190, 30));

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 680, 780, 20));

        ESTEESTUPEDIDO.setFont(new java.awt.Font("Liberation Sans", 1, 12)); // NOI18N
        ESTEESTUPEDIDO.setText("ESTE ES TU PEDIDO:");
        jPanel1.add(ESTEESTUPEDIDO, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, 170, -1));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SubNombre.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        SubNombre.setText("Nombre:");
        jPanel2.add(SubNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 90, -1));

        SubDistribuidora.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        SubDistribuidora.setText("Distribuidora:");
        jPanel2.add(SubDistribuidora, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 110, -1));

        SubDesarrolladora.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        SubDesarrolladora.setText("Desarrolladora:");
        jPanel2.add(SubDesarrolladora, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 120, -1));

        SubPrecio.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        SubPrecio.setText("Precio:");
        jPanel2.add(SubPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, 60, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, 780, 30));

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 550, 780, 20));

        IDNombre.setText("xxxxxxxxxxxxxx");
        jPanel1.add(IDNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 640, 210, -1));

        GAMEON.setText("GAMEON");
        jPanel1.add(GAMEON, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 640, 90, -1));

        IDDesarrolladora.setText("xxxxxxxxx");
        jPanel1.add(IDDesarrolladora, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 640, 180, -1));

        IDPrecio.setText("xxx.xx Bs.");
        jPanel1.add(IDPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 640, 80, -1));

        IDTotal.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        IDTotal.setText("xxx.xx Bs.");
        jPanel1.add(IDTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 730, 80, 20));

        TOTAL.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        TOTAL.setText("Total:");
        jPanel1.add(TOTAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 730, 60, -1));

        IDdelafactura.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        IDdelafactura.setText("ID de la factura:");
        jPanel1.add(IDdelafactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 140, -1));

        IDFactura.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        IDFactura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IDFactura.setText("xxxx-xxxx-xxxx-xxxx");
        jPanel1.add(IDFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, 200, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 855, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    public static void main(String args[]) {
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ESTEESTUPEDIDO;
    private javax.swing.JLabel GAMEON;
    private javax.swing.JLabel ICONOGAMEON;
    private javax.swing.JLabel IDDesarrolladora;
    private javax.swing.JLabel IDFactura;
    private javax.swing.JLabel IDFecha;
    private javax.swing.JLabel IDKey;
    private javax.swing.JLabel IDNit;
    private javax.swing.JLabel IDNombre;
    private javax.swing.JLabel IDPrecio;
    private javax.swing.JLabel IDTotal;
    private javax.swing.JLabel IDUser;
    private javax.swing.JLabel IDdelafactura;
    private javax.swing.JLabel MENSAJE;
    private javax.swing.JLabel SubDesarrolladora;
    private javax.swing.JLabel SubDistribuidora;
    private javax.swing.JLabel SubFecha;
    private javax.swing.JLabel SubNit;
    private javax.swing.JLabel SubNombre;
    private javax.swing.JLabel SubPrecio;
    private javax.swing.JLabel Subfacturado;
    private javax.swing.JLabel TOTAL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel subkeyjuego;
    // End of variables declaration//GEN-END:variables
}
