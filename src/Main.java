import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    private static final long czasOdswiezania = 10;
    private static final int frameWidth = 600;
    private static final int frameHeight = 500;

    public static void main(String[] args) {

        List<SkarbThread> skarbyThread = new ArrayList<>();
        List<PoszukiwaczThread> poszukiwaczeThread = new ArrayList<>();
        List<Kolo> kola = new ArrayList<>();
        List<Skarb> skarby = new ArrayList<>();
        Random random = new Random();

        Okienko1 frame = new Okienko1(kola, frameWidth, frameHeight);


        for (int i = 0; i < 3; i++) {
            skarbyThread.add(new SkarbThread(frame.getPanel(), czasOdswiezania, Color.RED, random.nextInt(frameWidth), random.nextInt(frameWidth), 15, 0, 0, frameWidth, frameHeight));

        }


        for (SkarbThread skarbThread : skarbyThread) {
            skarbThread.start();
            kola.add(skarbThread.getSkarb());
            skarby.add(skarbThread.getSkarb());
        }


        for (int i = 0; i < 5; i++) {
            poszukiwaczeThread.add(new PoszukiwaczThread(frame.getPanel(), czasOdswiezania, new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)), random.nextInt(frameWidth), random.nextInt(frameHeight), 10, 0, 0, frameWidth, frameHeight, skarby, random.nextDouble() * 7));

        }


        for (PoszukiwaczThread poszukiwaczThread : poszukiwaczeThread) {
            poszukiwaczThread.start();
            kola.add(poszukiwaczThread.getPoszukiwacz());

        }

    }
}
