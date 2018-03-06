package Lab06;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CookieJar {
	
	/***
	 * 
	 * Author: Walker Reynolds
	 * Version: 102115
	 */

	public static void cashingIn(File input, File output){
		try{
			Scanner scan = new Scanner(input);
			
			double sum = 0.0;
			int num = 0;
			String type = "";
			
			PrintWriter writer = new PrintWriter(output);
			
			while(scan.hasNext()){
				
				try{
					num = scan.nextInt();
					continue;
					
				}catch(InputMismatchException e){
					type = scan.next();
				}
				
				sum += getSum(num, type);
			}
			
			if(sum == 0){
				writer.print("You have no money in the jar");
			}else {
				writer.printf("You have $%,.2f in the jar", sum);
			}
			
			writer.close();
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public static double getSum(int num, String type){
		double add = 0.0;
		
		if(type.equalsIgnoreCase("penny") || type.equalsIgnoreCase("pennies")){
			add += (0.01 * num);
		}
		
		if(type.equalsIgnoreCase("nickel") || type.equalsIgnoreCase("nickels")){
			add += (0.05 * num);
		}
		
		if(type.equalsIgnoreCase("dime") || type.equalsIgnoreCase("dimes")){
			add += (0.1 * num);
		}
		
		if(type.equalsIgnoreCase("quarter") || type.equalsIgnoreCase("quarters")){
			add += (0.25 * num);
		}
		
		return add;
	}
}
