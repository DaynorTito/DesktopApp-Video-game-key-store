package view;

import java.awt.Color;
import logic.UserDetailView;


public class UserProfile extends javax.swing.JFrame {
    
    private String idUser;
    private int idUserNum;
    private UserDetailView showUserData;


    
    public UserProfile() {
        initComponents();
        this.setLocationRelativeTo(this);
        this.idUserNum = 5;
        //----------------------------------------------------------
        showUserData = new UserDetailView();
        idUser = showUserData.getNumId(this.idUserNum);
        showUserData.setIdUser(idUser);
        showUserData.showProfileInformation(this.userNameLabel, this.nameUser, this.lastNameUser, this.emailUser, this.birthdateUser);
        
    }
    public UserProfile(int idUsser){
        initComponents();
        this.setLocationRelativeTo(this);
        idUser = "";
        this.idUserNum = idUsser;
        //----------------------------------------------------------
        showUserData = new UserDetailView();
        idUser = showUserData.getNumId(this.idUserNum);
        showUserData.setIdUser(idUser);
        showUserData.showProfileInformation(this.userNameLabel, this.nameUser, this.lastNameUser, this.emailUser, this.birthdateUser);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        topBlackBarPanel = new javax.swing.JPanel();
        pcButton = new javax.swing.JButton();
        logPage = new javax.swing.JLabel();
        asideProfile = new javax.swing.JPanel();
        photoProfile = new javax.swing.JLabel();
        shoppingHistoryButton = new javax.swing.JPanel();
        labelShoppingHistory = new javax.swing.JLabel();
        homepageButton = new javax.swing.JPanel();
        labelHomepage = new javax.swing.JLabel();
        userNameLabel = new javax.swing.JLabel();
        profileInformationPanel = new javax.swing.JPanel();
        labelName = new javax.swing.JLabel();
        labelLastName = new javax.swing.JLabel();
        labelEmail = new javax.swing.JLabel();
        labelBirthday = new javax.swing.JLabel();
        separatorName = new javax.swing.JSeparator();
        separatorlastName = new javax.swing.JSeparator();
        separatorBirthdate = new javax.swing.JSeparator();
        separatorEmail = new javax.swing.JSeparator();
        nameUser = new javax.swing.JLabel();
        lastNameUser = new javax.swing.JLabel();
        emailUser = new javax.swing.JLabel();
        birthdateUser = new javax.swing.JLabel();
        personalDetailsTitle = new javax.swing.JLabel();
        changePasswordPanel = new javax.swing.JPanel();
        labelSetPassword = new javax.swing.JLabel();
        separatorTitleSetPass = new javax.swing.JSeparator();
        labelNewPass = new javax.swing.JLabel();
        newPasswordUser = new javax.swing.JPasswordField();
        panelPasswordContains = new javax.swing.JPanel();
        titleContainsPass = new javax.swing.JLabel();
        firstContain1 = new javax.swing.JLabel();
        firstContain2 = new javax.swing.JLabel();
        secondContain = new javax.swing.JLabel();
        thirtContain = new javax.swing.JLabel();
        fourtContain = new javax.swing.JLabel();
        labelConfirmmPass = new javax.swing.JLabel();
        confirmPassUser = new javax.swing.JPasswordField();
        labelCurrentPass = new javax.swing.JLabel();
        currentPassUser = new javax.swing.JPasswordField();
        changePassButton = new javax.swing.JPanel();
        labelButtChangePass = new javax.swing.JLabel();
        clearFieldUser = new javax.swing.JPanel();
        labelClearFButt = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        labelSignOff = new javax.swing.JLabel();
        signOutButton = new javax.swing.JPanel();
        labelSignOut = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 255, 204));
        setExtendedState(6);

        background.setBackground(new java.awt.Color(231, 231, 231));
        background.setPreferredSize(new java.awt.Dimension(1920, 1080));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        topBlackBarPanel.setBackground(new java.awt.Color(0, 0, 0));
        topBlackBarPanel.setPreferredSize(new java.awt.Dimension(1920, 123));
        topBlackBarPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pcButton.setBackground(new java.awt.Color(59, 59, 59));
        pcButton.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        pcButton.setForeground(new java.awt.Color(255, 255, 255));
        pcButton.setText("Catalogo");
        pcButton.setPreferredSize(new java.awt.Dimension(158, 28));
        pcButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pcButtonMouseClicked(evt);
            }
        });
        pcButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pcButtonActionPerformed(evt);
            }
        });
        topBlackBarPanel.add(pcButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, -1, -1));

        logPage.setFont(new java.awt.Font("Liberation Sans", 1, 60)); // NOI18N
        logPage.setForeground(new java.awt.Color(255, 255, 255));
        logPage.setText("GAME ON");
        topBlackBarPanel.add(logPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 32, 326, 61));

        background.add(topBlackBarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 130));

        asideProfile.setBackground(new java.awt.Color(41, 43, 44));

        photoProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgGameStore/icon/iconProfileDefault.png"))); // NOI18N

        shoppingHistoryButton.setBackground(new java.awt.Color(236, 236, 236));
        shoppingHistoryButton.setForeground(new java.awt.Color(255, 255, 255));
        shoppingHistoryButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        shoppingHistoryButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                shoppingHistoryButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                shoppingHistoryButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                shoppingHistoryButtonMouseExited(evt);
            }
        });

        labelShoppingHistory.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        labelShoppingHistory.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelShoppingHistory.setText("Historial de compras");
        labelShoppingHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelShoppingHistoryMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelShoppingHistoryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelShoppingHistoryMouseExited(evt);
            }
        });

        javax.swing.GroupLayout shoppingHistoryButtonLayout = new javax.swing.GroupLayout(shoppingHistoryButton);
        shoppingHistoryButton.setLayout(shoppingHistoryButtonLayout);
        shoppingHistoryButtonLayout.setHorizontalGroup(
            shoppingHistoryButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shoppingHistoryButtonLayout.createSequentialGroup()
                .addComponent(labelShoppingHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        shoppingHistoryButtonLayout.setVerticalGroup(
            shoppingHistoryButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelShoppingHistory, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        homepageButton.setBackground(new java.awt.Color(236, 236, 236));
        homepageButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        homepageButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                homepageButtonMouseExited(evt);
            }
        });

        labelHomepage.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        labelHomepage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelHomepage.setText("Pagina Inicio");
        labelHomepage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelHomepageMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelHomepageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelHomepageMouseExited(evt);
            }
        });

        javax.swing.GroupLayout homepageButtonLayout = new javax.swing.GroupLayout(homepageButton);
        homepageButton.setLayout(homepageButtonLayout);
        homepageButtonLayout.setHorizontalGroup(
            homepageButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelHomepage, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        homepageButtonLayout.setVerticalGroup(
            homepageButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelHomepage, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        userNameLabel.setBackground(new java.awt.Color(153, 153, 153));
        userNameLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        userNameLabel.setForeground(new java.awt.Color(204, 204, 204));
        userNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userNameLabel.setText("Nomre usuario");

        javax.swing.GroupLayout asideProfileLayout = new javax.swing.GroupLayout(asideProfile);
        asideProfile.setLayout(asideProfileLayout);
        asideProfileLayout.setHorizontalGroup(
            asideProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(asideProfileLayout.createSequentialGroup()
                .addGroup(asideProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(asideProfileLayout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(photoProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(asideProfileLayout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(userNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(asideProfileLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(asideProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(shoppingHistoryButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(homepageButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        asideProfileLayout.setVerticalGroup(
            asideProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(asideProfileLayout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(photoProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(shoppingHistoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(homepageButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(384, Short.MAX_VALUE))
        );

        background.add(asideProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 430, 950));

        profileInformationPanel.setBackground(new java.awt.Color(249, 249, 249));
        profileInformationPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelName.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        labelName.setText("Nombres");

        labelLastName.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        labelLastName.setText("Apellidos");

        labelEmail.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        labelEmail.setText("Correo");

        labelBirthday.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        labelBirthday.setText("Fecha nacimiento");

        nameUser.setText("Name user");

        lastNameUser.setText("Last name user");

        emailUser.setText("Emai user");

        birthdateUser.setText("Birthdate");

        javax.swing.GroupLayout profileInformationPanelLayout = new javax.swing.GroupLayout(profileInformationPanel);
        profileInformationPanel.setLayout(profileInformationPanelLayout);
        profileInformationPanelLayout.setHorizontalGroup(
            profileInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileInformationPanelLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(profileInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelEmail)
                    .addComponent(labelLastName)
                    .addComponent(labelName)
                    .addComponent(separatorName)
                    .addComponent(separatorlastName)
                    .addComponent(separatorEmail)
                    .addComponent(separatorBirthdate)
                    .addComponent(emailUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(birthdateUser, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
                    .addComponent(nameUser, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
                    .addComponent(lastNameUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        profileInformationPanelLayout.setVerticalGroup(
            profileInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profileInformationPanelLayout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(labelName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nameUser, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separatorName, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(labelLastName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lastNameUser, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separatorlastName, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(labelEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(emailUser, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(separatorEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(labelBirthday)
                .addGap(18, 18, 18)
                .addComponent(birthdateUser, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separatorBirthdate, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        background.add(profileInformationPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, 760, 610));

        personalDetailsTitle.setFont(new java.awt.Font("FreeSans", 1, 40)); // NOI18N
        personalDetailsTitle.setText("Datos personales");
        background.add(personalDetailsTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, 440, 50));

        changePasswordPanel.setBackground(new java.awt.Color(249, 249, 249));
        changePasswordPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelSetPassword.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelSetPassword.setText("Establezca su nueva contraseña");

        labelNewPass.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        labelNewPass.setText("Nueva contraseña");

        newPasswordUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPasswordUserActionPerformed(evt);
            }
        });

        panelPasswordContains.setBackground(new java.awt.Color(249, 249, 249));
        panelPasswordContains.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        titleContainsPass.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        titleContainsPass.setText("Password should contain:");

        firstContain1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        firstContain1.setText("- min 1 digit or special character ");

        firstContain2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        firstContain2.setText("  (!@#$^...) ");

        secondContain.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        secondContain.setText("- min 1 lower case letter");

        thirtContain.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        thirtContain.setText("- min 1 upper case letter");

        fourtContain.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        fourtContain.setText("- between 8 and 50 characters");

        javax.swing.GroupLayout panelPasswordContainsLayout = new javax.swing.GroupLayout(panelPasswordContains);
        panelPasswordContains.setLayout(panelPasswordContainsLayout);
        panelPasswordContainsLayout.setHorizontalGroup(
            panelPasswordContainsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titleContainsPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelPasswordContainsLayout.createSequentialGroup()
                .addGroup(panelPasswordContainsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(firstContain1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(firstContain2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(secondContain, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                    .addComponent(thirtContain, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                    .addComponent(fourtContain, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelPasswordContainsLayout.setVerticalGroup(
            panelPasswordContainsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPasswordContainsLayout.createSequentialGroup()
                .addComponent(titleContainsPass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(firstContain1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(firstContain2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(secondContain)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(thirtContain)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fourtContain)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        labelConfirmmPass.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        labelConfirmmPass.setText("Confirmar contraseña");

        confirmPassUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmPassUserActionPerformed(evt);
            }
        });

        labelCurrentPass.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        labelCurrentPass.setText("Contraseña actual");

        changePassButton.setBackground(new java.awt.Color(2, 117, 162));
        changePassButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        labelButtChangePass.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        labelButtChangePass.setForeground(new java.awt.Color(255, 255, 255));
        labelButtChangePass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelButtChangePass.setText("Cambiar");
        labelButtChangePass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelButtChangePassMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelButtChangePassMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelButtChangePassMouseExited(evt);
            }
        });

        javax.swing.GroupLayout changePassButtonLayout = new javax.swing.GroupLayout(changePassButton);
        changePassButton.setLayout(changePassButtonLayout);
        changePassButtonLayout.setHorizontalGroup(
            changePassButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(changePassButtonLayout.createSequentialGroup()
                .addComponent(labelButtChangePass, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        changePassButtonLayout.setVerticalGroup(
            changePassButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelButtChangePass, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        clearFieldUser.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(2, 117, 216), 1, true));
        clearFieldUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        labelClearFButt.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        labelClearFButt.setForeground(new java.awt.Color(2, 117, 216));
        labelClearFButt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelClearFButt.setText("Limpiar");
        labelClearFButt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelClearFButtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelClearFButtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelClearFButtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout clearFieldUserLayout = new javax.swing.GroupLayout(clearFieldUser);
        clearFieldUser.setLayout(clearFieldUserLayout);
        clearFieldUserLayout.setHorizontalGroup(
            clearFieldUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelClearFButt, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
        );
        clearFieldUserLayout.setVerticalGroup(
            clearFieldUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelClearFButt, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout changePasswordPanelLayout = new javax.swing.GroupLayout(changePasswordPanel);
        changePasswordPanel.setLayout(changePasswordPanelLayout);
        changePasswordPanelLayout.setHorizontalGroup(
            changePasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(changePasswordPanelLayout.createSequentialGroup()
                .addGroup(changePasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(changePasswordPanelLayout.createSequentialGroup()
                        .addComponent(labelNewPass)
                        .addGap(18, 18, 18)
                        .addComponent(newPasswordUser, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(changePasswordPanelLayout.createSequentialGroup()
                        .addGroup(changePasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, changePasswordPanelLayout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(changePassButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(clearFieldUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40))
                            .addGroup(changePasswordPanelLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(changePasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(changePasswordPanelLayout.createSequentialGroup()
                                        .addGroup(changePasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(labelCurrentPass)
                                            .addComponent(labelConfirmmPass))
                                        .addGap(18, 18, 18)
                                        .addGroup(changePasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(confirmPassUser)
                                            .addComponent(currentPassUser, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)))
                                    .addComponent(panelPasswordContains, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(1, 1, 1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, changePasswordPanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(changePasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelSetPassword)
                            .addComponent(separatorTitleSetPass))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        changePasswordPanelLayout.setVerticalGroup(
            changePasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(changePasswordPanelLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(labelSetPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separatorTitleSetPass, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(changePasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNewPass)
                    .addComponent(newPasswordUser, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(panelPasswordContains, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(changePasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelConfirmmPass)
                    .addComponent(confirmPassUser, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(changePasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCurrentPass)
                    .addComponent(currentPassUser, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addGroup(changePasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clearFieldUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changePassButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56))
        );

        background.add(changePasswordPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 250, 510, 610));

        jPanel6.setBackground(new java.awt.Color(249, 249, 249));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelSignOff.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelSignOff.setText("Cerrar sesion");

        signOutButton.setBackground(new java.awt.Color(217, 83, 79));
        signOutButton.setForeground(new java.awt.Color(255, 255, 255));
        signOutButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signOutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                signOutButtonMouseExited(evt);
            }
        });

        labelSignOut.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelSignOut.setForeground(new java.awt.Color(255, 255, 255));
        labelSignOut.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSignOut.setText("Salir");
        labelSignOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelSignOutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelSignOutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelSignOutMouseExited(evt);
            }
        });

        javax.swing.GroupLayout signOutButtonLayout = new javax.swing.GroupLayout(signOutButton);
        signOutButton.setLayout(signOutButtonLayout);
        signOutButtonLayout.setHorizontalGroup(
            signOutButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelSignOut, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        signOutButtonLayout.setVerticalGroup(
            signOutButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelSignOut, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(labelSignOff)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 977, Short.MAX_VALUE)
                .addComponent(signOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(labelSignOff))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(signOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        background.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 900, 1360, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 1926, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void labelShoppingHistoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelShoppingHistoryMouseEntered
        this.shoppingHistoryButton.setBackground(new Color(191,191,191));
    }//GEN-LAST:event_labelShoppingHistoryMouseEntered

    private void shoppingHistoryButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_shoppingHistoryButtonMouseExited
        
        System.out.println("Selio exited");
    }//GEN-LAST:event_shoppingHistoryButtonMouseExited

    private void newPasswordUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPasswordUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newPasswordUserActionPerformed

    private void confirmPassUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmPassUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmPassUserActionPerformed

    private void labelSignOutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSignOutMouseEntered
        this.signOutButton.setBackground(new Color(191,51,45));
    }//GEN-LAST:event_labelSignOutMouseEntered

    private void signOutButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signOutButtonMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_signOutButtonMouseExited

    private void labelHomepageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelHomepageMouseClicked
        HomePage hpg = new HomePage(this.idUserNum);
        this.dispose();
        hpg.setVisible(true);
    }//GEN-LAST:event_labelHomepageMouseClicked

    private void labelHomepageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelHomepageMouseEntered
        this.homepageButton.setBackground(new Color(191,191,191));
    }//GEN-LAST:event_labelHomepageMouseEntered

    private void homepageButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homepageButtonMouseExited

    }//GEN-LAST:event_homepageButtonMouseExited

    private void shoppingHistoryButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_shoppingHistoryButtonMouseEntered
        
    }//GEN-LAST:event_shoppingHistoryButtonMouseEntered

    private void labelShoppingHistoryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelShoppingHistoryMouseExited
        this.shoppingHistoryButton.setBackground(new Color(236,236,236));
    }//GEN-LAST:event_labelShoppingHistoryMouseExited

    private void shoppingHistoryButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_shoppingHistoryButtonMouseClicked
      
    }//GEN-LAST:event_shoppingHistoryButtonMouseClicked

    private void labelShoppingHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelShoppingHistoryMouseClicked
        RecordGames recordGames = new RecordGames(idUserNum);
        recordGames.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_labelShoppingHistoryMouseClicked

    private void labelHomepageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelHomepageMouseExited
        this.homepageButton.setBackground(new Color(236,236,236));
    }//GEN-LAST:event_labelHomepageMouseExited

    private void labelButtChangePassMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelButtChangePassMouseEntered
        this.changePassButton.setBackground(new Color(2,78,126));
    }//GEN-LAST:event_labelButtChangePassMouseEntered

    private void labelButtChangePassMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelButtChangePassMouseExited
        this.changePassButton.setBackground(new Color(2,117,162));
    }//GEN-LAST:event_labelButtChangePassMouseExited

    private void labelClearFButtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelClearFButtMouseEntered
        this.labelClearFButt.setForeground(new Color(0,62,115));
        this.clearFieldUser.setBackground(new Color(224,224,224));
    }//GEN-LAST:event_labelClearFButtMouseEntered

    private void labelClearFButtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelClearFButtMouseExited
        this.labelClearFButt.setForeground(new Color(2,117,216));
        this.clearFieldUser.setBackground(new Color(242,242,242));
    }//GEN-LAST:event_labelClearFButtMouseExited

    private void labelSignOutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSignOutMouseExited
        this.signOutButton.setBackground(new Color(217,83,79));
    }//GEN-LAST:event_labelSignOutMouseExited

    private void labelButtChangePassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelButtChangePassMouseClicked
        this.showUserData.changePassword(newPasswordUser, confirmPassUser, currentPassUser);
    }//GEN-LAST:event_labelButtChangePassMouseClicked

    private void labelClearFButtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelClearFButtMouseClicked
        this.showUserData.clearFieldsPassword(newPasswordUser, confirmPassUser, currentPassUser);
    }//GEN-LAST:event_labelClearFButtMouseClicked

    private void labelSignOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSignOutMouseClicked
        this.showUserData.logOutUser(this.userNameLabel, this.nameUser, this.lastNameUser, this.emailUser, this.birthdateUser);
        Login logIn = new Login();
        logIn.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_labelSignOutMouseClicked

    private void pcButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pcButtonActionPerformed
        
    }//GEN-LAST:event_pcButtonActionPerformed

    private void pcButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pcButtonMouseClicked
        Pagination pg = new Pagination(this.idUserNum);
        pg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_pcButtonMouseClicked


  
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserProfile().setVisible(true);
            }
        });
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }
    public int getIdUserNum() {
        return idUserNum;
    }

    public void setIdUserNum(int idUserNum) {
        this.idUserNum = idUserNum;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel asideProfile;
    private javax.swing.JPanel background;
    private javax.swing.JLabel birthdateUser;
    private javax.swing.JPanel changePassButton;
    private javax.swing.JPanel changePasswordPanel;
    private javax.swing.JPanel clearFieldUser;
    private javax.swing.JPasswordField confirmPassUser;
    private javax.swing.JPasswordField currentPassUser;
    private javax.swing.JLabel emailUser;
    private javax.swing.JLabel firstContain1;
    private javax.swing.JLabel firstContain2;
    private javax.swing.JLabel fourtContain;
    private javax.swing.JPanel homepageButton;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel labelBirthday;
    private javax.swing.JLabel labelButtChangePass;
    private javax.swing.JLabel labelClearFButt;
    private javax.swing.JLabel labelConfirmmPass;
    private javax.swing.JLabel labelCurrentPass;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelHomepage;
    private javax.swing.JLabel labelLastName;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelNewPass;
    private javax.swing.JLabel labelSetPassword;
    private javax.swing.JLabel labelShoppingHistory;
    private javax.swing.JLabel labelSignOff;
    private javax.swing.JLabel labelSignOut;
    private javax.swing.JLabel lastNameUser;
    private javax.swing.JLabel logPage;
    private javax.swing.JLabel nameUser;
    private javax.swing.JPasswordField newPasswordUser;
    private javax.swing.JPanel panelPasswordContains;
    private javax.swing.JButton pcButton;
    private javax.swing.JLabel personalDetailsTitle;
    private javax.swing.JLabel photoProfile;
    private javax.swing.JPanel profileInformationPanel;
    private javax.swing.JLabel secondContain;
    private javax.swing.JSeparator separatorBirthdate;
    private javax.swing.JSeparator separatorEmail;
    private javax.swing.JSeparator separatorName;
    private javax.swing.JSeparator separatorTitleSetPass;
    private javax.swing.JSeparator separatorlastName;
    private javax.swing.JPanel shoppingHistoryButton;
    private javax.swing.JPanel signOutButton;
    private javax.swing.JLabel thirtContain;
    private javax.swing.JLabel titleContainsPass;
    private javax.swing.JPanel topBlackBarPanel;
    private javax.swing.JLabel userNameLabel;
    // End of variables declaration//GEN-END:variables
}
