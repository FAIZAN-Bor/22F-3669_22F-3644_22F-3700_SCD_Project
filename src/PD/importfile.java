package PD;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import BLL.IEditorBusinessLogic;
import DTO.Files;
import DTO.Page;

public class importfile extends JFrame {
    private IEditorBusinessLogic filesfrombusiness;
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton searchButton;
    private JTextField searchTextField;
    private JComboBox<String> searchComboBox;

    public importfile(IEditorBusinessLogic filesfrombusiness) {
        this.filesfrombusiness = filesfrombusiness;
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Imported Files");
        this.setLayout(new BorderLayout());

        // Search panel styling
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        searchPanel.setBackground(new Color(230, 240, 250));

        searchButton = new JButton("Search");
        styleButton(searchButton);

        searchTextField = new JTextField(20);
        String[] options = {"Search by Exact Word", "Search by Prefix/Postfix"};
        searchComboBox = new JComboBox<>(options);
        searchComboBox.setFont(new Font("Arial", Font.PLAIN, 14));
        searchTextField.setFont(new Font("Arial", Font.PLAIN, 14));

        searchPanel.add(searchComboBox);
        searchPanel.add(searchTextField);
        searchPanel.add(searchButton);

        // Table setup
        String[] columnNames = {"ID", "FileName"};
        List<Files> files = filesfrombusiness.getFiles();
        Object[][] data = new Object[files.size()][columnNames.length];
        for (int i = 0; i < files.size(); i++) {
            data[i][0] = files.get(i).getid();
            data[i][1] = files.get(i).getfilename();
        }

        tableModel = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 1;
            }
        };

        table = new JTable(tableModel);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(25);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        JScrollPane scrollPane = new JScrollPane(table);

        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBackground(new Color(230, 240, 250));

        JButton viewSpecific = new JButton("View Specific");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");
        styleButton(viewSpecific);
        styleButton(updateButton);
        styleButton(deleteButton);

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    int row = table.getSelectedRow();
                    int id = (int) tableModel.getValueAt(row, 0);
                    String content = filesfrombusiness.viewFile(id).trim();
                    
                    content = content.trim();

                    String trans_cont = filesfrombusiness.transliterate(content);
                    new NewFile(filesfrombusiness, trans_cont);
                    
                    new NewFile(filesfrombusiness, trans_cont);
                    importfile.this.dispose();
                }
            }
        });

        viewSpecific.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filename = JOptionPane.showInputDialog(null, "Enter filename:");
                if (filename != null && !filename.trim().isEmpty()) {
                    Files file = filesfrombusiness.searchFilename(filename);
                    if (file != null) {
                        new NewFile(filesfrombusiness, file.getcontent());
                    } else {
                        JOptionPane.showMessageDialog(null, "File not found.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (table.isEditing()) {
                    table.getCellEditor().stopCellEditing();
                }
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    int id = (int) tableModel.getValueAt(selectedRow, 0);
                    String newFilename = (String) tableModel.getValueAt(selectedRow, 1);
                    filesfrombusiness.updateFilename(id, newFilename);
                    JOptionPane.showMessageDialog(importfile.this, "Filename updated successfully.", "Update", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    int id = (int) tableModel.getValueAt(selectedRow, 0);
                    String filename = (String) tableModel.getValueAt(selectedRow, 1);
                    filesfrombusiness.deleteFile(id);
                    tableModel.removeRow(selectedRow);
                    JOptionPane.showMessageDialog(importfile.this, filename + " deleted successfully.", "Delete", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(importfile.this, "No file selected for deletion.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchTerm = searchTextField.getText().trim();
                if (searchTerm.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a search term.", "Empty Search Term", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                String selectedOption = (String) searchComboBox.getSelectedItem();
                List<Page> searchResults = filesfrombusiness.searchWordFromFiles(searchTerm);

                if (searchResults.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No data found for the search term: " + searchTerm, "No Results Found", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                if (selectedOption.equals("Search by Exact Word")) {
                    searchTerm = " " + searchTerm + " ";
                }

                new searchResults(searchResults, searchTerm, filesfrombusiness);
            }
        });

        buttonPanel.add(viewSpecific);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        this.add(searchPanel, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        button.setBackground(new Color(60, 179, 113));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
    }

}
