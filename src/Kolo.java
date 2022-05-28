import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;


public class Kolo {
    protected Color kolor;

    /**
     * Œrodek ko³a, pozycja x
     */
    protected double x;

    /**
     * Œrodek ko³a, pozycja y
     */
    protected double y;
    private int promien;

    protected int frameWidth;
    protected int frameHeight;


    private double predkoscX;
    private double predkoscY;
    protected Wektor predkosc;

    private List<Kolo> odbijaneKola = new ArrayList<>();


    public Kolo(Color kolor, double x, double y, int promien, double predkoscX, double predkoscY, int frameWidth, int frameHeight) {
        this.kolor = kolor;
        this.x = x;
        this.y = y;
        this.promien = promien;
        this.predkoscX = predkoscX;
        this.predkoscY = predkoscY;
        predkosc = new Wektor(predkoscX, predkoscY);
        this.frameHeight = frameHeight;
        this.frameWidth = frameWidth;
    }

    public synchronized void rusz(List<KoloThread> kolaThread) {

        this.x += predkosc.x;
        this.y += predkosc.y;
        if (kolaThread != null) {
            sprawdzOdbicie(kolaThread);
        }

    }

    public void rysuj(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Ellipse2D.Double circle = new Ellipse2D.Double(x - promien, y - promien, 2 * promien, 2 * promien);

        g2d.setColor(kolor);
        g2d.fill(circle);
    }

    public Rectangle getRectangle() {
        return new Rectangle((int) x - promien - 1, (int) y - promien - 1, 2 * promien + 2, 2 * promien + 2);
    }


    public void sprawdzOdbicie(List<KoloThread> kolaThread) {
        if ((x - promien < 0 && predkosc.x < 0) || (x + promien > frameWidth && predkosc.x > 0)) {
            predkosc.x = -predkosc.x;
        }

        if ((y - promien < 0 && predkosc.y < 0) || (y + promien > frameHeight && predkosc.y > 0)) {
            predkosc.y = -predkosc.y;
        }

        synchronized (kolaThread) {
            for (KoloThread koloThread : kolaThread) {
                Kolo kolo = koloThread.getKolo();
                if (kolo != this) {
                    if (kolo.getPromien() + promien > Geometry.odleglosc(x, y, kolo.getX(), kolo.getY())) {
                        odbij();
                        kolo.odbij();
                        while (kolo.getPromien() + promien > Geometry.odleglosc(x, y, kolo.getX(), kolo.getY())) {
                            this.x += predkosc.x;
                            this.y += predkosc.y;
                        }
                    }
                }
            }
        }
    }

    public void odbij() {
        predkosc = predkosc.pomnozSkalar(-1);
    }

    public int getPromien() {
        return promien;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void addOdbijaneKolo(Kolo kolo) {
        odbijaneKola.add(kolo);
    }

}
