package pl.edu.pwr.mine.model;

import java.awt.*;

public class Treasure extends Circle {

    private boolean state;
    private Color defaultColor;

    public Treasure(Color color, double x, double y, int radius, double velocityX, double velocityY, int frameWidth,
                    int frameHeight, boolean state) {
        super(color, x, y, radius, velocityX, velocityY, frameWidth, frameHeight);
        this.state = state;
        defaultColor = color;
    }

    public synchronized void deactivateState(Miner miner) {
        if (state) {
            miner.addPoint();
        }
        this.state = false;
        color = Color.BLACK;

    }

    public void activate() {
        color = defaultColor;
        state = true;
    }

    public synchronized boolean getState() {
        return state;
    }

}
