package PD;

import javax.swing.*;

import BLL.IEditorBusinessLogic;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class selectOption extends JFrame {
    private JButton transliterate;
    private JButton Arabic;
    public selectOption(IEditorBusinessLogic filesfrombusiness,String transliteration,String arabic) {
        // Frame Settings
        this.setSize(500, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Select Option");
        this.setLayout(new BorderLayout(10, 10));
        this.setLocationRelativeTo(null); // Center the window on the screen

        // Buttons Initialization
        transliterate = new JButton("Transliterate");
        
        Arabic=new JButton("Arabic");
        styleButton(transliterate);
        
        styleButton(Arabic);
        // Button Panel Setup
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        buttonPanel.setBackground(new Color(240, 248, 255)); // Light blue background
        buttonPanel.add(transliterate);
        
        buttonPanel.add(Arabic);
        transliterate.addActionListener(new ActionListener()
        		{

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						new NewFile(filesfrombusiness, transliteration);
						selectOption.this.dispose();
					}
        	
        		});
        Arabic.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new NewFile(filesfrombusiness, arabic);
				selectOption.this.dispose();
			}
	
		});
        	
        // Add components to Frame
        this.add(buttonPanel, BorderLayout.CENTER);

        // Make Frame Visible
        this.setVisible(true);
    }

    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.PLAIN, 16));
        button.setBackground(new Color(60, 179, 113)); // Green color
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
    }


}
