
package view;


import databaseConnection.CLogin;
import java.awt.Color;
import java.awt.Image;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import logic.GetUserName;
import logic.ShoppingCartDatas;
import logic.ShoppingCartSearcherUsers;
import logic.KeyExtractor;



/**
 *
 * @author university
 */
public class CarritoCompras extends javax.swing.JFrame {
    ShoppingCartDatas cartDatas;
    String[][][] gameDataArray;
    
    
    int currentPage;
    int[][] numberOfVideoGames;
    double totalPrice; 
    
    ShoppingCartSearcherUsers searcher = new ShoppingCartSearcherUsers();
    ShoppingCartSearcherUsers provider = new ShoppingCartSearcherUsers();
    List<Integer> unpurchasedGameIDs;
    int[] gameIDArray;
    
    int userDataID;// = CLogin.userId;
    
    
    
    /**
     * Creates new form CarritoCompras
     */
    public CarritoCompras() {
        initComponents();
        this.setLocationRelativeTo(this);
        this.userDataID = CLogin.userId;
        //this.userDataID = 2;
        GetUserName nameL = new GetUserName();
        
        userNameLabel.setText(nameL.GetUserName(userDataID));
        //gameDataArray = cartDatas.generatePaginationArray(unpurchasedGameIDs);
        

        setImageLabel(iconUserLabel, "src/imgGameStore/icon/userIcon.png");
        setImageLabel(iconDelet1, "src/imgGameStore/icon/cestaBasuraIcono.png");
        setImageLabel(iconDelet2, "src/imgGameStore/icon/cestaBasuraIcono.png");
        setImageLabel(iconDelet3, "src/imgGameStore/icon/cestaBasuraIcono.png");
        setImageLabel(iconDelet4, "src/imgGameStore/icon/cestaBasuraIcono.png");
        setImageLabel(iconDelet5, "src/imgGameStore/icon/cestaBasuraIcono.png");
        
        

        cartDatas = new ShoppingCartDatas();
        initGameDataArray();
        
        
        //List<Integer> unpurchasedGameIDs = cartDatas.getUnpurchasedGameIDs(1);
        unpurchasedGameIDs = cartDatas.getUnpurchasedGameIDs(this.userDataID);

        gameDataArray = cartDatas.generatePaginationArray(unpurchasedGameIDs);
        numberOfVideoGames = new int[gameDataArray.length][5];
        for (int i = 0; i < gameDataArray.length; i++) {
            for (int j = 0; j < 5; j++) {
                numberOfVideoGames[i][j] = 1;
            }
        }
        
        refreshPage(currentPage);
        updateNumberOfVideoGamesLabels(currentPage);
        
        double totalPrice = 0.0;
        
        unpurchasedGameIDs = provider.getUnpurchasedGameIDs(this.userDataID); //especificar aqui el usuario actual
        gameIDArray = new int[unpurchasedGameIDs.size()];
        
        System.out.println("IDGames encontrados:");
        for (int i = 0; i < unpurchasedGameIDs.size(); i++) {
            int gameID = unpurchasedGameIDs.get(i);
            gameIDArray[i] = gameID;
            System.out.println(gameID);
        }
            
    }

    public int getUserDataID() {
        return userDataID;
    }

    public void setUserDataID(int userDataID) {
        this.userDataID = userDataID;
    }
    

    /**
     * Actualiza la página del carrito de compras.
     *
     * @param page la página a mostrar
     */
   
    private void refreshPage(int page) {

        // Actualiza los elementos de la página según la página actual
        JLabel[] caratuleGameImgs = {caratuleGameImg1, caratuleGameImg2, caratuleGameImg3, caratuleGameImg4, caratuleGameImg5};
        JLabel[] nameGames = {nameGame1, nameGame2, nameGame3, nameGame4, nameGame5};
        JLabel[] priceGames = {priceTotalGameLabel1, priceTotalGameLabel2, priceTotalGameLabel3, priceTotalGameLabel4, priceTotalGameLabel5};
        searcher.calculateTotalCost(1);//aqui tengo que poner el usuario
        updateTotalPrice();
        


            for (int i = 0; i < caratuleGameImgs.length; i++) {
                if (currentPage < gameDataArray.length && i < gameDataArray[currentPage].length && gameDataArray[currentPage][i][2] != null) {
                    setImageLabel(caratuleGameImgs[i], gameDataArray[currentPage][i][2]);
                    caratuleGameImgs[i].setVisible(true);
                } else {
                    setImageLabel(caratuleGameImgs[i], null);
                    caratuleGameImgs[i].setVisible(false);
                }

                if (currentPage < gameDataArray.length && i < gameDataArray[currentPage].length && gameDataArray[currentPage][i][0] != null) {
                    nameGames[i].setText(gameDataArray[currentPage][i][0]);
                    nameGames[i].setVisible(true);
                } else {
                    nameGames[i].setText("");
                    nameGames[i].setVisible(false);
                }

                if (currentPage < gameDataArray.length && i < gameDataArray[currentPage].length && gameDataArray[currentPage][i][1] != null) {
                    String priceText = gameDataArray[currentPage][i][1];
                    double priceValue = Double.parseDouble(priceText);
                    double multipliedPrice = priceValue * numberOfVideoGames[currentPage][i]; // Realiza la operación matemática deseada

                    // Formatea el resultado con dos decimales
                    DecimalFormat decimalFormat = new DecimalFormat("0.00");
                    String formattedPrice = decimalFormat.format(multipliedPrice);

                    priceGames[i].setText(formattedPrice);
                    priceGames[i].setVisible(true);
                } else {
                    priceGames[i].setText("");
                    priceGames[i].setVisible(false);
                }

            }
        
         
        
        
        updateTotalPrice();
        
        
    }
    private void initGameDataArray() {
        unpurchasedGameIDs = cartDatas.getUnpurchasedGameIDs(this.userDataID);
        gameDataArray = cartDatas.generatePaginationArray(unpurchasedGameIDs);
        numberOfVideoGames = new int[gameDataArray.length][5];
    }
    
    private void updateGameDataArray() {
        unpurchasedGameIDs = cartDatas.getUnpurchasedGameIDs(this.userDataID); // Actualiza los IDs de los juegos no comprados
        gameDataArray = cartDatas.generatePaginationArray(unpurchasedGameIDs); // Genera el nuevo arreglo de datos
        numberOfVideoGames = new int[gameDataArray.length][5]; // Actualiza el arreglo de conteo de juegos
    }
    

