import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class KoloThread extends Thread {

    private Kolo kolo;

    private long czasOdswiezania;
    private Panel panel;

    private static List<KoloThread> kolaThread = new ArrayList<>();

    public KoloThread(Panel panel, long czasOdswiezania, Color kolor, double x, double y, int promien, double predkoscX, double predkoscY, int frameWidth, int frameHeight) {
        super();
        this.czasOdswiezania = czasOdswiezania;
        this.panel = panel;
        kolo = new Kolo(kolor, x, y, promien, predkoscX, predkoscY, frameWidth, frameHeight);
        kolaThread.add(this);
    }

    @Override
    public void run() {
        while (true) {
            kolo.rusz(kolaThread);
            panel.repaint();
            try {
                sleep(czasOdswiezania);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }


    public Kolo getKolo() {
        return kolo;
    }
}
