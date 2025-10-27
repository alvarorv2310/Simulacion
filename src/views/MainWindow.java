package views;

import javax.swing.*;
import java.awt.*;

public class MainWindow {
    private JFrame frame;
    private FigurePanel figurePanel;
    private final int firstWidth = 1000;
    private final int firstHeigth = 600;

    public int getFirstWidth() {
        return firstWidth;
    }

    public int getFirstHeigth() {
        return firstHeigth;
    }

    public MainWindow() {
        initUI();
    }

    private void initUI() {
        int minWidth = 900;
        int minHeigth = 500;
        frame = new JFrame("Simulación 2D");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(firstWidth, firstHeigth);
        frame.setMinimumSize(new Dimension(minWidth, minHeigth));
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        figurePanel = new FigurePanel(null);
        figurePanel.setBackground(new Color(20, 20, 20));
        frame.add(figurePanel, BorderLayout.CENTER);
    }

    public JFrame getFrame() { return frame; }
    public FigurePanel getFigurePanel() { return figurePanel; }

    public void showWindow() {
        frame.setVisible(true);
    }
}
