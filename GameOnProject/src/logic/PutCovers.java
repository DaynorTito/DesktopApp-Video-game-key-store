
package logic;
//import com.mysql.cj.xdevapi.Statement;
import java.awt.Color;
import java.awt.Cursor;
import view.Pagination;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import view.GamePage;


public class PutCovers {
    private JLabel[] jlabelsImages;
    private JLabel[] jlabelsText;
    private JLabel[] jlabelsTextPlataform;
    private JPanel[] jPanelsGames;
    private JButton[] jlabelsTextPrice;
    private ResultSet resultSet;
    
    public PutCovers(JLabel[] jlabelsImages, JLabel[] jlabelsText, JButton[] price,JPanel[] paneles,ResultSet resultSet) {
        this.jlabelsImages = jlabelsImages;
        this.jlabelsText = jlabelsText;
        this.resultSet = resultSet;
        this.jlabelsTextPrice = price;
        this.jPanelsGames = paneles;
    }
    public PutCovers(JLabel[] jlabelsImages, JLabel[] jlabelsText,JLabel[] jlabelsTextPlataform,JButton[] jlabelsTextPrice, ResultSet resultSet) {
        this.jlabelsTextPlataform = jlabelsTextPlataform;
        this.jlabelsTextPrice = jlabelsTextPrice;
        this.jlabelsImages = jlabelsImages;
        this.jlabelsText = jlabelsText;
        this.resultSet = resultSet;
    }
   
    public void putImageText(Pagination aThis){
        try {
            int i = 0, setRows = countResultSetRows(), lim=0;
            
            if(setRows>9){
                lim = 9;
            }else{
                lim = setRows;
            }
            while (resultSet.next() && i<lim) {
                jlabelsText[i].setVisible(true);
                jlabelsTextPrice[i].setVisible(true);
                jlabelsImages[i].setVisible(true);
                jPanelsGames[i].setVisible(true);
                String gameName = resultSet.getString("Name");
                String gamePlataform = resultSet.getString("Plataform");
                float gamePrice = resultSet.getFloat("Price");
                String gamePathImage = resultSet.getString("ImagePath");
                setTextLabel(jlabelsText[i],gameName,gamePlataform);
                setTextLabelPrice(jlabelsTextPrice[i],gamePrice);
                setImageLabel(jlabelsImages[i], gamePathImage, aThis);
                configureClickableLabel(jlabelsText[i]);
                i++;
            }
            if(lim <= 9){
                for (int j = lim; j < 9; j++) {
                    jlabelsText[j].setVisible(false);
                    jlabelsTextPrice[j].setVisible(false);
                    jlabelsImages[j].setVisible(false);
                    jPanelsGames[j].setVisible(false);
                    
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PutCovers.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(PutCovers.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private static GamePage gamePage;
    
    private static void configureClickableLabel(JLabel label) {
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
    
 
    public int countResultSetRows() throws SQLException {
    int rowCount = 0;
    ResultSet resultSetCopy = resultSet; // Crear una copia del ResultSet

    while (resultSetCopy.next()) {
        rowCount++;
    }
    
    resultSet.last(); // Colocar el cursor en la última fila
    resultSet.beforeFirst(); // Devolver el cursor al inicio del ResultSet
    return rowCount;
}

  
   /* public void setTextLabel(JLabel labelName, String name, String plataform) {
        labelName.setText(name+"\n"+plataform);
    }*/
    
     public void setTextLabel(JLabel labelName, String name, String plataform) {
        labelName.setText(name);    
        
    }
    
    public void setTextLabelPrice(JButton labelName, float price) {
        labelName.setText(price+" Bs");
    }
    
    public void setImageLabel(JLabel labelName, String root, Pagination athis){
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(
                image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT)
        );
        labelName.setIcon(icon);
        athis.repaint();
    }
    public JLabel[] getJlabelsImages() {
        return jlabelsImages;
    }

    public void setJlabelsImages(JLabel[] jlabelsImages) {
        this.jlabelsImages = jlabelsImages;
    }

    public JLabel[] getJlabelsText() {
        return jlabelsText;
    }

    public void setJlabelsText(JLabel[] jlabelsText) {
        this.jlabelsText = jlabelsText;
    }

    public JLabel[] getJlabelsTextPlataform() {
        return jlabelsTextPlataform;
    }

    public void setJlabelsTextPlataform(JLabel[] jlabelsTextPlataform) {
        this.jlabelsTextPlataform = jlabelsTextPlataform;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public JPanel[] getjPanelsGames() {
        return jPanelsGames;
    }

    public void setjPanelsGames(JPanel[] jPanelsGames) {
        this.jPanelsGames = jPanelsGames;
    }
    
    
}
