package views;

import models.shapes.*;
import simulation.SimulationManager;

import javax.swing.*;
import java.awt.*;

public class MainWindow {
    private JFrame frame;
    private Figure figure;
    private FigurePanel figurePanel;
    private JPanel topPanel;
    private JTextField textFieldX;
    private JTextField textFieldY;
    private JTextField textFieldSize1;
    private JTextField textFieldSize2;
    private JLabel labelX;
    private JLabel labelY;
    private JLabel labelSize1;
    private JLabel labelSize2;
    private JComboBox<String> comboBoxFigure;
    private SimulationManager simulationManager;

    public MainWindow() {
        initUI();
    }

    private void initUI() {
        frame = new JFrame("Simulación 2D");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.setMinimumSize(new Dimension(900, 500));
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        topPanel = new JPanel(new FlowLayout());

        labelX = new JLabel("Velocidad X:");
        textFieldX = new JTextField(5);
        textFieldX.setText("2");

        labelY = new JLabel("Velocidad Y:");
        textFieldY = new JTextField(5);
        textFieldY.setText("2");

        labelSize1 = new JLabel("Size");
        textFieldSize1 = new JTextField(5);
        textFieldSize1.setText("100");

        labelSize2 = new JLabel("Height");
        textFieldSize2 = new JTextField(5);
        textFieldSize2.setText("100");

        comboBoxFigure = new JComboBox<>(new String[]{"Circle", "Triangle", "Square", "EquilateralTriangle"});
        comboBoxFigure.addActionListener(e -> updateSizeFields());

        JButton updateButton = new JButton("Actualizar");
        updateButton.addActionListener(e -> updateFigure());

        topPanel.add(labelX);
        topPanel.add(textFieldX);
        topPanel.add(labelY);
        topPanel.add(textFieldY);
        topPanel.add(labelSize1);
        topPanel.add(textFieldSize1);
        topPanel.add(labelSize2);
        topPanel.add(textFieldSize2);
        topPanel.add(comboBoxFigure);
        topPanel.add(updateButton);

        frame.add(topPanel, BorderLayout.NORTH);

        figure = new Circle(50, 50, 100, Color.BLUE);
        figure.setVx(Integer.parseInt(textFieldX.getText()));
        figure.setVy(Integer.parseInt(textFieldY.getText()));

        figurePanel = new FigurePanel(figure);
        figurePanel.setBackground(new Color(20, 20, 20));
        frame.add(figurePanel, BorderLayout.CENTER);

        simulationManager = new SimulationManager();
        simulationManager.addFigure(figure, figurePanel);

        updateSizeFields();
    }

    private void updateSizeFields() {
        String selected = (String) comboBoxFigure.getSelectedItem();
        if ("Triangle".equals(selected)) {
            labelSize2.setVisible(true);
            labelSize1.setText("Widht");
            textFieldSize2.setVisible(true);
        } else {
            labelSize2.setVisible(false);
            textFieldSize2.setVisible(false);
        }
        topPanel.revalidate();
        topPanel.repaint();
    }

    private void updateFigure() {
        String selected = (String) comboBoxFigure.getSelectedItem();
        int size1, size2;
        try {
            size1 = Integer.parseInt(textFieldSize1.getText());
            size2 = Integer.parseInt(textFieldSize2.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Introduce tamaños válidos");
            return;
        }

        switch (selected) {
            case "Circle" -> figure = new Circle(50, 50, size1, Color.BLUE);
            case "Triangle" -> figure = new Triangle(50, 50, size1, size2, Color.RED);
            case "Square" -> figure = new Square(50, 50, size1, Color.GREEN);
            case "EquilateralTriangle" -> figure = new EquilateralTriangle(50, 50, size1, Color.PINK);
        }

        try {
            int vx = Integer.parseInt(textFieldX.getText());
            int vy = Integer.parseInt(textFieldY.getText());
            figure.setVx(vx);
            figure.setVy(vy);
        } catch (NumberFormatException ignored) {}

        figurePanel.setFigure(figure);
        figurePanel.repaint();
        simulationManager.addFigure(figure, figurePanel);
    }

    public void showWindow() {
        frame.setVisible(true);
        simulationManager.startAll();
    }
}
