/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savelifeadventure;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class HomeGame extends JPanel {

    private ImageIcon feild = new ImageIcon(this.getClass().getResource("imHome.jpg"));

    public JButton BStart = new JButton("Start");
    public JButton BExit1 = new JButton("Exit");

    HomeGame() {
        setLayout(null);
        BExit1.setBounds(750, 500, 150, 90);
        add(BExit1);
        add(BStart);
        BStart.setBounds(750, 370, 150, 90);
        add(BStart);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(feild.getImage(), 0, 0, 1200, 700, this);

    }
}
