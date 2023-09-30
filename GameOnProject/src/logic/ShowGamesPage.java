package logic;


import databaseConnection.ConnectionSQL;
import java.sql.*;

public class ShowGamesPage {
    private Connection con;
    private PreparedStatement statement;
    private ResultSet resultSet;
    
    public ShowGamesPage() {
        ConnectionSQL conn = new ConnectionSQL();
        con = conn.getConnection();
    }
    
    public ResultSet returnAllGames() {
        resultSet = null;
        if (con != null) {
            try {
                String sql = "SELECT g.Name, p.Name AS Plataform, g.Price, g.ImagePath " +
             "FROM Games g " +
             "JOIN Categories c ON g.CategoryID = c.IDCategorie " +
             "JOIN Plataforms p ON g.PlataformID = p.IDPlataform";
                
                statement = (PreparedStatement) con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                resultSet = statement.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Failure to display all games");
        }
        return resultSet;
    }
    // -------------------------------FUNCTION SEARCH---------------- ANDRES ROJAS--------------
    public ResultSet returnWordSearch(String searchTerm) {
        resultSet = null;
        if (con != null) {
            try {
                String searchTermLower = searchTerm.toLowerCase();

                String sql = "SELECT DISTINCT g.Name, p.Name AS Plataform, g.Price, g.ImagePath FROM Games g "
                        + "JOIN Categories c ON g.CategoryID = c.IDCategorie "
                        + "JOIN Plataforms p ON g.PlataformID = p.IDPlataform "
                        + "JOIN Audience a ON g.AudienceID = a.IDAudience "
                        + "JOIN Developments d ON g.DevelopmentID = d.IDDevelopment "
                        + "WHERE LOWER(g.Name) LIKE ? OR LOWER(c.Name) LIKE ? OR LOWER(p.Name) LIKE ? OR LOWER(a.field) LIKE ? OR LOWER(d.NameDevelopment) LIKE ?";

                statement = (PreparedStatement) con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                statement.setString(1, "%" + searchTermLower + "%");
                statement.setString(2, "%" + searchTermLower + "%");
                statement.setString(3, "%" + searchTermLower + "%");
                statement.setString(4, "%" + searchTermLower + "%");
                statement.setString(5, "%" + searchTermLower + "%");
                resultSet = statement.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Failure to search for game");
        }

        return resultSet;
    }
    //-----------------------------------------------------------------------------------------------------------------------------
    
    
    
    //---------------------------------FUNCION JOSE RODRIGUEZ--------------------------------------------
    public ResultSet getDataPage(int currentPage, int pageSize) {
        resultSet = null;
        try {
            int startIndex = (currentPage - 1) * pageSize;
            int endIndex = startIndex + pageSize;
            String sql = "SELECT g.Name, p.Name AS Plataform, g.Price, g.ImagePath FROM Games g JOIN Plataforms p ON g.PlataformID = p.IDPlataform LIMIT "+ startIndex + ", " + pageSize;

            statement = (PreparedStatement) con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }
       
    public int getTotalPages(int currentPage, int pageSize) {
        try {
            Statement stant = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet = stant.executeQuery("SELECT COUNT(*) AS total FROM Games");

            if (resultSet.next()) {
                int total = resultSet.getInt("total");
                return (int) Math.ceil((double) total / pageSize);
            }

            //resultSet.close();
            //statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
    
    //--------------------------------JESUS MIRANDA---------------------------------------------
      public ResultSet searchGamesByPlatform(String platform) {
        ResultSet resultSet = null;
        if (con != null) {
            try {
                String platformLower = platform.toLowerCase();
 
                String sql = "SELECT g.Name, p.Name AS Plataform, g.Price, g.ImagePath FROM Games g "
                        + "JOIN Plataforms p ON g.PlataformID = p.IDPlataform "
                        + "WHERE p.Name = ? ";
                PreparedStatement statement = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                statement.setString(1, platform);
                resultSet = statement.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Failure to search for game");
        }
        return resultSet;
    }
    
   
    //--------------------------------------------------------------------------------------------------
    
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
}
