package PD;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import BLL.IEditorBusinessLogic;
import DTO.Page;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class searchResults extends JFrame {
    private JTable resultsTable;
    private DefaultTableModel tableModel;
    private IEditorBusinessLogic files;

    public searchResults(List<Page> searchResults, String word, IEditorBusinessLogic filesfrombusiness) {
        files = filesfrombusiness;
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Search Results");
        this.setLayout(new BorderLayout());

        String[] columnNames = {"Page ID", "Document ID", "Search Results"};

        
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // All cells are non-editable
            }
        };

        for (Page page : searchResults) {
            int pageId = page.getPageId();
            int documentId = page.getDocumentId();
            String contentLine = page.getSearchResult();
            String snippet = filesfrombusiness.generateSnippet(contentLine, word);
            tableModel.addRow(new Object[]{pageId, documentId, snippet});
        }

        resultsTable = new JTable(tableModel);
        resultsTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && resultsTable.getSelectedRow() != -1) {
                    int selectedRow = resultsTable.getSelectedRow();
                    Page selectedPage = searchResults.get(selectedRow);
                    new NewFile(files, selectedPage.getSearchResult()); // Assuming NewFile accepts full content
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(resultsTable);
        this.add(scrollPane, BorderLayout.CENTER);
        this.setVisible(true);
    }
}
