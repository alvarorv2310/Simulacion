package app;

import views.MainWindow;
import controllers.MainController;

public class App {
    public static void main(String[] args) {
        MainWindow window = new MainWindow();
        new MainController(window);
        window.showWindow();
    }
}
