package app;

import models.shapes.Circle;
import utils.Animation;
import views.CirclePanel;

import javax.swing.*;
import java.awt.*;

public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Simulación 2D");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 500);

            Circle circle = new Circle(50, 50, 100, Color.BLUE);
            circle.setVx(2);
            circle.setVy(1);

            CirclePanel panel = new CirclePanel(circle);
            frame.add(panel);

            new Animation(circle, panel);

            frame.setVisible(true);
        });
    }
}
