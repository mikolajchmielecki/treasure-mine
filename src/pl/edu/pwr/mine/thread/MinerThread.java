package pl.edu.pwr.mine.thread;

import pl.edu.pwr.mine.model.Miner;
import pl.edu.pwr.mine.model.Treasure;
import pl.edu.pwr.mine.view.CirclesPanel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MinerThread extends Thread {

    private Miner miner;

    private long refreshTime;
    private CirclesPanel panel;

    public MinerThread(CirclesPanel panel, long refreshTime, Color color, double x, double y, int radius, double velocityX, double velocityY, int frameWidth, int frameHeight, List<Treasure> treasures, double speed) {
        super();
        this.refreshTime = refreshTime;
        this.panel = panel;
        miner = new Miner(color, x, y, radius, velocityX, velocityY, frameWidth, frameHeight, treasures, speed);

    }

    @Override
    public void run() {
        while (true) {
            panel.repaint();
            miner.calcVelocity();
            if (!miner.getHaveTarget()) {
                miner.setSpeedToTreasure();
            }
            miner.go();
            try {
                sleep(refreshTime);
            } catch (InterruptedException e) {
                JOptionPane.showMessageDialog(panel,
                        e.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public Miner getMiner() {
        return miner;
    }
}