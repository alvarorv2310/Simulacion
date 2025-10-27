package controllers;

import models.shapes.*;
import simulation.SimulationManager;
import views.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class MainController implements KeyListener {
    private final MainWindow view;
    private final SimulationManager simulationManager;
    private Figure currentFigure;
    private final Set<Integer> pressedKeys = new HashSet<>();
    private final Timer movementTimer;

    public MainController(MainWindow view) {
        this.view = view;
        this.simulationManager = new SimulationManager();

        movementTimer = new Timer(15, e -> moveFigureContinuously());
        initController();
    }

    private void initController() {
        currentFigure = new Circle(view.getFirstWidth()/2 - 50, view.getFirstHeigth()/2 - 50, 100, Color.BLUE);
        currentFigure.setVx(0);
        currentFigure.setVy(0);
        view.getFigurePanel().setFigure(currentFigure);
        simulationManager.addFigure(currentFigure, view.getFigurePanel());

        view.getFigurePanel().addKeyListener(this);
        view.getFigurePanel().setFocusable(true);
        view.getFigurePanel().requestFocusInWindow();

        simulationManager.startAll();
        movementTimer.start();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        pressedKeys.add(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressedKeys.remove(e.getKeyCode());
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    private void moveFigureContinuously() {
        if (currentFigure == null) return;

        int dx = 0, dy = 0;
        int step = 5;

        if (pressedKeys.contains(KeyEvent.VK_W)) dy -= step;
        if (pressedKeys.contains(KeyEvent.VK_S)) dy += step;
        if (pressedKeys.contains(KeyEvent.VK_A)) dx -= step;
        if (pressedKeys.contains(KeyEvent.VK_D)) dx += step;

        if (dx != 0 || dy != 0) {
            currentFigure.move(dx, dy);
            view.getFigurePanel().repaint();
        }
    }
}
