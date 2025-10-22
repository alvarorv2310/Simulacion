package models.shapes;

import java.awt.*;

public class Triangle extends Figure {
    public Triangle(int x, int y, int width, int height,  java.awt.Color color) {
        super(x, y, width, height, color);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);

        int[] xPoints = { x + width / 2, x, x + width };
        int[] yPoints = { y, y + height, y + height };

        g2d.fillPolygon(xPoints, yPoints, 3);
    }

}
