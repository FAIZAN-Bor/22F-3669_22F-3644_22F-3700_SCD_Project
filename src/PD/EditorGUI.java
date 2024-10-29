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
    private JButton importfile;
    private JButton importfromlocal;
    private EditorBusinessLogic filesfrombusiness = new EditorBusinessLogic();

    public EditorGUI() {
        create = new JButton("Create");
        importfile = new JButton("Import From DB");
        importfromlocal = new JButton("Import From Local PC");

        importfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new importfile();
                EditorGUI.this.dispose();
            }
        });

        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NewFile();
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
                    new NewFile(content);
                }
            }
        });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 700);
        this.setLayout(new FlowLayout());
        this.setTitle("Arabic Editor");
        this.add(create);
        this.add(importfile);
        this.add(importfromlocal);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new EditorGUI();
    }
}
