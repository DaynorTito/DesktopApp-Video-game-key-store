package view;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import logic.ChangePage;
import logic.PutCovers;
import logic.ShowGamesPage;
import logic.SuperUserDriver;


public class UserAdministrator extends javax.swing.JFrame {

    private ShowGamesPage gamesOnPage;
    private ChangePage cp;
    private SuperUserDriver superDriver;
    private JTextField[] arrayFields;
    
    public UserAdministrator() {
        initComponents();
        this.setLocationRelativeTo(this);
        clearTable();
        superDriver = new SuperUserDriver();
        superDriver.loadAllUsers(this.tableUsers,superDriver.getAllUsers());
        arrayFields = new JTextField[]{this.userNameField,this.firstNameField,this.lastNameField,this.dateOfBirthField,this.changePassUser,this.passwordAdmin};
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        topBlackBarPanel = new javax.swing.JPanel();
        salesRecordButton = new javax.swing.JButton();
        usersButton = new javax.swing.JButton();
        gamesButton = new javax.swing.JButton();
        logPage = new javax.swing.JLabel();
        labelAdministrator = new javax.swing.JLabel();
        buttonFailedSales1 = new javax.swing.JPanel();
        labelFailedSales1 = new javax.swing.JLabel();
        labelUsers = new javax.swing.JLabel();
        searchUsers = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableUsers = new javax.swing.JTable();
        buttonSelectUser = new javax.swing.JPanel();
        labelSelect = new javax.swing.JLabel();
        changeData = new javax.swing.JPanel();
        labelChangeData = new javax.swing.JLabel();
        labelUserName = new javax.swing.JLabel();
        userNameField = new javax.swing.JTextField();
        labelChangeTo = new javax.swing.JLabel();
        changePassUser = new javax.swing.JPasswordField();
        labelFirstName = new javax.swing.JLabel();
        firstNameField = new javax.swing.JTextField();
        labelLastName = new javax.swing.JLabel();
        lastNameField = new javax.swing.JTextField();
        labelDateofbirth = new javax.swing.JLabel();
        dateOfBirthField = new javax.swing.JTextField();
        labelPassAdmin = new javax.swing.JLabel();
        passwordAdmin = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        buttonChange = new javax.swing.JPanel();
        labelChange = new javax.swing.JLabel();
        buttonRefresh = new javax.swing.JPanel();
        labelRefresh = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 255, 204));
        setExtendedState(6);

        background.setBackground(new java.awt.Color(234, 234, 234));
        background.setMinimumSize(new java.awt.Dimension(1920, 1010));
        background.setPreferredSize(new java.awt.Dimension(1920, 1080));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        topBlackBarPanel.setBackground(new java.awt.Color(0, 0, 0));
        topBlackBarPanel.setPreferredSize(new java.awt.Dimension(1920, 123));
        topBlackBarPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        salesRecordButton.setBackground(new java.awt.Color(59, 59, 59));
        salesRecordButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        salesRecordButton.setForeground(new java.awt.Color(255, 255, 255));
        salesRecordButton.setText("Registro de ventas");
        salesRecordButton.setPreferredSize(new java.awt.Dimension(158, 28));
        salesRecordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesRecordButtonActionPerformed(evt);
            }
        });
        topBlackBarPanel.add(salesRecordButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(578, 80, 240, -1));

        usersButton.setBackground(new java.awt.Color(59, 59, 59));
        usersButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        usersButton.setForeground(new java.awt.Color(255, 255, 255));
        usersButton.setText("Usuarios");
        usersButton.setPreferredSize(new java.awt.Dimension(158, 28));
        usersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usersButtonActionPerformed(evt);
            }
        });
        topBlackBarPanel.add(usersButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 80, -1, -1));

        gamesButton.setBackground(new java.awt.Color(59, 59, 59));
        gamesButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        gamesButton.setForeground(new java.awt.Color(255, 255, 255));
        gamesButton.setText("Juegos");
        gamesButton.setPreferredSize(new java.awt.Dimension(158, 28));
        gamesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gamesButtonActionPerformed(evt);
            }
        });
        topBlackBarPanel.add(gamesButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 80, -1, -1));

        logPage.setFont(new java.awt.Font("Liberation Sans", 1, 60)); // NOI18N
        logPage.setForeground(new java.awt.Color(255, 255, 255));
        logPage.setText("GAME ON");
        topBlackBarPanel.add(logPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 32, 326, 61));

        labelAdministrator.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        labelAdministrator.setForeground(new java.awt.Color(255, 255, 255));
        labelAdministrator.setText("Administrador");
        topBlackBarPanel.add(labelAdministrator, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));

        buttonFailedSales1.setBackground(new java.awt.Color(217, 83, 79));

        labelFailedSales1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        labelFailedSales1.setForeground(new java.awt.Color(255, 255, 255));
        labelFailedSales1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelFailedSales1.setText("Salir");
        labelFailedSales1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelFailedSales1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelFailedSales1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelFailedSales1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelFailedSales1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout buttonFailedSales1Layout = new javax.swing.GroupLayout(buttonFailedSales1);
        buttonFailedSales1.setLayout(buttonFailedSales1Layout);
        buttonFailedSales1Layout.setHorizontalGroup(
            buttonFailedSales1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelFailedSales1, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );
        buttonFailedSales1Layout.setVerticalGroup(
            buttonFailedSales1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelFailedSales1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        topBlackBarPanel.add(buttonFailedSales1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1760, 70, 90, -1));

        background.add(topBlackBarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 130));

        labelUsers.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        labelUsers.setText("Usuarios");
        background.add(labelUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        searchUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchUsersActionPerformed(evt);
            }
        });
        background.add(searchUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 210, 230, 40));

        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgGameStore/icon/lupa.png"))); // NOI18N
        searchButton.setPreferredSize(new java.awt.Dimension(72, 6));
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        background.add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 210, 44, 43));

        tableUsers.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tableUsers.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        tableUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User", "Nombre", "Apellido", "Correo", "Cumpleaños", "NIT"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tableUsers);
        if (tableUsers.getColumnModel().getColumnCount() > 0) {
            tableUsers.getColumnModel().getColumn(0).setResizable(false);
            tableUsers.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableUsers.getColumnModel().getColumn(1).setResizable(false);
            tableUsers.getColumnModel().getColumn(1).setPreferredWidth(100);
            tableUsers.getColumnModel().getColumn(2).setResizable(false);
            tableUsers.getColumnModel().getColumn(2).setPreferredWidth(100);
            tableUsers.getColumnModel().getColumn(3).setResizable(false);
            tableUsers.getColumnModel().getColumn(3).setPreferredWidth(200);
            tableUsers.getColumnModel().getColumn(4).setResizable(false);
            tableUsers.getColumnModel().getColumn(4).setPreferredWidth(100);
            tableUsers.getColumnModel().getColumn(5).setResizable(false);
            tableUsers.getColumnModel().getColumn(5).setPreferredWidth(100);
        }

        background.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 990, 700));

        buttonSelectUser.setBackground(new java.awt.Color(70, 127, 208));

        labelSelect.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        labelSelect.setForeground(new java.awt.Color(255, 255, 255));
        labelSelect.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSelect.setText("Seleccionar");
        labelSelect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelSelectMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelSelectMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelSelectMouseExited(evt);
            }
        });

        javax.swing.GroupLayout buttonSelectUserLayout = new javax.swing.GroupLayout(buttonSelectUser);
        buttonSelectUser.setLayout(buttonSelectUserLayout);
        buttonSelectUserLayout.setHorizontalGroup(
            buttonSelectUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelSelect, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        buttonSelectUserLayout.setVerticalGroup(
            buttonSelectUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelSelect, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        background.add(buttonSelectUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 340, 130, 40));

        changeData.setBackground(new java.awt.Color(255, 255, 255));
        changeData.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelChangeData.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        labelChangeData.setText("Cambiar datos");

        labelUserName.setText("Usuario");

        userNameField.setEditable(false);

        labelChangeTo.setText("Nueva contraseña");

        labelFirstName.setText("Nombres");

        labelLastName.setText("Apellidos");

        labelDateofbirth.setText("Cumpleaños");

        labelPassAdmin.setText("Pass admin");

        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));

        buttonChange.setBackground(new java.awt.Color(230, 230, 230));
        buttonChange.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(70, 127, 208), 2));
        buttonChange.setForeground(new java.awt.Color(255, 255, 255));

        labelChange.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        labelChange.setForeground(new java.awt.Color(70, 127, 208));
        labelChange.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelChange.setText("Cambiar");
        labelChange.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelChange.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelChangeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelChangeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelChangeMouseExited(evt);
            }
        });

        javax.swing.GroupLayout buttonChangeLayout = new javax.swing.GroupLayout(buttonChange);
        buttonChange.setLayout(buttonChangeLayout);
        buttonChangeLayout.setHorizontalGroup(
            buttonChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelChange, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
        );
        buttonChangeLayout.setVerticalGroup(
            buttonChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelChange, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout changeDataLayout = new javax.swing.GroupLayout(changeData);
        changeData.setLayout(changeDataLayout);
        changeDataLayout.setHorizontalGroup(
            changeDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, changeDataLayout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addGroup(changeDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, changeDataLayout.createSequentialGroup()
                        .addGroup(changeDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(changeDataLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(changeDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelDateofbirth)
                                    .addComponent(labelPassAdmin)))
                            .addComponent(labelChangeTo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(changeDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(firstNameField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(userNameField)
                            .addComponent(lastNameField)
                            .addComponent(dateOfBirthField)
                            .addComponent(changePassUser, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                            .addComponent(passwordAdmin))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(changeDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(labelChangeData)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(changeDataLayout.createSequentialGroup()
                            .addGap(11, 11, 11)
                            .addGroup(changeDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelUserName)
                                .addComponent(labelFirstName, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(labelLastName, javax.swing.GroupLayout.Alignment.TRAILING)))))
                .addGap(32, 32, 32))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, changeDataLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(buttonChange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(188, 188, 188))
        );
        changeDataLayout.setVerticalGroup(
            changeDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(changeDataLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(labelChangeData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(changeDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUserName)
                    .addComponent(userNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(changeDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFirstName)
                    .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(changeDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLastName)
                    .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(changeDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDateofbirth)
                    .addComponent(dateOfBirthField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(changeDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changePassUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelChangeTo))
                .addGap(35, 35, 35)
                .addGroup(changeDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPassAdmin))
                .addGap(56, 56, 56)
                .addComponent(buttonChange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        background.add(changeData, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 260, 510, 690));

        buttonRefresh.setBackground(new java.awt.Color(70, 127, 208));

        labelRefresh.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        labelRefresh.setForeground(new java.awt.Color(255, 255, 255));
        labelRefresh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgGameStore/icon/actualizar.png"))); // NOI18N
        labelRefresh.setText("Actualizar");
        labelRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelRefreshMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelRefreshMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelRefreshMouseExited(evt);
            }
        });

        javax.swing.GroupLayout buttonRefreshLayout = new javax.swing.GroupLayout(buttonRefresh);
        buttonRefresh.setLayout(buttonRefreshLayout);
        buttonRefreshLayout.setHorizontalGroup(
            buttonRefreshLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        buttonRefreshLayout.setVerticalGroup(
            buttonRefreshLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        background.add(buttonRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 150, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        clearTable();
        superDriver.loadAllUsers(this.tableUsers, superDriver.filterUserNam(this.searchUsers.getText()));
    }//GEN-LAST:event_searchButtonActionPerformed

    private void gamesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gamesButtonActionPerformed
        this.setVisible(false);
       GameAdministrator ga = new GameAdministrator();
       ga.setVisible(true);
    }//GEN-LAST:event_gamesButtonActionPerformed
    public void clearTable(){
        DefaultTableModel data = (DefaultTableModel) tableUsers.getModel();
        int n = tableUsers.getRowCount() - 1;
        for (int i = n; i >= 0; i--) {
            data.removeRow(this.tableUsers.getRowCount() - 1);
        }
        clearFields();
    }
    private void usersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usersButtonActionPerformed

    }//GEN-LAST:event_usersButtonActionPerformed

    private void salesRecordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesRecordButtonActionPerformed
         this.setVisible(false);
       SuperUser su = new SuperUser();
       su.setVisible(true);
    }//GEN-LAST:event_salesRecordButtonActionPerformed

    private void searchUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchUsersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchUsersActionPerformed

    private void labelSelectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSelectMouseClicked
        int x = this.tableUsers.getSelectedRow();
        if (x!=-1){
        String userNa = (String) this.tableUsers.getValueAt(x, 0);
        superDriver.putInfoTextField(this.arrayFields, userNa);}     
    }//GEN-LAST:event_labelSelectMouseClicked

    private void labelRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRefreshMouseClicked
        clearTable();
        superDriver.loadAllUsers(this.tableUsers,superDriver.getAllUsers());
    }//GEN-LAST:event_labelRefreshMouseClicked
