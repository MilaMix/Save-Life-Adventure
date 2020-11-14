package savelifeadventure;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.net.URL;
import java.awt.Rectangle;

public class floor {
    int x;
    int y;
    Image floor;
    
    public floor(int x,int y){

        this.x = x;
        this.y = y;
    }
    public void draw(Graphics g,Color c){
        g.setColor(c);
        g.fillRect(x, y, 100,5);
    }
    public String color(String str){
        return str;
    }
    public Rectangle getBounds(){
        return new Rectangle(x+10, y, 100, 5);
    }
}
