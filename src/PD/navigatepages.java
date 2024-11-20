package PD;

import javax.swing.*;
import java.awt.*;
import BLL.IEditorBusinessLogic;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class navigatepages {
    private ArrayList<JFrame> pages;
    private int currentPageIndex;
    private IEditorBusinessLogic obj;
    private ArrayList<String> a;   

    public navigatepages(IEditorBusinessLogic o, int id) {
        obj = o;
        a = obj.navigatepages(id); 

        if (a == null || a.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No pages found for the given file ID.");
            return;
        }

        pages = new ArrayList<>();
        createPages();
        currentPageIndex = 0;
        showPage(currentPageIndex);
        pages.get(currentPageIndex).setVisible(true); 
    }

    private void createPages() {
        for (int i = 0; i < a.size(); i++) {
            JFrame page = new JFrame("Page " + (i + 1));
            page.setSize(800, 600);
            page.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            page.setLocationRelativeTo(null);

            // Text Area Setup
            JTextArea contentArea = new JTextArea(a.get(i));
            contentArea.setFont(new Font("Arial", Font.PLAIN, 16));
            contentArea.setLineWrap(true);
            contentArea.setWrapStyleWord(true);
            contentArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(contentArea);

            // Navigation Panel
            JPanel navPanel = new JPanel();
            JButton backButton = new JButton("<");
            JButton forwardButton = new JButton(">");
            styleButton(backButton);
            styleButton(forwardButton);

            backButton.addActionListener(this::goBack);
            forwardButton.addActionListener(this::goForward);

            navPanel.add(backButton);
            navPanel.add(forwardButton);

            // Adding components to page
            page.add(scrollPane, BorderLayout.CENTER);
            page.add(navPanel, BorderLayout.SOUTH);

            pages.add(page);  // Add page to the list
        }
    }

    private void showPage(int index) {
        for (int i = 0; i < pages.size(); i++) {
            pages.get(i).setVisible(i == index);
        }
    }

    private void goBack(ActionEvent e) {
        if (currentPageIndex > 0) {
            currentPageIndex--;
            showPage(currentPageIndex);
        } else {
            JOptionPane.showMessageDialog(null, "Already at the first page!");
        }
    }

    private void goForward(ActionEvent e) {
        if (currentPageIndex < pages.size() - 1) {
            currentPageIndex++;
            showPage(currentPageIndex);
        } else {
            JOptionPane.showMessageDialog(null, "Already at the last page!");
        }
    }

    // Styling for buttons
    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        button.setBackground(new Color(60, 179, 113)); // Green color
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
    }
}