    private void updateTotalPrice() {
        totalPrice = 0.0;
        for (int i = 0; i < gameDataArray.length; i++) {
            for (int j = 0; j < gameDataArray[i].length; j++) {
                if (gameDataArray[i][j][1] != null) {
                    String priceText = gameDataArray[i][j][1];
                    double priceValue = Double.parseDouble(priceText);
                    double multipliedPrice = priceValue * numberOfVideoGames[i][j]; // Realiza la operación matemática

                    totalPrice += multipliedPrice; // Suma el precio individual al precio total
                }
            }
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        double roundedNumber = Double.parseDouble(decimalFormat.format(totalPrice));

        this.totalPrice = totalPrice; // Asigna el valor del precio total al campo de instancia totalPrice

        // Establece el texto del totalPriceInfoLabel con el valor del precio total
        totalPriceInfoLabel.setText(String.valueOf(roundedNumber)+" Bs");
    }
    
    
    
    private void updateNumberOfVideoGamesLabels(int page) {
        String[][] numberOfVideoGameStrings = new String[numberOfVideoGames.length][numberOfVideoGames[0].length];
        for (int i = 0; i < numberOfVideoGames.length; i++) {
            for (int j = 0; j < numberOfVideoGames[i].length; j++) {
                numberOfVideoGameStrings[i][j] = String.valueOf(numberOfVideoGames[i][j]);
            }
        }

        JLabel[] numberOfVideoGamesLabelsE = {quantityGameLabel1, quantityGameLabel2, quantityGameLabel3, quantityGameLabel4, quantityGameLabel5};

        for (int i = 0; i < numberOfVideoGamesLabelsE.length; i++) {
            if (page < gameDataArray.length && i < gameDataArray[page].length && gameDataArray[page][i][0] != null) {
                numberOfVideoGamesLabelsE[i].setText(numberOfVideoGameStrings[page][i]);
                numberOfVideoGamesLabelsE[i].setVisible(true);
            } else {
                numberOfVideoGamesLabelsE[i].setText("");
                numberOfVideoGamesLabelsE[i].setVisible(false);
            }
        }
    }
        

    
    private boolean verificarDisponibilidadClaves(int userDataID) {
        ShoppingCartSearcherUsers searcherUsers = new ShoppingCartSearcherUsers();
        KeyExtractor keyExtractor = new KeyExtractor();

        List<Integer> gameIDs = searcherUsers.getUnpurchasedGameIDs(userDataID); // Obtener los ID de juegos sin comprar

        // Lista para almacenar los juegos con cantidad insuficiente de claves
        List<String> juegosInsuficientes = new ArrayList<>();

        boolean disponibilidadClaves = juegosInsuficientes.isEmpty();

        // Iterar sobre los juegos en el carrito de compras
        for (int i = 0; i < gameDataArray.length; i++) {
            for (int j = 0; j < gameDataArray[i].length; j++) {
                int gameID = gameIDs.get(i); // Obtener el ID del juego actual
                int cantidadSolicitada = numberOfVideoGames[i][j]; // Obtener la cantidad solicitada

                // Obtener las claves disponibles para el juego actual
                String[] gameKeys = keyExtractor.retrieveGameKeys(gameID);

                if (gameKeys.length < cantidadSolicitada) {
                    String nombreJuego = gameDataArray[i][j][0]; // Obtener el nombre del juego
                    int clavesDisponibles = gameKeys.length; // Obtener la cantidad de claves disponibles

                    // Agregar el juego con cantidad insuficiente a la lista
                    juegosInsuficientes.add(nombreJuego + " - Claves disponibles: " + clavesDisponibles);
                }
            }
        }

        // Verificar si hay juegos con cantidad insuficiente de claves
        if (!juegosInsuficientes.isEmpty()) {
            // Construir el mensaje a mostrar en la ventana emergente
            StringBuilder errorMessage = new StringBuilder();
            errorMessage.append("Error: Claves insuficientes\n\n");
            errorMessage.append("Los siguientes juegos no tienen suficientes claves:\n");
            for (String juego : juegosInsuficientes) {
                errorMessage.append(juego).append("\n");
            }

            // Mostrar la ventana emergente con el mensaje de error
            JOptionPane.showMessageDialog(this, errorMessage.toString(), "Error de Claves", JOptionPane.ERROR_MESSAGE);

            disponibilidadClaves = false;
        }

        return disponibilidadClaves;
    }

   
    private void addGameToList(int caratule) {
        gameDataArray = cartDatas.generatePaginationArray(unpurchasedGameIDs);
            System.out.println(gameDataArray.length);
            System.out.println(gameDataArray[currentPage].length);

        // Verificar si el gameDataArray está vacío o la página actual no tiene datos
        if (gameDataArray.length == 0 || gameDataArray[currentPage].length == 0) {
            System.out.println("No hay datos disponibles en la base de datos.");
            return;
        }

        numberOfVideoGames[currentPage][caratule] += 1;
        refreshPage(currentPage);
        updateNumberOfVideoGamesLabels(currentPage);
        int positionGame = (currentPage * 5) + caratule;
        if(gameIDArray.length + 2 < positionGame ){
            int gameID = gameIDArray[positionGame]; // ID del juego
            int updatedQuantity = numberOfVideoGames[currentPage][caratule]; // Cantidad actualizada de NumberOfVideoGames
            searcher.updateNumberOfVideoGames(this.userDataID, gameID, updatedQuantity);
        }
    }
    private void decreaseTheNumberOfGames(int caratule) {
        if (gameDataArray.length == 0) {
            System.out.println("No hay datos disponibles en la base de datos.");
            return;
        }

        if (numberOfVideoGames[currentPage][caratule] > 1) {
            numberOfVideoGames[currentPage][caratule] -= 1;
            refreshPage(currentPage);
            updateNumberOfVideoGamesLabels(currentPage);
            
            int positionGame = (currentPage * 5) + caratule;
            int gameID = gameIDArray[positionGame]; // ID del juego
            int updatedQuantity = numberOfVideoGames[currentPage][caratule]; // Cantidad actualizada de NumberOfVideoGames
            searcher.updateNumberOfVideoGames(this.userDataID, gameID, updatedQuantity);
        }
    }
    
    private void deleteGameFromList(int caratule) {
        if (gameDataArray.length == 0) {
            System.out.println("No hay datos disponibles en la base de datos.");
            return;
        }
        numberOfVideoGames[currentPage][caratule] = 0;

        //if (numberOfVideoGames[currentPage][caratule] == -1) {                            
                
                int positionGame = (currentPage * 5) + caratule;
                //if(gameIDArray.length + 2 < positionGame ){
                    int gameID = gameIDArray[positionGame]; // ID del juego
                    int updatedQuantity = numberOfVideoGames[currentPage][caratule]; // Cantidad actualizada de NumberOfVideoGames
                    searcher.updateNumberOfVideoGames(this.userDataID, gameID, updatedQuantity);
                    cartDatas.removeGameFromShoppingCart(this.userDataID, gameID);
                    updateGameDataArray();
                    System.out.println("juego borrado");
                    refreshPage(currentPage);
                    updateNumberOfVideoGamesLabels(currentPage);
               // }
            //}
            
        }
    




  

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        backGrounBlack = new javax.swing.JPanel();
        logPage = new javax.swing.JLabel();
        userProfileBoton = new javax.swing.JPanel();
        iconUserLabel = new javax.swing.JLabel();
        userNameLabel = new javax.swing.JLabel();
        totalPricePanel = new javax.swing.JPanel();
        totalPriceInfoLabel = new javax.swing.JLabel();
        backToCatalogBoton = new javax.swing.JPanel();
        titlePrice3 = new javax.swing.JLabel();
        backToTopBoton = new javax.swing.JPanel();
        titlePrice1 = new javax.swing.JLabel();
        titlePrice2 = new javax.swing.JLabel();
        backgroundListPanel = new javax.swing.JPanel();
        panelGame1 = new javax.swing.JPanel();
        caratuleGameImg1 = new javax.swing.JLabel();
        nameGame1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        priceTotalGameLabel1 = new javax.swing.JLabel();
        removeQuantitySetButton1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        removeGameFromListBoton1 = new javax.swing.JPanel();
        iconDelet1 = new javax.swing.JLabel();
        panelQuantitySet1 = new javax.swing.JPanel();
        quantityGameLabel1 = new javax.swing.JLabel();
        addGameToListButton1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        panelGame2 = new javax.swing.JPanel();
        caratuleGameImg2 = new javax.swing.JLabel();
        nameGame2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        priceTotalGameLabel2 = new javax.swing.JLabel();
        removeQuantitySetButton2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        removeGameFromListBoton2 = new javax.swing.JPanel();
        iconDelet2 = new javax.swing.JLabel();
        panelQuantitySet2 = new javax.swing.JPanel();
        quantityGameLabel2 = new javax.swing.JLabel();
        addGameToListButton2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        panelGame3 = new javax.swing.JPanel();
        caratuleGameImg3 = new javax.swing.JLabel();
        nameGame3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        priceTotalGameLabel3 = new javax.swing.JLabel();
        removeQuantitySetButton3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        removeGameFromListBoton3 = new javax.swing.JPanel();
        iconDelet3 = new javax.swing.JLabel();
        panelQuantitySet3 = new javax.swing.JPanel();
        quantityGameLabel3 = new javax.swing.JLabel();
        addGameToListButton3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        panelGame4 = new javax.swing.JPanel();
        caratuleGameImg4 = new javax.swing.JLabel();
        nameGame4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        priceTotalGameLabel4 = new javax.swing.JLabel();
        removeQuantitySetButton4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        removeGameFromListBoton4 = new javax.swing.JPanel();
        iconDelet4 = new javax.swing.JLabel();
        panelQuantitySet4 = new javax.swing.JPanel();
        quantityGameLabel4 = new javax.swing.JLabel();
        addGameToListButton4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        panelGame5 = new javax.swing.JPanel();
        caratuleGameImg5 = new javax.swing.JLabel();
        nameGame5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        priceTotalGameLabel5 = new javax.swing.JLabel();
        removeQuantitySetButton5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        removeGameFromListBoton5 = new javax.swing.JPanel();
        iconDelet5 = new javax.swing.JLabel();
        panelQuantitySet5 = new javax.swing.JPanel();
        quantityGameLabel5 = new javax.swing.JLabel();
        addGameToListButton5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        makeAPurchaseBoton = new javax.swing.JPanel();
        titlePrice4 = new javax.swing.JLabel();
        botonToMoveUpInTheList = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        nextPageBoton = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        numberOfPagesInTheListLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setPreferredSize(new java.awt.Dimension(1920, 1080));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backGrounBlack.setBackground(new java.awt.Color(0, 0, 0));
        backGrounBlack.setPreferredSize(new java.awt.Dimension(1920, 123));
        backGrounBlack.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logPage.setFont(new java.awt.Font("Liberation Sans", 1, 60)); // NOI18N
        logPage.setForeground(new java.awt.Color(255, 255, 255));
        logPage.setText("GAME ON");
        backGrounBlack.add(logPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 32, 326, 61));

