package Lab08;

import java.util.LinkedList;
import java.util.List;

public class Queue<T> {

private List<T> list = new LinkedList<T>();
	
	public void enqueue(T value) {
		list.add( value );
	}
	public T dequeue() {
		return list.remove( 0 );
	}
	public boolean isEmpty() {
		return list.isEmpty();
	}
	@Override
	public String toString() {
		return list.toString();
	}
}
