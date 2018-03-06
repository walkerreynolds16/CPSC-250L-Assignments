package Lab08;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.lang.reflect.Field;

import org.junit.Test;

public class ListExampleTest {
	@Test
	public void testReflection() {
		Class<?> iClass  = ListExample.class;
		Field[]  iFields = iClass.getDeclaredFields();

		for (Field f : iFields) {
			if (!f.isSynthetic()) {
				fail( "Class shouldn't have any fields [found: \""+f.getName()+"\"]" );
			}
		}
	}
	@Test
	public void testNull() {
		Node<Character> actual = ListExample.getUppercaseList( null );
		//expected: NULL
		assertEquals( "", null, actual );
	}
	@Test
	public void test1of1() {
		Node<Character> A = new Node<Character>( 'A', null );
		// expected: A 
		Node<Character> actual = ListExample.getUppercaseList( A );
		assertEquals( "",  A,   actual      );
		assertEquals( "", null, actual.next );
	}
	@Test
	public void test0of1() {
		Node<Character> a = new Node<Character>( 'a', null );
		// expected: NULL
		Node<Character> actual = ListExample.getUppercaseList( a );
		assertEquals( "", null, actual );
	}
	@Test
	public void test0of3() {
		Node<Character> b = new Node<Character>( 'b' );
		Node<Character> a = new Node<Character>( 'a' );
		Node<Character> r = new Node<Character>( 'r' );
		b.next = a;
		a.next = r;
		r.next = null;
		// expected: NULL
		Node<Character> actual = ListExample.getUppercaseList( b );
		assertEquals( "", null, actual );
	}
	@Test
	public void test3of3() {
		Node<Character> B = new Node<Character>( 'B' );
		Node<Character> A = new Node<Character>( 'A' );
		Node<Character> M = new Node<Character>( 'M' );
		B.next = A;
		A.next = M;
		M.next = null;
		// expected: B -> A -> M
		Node<Character> actual = ListExample.getUppercaseList( B );
		Node<Character> now    = actual;
		assertEquals( "", B,    now      );
		assertEquals( "", A,    now.next );
		now = now.next;
		assertEquals( "", M,    now.next );
		now = now.next;
		assertEquals( "", null, now.next );
	}
	@Test
	public void test2of4() {
		Node<Character> b = new Node<Character>( 'b' );
		Node<Character> L = new Node<Character>( 'L' );
		Node<Character> a = new Node<Character>( 'a' );
		Node<Character> H = new Node<Character>( 'H' );
		b.next = L;
		L.next = a;
		a.next = H;
		H.next = null;
		// expected: L -> H
		Node<Character> actual = ListExample.getUppercaseList( b );
		Node<Character> now    = actual;
		assertEquals( "", L,    now      );
		assertEquals( "", H,    now.next );
		now = now.next;
		assertEquals( "", null, now.next );
	}
	@Test
	public void testBroccoli() {
		@SuppressWarnings("unchecked")
		Node<Character>[] nodes = new Node[]{ 
				new Node<Character>( 'B' ), // 0
				new Node<Character>( 'r' ), // 1
				new Node<Character>( 'o' ), // 2
				new Node<Character>( 'C' ), // 3
				new Node<Character>( 'c' ), // 4
				new Node<Character>( 'o' ), // 5
				new Node<Character>( 'L' ), // 6
				new Node<Character>( 'i', null )
		};
		for (int i = 0; i < nodes.length-1; i++) {
			nodes[ i ].next = nodes[ i+1 ];
		}
		// expected: B -> C -> L
		Node<Character> actual = ListExample.getUppercaseList( nodes[0] );
		Node<Character> now    = actual;
		assertEquals( "", nodes[0], now      ); // B
		assertEquals( "", nodes[3], now.next ); // C
		now = now.next;
		assertEquals( "", nodes[6], now.next ); // L
		now = now.next;
		assertEquals( "", null,     now.next );
	}
	@Test
	public void testDrEvil() {
		@SuppressWarnings("unchecked")
		Node<Character>[] nodes = new Node[] { 
				new Node<Character>( 'd' ), // 0
				new Node<Character>( 'R' ), // 1
				new Node<Character>( 'E' ), // 2
				new Node<Character>( 'v' ), // 3
				new Node<Character>( 'I' ), // 4
				new Node<Character>( 'l', null )
		};
		for (int i = 0; i < nodes.length-1; i++) {
			nodes[ i ].next = nodes[ i+1 ];
		}
		// expected: D -> E -> I
		Node<Character> actual = ListExample.getUppercaseList( nodes[0] );
		Node<Character> now    = actual;
		assertEquals( "", nodes[1], now      ); // R
		assertEquals( "", nodes[2], now.next ); // E
		now = now.next;
		assertEquals( "", nodes[4], now.next ); // I
		now = now.next;
		assertEquals( "", null,     now.next );
	}
	@Test
	public void testAbracadrabra() {
		@SuppressWarnings("unchecked")
		Node<Character>[] nodes = new Node[]{ 
				new Node<Character>( 'A' ), // 0
				new Node<Character>( 'b' ), // 1
				new Node<Character>( 'R' ), // 2
				new Node<Character>( 'A' ), // 3
				new Node<Character>( 'C' ), // 4
				new Node<Character>( 'a' ), // 5
				new Node<Character>( 'D' ), // 6
				new Node<Character>( 'a' ), // 7
				new Node<Character>( 'B' ), // 8
				new Node<Character>( 'R' ), // 9
				new Node<Character>( 'a', null )
		};
		for (int i = 0; i < nodes.length-1; i++) {
			nodes[ i ].next = nodes[ i+1 ];
		}
		// expected: A -> R -> A -> C -> D -> B -> R
		Node<Character> actual = ListExample.getUppercaseList( nodes[0] );
		Node<Character> now    = actual;
		assertEquals( "", nodes[0], now      ); // A
		assertEquals( "", nodes[2], now.next ); // R
		now = now.next;
		assertEquals( "", nodes[3], now.next ); // A
		now = now.next;
		assertEquals( "", nodes[4], now.next ); // C
		now = now.next;
		assertEquals( "", nodes[6], now.next ); // D
		now = now.next;
		assertEquals( "", nodes[8], now.next ); // B
		now = now.next;
		assertEquals( "", nodes[9], now.next ); // R
		now = now.next;
		assertEquals( "", null,     now.next );
	}

}
