package savelifeadventure;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainFrame extends JFrame implements ActionListener {

    HomeGame h = new HomeGame();

    MainFrame() {
        h.BStart.addActionListener(this);
        h.BExit1.addActionListener(this);
        add(h);

    }

    public static void main(String[] args) {
        JFrame window = new MainFrame();
        window.setTitle("Save life Adveture");
        window.setSize(1200, 700);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setResizable(false);
        window.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == h.BStart) {
            this.remove(h);
            PlayState g = new PlayState();
            this.setResizable(false);
            this.setVisible(true);
            this.setLocationRelativeTo(null);
            this.setSize(1200, 700);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.add(g);
            g.requestFocusInWindow();
        } else if (e.getSource() == h.BExit1) {
            System.exit(0);
        }
        this.validate();
        this.repaint();
    }

}
