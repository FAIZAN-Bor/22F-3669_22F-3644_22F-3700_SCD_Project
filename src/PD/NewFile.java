package PD;

import javax.swing.*;
import java.awt.*;
import BLL.IEditorBusinessLogic;

public class NewFile extends JFrame {
    private JTextArea textArea;
    private JButton saveButton;
    private IEditorBusinessLogic files;

    public NewFile(IEditorBusinessLogic files) {
        this(files, ""); // Use empty content for a new file.
    }

    public NewFile(IEditorBusinessLogic files, String content) {
        this.files = files;
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("New File Editor");
        this.setLayout(new BorderLayout(10, 10));

        // Text Area Setup
        textArea = new JTextArea(20, 50);
        textArea.setText(content.replaceAll("\r\n", "\n"));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane(textArea);
        
        // Save Button
        saveButton = new JButton("Save");
        styleButton(saveButton);
        saveButton.addActionListener(e -> saveFile());

        // Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.setBackground(new Color(230, 240, 250));
        buttonPanel.add(saveButton);

        // Add components to Frame
        this.add(scrollPane, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.setVisible(true); // Ensure components are initialized before visibility
    }

    private void saveFile() {
        String filename = JOptionPane.showInputDialog(this, "Enter filename:");
        if (filename != null && !filename.trim().isEmpty()) {
            boolean isSaved = files.saveToDB(filename, textArea.getText());
            String message = isSaved ? "File saved with name: " + filename : "File already exists";
            JOptionPane.showMessageDialog(this, message, isSaved ? "Success" : "Error", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Filename cannot be empty.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        button.setBackground(new Color(60, 179, 113));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
    }
}