// PASWORD FOR ADMIN
    private void labelChangeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelChangeMouseClicked
        
        if(this.passwordAdmin.getText().equals("Admin123")){
            if(this.changePassUser.getText().equals("")){
                superDriver.changeUserData(this.arrayFields);
            } else{
                superDriver.changeUserData(this.arrayFields);
                superDriver.changePassword(this.userNameField.getText(), this.changePassUser.getText());
            }
            JOptionPane.showMessageDialog(null, "Datos actualizados correctamente", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else{
            JOptionPane.showMessageDialog(null, "Accion denegada", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        clearFields();
    }//GEN-LAST:event_labelChangeMouseClicked

    private void labelRefreshMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRefreshMouseEntered
        this.buttonRefresh.setBackground(new Color(51,107,188));
    }//GEN-LAST:event_labelRefreshMouseEntered

    private void labelSelectMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSelectMouseEntered
        this.buttonSelectUser.setBackground(new Color(51,107,188));
    }//GEN-LAST:event_labelSelectMouseEntered

    private void labelChangeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelChangeMouseEntered
        this.buttonChange.setBackground(new Color(51,107,188));
        this.labelChange.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_labelChangeMouseEntered

    private void labelRefreshMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRefreshMouseExited
        this.buttonRefresh.setBackground(new Color(70,127,208));
        
    }//GEN-LAST:event_labelRefreshMouseExited

    private void labelSelectMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSelectMouseExited
        this.buttonSelectUser.setBackground(new Color(70,127,208));
    }//GEN-LAST:event_labelSelectMouseExited

    private void labelChangeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelChangeMouseExited
        this.buttonChange.setBackground(new Color(242,242,242));
        this.labelChange.setForeground(new Color(70,127,208));
    }//GEN-LAST:event_labelChangeMouseExited

    private void labelFailedSales1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelFailedSales1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_labelFailedSales1MouseClicked

    private void labelFailedSales1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelFailedSales1MouseEntered
        this.buttonFailedSales1.setBackground(new Color(255,102,102));
    }//GEN-LAST:event_labelFailedSales1MouseEntered

    private void labelFailedSales1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelFailedSales1MouseExited
        this.buttonFailedSales1.setBackground(new Color(217,83,79));
    }//GEN-LAST:event_labelFailedSales1MouseExited
    public void clearFields(){
        this.userNameField.setText("");
        this.firstNameField.setText("");
        this.lastNameField.setText("");
        this.dateOfBirthField.setText("");
        this.changePassUser.setText("");
        this.passwordAdmin.setText("");
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserAdministrator().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JPanel buttonChange;
    private javax.swing.JPanel buttonFailedSales1;
    private javax.swing.JPanel buttonRefresh;
    private javax.swing.JPanel buttonSelectUser;
    private javax.swing.JPanel changeData;
    private javax.swing.JPasswordField changePassUser;
    private javax.swing.JTextField dateOfBirthField;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JButton gamesButton;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelAdministrator;
    private javax.swing.JLabel labelChange;
    private javax.swing.JLabel labelChangeData;
    private javax.swing.JLabel labelChangeTo;
    private javax.swing.JLabel labelDateofbirth;
    private javax.swing.JLabel labelFailedSales1;
    private javax.swing.JLabel labelFirstName;
    private javax.swing.JLabel labelLastName;
    private javax.swing.JLabel labelPassAdmin;
    private javax.swing.JLabel labelRefresh;
    private javax.swing.JLabel labelSelect;
    private javax.swing.JLabel labelUserName;
    private javax.swing.JLabel labelUsers;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel logPage;
    private javax.swing.JPasswordField passwordAdmin;
    private javax.swing.JButton salesRecordButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchUsers;
    private javax.swing.JTable tableUsers;
    private javax.swing.JPanel topBlackBarPanel;
    private javax.swing.JTextField userNameField;
    private javax.swing.JButton usersButton;
    // End of variables declaration//GEN-END:variables
}
