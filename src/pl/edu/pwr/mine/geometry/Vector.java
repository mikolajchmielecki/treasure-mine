package pl.edu.pwr.mine.geometry;

public class Vector {

    double y;
    double x;

    public Vector(double x1, double y1, double x2, double y2) {
        x = x2 - x1;
        y = y2 - y1;
    }

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector getNormalize() {
        return new Vector(x / GeometryUtil.density(x, y), y / GeometryUtil.density(x, y));
    }

    public Vector multiplyScalar(double number) {
        return new Vector(x * number, y * number);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
	