        userProfileBoton.setBackground(new java.awt.Color(217, 217, 217));
        userProfileBoton.setPreferredSize(new java.awt.Dimension(404, 123));
        userProfileBoton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userProfileBotonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                userProfileBotonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                userProfileBotonMouseExited(evt);
            }
        });

        userNameLabel.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        userNameLabel.setText("oooooooooooooo");

        javax.swing.GroupLayout userProfileBotonLayout = new javax.swing.GroupLayout(userProfileBoton);
        userProfileBoton.setLayout(userProfileBotonLayout);
        userProfileBotonLayout.setHorizontalGroup(
            userProfileBotonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userProfileBotonLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(userNameLabel)
                .addGap(18, 18, 18)
                .addComponent(iconUserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        userProfileBotonLayout.setVerticalGroup(
            userProfileBotonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userProfileBotonLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(userProfileBotonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(iconUserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        backGrounBlack.add(userProfileBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1520, 0, -1, -1));

        background.add(backGrounBlack, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        totalPricePanel.setBackground(new java.awt.Color(217, 217, 217));
        totalPricePanel.setPreferredSize(new java.awt.Dimension(290, 70));

        totalPriceInfoLabel.setBackground(new java.awt.Color(0, 0, 0));
        totalPriceInfoLabel.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        totalPriceInfoLabel.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout totalPricePanelLayout = new javax.swing.GroupLayout(totalPricePanel);
        totalPricePanel.setLayout(totalPricePanelLayout);
        totalPricePanelLayout.setHorizontalGroup(
            totalPricePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, totalPricePanelLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(totalPriceInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        totalPricePanelLayout.setVerticalGroup(
            totalPricePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, totalPricePanelLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(totalPriceInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        background.add(totalPricePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1590, 410, -1, -1));

        backToCatalogBoton.setBackground(new java.awt.Color(0, 0, 0));
        backToCatalogBoton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backToCatalogBotonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backToCatalogBotonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backToCatalogBotonMouseExited(evt);
            }
        });

        titlePrice3.setBackground(new java.awt.Color(0, 0, 0));
        titlePrice3.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        titlePrice3.setForeground(new java.awt.Color(255, 255, 255));
        titlePrice3.setText("volver al catalogo");

        javax.swing.GroupLayout backToCatalogBotonLayout = new javax.swing.GroupLayout(backToCatalogBoton);
        backToCatalogBoton.setLayout(backToCatalogBotonLayout);
        backToCatalogBotonLayout.setHorizontalGroup(
            backToCatalogBotonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backToCatalogBotonLayout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addComponent(titlePrice3, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        backToCatalogBotonLayout.setVerticalGroup(
            backToCatalogBotonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backToCatalogBotonLayout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(titlePrice3)
                .addGap(27, 27, 27))
        );

        background.add(backToCatalogBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1520, 710, 400, -1));

        backToTopBoton.setBackground(new java.awt.Color(0, 0, 0));
        backToTopBoton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backToTopBotonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backToTopBotonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backToTopBotonMouseExited(evt);
            }
        });

        titlePrice1.setBackground(new java.awt.Color(0, 0, 0));
        titlePrice1.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        titlePrice1.setForeground(new java.awt.Color(255, 255, 255));
        titlePrice1.setText("volver al inicio");

        javax.swing.GroupLayout backToTopBotonLayout = new javax.swing.GroupLayout(backToTopBoton);
        backToTopBoton.setLayout(backToTopBotonLayout);
        backToTopBotonLayout.setHorizontalGroup(
            backToTopBotonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backToTopBotonLayout.createSequentialGroup()
                .addContainerGap(104, Short.MAX_VALUE)
                .addComponent(titlePrice1)
                .addGap(78, 78, 78))
        );
        backToTopBotonLayout.setVerticalGroup(
            backToTopBotonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backToTopBotonLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(titlePrice1)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        background.add(backToTopBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1520, 840, -1, -1));

        titlePrice2.setBackground(new java.awt.Color(0, 0, 0));
        titlePrice2.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        titlePrice2.setForeground(new java.awt.Color(0, 0, 0));
        titlePrice2.setText("Precio total");
        background.add(titlePrice2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1640, 360, 200, -1));

        backgroundListPanel.setBackground(new java.awt.Color(217, 217, 217));
        backgroundListPanel.setPreferredSize(new java.awt.Dimension(1478, 888));
        backgroundListPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelGame1.setBackground(new java.awt.Color(255, 255, 255));
        panelGame1.setPreferredSize(new java.awt.Dimension(1000, 140));
        panelGame1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelGame1.add(caratuleGameImg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 140));

        nameGame1.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        panelGame1.add(nameGame1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 720, 60));

        jPanel1.setBackground(new java.awt.Color(217, 217, 217));
        jPanel1.setForeground(new java.awt.Color(217, 217, 217));
        jPanel1.setPreferredSize(new java.awt.Dimension(126, 45));

        priceTotalGameLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        priceTotalGameLabel1.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(priceTotalGameLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(priceTotalGameLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelGame1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 60, -1, 40));

        removeQuantitySetButton1.setBackground(new java.awt.Color(240, 150, 150));
        removeQuantitySetButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeQuantitySetButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                removeQuantitySetButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                removeQuantitySetButton1MouseExited(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("<");

        javax.swing.GroupLayout removeQuantitySetButton1Layout = new javax.swing.GroupLayout(removeQuantitySetButton1);
        removeQuantitySetButton1.setLayout(removeQuantitySetButton1Layout);
        removeQuantitySetButton1Layout.setHorizontalGroup(
            removeQuantitySetButton1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(removeQuantitySetButton1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        removeQuantitySetButton1Layout.setVerticalGroup(
            removeQuantitySetButton1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(removeQuantitySetButton1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        panelGame1.add(removeQuantitySetButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 50, 40, 50));

        removeGameFromListBoton1.setBackground(new java.awt.Color(208, 89, 89));
        removeGameFromListBoton1.setPreferredSize(new java.awt.Dimension(140, 140));
        removeGameFromListBoton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeGameFromListBoton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                removeGameFromListBoton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                removeGameFromListBoton1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout removeGameFromListBoton1Layout = new javax.swing.GroupLayout(removeGameFromListBoton1);
        removeGameFromListBoton1.setLayout(removeGameFromListBoton1Layout);
        removeGameFromListBoton1Layout.setHorizontalGroup(
            removeGameFromListBoton1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(removeGameFromListBoton1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(iconDelet1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        removeGameFromListBoton1Layout.setVerticalGroup(
            removeGameFromListBoton1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(removeGameFromListBoton1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(iconDelet1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        panelGame1.add(removeGameFromListBoton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 0, 130, 140));

        panelQuantitySet1.setBackground(new java.awt.Color(217, 217, 217));

        quantityGameLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N

        javax.swing.GroupLayout panelQuantitySet1Layout = new javax.swing.GroupLayout(panelQuantitySet1);
        panelQuantitySet1.setLayout(panelQuantitySet1Layout);
        panelQuantitySet1Layout.setHorizontalGroup(
            panelQuantitySet1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelQuantitySet1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(quantityGameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        panelQuantitySet1Layout.setVerticalGroup(
            panelQuantitySet1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelQuantitySet1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(quantityGameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        panelGame1.add(panelQuantitySet1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 30, 80, 90));

        addGameToListButton1.setBackground(new java.awt.Color(175, 251, 173));
        addGameToListButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addGameToListButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addGameToListButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addGameToListButton1MouseExited(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText(">");

        javax.swing.GroupLayout addGameToListButton1Layout = new javax.swing.GroupLayout(addGameToListButton1);
        addGameToListButton1.setLayout(addGameToListButton1Layout);
        addGameToListButton1Layout.setHorizontalGroup(
            addGameToListButton1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addGameToListButton1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        addGameToListButton1Layout.setVerticalGroup(
            addGameToListButton1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addGameToListButton1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(14, 14, 14))
        );

        panelGame1.add(addGameToListButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 50, -1, -1));

        backgroundListPanel.add(panelGame1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1490, -1));

        panelGame2.setBackground(new java.awt.Color(255, 255, 255));
        panelGame2.setPreferredSize(new java.awt.Dimension(1000, 140));
        panelGame2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelGame2.add(caratuleGameImg2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 140));

        nameGame2.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        panelGame2.add(nameGame2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 720, 60));

        jPanel2.setBackground(new java.awt.Color(217, 217, 217));
        jPanel2.setForeground(new java.awt.Color(217, 217, 217));
        jPanel2.setPreferredSize(new java.awt.Dimension(126, 45));

        priceTotalGameLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        priceTotalGameLabel2.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(priceTotalGameLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(priceTotalGameLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelGame2.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 60, -1, 40));

        removeQuantitySetButton2.setBackground(new java.awt.Color(240, 150, 150));
        removeQuantitySetButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeQuantitySetButton2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                removeQuantitySetButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                removeQuantitySetButton2MouseExited(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("<");

        javax.swing.GroupLayout removeQuantitySetButton2Layout = new javax.swing.GroupLayout(removeQuantitySetButton2);
        removeQuantitySetButton2.setLayout(removeQuantitySetButton2Layout);
        removeQuantitySetButton2Layout.setHorizontalGroup(
            removeQuantitySetButton2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(removeQuantitySetButton2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel5)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        removeQuantitySetButton2Layout.setVerticalGroup(
            removeQuantitySetButton2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(removeQuantitySetButton2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel5)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        panelGame2.add(removeQuantitySetButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 50, 40, 50));

        removeGameFromListBoton2.setBackground(new java.awt.Color(208, 89, 89));
        removeGameFromListBoton2.setPreferredSize(new java.awt.Dimension(140, 140));
        removeGameFromListBoton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeGameFromListBoton2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                removeGameFromListBoton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                removeGameFromListBoton2MouseExited(evt);
            }
        });

        javax.swing.GroupLayout removeGameFromListBoton2Layout = new javax.swing.GroupLayout(removeGameFromListBoton2);
        removeGameFromListBoton2.setLayout(removeGameFromListBoton2Layout);
        removeGameFromListBoton2Layout.setHorizontalGroup(
            removeGameFromListBoton2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(removeGameFromListBoton2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(iconDelet2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        removeGameFromListBoton2Layout.setVerticalGroup(
            removeGameFromListBoton2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(removeGameFromListBoton2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(iconDelet2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        panelGame2.add(removeGameFromListBoton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 0, 130, 140));

        panelQuantitySet2.setBackground(new java.awt.Color(217, 217, 217));

        quantityGameLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N

        javax.swing.GroupLayout panelQuantitySet2Layout = new javax.swing.GroupLayout(panelQuantitySet2);
        panelQuantitySet2.setLayout(panelQuantitySet2Layout);
        panelQuantitySet2Layout.setHorizontalGroup(
            panelQuantitySet2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelQuantitySet2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(quantityGameLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        panelQuantitySet2Layout.setVerticalGroup(
            panelQuantitySet2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelQuantitySet2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(quantityGameLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        panelGame2.add(panelQuantitySet2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 30, 80, 90));

        addGameToListButton2.setBackground(new java.awt.Color(175, 251, 173));
        addGameToListButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addGameToListButton2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addGameToListButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addGameToListButton2MouseExited(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText(">");

        javax.swing.GroupLayout addGameToListButton2Layout = new javax.swing.GroupLayout(addGameToListButton2);
        addGameToListButton2.setLayout(addGameToListButton2Layout);
        addGameToListButton2Layout.setHorizontalGroup(
            addGameToListButton2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addGameToListButton2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel6)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        addGameToListButton2Layout.setVerticalGroup(
            addGameToListButton2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addGameToListButton2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(14, 14, 14))
        );

        panelGame2.add(addGameToListButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 50, -1, -1));

        backgroundListPanel.add(panelGame2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 1490, -1));

        panelGame3.setBackground(new java.awt.Color(255, 255, 255));
        panelGame3.setPreferredSize(new java.awt.Dimension(1000, 140));
        panelGame3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelGame3.add(caratuleGameImg3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 140));

        nameGame3.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        panelGame3.add(nameGame3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 720, 60));

        jPanel3.setBackground(new java.awt.Color(217, 217, 217));
        jPanel3.setForeground(new java.awt.Color(217, 217, 217));
        jPanel3.setPreferredSize(new java.awt.Dimension(126, 45));

        priceTotalGameLabel3.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        priceTotalGameLabel3.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(priceTotalGameLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(priceTotalGameLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelGame3.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 60, -1, 40));

        removeQuantitySetButton3.setBackground(new java.awt.Color(240, 150, 150));
        removeQuantitySetButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeQuantitySetButton3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                removeQuantitySetButton3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                removeQuantitySetButton3MouseExited(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("<");

        javax.swing.GroupLayout removeQuantitySetButton3Layout = new javax.swing.GroupLayout(removeQuantitySetButton3);
        removeQuantitySetButton3.setLayout(removeQuantitySetButton3Layout);
        removeQuantitySetButton3Layout.setHorizontalGroup(
            removeQuantitySetButton3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(removeQuantitySetButton3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel7)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        removeQuantitySetButton3Layout.setVerticalGroup(
            removeQuantitySetButton3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(removeQuantitySetButton3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel7)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        panelGame3.add(removeQuantitySetButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 50, 40, 50));

        removeGameFromListBoton3.setBackground(new java.awt.Color(208, 89, 89));
        removeGameFromListBoton3.setPreferredSize(new java.awt.Dimension(140, 140));
        removeGameFromListBoton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeGameFromListBoton3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                removeGameFromListBoton3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                removeGameFromListBoton3MouseExited(evt);
            }
        });

        javax.swing.GroupLayout removeGameFromListBoton3Layout = new javax.swing.GroupLayout(removeGameFromListBoton3);
        removeGameFromListBoton3.setLayout(removeGameFromListBoton3Layout);
        removeGameFromListBoton3Layout.setHorizontalGroup(
            removeGameFromListBoton3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(removeGameFromListBoton3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(iconDelet3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        removeGameFromListBoton3Layout.setVerticalGroup(
            removeGameFromListBoton3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(removeGameFromListBoton3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(iconDelet3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        panelGame3.add(removeGameFromListBoton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 0, 130, 140));

        panelQuantitySet3.setBackground(new java.awt.Color(217, 217, 217));

        quantityGameLabel3.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N

        javax.swing.GroupLayout panelQuantitySet3Layout = new javax.swing.GroupLayout(panelQuantitySet3);
        panelQuantitySet3.setLayout(panelQuantitySet3Layout);
        panelQuantitySet3Layout.setHorizontalGroup(
            panelQuantitySet3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelQuantitySet3Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(quantityGameLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        panelQuantitySet3Layout.setVerticalGroup(
            panelQuantitySet3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelQuantitySet3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(quantityGameLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        panelGame3.add(panelQuantitySet3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 30, 80, 90));

        addGameToListButton3.setBackground(new java.awt.Color(175, 251, 173));
        addGameToListButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addGameToListButton3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addGameToListButton3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addGameToListButton3MouseExited(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText(">");

        javax.swing.GroupLayout addGameToListButton3Layout = new javax.swing.GroupLayout(addGameToListButton3);
        addGameToListButton3.setLayout(addGameToListButton3Layout);
        addGameToListButton3Layout.setHorizontalGroup(
            addGameToListButton3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addGameToListButton3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel8)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        addGameToListButton3Layout.setVerticalGroup(
            addGameToListButton3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addGameToListButton3Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(14, 14, 14))
        );

        panelGame3.add(addGameToListButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 50, -1, -1));

        backgroundListPanel.add(panelGame3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 1490, -1));

        panelGame4.setBackground(new java.awt.Color(255, 255, 255));
        panelGame4.setPreferredSize(new java.awt.Dimension(1000, 140));
        panelGame4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelGame4.add(caratuleGameImg4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 140));

        nameGame4.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        panelGame4.add(nameGame4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 720, 60));

        jPanel4.setBackground(new java.awt.Color(217, 217, 217));
        jPanel4.setForeground(new java.awt.Color(217, 217, 217));
        jPanel4.setPreferredSize(new java.awt.Dimension(126, 45));

        priceTotalGameLabel4.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        priceTotalGameLabel4.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(priceTotalGameLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(priceTotalGameLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelGame4.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 60, -1, 40));

        removeQuantitySetButton4.setBackground(new java.awt.Color(240, 150, 150));
        removeQuantitySetButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeQuantitySetButton4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                removeQuantitySetButton4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                removeQuantitySetButton4MouseExited(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("<");

        javax.swing.GroupLayout removeQuantitySetButton4Layout = new javax.swing.GroupLayout(removeQuantitySetButton4);
        removeQuantitySetButton4.setLayout(removeQuantitySetButton4Layout);
        removeQuantitySetButton4Layout.setHorizontalGroup(
            removeQuantitySetButton4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(removeQuantitySetButton4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel9)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        removeQuantitySetButton4Layout.setVerticalGroup(
            removeQuantitySetButton4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(removeQuantitySetButton4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel9)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        panelGame4.add(removeQuantitySetButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 50, 40, 50));

        removeGameFromListBoton4.setBackground(new java.awt.Color(208, 89, 89));
        removeGameFromListBoton4.setPreferredSize(new java.awt.Dimension(140, 140));
        removeGameFromListBoton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeGameFromListBoton4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                removeGameFromListBoton4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                removeGameFromListBoton4MouseExited(evt);
            }
        });

        javax.swing.GroupLayout removeGameFromListBoton4Layout = new javax.swing.GroupLayout(removeGameFromListBoton4);
        removeGameFromListBoton4.setLayout(removeGameFromListBoton4Layout);
        removeGameFromListBoton4Layout.setHorizontalGroup(
            removeGameFromListBoton4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(removeGameFromListBoton4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(iconDelet4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        removeGameFromListBoton4Layout.setVerticalGroup(
            removeGameFromListBoton4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(removeGameFromListBoton4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(iconDelet4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        panelGame4.add(removeGameFromListBoton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 0, 130, 140));

        panelQuantitySet4.setBackground(new java.awt.Color(217, 217, 217));

        quantityGameLabel4.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N

        javax.swing.GroupLayout panelQuantitySet4Layout = new javax.swing.GroupLayout(panelQuantitySet4);
        panelQuantitySet4.setLayout(panelQuantitySet4Layout);
        panelQuantitySet4Layout.setHorizontalGroup(
            panelQuantitySet4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelQuantitySet4Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(quantityGameLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        panelQuantitySet4Layout.setVerticalGroup(
            panelQuantitySet4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelQuantitySet4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(quantityGameLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        panelGame4.add(panelQuantitySet4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 30, 80, 90));

        addGameToListButton4.setBackground(new java.awt.Color(175, 251, 173));
        addGameToListButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addGameToListButton4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addGameToListButton4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addGameToListButton4MouseExited(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText(">");

        javax.swing.GroupLayout addGameToListButton4Layout = new javax.swing.GroupLayout(addGameToListButton4);
        addGameToListButton4.setLayout(addGameToListButton4Layout);
        addGameToListButton4Layout.setHorizontalGroup(
            addGameToListButton4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addGameToListButton4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel10)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        addGameToListButton4Layout.setVerticalGroup(
            addGameToListButton4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addGameToListButton4Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(14, 14, 14))
        );

        panelGame4.add(addGameToListButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 50, -1, -1));

        backgroundListPanel.add(panelGame4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 1490, -1));

        panelGame5.setBackground(new java.awt.Color(255, 255, 255));
        panelGame5.setPreferredSize(new java.awt.Dimension(1000, 140));
        panelGame5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelGame5.add(caratuleGameImg5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 140));

        nameGame5.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        panelGame5.add(nameGame5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 720, 60));

        jPanel5.setBackground(new java.awt.Color(217, 217, 217));
        jPanel5.setForeground(new java.awt.Color(217, 217, 217));
        jPanel5.setPreferredSize(new java.awt.Dimension(126, 45));

        priceTotalGameLabel5.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        priceTotalGameLabel5.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(priceTotalGameLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(priceTotalGameLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelGame5.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 60, -1, 40));

        removeQuantitySetButton5.setBackground(new java.awt.Color(240, 150, 150));
        removeQuantitySetButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeQuantitySetButton5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                removeQuantitySetButton5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                removeQuantitySetButton5MouseExited(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("<");

        javax.swing.GroupLayout removeQuantitySetButton5Layout = new javax.swing.GroupLayout(removeQuantitySetButton5);
        removeQuantitySetButton5.setLayout(removeQuantitySetButton5Layout);
        removeQuantitySetButton5Layout.setHorizontalGroup(
            removeQuantitySetButton5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(removeQuantitySetButton5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel11)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        removeQuantitySetButton5Layout.setVerticalGroup(
            removeQuantitySetButton5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(removeQuantitySetButton5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel11)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        panelGame5.add(removeQuantitySetButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 50, 40, 50));

        removeGameFromListBoton5.setBackground(new java.awt.Color(208, 89, 89));
        removeGameFromListBoton5.setPreferredSize(new java.awt.Dimension(140, 140));
        removeGameFromListBoton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeGameFromListBoton5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                removeGameFromListBoton5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                removeGameFromListBoton5MouseExited(evt);
            }
        });

        javax.swing.GroupLayout removeGameFromListBoton5Layout = new javax.swing.GroupLayout(removeGameFromListBoton5);
        removeGameFromListBoton5.setLayout(removeGameFromListBoton5Layout);
        removeGameFromListBoton5Layout.setHorizontalGroup(
            removeGameFromListBoton5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(removeGameFromListBoton5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(iconDelet5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        removeGameFromListBoton5Layout.setVerticalGroup(
            removeGameFromListBoton5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(removeGameFromListBoton5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(iconDelet5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        panelGame5.add(removeGameFromListBoton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 0, 130, 140));

        panelQuantitySet5.setBackground(new java.awt.Color(217, 217, 217));

        quantityGameLabel5.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N

        javax.swing.GroupLayout panelQuantitySet5Layout = new javax.swing.GroupLayout(panelQuantitySet5);
        panelQuantitySet5.setLayout(panelQuantitySet5Layout);
        panelQuantitySet5Layout.setHorizontalGroup(
            panelQuantitySet5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelQuantitySet5Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(quantityGameLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        panelQuantitySet5Layout.setVerticalGroup(
            panelQuantitySet5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelQuantitySet5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(quantityGameLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        panelGame5.add(panelQuantitySet5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 30, 80, 90));

        addGameToListButton5.setBackground(new java.awt.Color(175, 251, 173));
        addGameToListButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addGameToListButton5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addGameToListButton5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addGameToListButton5MouseExited(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText(">");

        javax.swing.GroupLayout addGameToListButton5Layout = new javax.swing.GroupLayout(addGameToListButton5);
        addGameToListButton5.setLayout(addGameToListButton5Layout);
        addGameToListButton5Layout.setHorizontalGroup(
            addGameToListButton5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addGameToListButton5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel12)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        addGameToListButton5Layout.setVerticalGroup(
            addGameToListButton5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addGameToListButton5Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(14, 14, 14))
        );

        panelGame5.add(addGameToListButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 50, -1, -1));

        backgroundListPanel.add(panelGame5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 650, 1490, -1));

        background.add(backgroundListPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 1510, 800));

        makeAPurchaseBoton.setBackground(new java.awt.Color(139, 215, 132));
        makeAPurchaseBoton.setForeground(new java.awt.Color(139, 215, 132));
        makeAPurchaseBoton.setPreferredSize(new java.awt.Dimension(326, 120));
        makeAPurchaseBoton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                makeAPurchaseBotonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                makeAPurchaseBotonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                makeAPurchaseBotonMouseExited(evt);
            }
        });

        titlePrice4.setBackground(new java.awt.Color(0, 0, 0));
        titlePrice4.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        titlePrice4.setForeground(new java.awt.Color(255, 255, 255));
        titlePrice4.setText("Realizar Compra");

        javax.swing.GroupLayout makeAPurchaseBotonLayout = new javax.swing.GroupLayout(makeAPurchaseBoton);
        makeAPurchaseBoton.setLayout(makeAPurchaseBotonLayout);
        makeAPurchaseBotonLayout.setHorizontalGroup(
            makeAPurchaseBotonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, makeAPurchaseBotonLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(titlePrice4)
                .addGap(34, 34, 34))
        );
        makeAPurchaseBotonLayout.setVerticalGroup(
            makeAPurchaseBotonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, makeAPurchaseBotonLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(titlePrice4)
                .addGap(36, 36, 36))
        );

        background.add(makeAPurchaseBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1560, 520, 340, -1));

        botonToMoveUpInTheList.setBackground(new java.awt.Color(217, 217, 217));
        botonToMoveUpInTheList.setPreferredSize(new java.awt.Dimension(650, 50));
        botonToMoveUpInTheList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonToMoveUpInTheListMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonToMoveUpInTheListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonToMoveUpInTheListMouseExited(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("atras");

        javax.swing.GroupLayout botonToMoveUpInTheListLayout = new javax.swing.GroupLayout(botonToMoveUpInTheList);
        botonToMoveUpInTheList.setLayout(botonToMoveUpInTheListLayout);
        botonToMoveUpInTheListLayout.setHorizontalGroup(
            botonToMoveUpInTheListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonToMoveUpInTheListLayout.createSequentialGroup()
                .addGap(308, 308, 308)
                .addComponent(jLabel4)
                .addContainerGap(349, Short.MAX_VALUE))
        );
        botonToMoveUpInTheListLayout.setVerticalGroup(
            botonToMoveUpInTheListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonToMoveUpInTheListLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        background.add(botonToMoveUpInTheList, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 950, 710, 30));

        nextPageBoton.setBackground(new java.awt.Color(217, 217, 217));
        nextPageBoton.setPreferredSize(new java.awt.Dimension(650, 50));
        nextPageBoton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextPageBotonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nextPageBotonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nextPageBotonMouseExited(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("siguiente");

        javax.swing.GroupLayout nextPageBotonLayout = new javax.swing.GroupLayout(nextPageBoton);
        nextPageBoton.setLayout(nextPageBotonLayout);
        nextPageBotonLayout.setHorizontalGroup(
            nextPageBotonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nextPageBotonLayout.createSequentialGroup()
                .addContainerGap(294, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(319, 319, 319))
        );
        nextPageBotonLayout.setVerticalGroup(
            nextPageBotonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nextPageBotonLayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        background.add(nextPageBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 950, 710, 30));

        numberOfPagesInTheListLabel.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        numberOfPagesInTheListLabel.setForeground(new java.awt.Color(0, 0, 0));
        background.add(numberOfPagesInTheListLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 950, 50, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//realizar compra
    private void makeAPurchaseBotonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_makeAPurchaseBotonMouseClicked

    updateNumberOfVideoGamesLabels(currentPage); // Actualiza el precio total antes de imprimirlo
    System.out.println(totalPrice);

   
    

    // Verificar la disponibilidad de claves para el carrito de compras del usuario
    boolean disponibilidadClaves = verificarDisponibilidadClaves(this.userDataID);

    System.out.println("Disponibilidad de claves: " + disponibilidadClaves);

    // Abrir la ventana CardPaymentUi si hay disponibilidad de claves
    if (disponibilidadClaves) {
        CardPaymentUi cardPaymentUi = new CardPaymentUi(this.totalPrice);
        cardPaymentUi.setVisible(true);
        
    } else {
        // Mostrar ventana emergente de error de claves
        String mensajeError = "Error de claves: Algunos juegos no tienen suficiente cantidad de llaves.\n\n";

        JOptionPane.showMessageDialog(this, mensajeError, "Error de claves", JOptionPane.ERROR_MESSAGE);
    }
    
 

    }//GEN-LAST:event_makeAPurchaseBotonMouseClicked

    private void makeAPurchaseBotonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_makeAPurchaseBotonMouseEntered
        makeAPurchaseBoton.setBackground(new Color(59,193,46));
    }//GEN-LAST:event_makeAPurchaseBotonMouseEntered

    private void makeAPurchaseBotonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_makeAPurchaseBotonMouseExited
        makeAPurchaseBoton.setBackground(new Color(139,215,132));
    }//GEN-LAST:event_makeAPurchaseBotonMouseExited

    private void backToCatalogBotonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backToCatalogBotonMouseClicked
        Pagination pag = new Pagination(userDataID);
        pag.setVisible(true);
        dispose();
    }//GEN-LAST:event_backToCatalogBotonMouseClicked

    private void backToCatalogBotonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backToCatalogBotonMouseEntered
        backToCatalogBoton.setBackground(new Color(108,90,90));
    }//GEN-LAST:event_backToCatalogBotonMouseEntered

    private void backToCatalogBotonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backToCatalogBotonMouseExited
        backToCatalogBoton.setBackground(Color.black);
    }//GEN-LAST:event_backToCatalogBotonMouseExited

    private void backToTopBotonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backToTopBotonMouseClicked
        HomePage home = new HomePage(userDataID);
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_backToTopBotonMouseClicked

    private void backToTopBotonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backToTopBotonMouseEntered
        backToTopBoton.setBackground(new Color(108,90,90));
    }//GEN-LAST:event_backToTopBotonMouseEntered

    private void backToTopBotonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backToTopBotonMouseExited
        backToTopBoton.setBackground(Color.black);
    }//GEN-LAST:event_backToTopBotonMouseExited

    private void botonToMoveUpInTheListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonToMoveUpInTheListMouseClicked
        if (currentPage <= gameDataArray.length - 1 && currentPage > 0) {
            currentPage--;
            cartDatas = new ShoppingCartDatas();
            refreshPage(currentPage);
            updateNumberOfVideoGamesLabels(currentPage);
            
        }
        
        System.out.println(currentPage);
    }//GEN-LAST:event_botonToMoveUpInTheListMouseClicked

    private void botonToMoveUpInTheListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonToMoveUpInTheListMouseEntered
        botonToMoveUpInTheList.setBackground(new Color(136,152,136));
    }//GEN-LAST:event_botonToMoveUpInTheListMouseEntered

    private void botonToMoveUpInTheListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonToMoveUpInTheListMouseExited
        botonToMoveUpInTheList.setBackground(new Color(217,217,217));
    }//GEN-LAST:event_botonToMoveUpInTheListMouseExited


    private void nextPageBotonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextPageBotonMouseClicked
        if (currentPage < gameDataArray.length - 1) {
            currentPage++;
            refreshPage(currentPage);
            updateNumberOfVideoGamesLabels(currentPage);
            
        }
        
        System.out.println(currentPage);
        
    }//GEN-LAST:event_nextPageBotonMouseClicked

    private void nextPageBotonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextPageBotonMouseEntered
        nextPageBoton.setBackground(new Color(154,129,129));
    }//GEN-LAST:event_nextPageBotonMouseEntered

    private void nextPageBotonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextPageBotonMouseExited
        nextPageBoton.setBackground(new Color(217,217,217));
    }//GEN-LAST:event_nextPageBotonMouseExited

    private void userProfileBotonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userProfileBotonMouseClicked
        UserProfile user = new UserProfile(userDataID);
        user.setVisible(true);
        dispose();
    }//GEN-LAST:event_userProfileBotonMouseClicked

    private void userProfileBotonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userProfileBotonMouseEntered
        userProfileBoton.setBackground(new Color(135,180,189));
    }//GEN-LAST:event_userProfileBotonMouseEntered

    private void userProfileBotonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userProfileBotonMouseExited
        userProfileBoton.setBackground(new Color(217,217,217));
    }//GEN-LAST:event_userProfileBotonMouseExited
//list1-------------------------------------------------------------------------------------------------
    private void removeGameFromListBoton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeGameFromListBoton1MouseClicked
        deleteGameFromList(0);
    }//GEN-LAST:event_removeGameFromListBoton1MouseClicked

    private void removeGameFromListBoton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeGameFromListBoton1MouseEntered
        removeGameFromListBoton1.setBackground(Color.red);
    }//GEN-LAST:event_removeGameFromListBoton1MouseEntered

    private void removeGameFromListBoton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeGameFromListBoton1MouseExited
        removeGameFromListBoton1.setBackground(new Color(208,89,89));
    }//GEN-LAST:event_removeGameFromListBoton1MouseExited

    private void addGameToListButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addGameToListButton1MouseClicked
        
    gameDataArray = cartDatas.generatePaginationArray(unpurchasedGameIDs);
        addGameToList(0);
    }//GEN-LAST:event_addGameToListButton1MouseClicked

    private void addGameToListButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addGameToListButton1MouseEntered
        addGameToListButton1.setBackground(new Color(120,211,117));
    }//GEN-LAST:event_addGameToListButton1MouseEntered

    private void addGameToListButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addGameToListButton1MouseExited
        addGameToListButton1.setBackground(new Color(175,251,173));
    }//GEN-LAST:event_addGameToListButton1MouseExited

    private void removeQuantitySetButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeQuantitySetButton1MouseClicked
        decreaseTheNumberOfGames(0);
    }//GEN-LAST:event_removeQuantitySetButton1MouseClicked

    private void removeQuantitySetButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeQuantitySetButton1MouseEntered
        removeQuantitySetButton1.setBackground(new Color(202,92,92));
    }//GEN-LAST:event_removeQuantitySetButton1MouseEntered

    private void removeQuantitySetButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeQuantitySetButton1MouseExited
        removeQuantitySetButton1.setBackground(new Color(240,150,150));
    }//GEN-LAST:event_removeQuantitySetButton1MouseExited
