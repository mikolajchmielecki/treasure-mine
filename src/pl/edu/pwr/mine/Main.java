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

public class Main {

    private static final long REFRESH_TIME = 10;
    private static final int FRAME_WIDTH = 600;
    private static final int FRAME_HEIGHT = 500;

    public static void main(String[] args) {

        List<TreasureThread> skarbyThread = new ArrayList<>();
        List<MinerThread> poszukiwaczeThread = new ArrayList<>();
        List<Circle> kola = new ArrayList<>();
        List<Treasure> skarby = new ArrayList<>();
        Random random = new Random();

        MainWindow frame = new MainWindow(kola, FRAME_WIDTH, FRAME_HEIGHT);


        for (int i = 0; i < 3; i++) {
            skarbyThread.add(new TreasureThread(frame.getPanel(), REFRESH_TIME, Color.RED, random.nextInt(FRAME_WIDTH), random.nextInt(FRAME_WIDTH), 15, 0, 0, FRAME_WIDTH, FRAME_HEIGHT));

        }


        for (TreasureThread treasureThread : skarbyThread) {
            treasureThread.start();
            kola.add(treasureThread.getTreasure());
            skarby.add(treasureThread.getTreasure());
        }


        for (int i = 0; i < 5; i++) {
            poszukiwaczeThread.add(new MinerThread(frame.getPanel(), REFRESH_TIME, new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)), random.nextInt(FRAME_WIDTH), random.nextInt(FRAME_HEIGHT), 10, 0, 0, FRAME_WIDTH, FRAME_HEIGHT, skarby, random.nextDouble() * 7));

        }


        for (MinerThread minerThread : poszukiwaczeThread) {
            minerThread.start();
            kola.add(minerThread.getMiner());

        }

    }
}
