package org.example.graphic;

import javax.swing.*;
import java.awt.*;
//Tohle je hlavni graficka trida, ktera bude pouzivana k spusteni grafiky programu
public class Graphics extends JFrame {
    public Graphics()throws HeadlessException{
        new Login();
    }
}
