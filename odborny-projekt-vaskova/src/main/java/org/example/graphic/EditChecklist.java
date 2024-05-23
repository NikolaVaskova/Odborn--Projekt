package org.example.graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditChecklist extends JFrame {
    JPanel panel;
    JLabel addLabel, removeLabel;
    JTextField addText, removeText;
    JButton saveButton;
    public EditChecklist() throws HeadlessException {
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints g = new GridBagConstraints();

        addLabel = new JLabel("Add:");
            g.gridx = 0;
            g.gridy = 0;
            g.gridwidth = 1;
            g.gridheight = 1;
            panel.add(addLabel, g);


        removeLabel = new JLabel("Remove:");
            g.gridx = 0;
            g.gridy = 1;
            g.gridwidth = 1;
            g.gridheight = 1;
            panel.add(removeLabel, g);


        addText = new JTextField();
            g.gridx = 1;
            g.gridy = 0;
            g.gridwidth = 2;
            g.gridheight = 1;
            g.fill = GridBagConstraints.HORIZONTAL;
            addText.setColumns(20);
            panel.add(addText, g);


        removeText = new JTextField();
            g.gridx = 1;
            g.gridy = 1;
            g.gridwidth = 2;
            g.gridheight = 1;
            g.fill = GridBagConstraints.HORIZONTAL;
            removeText.setColumns(20);
            panel.add(removeText, g);

        saveButton = new JButton("Save");
            g.gridx = 0;
            g.gridy = 2;
            g.gridwidth = 1;
            g.gridheight = 1;
            panel.add(saveButton, g);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        add(panel);

        setTitle("Edit");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 200);
        //setIconImage
        //setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
