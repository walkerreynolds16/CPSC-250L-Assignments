package Lab04B;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class PartyTest {

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

	@Test
	public void testAddInvitedListIsEmpty() {
		Party             party = new Party();
		ArrayList<Person> list  = party.getInvited();
		assertEquals( "Incorrect result", 0, list.size() );
	}

	@Test
	public void testAddInvitedWith2Invited() {
		Party  party = new Party();
		Person a     = new Person( new String( ALEKS_SYNTEK ));
		Person b     = new Person( new String( DAVID_BISBAL ));

		Person a1    = new Person( new String( ALEKS_SYNTEK ));
		Person b1    = new Person( new String( DAVID_BISBAL ));
		
		party.addInvited( a );
		party.addInvited( b );
		
		ArrayList<Person> list = party.getInvited();
		assertEquals( "Incorrect result", 2, list.size() );
		assertTrue  ( "Incorrect result", list.contains( a1 ));
		assertTrue  ( "Incorrect result", list.contains( b1 ));
	}

	@Test
	public void testAddInvitedWithDuplicatedNames() {
		Party  party = new Party();
		Person a     = new Person( new String( ALEX_LORA      ));
		Person b     = new Person( new String( ENRIQUE_IGLESIAS ));
		Person c     = new Person( new String( ALEX_LORA      ));

		Person a1    = new Person( new String( ALEX_LORA      ));
		Person b1    = new Person( new String( ENRIQUE_IGLESIAS ));

		party.addInvited( a );
		party.addInvited( b );
		party.addInvited( c );
		
		ArrayList<Person> list = party.getInvited();
		assertEquals( "Incorrect result", 2, list.size() );
		assertTrue  ( "Incorrect result", list.contains( a1 ));
		assertTrue  ( "Incorrect result", list.contains( b1 ));
	}

	@Test
	public void testGetInvitedListIsACopy() {
		Party  party = new Party();
		Person a     = new Person( new String( GLORIA_ESTEFAN ));
		Person b     = new Person( new String( FRANCO_DE_VITA ));

		Person a1    = new Person( new String( GLORIA_ESTEFAN ));
		Person b1    = new Person( new String( FRANCO_DE_VITA ));
		
		party.addInvited( a );
		party.addInvited( b );
		
		ArrayList<Person> list = party.getInvited();
		assertEquals( "Incorrect result", 2, list.size() );
		assertTrue  ( "Incorrect result", list.contains( a1 ));
		assertTrue  ( "Incorrect result", list.contains( b1 ));
		
		list.clear();
		
		list = party.getInvited();
		
		assertEquals( "Incorrect result", 2, list.size() );
		assertTrue  ( "Incorrect result", list.contains( a1 ));
		assertTrue  ( "Incorrect result", list.contains( b1 ));
	}

	@Test
	public void testGetInvitedModifyNamesAfterAdded() {
		Party  party = new Party();
		Person a     = new Person( new String( KANY_GARCIA   ));
		Person b     = new Person( new String( LAURA_PAUSINI ));

		Person a1    = new Person( new String( KANY_GARCIA   ));
		Person b1    = new Person( new String( LAURA_PAUSINI ));
		
		party.addInvited( a );
		party.addInvited( b );

		a.setName( new String( LUIS_MIGUEL  ));
		b.setName( new String( LU ));
		
		ArrayList<Person> list;
		
		list = party.getInvited();
		assertEquals( "Incorrect result", 2, list.size() );
		assertTrue  ( "Incorrect result", list.contains( a1 ));
		assertTrue  ( "Incorrect result", list.contains( b1 ));
	}

	@Test
	public void testGetInvitedModifyNamesReturned() {
		Party  party = new Party();
		Person a     = new Person( new String( KANY_GARCIA   ));
		Person b     = new Person( new String( LAURA_PAUSINI ));

		party.addInvited( a );
		party.addInvited( b );
		
		ArrayList<Person> list = party.getInvited();
		assertEquals( 2, list.size() );
		for (Person p : list) {
			p.setName( new String( MIGUEL_RIOS ));
		}
		
		list = party.getInvited();
		assertEquals( "Incorrect result", 2, list.size() );
		assertTrue  ( "Incorrect result", list.contains( a ));
		assertTrue  ( "Incorrect result", list.contains( b ));
	}

	@Test
	public void testGetInvitedSorted() {
		Party  party = new Party();
		Person a     = new Person( new String( LAURA_PAUSINI ));
		Person b     = new Person( new String( BELINDA       ));
		Person c     = new Person( new String( KANY_GARCIA   ));
		Person d     = new Person( new String( JESSE       ));
		
		party.addInvited( a );
		party.addInvited( b );
		party.addInvited( c );
		party.addInvited( d );
		
		ArrayList<Person> list = party.getInvited();
		assertEquals( "Incorrect result", 4, list.size() );
		
		Collections.sort( list );
		
		assertEquals( "Incorrect result", 0, list.indexOf( b ));
		assertEquals( "Incorrect result", 1, list.indexOf( d ));
		assertEquals( "Incorrect result", 2, list.indexOf( c ));
		assertEquals( "Incorrect result", 3, list.indexOf( a ));
	}

	@Test
	public void testGetRSVPAddingInvitedAndNotInvited() {
		Party  party = new Party();
		Person a     = new Person( new String( NATALIA_LAFOURCADE ));
		Person b     = new Person( new String( MANA      ));
		Person c     = new Person( new String( PATXI_ANDION       ));
		
		party.addInvited( a );
		party.addInvited( b );

		party.addRSVP   ( b );
		party.addRSVP   ( c );
		
		ArrayList<Person> list = party.getRSVP();
		assertEquals( "Incorrect result", 1, list.size() );
		assertTrue  ( "Incorrect result", list.contains( b ));
	}

	@Test
	public void testGetRSVPAddingRSVPTwice() {
		Party  party = new Party();
		Person a     = new Person( new String( KANY_GARCIA   ));
		Person b     = new Person( new String( LAURA_PAUSINI ));
		
		party.addInvited( a );
		party.addInvited( b );
		
		party.addRSVP( a );
		party.addRSVP( a );

		ArrayList<Person> list = party.getRSVP();
		assertEquals( "Incorrect result", 1, list.size() );
	}

	@Test
	public void testGetRSVPListIsACopy() {
		Party  party = new Party();
		Person a     = new Person( new String( GLORIA_ESTEFAN ));
		Person b     = new Person( new String( FRANCO_DE_VITA ));
		
		party.addInvited( a );
		party.addInvited( b );

		party.addRSVP( a );
		
		ArrayList<Person> list;
		
		list = party.getRSVP();
		assertEquals( "Incorrect result", 1, list.size() );
		assertTrue  ( "Incorrect result", list.contains( a ));
		
		list.clear();
		
		list = party.getRSVP();
		assertEquals( "Incorrect result", 1, list.size() );
		assertTrue  ( "Incorrect result", list.contains( a ));
	}


	@Test
	public void testGetRSVPModifyNamesAfterAdded() {
		Party  party = new Party();
		Person a1 = new Person( new String( KANY_GARCIA   ));
		Person a2 = new Person( new String( KANY_GARCIA   ));
		
		party.addInvited( a1 );
		party.addRSVP   ( a1 );

		a1.setName( new String( LUIS_MIGUEL  ));
		
		ArrayList<Person> list = party.getRSVP();
		System.out.println(list.get(0).getName());
		assertEquals( "Incorrect result", 1, list.size() );
		assertTrue  ( "Incorrect result", list.contains( a2 ));
	}

	@Test
	public void testGetRSVPModifyNamesReturned() {
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

	@Test
	public void testGetRSVPSorted() {
		Party  party = new Party();
		Person a     = new Person( new String( LAURA_PAUSINI ));
		Person b     = new Person( new String( BELINDA       ));
		Person c     = new Person( new String( KANY_GARCIA   ));
		Person d     = new Person( new String( JESSE       ));
		
		party.addInvited( a );
		party.addInvited( b );
		party.addInvited( c );
		party.addInvited( d );

		party.addRSVP( a );
		party.addRSVP( c );
		
		ArrayList<Person> list;
		Person            person;
		
		list = party.getRSVP();
		assertEquals( "Incorrect result", 2, list.size() );
		
		Collections.sort( list );
		
		person = list.get( 0 );
		assertEquals( "Incorrect result", c, person );
		
		person = list.get( 1 );
		assertEquals( "Incorrect result", a, person );
	}

}
