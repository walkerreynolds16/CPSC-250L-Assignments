package Lab04A;

import java.awt.Point;

public class Triangle extends Shape{

	protected Triangle(Point[] points) {
		super("Triangle");
		
		Point[] tPoints = {points[0], points[1], points[2]};
		
		super.setPoints(tPoints);
		
	}

	@Override
	public double getPerimeter() {
		Point[] points = super.getPoints();
		
		double one = super.getDistance(points[0], points[1]);
		double two = super.getDistance(points[1], points[2]);
		double three = super.getDistance(points[2], points[0]);
		
		double perimeter = one + two + three;
		
		
		return perimeter;
	}

}
