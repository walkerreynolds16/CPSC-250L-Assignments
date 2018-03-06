package Lab08;

public class ListExample {

	
	public static Node<Character> getUppercaseList(Node<Character> head){
		
		if(head == null){
			return null;
		}
		
		
		if(Character.isLowerCase(head.value)){
			
			
			
			while(Character.isLowerCase(head.value)){
				if(head.next != (null)){
					head = head.next;
				}else {
					return null;
				}
				 
			}
			
			
			
			
			Node<Character> temp = head.next;
			
			while(temp.next != (null)){
				
				while(Character.isLowerCase(temp.value)){
					if(temp.next != null){
						temp = temp.next;
					}else {
						return head;
					}
					
				}
				
				head.next = temp;
				
			}
			
			return head;
				
			
			
			
			
			
		}else {
			
			Node<Character> temp = head.next;
			
			
			while(temp.next != null){
				
				while(Character.isLowerCase(temp.value)){
					if(temp.next != (null)){
						temp = temp.next;
					}else {
						return null;
					}
					 
				}
				
				head.next = temp;
				temp = temp.next;
			}
			
			return head;
		}
		
	}
	
	public static void main(String[] args){
		/*
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
		
		while(now.next != null){
			System.out.println(now.value);
		}
		
		*/
		
		/*
		Node<Character> B = new Node<Character>( 'B' );
		Node<Character> A = new Node<Character>( 'A' );
		Node<Character> M = new Node<Character>( 'M' );
		B.next = A;
		A.next = M;
		M.next = null;
		// expected: B -> A -> M
		Node<Character> actual = ListExample.getUppercaseList( B );
		
		
		
		*/
		
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
		
		while(actual.next != null){
			System.out.println(actual.value);
			actual = actual.next;
		}
			
	}
}
