package view;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import logic.ChangePage;
import logic.ShowGamesPage;
import logic.SuperUserDriver;


public class SuperUser extends javax.swing.JFrame {

    private ShowGamesPage gamesOnPage;
    private ChangePage cp;
    private SuperUserDriver superDriver;
    
    public SuperUser() {
        initComponents();
        this.setLocationRelativeTo(this);
        superDriver = new SuperUserDriver();
        showDataSale();
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tableHistorySales = new javax.swing.JTable();
        buttonRefresh = new javax.swing.JPanel();
        labelRefresh = new javax.swing.JLabel();
        buttonFailedSales = new javax.swing.JPanel();
        labelFailedSales = new javax.swing.JLabel();
        buttonSuccessfulSales = new javax.swing.JPanel();
        labelSuccessful = new javax.swing.JLabel();
        usersSearch = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        buttonShowDetails = new javax.swing.JPanel();
        labelShowDetails = new javax.swing.JLabel();
        totalSold = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        detailsSaleTextArea = new javax.swing.JTextArea();

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
        salesRecordButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        usersButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        gamesButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        tableHistorySales.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        tableHistorySales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nro", "Nombre completo", "User", "Juego", "Fecha y hora", "Estado", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableHistorySales.setToolTipText("Tabla");
        jScrollPane1.setViewportView(tableHistorySales);
        if (tableHistorySales.getColumnModel().getColumnCount() > 0) {
            tableHistorySales.getColumnModel().getColumn(0).setResizable(false);
            tableHistorySales.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableHistorySales.getColumnModel().getColumn(1).setResizable(false);
            tableHistorySales.getColumnModel().getColumn(1).setPreferredWidth(400);
            tableHistorySales.getColumnModel().getColumn(2).setResizable(false);
            tableHistorySales.getColumnModel().getColumn(2).setPreferredWidth(50);
            tableHistorySales.getColumnModel().getColumn(3).setResizable(false);
            tableHistorySales.getColumnModel().getColumn(3).setPreferredWidth(300);
            tableHistorySales.getColumnModel().getColumn(4).setResizable(false);
            tableHistorySales.getColumnModel().getColumn(4).setPreferredWidth(200);
            tableHistorySales.getColumnModel().getColumn(5).setResizable(false);
            tableHistorySales.getColumnModel().getColumn(5).setPreferredWidth(150);
            tableHistorySales.getColumnModel().getColumn(6).setResizable(false);
        }

        background.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 1580, 580));

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
            .addGroup(buttonRefreshLayout.createSequentialGroup()
                .addComponent(labelRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        buttonRefreshLayout.setVerticalGroup(
            buttonRefreshLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        background.add(buttonRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 140, 40));

        buttonFailedSales.setBackground(new java.awt.Color(217, 83, 79));

        labelFailedSales.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        labelFailedSales.setForeground(new java.awt.Color(255, 255, 255));
        labelFailedSales.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelFailedSales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgGameStore/icon/advertencia.png"))); // NOI18N
        labelFailedSales.setText("Ventas fallidas");
        labelFailedSales.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelFailedSales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelFailedSalesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelFailedSalesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelFailedSalesMouseExited(evt);
            }
        });

        javax.swing.GroupLayout buttonFailedSalesLayout = new javax.swing.GroupLayout(buttonFailedSales);
        buttonFailedSales.setLayout(buttonFailedSalesLayout);
        buttonFailedSalesLayout.setHorizontalGroup(
            buttonFailedSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelFailedSales, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
        );
        buttonFailedSalesLayout.setVerticalGroup(
            buttonFailedSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonFailedSalesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelFailedSales, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        background.add(buttonFailedSales, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 180, 190, 40));

        buttonSuccessfulSales.setBackground(new java.awt.Color(92, 184, 92));

        labelSuccessful.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        labelSuccessful.setForeground(new java.awt.Color(255, 255, 255));
        labelSuccessful.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSuccessful.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgGameStore/icon/controlar.png"))); // NOI18N
        labelSuccessful.setText("Ventas exitosas");
        labelSuccessful.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelSuccessful.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelSuccessfulMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelSuccessfulMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelSuccessfulMouseExited(evt);
            }
        });

        javax.swing.GroupLayout buttonSuccessfulSalesLayout = new javax.swing.GroupLayout(buttonSuccessfulSales);
        buttonSuccessfulSales.setLayout(buttonSuccessfulSalesLayout);
        buttonSuccessfulSalesLayout.setHorizontalGroup(
            buttonSuccessfulSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonSuccessfulSalesLayout.createSequentialGroup()
                .addComponent(labelSuccessful, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addContainerGap())
        );
        buttonSuccessfulSalesLayout.setVerticalGroup(
            buttonSuccessfulSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelSuccessful, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        background.add(buttonSuccessfulSales, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 180, 220, 40));

        usersSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usersSearchActionPerformed(evt);
            }
        });
        background.add(usersSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(1440, 180, 230, 40));

        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgGameStore/icon/lupa.png"))); // NOI18N
        searchButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchButton.setPreferredSize(new java.awt.Dimension(72, 6));
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        background.add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1690, 180, 44, 43));

        buttonShowDetails.setBackground(new java.awt.Color(70, 127, 208));

        labelShowDetails.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        labelShowDetails.setForeground(new java.awt.Color(255, 255, 255));
        labelShowDetails.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelShowDetails.setText("Detalles");
        labelShowDetails.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelShowDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelShowDetailsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelShowDetailsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelShowDetailsMouseExited(evt);
            }
        });

        javax.swing.GroupLayout buttonShowDetailsLayout = new javax.swing.GroupLayout(buttonShowDetails);
        buttonShowDetails.setLayout(buttonShowDetailsLayout);
        buttonShowDetailsLayout.setHorizontalGroup(
            buttonShowDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonShowDetailsLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelShowDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        buttonShowDetailsLayout.setVerticalGroup(
            buttonShowDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonShowDetailsLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelShowDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        background.add(buttonShowDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 910, 130, 40));

        totalSold.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        totalSold.setText("Total");
        background.add(totalSold, new org.netbeans.lib.awtextra.AbsoluteConstraints(1570, 840, 250, 40));

        detailsSaleTextArea.setEditable(false);
        detailsSaleTextArea.setBackground(new java.awt.Color(255, 255, 255));
        detailsSaleTextArea.setColumns(20);
        detailsSaleTextArea.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        detailsSaleTextArea.setRows(5);
        detailsSaleTextArea.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane2.setViewportView(detailsSaleTextArea);

        background.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 850, 660, 160));

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
    public void showDataSale(){
        clearTable();
        superDriver.getTotalSold(totalSold);
        superDriver.loadDataSales(this.tableHistorySales, superDriver.getSalesHistory());
    }
    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        clearTable();
        superDriver.loadDataSales(this.tableHistorySales, superDriver.filerUserName(this.usersSearch.getText()));

    }//GEN-LAST:event_searchButtonActionPerformed
    private void clearTable() {
        DefaultTableModel data = (DefaultTableModel) tableHistorySales.getModel();
        int n = this.tableHistorySales.getRowCount() - 1;
        for (int i = n; i >= 0; i--) {
            data.removeRow(this.tableHistorySales.getRowCount() - 1);
        }
        this.detailsSaleTextArea.setText("");
    }

    private void salesRecordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesRecordButtonActionPerformed
      
    }//GEN-LAST:event_salesRecordButtonActionPerformed

    private void usersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usersButtonActionPerformed
        this.setVisible(false);
        UserAdministrator us = new UserAdministrator();
        us.setVisible(true);
    }//GEN-LAST:event_usersButtonActionPerformed

    private void gamesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gamesButtonActionPerformed
       this.setVisible(false);
       GameAdministrator ga = new GameAdministrator();
       ga.setVisible(true);
    }//GEN-LAST:event_gamesButtonActionPerformed

    private void usersSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usersSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usersSearchActionPerformed

    private void labelRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRefreshMouseClicked
        clearTable();
        superDriver.loadDataSales(this.tableHistorySales, superDriver.getSalesHistory());
    }//GEN-LAST:event_labelRefreshMouseClicked

    private void labelShowDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelShowDetailsMouseClicked
        
        int x = this.tableHistorySales.getSelectedRow();
        if(x!=-1){
        String bill = (String) this.tableHistorySales.getValueAt(x, 0);
        superDriver.showDetails(this.detailsSaleTextArea, superDriver.getDetailsSale(bill));
        }
    }//GEN-LAST:event_labelShowDetailsMouseClicked

    private void labelFailedSalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelFailedSalesMouseClicked
        clearTable();
        superDriver.loadDataSales(this.tableHistorySales, superDriver.filerFailuresSales());
    }//GEN-LAST:event_labelFailedSalesMouseClicked

    private void labelSuccessfulMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSuccessfulMouseClicked
        clearTable();
        superDriver.loadDataSales(this.tableHistorySales, superDriver.filerSucessfullSales());
    }//GEN-LAST:event_labelSuccessfulMouseClicked

    private void labelRefreshMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRefreshMouseEntered
        this.buttonRefresh.setBackground(new Color(51,107,188));
    }//GEN-LAST:event_labelRefreshMouseEntered

    private void labelRefreshMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRefreshMouseExited
        this.buttonRefresh.setBackground(new Color(70,127,208));
    }//GEN-LAST:event_labelRefreshMouseExited

    private void labelFailedSalesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelFailedSalesMouseEntered
        this.buttonFailedSales.setBackground(new Color(255,102,102));
    }//GEN-LAST:event_labelFailedSalesMouseEntered

    private void labelFailedSalesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelFailedSalesMouseExited
        this.buttonFailedSales.setBackground(new Color(217,83,79));
    }//GEN-LAST:event_labelFailedSalesMouseExited

    private void labelSuccessfulMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSuccessfulMouseEntered
        this.buttonSuccessfulSales.setBackground(new Color(0,153,51));
    }//GEN-LAST:event_labelSuccessfulMouseEntered

    private void labelSuccessfulMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSuccessfulMouseExited
        this.buttonSuccessfulSales.setBackground(new Color(92,184,92));
    }//GEN-LAST:event_labelSuccessfulMouseExited

    private void labelShowDetailsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelShowDetailsMouseEntered
        this.buttonShowDetails.setBackground(new Color(51,107,188));
    }//GEN-LAST:event_labelShowDetailsMouseEntered

    private void labelShowDetailsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelShowDetailsMouseExited
        this.buttonShowDetails.setBackground(new Color(70,127,208));
    }//GEN-LAST:event_labelShowDetailsMouseExited

    private void labelFailedSales1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelFailedSales1MouseClicked
          System.exit(0);
    }//GEN-LAST:event_labelFailedSales1MouseClicked

    private void labelFailedSales1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelFailedSales1MouseEntered
        this.buttonFailedSales1.setBackground(new Color(255,102,102));
    }//GEN-LAST:event_labelFailedSales1MouseEntered

    private void labelFailedSales1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelFailedSales1MouseExited
       this.buttonFailedSales1.setBackground(new Color(217,83,79));
    }//GEN-LAST:event_labelFailedSales1MouseExited


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SuperUser().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JPanel buttonFailedSales;
    private javax.swing.JPanel buttonFailedSales1;
    private javax.swing.JPanel buttonRefresh;
    private javax.swing.JPanel buttonShowDetails;
    private javax.swing.JPanel buttonSuccessfulSales;
    private javax.swing.JTextArea detailsSaleTextArea;
    private javax.swing.JButton gamesButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelAdministrator;
    private javax.swing.JLabel labelFailedSales;
    private javax.swing.JLabel labelFailedSales1;
    private javax.swing.JLabel labelRefresh;
    private javax.swing.JLabel labelShowDetails;
    private javax.swing.JLabel labelSuccessful;
    private javax.swing.JLabel logPage;
    private javax.swing.JButton salesRecordButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTable tableHistorySales;
    private javax.swing.JPanel topBlackBarPanel;
    private javax.swing.JLabel totalSold;
    private javax.swing.JButton usersButton;
    private javax.swing.JTextField usersSearch;
    // End of variables declaration//GEN-END:variables
}
