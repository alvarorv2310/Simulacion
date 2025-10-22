package views;


import models.shapes.Circle;
import models.shapes.Triangle;

import javax.swing.*;
import java.awt.*;

public class TrianglePanel extends JPanel {
    private Triangle triangle;

    public TrianglePanel(Triangle triangle) {
        this.triangle = triangle;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(triangle.getColor());
        g2d.fillOval(triangle.getX(), triangle.getY(), triangle.getWidth(), triangle.getWidth());
    }

    public void updateCirclePosition(int x, int y) {
        triangle.setX(x);
        triangle.setY(y);
        repaint();
    }

    public void updateCircleColor(Color color) {
        triangle.setColor(color);
        repaint();
    }
}

