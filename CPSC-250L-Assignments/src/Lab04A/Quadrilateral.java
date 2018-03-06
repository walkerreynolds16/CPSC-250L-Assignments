package Lab04A;

import java.awt.Point;

public class Quadrilateral extends Shape{

	protected Quadrilateral(Point[] points) {
		super("Quadrilateral");
		
		Point[] qPoints = {points[0], points[1], points[2], points[3]};
		super.setPoints(qPoints);
		
	}

	@Override
	public double getPerimeter() {
		Point[] points = super.getPoints();
		
		double one = super.getDistance(points[0], points[1]);
		double two = super.getDistance(points[1], points[2]);
		double three = super.getDistance(points[2], points[3]);
		double four = super.getDistance(points[3], points[0]);
		
		double perimeter = one + two + three + four;
		
		
		return perimeter;
	}

}
