package controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import models.shapes.Figure;
import views.FigurePanel;

public class FigureController {
    private Figure figure;
    private FigurePanel panel;

    public FigureController(Figure figure, FigurePanel panel) {
        this.figure = figure;
        this.panel = panel;

        panel.setFocusable(true);
    }
}
