package logic;

import databaseConnection.ConnectionSQL;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;
import javax.swing.*;

public class UserDetailView {
    private Connection con;
    private PreparedStatement statement;
    private ResultSet resultSet;    
    private String idUser;
    private String curretPassword;
    private boolean signOut;

    
    public UserDetailView() {
        ConnectionSQL conn = new ConnectionSQL();
        con = conn.getConnection();
        signOut=false;
    }
    public UserDetailView(String idUser) {
        ConnectionSQL conn = new ConnectionSQL();
        con = conn.getConnection();
        this.idUser = idUser;
        signOut=false;
    }
    public boolean usernameExists(){
        try {
            getUserInformation();
            if(this.resultSet.next())
                return true;
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(UserDetailView.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean checkSpecialCharacters(String password){
        String specialCharsRegex = "[!\"#$%&'()*+,\\-./:;<=>?@\\[\\\\\\]^_`{|}~]";
        boolean hasLowercase = password.matches(".*[a-z].*");
        boolean hasUppercase = password.matches(".*[A-Z].*");
        int length = password.length();
        boolean hasSpecialChars = Pattern.compile(specialCharsRegex).matcher(password).find();
        if (hasSpecialChars && hasLowercase && hasUppercase && (length >= 8 && length <= 49))
            return true;
        return false;
        
    }
    public void getUserInformation(){
        resultSet = null;
        if (con != null) {
            try {
                String sql = "SELECT Users.Email, Users.Password, Users.UserLevel, UserData.UserName, UserData.FirstName, UserData.SecondName, UserData.FirstSurname, UserData.SecondLastName, UserData.DateOfBirth "
                        + "FROM Users "
                        + "INNER JOIN UserData ON Users.IDUser = UserData.IDUserDate "
                        + "WHERE UserData.UserName = ?";
                statement = (PreparedStatement) con.prepareStatement(sql);
                statement.setString(1, this.idUser);
                resultSet = statement.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Failure to search for Users");
        }

    }
    public void showProfileInformation(JLabel labelUserName,JLabel labelNames, JLabel labelLastNames, JLabel labelEmail, JLabel labelDateBirthday){
        getUserInformation();
        try {
            if(this.resultSet.next()){
                String email = resultSet.getString("Email");
                this.curretPassword = resultSet.getString("Password");
                String userLevel = resultSet.getString("UserLevel");
                String userName = resultSet.getString("UserName");
                String firstName = resultSet.getString("FirstName");
                String firstSurname = resultSet.getString("FirstSurname");
                String secondName = resultSet.getString("SecondName");

                String secondLastName = resultSet.getString("SecondLastName");
                Date dateOfBirth = resultSet.getDate("DateOfBirth");

                labelUserName.setText(userName);
                labelNames.setText(firstName+" "+secondName);
                labelLastNames.setText(firstSurname+" "+secondLastName);
                labelEmail.setText(email);
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String dateOfBirthString = sdf.format(dateOfBirth);
                labelDateBirthday.setText(dateOfBirthString);
            } else{
                System.out.println("");
                JOptionPane.showMessageDialog(null, "No se han encontrado resultados para el usuario especificado.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PutCovers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void changePassword(JPasswordField newPass, JPasswordField confirmPass, JPasswordField currentPass){
        String tryNewPass = newPass.getText();
        String try2NewPass = confirmPass.getText();
        if(!this.idUser.equals("")){
            if(checkSpecialCharacters(tryNewPass)){
                if(tryNewPass.equals(try2NewPass)){
                    if(this.curretPassword.equals(currentPass.getText())){
                        try {
                            String sql = "UPDATE Users SET Password = ? WHERE IDUser = (SELECT UserID FROM UserData WHERE UserName = ?)";
                            statement = con.prepareStatement(sql);

                            statement.setString(1, tryNewPass);
                            statement.setString(2, this.idUser);
                            this.curretPassword = tryNewPass;
                            int rowsUpdated = statement.executeUpdate();

                            if (rowsUpdated > 0) {
                                System.out.println("La contraseña se actualizó correctamente.");
                            } else {
                                System.out.println("No se encontró ninguna fila para actualizar.");
                            }

                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                        JOptionPane.showMessageDialog(null, "Se cambio de contraseña correctamente");

                    } else{
                        JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Las nuevas contraseñas no coinciden");
                }
            } else{
                JOptionPane.showMessageDialog(null, "La nueva contraseña no cumple los requisitos");
            }
        } else{
            JOptionPane.showMessageDialog(null, "Primero conéctate para cambiar tu contraseña");
        }
    }

    public void clearFieldsPassword(JPasswordField newPasswordUser, JPasswordField confirmPassUser, JPasswordField currentPassUser) {
        newPasswordUser.setText("");
        confirmPassUser.setText("");
        currentPassUser.setText("");
    }

    public void logOutUser(JLabel labelUserName,JLabel labelNames, JLabel labelLastNames, JLabel labelEmail, JLabel labelDateBirthday) {
        if(this.signOut){
            JOptionPane.showMessageDialog(null, "Se ha producido un error al cerrar el registro, vuelva al inicio.");
        } else{
            this.signOut = true;
            try {
                statement.close();
                con.close();
                clearAll(labelUserName, labelNames, labelLastNames, labelEmail, labelDateBirthday);
                JOptionPane.showMessageDialog(null, "Registro cerrado con éxito.");
               
            } catch (SQLException ex) {
                Logger.getLogger(UserDetailView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void clearAll(JLabel labelUserName,JLabel labelNames, JLabel labelLastNames, JLabel labelEmail, JLabel labelDateBirthday) {
        signOut=false;
        this.idUser = "";
        labelUserName.setText("");
        labelNames.setText("");
        labelLastNames.setText("");
        labelEmail.setText("");
        labelDateBirthday.setText("");        
    }

    public String getNumId(int idUserNum) {
        String userName = "";
        ResultSet resul;
        try {
            String sql = "SELECT ud.UserName FROM Users u JOIN UserData ud ON u.IDUser = ud.UserID WHERE u.IDUser = ?";
            
            PreparedStatement statemen = (PreparedStatement) con.prepareStatement(sql);
            statemen.setInt(1, idUserNum);
            resul = statemen.executeQuery();
            if (resul.next()) {
                
                userName = resul.getString("UserName");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userName;
    }
    
    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public PreparedStatement getStatement() {
        return statement;
    }

    public void setStatement(PreparedStatement statement) {
        this.statement = statement;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getCurretPassword() {
        return curretPassword;
    }

    public void setCurretPassword(String curretPassword) {
        this.curretPassword = curretPassword;
    }

    public boolean isSignOut() {
        return signOut;
    }

    public void setSignOut(boolean signOut) {
        this.signOut = signOut;
    }
}
