
package logic;

import databaseConnection.ConnectionSQL;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
public class SuperUserDriver {
    private Connection con;
    private PreparedStatement statement;
    private ResultSet resultSet;
    
    public SuperUserDriver() {
        ConnectionSQL conn = new ConnectionSQL();
        con = conn.getConnection();
    }
// ---------------------- frame SUPER USER-----------------------------------------------------------------------------
    public void getTotalSold(JLabel totalSold){
        ResultSet sold = null;
        if (con != null) {
            try {
                String sql = "SELECT SUM(g.Price) AS TotalSold FROM PurchaseHistory ph "
                        + "JOIN ShoppingCarts sc ON ph.IDCart = sc.CartID "
                        + "JOIN Games g ON sc.IDGames = g.IDGame "
                        + "JOIN PurchaseStatus ps ON ph.IDStatus = ps.IDStatus "
                        + "WHERE ps.State = 'Successfully purchased' ";
                statement = (PreparedStatement) con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                sold = statement.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Failure to search for game");
        }
        try {
            while (sold.next()) {
                float total = sold.getFloat("TotalSold");
                totalSold.setText(totalSold.getText()+" "+Float.toString(total));
            }
            
        } catch (SQLException ex) {
            System.out.println("Error: "+ex);
        }
        
    }
    public ResultSet getSalesHistory(){
        ResultSet resultSet = null;
        if (con != null) {
            try {
                String sql = "SELECT ph.BillID, ud.FirstName, ud.FirstSurname, ud.UserName, g.Name, ph.DateAndTime, ps.State, g.Price FROM PurchaseHistory ph "
                        + "JOIN ShoppingCarts sc ON ph.IDCart = sc.CartID "
                        + "JOIN UserData ud ON sc.IDDataUser = ud.IDUserDate "
                        + "JOIN Users u ON ud.UserID = u.IDUser "
                        + "JOIN Games g ON sc.IDGames = g.IDGame "
                        + "JOIN PurchaseStatus ps ON ph.IDStatus = ps.IDStatus ";
                statement = (PreparedStatement) con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                resultSet = statement.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Failure to search for game");
        }
        return resultSet;
    }
    public ResultSet filerFailuresSales(){
        ResultSet resultSet = null;
        if (con != null) {
            try {
                String sql = "SELECT ph.BillID, ud.FirstName, ud.FirstSurname, ud.UserName, g.Name, ph.DateAndTime, ps.State, g.Price FROM PurchaseHistory ph "
                        + "JOIN ShoppingCarts sc ON ph.IDCart = sc.CartID "
                        + "JOIN UserData ud ON sc.IDDataUser = ud.IDUserDate "
                        + "JOIN Users u ON ud.UserID = u.IDUser "
                        + "JOIN Games g ON sc.IDGames = g.IDGame "
                        + "JOIN PurchaseStatus ps ON ph.IDStatus = ps.IDStatus "
                        + "WHERE ps.State IN ('Key failures', 'Lack of balance') ";
                statement = (PreparedStatement) con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                resultSet = statement.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Failure to search for game");
        }
        return resultSet;       
    }
    public ResultSet filerSucessfullSales(){
        ResultSet resultSet = null;
        if (con != null) {
            try {
                String sql = "SELECT ph.BillID, ud.FirstName, ud.FirstSurname, ud.UserName, g.Name, ph.DateAndTime, ps.State, g.Price FROM PurchaseHistory ph "
                        + "JOIN ShoppingCarts sc ON ph.IDCart = sc.CartID "
                        + "JOIN UserData ud ON sc.IDDataUser = ud.IDUserDate "
                        + "JOIN Users u ON ud.UserID = u.IDUser "
                        + "JOIN Games g ON sc.IDGames = g.IDGame "
                        + "JOIN PurchaseStatus ps ON ph.IDStatus = ps.IDStatus "
                        + "WHERE ps.State = 'Successfully purchased' ";
                statement = (PreparedStatement) con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                resultSet = statement.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Failure to search for game");
        }
        return resultSet;       
    }    
    public ResultSet filerUserName(String userName){
        ResultSet resultSet = null;
        String userNam =  userName.toLowerCase();
        if (con != null) {
            try {
                String sql = "SELECT ph.BillID, ud.FirstName, ud.FirstSurname, ud.UserName, g.Name, ph.DateAndTime, ps.State, g.Price FROM PurchaseHistory ph "
                        + "JOIN ShoppingCarts sc ON ph.IDCart = sc.CartID "
                        + "JOIN UserData ud ON sc.IDDataUser = ud.IDUserDate "
                        + "JOIN Users u ON ud.UserID = u.IDUser "
                        + "JOIN Games g ON sc.IDGames = g.IDGame "
                        + "JOIN PurchaseStatus ps ON ph.IDStatus = ps.IDStatus "
                        + "WHERE LOWER(ud.UserName) = ? OR LOWER(ud.FirstName) = ? OR LOWER(ud.SecondName) = ? OR LOWER(ud.FirstSurname) = ? OR LOWER(ud.SecondLastName) = ?";
                PreparedStatement statement = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                statement.setString(1, userNam);
                statement.setString(2, userNam);
                statement.setString(3, userNam);
                statement.setString(4, userNam);
                statement.setString(5, userNam);
                resultSet = statement.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Failure to search for game");
        }
        return resultSet;       
    }
    public ResultSet getDetailsSale(String billing){
        ResultSet resultSet = null;
        
        if (con != null) {
            try {
                
                String sql = "SELECT ud.FirstName, ud.SecondName, ud.FirstSurname, ud.SecondLastName, ud.UserName, ud.DateOfBirth, u.Email, ud.NIT, vgk.GameKey, ps.State FROM PurchaseHistory ph "
                        + "JOIN ShoppingCarts sc ON ph.IDCart = sc.CartID "
                        + "JOIN UserData ud ON sc.IDDataUser = ud.IDUserDate "
                        + "JOIN Users u ON ud.UserID = u.IDUser "
                        + "JOIN VideoGameKeys vgk ON ph.IDKey = vgk.VideoGameKeysID "
                        + "JOIN PurchaseStatus ps ON ph.IDStatus = ps.IDStatus "
                        + "WHERE ph.BillID = ? ";
                PreparedStatement statement = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                statement.setString(1, billing);
                resultSet = statement.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Failure to search for game");
        }
        return resultSet;    
    }
    
    public void showDetails(JTextArea detailsSaleTextArea, ResultSet details) {
        try {
            while(details.next()){
            Timestamp dataTime = details.getTimestamp("DateOfBirth");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Define el formato deseado para la fecha y hora
                String date = dateFormat.format(dataTime);
            String info = "Nombres: "+details.getString("FirstName")+" "+details.getString("SecondName")+"\nApellidos: "
                    + details.getString("FirstSurname")+" "+details.getString("SecondLastName")+"\nUsuario: "
                    +details.getString("UserName")+"\tCumpleaños: "+date+"\nNIT: "+details.getString("NIT")+"\tCorreo: "+details.getString("Email")
                    +"\nKEY: "+details.getString("GameKey");
            detailsSaleTextArea.setText(info);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SuperUserDriver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void loadDataSales(JTable tableHistorySales, ResultSet sales) {
        try {
            while (sales.next()) {
                String bill = sales.getString("BillID");
                String firstNam = sales.getString("FirstName");
                String lastNam = sales.getString("FirstSurname");
                String userNam = sales.getString("UserName");
                String gameNam = sales.getString("Name");
                
                Timestamp dataTime = sales.getTimestamp("DateAndTime");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // Define el formato deseado para la fecha y hora
                String fechaHoraString = dateFormat.format(dataTime);
                
                String state = sales.getString("State");
                float price = sales.getFloat("Price");
                addRowTable(bill, firstNam+" "+lastNam,userNam, gameNam, fechaHoraString, state, price, tableHistorySales);
            }
            
        } catch (SQLException ex) {
            System.out.println("Error: "+ex);
        }
    }
    public void addRowTable(String bill, String fullUserNam,String userName, String game,String dataTime, String state, float price,JTable tableHistorySales ){
        DefaultTableModel datos = (DefaultTableModel)tableHistorySales.getModel();
        Object[] row = new Object[7];
        row[0] = bill;
        row[1] = fullUserNam;
        row[2] = userName;
        row[3] = game;
        row[4] = dataTime;
        row[5] = state;
        row[6] = Float.toString(price);
        datos.addRow(row);
    }
// ---------------------- frame USER ADMINISTRATOR-----------------------------------------------------------------------------
    public ResultSet getAllUsers(){
        ResultSet users = null;
        if (con != null) {
            try {
                String sql = "SELECT ud.FirstName, ud.SecondName, ud.FirstSurname, ud.SecondLastName, ud.DateOfBirth, ud.NIT,u.Email, ud.UserName FROM UserData ud "
                        + "JOIN Users u ON ud.UserID = u.IDUser ";
                statement = (PreparedStatement) con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                users = statement.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Failure to search for game");
        }
        return users; 
    }

    public void loadAllUsers(JTable tableUsers,ResultSet allUsers) {
        try {
            while (allUsers.next()) {
                String firstNam = allUsers.getString("FirstName");
                String secondNam = allUsers.getString("SecondName");
                String lastNam = allUsers.getString("FirstSurname");
                String lastSeconNam = allUsers.getString("SecondLastName");
                String userNam = allUsers.getString("UserName");
                String email = allUsers.getString("Email");
                
                Timestamp dataTime = allUsers.getTimestamp("DateOfBirth");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ");
                String fechaStr = dateFormat.format(dataTime);
                String NIT = allUsers.getString("NIT");
                
                addRowTableUsers(userNam,firstNam,secondNam,lastNam,lastSeconNam,email,fechaStr, NIT, tableUsers);
            }
            
        } catch (SQLException ex) {
            System.out.println("Error: "+ex);
        }
    }
    public void putInfoTextField(JTextField[] textFields, String user){
        ResultSet userinfo = null;
        if (con != null) {
            try {
                String sql = "SELECT ud.FirstName, ud.SecondName, ud.FirstSurname, ud.SecondLastName, ud.DateOfBirth, ud.NIT, u.Email, ud.UserName "
            + "FROM UserData ud "
            + "JOIN Users u ON ud.UserID = u.IDUser "
            + "WHERE ud.UserName = ?";
                PreparedStatement statement = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                statement.setString(1, user);
                userinfo = statement.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Failure to search for game");
        }       
        try {
            while (userinfo.next()) {
                String firstNam = userinfo.getString("FirstName");
                String secondNam = userinfo.getString("SecondName");
                String lastNam = userinfo.getString("FirstSurname");
                String lastSeconNam = userinfo.getString("SecondLastName");
                String userNam = userinfo.getString("UserName");
                String email = userinfo.getString("Email");
                
                Timestamp dataTime = userinfo.getTimestamp("DateOfBirth");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ");
                String fechaStr = dateFormat.format(dataTime);
                String NIT = userinfo.getString("NIT");
                
                textFields[0].setText(userNam);
                textFields[1].setText(firstNam+" "+secondNam);
                textFields[2].setText(lastNam+" "+lastSeconNam);
                textFields[3].setText(fechaStr);
            }
            
        } catch (SQLException ex) {
            System.out.println("Error: "+ex);
        }        
        
    }
    public ResultSet filterUserNam(String user){
        ResultSet resultSet = null;
        String userNam =  user.toLowerCase();
        if (con != null) {
            try {
                String sql = "SELECT ud.FirstName, ud.SecondName, ud.FirstSurname, ud.SecondLastName, ud.DateOfBirth, ud.NIT, u.Email, ud.UserName FROM UserData ud "
                        + "JOIN Users u ON ud.UserID = u.IDUser "
                        + "WHERE LOWER(ud.UserName) = ? OR LOWER(ud.FirstName) = ? OR LOWER(ud.SecondName) = ? OR LOWER(ud.FirstSurname) = ? OR LOWER(ud.SecondLastName) = ?";
                PreparedStatement statement = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                statement.setString(1, userNam);
                statement.setString(2, userNam);
                statement.setString(3, userNam);
                statement.setString(4, userNam);
                statement.setString(5, userNam);
                resultSet = statement.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Failure to search for game");
        }
        return resultSet;              
    }
    public void changePassword(String username, String newPassword) {
        String sql = "UPDATE Users u " +
                 "JOIN UserData ud ON u.IDUser = ud.UserID " +
                 "SET u.Password = ? " +
                 "WHERE ud.UserName = ?";
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, newPassword);
            statement.setString(2, username);

            int rowsAffected = statement.executeUpdate();
            if (!(rowsAffected > 0)){
                System.out.println("Error updating data");
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void changeUserData(JTextField[] arrayFields) {
        String sql = "UPDATE UserData SET FirstName = ?, SecondName = ?, FirstSurname = ?, SecondLastName = ?, DateOfBirth = ? "
                     + "WHERE UserName = ?";

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, arrayFields[1].getText().split(" ")[0]);
            statement.setString(2, arrayFields[1].getText().split(" ")[1]);
            statement.setString(3, arrayFields[2].getText().split(" ")[0]);
            statement.setString(4, arrayFields[2].getText().split(" ")[1]);
            statement.setDate(5, java.sql.Date.valueOf(arrayFields[3].getText().substring(0,10)));
            statement.setString(6, arrayFields[0].getText());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data user up date sucessfully.");
            } else {
                System.out.println("A user with the provided username was not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void addRowTableUsers(String userNam, String firstNam, String secondNam, String lastNam, String lastSeconNam, String email, String fechaStr, String NIT, JTable tableUsers) {
        DefaultTableModel datos = (DefaultTableModel)tableUsers.getModel();
        Object[] row = new Object[6];
        row[0] = userNam;
        row[1] = firstNam+"  "+secondNam;
        row[2] = lastNam+"  "+lastSeconNam;
        row[3] = email;
        row[4] = fechaStr;
        row[5] = NIT;
        datos.addRow(row);
    }
//----------------------------------------------------------------------------FRAME GAME ADMINISTRATOR-------------------------------------------------------------
    public ResultSet getAllGames(){
        ResultSet games = null;
        if (con != null) {
            try {
                String sql = "SELECT g.Name, c.Name AS Category, p.Name AS Platform, a.field AS Audience, g.Price, d.NameDevelopment AS Developer FROM Games g "
                        + "JOIN Categories c ON g.CategoryID = c.IDCategorie "
                        + "JOIN Plataforms p ON g.PlataformID = p.IDPlataform "
                        + "JOIN Audience a ON g.AudienceID = a.IDAudience "
                        + "JOIN Developments d ON g.DevelopmentID = d.IDDevelopment;";
                statement = (PreparedStatement) con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                games = statement.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Failure to search for game");
        }
        return games; 
    }
    public ResultSet gameSelected(String name){
        ResultSet game = null;
        if (con != null) {
            try {
                String sql = "SELECT g.Name, g.CategoryID, g.PlataformID, g.AudienceID, g.DevelopmentID, g.Price FROM Games g WHERE g.Name = ? ";
                PreparedStatement statement = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                statement.setString(1, name);
                game = statement.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Failure to search for game");
        }
        return game; 
    }
    public void putTextFieldBox(JTextField[] arrayLabel, JComboBox[] arrayBox, ResultSet game){
         try {
            while (game.next()) {
                String nam = game.getString("Name");
                int categor = game.getInt("CategoryID");
                int platfor = game.getInt("PlataformID");
                int audienc = game.getInt("AudienceID");
                int develop = game.getInt("DevelopmentID");
                
                float pric = game.getFloat("Price");
                String precio = Float.toString(pric);
                arrayLabel[0].setText(nam);
                arrayLabel[1].setText(precio);
                
                arrayBox[0].setSelectedIndex(categor-1);
                arrayBox[1].setSelectedIndex(platfor-1);
                arrayBox[2].setSelectedIndex(audienc-1);
                arrayBox[3].setSelectedIndex(develop-1);
            }
            
        } catch (SQLException ex) {
            System.out.println("Error: "+ex);
        }       
    }
    public void changeGameData(JTextField[] arrayLabel, JComboBox[] arrayBox) {
        String sql = "UPDATE Games SET CategoryID = ?, PlataformID = ?, AudienceID = ?, DevelopmentID = ?, Price = ? WHERE Name = ?";
        PreparedStatement statement;
        int rowsAffected=0;
        try {
            statement = con.prepareStatement(sql);
            // Establecer los nuevos valores
            statement.setInt(1, arrayBox[0].getSelectedIndex()+1);
            statement.setInt(2, arrayBox[1].getSelectedIndex()+1);
            statement.setInt(3, arrayBox[2].getSelectedIndex()+1);
            statement.setInt(4, arrayBox[3].getSelectedIndex()+1);
            float price = Float.parseFloat(arrayLabel[1].getText());
            statement.setFloat(5, price);
            statement.setString(6, arrayLabel[0].getText());
            System.out.println("a "+(arrayBox[0].getSelectedIndex()+1)+" "+(arrayBox[1].getSelectedIndex()+1)+" "+price);
        rowsAffected = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SuperUserDriver.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (rowsAffected > 0) {
            System.out.println("Los datos del juego se han actualizado correctamente.");
        } else {
            System.out.println("No se encontró ningún juego con el nombre especificado.");
        }
        
    }


    public void loadAllGames(JTable tableGames, ResultSet allGames) {
        try {
            while (allGames.next()) {
                String nam = allGames.getString("Name");
                String categor = allGames.getString("Category");
                String platfor = allGames.getString("Platform");
                String audienc = allGames.getString("Audience");
                float pric = allGames.getFloat("Price");
                String precio = Float.toString(pric);
                String develop = allGames.getString("Developer");
                addRowTableGames(nam, categor,platfor, audienc, precio, tableGames);
            }
            
        } catch (SQLException ex) {
            System.out.println("Error: "+ex);
        }
    }
    public ResultSet filterSearchGames(String str){
        ResultSet search = null;
        if (con != null) {
            try {
                String searchTermLower = str.toLowerCase();

                String sql = "SELECT DISTINCT g.Name, c.Name AS Category, p.Name AS Platform, a.field AS Audience, g.Price, d.NameDevelopment AS Developer, g.ImagePath FROM Games g "
                        + "JOIN Categories c ON g.CategoryID = c.IDCategorie "
                        + "JOIN Plataforms p ON g.PlataformID = p.IDPlataform "
                        + "JOIN Audience a ON g.AudienceID = a.IDAudience "
                        + "JOIN Developments d ON g.DevelopmentID = d.IDDevelopment "
                        + "WHERE LOWER(g.Name) LIKE ? OR LOWER(c.Name) LIKE ? OR LOWER(p.Name) LIKE ? OR LOWER(a.field) LIKE ? OR LOWER(d.NameDevelopment) LIKE ?";

                PreparedStatement statement = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                statement.setString(1, "%" + searchTermLower + "%");
                statement.setString(2, "%" + searchTermLower + "%");
                statement.setString(3, "%" + searchTermLower + "%");
                statement.setString(4, "%" + searchTermLower + "%");
                statement.setString(5, "%" + searchTermLower + "%");
                search = statement.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Failure to search for game");
        }
        return search;
    }
    
    public void addRowTableGames(String name, String category, String platform, String audience, String price, JTable tableGames) {
        DefaultTableModel datos = (DefaultTableModel)tableGames.getModel();
        Object[] row = new Object[5];
        row[0] = name;
        row[1] = category;
        row[2] = platform;
        row[3] = audience;
        row[4] = price;
        datos.addRow(row);
    }
    public void addGameKey(JTextField textFieldKey, String gameName) {
        String sql = "INSERT INTO VideoGameKeys (IDGame, GameKey, Activate) "
                +"VALUES (?,?,?)";
        int nro = getIdGame(gameName);
        PreparedStatement statement;
        int rowsAffected=0;
        try {
            statement = con.prepareStatement(sql);
            statement.setInt(1, nro);
            statement.setString(2, textFieldKey.getText());
            statement.setBoolean(3, true);
            
        rowsAffected = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SuperUserDriver.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (rowsAffected > 0) {
            System.out.println("KEY agregada xorrextamente");
        } else {
            System.out.println("No se agrego key.");
        }
    }
    public int getIdGame(String gameName) {
        ResultSet game = null;
        int idGam = 0;
        if (con != null) {
            try {
                String sql = "SELECT IDGame FROM Games WHERE Name = ?";
                statement = (PreparedStatement) con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                statement.setString(1, gameName);
                game = statement.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Failure to search for game");
        }
        try {
            while (game.next()) {
                idGam = game.getInt("IDGame");
            }
            
        } catch (SQLException ex) {
            System.out.println("Error: "+ex);
        }
        return idGam;
    }

}
