package pl.edu.pwr.mine.model;

import pl.edu.pwr.mine.geometry.GeometryUtil;
import pl.edu.pwr.mine.geometry.Vector;

import java.awt.*;
import java.util.List;

public class Miner extends Circle {

    private int points = 0;
    private List<Treasure> treasures;
    private Treasure pointedTreasure;
    private double speed;
    private boolean haveTarget;

    public Miner(Color color, double x, double y, int radius, double velocityX, double velocityY, int frameWidth,
                 int frameHeight, List<Treasure> treasures, double speed) {
        super(color, x, y, radius, velocityX, velocityY, frameWidth, frameHeight);
        this.treasures = treasures;
        this.speed = speed;
        haveTarget = false;
    }

    public void setSpeedToTreasure() {
        int maxDensity;
        boolean valid = false;

        if (frameWidth > frameHeight) {
            maxDensity = frameWidth;
        } else {
            maxDensity = frameHeight;
        }

        double minDensity = maxDensity;
        for (Treasure treasure : treasures) {
            if (treasure.getState()) {
                double odleglosc = GeometryUtil.density(x, y, treasure.getX(), treasure.getY());
                if (minDensity > odleglosc) {
                    minDensity = odleglosc;
                    pointedTreasure = treasure;
                }
                valid = true;
            }
        }
        if (valid) {
            calcVelocity();
        } else {
            velocity = velocity.multiplyScalar(0);
            haveTarget = false;
        }
    }

    public boolean getHaveTarget() {
        return haveTarget;
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.drawString(Integer.toString(points), (int) x - 3, (int) y + 3);
    }

    @Override
    public synchronized void go() {
        super.go();
        if (pointedTreasure != null) {
            if (pointedTreasure.getState()) {
                double density = GeometryUtil.density(x, y, pointedTreasure.getX(), pointedTreasure.getY());
                if (density < getRadius() + pointedTreasure.getRadius()) {

                    pointedTreasure.deactivateState(this);
                    pointedTreasure = null;
                    velocity = velocity.multiplyScalar(0);
                    haveTarget = false;
                }
            } else {
                pointedTreasure = null;
                velocity = velocity.multiplyScalar(0);
                haveTarget = false;
            }
        }
    }

    public void addPoint() {
        points++;
    }

    public void calcVelocity() {
        if (pointedTreasure != null) {
            velocity = new Vector(x, y, pointedTreasure.getX(), pointedTreasure.getY()).getNormalize().multiplyScalar(speed);
            haveTarget = true;
        }
    }
}
	
	
