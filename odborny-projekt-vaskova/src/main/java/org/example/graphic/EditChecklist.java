package org.example.graphic;

import org.example.DBConnect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

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
                DBConnect dbConnect = new DBConnect();
                String itemToAdd = addText.getText();
                String itemToRemove = removeText.getText();

                if (!itemToAdd.isEmpty()) {
                    String lastUsedTable = SelectOperation.getLastUsedTable();
                    dbConnect.addItemInTable(lastUsedTable, itemToAdd);
                }

                if (!itemToRemove.isEmpty()) {
                    try {
                        int idToRemove = Integer.parseInt(itemToRemove);
                        String lastUsedTable = SelectOperation.getLastUsedTable();
                        dbConnect.removeItemById(lastUsedTable, idToRemove);
                    } catch (NumberFormatException ex) {
                        System.out.println("Invalid ID format: " + itemToRemove);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }

                setVisible(false);
            }
        });

        add(panel);

        setTitle("Edit");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
