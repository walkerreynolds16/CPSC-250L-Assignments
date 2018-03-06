package Lab04A;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.awt.Point;
import java.lang.reflect.Field;

import org.junit.Test;

public class QuadrilateralTest {

	@Test
	public void testReflection() {
		Class<?> iClass  = Quadrilateral.class;
		Field[]  iFields = iClass.getDeclaredFields();

		for (Field f : iFields) {
			if (!f.isSynthetic()) {
				fail( "Quadrilateral should'n have any fields: field \""+f.getName()+"\" detected" );
			}
		}
	}

	@Test
	public void testInheritsFromShape() {
		Point[] points    = new Point[] { 
				new Point( 0, 0 ), 
				new Point( 0, 0 ),
				new Point( 0, 0 ),
				new Point( 0, 0 ) 
		}; 
		Quadrilateral quadrilateral = new Quadrilateral( points );
		assertTrue( "Quadrilateral is not a subclass of Shape", quadrilateral instanceof Shape );
	}	
	
	@Test
	public void testGetName() {
		Point[] points    = new Point[] { 
				new Point( -2, -2 ), 
				new Point(  2, -2 ),
				new Point(  2,  2 ),
				new Point( -2,  2 ) 
		}; 
		Shape  quadrilateral = new Quadrilateral( points );
		String expected      = "Quadrilateral";
		String actual        = quadrilateral.getName();
		assertEquals( "Incorrect name", expected, actual );
	}
	
	@Test
	public void testGetPointsMoreThan4() {
		Point[] points    = new Point[] { 
				new Point(  5,  0 ), 
				new Point(  0,  5 ),
				new Point( -5,  0 ),
				new Point(  0, -5 ),
				new Point(  9,  9 ),
				new Point( -9, -9 ),
				new Point( -9,  9 ),
				new Point(  9, -9 )
		};
		Shape quadrilateral = new Quadrilateral( points );
		
		Point[]  expected = new Point[]{ 
				new Point(  5,  0 ), 
				new Point(  0,  5 ),
				new Point( -5,  0 ),
				new Point(  0, -5 )
		};
		Point[] actual    = quadrilateral.getPoints();
		assertEquals( expected.length, actual.length );
		assertEquals( expected[ 0 ], actual[ 0 ] );
		assertEquals( expected[ 1 ], actual[ 1 ] );
		assertEquals( expected[ 2 ], actual[ 2 ] );
		assertEquals( expected[ 3 ], actual[ 3 ] );
	}
	
	@Test
	public void testGetPerimeter() {
		Point[] points    = new Point[] { 
				new Point( -5,  0 ), 
				new Point(  0,  1 ),
				new Point(  2,  0 ),
				new Point( -1, -6 )
		};
		Shape   quadrilateral = new Quadrilateral( points );
		double  expected      = 21.25439397451992;
		double  actual        = quadrilateral.getPerimeter();
		assertEquals( "Incorrect perimeter", expected, actual, 0.0001 );
	}

}
