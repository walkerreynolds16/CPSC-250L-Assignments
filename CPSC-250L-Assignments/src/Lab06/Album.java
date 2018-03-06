package Lab06;

import java.util.ArrayList;
import java.util.Scanner;

public class Album {
	
	//Album is used to help discography be more efficient 

	private String albumName, authorName, times, timesSum;
	
	public Album(String albumName, String authorName, String times){
		
		//Set Object Fields
		this.albumName = albumName;
		this.authorName = authorName;
		this.times = times;
		timesSum = "";
		
		getSumOfTimes();
		
	}
	
	
	//*****Getters and Setters*********
	public void SetAlbumName(String name){
		albumName = name;
	}
	
	public String getAlbumName(){
		return albumName;
	}
	
	public void setAuthorName(String name){
		authorName = name;
	}
	
	public String getAuthorName(){
		return authorName;
	}
	
	public void setTimes(String times){
		this.times = times;
	}
	
	public String getTimes(){
		return times;
	}
	
	public void setTimesSum(String sum){
		timesSum = sum;
	}
	
	public String getTimesSum(){
		return timesSum;
	}
	
	//method used to get the longest author name for string format padding
	public static int getLongestAuthorName(ArrayList<Album> albums){
		int amount = 0;
		
		for(int i = 0; i < albums.size(); i++){
			if(albums.get(i).getAuthorName().length() > amount){
				amount = albums.get(i).getAuthorName().length();
			}
		}
		
		return amount;
	}
	
	
	//method used to get the longest album name for string format padding
	public static int getLongestAlbumName(ArrayList<Album> albums){
		int amount = 0;
		
		for(int i = 0; i < albums.size(); i++){
			if(albums.get(i).getAlbumName().length() > amount){
				amount = albums.get(i).getAlbumName().length();
			}
		}
		
		return amount;
	}
	
	//returns the sum of the times in the right format
	public void getSumOfTimes(){
		int hours = 0;
		int mins = 0;
		int sec = 0;
		
		Scanner scan = new Scanner(times);
		scan.useDelimiter("\r]n|,");
		
		while(scan.hasNext()){
			String scanNext = scan.next();
			
			
			Scanner spliter = new Scanner(scanNext);
			spliter.useDelimiter(":");
			
			if(containsHowMany(scanNext, ":") == 2){
				hours += Integer.parseInt(spliter.next());
				mins += Integer.parseInt(spliter.next());
				sec += Integer.parseInt(spliter.next());
			}else {
				mins += Integer.parseInt(spliter.next());
				sec += Integer.parseInt(spliter.next());
			}
			
			
			mins += (sec / 60);
			sec = sec % 60;
			
			hours += (mins / 60);
			mins = mins % 60;
			
			
		}
			
		if(getDigits(mins) == 1 && getDigits(sec) == 1){
			timesSum = hours + ":" + "0" + mins + ":" + "0" + sec;
		}else if(getDigits(sec) == 1){
			timesSum = hours + ":" + mins + ":" + "0" + sec;
		}else if(getDigits(mins) == 1){
			timesSum = hours + ":" + "0" + mins + ":" + sec;
		}else {
			timesSum = hours + ":" + mins + ":" + sec;
		}
		
		
		
	}
	
	//method that return how many digits an int has (used in getTimeSum())
	public static int getDigits(int num){
		int count = 0;
		int tempNum = num;
		
		while(tempNum / 10 != 0){
			tempNum /= 10;
			count++;
		}
		
		return count + 1;
	}
	
	//method used to sort the albums by their authors
	public static void sortListsByAuthors(ArrayList<Album> albums){
		//Selection sort used to sort albums by authors
		for(int i = 0; i < albums.size(); i++){
			for(int k = i + 1 ; k < albums.size(); k++){
				if(albums.get(k).getAuthorName().compareToIgnoreCase(albums.get(i).getAuthorName()) == 0){
					
					if(albums.get(k).getAlbumName().compareToIgnoreCase(albums.get(i).getAlbumName()) < 0){
						Album temp = albums.get(i);
						albums.set(i, albums.get(k));
						albums.set(k, temp);
					}
					
				}else if(albums.get(k).getAuthorName().compareToIgnoreCase(albums.get(i).getAuthorName()) < 0){
					Album temp = albums.get(i);
					albums.set(i, albums.get(k));
					albums.set(k, temp);
				}
			}
		}
			
	}
	

	//method used for return how many of a single string are in another(used in getTimesSum())
	public int containsHowMany(String str, String str2){
		int count = 0;
		
		Scanner scan = new Scanner(str);
		scan.useDelimiter("");
		
		while(scan.hasNext()){
			if(scan.next().equals(str2)){
				count++;
			}
		}
		
		return count;
	}
}
