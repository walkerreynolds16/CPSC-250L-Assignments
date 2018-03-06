package Lab06;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Discography {

	
	public static void writeReport(File input, File output){
		
		try{
			
			Scanner scan = new Scanner(input);
			scan.useDelimiter("\r\n");
			
			ArrayList<Album> albums = new ArrayList<Album>();
			String albumName = "";
			String authorName = "";
			int count = 0;
			
			while (scan.hasNext()){
				
				Scanner spliter = new Scanner(scan.next());
				spliter.useDelimiter("\r\n|\n|,");
				
				albumName = spliter.next();
				authorName = spliter.next();
				String times = "";
				
				while(spliter.hasNext()){
					times += spliter.next() + ",";
				}
				
				//make a new album object with the authors name, album name, and times and add it to an arraylist
				albums.add(new Album(albumName, authorName, times));
				
				count++;
				
				spliter.close();
			}
			
			//sort the arraylist using a static method in Album
			Album.sortListsByAuthors(albums);

			
			PrintWriter writer = new PrintWriter(output);
			
			//establish the longest album and author names for string format padding
			int longestAuthorName = Album.getLongestAuthorName(albums);
			int longestAlbumName = Album.getLongestAlbumName(albums);
			
			//prints to the print writer in the right format
			for(int i = 0; i < albums.size(); i++){
				writer.printf("%-" + longestAuthorName + "s | %-" + longestAlbumName + "s | %s\r\n" , albums.get(i).getAuthorName(), albums.get(i).getAlbumName(), albums.get(i).getTimesSum());
			}
			
			
			writer.close();
			
			
			scan.close();
		}catch(FileNotFoundException e){
			
			e.printStackTrace();
		}
		
	}

}
