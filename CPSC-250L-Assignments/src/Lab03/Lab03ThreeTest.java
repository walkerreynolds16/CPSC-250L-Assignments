package Lab03;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class Lab03ThreeTest {

	@Test
	public void testGetLettersWithEmptyList() {
		String[]          values = { }; 
		ArrayList<String> list   = new ArrayList<String>( Arrays.asList( values ));
		//                 a  b  c  d  e  f  g  h  i  j  k  l  m  n  o  p  q  r  s  t  u  v  w  x  y  z
		int[] expected = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int[] actual   = Lab03Three.getLetters( list );
		
		assertArrayEquals( "The result is incorrect", expected, actual );
	}
	@Test
	public void testGetLettersWithOneShortString() {
		String[]          values = { "AC/DC" }; 
		ArrayList<String> list   = new ArrayList<String>( Arrays.asList( values ));
		//                 a  b  c  d  e  f  g  h  i  j  k  l  m  n  o  p  q  r  s  t  u  v  w  x  y  z
		int[] expected = { 1, 0, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int[] actual   = Lab03Three.getLetters( list );
		
		assertArrayEquals( "The result is incorrect", expected, actual );
	}
	@Test
	public void testGetLettersWithSeveralShortStrings() {
		String[]          values = { "Coldplay", "", "The B-52's", "INXS" }; // the 2nd string is empty 
		ArrayList<String> list   = new ArrayList<String>( Arrays.asList( values ));
		//                 a  b  c  d  e  f  g  h  i  j  k  l  m  n  o  p  q  r  s  t  u  v  w  x  y  z
		int[] expected = { 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 2, 0, 1, 1, 1, 0, 0, 2, 1, 0, 0, 0, 1, 1, 0 };
		int[] actual   = Lab03Three.getLetters( list );
		
		assertArrayEquals( "The result is incorrect", expected, actual );
	}
	@Test
	public void testGetLettersWithOneLongString() {
		String[]          values = { "Back in black, I hit the sack, I've been too long, I'm glad to be back." }; 
		ArrayList<String> list   = new ArrayList<String>( Arrays.asList( values ));
		//                 a  b  c  d  e  f  g  h  i  j  k  l  m  n  o  p  q  r  s  t  u  v  w  x  y  z
		int[] expected = { 5, 5, 4, 1, 5, 0, 2, 2, 5, 0, 4, 3, 1, 3, 4, 0, 0, 0, 1, 4, 0, 1, 0, 0, 0, 0 };
		int[] actual   = Lab03Three.getLetters( list );
		
		assertArrayEquals( "The result is incorrect", expected, actual );
	}
	@Test
	public void testGetLettersWithSeveralMediumSizeStrings() {
		String[]          values = { "Cars: My best friend's girl", "Jesse & Joy: Chocolate", "Queen: We will rock you", "Rush: YYZ" }; 
		ArrayList<String> list   = new ArrayList<String>( Arrays.asList( values ));
		//                 a  b  c  d  e  f  g  h  i  j  k  l  m  n  o  p  q  r  s  t  u  v  w  x  y  z
		int[] expected = { 2, 1, 4, 1, 8, 1, 1, 2, 3, 2, 1, 4, 1, 2, 5, 0, 1, 5, 6, 2, 3, 0, 2, 0, 5, 1 };
		int[] actual   = Lab03Three.getLetters( list );
		
		assertArrayEquals( "The result is incorrect", expected, actual );
	}
}
