package IDS;
import java.sql.*;

public class DbConnector {
    private static final String username = "root";
    private static final String password = "";
    private static final String url = "jdbc:mysql://localhost:3306/loyaltyplatform";
    private static Connection connection;

    /**
     * Connection method
     */
    public static void init() throws SQLException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Connection connection = DriverManager.getConnection(url, username, password);
            connection = DriverManager.getConnection(url, username, password);
            //DbConnector.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new IllegalStateException("Not connected", e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void insertQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }

    public static ResultSet executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(query);
        return result;
    }

    public static void removeQuery(String query) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        statement.executeUpdate();
    }

    public static ResultSet selectAllFromTable(String table) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + table);
        return statement.executeQuery();
    }

    public static int getNumberRows(String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery(query);
            if (resultset.last()) {
                return resultset.getRow();
            } else {
                return 0;
            }
        } catch (Exception e) {
            System.out.println("Error getting row count");
            e.printStackTrace();
        }
        return 0;
    }

    public static void closeConnection()
    {
        try {
            DbConnector.connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}