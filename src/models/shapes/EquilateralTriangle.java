package models.shapes;

import java.awt.*;

public class EquilateralTriangle extends Figure {
    public EquilateralTriangle(int x, int y, int width,   java.awt.Color color) {
        super(x, y, width, (int)((Math.sqrt(3) / 2) * width), color);
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
