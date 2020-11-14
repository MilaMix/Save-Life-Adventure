package savelifeadventure;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;

public class Player {
    public int HP;
    public int x;
    public int y;
    int countStuff= 0;
    int countStuff2= 0;
    int countStuff3= 0;
    public int pass = 0;
    public int jump = 0;
    public static int score = 0;
    public int speedx = 0;
    public int speedy = 0;
    int count = 0;
    Image[] image = new Image[3];
    URL leftgifURL = this.getClass().getResource("imLG.gif");
    URL rightgifURL = this.getClass().getResource("imRG.gif");
    URL rightpURL = this.getClass().getResource("imRS.png");
    
    public LinkedList<floor> e = Obfloor.getfloorBounds();

    Player(int x, int y) {
        HP = 50;
        image[0] = Toolkit.getDefaultToolkit().getImage(rightgifURL);
        image[1] = Toolkit.getDefaultToolkit().getImage(leftgifURL);
        image[2] = Toolkit.getDefaultToolkit().getImage(rightpURL);
        this.x = x;
        this.y = y;
        tjump.start();

    }
    Thread tjump = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (jump == 1) {
                    int ppp = 1;
                    for (int i = 0; i < 10; i++) {
                        if (i < 2) {
                            for (int j = 0; j < 70000; j++)j += 0;
                            speedy = -13;
                        } else {
                            for (int j = 0; j < 70000 - (ppp * 2000); j++)j += 0;
                            speedy = -13 + (i - (i + 1));
                        }
                        try {
                            Thread.sleep(15);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    jump = 0;
                }
            }
        }

    });

    public void update() {
        x += speedx;
        y += speedy;
        if (x < 0) x = 0;
        if (y < 0)y = 0;
        if (x >= 1140)x = 1140;
        if (colision())speedy = 0;
        else speedy = 3;
    }


    public Rectangle getBounds() {
        return new Rectangle(x+20 , y+46, 30, 10);
    }

    public boolean colision() {
        int fall = 0;
        try {
            for (int i = 0; i < e.size(); i++) {
            if (getBounds().intersects(e.get(i).getBounds()))return true;
            else fall = 0;
            }
        } catch (NullPointerException e) {
            System.out.print("");
        }
        return (fall == 1) ? true : false;
    }
}
