package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Checklist extends JFrame {
    private NewChecklist newChecklist;
    JPanel panel;
    JLabel label;
    JCheckBox checkBox;
    JScrollBar scrollBar;
    JButton okeyButton, editButton;

    public Checklist(DBConnect dbConnect) throws HeadlessException {
        this.newChecklist = new NewChecklist();
        for (ChecklistItem item : dbConnect.getChecklistItems()) {
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
        panel.add(checkBox, g);
        }


        scrollBar = new JScrollBar();
            g.gridx = 0;
            g.gridy = GridBagConstraints.RELATIVE;
            g.gridwidth = 1;
            g.gridheight = 1;
        scrollBar.setOrientation(JScrollBar.VERTICAL);
        scrollBar.setMinimum(0);
        scrollBar.setMaximum(100);
        scrollBar.setValue(1);
        panel.add(scrollBar, g);


        okeyButton = new JButton("Okey");
            g.gridx = 0;
            g.gridy = GridBagConstraints.RELATIVE;
            g.gridwidth = 1;
            g.gridheight = 1;
        panel.add(okeyButton, g);


        editButton = new JButton("Edit");
            g.gridx = 0;
            g.gridy = GridBagConstraints.RELATIVE;
            g.gridwidth = 1;
            g.gridheight = 1;
        panel.add(editButton, g);

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditChecklist newWindow = new EditChecklist();
                newWindow.setVisible(true);
            }
        });

        add(panel);
            setTitle("Checklist");
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setSize(500, 500);
            //setIconImage
            //setResizable(false);
            setLocationRelativeTo(null);
            setVisible(true);
        }
    }

