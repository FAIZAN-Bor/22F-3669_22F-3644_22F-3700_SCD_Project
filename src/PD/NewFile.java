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
	
	//Faizan
	private JTextArea textArea;
   public NewFile()
    {
    	this.setSize(700, 700);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("NewFile");
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        textArea = new JTextArea(20, 50);
        JScrollPane scrollPane = new JScrollPane(textArea);

        this.add(scrollPane, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);

    }
    public NewFile(String content)
    {
    	this.setSize(700, 700);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("NewFile");
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        textArea = new JTextArea(20, 50);
        textArea.setText(content);
        JScrollPane scrollPane = new JScrollPane(textArea);

        
        
        saveButton.addActionListener(e -> {
            String filename = JOptionPane.showInputDialog(this, "Enter filename:");
            if (filename != null && !filename.trim().isEmpty()) {
            	NewFile.this.files.savetoDB(filename, textArea.getText());
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