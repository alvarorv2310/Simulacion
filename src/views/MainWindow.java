package views;

import models.shapes.Circle;
import simulation.SimulationManager;

import javax.swing.*;
import java.awt.*;

public class MainWindow {
    private JFrame frame;
    private Circle circle;
    private CirclePanel circlePanel;
    private JPanel topPanel;
    private JTextField textFieldX;
    private JTextField textFieldY;
    private JLabel labelX;
    private JLabel labelY;
    private SimulationManager simulationManager;

    public MainWindow() {
        initUI();
    }

    private void initUI() {
        frame = new JFrame("Simulación 2D");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
        frame.setMinimumSize(new Dimension(900, 600));
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());

        labelX = new JLabel("Velocidad eje X:");
        textFieldX = new JTextField(5);
        textFieldX.setText("2");

        labelY = new JLabel("Velocidad eje Y:");
        textFieldY = new JTextField(5);
        textFieldY.setText("2");

        JButton updateButton = new JButton("Actualizar velocidad");
        updateButton.addActionListener(e -> {
            try {
                int vx = Integer.parseInt(textFieldX.getText());
                int vy = Integer.parseInt(textFieldY.getText());
                circle.setVx(vx);
                circle.setVy(vy);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Introduce números válidos");
            }
        });

        topPanel.add(labelX);
        topPanel.add(textFieldX);
        topPanel.add(labelY);
        topPanel.add(textFieldY);
        topPanel.add(updateButton);

        frame.add(topPanel, BorderLayout.NORTH);

        circle = new Circle(50, 50, 100, Color.BLUE);
        circle.setVx(Integer.parseInt(textFieldX.getText()));
        circle.setVy(Integer.parseInt(textFieldY.getText()));

        circlePanel = new CirclePanel(circle);
        circlePanel.setBackground(new Color(20, 20, 20));
        frame.add(circlePanel, BorderLayout.CENTER);

        simulationManager = new SimulationManager();
        simulationManager.addFigure(circle, circlePanel);
    }

    public void showWindow() {
        frame.setVisible(true);
        simulationManager.startAll();
    }
}
