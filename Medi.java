/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savelifeadventure;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.net.URL;
public class Medi {

    int x;
    int y;
    Image Medi;

    public Medi(int x, int y) {
        URL MedikURL = this.getClass().getResource("imMedi.gif");
        Medi = Toolkit.getDefaultToolkit().getImage(MedikURL);
        this.x = x;
        this.y = y;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }
}
