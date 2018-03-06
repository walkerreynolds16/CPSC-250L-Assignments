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


public class LineNumbersTest {

	@Rule
    public TemporaryFolder folder = new TemporaryFolder();
	
	@Test
	public void testReflection() {
		Class<?>   cClass  = LineNumbers.class;
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
			LineNumbers.process( input, output );
			
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
	public void testOneLine() {
		try {
			// create file
			File        input  = folder.newFile( "input.txt" );
			File        output = folder.newFile( "output.txt" );

			PrintWriter write  = new PrintWriter( input );
			write.println( "Lorem ipsum dolor sit amet, consectetur adipiscing elit." );
			write.close();

			// invoke program
			LineNumbers.process( input, output );
			
			// verify file results
			assertTrue  ( "Output file does not exist", output.exists() );
			Scanner scan     = new Scanner( output );
			String[] result = new String[] { 
					"  1 | Lorem ipsum dolor sit amet, consectetur adipiscing elit."
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
	public void testLinesWithEmpty() {
		try {
			// create file
			File        input  = folder.newFile( "input.txt" );
			File        output = folder.newFile( "output.txt" );

			PrintWriter write  = new PrintWriter( input );
			write.println( "                                     " );
			write.println( "            In sed scelerisque dolor," );
			write.println( "               in scelerisque lectus." );
			write.println( "                                     " );
			write.println( "Nam euismod mattis elit ac convallis." );
			write.println( "                                     " );
			write.println( "               Aliquam erat volutpat." );
			write.println( "                                     " );
			write.println( "                  Mauris velit magna," );
			write.println( "                  convallis a mi vel," );
			write.println( "    mattis     elementum      sapien." );
			write.close();

			// invoke program
			LineNumbers.process( input, output );
			
			// verify file results
			assertTrue  ( "Output file does not exist", output.exists() );
			Scanner scan     = new Scanner( output );
			String[] result = new String[] { 
					"  1 |                                      ",
					"  2 |             In sed scelerisque dolor,",
					"  3 |                in scelerisque lectus.",
					"  4 |                                      ",
					"  5 | Nam euismod mattis elit ac convallis.",
					"  6 |                                      ",
					"  7 |                Aliquam erat volutpat.",
					"  8 |                                      ",
					"  9 |                   Mauris velit magna,",
					" 10 |                   convallis a mi vel,",
					" 11 |     mattis     elementum      sapien.",
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
	public void testSeveralLines() {
		try {
			// create file
			File        input  = folder.newFile( "input.txt" );
			File        output = folder.newFile( "output.txt" );

			PrintWriter write  = new PrintWriter( input );
			write.println( "Nulla accumsan leo augue, eget mattis eros dictum sed." );
			write.println( "Donec sodales nibh sapien, non lacinia enim convallis eget." );
			write.println( "Duis at malesuada nisl." );
			write.println( "Proin risus diam, tristique bibendum euismod nec, fermentum adipiscing tortor." );
			write.println( "Sed porta semper risus, vitae tempor neque interdum vitae." );
			write.println( "Ut ullamcorper mollis elit, ut pellentesque tellus hendrerit nec." );
			write.println( "Nunc malesuada ac ipsum sit amet cursus." );
			write.println( "Donec ut tellus a lacus imperdiet elementum vitae consectetur sapien." );
			write.println( "Vestibulum eget consequat mauris." );
			write.println( "Aenean posuere placerat arcu, eu bibendum magna iaculis nec." );
			write.println( "Integer pretium, quam in venenatis cursus, dolor lacus feugiat turpis, nec ultrices dui diam sed odio." );
			write.println( "Suspendisse sed placerat lectus." );
			write.println( "Curabitur euismod eros a blandit pulvinar." );
			write.println( "Mauris est ante, rutrum in enim a, ultrices pellentesque odio." );
			write.println( "Ut congue neque quis dapibus facilisis." );
			write.close();

			// invoke program
			LineNumbers.process( input, output );
			
			// verify file results
			assertTrue  ( "Output file does not exist", output.exists() );
			Scanner  scan   = new Scanner( output );
			String[] result = new String[] { 
					"  1 | Nulla accumsan leo augue, eget mattis eros dictum sed.",
					"  2 | Donec sodales nibh sapien, non lacinia enim convallis eget.",
					"  3 | Duis at malesuada nisl.",
					"  4 | Proin risus diam, tristique bibendum euismod nec, fermentum adipiscing tortor.",
					"  5 | Sed porta semper risus, vitae tempor neque interdum vitae.",
					"  6 | Ut ullamcorper mollis elit, ut pellentesque tellus hendrerit nec.",
					"  7 | Nunc malesuada ac ipsum sit amet cursus.",
					"  8 | Donec ut tellus a lacus imperdiet elementum vitae consectetur sapien.",
					"  9 | Vestibulum eget consequat mauris.",
					" 10 | Aenean posuere placerat arcu, eu bibendum magna iaculis nec.",
					" 11 | Integer pretium, quam in venenatis cursus, dolor lacus feugiat turpis, nec ultrices dui diam sed odio.",
					" 12 | Suspendisse sed placerat lectus.",
					" 13 | Curabitur euismod eros a blandit pulvinar.",
					" 14 | Mauris est ante, rutrum in enim a, ultrices pellentesque odio.",
					" 15 | Ut congue neque quis dapibus facilisis."
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
	public void testGazillionLines() {
		try {
			// create file
			File        input  = folder.newFile( "input.txt" );
			File        output = folder.newFile( "output.txt" );

			PrintWriter write  = new PrintWriter( input );
			write.println( "one" );
			write.println( "two" );
			write.println( "three" );
			write.println( "four" );
			write.println( "five" );
			write.println( "six" );
			write.println( "seven" );
			write.println( "eight" );
			write.println( "nine" );
			write.println( "ten" );
			write.println( "eleven" );
			write.println( "twelve" );
			write.println( "thirteen" );
			write.println( "fourteen" );
			write.println( "fifteen" );
			write.println( "sixteen" );
			write.println( "seventeen" );
			write.println( "eighteen" );
			write.println( "nineteen" );
			write.println( "twenty" );
			write.println( "twenty one" );
			write.println( "twenty two" );
			write.println( "twenty three" );
			write.println( "twenty four" );
			write.println( "twenty five" );
			write.println( "twenty six" );
			write.println( "twenty seven" );
			write.println( "twenty eight" );
			write.println( "twenty nine" );
			write.println( "thirty" );
			write.println( "thirty one" );
			write.println( "thirty two" );
			write.println( "thirty three" );
			write.println( "thirty four" );
			write.println( "thirty five" );
			write.println( "thirty six" );
			write.println( "thirty seven" );
			write.println( "thirty eight" );
			write.println( "thirty nine" );
			write.println( "fourty" );
			write.println( "fourty one" );
			write.println( "fourty two" );
			write.println( "fourty three" );
			write.println( "fourty four" );
			write.println( "fourty five" );
			write.println( "fourty six" );
			write.println( "fourty seven" );
			write.println( "fourty eight" );
			write.println( "fourty nine" );
			write.println( "fifty" );
			write.println( "fifty one" );
			write.println( "fifty two" );
			write.println( "fifty three" );
			write.println( "fifty four" );
			write.println( "fifty five" );
			write.println( "fifty six" );
			write.println( "fifty seven" );
			write.println( "fifty eight" );
			write.println( "fifty nine" );
			write.println( "sixty" );
			write.println( "sixty one" );
			write.println( "sixty two" );
			write.println( "sixty three" );
			write.println( "sixty four" );
			write.println( "sixty five" );
			write.println( "sixty six" );
			write.println( "sixty seven" );
			write.println( "sixty eight" );
			write.println( "sixty nine" );
			write.println( "seventy" );
			write.println( "seventy one" );
			write.println( "seventy two" );
			write.println( "seventy three" );
			write.println( "seventy four" );
			write.println( "seventy five" );
			write.println( "seventy six" );
			write.println( "seventy seven" );
			write.println( "seventy eight" );
			write.println( "seventy nine" );
			write.println( "eigthy" );
			write.println( "eigthy one" );
			write.println( "eigthy two" );
			write.println( "eigthy three" );
			write.println( "eigthy four" );
			write.println( "eigthy five" );
			write.println( "eigthy six" );
			write.println( "eigthy seven" );
			write.println( "eigthy eight" );
			write.println( "eigthy nine" );
			write.println( "ninety" );
			write.println( "ninety one" );
			write.println( "ninety two" );
			write.println( "ninety three" );
			write.println( "ninety four" );
			write.println( "ninety five" );
			write.println( "ninety six" );
			write.println( "ninety seven" );
			write.println( "ninety eight" );
			write.println( "ninety nine" );
			write.println( "one hundred" );
			write.println( "one hundred one" );
			write.println( "one hundred two" );
			write.println( "one hundred three" );
			write.println( "one hundred four" );
			write.println( "one hundred five" );
			write.println( "one hundred six" );
			write.println( "one hundred seven" );
			write.println( "one hundred eight" );
			write.println( "one hundred nine" );
			write.println( "one hundred ten" );
			write.println( "one hundred eleven" );
			write.println( "one hundred twelve" );
			write.println( "one hundred thirteen" );
			write.println( "one hundred fourteen" );
			write.println( "one hundred fifteen" );
			write.println( "one hundred sixteen" );
			write.println( "one hundred seventeen" );
			write.println( "one hundred eighteen" );
			write.println( "one hundred nineteen" );
			write.println( "one hundred twenty" );
			write.close();

			// invoke program
			LineNumbers.process( input, output );
			
			// verify file results
			assertTrue  ( "Output file does not exist", output.exists() );
			Scanner  scan   = new Scanner( output );
			String[] result = new String[] { 
					"  1 | one",
					"  2 | two",
					"  3 | three",
					"  4 | four",
					"  5 | five",
					"  6 | six",
					"  7 | seven",
					"  8 | eight",
					"  9 | nine",
					" 10 | ten",
					" 11 | eleven",
					" 12 | twelve",
					" 13 | thirteen",
					" 14 | fourteen",
					" 15 | fifteen",
					" 16 | sixteen",
					" 17 | seventeen",
					" 18 | eighteen",
					" 19 | nineteen",
					" 20 | twenty",
					" 21 | twenty one",
					" 22 | twenty two",
					" 23 | twenty three",
					" 24 | twenty four",
					" 25 | twenty five",
					" 26 | twenty six",
					" 27 | twenty seven",
					" 28 | twenty eight",
					" 29 | twenty nine",
					" 30 | thirty",
					" 31 | thirty one",
					" 32 | thirty two",
					" 33 | thirty three",
					" 34 | thirty four",
					" 35 | thirty five",
					" 36 | thirty six",
					" 37 | thirty seven",
					" 38 | thirty eight",
					" 39 | thirty nine",
					" 40 | fourty",
					" 41 | fourty one",
					" 42 | fourty two",
					" 43 | fourty three",
					" 44 | fourty four",
					" 45 | fourty five",
					" 46 | fourty six",
					" 47 | fourty seven",
					" 48 | fourty eight",
					" 49 | fourty nine",
					" 50 | fifty",
					" 51 | fifty one",
					" 52 | fifty two",
					" 53 | fifty three",
					" 54 | fifty four",
					" 55 | fifty five",
					" 56 | fifty six",
					" 57 | fifty seven",
					" 58 | fifty eight",
					" 59 | fifty nine",
					" 60 | sixty",
					" 61 | sixty one",
					" 62 | sixty two",
					" 63 | sixty three",
					" 64 | sixty four",
					" 65 | sixty five",
					" 66 | sixty six",
					" 67 | sixty seven",
					" 68 | sixty eight",
					" 69 | sixty nine",
					" 70 | seventy",
					" 71 | seventy one",
					" 72 | seventy two",
					" 73 | seventy three",
					" 74 | seventy four",
					" 75 | seventy five",
					" 76 | seventy six",
					" 77 | seventy seven",
					" 78 | seventy eight",
					" 79 | seventy nine",
					" 80 | eigthy",
					" 81 | eigthy one",
					" 82 | eigthy two",
					" 83 | eigthy three",
					" 84 | eigthy four",
					" 85 | eigthy five",
					" 86 | eigthy six",
					" 87 | eigthy seven",
					" 88 | eigthy eight",
					" 89 | eigthy nine",
					" 90 | ninety",
					" 91 | ninety one",
					" 92 | ninety two",
					" 93 | ninety three",
					" 94 | ninety four",
					" 95 | ninety five",
					" 96 | ninety six",
					" 97 | ninety seven",
					" 98 | ninety eight",
					" 99 | ninety nine",
					"100 | one hundred",
					"101 | one hundred one",
					"102 | one hundred two",
					"103 | one hundred three",
					"104 | one hundred four",
					"105 | one hundred five",
					"106 | one hundred six",
					"107 | one hundred seven",
					"108 | one hundred eight",
					"109 | one hundred nine",
					"110 | one hundred ten",
					"111 | one hundred eleven",
					"112 | one hundred twelve",
					"113 | one hundred thirteen",
					"114 | one hundred fourteen",
					"115 | one hundred fifteen",
					"116 | one hundred sixteen",
					"117 | one hundred seventeen",
					"118 | one hundred eighteen",
					"119 | one hundred nineteen",
					"120 | one hundred twenty",
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

}
