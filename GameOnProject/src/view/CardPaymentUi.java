/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import databaseConnection.CLogin;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import logic.CardPaymentChecker;
import logic.ShoppingCartSearcherUsers;
import logic.PurchaseHistoryUpdater;


/**
 *
 * @author university
 */
public class CardPaymentUi extends javax.swing.JFrame {
    //costo total
        ShoppingCartSearcherUsers searcher = new ShoppingCartSearcherUsers();
        CardPaymentChecker checker = new CardPaymentChecker();
        private PurchaseHistoryUpdater historyUpdater;
        
        private CarritoCompras carritoCompras;


        
        int userDataID;
        
        double totalCost = searcher.getTotalCost(this.userDataID);
        
        int numberOfVideoGames;

    public int getUserDataID() {
        return userDataID;
    }

    public void setUserDataID(int userDataID) {
        this.userDataID = userDataID;
    }
        

    public CardPaymentUi() {
        initComponents();
        this.setLocationRelativeTo(this);
        //();
        
        
        //setImageLabel(debitCardIcon,"src/imgGameStore/icon/tarjeta-de-debito.png");
         // Obtener el costo total
        // Obtener el costo total
        totalCost = searcher.getTotalCost(this.userDataID);

        // Formatear el costo total a dos decimales
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String formattedTotalCost = decimalFormat.format(totalCost);

        // Concatenar la palabra "Bs" al final del número formateado
        String totalCostLabelText = formattedTotalCost + " Bs";

        // Actualizar el texto del JLabel
        totalCostLabel.setText(totalCostLabelText);

        // Mostrar el JLabel actualizado
        totalCostLabel.setVisible(true);
        // validar cantidad del carrito de compras con la del usuario
        
        historyUpdater = new PurchaseHistoryUpdater();
        
        List<Integer> unpurchasedGameIDs = searcher.getUnpurchasedGameIDs(this.userDataID);
        numberOfVideoGames = unpurchasedGameIDs.size();
        
        
        
        

    }
    
    public CardPaymentUi(double totalPrice) {
        initComponents();
        this.setLocationRelativeTo(this);
        userDataID = CLogin.userId;
        
        //setImageLabel(debitCardIcon,"src/imgGameStore/icon/tarjeta-de-debito.png");
         // Obtener el costo total
        // Obtener el costo total
        totalCost = totalPrice;

        // Formatear el costo total a dos decimales
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String formattedTotalCost = decimalFormat.format(totalCost);

        // Concatenar la palabra "Bs" al final del número formateado
        String totalCostLabelText = formattedTotalCost + " Bs";

        // Actualizar el texto del JLabel
        totalCostLabel.setText(totalCostLabelText);

        // Mostrar el JLabel actualizado
        totalCostLabel.setVisible(true);
        // validar cantidad del carrito de compras con la del usuario
       
        historyUpdater = new PurchaseHistoryUpdater();
        
        List<Integer> unpurchasedGameIDs = searcher.getUnpurchasedGameIDs(this.userDataID);
        numberOfVideoGames = unpurchasedGameIDs.size();
    }
    
    
    private void configureCloseAction() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        this.addWindowFocusListener(new WindowAdapter() {
            public void windowLostFocus(WindowEvent e) {
                // Cerrar el JFrame CardPaymentUi cuando pierde el foco
                dispose();
                // Mostrar nuevamente el JFrame CarritoCompras
                /*carritoCompras = new CarritoCompras();
                carritoCompras.setVisible(true);*/
                
            }
        });

