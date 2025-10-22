package controllers;

import models.shapes.*;
import simulation.SimulationManager;
import views.MainWindow;

import javax.swing.*;
import java.awt.*;

public class MainController {
    private MainWindow view;
    private SimulationManager simulationManager;
    private Figure currentFigure;

    public MainController(MainWindow view) {
        this.view = view;
        this.simulationManager = new SimulationManager();
        initController();
    }

    private void initController() {
        view.getComboBoxFigure().addActionListener(e -> updateSizeFields());
        view.getUpdateButton().addActionListener(e -> updateFigure());

        currentFigure = new Circle(50, 50, 100, Color.BLUE);
        currentFigure.setVx(Integer.parseInt(view.getTextFieldX().getText()));
        currentFigure.setVy(Integer.parseInt(view.getTextFieldY().getText()));
        view.getFigurePanel().setFigure(currentFigure);
        simulationManager.addFigure(currentFigure, view.getFigurePanel());

        updateSizeFields();
        simulationManager.startAll();
    }

    private void updateSizeFields() {
        String selected = (String) view.getComboBoxFigure().getSelectedItem();
        if ("Triangle".equals(selected)) {
            view.getLabelSize2().setVisible(true);
            view.getLabelSize1().setText("Width");
            view.getTextFieldSize2().setVisible(true);
        } else {
            view.getLabelSize2().setVisible(false);
            view.getTextFieldSize2().setVisible(false);
            view.getLabelSize1().setText("Size");
        }
        view.getFrame().revalidate();
        view.getFrame().repaint();
    }

    private void updateFigure() {
        String selected = (String) view.getComboBoxFigure().getSelectedItem();
        int size1, size2;

        try {
            size1 = Integer.parseInt(view.getTextFieldSize1().getText());
            size2 = Integer.parseInt(view.getTextFieldSize2().getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view.getFrame(), "Introduce tamaños válidos");
            return;
        }

        switch (selected) {
            case "Circle" -> currentFigure = new Circle(50, 50, size1, Color.BLUE);
            case "Triangle" -> currentFigure = new Triangle(50, 50, size1, size2, Color.RED);
            case "Square" -> currentFigure = new Square(50, 50, size1, Color.GREEN);
            case "EquilateralTriangle" -> currentFigure = new EquilateralTriangle(50, 50, size1, Color.PINK);
        }

        try {
            int vx = Integer.parseInt(view.getTextFieldX().getText());
            int vy = Integer.parseInt(view.getTextFieldY().getText());
            currentFigure.setVx(vx);
            currentFigure.setVy(vy);
        } catch (NumberFormatException ignored) {}

        view.getFigurePanel().setFigure(currentFigure);
        view.getFigurePanel().repaint();
        simulationManager.addFigure(currentFigure, view.getFigurePanel());
    }
}
