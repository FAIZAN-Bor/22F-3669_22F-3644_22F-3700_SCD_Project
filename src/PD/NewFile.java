package PD;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import BLL.EditorBusinessLogic;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class NewFile extends JFrame {
    private JTextArea textArea;
    private JButton saveButton;
    private EditorBusinessLogic files = new EditorBusinessLogic();

    public NewFile() {
        this.setSize(700, 700);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("NewFile");
        this.setLayout(new BorderLayout());
        this.setVisible(true);

        textArea = new JTextArea(20, 50);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);

        saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            String filename = JOptionPane.showInputDialog(this, "Enter filename:");
            if (filename != null && !filename.trim().isEmpty()) {
                NewFile.this.files.saveToDB(filename, textArea.getText());
                JOptionPane.showMessageDialog(this, "File saved with name: " + filename);
            } else {
                JOptionPane.showMessageDialog(this, "Filename cannot be empty.");
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(saveButton);
        this.add(scrollPane, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    public NewFile(String content) {
        this.setSize(700, 700);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("NewFile");
        this.setLayout(new BorderLayout());
        this.setVisible(true);

        textArea = new JTextArea(20, 50);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setText(content.replaceAll("\r\n", "\n")); // Ensure new lines are correctly interpreted
        JScrollPane scrollPane = new JScrollPane(textArea);

        saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            String filename = JOptionPane.showInputDialog(this, "Enter filename:");
            if (filename != null && !filename.trim().isEmpty()) {
                NewFile.this.files.saveToDB(filename, textArea.getText());
                JOptionPane.showMessageDialog(this, "File saved with name: " + filename);
            } else {
                JOptionPane.showMessageDialog(this, "Filename cannot be empty.");
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(saveButton);
        this.add(scrollPane, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }
}
