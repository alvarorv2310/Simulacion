import javax.swing.*;
import java.awt.*;

public class Main extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Cambiamos a Graphics2D para más opciones
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLUE); // color del círculo
        g2d.fillOval(50, 50, 100, 100); // x, y, ancho, alto
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Dibujar Círculo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.add(new Main());
        frame.setVisible(true);
    }
}
