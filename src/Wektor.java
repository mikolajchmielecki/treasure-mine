
public class Wektor {
    double y;
    double x;

    Wektor(double x1, double y1, double x2, double y2) {
        x = x2 - x1;
        y = y2 - y1;
    }

    Wektor(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Wektor getUnormowany() {
        return new Wektor(x / Geometry.odleglosc(x, y), y / Geometry.odleglosc(x, y));
    }

    public Wektor getProstopadly() {
        return new Wektor(-y, -x);
    }

    public double iloczynSkalarny(Wektor wektor) {
        return x * wektor.x + y * wektor.y;
    }

    public Wektor pomnozSkalar(double liczba) {
        return new Wektor(x * liczba, y * liczba);
    }

    public Wektor getRzut(Wektor wektor) {
        return wektor.pomnozSkalar(this.iloczynSkalarny(wektor));
    }

    public static Wektor suma(Wektor wektor1, Wektor wektor2) {
        return new Wektor(wektor1.x + wektor2.x, wektor1.y + wektor2.y);
    }
}
	