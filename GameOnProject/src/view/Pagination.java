package view;

import databaseConnection.CLogin;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import logic.ChangePage;
import logic.PutCovers;
import logic.ShowGamesPage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import logic.GetUserName;

public class Pagination extends javax.swing.JFrame {


    private ShowGamesPage gamesOnPage;
    private ChangePage cp;
    private int userId;
    private JPanel[] panels;
    public Pagination(int idUser) {
        initComponents();

        userId = idUser;
        GetUserName get = new GetUserName();
        String userName = get.GetUserName(userId);
        System.out.println(userName);
        jLabel1.setText(userName);

        this.setLocationRelativeTo(this);
        //--------------------------------------------------------------------
        gamesOnPage = new ShowGamesPage();
        JLabel[] images = {this.coverImage1, this.coverImage2, this.coverImage3, this.coverImage4, this.coverImage5, this.coverImage6,this.coverImage7, this.coverImage8,this.coverImage9};
        JLabel[] textTitle = {this.titleGame1, this.titleGame2, this.titleGame3, this.titleGame4, this.titleGame5, this.titleGame6, this.titleGame7, this.titleGame8, this.titleGame9};
        JButton[] buttons = {this.priceBoton1, this.priceBoton2,this.priceBoton3,this.priceBoton4,this.priceBoton5,this.priceBoton6,this.priceBoton7,this.priceBoton8,this.priceBoton9};
        panels = new JPanel[]{this.panelCaratule1,this.panelCaratule2,this.panelCaratule3,this.panelCaratule4,this.panelCaratule5,this.panelCaratule6,this.panelCaratule7,this.panelCaratule8,this.panelCaratule9};
        PutCovers putCover = new PutCovers(images, textTitle,buttons, panels,gamesOnPage.returnAllGames());
        putCover.putImageText(this);
        //----------------------------------------------------------------
        
        //-------------------------Jose Rodriguez-----------------------------------------------
        cp = new ChangePage(images,textTitle,panels,buttons,this);
        
        configureClickableLabel(Inicio);
    }
    