//list2-----------------------------------------------------------------------------------------
    private void removeQuantitySetButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeQuantitySetButton2MouseClicked
        decreaseTheNumberOfGames(1);
    }//GEN-LAST:event_removeQuantitySetButton2MouseClicked

    private void removeQuantitySetButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeQuantitySetButton2MouseEntered
        removeQuantitySetButton2.setBackground(new Color(202,92,92));
    }//GEN-LAST:event_removeQuantitySetButton2MouseEntered

    private void removeQuantitySetButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeQuantitySetButton2MouseExited
        removeQuantitySetButton2.setBackground(new Color(240,150,150));
    }//GEN-LAST:event_removeQuantitySetButton2MouseExited

    private void removeGameFromListBoton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeGameFromListBoton2MouseClicked
        deleteGameFromList(1);
    }//GEN-LAST:event_removeGameFromListBoton2MouseClicked

    private void removeGameFromListBoton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeGameFromListBoton2MouseEntered
        removeGameFromListBoton2.setBackground(Color.red);
    }//GEN-LAST:event_removeGameFromListBoton2MouseEntered

    private void removeGameFromListBoton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeGameFromListBoton2MouseExited
        removeGameFromListBoton2.setBackground(new Color(208,89,89));
    }//GEN-LAST:event_removeGameFromListBoton2MouseExited

    private void addGameToListButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addGameToListButton2MouseClicked
        addGameToList(1);
        
    }//GEN-LAST:event_addGameToListButton2MouseClicked

    private void addGameToListButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addGameToListButton2MouseEntered
        addGameToListButton2.setBackground(new Color(120,211,117));
    }//GEN-LAST:event_addGameToListButton2MouseEntered

    private void addGameToListButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addGameToListButton2MouseExited
        addGameToListButton2.setBackground(new Color(175,251,173));
    }//GEN-LAST:event_addGameToListButton2MouseExited
