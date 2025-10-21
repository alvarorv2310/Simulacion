package app;

import views.MainWindow;

import javax.swing.*;
import java.awt.*;

public class App {

    void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainWindow window = new MainWindow();
            window.showWindow();
        });
    }
}
