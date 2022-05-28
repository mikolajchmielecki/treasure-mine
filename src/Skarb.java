import java.awt.*;

public class Skarb extends Kolo {

    private boolean stan;
    private Color defaultKolor;

    public Skarb(Color kolor, double x, double y, int promien, double predkoscX, double predkoscY, int frameWidth,
                 int frameHeight, boolean stan) {
        super(kolor, x, y, promien, predkoscX, predkoscY, frameWidth, frameHeight);
        this.stan = stan;
        defaultKolor = kolor;
    }

    public synchronized void dezaktywujStan(Poszukiwacz poszukiwacz) {
        if (stan) {
            poszukiwacz.dodajPunkt();
        }
        this.stan = false;
        kolor = Color.BLACK;

    }

    public void aktywuj() {
        kolor = defaultKolor;
        stan = true;
    }

    public synchronized boolean getStan() {
        return stan;
    }

}
