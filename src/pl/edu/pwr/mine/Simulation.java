package pl.edu.pwr.mine;

import pl.edu.pwr.mine.model.Circle;
import pl.edu.pwr.mine.model.Treasure;
import pl.edu.pwr.mine.thread.MinerThread;
import pl.edu.pwr.mine.thread.TreasureThread;
import pl.edu.pwr.mine.view.MainWindow;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Simulation {

    private static final long REFRESH_TIME = 10;
    private static final int FRAME_WIDTH = 600;
    private static final int FRAME_HEIGHT = 500;

    private List<TreasureThread> treasureThreads = new ArrayList<>();
    private List<MinerThread> minerThreads = new ArrayList<>();
    private List<Circle> circles = new ArrayList<>();
    private List<Treasure> treasures = new ArrayList<>();
    private Random random = new Random();

    public Simulation(int treasuresNumber, int minersNumber) {

        MainWindow window = new MainWindow(circles, FRAME_WIDTH, FRAME_HEIGHT);

        for (int i = 0; i < treasuresNumber; i++) {
            treasureThreads.add(new TreasureThread(window.getPanel(), REFRESH_TIME, Color.RED,
                    random.nextInt(FRAME_WIDTH), random.nextInt(FRAME_WIDTH), 15, 0, 0,
                    FRAME_WIDTH, FRAME_HEIGHT));
        }

        for (int i = 0; i < minersNumber; i++) {
            minerThreads.add(new MinerThread(window.getPanel(), REFRESH_TIME, new Color(random.nextInt(255),
                    random.nextInt(255), random.nextInt(255)), random.nextInt(FRAME_WIDTH),
                    random.nextInt(FRAME_HEIGHT), 10, 0, 0, FRAME_WIDTH, FRAME_HEIGHT, treasures,
                    random.nextDouble() * 7));

        }
    }

    public void run() {
        treasureThreads.forEach(t -> circles.add(t.getTreasure()));
        treasureThreads.forEach(t -> treasures.add(t.getTreasure()));

        minerThreads.forEach(m -> m.start());
        minerThreads.forEach(m -> circles.add(m.getMiner()));
    }
}
