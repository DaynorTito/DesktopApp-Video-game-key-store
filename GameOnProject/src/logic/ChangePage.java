package logic;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import logic.PutCovers;
import view.Pagination;

public class ChangePage {
    private int currentPage;
    private int pageSize;
    private JLabel[] gameLabels;
    private JLabel[] gameImage;
    private JButton[] gamePrice;
    private JButton prevButton;
    private JButton nextButton;
    private JLabel pageLabel;
    private JTextArea dataTextArea;
    private Pagination aThis;
    private ShowGamesPage getGamesPage;
    PutCovers putCover;

    
    public ChangePage() {
        currentPage = 1;
        pageSize = 9;
        getGamesPage = new ShowGamesPage();
    }
    
    
    public ChangePage(JLabel[] gameImage, JLabel[] jLabels, JPanel[] panels, JButton[] gamePrice,Pagination aThis) {
        this.aThis = aThis;
        currentPage = 1;
        pageSize = 9;
        getGamesPage = new ShowGamesPage();
        gameLabels = new JLabel[pageSize];
        gameLabels = jLabels;
        
        putCover = new PutCovers(gameImage, jLabels, gamePrice, panels,null);
        updateDataLabels();
        
        // Área de texto para mostrar los datos
        dataTextArea = new JTextArea();
        aThis.add(new JScrollPane(dataTextArea), BorderLayout.CENTER);
        
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        aThis.add(controlPanel, BorderLayout.SOUTH);

        // Botón anterior
        prevButton = new JButton("Anterior");
        prevButton.setEnabled(false);
        controlPanel.add(prevButton);

        // Etiqueta para mostrar la página actual
        pageLabel = new JLabel("Página: " + currentPage);
        controlPanel.add(pageLabel);

        // Botón siguiente
        nextButton = new JButton("Siguiente");
        controlPanel.add(nextButton);
        
       // updateDataTextArea();
        updateButtonStates();
    }

    public void updatePageLabel() {
        pageLabel.setText("Página: " + currentPage);
    }

    public void updateButtonStates() {
        int totalPages = getGamesPage.getTotalPages(currentPage, pageSize);
        prevButton.setEnabled(currentPage > 1);
        nextButton.setEnabled(currentPage < totalPages);
    }

    public void updateDataLabels() {
        putCover.setResultSet(getGamesPage.getDataPage(currentPage, pageSize));
        putCover.putImageText(aThis);
    }
    public void goBackBotonAction(){
       if (getCurrentPage() > 1) {
            setCurrentPage(getCurrentPage()-1);
            updatePageLabel();
            updateButtonStates();
        }
        updateDataLabels();
    }
    
    public void goForwardBotonAction(){
        int totalPages = getGamesPage.getTotalPages(currentPage, pageSize);
        if (getCurrentPage() < totalPages) {
            setCurrentPage(getCurrentPage()+1);
            updatePageLabel();
            updateButtonStates();
        }
        updateDataLabels();
    }


    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public JLabel[] getGameLabels() {
        return gameLabels;
    }

    public void setGameLabels(JLabel[] gameLabels) {
        this.gameLabels = gameLabels;
    }

    public JButton getPrevButton() {
        return prevButton;
    }

    public void setPrevButton(JButton prevButton) {
        this.prevButton = prevButton;
    }

    public JButton getNextButton() {
        return nextButton;
    }

    public void setNextButton(JButton nextButton) {
        this.nextButton = nextButton;
    }

    public JLabel getPageLabel() {
        return pageLabel;
    }

    public void setPageLabel(JLabel pageLabel) {
        this.pageLabel = pageLabel;
    }

    public JTextArea getDataTextArea() {
        return dataTextArea;
    }

    public void setDataTextArea(JTextArea dataTextArea) {
        this.dataTextArea = dataTextArea;
    }

    public Pagination getaThis() {
        return aThis;
    }

    public void setaThis(Pagination aThis) {
        this.aThis = aThis;
    }
    

}