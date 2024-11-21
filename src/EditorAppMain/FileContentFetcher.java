package EditorAppMain;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/arabiceditor";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private Connection connection;

    public DatabaseConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connection established successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to the database.", e);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
public class FileContentFetcher {
    private DatabaseConnection databaseConnection;

    public FileContentFetcher(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public List<String> getAllFilesContentByDocument() {
        List<String> documentsContent = new ArrayList<>();
        String query = "SELECT d.id AS document_id, " +
                       "GROUP_CONCAT(p.content SEPARATOR ' ') AS document_content " +
                       "FROM Document d " +
                       "JOIN Page p ON d.id = p.document_id " +
                       "GROUP BY d.id " +
                       "ORDER BY d.id";

        try (PreparedStatement stmt = databaseConnection.getConnection().prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                documentsContent.add(rs.getString("document_content"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return documentsContent;
    }
    public static void main(String[] args) {
        // Establish a database connection
        DatabaseConnection dbConnection = new DatabaseConnection();

        // Create an instance of FileContentFetcher
        FileContentFetcher fetcher = new FileContentFetcher(dbConnection);

        // Fetch and print all document contents
        List<String> documentsContent = fetcher.getAllFilesContentByDocument();

        // Print the contents
        for (int i = 0; i < documentsContent.size(); i++) {
            System.out.println("Document " + (i + 1) + ":");
            System.out.println(documentsContent.get(i));
            System.out.println("--------------------");
        }

        // Close the database connection
        dbConnection.closeConnection();
    }
}
