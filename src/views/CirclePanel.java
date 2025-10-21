package views;


import models.shapes.Circle;
import javax.swing.*;
import java.awt.*;

public class CirclePanel extends JPanel {
    private Circle circle;

    public CirclePanel(Circle circle) {
        this.circle = circle;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(circle.getColor());
        g2d.fillOval(circle.getX(), circle.getY(), circle.getWidth(), circle.getWidth());
    }

    public void updateCirclePosition(int x, int y) {
        circle.setX(x);
        circle.setY(y);
        repaint();
    }

    public void updateCircleColor(Color color) {
        circle.setColor(color);
        repaint();
    }
}

