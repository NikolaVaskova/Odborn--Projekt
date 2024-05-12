package org.example;

import javax.swing.*;
import java.awt.*;

public class Checklist extends JFrame {
    JPanel panel;
    JLabel label;
    JCheckBox checkBox;
    JScrollBar scrollBar;
    JButton button;

    public Checklist() throws HeadlessException {
        setTitle("Checklist");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        //setIconImage
        //setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints g = new GridBagConstraints();

        add(panel);
    }
}
