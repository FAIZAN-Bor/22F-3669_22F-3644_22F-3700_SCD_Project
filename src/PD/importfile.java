package PD;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import BLL.EditorBusinessLogic;
import DTO.Files;

public class importfile extends JFrame {
    

    public importfile() {
        this.setSize(700, 700);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());

        String[] columnNames = {"ID", "FileName"};
        
        List<Files> files = filesfrombusiness.getFiles();
        Object[][] data = new Object[files.size()][columnNames.length];
        int i = 0;
    
        for (Files file : files) {
            data[i][0] = file.getid();
            data[i][1] = file.getfilename();
            i++;
        }
        
        tableModel = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 1; 
            }
        };
        
        table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton searchButton = new JButton("Search");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            	if (table.isEditing()) {
                    table.getCellEditor().stopCellEditing();
                }
                if (e.getClickCount() == 2 && table.getSelectedRow()!=-1) {
                	int row=table.getSelectedRow();
                	int id = (int) tableModel.getValueAt(row, 0);
                	String content=filesfrombusiness.viewfile(id);
                	new NewFile(content);
                	importfile.this.dispose();
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
                   
                    filesfrombusiness.deletefile(id);
                    System.out.println(filename + " Deleted!!");
                    
                    tableModel.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(importfile.this, "No file selected for deletion.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        buttonPanel.add(deleteButton);

        this.add(scrollPane, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new importfile();
    }
}