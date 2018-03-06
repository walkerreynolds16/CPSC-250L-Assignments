package Lab06;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class CookieJarTest {

	@Rule
    public TemporaryFolder folder = new TemporaryFolder();
	
	@Test
	public void testReflection() {
		Class<?>   cClass  = CookieJar.class;
		Field[]    cFields = cClass.getDeclaredFields();

		for (Field f : cFields) {
			if (!f.isSynthetic()) {
				assertTrue ( "Field \""+f.getName()+"\" should be private", Modifier.isPrivate( f.getModifiers() ));
				assertFalse( "Field \""+f.getName()+"\" can't be static",   Modifier.isStatic ( f.getModifiers() ));
			}
		}
	}
	@Test
	public void testEmptyFile() {
		try {
			// create file
			File        input  = folder.newFile( "input.txt" );
			File        output = folder.newFile( "output.txt" );

			// invoke program
			CookieJar.cashingIn( input, output );
			
			// verify file results
			assertTrue  ( "Output file does not exist", output.exists() );
			Scanner scan     = new Scanner( output );
			String  expected = "You have no money in the jar";
			assertTrue  ( "Unexpected end of file: expected \"%s\"" + expected, scan.hasNext() );
			String  actual   = scan.nextLine();
			assertEquals( "Incorrect result", expected, actual );
			assertFalse ( "File contains more data than expected", scan.hasNext() );
			scan.close();
		} 
		catch (IOException e) {
			fail( "No exception should be thrown" );
		}
	}
	@Test
	public void test0() {
		try {
			// create file
			File        input  = folder.newFile( "input.txt" );
			File        output = folder.newFile( "output.txt" );

			PrintWriter write  = new PrintWriter( input );
			write.println( "0 quarters 0 pennies 0 nickels 0 dimes" );
			write.close();

			// invoke program
			CookieJar.cashingIn( input, output );
			
			// verify file results
			assertTrue  ( "Output file does not exist", output.exists() );
			Scanner scan     = new Scanner( output );
			String  expected = "You have no money in the jar";
			assertTrue  ( "Unexpected end of file: expected \"%s\"" + expected, scan.hasNext() );
			String  actual   = scan.nextLine();
			assertEquals( "Incorrect result", expected, actual );
			assertFalse ( "File contains more data than expected", scan.hasNext() );
			scan.close();
		} 
		catch (IOException e) {
			fail( "No exception should be thrown" );
		}
	}
	@Test
	public void test1() {
		try {
			// create file
			File        input  = folder.newFile( "input.txt" );
			File        output = folder.newFile( "output.txt" );

			PrintWriter write  = new PrintWriter( input );
			write.println( "2 quarters 4 dimes 1 penny 3 nickels 3 pennies" );
			write.close();

			// invoke program
			CookieJar.cashingIn( input, output );
			
			// verify file results
			assertTrue  ( "Output file does not exist", output.exists() );
			Scanner scan     = new Scanner( output );
			String  expected = "You have $1.09 in the jar";
			assertTrue  ( "Unexpected end of file: expected \"%s\"" + expected, scan.hasNext() );
			String  actual   = scan.nextLine();
			assertEquals( "Incorrect result", expected, actual );
			assertFalse ( "File contains more data than expected", scan.hasNext() );
			scan.close();
		} 
		catch (IOException e) {
			fail( "No exception should be thrown" );
		}
	}
	@Test
	public void test2() {
		try {
			// create file
			File        input  = folder.newFile( "input.txt" );
			File        output = folder.newFile( "output.txt" );

			PrintWriter write  = new PrintWriter( input );
			write.println( "             " );
			write.println( " 423 quarters" );
			write.println( " 102 nickels " );
			write.println( "  99 pennies " );
			write.println( "   3 dimes   " );
			write.println( "             " );
			write.close();

			// invoke program
			CookieJar.cashingIn( input, output );
			
			// verify file results
			assertTrue  ( "Output file does not exist", output.exists() );
			Scanner scan     = new Scanner( output );
			String  expected = "You have $112.14 in the jar";
			assertTrue  ( "Unexpected end of file: expected \"%s\"" + expected, scan.hasNext() );
			String  actual   = scan.nextLine();
			assertEquals( "Incorrect result", expected, actual );
			assertFalse ( "File contains more data than expected", scan.hasNext() );
			scan.close();
		} 
		catch (IOException e) {
			fail( "No exception should be thrown" );
		}
	}
	@Test
	public void test3() {
		try {
			// create file
			File        input  = folder.newFile( "input.txt" );
			File        output = folder.newFile( "output.txt" );

			PrintWriter write  = new PrintWriter( input );
			write.println( "32 nickels" );
			write.println( " 1" );
			write.println( "   nickel 42" );
			write.println( "quarters 1 penny" );
			write.println( "1 quarter 23 pennies 16" );
			write.println( "" );
			write.println( "dimes 1 dime 1 dime 1 dime 1 dime" );
			write.close();

			// invoke program
			CookieJar.cashingIn( input, output );
			
			// verify file results
			assertTrue  ( "Output file does not exist", output.exists() );
			Scanner scan     = new Scanner( output );
			String  expected = "You have $14.64 in the jar";
			assertTrue  ( "Unexpected end of file: expected \"%s\"" + expected, scan.hasNext() );
			String  actual   = scan.nextLine();
			assertEquals( "Incorrect result", expected, actual );
			assertFalse ( "File contains more data than expected", scan.hasNext() );
			scan.close();
		} 
		catch (IOException e) {
			fail( "No exception should be thrown" );
		}
	}
	@Test
	public void test4() {
		try {
			// create file
			File        input  = folder.newFile( "input.txt" );
			File        output = folder.newFile( "output.txt" );

			PrintWriter write  = new PrintWriter( input );
			write.println( "4321 quarters" );
			write.println( "1234 pennies" );
			write.println( "4567 dimes" );
			write.println( "9876 nickels" );
			write.close();

			// invoke program
			CookieJar.cashingIn( input, output );
			
			// verify file results
			assertTrue  ( "Output file does not exist", output.exists() );
			Scanner scan     = new Scanner( output );
			String  expected = "You have $2,043.09 in the jar";
			assertTrue  ( "Unexpected end of file: expected \"%s\"" + expected, scan.hasNext() );
			String  actual   = scan.nextLine();
			assertEquals( "Incorrect result", expected, actual );
			assertFalse ( "File contains more data than expected", scan.hasNext() );
			scan.close();
		} 
		catch (IOException e) {
			fail( "No exception should be thrown" );
		}
	}

}
