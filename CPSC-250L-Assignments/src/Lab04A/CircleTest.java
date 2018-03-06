package Lab04A;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class CircleTest {

	@Test
	public void testReflection() {
		Class<?> iClass  = Circle.class;
		Field[]  iFields = iClass.getDeclaredFields();

		int count = 0;
		for (Field f : iFields) {
			if (!f.isSynthetic()) {
				count++;
				assertTrue ( "Field \""+f.getName()+"\" should be private", Modifier.isPrivate( f.getModifiers() ));
				assertFalse( "Field \""+f.getName()+"\" can't be static",   Modifier.isStatic ( f.getModifiers() ));
			}
		}
		assertEquals( "Class should have only one field", 1, count );
	}

	@Test
	public void testInheritsFromShape() {
		Point  center   = new Point( 0, 0 );
		Circle circle   = new Circle( center, 1.0 );
		
		assertTrue( "Circle doesn't subclass from Shape", circle instanceof Shape );
	}

	@Test
	public void testGetPoint() {
		Point   center   = new Point( 4, 2 );
		Shape   circle   = new Circle( center, 3.0 );
		Point   expected = new Point( 4, 2 );

		Point[] actual   = circle.getPoints();
		assertEquals( "Incorrect number of points", 1,        actual.length );
		assertEquals( "Incorrect point",            expected, actual[ 0 ] );
	}

	@Test
	public void testGetName() {
		Point  center   = new Point( 0, 0 );
		Shape  circle   = new Circle( center, 1.0 );

		String expected = "Circle";
		String actual   = circle.getName();
		assertEquals( "Incorrect name", expected, actual );
	}
	
	@Test
	public void testGetPerimeterWithZeroRadius() {
		Point  center   = new Point( 4, 4 );
		Shape  circle   = new Circle( center, 0.0 );
		
		double expected = 0.0;
		double actual   = circle.getPerimeter();
		assertEquals( "Incorrect radius", expected, actual, 0.0001 );
	}
	@Test
	public void testGetPerimeter() {
		Point  center   = new Point( 3, 3 );
		Shape  circle   = new Circle( center, 4.0 );
		
		double expected = 25.132741228718345;
		double actual   = circle.getPerimeter();
		assertEquals( "Incorrect perimeter", expected, actual, 0.0001 );
	}
	
	@Test
	public void testGetRadiusPositive() {
		Point  center   = new Point( 2, 2 );
		Circle circle   = new Circle( center, 3.3333 );
		
		double expected = 3.3333;
		double actual   = circle.getRadius();
		assertEquals( "Incorrect radius", expected, actual, 0.0001 );
	}
	@Test
	public void testGetRadiusNegative() {
		Point  center   = new Point( 2, 2 );
		Circle circle   = new Circle( center, -3.0 );
		
		double expected = 0;
		double actual   = circle.getRadius();
		assertEquals( "Incorrect radius", expected, actual, 0.0001 );
	}

}