//list3-----------------------------------------------------------------------------------------
    private void removeQuantitySetButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeQuantitySetButton3MouseClicked
        decreaseTheNumberOfGames(2);
    }//GEN-LAST:event_removeQuantitySetButton3MouseClicked

    private void removeQuantitySetButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeQuantitySetButton3MouseEntered
        removeQuantitySetButton3.setBackground(new Color(202,92,92));
    }//GEN-LAST:event_removeQuantitySetButton3MouseEntered

    private void removeQuantitySetButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeQuantitySetButton3MouseExited
        removeQuantitySetButton3.setBackground(new Color(240,150,150));
    }//GEN-LAST:event_removeQuantitySetButton3MouseExited

    private void removeGameFromListBoton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeGameFromListBoton3MouseClicked
        deleteGameFromList(2);
    }//GEN-LAST:event_removeGameFromListBoton3MouseClicked

    private void removeGameFromListBoton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeGameFromListBoton3MouseEntered
        removeGameFromListBoton3.setBackground(Color.red);
    }//GEN-LAST:event_removeGameFromListBoton3MouseEntered

    private void removeGameFromListBoton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeGameFromListBoton3MouseExited
        removeGameFromListBoton3.setBackground(new Color(208,89,89));
    }//GEN-LAST:event_removeGameFromListBoton3MouseExited

    private void addGameToListButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addGameToListButton3MouseClicked
        addGameToList(2); 
    }//GEN-LAST:event_addGameToListButton3MouseClicked

    private void addGameToListButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addGameToListButton3MouseEntered
        addGameToListButton3.setBackground(new Color(120,211,117));
    }//GEN-LAST:event_addGameToListButton3MouseEntered

    private void addGameToListButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addGameToListButton3MouseExited
        addGameToListButton3.setBackground(new Color(175,251,173));
    }//GEN-LAST:event_addGameToListButton3MouseExited
