package view;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import logic.ChangePage;
import logic.PutCovers;
import logic.ShowGamesPage;
import logic.SuperUserDriver;


public class GameAdministrator extends javax.swing.JFrame {

    private ShowGamesPage gamesOnPage;
    private ChangePage cp;
    private SuperUserDriver superDriver;
    private JTextField[] arrayLabel;
    private JComboBox[] arrayBox;
    
    public GameAdministrator() {
        initComponents();
        this.setLocationRelativeTo(this);
        
        arrayBox = new JComboBox[]{this.optionsCategory,this.optionsPlatform, this.optionsAudience,this.optionsDeveloper};
        arrayLabel = new JTextField[]{this.textFieldNameGame, this.textFieldPrice, this.textFieldKey};
        superDriver = new SuperUserDriver();
        clearTable();
        superDriver.loadAllGames(this.tableGames, superDriver.getAllGames());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        topBlackBarPanel = new javax.swing.JPanel();
        salesRecordButton = new javax.swing.JButton();
        usertsButton = new javax.swing.JButton();
        gamesButton = new javax.swing.JButton();
        logPage = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        buttonFailedSales1 = new javax.swing.JPanel();
        labelFailedSales1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableGames = new javax.swing.JTable();
        textFieldGame = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        buttonSelect = new javax.swing.JPanel();
        labelSelect = new javax.swing.JLabel();
        panelModifyDataGames = new javax.swing.JPanel();
        labelModifyData = new javax.swing.JLabel();
        labelName = new javax.swing.JLabel();
        textFieldNameGame = new javax.swing.JTextField();
        labelCategory = new javax.swing.JLabel();
        optionsCategory = new javax.swing.JComboBox<>();
        labelPlatform = new javax.swing.JLabel();
        optionsPlatform = new javax.swing.JComboBox<>();
        labelAudience = new javax.swing.JLabel();
        optionsAudience = new javax.swing.JComboBox<>();
        labelDeveloper = new javax.swing.JLabel();
        optionsDeveloper = new javax.swing.JComboBox<>();
        labelPrice = new javax.swing.JLabel();
        textFieldPrice = new javax.swing.JTextField();
        labelPassword = new javax.swing.JLabel();
        passwordAdmin = new javax.swing.JPasswordField();
        buttonSaveChanges = new javax.swing.JPanel();
        labelSave = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        panelAddKey = new javax.swing.JPanel();
        labelAddkey = new javax.swing.JLabel();
        labelKey = new javax.swing.JLabel();
        textFieldKey = new javax.swing.JTextField();
        buttonAddKey = new javax.swing.JPanel();
        labelAdd = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        labelGames = new javax.swing.JLabel();
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
        salesRecordButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        salesRecordButton.setPreferredSize(new java.awt.Dimension(158, 28));
        salesRecordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesRecordButtonActionPerformed(evt);
            }
        });
        topBlackBarPanel.add(salesRecordButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, 240, -1));

        usertsButton.setBackground(new java.awt.Color(59, 59, 59));
        usertsButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        usertsButton.setForeground(new java.awt.Color(255, 255, 255));
        usertsButton.setText("Usuarios");
        usertsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        usertsButton.setPreferredSize(new java.awt.Dimension(158, 28));
        usertsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usertsButtonActionPerformed(evt);
            }
        });
        topBlackBarPanel.add(usertsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 80, -1, -1));

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

        jLabel8.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Administrador");
        topBlackBarPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));

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

        tableGames.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        tableGames.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Categoria", "Plataforma", "Audiencia", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableGames.setToolTipText("Tabla");
        jScrollPane1.setViewportView(tableGames);
        if (tableGames.getColumnModel().getColumnCount() > 0) {
            tableGames.getColumnModel().getColumn(0).setResizable(false);
            tableGames.getColumnModel().getColumn(0).setPreferredWidth(270);
            tableGames.getColumnModel().getColumn(1).setResizable(false);
            tableGames.getColumnModel().getColumn(1).setPreferredWidth(80);
            tableGames.getColumnModel().getColumn(2).setResizable(false);
            tableGames.getColumnModel().getColumn(2).setPreferredWidth(60);
            tableGames.getColumnModel().getColumn(3).setResizable(false);
            tableGames.getColumnModel().getColumn(3).setPreferredWidth(50);
            tableGames.getColumnModel().getColumn(4).setResizable(false);
            tableGames.getColumnModel().getColumn(4).setPreferredWidth(60);
        }

        background.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 1090, 740));

        textFieldGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldGameActionPerformed(evt);
            }
        });
        background.add(textFieldGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 200, 230, 40));

        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgGameStore/icon/lupa.png"))); // NOI18N
        searchButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchButton.setPreferredSize(new java.awt.Dimension(72, 6));
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        background.add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 200, 44, 43));

        buttonSelect.setBackground(new java.awt.Color(70, 127, 208));

        labelSelect.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        labelSelect.setForeground(new java.awt.Color(255, 255, 255));
        labelSelect.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSelect.setText("Seleccionar");
        labelSelect.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        javax.swing.GroupLayout buttonSelectLayout = new javax.swing.GroupLayout(buttonSelect);
        buttonSelect.setLayout(buttonSelectLayout);
        buttonSelectLayout.setHorizontalGroup(
            buttonSelectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelSelect, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        buttonSelectLayout.setVerticalGroup(
            buttonSelectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelSelect, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        background.add(buttonSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 310, 130, 40));

        panelModifyDataGames.setBackground(new java.awt.Color(255, 255, 255));
        panelModifyDataGames.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelModifyData.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        labelModifyData.setText("Cambiar datos");

        labelName.setText("Nombre");

        textFieldNameGame.setEditable(false);
        textFieldNameGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNameGameActionPerformed(evt);
            }
        });

        labelCategory.setText("Categoria");

        optionsCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Action", "Adventure", "RPG", "Sports", "Strategy" }));
        optionsCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionsCategoryActionPerformed(evt);
            }
        });

        labelPlatform.setText("Plataforma");

        optionsPlatform.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PC", "PS4", "PS5", "XBOX", "Switch" }));

        labelAudience.setText("Audiencia");

        optionsAudience.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3+", "7+", "12+", "16+", "18+" }));

        labelDeveloper.setText("Proveedor");

        optionsDeveloper.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Electronic Arts", "Ubisoft", "Activision", "Nintendo", "Sony Interactive" }));

        labelPrice.setText("Precio");

        labelPassword.setText("Contraseña");

        buttonSaveChanges.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(70, 127, 208), 2));

        labelSave.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        labelSave.setForeground(new java.awt.Color(70, 127, 208));
        labelSave.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSave.setText("Guardar");
        labelSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelSaveMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelSaveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelSaveMouseExited(evt);
            }
        });

        javax.swing.GroupLayout buttonSaveChangesLayout = new javax.swing.GroupLayout(buttonSaveChanges);
        buttonSaveChanges.setLayout(buttonSaveChangesLayout);
        buttonSaveChangesLayout.setHorizontalGroup(
            buttonSaveChangesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelSave, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );
        buttonSaveChangesLayout.setVerticalGroup(
            buttonSaveChangesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelSave, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout panelModifyDataGamesLayout = new javax.swing.GroupLayout(panelModifyDataGames);
        panelModifyDataGames.setLayout(panelModifyDataGamesLayout);
        panelModifyDataGamesLayout.setHorizontalGroup(
            panelModifyDataGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModifyDataGamesLayout.createSequentialGroup()
                .addGroup(panelModifyDataGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelModifyDataGamesLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(panelModifyDataGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelModifyDataGamesLayout.createSequentialGroup()
                                .addGroup(panelModifyDataGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelModifyDataGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(labelAudience)
                                        .addComponent(labelPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(labelPrice)
                                        .addComponent(labelDeveloper, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelPlatform, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(labelCategory, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelModifyDataGamesLayout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(labelName, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(panelModifyDataGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textFieldNameGame)
                                    .addComponent(optionsCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(optionsPlatform, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(optionsDeveloper, 0, 233, Short.MAX_VALUE)
                                    .addComponent(optionsAudience, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textFieldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(passwordAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)))
                            .addComponent(labelModifyData, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(panelModifyDataGamesLayout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(buttonSaveChanges, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        panelModifyDataGamesLayout.setVerticalGroup(
            panelModifyDataGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModifyDataGamesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(labelModifyData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelModifyDataGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldNameGame, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelName))
                .addGap(30, 30, 30)
                .addGroup(panelModifyDataGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(optionsCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCategory))
                .addGap(28, 28, 28)
                .addGroup(panelModifyDataGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(optionsPlatform, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPlatform))
                .addGap(28, 28, 28)
                .addGroup(panelModifyDataGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(optionsAudience, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelAudience))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(panelModifyDataGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(optionsDeveloper, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDeveloper))
                .addGap(28, 28, 28)
                .addGroup(panelModifyDataGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPrice))
                .addGap(31, 31, 31)
                .addGroup(panelModifyDataGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPassword))
                .addGap(29, 29, 29)
                .addComponent(buttonSaveChanges, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        background.add(panelModifyDataGames, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 250, 430, 590));

        panelAddKey.setBackground(new java.awt.Color(255, 255, 255));
        panelAddKey.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelAddkey.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        labelAddkey.setText("Agregar KEY");

        labelKey.setText("KEY");

        textFieldKey.setText("xxxxxxxxxxxxxxxx");
        textFieldKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldKeyActionPerformed(evt);
            }
        });

        buttonAddKey.setBackground(new java.awt.Color(240, 173, 78));

        labelAdd.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        labelAdd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAdd.setText("Agregar");
        labelAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelAddMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelAddMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelAddMouseExited(evt);
            }
        });

        javax.swing.GroupLayout buttonAddKeyLayout = new javax.swing.GroupLayout(buttonAddKey);
        buttonAddKey.setLayout(buttonAddKeyLayout);
        buttonAddKeyLayout.setHorizontalGroup(
            buttonAddKeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
        );
        buttonAddKeyLayout.setVerticalGroup(
            buttonAddKeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jSeparator2.setForeground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout panelAddKeyLayout = new javax.swing.GroupLayout(panelAddKey);
        panelAddKey.setLayout(panelAddKeyLayout);
        panelAddKeyLayout.setHorizontalGroup(
            panelAddKeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddKeyLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panelAddKeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelAddkey)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAddKeyLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelAddKeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAddKeyLayout.createSequentialGroup()
                        .addComponent(labelKey, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldKey, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAddKeyLayout.createSequentialGroup()
                        .addComponent(buttonAddKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128))))
        );
        panelAddKeyLayout.setVerticalGroup(
            panelAddKeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddKeyLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(labelAddkey)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAddKeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelKey)
                    .addComponent(textFieldKey, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(buttonAddKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        background.add(panelAddKey, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 850, 430, 160));

        labelGames.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        labelGames.setText("Juegos");
        background.add(labelGames, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

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
            .addComponent(labelRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        buttonRefreshLayout.setVerticalGroup(
            buttonRefreshLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        background.add(buttonRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 150, 40));

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
        superDriver.loadAllGames(tableGames, superDriver.filterSearchGames(this.textFieldGame.getText()));
    }//GEN-LAST:event_searchButtonActionPerformed
    public void clearTable(){
        DefaultTableModel data = (DefaultTableModel) this.tableGames.getModel();
        int n = tableGames.getRowCount() - 1;
        for (int i = n; i >= 0; i--) {
            data.removeRow(this.tableGames.getRowCount() - 1);
        }
        clearFields();
    }
    private void salesRecordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesRecordButtonActionPerformed
        this.setVisible(false);
        SuperUser su = new SuperUser();
       su.setVisible(true);
    }//GEN-LAST:event_salesRecordButtonActionPerformed

    private void usertsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usertsButtonActionPerformed
        this.setVisible(false);
        UserAdministrator us = new UserAdministrator();
        us.setVisible(true);
    }//GEN-LAST:event_usertsButtonActionPerformed

    private void gamesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gamesButtonActionPerformed
       
    }//GEN-LAST:event_gamesButtonActionPerformed

    private void textFieldGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldGameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldGameActionPerformed

    private void optionsCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionsCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_optionsCategoryActionPerformed

    private void textFieldNameGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNameGameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldNameGameActionPerformed

    private void textFieldKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldKeyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldKeyActionPerformed

    private void labelRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRefreshMouseClicked
        clearTable();
        superDriver.loadAllGames(tableGames, superDriver.getAllGames());
    }//GEN-LAST:event_labelRefreshMouseClicked

    private void labelSelectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSelectMouseClicked
        int x = this.tableGames.getSelectedRow();
        if(x!=-1){
        String gameName = (String) this.tableGames.getValueAt(x, 0);
        superDriver.putTextFieldBox(arrayLabel, arrayBox, superDriver.gameSelected(gameName));
        }
    }//GEN-LAST:event_labelSelectMouseClicked

    private void labelSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSaveMouseClicked
        if(this.passwordAdmin.getText().equals("Admin123")){
            superDriver.changeGameData(arrayLabel, arrayBox);
            JOptionPane.showMessageDialog(null, "Cambios realizados correctamente", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else{
            JOptionPane.showMessageDialog(null, "Acción denegada", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        clearFields();
    }//GEN-LAST:event_labelSaveMouseClicked

    private void labelAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAddMouseClicked
        int x = this.tableGames.getSelectedRow();
        String gameName = (String) this.tableGames.getValueAt(x, 0);
        
        if(this.passwordAdmin.getText().equals("Admin123")){
            superDriver.addGameKey(this.textFieldKey,gameName);
            JOptionPane.showMessageDialog(null, "Clave añadida correctamente", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else{
            JOptionPane.showMessageDialog(null, "Acción denegada", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        clearFields();
        this.textFieldKey.setText("xxxxxxxxxxxxxxxx");
    }//GEN-LAST:event_labelAddMouseClicked

    private void labelRefreshMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRefreshMouseEntered
        this.buttonRefresh.setBackground(new Color(51,107,188));
    }//GEN-LAST:event_labelRefreshMouseEntered

    private void labelRefreshMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRefreshMouseExited
        this.buttonRefresh.setBackground(new Color(70,127,208));
    }//GEN-LAST:event_labelRefreshMouseExited

    private void labelSelectMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSelectMouseEntered
        this.buttonSelect.setBackground(new Color(51,107,188));
    }//GEN-LAST:event_labelSelectMouseEntered

    private void labelSelectMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSelectMouseExited
        this.buttonSelect.setBackground(new Color(70,127,208));
    }//GEN-LAST:event_labelSelectMouseExited

    private void labelSaveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSaveMouseEntered
        this.buttonSaveChanges.setBackground(new Color(51,107,188));
        this.labelSave.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_labelSaveMouseEntered

    private void labelSaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSaveMouseExited
        this.buttonSaveChanges.setBackground(new Color(242,242,242));
        this.labelSave.setForeground(new Color(70,127,208));
    }//GEN-LAST:event_labelSaveMouseExited

    private void labelAddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAddMouseEntered
        this.buttonAddKey.setBackground(new Color(207, 172, 74));
    }//GEN-LAST:event_labelAddMouseEntered

    private void labelAddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAddMouseExited
        this.buttonAddKey.setBackground(new Color(240,173,78));
    }//GEN-LAST:event_labelAddMouseExited

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
        arrayBox[0].setSelectedIndex(0);
        arrayBox[1].setSelectedIndex(0);
        arrayBox[2].setSelectedIndex(0);
        arrayBox[3].setSelectedIndex(0);
        arrayLabel[0].setText("");
        arrayLabel[1].setText("");
        this.passwordAdmin.setText("");
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameAdministrator().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JPanel buttonAddKey;
    private javax.swing.JPanel buttonFailedSales1;
    private javax.swing.JPanel buttonRefresh;
    private javax.swing.JPanel buttonSaveChanges;
    private javax.swing.JPanel buttonSelect;
    private javax.swing.JButton gamesButton;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelAdd;
    private javax.swing.JLabel labelAddkey;
    private javax.swing.JLabel labelAudience;
    private javax.swing.JLabel labelCategory;
    private javax.swing.JLabel labelDeveloper;
    private javax.swing.JLabel labelFailedSales1;
    private javax.swing.JLabel labelGames;
    private javax.swing.JLabel labelKey;
    private javax.swing.JLabel labelModifyData;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labelPlatform;
    private javax.swing.JLabel labelPrice;
    private javax.swing.JLabel labelRefresh;
    private javax.swing.JLabel labelSave;
    private javax.swing.JLabel labelSelect;
    private javax.swing.JLabel logPage;
    private javax.swing.JComboBox<String> optionsAudience;
    private javax.swing.JComboBox<String> optionsCategory;
    private javax.swing.JComboBox<String> optionsDeveloper;
    private javax.swing.JComboBox<String> optionsPlatform;
    private javax.swing.JPanel panelAddKey;
    private javax.swing.JPanel panelModifyDataGames;
    private javax.swing.JPasswordField passwordAdmin;
    private javax.swing.JButton salesRecordButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTable tableGames;
    private javax.swing.JTextField textFieldGame;
    private javax.swing.JTextField textFieldKey;
    private javax.swing.JTextField textFieldNameGame;
    private javax.swing.JTextField textFieldPrice;
    private javax.swing.JPanel topBlackBarPanel;
    private javax.swing.JButton usertsButton;
    // End of variables declaration//GEN-END:variables
}
