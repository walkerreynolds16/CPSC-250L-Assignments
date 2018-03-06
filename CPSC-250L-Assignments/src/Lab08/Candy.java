package Lab08;

public class Candy {

private final String flavor;
	
	public Candy (String _flavor) {
		flavor = _flavor;
	}
	@Override
	public String toString() {
		return flavor;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Candy) {
			Candy other = (Candy) obj;
			if (flavor == other.flavor) {
				return true;
			}
		}
		return false;
	}
}
