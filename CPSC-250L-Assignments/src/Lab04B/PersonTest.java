package Lab04B;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersonTest {

	private static final String FLEETWOOD_MAC   = "Fleetwood Mac";
	private static final String LYNYARD_SKYNYRD = "Lynyard Skynyrd";
	private static final String LED_ZEPPELIN    = "Led Zeppelin";
	private static final String VAN_HALEN       = "Van Halen";
	
	@Test
	public void testGetName() {
		Person person   = new Person( new String( FLEETWOOD_MAC ));
		String expected =             new String( FLEETWOOD_MAC );
		String actual   = person.getName();
		assertEquals( "Incorrect name", expected, actual );
	}

	@Test
	public void testSetName() {
		Person person   = new Person( "" );
		String expected = new String( LED_ZEPPELIN );

		person.setName(   new String( LED_ZEPPELIN ));
		String actual   = person.getName();
		assertEquals( "Incorrect name", expected, actual );
	}

	@Test
	public void testEqualsWithSameName() {
		Object a = new Person( new String( LYNYARD_SKYNYRD )) { }; // prevents equals use of getClass()
		Object b = new Person( new String( LYNYARD_SKYNYRD ));
		assertEquals( "Incorrect equality result", a, b );
	}

	@Test
	public void testEqualsWithDifferentName() {
		Object a = new Person( new String( LYNYARD_SKYNYRD ));
		Object b = new Person( new String( LED_ZEPPELIN    ));
		assertNotEquals( "Incorrect equality result", a, b );
	}

	@Test
	public void testEqualsWithOtherObjects() {
		Object a = new Person( new String( LYNYARD_SKYNYRD ));
		assertNotEquals( "Incorrect equality result", a, new Integer( 42 ));
		assertNotEquals( "Incorrect equality result", a, new Character( 'A' ));
		assertNotEquals( "Incorrect equality result", a, "abracadabra" );
	}

	@Test
	public void testEqualsWithNull() {
		Object a = new Person( new String( VAN_HALEN ));
		assertNotEquals( "Incorrect equality result", a, null );
	}

	@Test
	public void testCompareToLessThan() {
		Person a = new Person( new String( LED_ZEPPELIN    ));
		Person b = new Person( new String( LYNYARD_SKYNYRD ));
		// They differ in the 2nd character, where 'e'
		// is 20 alphabetic positions earlier than 'y'
		int actual = a.compareTo( b );
		assertTrue( "Incorrect comparison result", actual < 0 );
	}

	@Test
	public void testCompareToEqual() {
		Person a = new Person( new String( FLEETWOOD_MAC ));
		Person b = new Person( new String( FLEETWOOD_MAC ));
		int actual = a.compareTo( b );
		assertTrue( "Incorrect comparison result", actual == 0 );
	}

	@Test
	public void testCompareToGreaterThan() {
		Person a = new Person( new String( VAN_HALEN       ));
		Person b = new Person( new String( LYNYARD_SKYNYRD ));
		// They differ in the 1st character, where 'v'
		// is 10 alphabetic positions earlier than 'l'
		int actual = a.compareTo( b );
		assertTrue( "Incorrect comparison result", actual > 0 );
	}

	@SuppressWarnings("unchecked")
	@Test(expected = ClassCastException.class)
	public void testComparableShouldUseGenericsAndThrowException() {
		@SuppressWarnings("rawtypes")
		Comparable a = new Person( new String( LYNYARD_SKYNYRD ));
		@SuppressWarnings("rawtypes")
		Comparable b =             new String( LED_ZEPPELIN );
		// Person cannot be compared with String
		// Person.compareTo should automatically throw an exception when called
		a.compareTo( b );
	}

}
