import java.awt.*;
import java.util.List;

public class PoszukiwaczThread extends Thread {

    private Poszukiwacz poszukiwacz;

    private long czasOdswiezania;
    private Panel1 panel;


    public PoszukiwaczThread(Panel1 panel, long czasOdswiezania, Color kolor, double x, double y, int promien, double predkoscX, double predkoscY, int frameWidth, int frameHeight, List<Skarb> skarby, double szybkosc) {
        super();
        this.czasOdswiezania = czasOdswiezania;
        this.panel = panel;
        poszukiwacz = new Poszukiwacz(kolor, x, y, promien, predkoscX, predkoscY, frameWidth, frameHeight, skarby, szybkosc);

    }

    @Override
    public void run() {
        while (true) {
            panel.repaint();
            poszukiwacz.nastawPredkosc();
            if (!poszukiwacz.getMaCel()) {
                poszukiwacz.setPredkoscToSkarb();
            }
            poszukiwacz.rusz(null);
            //panel.repaint(kolo.getRectangle());
            try {
                sleep(czasOdswiezania);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }


    public Poszukiwacz getPoszukiwacz() {
        return poszukiwacz;
    }
}