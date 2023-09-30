/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;



import databaseConnection.CLogin;
import databaseConnection.ConnectionSQL;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import logic.ShowGamesPage;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import logic.GetUserName;
import logic.ShowGamesPage;

public class HomePage extends javax.swing.JFrame {

    private Connection connection;
    private ShowGamesPage gamesOnPage;
    private int currentPage;
    private int pageSize;
    private int MainPage;
    private int Topgame;
    private int price;
    private int pricetop;
    
    private JLabel[] discounts;
    private JLabel[] gameLabels;
    private JLabel[] Top;
    private JButton[] prices;
    private JButton[] pricestop;
   //private imagen icono;
    private ImageIcon imagen;
    private Icon icono;
    private int userId;
    
    public HomePage(int IdUser) {
        initComponents();
        this.setLocationRelativeTo(this);
        userId = IdUser;
        GetUserName get = new GetUserName();
        String userName = get.GetUserName(userId);
        System.out.println(userName);
        jLabel1.setText(userName);

        ConnectionSQL conn = new ConnectionSQL();
        connection = conn.getConnection();
        this.pintarImagen(this.coverImage1, "src/imgGameStoreCaratule/GTAV_image.jpg");
        this.pintarImagen(this.coverImage2, "src/imgGameStoreCaratule/HaloInfinite_image.jpeg");
        this.pintarImagen(this.coverImage11, "src/imgGameStoreCaratule/Fortnite_image.jpg");
        this.pintarImagen(this.coverImage14, "src/imgGameStoreCaratule/StarWarsJedi_image.jpg");
        this.pintarImagen(this.coverImage3, "src/imgGameStoreCaratule/CODWarzone_image.jpg");
        
        this.pintarImagen(this.coverImage4, "src/imgGameStoreCaratule/Minecraft_image.png");
        this.pintarImagen(this.coverImage5, "src/imgGameStoreCaratule/MarvelSpiderManMilesM_image.jpg");
        this.pintarImagen(this.coverImage12, "src/imgGameStoreCaratule/RedDeadRedemption_image.jpg");
        this.pintarImagen(this.coverImage15, "src/imgGameStoreCaratule/MortalKombat11_image.jpeg");
        this.pintarImagen(this.coverImage6, "src/imgGameStoreCaratule/Fifa_image.jpeg");
        
        //pagina actual
        currentPage = 1;
        //Asignar valores de porcentges de descuentos a los labels
        
        
        MainPage = 5;
        discounts = new JLabel[MainPage];
        discounts[0] = Oferta1;
        discounts[1] = Oferta2;
        discounts[2] = Oferta3;
        discounts[3] = Oferta4;
        discounts[4] = Oferta5;
        
        
        // Asignar nombres de juegos en ofertas a los labels 
        
        pageSize = 5;
        gameLabels = new JLabel[pageSize];
        gameLabels[0] = titleGame1;
        gameLabels[1] = titleGame2;
        gameLabels[2] = titleGame3;
        gameLabels[3] = titleGame7;
        gameLabels[4] = titleGame10;
        
        Topgame = 5;
        Top = new JLabel[Topgame];

        
        Top[0] = titleGame6;
        Top[1] = titleGame4;
        Top[2] = titleGame8;
        Top[3] = titleGame9;
        Top[4] = titleGame5;
        
      
        price = 5;
        prices = new JButton[price];
        initializePrices();
        updateDataLabelsprice();
        
        pricetop = 5;
        pricestop = new JButton[pricetop];
        initializePricesTop();
        updateDataLabelstopgameprice();  
       
        updateDataLabels();
        updateDataLabelsPercentages();
        updateDataLabelstopgame();
        configureClickableLabel(Catalogo);

    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        topBlackBarPanel = new javax.swing.JPanel();
        serchBox = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        logPage = new javax.swing.JLabel();
        Catalogo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblImagen1 = new javax.swing.JLabel();
        areaCaratule10 = new javax.swing.JPanel();
        panelCaratule1 = new javax.swing.JPanel();
        Oferta1 = new javax.swing.JLabel();
        titleGame1 = new javax.swing.JLabel();
        coverImage1 = new javax.swing.JLabel();
        priceBoton1 = new javax.swing.JButton();
        panelCaratule4 = new javax.swing.JPanel();
        titleGame4 = new javax.swing.JLabel();
        coverImage4 = new javax.swing.JLabel();
        priceBoton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        areaCaratule2 = new javax.swing.JPanel();
        panelCaratule2 = new javax.swing.JPanel();
        Oferta2 = new javax.swing.JLabel();
        coverImage2 = new javax.swing.JLabel();
        priceBoton2 = new javax.swing.JButton();
        titleGame2 = new javax.swing.JLabel();
        panelCaratule5 = new javax.swing.JPanel();
        priceBoton5 = new javax.swing.JButton();
        titleGame5 = new javax.swing.JLabel();
        coverImage5 = new javax.swing.JLabel();
        areaCaratule1 = new javax.swing.JPanel();
        panelCaratule11 = new javax.swing.JPanel();
        Oferta3 = new javax.swing.JLabel();
        coverImage11 = new javax.swing.JLabel();
        priceBoton11 = new javax.swing.JButton();
        titleGame7 = new javax.swing.JLabel();
        panelCaratule12 = new javax.swing.JPanel();
        coverImage12 = new javax.swing.JLabel();
        priceBoton12 = new javax.swing.JButton();
        titleGame8 = new javax.swing.JLabel();
        areaCaratule3 = new javax.swing.JPanel();
        panelCaratule14 = new javax.swing.JPanel();
        Oferta4 = new javax.swing.JLabel();
        coverImage14 = new javax.swing.JLabel();
        priceBoton14 = new javax.swing.JButton();
        titleGame10 = new javax.swing.JLabel();
        panelCaratule15 = new javax.swing.JPanel();
        titleGame9 = new javax.swing.JLabel();
        coverImage15 = new javax.swing.JLabel();
        priceBoton15 = new javax.swing.JButton();
        areaCaratule = new javax.swing.JPanel();
        panelCaratule3 = new javax.swing.JPanel();
        Oferta5 = new javax.swing.JLabel();
        coverImage3 = new javax.swing.JLabel();
        priceBoton3 = new javax.swing.JButton();
        titleGame3 = new javax.swing.JLabel();
        panelCaratule6 = new javax.swing.JPanel();
        coverImage6 = new javax.swing.JLabel();
        priceBoton6 = new javax.swing.JButton();
        titleGame6 = new javax.swing.JLabel();
        JuegoOfertas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setForeground(new java.awt.Color(204, 0, 0));
        background.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        background.setMinimumSize(new java.awt.Dimension(1920, 1040));
        background.setPreferredSize(new java.awt.Dimension(1920, 1080));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        topBlackBarPanel.setBackground(new java.awt.Color(0, 0, 0));
        topBlackBarPanel.setPreferredSize(new java.awt.Dimension(1920, 123));
        topBlackBarPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        serchBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serchBoxActionPerformed(evt);
            }
        });
        topBlackBarPanel.add(serchBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(1460, 40, 204, 43));

        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgGameStore/icon/lupa.png"))); // NOI18N
        searchButton.setPreferredSize(new java.awt.Dimension(72, 6));
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        topBlackBarPanel.add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1690, 40, 44, 43));

        logPage.setFont(new java.awt.Font("Liberation Sans", 1, 60)); // NOI18N
        logPage.setForeground(new java.awt.Color(255, 255, 255));
        logPage.setText("GAME ON");
        topBlackBarPanel.add(logPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 32, 326, 61));

        Catalogo.setForeground(new java.awt.Color(255, 255, 255));
        Catalogo.setText("Mostrar Catalogo De Juegos");
        topBlackBarPanel.add(Catalogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 270, 30));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("USUARIO");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        lblImagen1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgGameStore/icon/fotor_2023-6-3_23_14_9.png"))); // NOI18N
        lblImagen1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImagen1MouseClicked(evt);
            }
        });
        jPanel2.add(lblImagen1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 90, 80));

        topBlackBarPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1770, 10, 140, 110));

        background.add(topBlackBarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, -1));

        areaCaratule10.setBackground(new java.awt.Color(255, 255, 255));
        areaCaratule10.setPreferredSize(new java.awt.Dimension(1558, 734));
        areaCaratule10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCaratule1.setBackground(new java.awt.Color(153, 153, 153));
        panelCaratule1.setPreferredSize(new java.awt.Dimension(492, 218));
        panelCaratule1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Oferta1.setBackground(new java.awt.Color(0, 0, 0));
        Oferta1.setFont(new java.awt.Font("Noto Sans Mono CJK HK", 1, 24)); // NOI18N
        Oferta1.setForeground(new java.awt.Color(204, 0, 0));
        Oferta1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Oferta1.setOpaque(true);
        panelCaratule1.add(Oferta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 80, 30));
        panelCaratule1.add(titleGame1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 253, 32));
        panelCaratule1.add(coverImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 165));

        priceBoton1.setBackground(new java.awt.Color(0, 51, 102));
        priceBoton1.setForeground(new java.awt.Color(255, 255, 255));
        priceBoton1.setText("----");
        priceBoton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceBoton1ActionPerformed(evt);
            }
        });
        panelCaratule1.add(priceBoton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 100, 36));

        areaCaratule10.add(panelCaratule1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 16, 359, 210));

        panelCaratule4.setBackground(new java.awt.Color(153, 153, 153));
        panelCaratule4.setPreferredSize(new java.awt.Dimension(492, 218));
        panelCaratule4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelCaratule4.add(titleGame4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 171, 251, 36));
        panelCaratule4.add(coverImage4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 359, 165));

        priceBoton4.setBackground(new java.awt.Color(0, 51, 102));
        priceBoton4.setForeground(new java.awt.Color(255, 255, 255));
        priceBoton4.setText("----");
        priceBoton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceBoton4ActionPerformed(evt);
            }
        });
        panelCaratule4.add(priceBoton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 171, 100, 36));

        areaCaratule10.add(panelCaratule4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 359, 210));

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel2.setText("TOP JUEGOS MAS BUSCADOS");
        areaCaratule10.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 280, -1));

        background.add(areaCaratule10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 400, -1));

        areaCaratule2.setBackground(new java.awt.Color(255, 255, 255));
        areaCaratule2.setPreferredSize(new java.awt.Dimension(1558, 734));
        areaCaratule2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCaratule2.setBackground(new java.awt.Color(153, 153, 153));
        panelCaratule2.setPreferredSize(new java.awt.Dimension(492, 218));
        panelCaratule2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Oferta2.setBackground(new java.awt.Color(0, 0, 0));
        Oferta2.setFont(new java.awt.Font("Noto Sans Mono CJK HK", 1, 24)); // NOI18N
        Oferta2.setForeground(new java.awt.Color(204, 0, 0));
        Oferta2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Oferta2.setOpaque(true);
        panelCaratule2.add(Oferta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 80, 30));
        panelCaratule2.add(coverImage2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 165));

        priceBoton2.setBackground(new java.awt.Color(0, 51, 102));
        priceBoton2.setForeground(new java.awt.Color(255, 255, 255));
        priceBoton2.setText("----");
        priceBoton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceBoton2ActionPerformed(evt);
            }
        });
        panelCaratule2.add(priceBoton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 171, 100, 36));
        panelCaratule2.add(titleGame2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 171, 251, 36));

        areaCaratule2.add(panelCaratule2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 359, 210));

        panelCaratule5.setBackground(new java.awt.Color(153, 153, 153));
        panelCaratule5.setPreferredSize(new java.awt.Dimension(492, 218));
        panelCaratule5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        priceBoton5.setBackground(new java.awt.Color(0, 51, 102));
        priceBoton5.setForeground(new java.awt.Color(255, 255, 255));
        priceBoton5.setText("----");
        priceBoton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceBoton5ActionPerformed(evt);
            }
        });
        panelCaratule5.add(priceBoton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 171, 100, 36));
        panelCaratule5.add(titleGame5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 171, 251, 36));
        panelCaratule5.add(coverImage5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 359, 165));

        areaCaratule2.add(panelCaratule5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 359, 210));

        background.add(areaCaratule2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 400, 730));

        areaCaratule1.setBackground(new java.awt.Color(255, 255, 255));
        areaCaratule1.setPreferredSize(new java.awt.Dimension(1558, 734));
        areaCaratule1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCaratule11.setBackground(new java.awt.Color(153, 153, 153));
        panelCaratule11.setPreferredSize(new java.awt.Dimension(492, 218));
        panelCaratule11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Oferta3.setBackground(new java.awt.Color(0, 0, 0));
        Oferta3.setFont(new java.awt.Font("Noto Sans Mono CJK HK", 1, 24)); // NOI18N
        Oferta3.setForeground(new java.awt.Color(204, 0, 0));
        Oferta3.setOpaque(true);
        panelCaratule11.add(Oferta3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 80, 30));
        panelCaratule11.add(coverImage11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 165));

        priceBoton11.setBackground(new java.awt.Color(0, 51, 102));
        priceBoton11.setForeground(new java.awt.Color(255, 255, 255));
        priceBoton11.setText("----");
        priceBoton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceBoton11ActionPerformed(evt);
            }
        });
        panelCaratule11.add(priceBoton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 100, 36));
        panelCaratule11.add(titleGame7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 171, 251, 36));

        areaCaratule1.add(panelCaratule11, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 16, 359, 210));

        panelCaratule12.setBackground(new java.awt.Color(153, 153, 153));
        panelCaratule12.setPreferredSize(new java.awt.Dimension(492, 218));
        panelCaratule12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelCaratule12.add(coverImage12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 359, 165));

        priceBoton12.setBackground(new java.awt.Color(0, 51, 102));
        priceBoton12.setForeground(new java.awt.Color(255, 255, 255));
        priceBoton12.setText("----");
        priceBoton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceBoton12ActionPerformed(evt);
            }
        });
        panelCaratule12.add(priceBoton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 171, 100, 36));
        panelCaratule12.add(titleGame8, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 171, 251, 36));

        areaCaratule1.add(panelCaratule12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 359, 210));

        background.add(areaCaratule1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 160, 400, -1));

        areaCaratule3.setBackground(new java.awt.Color(255, 255, 255));
        areaCaratule3.setPreferredSize(new java.awt.Dimension(1558, 734));
        areaCaratule3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCaratule14.setBackground(new java.awt.Color(153, 153, 153));
        panelCaratule14.setPreferredSize(new java.awt.Dimension(492, 218));
        panelCaratule14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Oferta4.setBackground(new java.awt.Color(0, 0, 0));
        Oferta4.setFont(new java.awt.Font("Noto Sans CJK HK", 1, 24)); // NOI18N
        Oferta4.setForeground(new java.awt.Color(204, 0, 0));
        Oferta4.setOpaque(true);
        panelCaratule14.add(Oferta4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 80, 30));
        panelCaratule14.add(coverImage14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 165));

        priceBoton14.setBackground(new java.awt.Color(0, 51, 102));
        priceBoton14.setForeground(new java.awt.Color(255, 255, 255));
        priceBoton14.setText("----");
        priceBoton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceBoton14ActionPerformed(evt);
            }
        });
        panelCaratule14.add(priceBoton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 100, 36));
        panelCaratule14.add(titleGame10, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 171, 251, 36));

        areaCaratule3.add(panelCaratule14, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 16, 359, 210));

        panelCaratule15.setBackground(new java.awt.Color(153, 153, 153));
        panelCaratule15.setPreferredSize(new java.awt.Dimension(492, 218));
        panelCaratule15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleGame9.setBackground(new java.awt.Color(60, 65, 63));
        panelCaratule15.add(titleGame9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 240, 40));
        panelCaratule15.add(coverImage15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1, 360, 170));

        priceBoton15.setBackground(new java.awt.Color(0, 51, 102));
        priceBoton15.setForeground(new java.awt.Color(255, 255, 255));
        priceBoton15.setText("----");
        priceBoton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceBoton15ActionPerformed(evt);
            }
        });
        panelCaratule15.add(priceBoton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 100, 36));

        areaCaratule3.add(panelCaratule15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 359, 210));

        background.add(areaCaratule3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 160, 400, -1));

        areaCaratule.setBackground(new java.awt.Color(255, 255, 255));
        areaCaratule.setPreferredSize(new java.awt.Dimension(1558, 734));
        areaCaratule.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCaratule3.setBackground(new java.awt.Color(153, 153, 153));
        panelCaratule3.setPreferredSize(new java.awt.Dimension(492, 218));
        panelCaratule3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Oferta5.setBackground(new java.awt.Color(0, 0, 0));
        Oferta5.setFont(new java.awt.Font("Noto Sans Mono CJK HK", 1, 24)); // NOI18N
        Oferta5.setForeground(new java.awt.Color(255, 0, 0));
        Oferta5.setOpaque(true);
        panelCaratule3.add(Oferta5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 80, 30));
        panelCaratule3.add(coverImage3, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 0, 300, 165));

        priceBoton3.setBackground(new java.awt.Color(0, 51, 102));
        priceBoton3.setForeground(new java.awt.Color(255, 255, 255));
        priceBoton3.setText("----");
        priceBoton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceBoton3ActionPerformed(evt);
            }
        });
        panelCaratule3.add(priceBoton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 100, 36));
        panelCaratule3.add(titleGame3, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 171, 190, 36));

        areaCaratule.add(panelCaratule3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 16, 359, 210));

        panelCaratule6.setBackground(new java.awt.Color(153, 153, 153));
        panelCaratule6.setPreferredSize(new java.awt.Dimension(492, 218));
        panelCaratule6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelCaratule6.add(coverImage6, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 0, 300, 165));

        priceBoton6.setBackground(new java.awt.Color(0, 51, 102));
        priceBoton6.setForeground(new java.awt.Color(255, 255, 255));
        priceBoton6.setText("----");
        priceBoton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceBoton6ActionPerformed(evt);
            }
        });
        panelCaratule6.add(priceBoton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 171, 100, 36));
        panelCaratule6.add(titleGame6, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 171, 196, 36));

        areaCaratule.add(panelCaratule6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 359, 210));

        background.add(areaCaratule, new org.netbeans.lib.awtextra.AbsoluteConstraints(1530, 160, 400, -1));

        JuegoOfertas.setBackground(new java.awt.Color(0, 0, 0));
        JuegoOfertas.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        JuegoOfertas.setText("JUEGOS EN OFERTAS");
        background.add(JuegoOfertas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 210, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 1087, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     
    private static Pagination pagination;
    
    private static void configureClickableLabel(JLabel label) {
        label.setForeground(Color.WHITE);
        label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Cerrar el JFrame
              JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(label);
                currentFrame.dispose();
                String selectedGameName = label.getText();
                // Acciones cuando se hace clic en el JLabel   
               if (pagination == null) {
                pagination = new Pagination(CLogin.userId);
                pagination.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                pagination.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        pagination = null; // Restablecer la variable gamePage a null
                    }
                });

                pagination.setVisible(true);
            }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // Cambiar el color del JLabel cuando el ratón entra en él
                label.setForeground(Color.BLUE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Restaurar el color del JLabel cuando el ratón sale de él
                label.setForeground(Color.WHITE);
            }
        });
    
    }
    private static GamePage gamePage;
    
    private static void configureClickableLabel1(JLabel label) {
        label.setForeground(Color.BLACK);
        label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Cerrar el JFrame
              JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(label);
                currentFrame.dispose();
                String selectedGameName = label.getText();
                // Acciones cuando se hace clic en el JLabel   
               if (gamePage == null) {
                gamePage = new GamePage(selectedGameName);
                gamePage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                gamePage.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        gamePage = null; // Restablecer la variable gamePage a null
                    }
                });

                gamePage.setVisible(true);
            }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // Cambiar el color del JLabel cuando el ratón entra en él
                label.setForeground(Color.BLUE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Restaurar el color del JLabel cuando el ratón sale de él
                label.setForeground(Color.BLACK);
            }
        });
    
    }
  
    private void serchBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serchBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_serchBoxActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
         
    }                                            

    private void priceBoton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceBoton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceBoton1ActionPerformed

    private void priceBoton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceBoton15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceBoton15ActionPerformed

    private void priceBoton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceBoton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceBoton2ActionPerformed

    private void priceBoton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceBoton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceBoton11ActionPerformed

    private void priceBoton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceBoton14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceBoton14ActionPerformed

    private void priceBoton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceBoton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceBoton3ActionPerformed

    private void priceBoton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceBoton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceBoton5ActionPerformed

    private void priceBoton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceBoton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceBoton4ActionPerformed

    private void priceBoton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceBoton12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceBoton12ActionPerformed

    private void priceBoton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceBoton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceBoton6ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        UserProfile userProf = new UserProfile(this.userId);
        this.dispose();
        userProf.setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void lblImagen1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImagen1MouseClicked
        UserProfile userProf = new UserProfile(this.userId);
        this.dispose();
        userProf.setVisible(true);
    }//GEN-LAST:event_lblImagen1MouseClicked


    private List<String> getDataFromDatabase() {
    List<String> data = new ArrayList<>();

    try {
        int startIndex = (currentPage - 1) * pageSize;
       // int endIndex = startIndex + pageSize;

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT o.GameID, g.Name FROM Offers o JOIN Games g ON o.GameID = g.IDGame LIMIT " + startIndex + ", " + pageSize);

        while (resultSet.next()) {
            String gameName = resultSet.getString("Name");
            data.add(gameName);
        }

        resultSet.close();
        statement.close();
    } catch (SQLException e) {
        e.printStackTrace();
        }
        return data;
    }
    
    private void updateDataLabels() {
        List<String> data = getDataFromDatabase();

        for (int i = 0; i < pageSize; i++) {
            if (i < data.size()) {
                gameLabels[i].setText(data.get(i));
                configureClickableLabel1(gameLabels[i]);
            } else {
                gameLabels[i].setText("");
                configureClickableLabel1(gameLabels[i]);
            }
        }
    }
    
 private List<String> getDataFromDatabaseprice() {
    List<String> data = new ArrayList<>();

    try {
        int startIndex = (currentPage - 1) * price;

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT o.GameID, g.Price FROM Offers o JOIN Games g ON o.GameID = g.IDGame LIMIT " + startIndex + ", " + price);

        while (resultSet.next()) {
            String gamePrice = resultSet.getString("Price");
            data.add(gamePrice);
        }

        resultSet.close();
        statement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return data;
}
    private void updateDataLabelsprice() {
        List<String> data = getDataFromDatabaseprice();

        for (int i = 0; i < price; i++) {
            if (i < data.size()) {
                prices[i].setText(data.get(i)+" Bs");
            } else {
                prices[i].setText("");
            }
        }
    }
    
    private void initializePrices() {
    prices[0] = priceBoton1;
    prices[1] = priceBoton2;
    prices[2] = priceBoton11;
    prices[3] = priceBoton14;
    prices[4] = priceBoton3;
    
    // ... Asigna el resto de los botones a los elementos de la matriz prices
}
    
    //porcentaje
     private List<String> getdatafromdatabasePercentages() {
    List<String> data = new ArrayList<>();

    try {
        int startIndex = (currentPage - 1) * MainPage;
        int endIndex = startIndex + MainPage;

        Statement statement = connection.createStatement();
      
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Offers LIMIT " + startIndex + ", " + MainPage);

        while (resultSet.next()) {
            String value = resultSet.getString("PercentageDiscount");
            data.add(value);
            }

        resultSet.close();
        statement.close();
        } catch (SQLException e) {
                e.printStackTrace();
            }

    return data;
    }
     
     //Actualizar porcentajes
     private void updateDataLabelsPercentages() {
        List<String> data = getdatafromdatabasePercentages();

        for (int i = 0; i < MainPage; i++) {
            if (i < data.size()) {
                discounts[i].setText(data.get(i)+" %");
            } else {
                discounts[i].setText("");
            }
        }
    }
     //Topgames
    
    private List<String> databasetopgame() {
     List<String> data = new ArrayList<>();

    try {
        int startIndex = (currentPage - 1) * Topgame;
        int endIndex = startIndex + Topgame;

        Statement statement = connection.createStatement();
        ResultSet resulstSet = statement.executeQuery("SELECT o.GameID, g.Name FROM TopGames o JOIN Games g ON o.GameID = g.IDGame LIMIT " + startIndex + ", " + Topgame);

        while (resulstSet.next()) {
            String gameName = resulstSet.getString("Name");
            data.add(gameName);
        }

        resulstSet.close();
        statement.close();
    } catch (SQLException e) {
        e.printStackTrace();
        }
        return data;
    }
   
    private void updateDataLabelstopgame() {
        List<String> data = databasetopgame();

        for (int i = 0; i < Topgame; i++) {
            if (i < data.size()) {
                Top[i].setText(data.get(i));
                configureClickableLabel1(Top[i]);
               
            } else {
                Top[i].setText("");
               
            }
        }
    }
    
    private List<String> databasetopgameprice() {
     List<String> data = new ArrayList<>();

    try {
        int startIndex = (currentPage - 1) * pricetop;
        int endIndex = startIndex + pricetop;

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT o.GameID, g.Price FROM TopGames o JOIN Games g ON o.GameID = g.IDGame LIMIT " + startIndex + ", " + price);

        //ResultSet resulstSet = statement.executeQuery("SELECT o.GameID, g.Name FROM TopGames o JOIN Games g ON o.GameID = g.IDGame LIMIT " + startIndex + ", " + pageSize);

        while (resultSet.next()) {
            String gameName = resultSet.getString("Price");
            data.add(gameName);
        }

        resultSet.close();
        statement.close();
    } catch (SQLException e) {
        e.printStackTrace();
        }
        return data;
    }
    private void updateDataLabelstopgameprice() {
        List<String> data = databasetopgameprice();

        for (int i = 0; i < pricetop; i++) {
            if (i < data.size()) {
                pricestop[i].setText(data.get(i)+" Bs");
            } else {
                pricestop[i].setText("");
            }
        }
    }
    
    
    private void initializePricesTop() {
    
    pricestop[0] = priceBoton4;
    pricestop[1] = priceBoton5;
    pricestop[2] = priceBoton12;
    pricestop[3] = priceBoton15;
    pricestop[4] = priceBoton6;
    // ... Asigna el resto de los botones a los elementos de la matriz prices
}
    
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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });*/
    }
 
    private void pintarImagen(JLabel lbl, String ruta){
        this.imagen = new ImageIcon(ruta);
        this.icono = new ImageIcon(
                this.imagen.getImage().getScaledInstance(
                        lbl.getWidth(),
                        lbl.getHeight(),
                        Image.SCALE_DEFAULT)
        );
        lbl.setIcon(this.icono);
        this.repaint();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Catalogo;
    private javax.swing.JLabel JuegoOfertas;
    private javax.swing.JLabel Oferta1;
    private javax.swing.JLabel Oferta2;
    private javax.swing.JLabel Oferta3;
    private javax.swing.JLabel Oferta4;
    private javax.swing.JLabel Oferta5;
    private javax.swing.JPanel areaCaratule;
    private javax.swing.JPanel areaCaratule1;
    private javax.swing.JPanel areaCaratule10;
    private javax.swing.JPanel areaCaratule2;
    private javax.swing.JPanel areaCaratule3;
    private javax.swing.JPanel background;
    private javax.swing.JLabel coverImage1;
    private javax.swing.JLabel coverImage11;
    private javax.swing.JLabel coverImage12;
    private javax.swing.JLabel coverImage14;
    private javax.swing.JLabel coverImage15;
    private javax.swing.JLabel coverImage2;
    private javax.swing.JLabel coverImage3;
    private javax.swing.JLabel coverImage4;
    private javax.swing.JLabel coverImage5;
    private javax.swing.JLabel coverImage6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblImagen1;
    private javax.swing.JLabel logPage;
    private javax.swing.JPanel panelCaratule1;
    private javax.swing.JPanel panelCaratule11;
    private javax.swing.JPanel panelCaratule12;
    private javax.swing.JPanel panelCaratule14;
    private javax.swing.JPanel panelCaratule15;
    private javax.swing.JPanel panelCaratule2;
    private javax.swing.JPanel panelCaratule3;
    private javax.swing.JPanel panelCaratule4;
    private javax.swing.JPanel panelCaratule5;
    private javax.swing.JPanel panelCaratule6;
    private javax.swing.JButton priceBoton1;
    private javax.swing.JButton priceBoton11;
    private javax.swing.JButton priceBoton12;
    private javax.swing.JButton priceBoton14;
    private javax.swing.JButton priceBoton15;
    private javax.swing.JButton priceBoton2;
    private javax.swing.JButton priceBoton3;
    private javax.swing.JButton priceBoton4;
    private javax.swing.JButton priceBoton5;
    private javax.swing.JButton priceBoton6;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField serchBox;
    private javax.swing.JLabel titleGame1;
    private javax.swing.JLabel titleGame10;
    private javax.swing.JLabel titleGame2;
    private javax.swing.JLabel titleGame3;
    private javax.swing.JLabel titleGame4;
    private javax.swing.JLabel titleGame5;
    private javax.swing.JLabel titleGame6;
    private javax.swing.JLabel titleGame7;
    private javax.swing.JLabel titleGame8;
    private javax.swing.JLabel titleGame9;
    private javax.swing.JPanel topBlackBarPanel;
    // End of variables declaration//GEN-END:variables
}
