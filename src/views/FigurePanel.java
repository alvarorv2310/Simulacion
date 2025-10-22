package views;

import models.shapes.Figure;
import javax.swing.*;
import java.awt.*;

public class FigurePanel extends JPanel {
    private Figure figure;

    public FigurePanel(Figure figure) {
        this.figure = figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (figure != null) {
            figure.draw(g);
        }
    }
}
