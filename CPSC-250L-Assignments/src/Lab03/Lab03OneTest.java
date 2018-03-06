package Lab03;

import static org.junit.Assert.*;

import org.junit.Test;

public class Lab03OneTest {


	@Test
	public void testGetMedianWithEmptyList() {
		Integer[] values   = { };
		Double    actual   = Lab03One.getMedian( values );
		Double    expected = 0.0;
		
		assertEquals( "The result is incorrect", expected, actual, 0.0001 );
	}
	@Test
	public void testGetMedianWithListOneValue() {
		Integer[] values   = { 5 };
		Double    actual   = Lab03One.getMedian( values );
		Double    expected = 5.0;
		
		assertEquals( "The result is incorrect", expected, actual, 0.0001 );
	}
	@Test
	public void testGetMedianWithListEvenValues() {
		Integer[] values   = { 20, 100, 21, 3 };
		Double    actual   = Lab03One.getMedian( values );
		Double    expected = 20.5;
		
		assertEquals( "The result is incorrect", expected, actual, 0.0001 );
	}
	@Test
	public void testGetMedianWithListEvenValuesAgain() {
		Integer[] values   = { 24, 61, 9, -3 };
		Double    actual   = Lab03One.getMedian( values );
		Double    expected = 16.5;
		
		assertEquals( "The result is incorrect", expected, actual, 0.0001 );
	}
	@Test
	public void testGetMedianWithListOddValues() {
		Integer[] values   = { 42, -27, 8, -2, 59, 42, -1 };
		Double    actual   = Lab03One.getMedian( values );
		Double    expected = 8.0;
		
		assertEquals( "The result is incorrect", expected, actual, 0.0001 );
	}

	@Test
	public void testGetDigitsWithListEmpty() {
		Character[] values   = { };
		Character[] actual   = Lab03One.getDigits( values );
		Character[] expected = { };
		
		assertArrayEquals( "The result is incorrect", expected, actual );
	}
	@Test
	public void testGetDigitsWithListWithNoDigits() {
		Character[] values = { 'y', 'o', 'd', 'a' };
		Character[] actual = Lab03One.getDigits( values );
		Character[] expected = { };
		
		assertArrayEquals( "The result is incorrect", expected, actual );
	}
	@Test
	public void testGetDigitsWithListWithLettersAndDigits() {
		Character[] values = { 'C', '-', '3', 'P', 'O' };
		Character[] actual = Lab03One.getDigits( values );
		Character[] expected = { '3' };
		
		assertArrayEquals( "The result is incorrect", expected, actual );
	}
	@Test
	public void testGetDigitsWithListWithDigitsAtBeginningAndEnd() {
		Character[] values = { '0', '0', '7', 'R', '2', 'D', '2' };
		Character[] actual = Lab03One.getDigits( values );
		Character[] expected = { '0', '0', '7', '2', '2' };
		
		assertArrayEquals( "The result is incorrect", expected, actual );
	}
	@Test
	public void testGetDigitsWithListWithDuplicatedDigits() {
		Character[] values = { 'a', '3', '2', 'b', '1', '2', 'c', '3', 'd' };
		Character[] actual = Lab03One.getDigits( values );
		Character[] expected = { '3', '2', '1', '2', '3' };
		
		assertArrayEquals( "The result is incorrect", expected, actual );
	}
	@Test
	public void testGetDigitsWithListWithOnlyDigits() {
		Character[] values = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		Character[] actual = Lab03One.getDigits( values );
		Character[] expected = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		
		assertArrayEquals( "The result is incorrect", expected, actual );
	}
}
