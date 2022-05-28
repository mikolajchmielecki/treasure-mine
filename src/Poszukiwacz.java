import java.awt.*;
import java.util.List;

public class Poszukiwacz extends Kolo {

    private int punkty = 0;
    private List<Skarb> skarby;
    private Skarb celowanySkarb;
    private double szybkosc;
    private boolean maCel;

    public Poszukiwacz(Color kolor, double x, double y, int promien, double predkoscX, double predkoscY, int frameWidth,
                       int frameHeight, List<Skarb> skarby, double szybkosc2) {
        super(kolor, x, y, promien, predkoscX, predkoscY, frameWidth, frameHeight);
        this.skarby = skarby;
        this.szybkosc = szybkosc2;
        maCel = false;
    }

    public void setPredkoscToSkarb() {
        int maxOdleglosc;
        boolean valid = false;

        if (frameWidth > frameHeight) {
            maxOdleglosc = frameWidth;
        } else {
            maxOdleglosc = frameHeight;
        }

        double minOdleglosc = maxOdleglosc;
        for (Skarb skarb : skarby) {
            if (skarb.getStan()) {
                double odleglosc = Geometry.odleglosc(x, y, skarb.getX(), skarb.getY());
                if (minOdleglosc > odleglosc) {
                    minOdleglosc = odleglosc;
                    celowanySkarb = skarb;
                }
                valid = true;
            }
        }
        if (valid) {
            nastawPredkosc();
        } else {
            predkosc = predkosc.pomnozSkalar(0);
            maCel = false;
        }
    }

    public boolean getMaCel() {
        return maCel;
    }

    @Override
    public void rysuj(Graphics g) {
        super.rysuj(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.drawString(Integer.toString(punkty), (int) x - 3, (int) y + 3);
    }

    @Override
    public synchronized void rusz(List<KoloThread> kolaThread) {
        super.rusz(kolaThread);
        if (celowanySkarb != null) {
            if (celowanySkarb.getStan()) {
                double odleglosc = Geometry.odleglosc(x, y, celowanySkarb.getX(), celowanySkarb.getY());
                if (odleglosc < getPromien() + celowanySkarb.getPromien()) {

                    celowanySkarb.dezaktywujStan(this);
                    celowanySkarb = null;
                    predkosc = predkosc.pomnozSkalar(0);
                    maCel = false;
                }
            } else {
                celowanySkarb = null;
                predkosc = predkosc.pomnozSkalar(0);
                maCel = false;
            }
        }
    }

    public void dodajPunkt() {
        punkty++;
        System.out.println("Poszukiwacz:" + kolor + " Punkty:" + punkty);
    }

    public void nastawPredkosc() {
        if (celowanySkarb != null) {
            predkosc = new Wektor(x, y, celowanySkarb.getX(), celowanySkarb.getY()).getUnormowany().pomnozSkalar(szybkosc);
            maCel = true;
        }
    }
}
	
	
