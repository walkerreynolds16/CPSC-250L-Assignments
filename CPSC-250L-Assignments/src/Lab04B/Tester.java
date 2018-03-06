package Lab04B;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;

public class Tester {
	
	private static String ALEKS_SYNTEK       = "Aleks Syntek";
	private static String ALEX_LORA          = "Alex Lora";
	private static String BELINDA            = "Belinda";
	private static String DAVID_BISBAL       = "David Bisbal";
	private static String ENRIQUE_IGLESIAS   = "Enrique Iglesias";
	private static String FRANCO_DE_VITA     = "Franco de Vita";
	private static String GLORIA_ESTEFAN     = "Gloria Estefan";
	private static String JESSE              = "Jesse";
	private static String KANY_GARCIA        = "Kany Garcia";
	private static String LAURA_PAUSINI      = "Laura Pausini";
	private static String LU                 = "Lu";
	private static String LUIS_MIGUEL        = "Luis Miguel";
	private static String MANA               = "Mana";
	private static String MIGUEL_RIOS        = "Miguel Rios";
	private static String NATALIA_LAFOURCADE = "Natalia LaFourcade";
	private static String PATXI_ANDION       = "Patxi Andion";

	public static void main(String[] args) {
		
		Party  party = new Party();
		Person a     = new Person( new String( KANY_GARCIA   ));

		party.addInvited( a );
		party.addRSVP   ( a );
		
		ArrayList<Person> list;
		
		list = party.getRSVP();
		assertEquals( "Incorrect result", 1, list.size() );
		for (Person p : list) {
			p.setName( new String( MIGUEL_RIOS ));
		}
		
		list = party.getRSVP();
		assertEquals( "Incorrect result", 1, list.size() );
		assertTrue  ( "Incorrect result", list.contains( a ));
		
	}

}
