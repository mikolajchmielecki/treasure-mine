
public class Geometry {
	
	static double odleglosc(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x1-x2 , 2) + Math.pow(y1-y2, 2));
	}
	
	static double odleglosc(double x, double y) {
		return odleglosc(x, y, 0, 0);
	}
}
