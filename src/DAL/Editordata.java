package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import DTO.Files;
import DTO.Page;

public class Editordata implements IEditordata{
    private DataBaseConnection databaseConnection;

    public Editordata() {
        databaseConnection = new DataBaseConnection();
    }

    public List<Files> getFiles() {
        List<Files> files = new ArrayList<>();
        String query = "SELECT * FROM Document";
        try (PreparedStatement stmt = databaseConnection.getConnection().prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                files.add(new Files(id, title, null));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return files;
    }
    public List<String> getAllFilescontent() {
        List<String> filescontent = new ArrayList<>();
        String query = "SELECT d.id AS document_id, " +
                "GROUP_CONCAT(p.content SEPARATOR ' ') AS document_content " +
                "FROM Document d " +
                "JOIN Page p ON d.id = p.document_id " +
                "GROUP BY d.id " +
                "ORDER BY d.id";
        try (PreparedStatement stmt = databaseConnection.getConnection().prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                
                filescontent.add(rs.getString("document_content"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filescontent;
    }

    public boolean saveToDB(String title, String content) {
        String selectQuery = "SELECT COUNT(*) FROM Document WHERE content_hash = ?";
        String insertDocumentQuery = "INSERT INTO Document (title, content_hash) VALUES (?, ?)";
        String insertPageQuery = "INSERT INTO Page (document_id, content) VALUES (?, ?)";

        try {
            String contentHash = generateHash(content);

            PreparedStatement selectPstmt = databaseConnection.getConnection().prepareStatement(selectQuery);
            selectPstmt.setString(1, contentHash);
            ResultSet rs = selectPstmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);

            if (count > 0) {
            	System.out.println("Already Exists");
                return false; // Content already exists
            } else {
                PreparedStatement insertDocumentPstmt = databaseConnection.getConnection().prepareStatement(insertDocumentQuery, PreparedStatement.RETURN_GENERATED_KEYS);
                insertDocumentPstmt.setString(1, title);
                insertDocumentPstmt.setString(2, contentHash);
                insertDocumentPstmt.executeUpdate();

                ResultSet generatedKeys = insertDocumentPstmt.getGeneratedKeys();
                int documentId = 0;
                if (generatedKeys.next()) {
                    documentId = generatedKeys.getInt(1);
                }

                List<String> pages = splitContentIntoPages(content, 100);
                for (String pageContent : pages) {
                    PreparedStatement insertPagePstmt = databaseConnection.getConnection().prepareStatement(insertPageQuery);
                    insertPagePstmt.setInt(1, documentId);
                    insertPagePstmt.setString(2, pageContent);
                    insertPagePstmt.executeUpdate();
                }
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String generateHash(String content) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(content.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> splitContentIntoPages(String content, int wordsPerPage) {
        String[] words = content.split("\\s+");
        List<String> pages = new ArrayList<>();
        StringBuilder pageContent = new StringBuilder();
        int wordCount = 0;
        for (String word : words) {
            pageContent.append(word).append(" ");
            wordCount++;
            if (wordCount == wordsPerPage) {
                pages.add(pageContent.toString().trim());
                pageContent = new StringBuilder();
                wordCount = 0;
            }
        }
        if (pageContent.length() > 0) {
            pages.add(pageContent.toString().trim());
        }
        return pages;
    }

    public boolean updateFilename(int id, String newTitle) {
        String sql = "UPDATE Document SET title = ? WHERE id = ?";
        try (PreparedStatement pstmt = databaseConnection.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, newTitle);
            pstmt.setInt(2, id);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteFilename(int id) {
        String deletePagesQuery = "DELETE FROM Page WHERE document_id = ?";
        String deleteDocumentQuery = "DELETE FROM Document WHERE id = ?";
        try (PreparedStatement pstmt1 = databaseConnection.getConnection().prepareStatement(deletePagesQuery);
             PreparedStatement pstmt2 = databaseConnection.getConnection().prepareStatement(deleteDocumentQuery)) {
            pstmt1.setInt(1, id);
            pstmt1.executeUpdate();
            pstmt2.setInt(1, id);
            int rowsAffected = pstmt2.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String viewFilename(int id) {
        String query = "SELECT content FROM Page WHERE document_id = ?";
        StringBuilder content = new StringBuilder();
        try (PreparedStatement pstmt = databaseConnection.getConnection().prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                content.append(rs.getString("content")).append(" ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return content.toString().trim();
    }

    public Files searchFile(String title) {
        String query = "SELECT * FROM Document WHERE title = ?";
        try (PreparedStatement pstmt = databaseConnection.getConnection().prepareStatement(query)) {
            pstmt.setString(1, title);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                return new Files(id, rs.getString("title"), viewFilename(id));
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<Page> searchWordfromFiles(String word, String selectedOption) {
        List<Page> pageData = new ArrayList<>();
        
        if ("Search by Exact Word".equals(selectedOption)) {
            // Exact match query with punctuation handling
            String searchQuery = "SELECT DISTINCT * FROM Page WHERE " +
                    "content LIKE ? OR content LIKE ? OR content LIKE ? OR content LIKE ? OR content LIKE ?";

            try (PreparedStatement pstmt = databaseConnection.getConnection().prepareStatement(searchQuery)) {
                // Patterns for matching exact words
                pstmt.setString(1, "% " + word + " %");  // Space before and after
                pstmt.setString(2, word + " %");         // At the beginning of the string
                pstmt.setString(3, "% " + word);         // At the end of the string
                pstmt.setString(4, "% " + word + "[.,!?؟،]%"); // Word with punctuation after
                pstmt.setString(5, "[.,!?؟،]%" + word + " %"); // Word with punctuation before
                
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    int pageId = rs.getInt("id");
                    int documentId = rs.getInt("document_id");
                    String content = rs.getString("content");
                    pageData.add(new Page(pageId, documentId, content));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            // Prefix/Postfix or general search
            String searchQuery = "SELECT DISTINCT * FROM Page WHERE content LIKE ?";
            
            try (PreparedStatement pstmt = databaseConnection.getConnection().prepareStatement(searchQuery)) {
                pstmt.setString(1, "%" + word + "%");
                ResultSet rs = pstmt.executeQuery();
                
                while (rs.next()) {
                    int pageId = rs.getInt("id");
                    int documentId = rs.getInt("document_id");
                    String content = rs.getString("content");
                    pageData.add(new Page(pageId, documentId, content));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return pageData;
    }
    public ArrayList<Page> navigatefromdb(int id) {
        ArrayList<Page> pageData = new ArrayList<>();
        String searchQuery = "SELECT * FROM Page WHERE document_id = ?";
        
        try (PreparedStatement pstmt = databaseConnection.getConnection().prepareStatement(searchQuery)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                int pageId = rs.getInt("id"); // Assuming 'id' is the primary key in the Page table
                int documentId = rs.getInt("document_id");
                String content = rs.getString("content");
                pageData.add(new Page(pageId, documentId, content));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pageData;
    }
    

    public void closeConnection() {
        databaseConnection.closeConnection();
    }

}
