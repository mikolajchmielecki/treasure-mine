package pl.edu.pwr.mine.thread;

import pl.edu.pwr.mine.model.Treasure;
import pl.edu.pwr.mine.view.CirclesPanel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TreasureThread extends Thread {

    private Treasure treasure;

    private long refreshTime;
    private CirclesPanel panel;

    private static List<TreasureThread> treasureThread = new ArrayList<>();

    private Random random = new Random();
    int frameWidth;
    int frameHeight;

    public TreasureThread(CirclesPanel panel, long refreshTime, Color color, double x, double y, int radius, double velocityX, double velocityY, int frameWidth, int frameHeight) {
        super();
        this.refreshTime = refreshTime;
        this.panel = panel;
        this.frameHeight = frameHeight;
        this.frameWidth = frameWidth;
        treasure = new Treasure(color, x, y, radius, velocityX, velocityY, frameWidth, frameHeight, true);
        treasureThread.add(this);
    }

    @Override
    public void run() {
        while (true) {
            panel.repaint();
            try {
                sleep(refreshTime);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            if (!treasure.getState()) {
                try {
                    sleep(1);
                    treasure.activate();
                    treasure.setX(random.nextInt(frameWidth));
                    treasure.setY(random.nextInt(frameHeight));
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    public Treasure getTreasure() {
        return treasure;
    }

}
