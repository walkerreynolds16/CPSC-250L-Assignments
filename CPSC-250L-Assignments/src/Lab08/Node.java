package Lab08;

public class Node<T> {

	public final T       value;
	public       Node<T> next;
	
	public Node(T _value) {
		this( _value, null );
	}
	public Node(T _value, Node<T> _next) {
		value = _value;
		next  = _next;
	}
	@Override
	public String toString() {
		return "" + value;
	}
	
	public T getValue(){
		return value;
	}
}
