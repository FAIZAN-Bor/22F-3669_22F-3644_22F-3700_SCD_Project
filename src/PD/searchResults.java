package PD;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import BLL.IEditorBusinessLogic;
import DTO.Page;

public class searchResults extends JFrame {
    private JTable resultsTable;
    private DefaultTableModel tableModel;
    private IEditorBusinessLogic files;

    public searchResults(List<Page> searchResults, String word, IEditorBusinessLogic filesfrombusiness) {
        files = filesfrombusiness;
        this.setSize(800, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Search Results - Matches for: " + word);
        this.setLayout(new BorderLayout(10, 10));

        // Column Setup
        String[] columnNames = {"Page ID", "Document ID", "Snippet"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Populate table model with search results
        for (Page page : searchResults) {
            int pageId = page.getPageId();
            int documentId = page.getDocumentId();
            String contentLine = page.getSearchResult();
            String snippet = filesfrombusiness.generateSnippet(contentLine, word);
            tableModel.addRow(new Object[]{pageId, documentId, snippet});
        }

        // Table Setup
        resultsTable = new JTable(tableModel);
        styleTable(resultsTable);

        resultsTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && resultsTable.getSelectedRow() != -1) {
                    int selectedRow = resultsTable.getSelectedRow();
                    int pageId = (int) tableModel.getValueAt(selectedRow, 0);
                    String content = files.viewFile(pageId).trim();
                    new NewFile(files, content);
                    //searchResults.this.dispose();
                }
            }
        });



        // Scroll Pane
        JScrollPane scrollPane = new JScrollPane(resultsTable);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add components to frame
        this.add(scrollPane, BorderLayout.CENTER);
        this.setVisible(true);
    }

    private void styleTable(JTable table) {
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(25);
        table.setShowGrid(true);
        table.setGridColor(Color.LIGHT_GRAY);

        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 14));
        header.setBackground(new Color(230, 240, 250));
        header.setReorderingAllowed(false);

        // Set selection background color to green
        table.setSelectionBackground(new Color(60, 179, 113)); // Green color
        table.setSelectionForeground(Color.WHITE); // Text color for selected rows

        // Alternate row color
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                // If the row is selected, set the background color to the selection color
                if (isSelected) {
                    comp.setBackground(new Color(60, 179, 113)); // Same green as selection background
                    comp.setForeground(Color.WHITE); // Text color for selected row
                } else {
                    // Alternate row color logic
                    comp.setBackground(row % 2 == 0 ? Color.WHITE : new Color(245, 245, 245));
                    comp.setForeground(Color.BLACK); // Default text color for unselected rows
                }
                return comp;
            }
        });
    }

}
