package Lab06;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LineNumbers {

	
	public static void process(File input, File output){
		
		try{
			Scanner scan = new Scanner(input);
			int count = 1;
			PrintWriter writer = new PrintWriter(output);
			
			while(scan.hasNextLine()){
				String line = scan.nextLine();
				
				writer.printf("%3d | %s\r\n", count, line);
				count++;
			}
			
			
			writer.close();
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}
}
