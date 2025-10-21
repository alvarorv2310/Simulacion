package models.shapes;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class Circle extends Figure {

    public Circle(int x, int y, int diameter, java.awt.Color color) {
        super(x, y, diameter, diameter, color);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);
        g2d.fillOval(x, y, width, height);
    }
}
