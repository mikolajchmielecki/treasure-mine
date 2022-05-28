import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SkarbThread extends Thread {

    private Skarb skarb;

    private long czasOdswiezania;
    private Panel1 panel;

    private static List<SkarbThread> skarbThread = new ArrayList<>();

    private Random random = new Random();
    int frameWidth;
    int frameHeight;

    public SkarbThread(Panel1 panel, long czasOdswiezania, Color kolor, double x, double y, int promien, double predkoscX, double predkoscY, int frameWidth, int frameHeight) {
        super();
        this.czasOdswiezania = czasOdswiezania;
        this.panel = panel;
        this.frameHeight = frameHeight;
        this.frameWidth = frameWidth;
        skarb = new Skarb(kolor, x, y, promien, predkoscX, predkoscY, frameWidth, frameHeight, true);
        skarbThread.add(this);
    }

    @Override
    public void run() {
        while (true) {
            panel.repaint();
            try {
                sleep(czasOdswiezania);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            if (!skarb.getStan()) {
                try {
                    sleep(1);
                    skarb.aktywuj();
                    skarb.x = random.nextInt(frameWidth);
                    skarb.y = random.nextInt(frameHeight);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }


    public Skarb getSkarb() {
        return skarb;
    }
}
