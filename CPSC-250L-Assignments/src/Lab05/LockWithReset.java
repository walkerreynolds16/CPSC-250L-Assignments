package Lab05;

import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class LockWithReset extends Lock {
	/***
	 * 
	 * Author: Walker Reynolds
	 * Version: 102115
	 */

	public LockWithReset(int upper, Combination combo) {
		super(upper, combo); //uses the super class constructor 
		
	}
	
	//Resets the combination without catching exceptions
	public void resetNaive(){
		String newCombo = JOptionPane.showInputDialog(null, "Type a new combination"); //uses the static method from JOptionPane to get input screen
		
		if(newCombo != null){// if the user didn't press cancel or close the window, continue
			
			Scanner scan = new Scanner(newCombo);// create new scanner object to scan through the input string
			scan.useDelimiter(" ");// set the delimiter to an open space so scanner knows where to separate the integers
			
			int[] array = new int[3]; // new int array for the 3 combination numbers
			int i = 0; // count variable to know whether there were 3 numbers inputed or not
			
				
				
			while(scan.hasNext()){// while loop that iterates over the input string
				try {
					array[i] = Integer.parseInt(scan.next()); // if the input is a number, we put it in the array
				}catch(NumberFormatException e){// if the input is not a number, catch the exception and throw the noSuchElementException
					throw new NoSuchElementException();				
				}
					
				i++;
			}
			
			scan.close();
			if(i != 3){// if i isn't three, then there was a problem with the new combination, throw noSuchElementException
				throw new NoSuchElementException();
			}
				
			Combination returnCombo = new Combination(array[0], array[1], array[2]); //make a new Combination with the inputed numbers
				
			if(!returnCombo.isWithinRange(getDialLimit())){// if the new combination is not within range, throw InvalidLockCombinationException
				throw new InvalidLockCombinationException();
			}
				
			combo = returnCombo;// make combo equal to the new combo
			
		}
		
	}
	
	//does the same as resetNaive, but will catch the exceptions and let the user retry the input
	public void resetRetry(){
		
		boolean go = true; //boolean to keep the while loop running
		
		while(go){
			try{
				resetNaive(); //reuse the reset Naive method
				
			}catch(NoSuchElementException e){// catch the NoSuchElement Exception and display a dialog to tell the user what went wrong
				
				JOptionPane.showMessageDialog(null, "Type 3 integers separated by spaces");
				continue; // go back through the while loop
				
			}catch(InvalidLockCombinationException e){//catch the InvalidLockCombinationException and display a dialog to tell the user what went wrong
				
				JOptionPane.showMessageDialog(null, "Type 3 integers in the range [0.." + getDialLimit() + "]");
				continue;
				
			}
			
			go = false;// if it goes through the whole loop, set the boolean to false
		}
		
	}
	
	
	public static void main(String[] args){
		Combination c = new Combination( 1, 2, 3 );
		LockWithReset lock = new LockWithReset( 5, c );
		lock.resetRetry();
		System.out.println(lock.getCombination().toString());
	}
	
	

}
