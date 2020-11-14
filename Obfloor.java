package savelifeadventure;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

public class Obfloor {

    static LinkedList<floor> e = new LinkedList<>();
    floor temp;

    public Obfloor() {
    }

    public void removefloor() {
        for (int i = 0; i < e.size(); i++) {
            e.remove();
        }
    }

    public void createfloor(int x, int y) {
        addfloor(new floor(x, y));
    }

    public void draw(Graphics g, Color c) {
        for (int i = 0; i < e.size(); i++) {
            temp = e.get(i);
            temp.draw(g, c);
        }
    }

    public void addfloor(floor f) {
        e.add(f);
    }

    public static LinkedList<floor> getfloorBounds() {
        return e;
    }
}
