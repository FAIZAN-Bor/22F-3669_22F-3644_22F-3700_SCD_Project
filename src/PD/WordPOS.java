package PD;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class WordPOS extends JFrame {

    public WordPOS(List<String[]> wordDetails) {
        // Set frame properties
        this.setTitle("تحليل الكلمات");
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        // Table column names in Arabic
        String[] columnNames = {"الكلمة", "جزء من الكلام"};

        // Convert List<String[]> to 2D Object array for JTable
        Object[][] tableData = new Object[wordDetails.size()][2];
        for (int i = 0; i < wordDetails.size(); i++) {
            tableData[i][0] = wordDetails.get(i)[0]; // Word
            tableData[i][1] = wordDetails.get(i)[1]; // Part of Speech
        }

        // Create table model and JTable
        DefaultTableModel tableModel = new DefaultTableModel(tableData, columnNames);
        JTable table = new JTable(tableModel);

        // Customize table appearance
        table.setFont(new Font("Arial", Font.PLAIN, 16));
        table.setRowHeight(25);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));
        table.getTableHeader().setBackground(new Color(240, 240, 240));
        table.getTableHeader().setForeground(Color.BLACK);

        // Add table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);

        // Add scroll pane to the frame
        this.add(scrollPane, BorderLayout.CENTER);

        // Display the frame
        this.setVisible(true);
    }

    // Main method to test the frame with sample data
    
}
