package Lab05;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class LockTest {

	@Test
	public void testReflection() {
		Class<?> iClass     = Lock.class;
		Field[]  iFields    = iClass.getDeclaredFields();
		int      fProtected = 0;

		for (Field f : iFields) {
			if (!f.isSynthetic()) {
				assertFalse( "Field \""+f.getName()+"\" can't be static",   Modifier.isStatic ( f.getModifiers() ));
				assertFalse( "Field \""+f.getName()+"\" can't be public",   Modifier.isPublic ( f.getModifiers() ));
				if (!(Modifier.isPrivate( f.getModifiers() ) || Modifier.isProtected( f.getModifiers() ))) {
					fail( "Field \""+f.getName()+"\" should be private or protected" );
				}
				if (Modifier.isProtected( f.getModifiers() )) {
					fProtected++;
				}
			}
		}
		assertEquals( "Only 1 field in the class Lock can be protected (all others are private)", 1, fProtected );
	}
	@Test
	public void testNewLockIsOpenAndHasDialLimit() {
		Combination comb = new Combination( 8, 8, 1 ); 
		Lock        lock = new Lock( 9, comb );
		
		assertTrue( lock.isOpen() );
		
		int expected = 9;
		int actual   = lock.getDialLimit();
		
		assertEquals( "Incorrect result", expected, actual );
	}

	@Test(expected=InvalidLockCombinationException.class)
	public void testNewLockThrowsExceptionWhenCombinationNotWithinLimits() {
		Combination  comb = new Combination( 1, 5, 10 ); 
		new Lock( 5, comb ); // invalid combination. should throw exception.
	}

	@Test
	public void testLockIsOpenWhenNew() {
		Combination comb = new Combination( 0, 0, 7 ); 
		Lock        lock = new Lock( 7, comb );
		assertTrue( "Incorrect result", lock.isOpen() );
	}
	
	@Test
	public void testLockIsNotOpenWhenClosed() {
		Combination comb = new Combination( 3, 0, 6 );
		Lock        lock = new Lock( 7, comb );
		
		lock.close();
		assertFalse( "Incorrect result", lock.isOpen() );
	}

	@Test
	public void testClosedLockIsNotOpenedWithIncorrectCombination() {
		Combination comb = new Combination( 0, 0, 7 ); 
		Lock        lock = new Lock( 7, comb );
		Combination now  = new Combination( 1, 2, 3 ); 
		
		lock.close();
		lock.open( now );
		assertFalse( "Incorrect result", lock.isOpen() );
	}

	@Test
	public void testClosedLockIsOpenedWithCorrectCombination() {
		Combination comb = new Combination( 0, 0, 7 ); 
		Lock        lock = new Lock( 9, comb );
		Combination now  = new Combination( 0, 0, 7 ); 

		lock.close();
		lock.open( now );
		assertTrue( "Incorrect result", lock.isOpen() );
	}

	@Test
	public void testOpenedLockRemainsOpenedWithIncorrectCombination() {
		Combination comb = new Combination( 4, 4, 4 );
		Lock        lock = new Lock( 5, comb );
		Combination now  = new Combination( 8, 8, 8 ); 
		
		lock.open( now );
		assertTrue( "Incorrect result", lock.isOpen() );
	}

}
