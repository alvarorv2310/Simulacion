package models.shapes;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Figure {
    protected int x, y;
    protected int width, height;
    protected Color color;
    protected int vx, vy;

    public Figure(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.vx = 0;
        this.vy = 0;
    }

    public abstract void draw(Graphics g);

    public int getX() { return x; }
    public void setX(int x) { this.x = x; }

    public int getY() { return y; }
    public void setY(int y) { this.y = y; }

    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width; }

    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }

    public Color getColor() { return color; }
    public void setColor(Color color) { this.color = color; }

    public int getVx() { return vx; }
    public void setVx(int vx) { this.vx = vx; }

    public int getVy() { return vy; }
    public void setVy(int vy) { this.vy = vy; }
}
