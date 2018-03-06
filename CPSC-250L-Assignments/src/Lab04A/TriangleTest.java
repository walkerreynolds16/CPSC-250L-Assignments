package Lab04A;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.awt.Point;
import java.lang.reflect.Field;

import org.junit.Test;

public class TriangleTest {

	@Test
	public void testReflection() {
		Class<?> iClass  = Triangle.class;
		Field[]  iFields = iClass.getDeclaredFields();

		for (Field f : iFields) {
			if (!f.isSynthetic()) {
				fail( "Triangle should'n have any fields: field \""+f.getName()+"\" detected" );
			}
		}
	}

	@Test
	public void testInheritsFromShape() {
		Point[] points   = new Point[] { 
				new Point( 0, 0 ), 
                new Point( 0, 0 ),
                new Point( 0, 0 ) 
		}; 
		Triangle triangle = new Triangle( points );
		assertTrue( "Triangle does not subclass from Shape", triangle instanceof Shape );
	}

	@Test
	public void testGetName() {
		Point[] points   = new Point[] { 
				new Point( -1, -3 ), 
                new Point(  3,  2 ),
                new Point(  7, -2 ) 
		}; 
		Shape   triangle = new Triangle( points );
		String  expected = "Triangle";
		String  actual   = triangle.getName();
		assertEquals( "Incorrect name", expected, actual );
	}

	@Test
	public void testGetPointsMoreThan3() {
		Point[] points    = new Point[] { 
				new Point( 1, 1 ), 
				new Point( 5, 1 ),
				new Point( 3, 3 ), 
				new Point( 9, 9 ),
				new Point( 8, 8 )
		};
		Shape   triangle = new Triangle( points );
		Point[] expected = new Point[]{ 
				new Point( 1, 1 ), 
				new Point( 5, 1 ),
				new Point( 3, 3 )
		};
		Point[] actual    = triangle.getPoints();
		assertEquals( "Incorrect number of points", expected.length, actual.length );
		assertEquals( "Incorrect point",            expected[ 0 ],   actual[ 0 ] );
		assertEquals( "Incorrect point",            expected[ 1 ],   actual[ 1 ] );
		assertEquals( "Incorrect point",            expected[ 2 ],   actual[ 2 ] );
	}

	@Test
	public void testGetPerimeterWithOnePoint() {
		Point[] points    = new Point[] { 
				new Point( 1, 1 ), 
                new Point( 1, 1 ),
                new Point( 1, 1 )
		};
		Shape  triangle = new Triangle( points );
		double expected = 0.0;
		double actual   = triangle.getPerimeter();
		assertEquals( "Incorrect perimeter", expected, actual, 0.0001 );
	}

	@Test
	public void testGetPerimeter() {
		Point[] points    = new Point[] { 
				new Point( -1, -3 ), 
                new Point(  3,  2 ),
                new Point(  7, -2 )
		};
		Shape   triangle = new Triangle( points );
		double  expected = 20.122236235223777;
		double  actual   = triangle.getPerimeter();
		assertEquals( "Incorrect perimeter", expected, actual, 0.0001 );
	}

}
