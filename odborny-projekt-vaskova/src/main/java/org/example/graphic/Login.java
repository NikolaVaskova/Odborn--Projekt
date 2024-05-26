package org.example.graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    JPanel panel;
    JLabel nameLabel, passwordLabel;
    JTextField nameText;
    JPasswordField passwordText;
    JButton loginButton, showPasswordButton, registerButton;

    public Login() throws HeadlessException { //Konstruktor

        panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints g = new GridBagConstraints();

        nameLabel = new JLabel("Name:");
            g.gridx = 0;
            g.gridy = 0;
            g.gridwidth = 1;
            g.gridheight = 1;
        panel.add(nameLabel, g);


        passwordLabel = new JLabel("Password:");
            g.gridx = 0;
            g.gridy = 1;
            g.gridwidth = 1;
            g.gridheight = 1;
        panel.add(passwordLabel, g);


        nameText = new JTextField();
            g.gridx = 1;
            g.gridy = 0;
            g.gridwidth = 2;
            g.gridheight = 1;
            g.fill = GridBagConstraints.HORIZONTAL;
        nameText.setColumns(20);
        nameText.setBackground(Color.getHSBColor(192,237,251));
        panel.add(nameText, g);


        passwordText = new JPasswordField();
            g.gridx = 1;
            g.gridy = 1;
            g.gridwidth = 2;
            g.gridheight = 1;
            g.fill = GridBagConstraints.HORIZONTAL;
        nameText.setColumns(20);
        passwordText.setBackground(Color.getHSBColor(192,237,251));
        panel.add(passwordText, g);


        loginButton = new JButton("Login");
            g.gridx = 1;
            g.gridy = 2;
            g.gridwidth = 2;
            g.gridheight = 1;
        loginButton.setBackground(Color.getHSBColor(192,237,251));
        panel.add(loginButton, g);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                // Tady bude muset být nějaká funkce funkce
                //dbConnect.findPasswordFromUsername(loginText.getUsername);
                //validatePassword(loginText.getPassword, dbConnect.findPasswordFromUsername(loginText.getUsername));

                SelectOperation newWindow = new SelectOperation();
                newWindow.setVisible(true);
                }
            });


        showPasswordButton = new JButton("Show");
            g.gridx = 3;
            g.gridy = 1;
            g.gridwidth = 1;
            g.gridheight = 1;
        showPasswordButton.setBackground(Color.getHSBColor(192,237,251));
        panel.add(showPasswordButton, g);

        //Ukazuje a skryva heslo
        showPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (passwordText.getEchoChar() == (char)0) {
                    //pokud je heslo viditelne, skryje se
                    passwordText.setEchoChar('*');
                } else {
                    //pokud je heslo skryte, zviditelni se
                    passwordText.setEchoChar((char)0);
                }
            }
        });


        registerButton = new JButton("Register Here!");
            g.gridx = 3;
            g.gridy = 2;
            g.gridwidth = 1;
            g.gridheight = 1;
        panel.add(registerButton, g);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Register newWindow = new Register();
                newWindow.setVisible(true);
            }
        });


        add(panel);

        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 350);
        setIconImage(new ImageIcon("savencia-icon.png").getImage());
        setLocationRelativeTo(null);
        setVisible(true);
    }
}