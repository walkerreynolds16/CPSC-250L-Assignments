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

public class DiscographyTest {

	@Rule
    public TemporaryFolder folder = new TemporaryFolder();
	
	@Test
	public void testReflection() {
		Class<?>   cClass  = Discography.class;
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
			Discography.writeReport( input, output );
			
			// verify file results
			assertTrue  ( "Output file does not exist", output.exists() );
			Scanner scan     = new Scanner( output );
			assertFalse ( "Incorrect result", scan.hasNext() );
			scan.close();
		} 
		catch (IOException e) {
			fail( "No exception should be thrown" );
		}
	}
	@Test
	public void testOneAlbum() {
		try {
			// create file
			File        input  = folder.newFile( "input.txt" );
			File        output = folder.newFile( "output.txt" );

			PrintWriter write  = new PrintWriter( input );
			write.println( "Best of Elmo,Sesame Street,2:29,1:30,2:09,1:46,1:55,2:02,1:42,2:40,1:56,1:30,2:03,1:14,2:28,2:47" );
			write.close();

			// invoke program
			Discography.writeReport( input, output );
			
			// verify file results
			assertTrue  ( "Output file does not exist", output.exists() );
			Scanner scan     = new Scanner( output );
			String[] result = new String[] { 
					"Sesame Street | Best of Elmo | 0:28:11"
			};
			for (String expected : result) {
				if (scan.hasNext()) {
					String actual = scan.nextLine();
					assertEquals( "Incorrect result", expected, actual );
				}
				else {
					fail( String.format( "Unexpected end of file: expected \"%s\"", expected ));
					break;
				}
			}
			assertFalse ( "File contains more data than expected", scan.hasNext() );
			scan.close();
		} 
		catch (IOException e) {
			fail( "No exception should be thrown" );
		}
	}
	@Test
	public void testOneLongAlbum() {
		try {
			// create file
			File        input  = folder.newFile( "input.txt" );
			File        output = folder.newFile( "output.txt" );

			PrintWriter write  = new PrintWriter( input );
			write.println( "Mozart: Don Giovanni,Herbert von Karajan,6:07,5:54,0:31,3:13,4:21,1:37,3:51,2:45,5:42,0:33,1:26,2:20,1:38,2:06,3:27,0:47,1:18,1:09,4:23,3:39,2:59,0:33,4:24,1:42,1:21,1:23,3:58,0:40,0:54,0:48,2:32,5:07,9:35,1:02,1:55,5:03,1:37,1:48,1:07,2:52,0:48,1:26,3:34,0:33,8:28,1:56,0:46,4:45,2:25,3:30,4:28,3:29,0:58,2:02,5:36,5:04,3:46,8:02,6:31" );
			write.close();

			// invoke program
			Discography.writeReport( input, output );
			
			// verify file results
			assertTrue  ( "Output file does not exist", output.exists() );
			Scanner scan     = new Scanner( output );
			String[] result = new String[] { 
					"Herbert von Karajan | Mozart: Don Giovanni | 2:56:14",
			};
			for (String expected : result) {
				if (scan.hasNext()) {
					String actual = scan.nextLine();
					assertEquals( "Incorrect result", expected, actual );
				}
				else {
					fail( String.format( "Unexpected end of file: expected \"%s\"", expected ));
					break;
				}
			}
			assertFalse ( "File contains more data than expected", scan.hasNext() );
			scan.close();
		} 
		catch (IOException e) {
			fail( "No exception should be thrown" );
		}
	}
	@Test
	public void testTwoAlbums() {
		try {
			// create file
			File        input  = folder.newFile( "input.txt" );
			File        output = folder.newFile( "output.txt" );

			PrintWriter write  = new PrintWriter( input );
			write.println( "The Adventures of Elmo in Grouchland,Sesame Street,2:17,3:04,3:16,2:31,4:28,12:42,2:13,2:24,3:32" );
			write.println( "Elmopalooza!,Sesame Street,2:37,3:59,1:40,2:35,2:31,2:24,3:34,2:45,2:34,3:29,3:15" );
			write.close();

			// invoke program
			Discography.writeReport( input, output );
			
			// verify file results
			assertTrue  ( "Output file does not exist", output.exists() );
			Scanner  scan   = new Scanner( output );
			String[] result = new String[] { 
					"Sesame Street | Elmopalooza!                         | 0:31:23",
					"Sesame Street | The Adventures of Elmo in Grouchland | 0:36:27"
			};
			for (String expected : result) {
				if (scan.hasNext()) {
					String actual = scan.nextLine();
					assertEquals( "Incorrect result", expected, actual );
				}
				else {
					fail( String.format( "Unexpected end of file: expected \"%s\"", expected ));
					break;
				}
			}
			assertFalse ( "File contains more data than expected", scan.hasNext() );
			scan.close();
		} 
		catch (IOException e) {
			fail( "No exception should be thrown" );
		}
	}
	@Test
	public void testThreeAlbums() {
		try {
			// create file
			File        input  = folder.newFile( "input.txt" );
			File        output = folder.newFile( "output.txt" );

			PrintWriter write  = new PrintWriter( input );
			write.println( "A Song for You,Carpenters,4:42,2:56,2:46,2:55,3:50,0:22,3:07,1:45,1:59,3:47,3:58,3:50" );
			write.println( "Doo-Wops & Hooligans,Bruno Mars,3:42,3:40,4:03,2:28,3:15,3:50,3:37,3:49,3:17,3:47" );
			write.println( "New Jersey,Bon Jovi,6:01,5:16,4:40,4:39,6:16,5:20,5:08,1:25,4:45,5:46,4:28,3:58" );
			write.close();

			// invoke program
			Discography.writeReport( input, output );
			
			// verify file results
			assertTrue  ( "Output file does not exist", output.exists() );
			Scanner  scan   = new Scanner( output );
			String[] result = new String[] { 
					"Bon Jovi   | New Jersey           | 0:57:42",
					"Bruno Mars | Doo-Wops & Hooligans | 0:35:28",
					"Carpenters | A Song for You       | 0:35:57"
			};
			for (String expected : result) {
				if (scan.hasNext()) {
					String actual = scan.nextLine();
					assertEquals( "Incorrect result", expected, actual );
				}
				else {
					fail( String.format( "Unexpected end of file: expected \"%s\"", expected ));
					break;
				}
			}
			assertFalse ( "File contains more data than expected", scan.hasNext() );
			scan.close();
		} 
		catch (IOException e) {
			fail( "No exception should be thrown" );
		}
	}
	@Test
	public void test03() {
		try {
			// create file
			File        input  = folder.newFile( "input.txt" );
			File        output = folder.newFile( "output.txt" );

			PrintWriter write  = new PrintWriter( input );
			write.println( "Toto IV,Toto,5:33,3:47,4:56,3:18,3:10,3:51,4:26,3:58,4:13,5:01" );
			write.println( "Thriller,Michael Jackson,6:03,4:20,3:42,5:57,4:18,4:54,4:06,3:59,5:00" );
			write.println( "Toto,Toto,2:46,3:46,4:09,3:54,4:11,6:13,3:47,3:19,3:56,4:45" );
			write.println( "Entre el Cielo y el Suelo,Mecano,4:02,4:37,4:22,4:04,2:57,3:05,3:14,4:42,5:04,3:58" );
			write.println( "Nothing But the Beat,David Guetta,3:30,3:10,3:19,3:16,3:28,3:39,3:29,3:12,3:23,5:16,3:41,3:26,4:05" );
			write.println( "The Suburbs,Arcade Fire,5:15,4:15,4:39,3:56,2:51,3:11,4:13,4:27,4:45,3:50,3:20,4:28,5:01,2:54,5:25,1:27" );
			write.close();
			// invoke program
			Discography.writeReport( input, output );
			
			// verify file results
			assertTrue  ( "Output file does not exist", output.exists() );
			Scanner  scan   = new Scanner( output );
			String[] result = new String[] { 
					"Arcade Fire     | The Suburbs               | 1:03:57",
					"David Guetta    | Nothing But the Beat      | 0:46:54",
					"Mecano          | Entre el Cielo y el Suelo | 0:40:05",
					"Michael Jackson | Thriller                  | 0:42:19",
					"Toto            | Toto                      | 0:40:46",
					"Toto            | Toto IV                   | 0:42:13"
			};
			for (String expected : result) {
				if (scan.hasNext()) {
					String actual = scan.nextLine();
					assertEquals( "Incorrect result", expected, actual );
				}
				else {
					fail( String.format( "Unexpected end of file: expected \"%s\"", expected ));
					break;
				}
			}
			assertFalse ( "Incorrect result", scan.hasNext() );
			scan.close();
		} 
		catch (IOException e) {
			fail( "No exception should be thrown" );
		}
	}
	@Test
	public void test04() {
		try {
			// create file
			File        input  = folder.newFile( "input.txt" );
			File        output = folder.newFile( "output.txt" );

			PrintWriter write  = new PrintWriter( input );
			write.println( "Moving Pictures,Rush,4:33,6:10,4:26,4:19,11:01,4:45,4:46" );
			write.println( "Third Stage,Boston,4:16,3:53,3:00,4:23,2:13,0:36,3:33,4:10,5:18,5:18" );
			write.println( "Led Zeppelin IV,Led Zeppelin,4:57,3:40,5:52,8:02,4:38,4:45,3:31,7:08" );
			write.println( "Back in Black,AC/DC,5:12,5:17,3:35,3:31,4:15,4:15,3:30,3:58,4:05,4:26" );
			write.println( "Boston,Boston,4:44,5:02,7:47,3:00,4:21,4:11,3:48,4:43" );
			write.println( "Eye in the Sky,The Alan Parsons Project,1:54,4:36,4:51,2:11,7:19,4:22,4:51,3:34,3:54,4:55" );
			write.println( "The Turn of a Friendly Card,The Alan Parsons Project,4:52,4:17,5:05,4:54,4:28,2:39,3:17,2:58,4:03,3:12" );
			write.close();
			// invoke program
			Discography.writeReport( input, output );
			
			// verify file results
			assertTrue  ( "Output file does not exist", output.exists() );
			Scanner  scan   = new Scanner( output );
			String[] result = new String[] { 
					"AC/DC                    | Back in Black               | 0:42:04",
					"Boston                   | Boston                      | 0:37:36",
					"Boston                   | Third Stage                 | 0:36:40",
					"Led Zeppelin             | Led Zeppelin IV             | 0:42:33",
					"Rush                     | Moving Pictures             | 0:40:00",
					"The Alan Parsons Project | Eye in the Sky              | 0:42:27",
					"The Alan Parsons Project | The Turn of a Friendly Card | 0:39:45"
			};
			for (String expected : result) {
				if (scan.hasNext()) {
					String actual = scan.nextLine();
					assertEquals( "Incorrect result", expected, actual );
				}
				else {
					fail( String.format( "Unexpected end of file: expected \"%s\"", expected ));
					break;
				}
			}
			assertFalse ( "Incorrect result", scan.hasNext() );
			scan.close();
		} 
		catch (IOException e) {
			fail( "No exception should be thrown" );
		}
	}

}