    private static HomePage homepage;
    
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
               if (homepage == null) {
                homepage = new HomePage(CLogin.userId);
                homepage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                homepage.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        homepage = null; // Restablecer la variable gamePage a null
                    }
                });

                homepage.setVisible(true);
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


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        topBlackBarPanel = new javax.swing.JPanel();
        serchBox = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        pcButton = new javax.swing.JButton();
        xboxButton = new javax.swing.JButton();
        nintendoSwitchButton = new javax.swing.JButton();
        playStationButton = new javax.swing.JButton();
        logPage = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblImagen1 = new javax.swing.JLabel();
        Inicio = new javax.swing.JLabel();
        areaCaratule = new javax.swing.JPanel();
        panelCaratule9 = new javax.swing.JPanel();
        coverImage9 = new javax.swing.JLabel();
        priceBoton9 = new javax.swing.JButton();
        titleGame9 = new javax.swing.JLabel();
        panelCaratule3 = new javax.swing.JPanel();
        coverImage3 = new javax.swing.JLabel();
        priceBoton3 = new javax.swing.JButton();
        titleGame3 = new javax.swing.JLabel();
        panelCaratule6 = new javax.swing.JPanel();
        coverImage6 = new javax.swing.JLabel();
        priceBoton6 = new javax.swing.JButton();
        titleGame6 = new javax.swing.JLabel();
        areaCaratule10 = new javax.swing.JPanel();
        panelCaratule7 = new javax.swing.JPanel();
        coverImage7 = new javax.swing.JLabel();
        priceBoton7 = new javax.swing.JButton();
        titleGame7 = new javax.swing.JLabel();
        panelCaratule1 = new javax.swing.JPanel();
        coverImage1 = new javax.swing.JLabel();
        priceBoton1 = new javax.swing.JButton();
        titleGame1 = new javax.swing.JLabel();
        panelCaratule4 = new javax.swing.JPanel();
        coverImage4 = new javax.swing.JLabel();
        priceBoton4 = new javax.swing.JButton();
        titleGame4 = new javax.swing.JLabel();
        areaCaratule2 = new javax.swing.JPanel();
        panelCaratule8 = new javax.swing.JPanel();
        coverImage8 = new javax.swing.JLabel();
        priceBoton8 = new javax.swing.JButton();
        titleGame8 = new javax.swing.JLabel();
        panelCaratule2 = new javax.swing.JPanel();
        coverImage2 = new javax.swing.JLabel();
        priceBoton2 = new javax.swing.JButton();
        titleGame2 = new javax.swing.JLabel();
        panelCaratule5 = new javax.swing.JPanel();
        coverImage5 = new javax.swing.JLabel();
        priceBoton5 = new javax.swing.JButton();
        titleGame5 = new javax.swing.JLabel();
        panelPaginationsBotons = new javax.swing.JPanel();
        paneGoBack = new javax.swing.JPanel();
        goBackPageTitle = new javax.swing.JTextField();
        goBackBoton = new javax.swing.JButton();
        goForwardPanel = new javax.swing.JPanel();
        goForwardTitle = new javax.swing.JTextField();
        goForwardBoton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 255, 204));
        setExtendedState(6);

        background.setBackground(new java.awt.Color(255, 255, 255));
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

        pcButton.setBackground(new java.awt.Color(59, 59, 59));
        pcButton.setForeground(new java.awt.Color(255, 255, 255));
        pcButton.setText("PC");
        pcButton.setPreferredSize(new java.awt.Dimension(158, 28));
        pcButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pcButtonActionPerformed(evt);
            }
        });
        topBlackBarPanel.add(pcButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(429, 76, -1, -1));

        xboxButton.setBackground(new java.awt.Color(59, 59, 59));
        xboxButton.setForeground(new java.awt.Color(255, 255, 255));
        xboxButton.setText("Xbox");
        xboxButton.setPreferredSize(new java.awt.Dimension(158, 28));
        xboxButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xboxButtonActionPerformed(evt);
            }
        });
        topBlackBarPanel.add(xboxButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(652, 76, -1, -1));

        nintendoSwitchButton.setBackground(new java.awt.Color(59, 59, 59));
        nintendoSwitchButton.setForeground(new java.awt.Color(255, 255, 255));
        nintendoSwitchButton.setText("Nintendo Switch");
        nintendoSwitchButton.setPreferredSize(new java.awt.Dimension(158, 28));
        nintendoSwitchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nintendoSwitchButtonActionPerformed(evt);
            }
        });
        topBlackBarPanel.add(nintendoSwitchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1087, 76, -1, -1));

        playStationButton.setBackground(new java.awt.Color(59, 59, 59));
        playStationButton.setForeground(new java.awt.Color(255, 255, 255));
        playStationButton.setText("PlayStation");
        playStationButton.setPreferredSize(new java.awt.Dimension(158, 28));
        playStationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playStationButtonActionPerformed(evt);
            }
        });
        topBlackBarPanel.add(playStationButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 76, -1, -1));

        logPage.setFont(new java.awt.Font("Liberation Sans", 1, 60)); // NOI18N
        logPage.setForeground(new java.awt.Color(255, 255, 255));
        logPage.setText("GAME ON");
        topBlackBarPanel.add(logPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 32, 326, 61));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(51, 255, 204));
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

        Inicio.setForeground(new java.awt.Color(255, 255, 255));
        Inicio.setText("Mostrar Pagina de Inicio");
        topBlackBarPanel.add(Inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 270, 30));

        background.add(topBlackBarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, -1));

        areaCaratule.setBackground(new java.awt.Color(255, 255, 255));
        areaCaratule.setPreferredSize(new java.awt.Dimension(1558, 734));
        areaCaratule.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCaratule9.setBackground(new java.awt.Color(153, 153, 153));
        panelCaratule9.setPreferredSize(new java.awt.Dimension(492, 218));
        panelCaratule9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelCaratule9.add(coverImage9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 359, 165));

        priceBoton9.setBackground(new java.awt.Color(0, 51, 102));
        priceBoton9.setForeground(new java.awt.Color(255, 255, 255));
        priceBoton9.setText("----");
        panelCaratule9.add(priceBoton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 100, 36));
        panelCaratule9.add(titleGame9, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 171, 251, 36));

        areaCaratule.add(panelCaratule9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 359, 210));

        panelCaratule3.setBackground(new java.awt.Color(153, 153, 153));
        panelCaratule3.setPreferredSize(new java.awt.Dimension(492, 218));
        panelCaratule3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelCaratule3.add(coverImage3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 359, 165));

        priceBoton3.setBackground(new java.awt.Color(0, 51, 102));
        priceBoton3.setForeground(new java.awt.Color(255, 255, 255));
        priceBoton3.setText("----");
        panelCaratule3.add(priceBoton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 100, 36));
        panelCaratule3.add(titleGame3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 171, 251, 36));

        areaCaratule.add(panelCaratule3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 16, 359, 210));

        panelCaratule6.setBackground(new java.awt.Color(153, 153, 153));
        panelCaratule6.setPreferredSize(new java.awt.Dimension(492, 218));
        panelCaratule6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelCaratule6.add(coverImage6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 359, 165));

        priceBoton6.setBackground(new java.awt.Color(0, 51, 102));
        priceBoton6.setForeground(new java.awt.Color(255, 255, 255));
        priceBoton6.setText("----");
        panelCaratule6.add(priceBoton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 100, 36));
        panelCaratule6.add(titleGame6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 171, 251, 36));

        areaCaratule.add(panelCaratule6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 359, 210));

        background.add(areaCaratule, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 160, 400, -1));

        areaCaratule10.setBackground(new java.awt.Color(255, 255, 255));
        areaCaratule10.setPreferredSize(new java.awt.Dimension(1558, 734));
        areaCaratule10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCaratule7.setBackground(new java.awt.Color(153, 153, 153));
        panelCaratule7.setPreferredSize(new java.awt.Dimension(492, 218));
        panelCaratule7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelCaratule7.add(coverImage7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 359, 165));

        priceBoton7.setBackground(new java.awt.Color(0, 51, 102));
        priceBoton7.setForeground(new java.awt.Color(255, 255, 255));
        priceBoton7.setText("----");
        panelCaratule7.add(priceBoton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 171, 100, 36));
        panelCaratule7.add(titleGame7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 171, 251, 36));

        areaCaratule10.add(panelCaratule7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 359, 210));

        panelCaratule1.setBackground(new java.awt.Color(153, 153, 153));
        panelCaratule1.setPreferredSize(new java.awt.Dimension(492, 218));
        panelCaratule1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelCaratule1.add(coverImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 359, 165));

        priceBoton1.setBackground(new java.awt.Color(0, 51, 102));
        priceBoton1.setForeground(new java.awt.Color(255, 255, 255));
        priceBoton1.setText("----");
        priceBoton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceBoton1ActionPerformed(evt);
            }
        });
        panelCaratule1.add(priceBoton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 171, 100, 36));
        panelCaratule1.add(titleGame1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 171, 251, 36));

        areaCaratule10.add(panelCaratule1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 16, 359, 210));

        panelCaratule4.setBackground(new java.awt.Color(153, 153, 153));
        panelCaratule4.setPreferredSize(new java.awt.Dimension(492, 218));
        panelCaratule4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelCaratule4.add(coverImage4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 165));

        priceBoton4.setBackground(new java.awt.Color(0, 51, 102));
        priceBoton4.setForeground(new java.awt.Color(255, 255, 255));
        priceBoton4.setText("----");
        panelCaratule4.add(priceBoton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 100, 36));
        panelCaratule4.add(titleGame4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 251, 36));

        areaCaratule10.add(panelCaratule4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 359, 210));

        background.add(areaCaratule10, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 400, -1));

        areaCaratule2.setBackground(new java.awt.Color(255, 255, 255));
        areaCaratule2.setPreferredSize(new java.awt.Dimension(1558, 734));
        areaCaratule2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCaratule8.setBackground(new java.awt.Color(153, 153, 153));
        panelCaratule8.setPreferredSize(new java.awt.Dimension(492, 218));
        panelCaratule8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelCaratule8.add(coverImage8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 359, 165));

        priceBoton8.setBackground(new java.awt.Color(0, 51, 102));
        priceBoton8.setForeground(new java.awt.Color(255, 255, 255));
        priceBoton8.setText("----");
        panelCaratule8.add(priceBoton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 100, 36));
        panelCaratule8.add(titleGame8, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 171, 251, 36));

        areaCaratule2.add(panelCaratule8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 359, 210));

        panelCaratule2.setBackground(new java.awt.Color(153, 153, 153));
        panelCaratule2.setPreferredSize(new java.awt.Dimension(492, 218));
        panelCaratule2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelCaratule2.add(coverImage2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 359, 165));

        priceBoton2.setBackground(new java.awt.Color(0, 51, 102));
        priceBoton2.setForeground(new java.awt.Color(255, 255, 255));
        priceBoton2.setText("----");
        panelCaratule2.add(priceBoton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 100, 36));
        panelCaratule2.add(titleGame2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 171, 251, 36));

        areaCaratule2.add(panelCaratule2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 16, 359, 210));

        panelCaratule5.setBackground(new java.awt.Color(153, 153, 153));
        panelCaratule5.setPreferredSize(new java.awt.Dimension(492, 218));
        panelCaratule5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelCaratule5.add(coverImage5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 359, 165));

        priceBoton5.setBackground(new java.awt.Color(0, 51, 102));
        priceBoton5.setForeground(new java.awt.Color(255, 255, 255));
        priceBoton5.setText("----");
        panelCaratule5.add(priceBoton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 171, 100, 36));
        panelCaratule5.add(titleGame5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 171, 251, 36));

        areaCaratule2.add(panelCaratule5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 359, 210));

        background.add(areaCaratule2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 160, 400, -1));

        panelPaginationsBotons.setBackground(new java.awt.Color(255, 255, 255));
        panelPaginationsBotons.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        paneGoBack.setBackground(new java.awt.Color(255, 255, 255));
        paneGoBack.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        goBackPageTitle.setEditable(false);
        goBackPageTitle.setBackground(new java.awt.Color(195, 206, 217));
        goBackPageTitle.setText("<");
        goBackPageTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(78, 80, 82)));
        paneGoBack.add(goBackPageTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 30, -1));

        goBackBoton.setForeground(new java.awt.Color(78, 80, 82));
        goBackBoton.setMaximumSize(new java.awt.Dimension(72, 76));
        goBackBoton.setMinimumSize(new java.awt.Dimension(72, 76));
        goBackBoton.setPreferredSize(new java.awt.Dimension(72, 76));
        goBackBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBackBotonActionPerformed(evt);
            }
        });
        paneGoBack.add(goBackBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 60));

        panelPaginationsBotons.add(paneGoBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 110, 100));

        goForwardPanel.setBackground(new java.awt.Color(255, 255, 255));
        goForwardPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        goForwardTitle.setEditable(false);
        goForwardTitle.setBackground(new java.awt.Color(195, 206, 217));
        goForwardTitle.setText(">");
        goForwardTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(78, 80, 82)));
        goForwardPanel.add(goForwardTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 30, -1));

        goForwardBoton.setForeground(new java.awt.Color(78, 80, 82));
        goForwardBoton.setMaximumSize(new java.awt.Dimension(72, 76));
        goForwardBoton.setMinimumSize(new java.awt.Dimension(72, 76));
        goForwardBoton.setPreferredSize(new java.awt.Dimension(72, 76));
        goForwardBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goForwardBotonActionPerformed(evt);
            }
        });
        goForwardPanel.add(goForwardBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 60));

        panelPaginationsBotons.add(goForwardPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 20, 110, 100));

        background.add(panelPaginationsBotons, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 900, 1060, 140));

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
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // ------------NEW------- Button Search------ ANDRES ROJAS--------------------------------------
        gamesOnPage = new ShowGamesPage();
        JLabel[] images = {this.coverImage1, this.coverImage2, this.coverImage3, this.coverImage4, this.coverImage5, this.coverImage6,this.coverImage7, this.coverImage8,this.coverImage9};
        JLabel[] textTitle = {this.titleGame1, this.titleGame2, this.titleGame3, this.titleGame4, this.titleGame5, this.titleGame6, this.titleGame7, this.titleGame8, this.titleGame9};
        JButton[] buttons = {this.priceBoton1, this.priceBoton2,this.priceBoton3,this.priceBoton4,this.priceBoton5,this.priceBoton6,this.priceBoton7,this.priceBoton8,this.priceBoton9};
        PutCovers putCover = new PutCovers(images, textTitle,buttons, this.panels,gamesOnPage.returnWordSearch(this.serchBox.getText()));
        putCover.putImageText(this);
        //--------------------------------------------------------------------------------------
    }//GEN-LAST:event_searchButtonActionPerformed

    private void serchBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serchBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_serchBoxActionPerformed

    private void goForwardBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goForwardBotonActionPerformed
              //----------------------JOSE RODRIGUEZ----------------------
        cp.goForwardBotonAction();
    }//GEN-LAST:event_goForwardBotonActionPerformed

    private void goBackBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackBotonActionPerformed
               //----------------------JOSE RODRIGUEZ----------------------
        cp.goBackBotonAction();
    }//GEN-LAST:event_goBackBotonActionPerformed

    private void priceBoton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceBoton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceBoton1ActionPerformed

    private void pcButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pcButtonActionPerformed
        // TODO add your handling code here:
        JLabel[] images = {this.coverImage1, this.coverImage2, this.coverImage3, this.coverImage4, this.coverImage5, this.coverImage6,this.coverImage7, this.coverImage8,this.coverImage9};
        JLabel[] textTitle = {this.titleGame1, this.titleGame2, this.titleGame3, this.titleGame4, this.titleGame5, this.titleGame6, this.titleGame7, this.titleGame8, this.titleGame9};
        JButton[] buttons = {this.priceBoton1, this.priceBoton2,this.priceBoton3,this.priceBoton4,this.priceBoton5,this.priceBoton6,this.priceBoton7,this.priceBoton8,this.priceBoton9};
        PutCovers putCover = new PutCovers(images, textTitle,buttons, panels,gamesOnPage.searchGamesByPlatform("PC"));
        putCover.putImageText(this);
    }//GEN-LAST:event_pcButtonActionPerformed

    private void xboxButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xboxButtonActionPerformed
        // TODO add your handling code here:
        JLabel[] images = {this.coverImage1, this.coverImage2, this.coverImage3, this.coverImage4, this.coverImage5, this.coverImage6,this.coverImage7, this.coverImage8,this.coverImage9};
        JLabel[] textTitle = {this.titleGame1, this.titleGame2, this.titleGame3, this.titleGame4, this.titleGame5, this.titleGame6, this.titleGame7, this.titleGame8, this.titleGame9};
        JButton[] buttons = {this.priceBoton1, this.priceBoton2,this.priceBoton3,this.priceBoton4,this.priceBoton5,this.priceBoton6,this.priceBoton7,this.priceBoton8,this.priceBoton9};
        PutCovers putCover = new PutCovers(images, textTitle,buttons, panels,gamesOnPage.searchGamesByPlatform("XBOX"));
        putCover.putImageText(this);
    }//GEN-LAST:event_xboxButtonActionPerformed

    private void playStationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playStationButtonActionPerformed
        // TODO add your handling code here:
        
        JLabel[] images = {this.coverImage1, this.coverImage2, this.coverImage3, this.coverImage4, this.coverImage5, this.coverImage6,this.coverImage7, this.coverImage8,this.coverImage9};
        JLabel[] textTitle = {this.titleGame1, this.titleGame2, this.titleGame3, this.titleGame4, this.titleGame5, this.titleGame6, this.titleGame7, this.titleGame8, this.titleGame9};
        JButton[] buttons = {this.priceBoton1, this.priceBoton2,this.priceBoton3,this.priceBoton4,this.priceBoton5,this.priceBoton6,this.priceBoton7,this.priceBoton8,this.priceBoton9};
        PutCovers putCover = new PutCovers(images, textTitle,buttons, panels,gamesOnPage.searchGamesByPlatform("PS4"));
        putCover.putImageText(this);
    }//GEN-LAST:event_playStationButtonActionPerformed

    private void nintendoSwitchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nintendoSwitchButtonActionPerformed
        // TODO add your handling code here:
        JLabel[] images = {this.coverImage1, this.coverImage2, this.coverImage3, this.coverImage4, this.coverImage5, this.coverImage6,this.coverImage7, this.coverImage8,this.coverImage9};
        JLabel[] textTitle = {this.titleGame1, this.titleGame2, this.titleGame3, this.titleGame4, this.titleGame5, this.titleGame6, this.titleGame7, this.titleGame8, this.titleGame9};
        JButton[] buttons = {this.priceBoton1, this.priceBoton2,this.priceBoton3,this.priceBoton4,this.priceBoton5,this.priceBoton6,this.priceBoton7,this.priceBoton8,this.priceBoton9};
        PutCovers putCover = new PutCovers(images, textTitle,buttons, panels,gamesOnPage.searchGamesByPlatform("Switch"));
        putCover.putImageText(this);
    }//GEN-LAST:event_nintendoSwitchButtonActionPerformed

    private void TopJuegosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TopJuegosActionPerformed
        // TODO add your handling code here:
        HomePage OpenCatalogo= new HomePage(userId);
        OpenCatalogo.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_TopJuegosActionPerformed

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


    public static void main(String args[]) {

       /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pagination().setVisible(true);
            }
        });*/
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Inicio;
    private javax.swing.JPanel areaCaratule;
    private javax.swing.JPanel areaCaratule10;
    private javax.swing.JPanel areaCaratule2;
    private javax.swing.JPanel background;
    private javax.swing.JLabel coverImage1;
    private javax.swing.JLabel coverImage2;
    private javax.swing.JLabel coverImage3;
    private javax.swing.JLabel coverImage4;
    private javax.swing.JLabel coverImage5;
    private javax.swing.JLabel coverImage6;
    private javax.swing.JLabel coverImage7;
    private javax.swing.JLabel coverImage8;
    private javax.swing.JLabel coverImage9;
    private javax.swing.JButton goBackBoton;
    private javax.swing.JTextField goBackPageTitle;
    private javax.swing.JButton goForwardBoton;
    private javax.swing.JPanel goForwardPanel;
    private javax.swing.JTextField goForwardTitle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblImagen1;
    private javax.swing.JLabel logPage;
    private javax.swing.JButton nintendoSwitchButton;
    private javax.swing.JPanel paneGoBack;
    private javax.swing.JPanel panelCaratule1;
    private javax.swing.JPanel panelCaratule2;
    private javax.swing.JPanel panelCaratule3;
    private javax.swing.JPanel panelCaratule4;
    private javax.swing.JPanel panelCaratule5;
    private javax.swing.JPanel panelCaratule6;
    private javax.swing.JPanel panelCaratule7;
    private javax.swing.JPanel panelCaratule8;
    private javax.swing.JPanel panelCaratule9;
    private javax.swing.JPanel panelPaginationsBotons;
    private javax.swing.JButton pcButton;
    private javax.swing.JButton playStationButton;
    private javax.swing.JButton priceBoton1;
    private javax.swing.JButton priceBoton2;
    private javax.swing.JButton priceBoton3;
    private javax.swing.JButton priceBoton4;
    private javax.swing.JButton priceBoton5;
    private javax.swing.JButton priceBoton6;
    private javax.swing.JButton priceBoton7;
    private javax.swing.JButton priceBoton8;
    private javax.swing.JButton priceBoton9;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField serchBox;
    private javax.swing.JLabel titleGame1;
    private javax.swing.JLabel titleGame2;
    private javax.swing.JLabel titleGame3;
    private javax.swing.JLabel titleGame4;
    private javax.swing.JLabel titleGame5;
    private javax.swing.JLabel titleGame6;
    private javax.swing.JLabel titleGame7;
    private javax.swing.JLabel titleGame8;
    private javax.swing.JLabel titleGame9;
    private javax.swing.JPanel topBlackBarPanel;
    private javax.swing.JButton xboxButton;
    // End of variables declaration//GEN-END:variables
}