//list4-----------------------------------------------------------------------------------------
    private void removeQuantitySetButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeQuantitySetButton4MouseClicked
        decreaseTheNumberOfGames(3);
    }//GEN-LAST:event_removeQuantitySetButton4MouseClicked

    private void removeQuantitySetButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeQuantitySetButton4MouseEntered
        removeQuantitySetButton4.setBackground(new Color(202,92,92));
    }//GEN-LAST:event_removeQuantitySetButton4MouseEntered

    private void removeQuantitySetButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeQuantitySetButton4MouseExited
        removeQuantitySetButton4.setBackground(new Color(240,150,150));
    }//GEN-LAST:event_removeQuantitySetButton4MouseExited

    private void removeGameFromListBoton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeGameFromListBoton4MouseClicked
        deleteGameFromList(3);
    }//GEN-LAST:event_removeGameFromListBoton4MouseClicked

    private void removeGameFromListBoton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeGameFromListBoton4MouseEntered
        removeGameFromListBoton4.setBackground(Color.red);
    }//GEN-LAST:event_removeGameFromListBoton4MouseEntered

    private void removeGameFromListBoton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeGameFromListBoton4MouseExited
        removeGameFromListBoton4.setBackground(new Color(208,89,89));
    }//GEN-LAST:event_removeGameFromListBoton4MouseExited

    private void addGameToListButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addGameToListButton4MouseClicked
        addGameToList(3);
    }//GEN-LAST:event_addGameToListButton4MouseClicked

    private void addGameToListButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addGameToListButton4MouseEntered
        addGameToListButton4.setBackground(new Color(120,211,117));
    }//GEN-LAST:event_addGameToListButton4MouseEntered

    private void addGameToListButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addGameToListButton4MouseExited
        addGameToListButton4.setBackground(new Color(175,251,173));
    }//GEN-LAST:event_addGameToListButton4MouseExited
