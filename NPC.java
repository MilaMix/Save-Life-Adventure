/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savelifeadventure;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.net.URL;

/**
 *
 * @author 66630
 */
public class NPC {
    public int x;
    public int y;
    public Image imnpc;
    public NPC(int x,int y){
        URL imnpcURL = this.getClass().getResource("imnpc.png");
        imnpc = Toolkit.getDefaultToolkit().getImage(imnpcURL);
        this.x = x;
        this.y = y;
    }
    public Rectangle getBounds() {
        return new Rectangle(x , y, 55, 52);
    }
}
