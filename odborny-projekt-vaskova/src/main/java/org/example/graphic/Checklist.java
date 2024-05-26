package org.example.graphic;

import org.example.logic.ChecklistItem;

import org.example.logic.NewChecklist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Checklist extends JFrame {
    private org.example.logic.NewChecklist newChecklist;
    JPanel panel;
    JCheckBox checkBox;
    JButton sendButton, exportButton, editButton, cancelButton;

    public Checklist(java.util.List<ChecklistItem> items) throws HeadlessException {
        this.newChecklist = new NewChecklist();
        for (ChecklistItem item : items) {
            this.newChecklist.addItem(item);
            }
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints g = new GridBagConstraints();

        for (ChecklistItem item : newChecklist.getItems()) {
            checkBox = new JCheckBox(item.getLabel());
            g.gridx = 0;
            g.gridy = GridBagConstraints.RELATIVE;
            g.gridwidth = 1;
            g.gridheight = 1;
            g.anchor = GridBagConstraints.WEST;
        panel.add(checkBox, g);
        }


        JPanel buttonPanel = new JPanel(new FlowLayout()); // vytvori specialni panel pro buttony

        sendButton = new JButton("Send");
        sendButton.setBackground(Color.getHSBColor(192,237,251));
        buttonPanel.add(sendButton);


        exportButton = new JButton("Export");
        exportButton.setBackground(Color.getHSBColor(192,237,251));
        buttonPanel.add(exportButton);

        exportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    java.io.File selectedFile = fileChooser.getSelectedFile();
                    System.out.println(selectedFile.getName());
                }
            }
        });


        editButton = new JButton("Edit");
        editButton.setBackground(Color.getHSBColor(192,237,251));
        buttonPanel.add(editButton);

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditChecklist newWindow = new EditChecklist();
                newWindow.setVisible(true);
            }
        });


        cancelButton = new JButton("Cancel");
        cancelButton.setBackground(Color.getHSBColor(192,237,251));
        buttonPanel.add(cancelButton);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        JScrollPane scrollPane = new JScrollPane(panel);

        setLayout(new BorderLayout()); // nastaví layout na BorderLayout
        add(scrollPane, BorderLayout.CENTER); // prida scroll panel na stred
        add(buttonPanel, BorderLayout.SOUTH); // Prida button panel dolu

        setTitle("Checklist");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700,400);
        setIconImage(new ImageIcon("savencia-icon.png").getImage());
        setLocationRelativeTo(null);
        setVisible(true);

    }
}