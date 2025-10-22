package models.shapes;

import java.awt.*;

public class Square extends Figure{
    public Square(int x, int y, int side, java.awt.Color color) {
        super(x, y, side, side, color);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);
        g2d.fillRect(x,y,width,height);
    }
}
