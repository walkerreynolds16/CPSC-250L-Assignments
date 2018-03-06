package Lab04A;

import java.awt.Point;

public abstract class Shape {
	private String  name;
	private Point[] points;
	
	protected Shape(String aName) {
		name = aName;
	}
	
	public final String getName() {
		return name;
	}

	protected final void setPoints(Point[] thePoints) {
		points = thePoints;
	}
	
	public final Point[] getPoints() {
		return points;
	}
	
	public abstract double getPerimeter();
	
	public static double getDistance(Point one, Point two) {
		double absOne =  Math.abs(one.getX() - two.getX());
		double absTwo =  Math.abs(one.getY() - two.getY());
		
		double oneSqrd =  Math.pow(absOne, 2);
		double twoSqrd =  Math.pow(absTwo, 2);
		
		double dis = Math.sqrt(oneSqrd + twoSqrd);
		
		return dis;
	}
}
