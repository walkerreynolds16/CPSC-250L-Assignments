package Lab07;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class GuessingServerTest {

	@Test
	public void testReflection() {
		Class<?> iClass  = GuessingServer.class;
		Field[]  iFields = iClass.getDeclaredFields();

		for (Field f : iFields) {
			if (!f.isSynthetic()) {
				assertTrue ( "Field \""+f.getName()+"\" should be private", Modifier.isPrivate( f.getModifiers() ));
				assertFalse( "Field \""+f.getName()+"\" can't be static",   Modifier.isStatic ( f.getModifiers() ));
			}
		}
	}

	@BeforeClass
	public static void startServer() {
		// run server
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				GuessingServer.main( new String[]{ } );
			}
		});
		thread.start();
	}
	@Before
	public void waitTwoSecondsBetweenTests() {
		try {
			Thread.sleep( 2000 );
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(timeout=3000)
	public void testA_WinningAfter1Try() {
		try {
			// run client
			Socket      socket  = new Socket( "localhost", 5150 );
			Scanner     scanner = new Scanner    ( socket.getInputStream() );
			PrintWriter writer  = new PrintWriter( socket.getOutputStream(), true );
			
			writer.println( "101 401" );
			// try 1
			int actual = scanner.nextInt();
			assertEquals( "Incorrect result", 251, actual );

			writer.println( "won" );
			
			socket .close();
			scanner.close();
		}
		catch (IOException e) {
			e.printStackTrace();
			fail( "Error opening client socket" );
		}
		catch (NoSuchElementException e) {
			e.printStackTrace();
			fail( "The server didn't return a value" );
		}
	}

	@Test(timeout=3000)
	public void testB_WinningAfter2Tries() {
		try {
			// run client
			Socket      socket  = new Socket( "localhost", 5150 );
			Scanner     scanner = new Scanner    ( socket.getInputStream() );
			PrintWriter writer  = new PrintWriter( socket.getOutputStream(), true );
			
			writer.println( "37 337" );
			// try 1
			int actual = scanner.nextInt();
			assertEquals( "Incorrect result", 187, actual );
			writer.println( "low" );
			// try 2
			actual = scanner.nextInt();
			assertEquals( "Incorrect result", 262, actual );
			writer.println( "high" );
			// try 3
			actual = scanner.nextInt();
			assertEquals( "Incorrect result", 224, actual );
			writer.println( "high" );
			// try 4
			actual = scanner.nextInt();
			assertEquals( "Incorrect result", 205, actual );
			writer.println( "low" );
			// try 5
			actual = scanner.nextInt();
			assertEquals( "Incorrect result", 214, actual );
			writer.println( "high" );
			// try 6
			actual = scanner.nextInt();
			assertEquals( "Incorrect result", 209, actual );
			writer.println( "high" );
			// try 7
			actual = scanner.nextInt();
			assertEquals( "Incorrect result", 207, actual );
			writer.println( "high" );
			// try 8
			actual = scanner.nextInt();
			assertEquals( "Incorrect result", 206, actual );
			writer.println( "won" );
			
			socket .close();
			scanner.close();
		}
		catch (IOException e) {
			e.printStackTrace();
			fail( "Error opening client socket" );
		}
		catch (NoSuchElementException e) {
			e.printStackTrace();
			fail( "The server didn't return a value" );
		}
	}

	@Test(timeout=3000)
	public void testC_PlayingARandomGame() throws IOException {
		final int    UPPER  = 200;
		final int    RANGE  = 300;
		final int    TRIES  =   9;

		final Random random = new Random();
		try {
			// run client
			Socket      socket  = new Socket( "localhost", 5150 );
			Scanner     scanner = new Scanner    ( socket.getInputStream() );
			PrintWriter writer  = new PrintWriter( socket.getOutputStream(), true );
			
			int low    = random.nextInt( UPPER );
			int hi     = low + RANGE;
			int number = low + random.nextInt( RANGE );

			writer.println( low + " " + hi );

			int     tries    = 0;
			boolean gameOver = false;

			while (!gameOver) {
				int guess = scanner.nextInt();
				if (guess == number) {
					writer.println( "won" );
					gameOver = true;
				}
				else {
					if (++tries > TRIES) {
						writer.println( "lose" );
						gameOver = true;
					}
					else {
						if (guess < number) {
							writer.println( "low" );
						}
						else {
							writer.println( "high" );
						}
					}
				}
			}
			socket .close();
			scanner.close();
		}
		catch (IOException e) {
			e.printStackTrace();
			fail( "Error opening client socket" );
		}
		catch (NoSuchElementException e) {
			e.printStackTrace();
			fail( "The server didn't return a value" );
		}
	}
	
	@Test(expected = IOException.class)
	public void testD_RunsLast_ServerShutsDown() throws IOException {
		try {
			// running client #1...shuts down server
			Socket      socket  = new Socket( "localhost", 5150 );
			PrintWriter writer  = new PrintWriter( socket.getOutputStream(), true );
			
			writer.println( "SHUT DOWN" );

			socket.close();
		}
		catch (IOException e) {
			e.printStackTrace();
			fail( "Error opening client socket" );
		}
		waitTwoSecondsBetweenTests();

		// running client #2...should throw exception (server should have stopped)
		new Socket( "localhost", 5150 ).close();
		fail( "Socket should not connect after server was shut down" );
	}

}