        /*cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Cerrar el JFrame CardPaymentUi al hacer clic en el botón "Cancelar compra"
                dispose();
                // Mostrar nuevamente el JFrame CarritoCompras
                carritoCompras.setVisible(true);
            }
        });*/
    }
    private void updatePurchaseHistory(int userDataID) {
        // Crea una instancia de la clase PurchaseHistoryUpdater
        PurchaseHistoryUpdater historyUpdater = new PurchaseHistoryUpdater();

        // Invoca el método para actualizar el historial de compras
        historyUpdater.updatePurchaseHistory(userDataID);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        totalCostLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        cardNumberTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        cancelPurchase = new javax.swing.JPanel();
        cancelButton = new javax.swing.JLabel();
        makePurchase = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1050, 560));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(28, 19, 47));
        jPanel1.setName(""); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(1714, 562));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Liberation Sans", 0, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("GAMEON");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, 230, 140));

        jPanel5.setBackground(new java.awt.Color(44, 39, 58));

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Costo total");

        totalCostLabel.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        totalCostLabel.setText("30000bs");

        jPanel4.setBackground(new java.awt.Color(44, 39, 59));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 71, 216)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cardNumberTextField.setBackground(new java.awt.Color(67, 55, 99));
        cardNumberTextField.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        cardNumberTextField.setForeground(new java.awt.Color(255, 255, 255));
        cardNumberTextField.setBorder(null);
        cardNumberTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardNumberTextFieldActionPerformed(evt);
            }
        });
        jPanel4.add(cardNumberTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 10, 300, 39));

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(182, 159, 225));
        jLabel2.setText("Card number");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 160, 40));

        jPanel6.setBackground(new java.awt.Color(44, 39, 59));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 71, 216)));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(182, 159, 225));
        jLabel6.setText("Expiry");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 70, 40));

        jTextField2.setBackground(new java.awt.Color(67, 55, 99));
        jTextField2.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setBorder(null);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel6.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 50, 39));

        jTextField3.setBackground(new java.awt.Color(67, 55, 99));
        jTextField3.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(255, 255, 255));
        jTextField3.setBorder(null);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel6.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 50, 39));

        jLabel8.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(182, 159, 225));
        jLabel8.setText("YYYY");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 30, 40));

        jLabel9.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(182, 159, 225));
        jLabel9.setText("DD");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 30, 40));

        jPanel7.setBackground(new java.awt.Color(44, 39, 59));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 71, 216)));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(182, 159, 225));
        jLabel7.setText("cvc");
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 70, 40));

        jTextField4.setBackground(new java.awt.Color(67, 55, 99));
        jTextField4.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));
        jTextField4.setBorder(null);
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jPanel7.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 120, 39));

        cancelPurchase.setBackground(new java.awt.Color(51, 0, 51));
        cancelPurchase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelPurchaseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancelPurchaseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancelPurchaseMouseExited(evt);
            }
        });

        cancelButton.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        cancelButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelButton.setText("Cancelar compra");

        javax.swing.GroupLayout cancelPurchaseLayout = new javax.swing.GroupLayout(cancelPurchase);
        cancelPurchase.setLayout(cancelPurchaseLayout);
        cancelPurchaseLayout.setHorizontalGroup(
            cancelPurchaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cancelPurchaseLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(cancelButton)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        cancelPurchaseLayout.setVerticalGroup(
            cancelPurchaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cancelPurchaseLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancelButton)
                .addContainerGap())
        );

        makePurchase.setBackground(new java.awt.Color(0, 51, 0));
        makePurchase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                makePurchaseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                makePurchaseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                makePurchaseMouseExited(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Realizar el pago");

        javax.swing.GroupLayout makePurchaseLayout = new javax.swing.GroupLayout(makePurchase);
        makePurchase.setLayout(makePurchaseLayout);
        makePurchaseLayout.setHorizontalGroup(
            makePurchaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(makePurchaseLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel3)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        makePurchaseLayout.setVerticalGroup(
            makePurchaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(makePurchaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(cancelPurchase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105)
                        .addComponent(makePurchase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(46, 46, 46)
                                .addComponent(totalCostLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(totalCostLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cancelPurchase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(makePurchase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 128, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1126, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cardNumberTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardNumberTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cardNumberTextFieldActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void cancelPurchaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelPurchaseMouseClicked
        this.dispose();
    }//GEN-LAST:event_cancelPurchaseMouseClicked

    private void cancelPurchaseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelPurchaseMouseEntered
        cancelPurchase.setBackground(new Color(51,22,91));
    }//GEN-LAST:event_cancelPurchaseMouseEntered

    private void cancelPurchaseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelPurchaseMouseExited
        cancelPurchase.setBackground(new Color(51,0,51));
    }//GEN-LAST:event_cancelPurchaseMouseExited

    private void makePurchaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_makePurchaseMouseClicked
        String cardNumber = cardNumberTextField.getText(); // Obtiene el número de tarjeta ingresado en un campo de texto
        float amount = (float) totalCost; // Monto de compra
        System.out.println(cardNumber);
        System.out.println("amount");

        if (cardNumber.length() != 16) {
            // Muestra una ventana de advertencia si la cantidad de caracteres no es igual a 16
            JOptionPane.showMessageDialog(this, "El número de tarjeta debe contener 16 caracteres", "Advertencia", JOptionPane.WARNING_MESSAGE);
            System.out.println("16 dijitos invalidos");
            return; // Sale del método sin continuar con el proceso de compra
            
        }

        // Llama al método isDebitEnough y obtiene el resultado
        boolean isEnough = checker.isDebitEnough(userDataID, cardNumber, amount);

        if (!isEnough) {
            // Insertar en el historial de compras con IDStatus = 3
            historyUpdater.updatePurchaseHistoryFaild(this.userDataID);
            //searcher.updateBoughtStatus(userDataID);
            // Muestra una ventana si el saldo es insuficiente
            JOptionPane.showMessageDialog(this, "Saldo insuficiente en la tarjeta", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Actualiza el historial de compras
        historyUpdater.updatePurchaseHistory(this.userDataID);
        searcher.updateBoughtStatus(this.userDataID);

        // Muestra un mensaje de compra exitosa
        JOptionPane.showMessageDialog(this, "Compra realizada exitosamente", "Compra exitosa", JOptionPane.INFORMATION_MESSAGE);
        RecordGames record = new RecordGames(this.userDataID);
        record.setVisible(true);
        dispose();
     
    }//GEN-LAST:event_makePurchaseMouseClicked

    private void makePurchaseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_makePurchaseMouseEntered
        makePurchase.setBackground(new Color(0,23,38));
    }//GEN-LAST:event_makePurchaseMouseEntered

    private void makePurchaseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_makePurchaseMouseExited
        makePurchase.setBackground(new Color(0,51,38));
    }//GEN-LAST:event_makePurchaseMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CardPaymentUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CardPaymentUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CardPaymentUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CardPaymentUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CardPaymentUi().setVisible(true);
            }
        });
    }
    private void setImageLabel(JLabel labelName, String root){
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
        labelName.setIcon(icon);
        this.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cancelButton;
    private javax.swing.JPanel cancelPurchase;
    private javax.swing.JTextField cardNumberTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JPanel makePurchase;
    private javax.swing.JLabel totalCostLabel;
    // End of variables declaration//GEN-END:variables
}

