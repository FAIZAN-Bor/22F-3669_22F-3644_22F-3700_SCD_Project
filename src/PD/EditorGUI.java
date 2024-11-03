package PD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import BLL.IEditorBusinessLogic;

public class EditorGUI extends JFrame {
    private JButton create;
    private JButton importfile;
    private JButton importfromlocal;
    private IEditorBusinessLogic filesfrombusiness;

    public EditorGUI(IEditorBusinessLogic filesfrombusiness) {
        this.filesfrombusiness = filesfrombusiness;

        create = new JButton("Create New File");
        importfile = new JButton("Import from Database");
        importfromlocal = new JButton("Import from Local PC");

        // Setting up button styles
        styleButton(create);
        styleButton(importfile);
        styleButton(importfromlocal);

        // Action listeners for buttons
        importfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new importfile(filesfrombusiness);
                EditorGUI.this.dispose();
            }
        });

        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NewFile(filesfrombusiness);
                EditorGUI.this.dispose();
            }
        });

        importfromlocal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    String content = filesfrombusiness.readFile(selectedFile);
                    content = content.trim();

                    String trans_cont = filesfrombusiness.transliterate(content);
                    new NewFile(filesfrombusiness, trans_cont);
                }
            }
        });

        // Setting up the main panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(240, 248, 255));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Title label
        JLabel titleLabel = new JLabel("G8 Arabic Editor", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(0, 102, 204));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Button panel
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        buttonPanel.setBackground(new Color(240, 248, 255));
        buttonPanel.add(create);
        buttonPanel.add(importfile);
        buttonPanel.add(importfromlocal);
        
        // Center button panel
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        this.add(mainPanel);

        // JFrame settings
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setTitle("Arabic Editor");
        this.setVisible(true);
    }

    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.PLAIN, 16));
        button.setBackground(new Color(0, 153, 204));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
    }

    
}
