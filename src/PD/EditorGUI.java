package PD;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import BLL.EditorBusinessLogic;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class EditorGUI extends JFrame {
    
	private JButton create;
    
	public EditorGUI() {
        
        
        create = new JButton("Create");
       
        
        create.addActionListener(new ActionListener()
        		{
        	public void actionPerformed(ActionEvent e) {
                new NewFile(); 
                EditorGUI.this.dispose();}
        		});
       
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setTitle("Arabic Editor");
        this.add(create);
     
        
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new EditorGUI();
    }
}