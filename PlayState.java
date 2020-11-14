/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savelifeadventure;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayState extends JPanel implements ActionListener {

    ImageIcon BG1 = new ImageIcon(this.getClass().getResource("imBG1.jpg"));
    ImageIcon BG2 = new ImageIcon(this.getClass().getResource("imBG2.jpg"));
    ImageIcon BG3 = new ImageIcon(this.getClass().getResource("imBG3.jpg"));
    ImageIcon imWin = new ImageIcon(this.getClass().getResource("imWin.jpg"));
    ImageIcon imGameover = new ImageIcon(this.getClass().getResource("imGameover.jpg"));
    ImageIcon heart = new ImageIcon(this.getClass().getResource("imHeart.gif"));

    ArrayList<Block> bird1 = new ArrayList<Block>();
    ArrayList<Block> bird2 = new ArrayList<Block>();
    ArrayList<Block> bird3 = new ArrayList<Block>();
    ArrayList<Medi> med1 = new ArrayList<Medi>();
    ArrayList<Medi> med2 = new ArrayList<Medi>();
    ArrayList<Medi> med3 = new ArrayList<Medi>();
    ArrayList<NPC> npcarr = new ArrayList<NPC>();
    int win = 0;
    int state = 1;

    public int getstate() {
        return state;
    }
    Player player1 = new Player(100, 600);
    Obfloor f = new Obfloor();
    int Time = 80;
    Thread time = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Time--;
            }
        }
    });
    Thread playerrun = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(7);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                player1.update();
                repaint();
            }
        }

    });

    PlayState() {
        playerrun.start();
        time.start();
        
        bird1.add(new Block(1150, 148));
        bird1.add(new Block(1050, 228));

        bird2.add(new Block(470, 628));
        bird2.add(new Block(500, 228));

        bird3.add(new Block(1150, 148));
        bird3.add(new Block(120, 148));
        bird3.add(new Block(1111, 228));
        bird3.add(new Block(960, 308));
        bird3.add(new Block(960, 548));
        bird3.add(new Block(1150, 388));
        bird3.add(new Block(570, 618));
        bird3.add(new Block(550, 228));
        bird3.add(new Block(585, 388));

        med1.add(new Medi(720, 228));
        med1.add(new Medi(300, 228));
        med1.add(new Medi(400, 308));
        med1.add(new Medi(500, 388));
        med1.add(new Medi(600, 468));
        med1.add(new Medi(700, 548));
        med1.add(new Medi(800, 628));

        med2.add(new Medi(300, 228));
        med2.add(new Medi(15, 308));
        med2.add(new Medi(500, 388));
        med2.add(new Medi(15, 468));
        med2.add(new Medi(700, 548));
        med2.add(new Medi(800, 628));
        med2.add(new Medi(1070, 548));
        med2.add(new Medi(1150, 628));
        med2.add(new Medi(1070, 228));

        med3.add(new Medi(300, 228));
        med3.add(new Medi(50, 308));
        med3.add(new Medi(500, 388));
        med3.add(new Medi(50, 468));
        med3.add(new Medi(700, 548));
        med3.add(new Medi(800, 628));
        med3.add(new Medi(1070, 228));
        med3.add(new Medi(1150, 308));
        med3.add(new Medi(0, 148));
        med3.add(new Medi(50, 468));
        med3.add(new Medi(700, 548));
        med3.add(new Medi(800, 628));

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int a = e.getKeyCode();
                if (player1.colision()) {
                    if (a == KeyEvent.VK_LEFT || a == KeyEvent.VK_A) {
                        player1.count = 1;

                        player1.speedx = -2;

                    }

                    if (a == KeyEvent.VK_RIGHT || a == KeyEvent.VK_D) {
                        player1.count = 0;
                        player1.speedx = 2;
                    }

                    if (a == KeyEvent.VK_UP || a == KeyEvent.VK_W) {
                        player1.jump = 1;

                    }

                } else {
                    if (a == KeyEvent.VK_RIGHT || a == KeyEvent.VK_D) {
                        player1.count = 0;
                        player1.speedx = 2;
                    }
                    if (a == KeyEvent.VK_LEFT || a == KeyEvent.VK_A) {
                        player1.count = 1;
                        player1.speedx = -2;
                    }
                    player1.speedy = 2;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                player1.count = 2;
                player1.speedx = 0;
                player1.speedy = 0;
            }
        });
        setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (player1.HP <= 0 || player1.y > 700 || Time <= 0) {
            g.drawImage(imGameover.getImage(), 0, 0, 1200, 700, this);
            if (player1.HP <= 0) {

            } else {
            }
        } else if (state == 1) {

            g.drawImage(BG1.getImage(), 0, 0, 1200, 700, this);
            f.removefloor();
            int floorarr[][] = {{0, 178},
            {100, 178},
            {200, 178},
            {1100, 178},
            {300, 258},
            {990, 258},
            {500, 258},
            {700, 258},
            {200, 338},
            {990, 338},
            {400, 338},
            {600, 338},
            {800, 338},
            {100, 418},
            {1100, 418},
            {500, 418},
            {300, 418},
            {990, 498},
            {0, 498},
            {600, 498},
            {1100, 578},
            {700, 578},
            {100, 578},
            {0, 658},
            {100, 658},
            {200, 658},
            {300, 658},
            {400, 658},
            {500, 658},
            {600, 658},
            {700, 658},
            {800, 658},
            {900, 658},
            {1000, 658},
            {1100, 658},};

            for (int[] floorarr1 : floorarr) {
                f.createfloor(floorarr1[0], floorarr1[1]);
            }
            f.draw(g, Color.pink);
            g.drawImage(player1.image[player1.count], player1.x, player1.y, this);
            npcarr.add(new NPC(15, 178 - 52));
            g.drawImage(npcarr.get(0).imnpc, npcarr.get(0).x, npcarr.get(0).y, this);
            g.setColor(Color.white);
            g.setFont(new Font("Hobo Std", Font.BOLD, 30));
            g.drawString("HP: " + player1.HP, 700, 50);
            g.drawString(" Time: " + Integer.toString(Time), 800, 50);
            g.setColor(Color.pink);
            g.setFont(new Font("Hobo Std", Font.BOLD, 50));
            g.drawString("Score: " + player1.countStuff + "/6", 530, 100);
            for (int i = 0; i < med1.size(); i++) {
                g.drawImage(med1.get(i).Medi, med1.get(i).x, med1.get(i).y, this);
            }
            try {
                for (int i = 0; i < bird1.size(); i++) {
                    g.drawImage(bird1.get(i).block, bird1.get(i).x, bird1.get(i).y, this);
                }

            } catch (Exception e) {
                System.out.print("");
            }

            for (int i = 0; i < med1.size(); i++) {
                if (player1.getBounds().intersects(med1.get(i).getBounds())) {
                    med1.remove(i);
                    player1.countStuff++;
                }
            }
            for (int i = 0; i < bird1.size(); i++) {
                if (player1.getBounds().intersects(bird1.get(i).getBounds())) {
                    bird1.remove(i);

                    player1.HP = player1.HP - 10;
                }
            }
            if (player1.getBounds().intersects(npcarr.get(0).getBounds())) {
                npcarr.removeAll(npcarr);
                if (player1.countStuff >= 6) {

                    state = 2;
                } else {
                    player1.HP = 0;
                }
            }

        } else if (state == 2) {
            g.drawImage(BG2.getImage(), 0, 0, 1200, 700, this);
            f.removefloor();

            int floorarr[][]
                    = {{15, 178},
                    {100, 258},
                    {115, 178},
                    {210, 178},
                    {290, 258},
                    {290, 338},
                    {290, 418},
                    {290, 578},
                    {15, 338},
                    {100, 418},
                    {528, 418},
                    {15, 498},
                    {420, 498},
                    {100, 578},
                    {440, 338},
                    {1087, 178},
                    {1037, 258},
                    {960, 338},
                    {1087, 418},
                    {977, 498},
                    {1087, 578},
                    {570, 578},
                    {717, 578},
                    {0, 658},
                    {100, 658},
                    {200, 658},
                    {300, 658},
                    {400, 658},
                    {500, 658},
                    {800, 658},
                    {900, 658},
                    {1000, 658},
                    {1100, 658},};

            for (int[] floorarr1 : floorarr) {
                f.createfloor(floorarr1[0], floorarr1[1]);
            }
            f.draw(g, Color.orange);
            npcarr.add(new NPC(1100, 178 - 52));
            g.drawImage(npcarr.get(0).imnpc, npcarr.get(0).x, npcarr.get(0).y, this);
            g.drawImage(player1.image[player1.count], player1.x, player1.y, this);
            g.setColor(Color.white);
            g.setFont(new Font("Hobo Std", Font.BOLD, 30));
            g.drawString("HP: " + player1.HP, 700, 50);
            g.drawString(" Time: " + Integer.toString(Time), 800, 50);
            g.setColor(Color.orange);
            g.setFont(new Font("Hobo Std", Font.BOLD, 50));
            g.drawString("Score: " + player1.countStuff2 + "/8", 530, 100);
            
            for (int i = 0; i < med2.size(); i++) {
                g.drawImage(med2.get(i).Medi, med2.get(i).x, med2.get(i).y, this);
            }
            try {
                for (int i = 0; i < bird2.size(); i++) {
                    bird1.removeAll(bird1);
                    g.drawImage(bird2.get(i).block, bird2.get(i).x, bird2.get(i).y, this);
                }
            } catch (java.lang.IndexOutOfBoundsException e) {
                System.out.print("");
            }
            for (int i = 0; i < med2.size(); i++) {
                if (player1.getBounds().intersects(med2.get(i).getBounds())) {
                    med2.remove(i);
                    player1.countStuff2++;
                }

            }
            for (int i = 0; i < bird2.size(); i++) {
                if (player1.getBounds().intersects(bird2.get(i).getBounds())) {
                    bird2.remove(i);
                    player1.HP = player1.HP - 10;
                }
            }
            try {
                if (player1.getBounds().intersects(npcarr.get(1).getBounds())) {
                    npcarr.removeAll(npcarr);
                    if (player1.countStuff2 >= 8) {
                        state = 3;
                    } else {
                        player1.HP = 0;
                    }
                }

            } catch (Exception e) {
                System.out.print("");
            }

           

        } else if (state == 3) {
            g.drawImage(BG3.getImage(), 0, 0, 1200, 700, this);
            f.removefloor();
            int floorarr[][]
                    = {{50, 178},
                    {0, 178},
                    {150, 258},
                    {115, 178},
                    {400, 178},
                    {210, 178},
                    {987, 178},
                    {500, 258},
                    {300, 258},
                    {290, 338},
                    {290, 418},
                    {290, 578},
                    {50, 338},
                    {100, 418},
                    {528, 418},
                    {50, 498},
                    {420, 498},
                    {100, 578},
                    {440, 338},
                    {1087, 178},
                    {1037, 258},
                    {960, 338},
                    {1087, 418},
                    {977, 498},
                    {1087, 578},
                    {570, 578},
                    {717, 578},
                    {100, 658},
                    {200, 658},
                    {300, 658},
                    {500, 658},
                    {800, 658},
                    {900, 658},
                    {1000, 658},};

            for (int[] floorarr1 : floorarr) {
                f.createfloor(floorarr1[0], floorarr1[1]);
            }
            f.draw(g, Color.lightGray);
            g.drawImage(player1.image[player1.count], player1.x, player1.y, this);
            npcarr.add(new NPC(400, 178 - 52));
            try {
                g.drawImage(npcarr.get(0).imnpc, npcarr.get(0).x, npcarr.get(0).y, this);
            } catch (Exception e) {
                System.out.print("");
            }
            g.setColor(Color.white);
            g.setFont(new Font("Hobo Std", Font.BOLD, 30));
            g.drawString("HP: " + player1.HP, 700, 50);
            g.drawString(" Time: " + Integer.toString(Time), 800, 50);
            g.setColor(Color.lightGray);
            g.setFont(new Font("Hobo Std", Font.BOLD, 50));
            g.drawString("Score: " + player1.countStuff3 + "/11", 530, 100);
            for (int i = 0; i < med3.size(); i++) {
                g.drawImage(med3.get(i).Medi, med3.get(i).x, med3.get(i).y, this);
            }
            try {
                bird2.removeAll(bird2);
                for (int i = 0; i < bird3.size(); i++) {
                    g.drawImage(bird3.get(i).block, bird3.get(i).x, bird3.get(i).y, this);
                }

            } catch (Exception e) {
                System.out.print("");
            }

            for (int i = 0; i < med3.size(); i++) {
                if (player1.getBounds().intersects(med3.get(i).getBounds())) {
                    med3.remove(i);
                    player1.countStuff3++;
                }
            }

            for (int i = 0; i < bird3.size(); i++) {
                if (player1.getBounds().intersects(bird3.get(i).getBounds())) {
                    bird3.remove(i);

                    player1.HP -= 10;
                }
            }
            try {
                if (player1.getBounds().intersects(npcarr.get(2).getBounds())) {
                    npcarr.removeAll(npcarr);
                    if (player1.countStuff3 >= 9) {
                        win = 1;

                    } else {
                        player1.HP = 0;
                    }
                }

            } catch (Exception e) {
                System.out.print("");
            }

        }
        if (win == 1) {
            bird3.removeAll(bird3);
            try {
                g.drawImage(imWin.getImage(), 0, 0, 1200, 700, this);
                g.drawImage(heart.getImage(), 300, 400, 120, 120, this);
            } catch (Exception e) {
                System.out.println("");
            }

        }

    }

    public boolean Intersect(Rectangle2D a, Rectangle2D b) {
        return (a.intersects(b));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
