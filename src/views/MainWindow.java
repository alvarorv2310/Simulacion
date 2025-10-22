package views;

import models.shapes.Figure;

import javax.swing.*;
import java.awt.*;

public class MainWindow {
    private JFrame frame;
    private FigurePanel figurePanel;
    private JPanel topPanel;
    private JTextField textFieldX, textFieldY, textFieldSize1, textFieldSize2;
    private JLabel labelX, labelY, labelSize1, labelSize2;
    private JComboBox<String> comboBoxFigure;
    private JButton updateButton;

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

        updateButton = new JButton("Actualizar");

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

        figurePanel = new FigurePanel(null);
        figurePanel.setBackground(new Color(20, 20, 20));
        frame.add(figurePanel, BorderLayout.CENTER);
    }

    public JFrame getFrame() { return frame; }
    public FigurePanel getFigurePanel() { return figurePanel; }
    public JTextField getTextFieldX() { return textFieldX; }
    public JTextField getTextFieldY() { return textFieldY; }
    public JTextField getTextFieldSize1() { return textFieldSize1; }
    public JTextField getTextFieldSize2() { return textFieldSize2; }
    public JLabel getLabelSize1() { return labelSize1; }
    public JLabel getLabelSize2() { return labelSize2; }
    public JComboBox<String> getComboBoxFigure() { return comboBoxFigure; }
    public JButton getUpdateButton() { return updateButton; }

    public void showWindow() {
        frame.setVisible(true);
    }
}
