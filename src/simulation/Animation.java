package simulation;

import models.shapes.Figure;
import javax.swing.*;
import java.awt.Dimension;

public class Animation {
    private Figure figure;
    private javax.swing.JPanel panel;
    private Timer timer;

    public Animation(Figure figure, JPanel panel) {
        this.figure = figure;
        this.panel = panel;
        timer = new Timer(16, e -> update());
        timer.start();
    }

    private void update() {
        int newX = figure.getX() + figure.getVx();
        int newY = figure.getY() + figure.getVy();

        Dimension size = panel.getSize();

        if (newX < 0) {
            newX = 0;
            figure.setVx(-figure.getVx());
        } else if (newX + figure.getWidth() > size.width) {
            newX = size.width - figure.getWidth();
            figure.setVx(-figure.getVx());
        }

        if (newY < 0) {
            newY = 0;
            figure.setVy(-figure.getVy());
        } else if (newY + figure.getHeight() > size.height) {
            newY = size.height - figure.getHeight();
            figure.setVy(-figure.getVy());
        }

        figure.setX(newX);
        figure.setY(newY);

        panel.repaint();
    }

    public void stop() {
        timer.stop();
    }

    public void start() {
        timer.start();
    }
}