//list5----------------------------------------------------------------------------------------
    private void removeQuantitySetButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeQuantitySetButton5MouseClicked
        decreaseTheNumberOfGames(4);
    }//GEN-LAST:event_removeQuantitySetButton5MouseClicked

    private void removeQuantitySetButton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeQuantitySetButton5MouseEntered
        removeQuantitySetButton5.setBackground(new Color(202,92,92));
    }//GEN-LAST:event_removeQuantitySetButton5MouseEntered

    private void removeQuantitySetButton5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeQuantitySetButton5MouseExited
        removeQuantitySetButton5.setBackground(new Color(240,150,150));
    }//GEN-LAST:event_removeQuantitySetButton5MouseExited

    private void removeGameFromListBoton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeGameFromListBoton5MouseClicked
        deleteGameFromList(4);
    }//GEN-LAST:event_removeGameFromListBoton5MouseClicked

    private void removeGameFromListBoton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeGameFromListBoton5MouseEntered
        removeGameFromListBoton5.setBackground(Color.red);
    }//GEN-LAST:event_removeGameFromListBoton5MouseEntered

    private void removeGameFromListBoton5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeGameFromListBoton5MouseExited
        removeGameFromListBoton5.setBackground(new Color(208,89,89));
    }//GEN-LAST:event_removeGameFromListBoton5MouseExited

    private void addGameToListButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addGameToListButton5MouseClicked
        addGameToList(4); 
    }//GEN-LAST:event_addGameToListButton5MouseClicked

    private void addGameToListButton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addGameToListButton5MouseEntered
        addGameToListButton5.setBackground(new Color(120,211,117));
    }//GEN-LAST:event_addGameToListButton5MouseEntered

    private void addGameToListButton5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addGameToListButton5MouseExited
        addGameToListButton5.setBackground(new Color(175,251,173));
    }//GEN-LAST:event_addGameToListButton5MouseExited

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
            java.util.logging.Logger.getLogger(CarritoCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CarritoCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CarritoCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CarritoCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CarritoCompras().setVisible(true);
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
    private javax.swing.JPanel addGameToListButton1;
    private javax.swing.JPanel addGameToListButton2;
    private javax.swing.JPanel addGameToListButton3;
    private javax.swing.JPanel addGameToListButton4;
    private javax.swing.JPanel addGameToListButton5;
    private javax.swing.JPanel backGrounBlack;
    private javax.swing.JPanel backToCatalogBoton;
    private javax.swing.JPanel backToTopBoton;
    private javax.swing.JPanel background;
    private javax.swing.JPanel backgroundListPanel;
    private javax.swing.JPanel botonToMoveUpInTheList;
    private javax.swing.JLabel caratuleGameImg1;
    private javax.swing.JLabel caratuleGameImg2;
    private javax.swing.JLabel caratuleGameImg3;
    private javax.swing.JLabel caratuleGameImg4;
    private javax.swing.JLabel caratuleGameImg5;
    private javax.swing.JLabel iconDelet1;
    private javax.swing.JLabel iconDelet2;
    private javax.swing.JLabel iconDelet3;
    private javax.swing.JLabel iconDelet4;
    private javax.swing.JLabel iconDelet5;
    private javax.swing.JLabel iconUserLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel logPage;
    private javax.swing.JPanel makeAPurchaseBoton;
    private javax.swing.JLabel nameGame1;
    private javax.swing.JLabel nameGame2;
    private javax.swing.JLabel nameGame3;
    private javax.swing.JLabel nameGame4;
    private javax.swing.JLabel nameGame5;
    private javax.swing.JPanel nextPageBoton;
    private javax.swing.JLabel numberOfPagesInTheListLabel;
    private javax.swing.JPanel panelGame1;
    private javax.swing.JPanel panelGame2;
    private javax.swing.JPanel panelGame3;
    private javax.swing.JPanel panelGame4;
    private javax.swing.JPanel panelGame5;
    private javax.swing.JPanel panelQuantitySet1;
    private javax.swing.JPanel panelQuantitySet2;
    private javax.swing.JPanel panelQuantitySet3;
    private javax.swing.JPanel panelQuantitySet4;
    private javax.swing.JPanel panelQuantitySet5;
    private javax.swing.JLabel priceTotalGameLabel1;
    private javax.swing.JLabel priceTotalGameLabel2;
    private javax.swing.JLabel priceTotalGameLabel3;
    private javax.swing.JLabel priceTotalGameLabel4;
    private javax.swing.JLabel priceTotalGameLabel5;
    private javax.swing.JLabel quantityGameLabel1;
    private javax.swing.JLabel quantityGameLabel2;
    private javax.swing.JLabel quantityGameLabel3;
    private javax.swing.JLabel quantityGameLabel4;
    private javax.swing.JLabel quantityGameLabel5;
    private javax.swing.JPanel removeGameFromListBoton1;
    private javax.swing.JPanel removeGameFromListBoton2;
    private javax.swing.JPanel removeGameFromListBoton3;
    private javax.swing.JPanel removeGameFromListBoton4;
    private javax.swing.JPanel removeGameFromListBoton5;
    private javax.swing.JPanel removeQuantitySetButton1;
    private javax.swing.JPanel removeQuantitySetButton2;
    private javax.swing.JPanel removeQuantitySetButton3;
    private javax.swing.JPanel removeQuantitySetButton4;
    private javax.swing.JPanel removeQuantitySetButton5;
    private javax.swing.JLabel titlePrice1;
    private javax.swing.JLabel titlePrice2;
    private javax.swing.JLabel titlePrice3;
    private javax.swing.JLabel titlePrice4;
    private javax.swing.JLabel totalPriceInfoLabel;
    private javax.swing.JPanel totalPricePanel;
    private javax.swing.JLabel userNameLabel;
    private javax.swing.JPanel userProfileBoton;
    // End of variables declaration//GEN-END:variables
}
