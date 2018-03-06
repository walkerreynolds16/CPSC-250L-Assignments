package Lab04A;

import java.awt.Point;

public class Circle extends Shape{

	private double radius;
	
	protected Circle(Point center, double radius) {
		super("Circle");
		Point[] points = {center};
		super.setPoints(points);
		
		
		if(radius < 0){
			radius = 0;
		}
		
		this.radius = radius;
	}

	@Override
	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}
	
	
	public double getRadius(){
		return radius;
	}

}
