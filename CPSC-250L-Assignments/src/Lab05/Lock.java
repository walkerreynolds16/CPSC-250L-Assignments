package Lab05;

public class Lock {
	
	/***
	 * 
	 * Author: Walker Reynolds
	 * Version: 102115
	 */
	
	protected Combination combo; //field for the combination object
	private int upper; //the upper limit of the dial
	private boolean opened; //whether the lock is open or not

	
	public Lock(int upper, Combination combo){// constructor checks if all the numbers are within range, if yes, throw InvalidLockCombinationException
		
		if(!combo.isWithinRange(upper)){
			InvalidLockCombinationException e = new InvalidLockCombinationException();
			throw e;
		}
		
		
		this.upper = upper;
		this.combo = combo;
		opened = true;
	}
	
	public int getDialLimit(){// return upper field
		return upper;
	}
	
	public void open(Combination newCombo){// if the inputed combo is equal to the field combo, set the open boolean to true
		if(newCombo.equals(this.combo)){
			opened = true;
		}
	}
	
	public void close(){ // make the open boolean equal to false
		opened = false;
	}
	
	public boolean isOpen(){// return open boolean
		return opened;
	}
	
	public Combination getCombination(){ //return combp field
		return combo;
	}
}
