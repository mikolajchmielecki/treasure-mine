package pl.edu.pwr.mine.geometry;

public class GeometryUtil {
	
	public static double density(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x1-x2 , 2) + Math.pow(y1-y2, 2));
	}
	
	public static double density(double x, double y) {
		return density(x, y, 0, 0);
	}

}
