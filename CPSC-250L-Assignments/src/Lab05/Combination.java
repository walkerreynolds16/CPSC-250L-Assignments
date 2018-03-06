package Lab05;

import java.util.Arrays;

public class Combination {
	
	/***
	 * 
	 * Author: Walker Reynolds
	 * Version: 102115
	 */

	private int[] combo = new int[3]; //field for the 3 numbers of the combo
	
	public Combination(int one, int two, int three){ //constructor sets the parameters into the field
		combo[0] = one;
		combo[1] = two;
		combo[2] = three;
		
		
	}
	
	public int[] getNumbers(){// return the array of the combination numbers
		return combo;
	}
	
	public boolean isWithinRange(int upper){// checks if each number is less than the set upper limit and if its bigger than 0
		for(int i = 0; i < combo.length; i++){
			if(!(combo[i] <= upper) || combo[i] < 0){
				return false;
			}
		}
		
		return true;
	}
	
	@Override
	public boolean equals(Object o){//checks if the object is of Combination, and checks if the numbers are the same between the 2 combinaitons
		if(o instanceof Combination){
			if(Arrays.equals(((Combination) o).getNumbers(), this.combo)){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString(){// return the numbers into a string
		String str = "";
		
		for(int i = 0; i < 3; i++){
			str += combo[i] + " ";
		}
		return str;
	}
}
