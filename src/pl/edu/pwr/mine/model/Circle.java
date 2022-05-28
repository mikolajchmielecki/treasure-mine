package pl.edu.pwr.mine.model;

import pl.edu.pwr.mine.geometry.Vector;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle {

    protected Color color;

    /**
     * Circle mid, x coordinate
     */
    protected double x;

    /**
     * Circle, y coordinate
     */

    protected double y;
    private int radius;

    protected int frameWidth;
    protected int frameHeight;

    protected Vector velocity;

    public Circle(Color color, double x, double y, int radial, double velosityX, double velosityY, int frameWidth, int frameHeight) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.radius = radial;
        velocity = new Vector(velosityX, velosityY);
        this.frameHeight = frameHeight;
        this.frameWidth = frameWidth;
    }

    public synchronized void go() {
        this.x += velocity.getX();
        this.y += velocity.getY();
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Ellipse2D.Double circle = new Ellipse2D.Double(x - radius, y - radius, 2 * radius, 2 * radius);

        g2d.setColor(color);
        g2d.fill(circle);
    }

    public int getRadius() {
        return radius;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return y;
    }
}
