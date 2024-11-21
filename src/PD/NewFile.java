package PD;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import BLL.IEditorBusinessLogic;

public class NewFile extends JFrame {
    private JTextArea textArea;
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

        // Add Menu Bar
        setUpMenuBar(content);

        // Add components to Frame
        this.add(scrollPane, BorderLayout.CENTER);
        this.setVisible(true); // Ensure components are initialized before visibility
    }

    private void setUpMenuBar(String content) {
        JMenuBar menuBar = new JMenuBar();
        
        // File Menu
        JMenu fileMenu = new JMenu("File");

        // Save Option
        JMenuItem saveMenuItem = new JMenuItem("Save");
        saveMenuItem.addActionListener(e -> {
            String filename = JOptionPane.showInputDialog(this, "Enter filename:");
            if (filename != null && !filename.trim().isEmpty()) {
                boolean isSaved = files.saveToDB(filename, textArea.getText());
                String message = isSaved ? "File saved with name: " + filename : "File already exists";
                JOptionPane.showMessageDialog(this, message, isSaved ? "Success" : "Error", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Filename cannot be empty.", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });
        fileMenu.add(saveMenuItem);

        // Word Segmentation Option
        JMenuItem wordSegmentMenuItem = new JMenuItem("Word Segmentation");
        wordSegmentMenuItem.addActionListener(e -> {
        	String selectedText = textArea.getSelectedText();
            List<String> segmentedWords = files.userSelectedorFilecontent(content, selectedText);
            List<String[]> wordsWithPOS = files.tagWordsWithPOS(segmentedWords);
            new WordPOS(wordsWithPOS,"الكلمة", "جزء من الكلام"); // Assuming WordPOS is a JFrame or a dialog to display results
        });
        fileMenu.add(wordSegmentMenuItem);
        JMenuItem Stemming=new JMenuItem("Stemming");
        Stemming.addActionListener(e -> {
        	String selectedText = textArea.getSelectedText();
            List<String> segmentedWords = files.userSelectedorFilecontent(content, selectedText);
            List<String[]> StemedWords = files.generateStemming(segmentedWords);
            new WordPOS(StemedWords,"الكلمة","جذر"); // Assuming WordPOS is a JFrame or a dialog to display results
        });
        // Add File Menu to Menu Bar
        fileMenu.add(Stemming);
        JMenuItem lema=new JMenuItem("Lematize");
        lema.addActionListener(e -> {
        	String selectedText = textArea.getSelectedText();
            List<String> segmentedWords = files.userSelectedorFilecontent(content, selectedText);
            List<String[]> StemedWords = files.lemmatizeWords(segmentedWords);
            new WordPOS(StemedWords,"الكلمة","تصريف الجذور"); // Assuming WordPOS is a JFrame or a dialog to display results
        });
        // Add File Menu to Menu Bar
        fileMenu.add(lema);
        JMenuItem TFIDF=new JMenuItem("TF-IDF");
        TFIDF.addActionListener(e -> {
        	String selectedText = textArea.getSelectedText();
            List<String> selectedText1=files.splitArabicDocumentsIntoWords(selectedText);
            List<String> content1=files.splitArabicDocumentsIntoWords(content);
            Map<String,Double> TF=new HashMap<>();
            TF=files.calculateTF(content1, selectedText1);
            List<String> documents=new ArrayList<>();
            documents=files.getfilescontent();
            Map<String,Double> IDF=new HashMap<>();
            IDF=files.calculateIDF(documents, selectedText1);
            List<String[]> TF_IDF=new ArrayList<>();
            TF_IDF=files.calculateTFIDF(TF, IDF);
            new WordPOS(TF_IDF,"Word","TF-IDF"); // Assuming WordPOS is a JFrame or a dialog to display results
        });
        // Add File Menu to Menu Bar
        fileMenu.add(TFIDF);
        JMenuItem PKL=new JMenuItem("PKL");
        PKL.addActionListener(e -> {
        	String selectedText = textArea.getSelectedText();
            List<String> selectedText1=files.splitArabicDocumentsIntoWords(selectedText);
            List<String> content1=files.splitArabicDocumentsIntoWords(content);
            Map<String,Double> TF=new HashMap<>();
            TF=files.calculateTF(content1, selectedText1);
            List<String> documents=new ArrayList<>();
            documents=files.getfilescontent();
            String result = String.join(", ", documents);
            documents=files.splitArabicDocumentsIntoWords(result);
            Map<String,Double> CorpusProb=new HashMap<>();
            CorpusProb=files.calculateCorpusProbability(selectedText1, documents);
            List<String[]> PKL1=new ArrayList<>();
            PKL1=files.calculatePKL(TF, CorpusProb);
            new WordPOS(PKL1,"Word","PKL"); // Assuming WordPOS is a JFrame or a dialog to display results
        });
        // Add File Menu to Menu Bar
        fileMenu.add(PKL);
        JMenuItem PMI=new JMenuItem("PMI");
        PMI.addActionListener(e -> {
            List<String> documents=new ArrayList<>();
            documents=files.getfilescontent();
            String result = String.join(" ", documents);
            documents=files.splitArabicDocumentsIntoWords(result);
            List<String[]> PMI1=new ArrayList<>();
            PMI1=files.calculatePMI(documents);
            new WordPOS(PMI1,"Word","PMI"); // Assuming WordPOS is a JFrame or a dialog to display results
        });
        // Add File Menu to Menu Bar
        fileMenu.add(PMI);
        menuBar.add(fileMenu);

        // Set the Menu Bar to the Frame
        this.setJMenuBar(menuBar);
    }
}
