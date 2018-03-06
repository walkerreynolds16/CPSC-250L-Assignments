package Lab03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 
 * @author Walker
 * @version 09/9/2015
 * 
 */
public class Lab03Two {
	
	public static void main(String[] args){
		String[]          un   = { "palpatine", "dooku", "vader", "sidius" };
		String[]          duex = { "padme", "vader", "sidius", "ackbar", "padme" };
		ArrayList<String> one  = new ArrayList<String>( Arrays.asList( un ));
		ArrayList<String> two  = new ArrayList<String>( Arrays.asList( duex ));
		
		ArrayList<String> list = Lab03Two.getDifference( one, two );
		
		System.out.println(list);
		
	}
	
	public static int getTally(ArrayList<Integer> list, int number){
		int count = 0;
		for(int i = 0; i < list.size(); i++){
			if(list.get(i) == number){
				count++;
			}
		}
		return count;
	}
	
	public static int getFirstIndex(ArrayList<Integer> list, int number){
		int index = -1;
		for(int i = 0; i < list.size(); i++){
			if(list.get(i) == number){
				index = i;
				break;
			}
		}
		return index;
	}
	
	public static void doReverse(ArrayList<Integer> list){
		
		if(list.size() == 2){
			int temp = list.get(0);
			list.set(0, list.get(1));
			list.set(1, temp);
			return;
		}
		
		for(int i = 0; i < list.size() /2; i++){
			int temp = list.get(i);
			list.set(i, list.get((list.size() -1) - i));
			list.set((list.size() -1) - i, temp);
		}
		
	}
	public static ArrayList<Integer> getSorted(ArrayList<Integer> one, ArrayList<Integer> two, boolean ascendingly){
		ArrayList<Integer> array = new ArrayList<Integer>();
		for(int i = 0; i < one.size(); i++){
			array.add(one.get(i));
		}
		for(int i = 0; i < two.size(); i++){
			array.add(two.get(i));
		}
		
		if(ascendingly){
			Collections.sort(array);
		}else {
			array.sort(Collections.reverseOrder());
		}
		return array;
	}
	public static ArrayList<Integer> getUnion( ArrayList<Integer> one, ArrayList<Integer> two ){
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		
		for(int i = 0; i < one.size(); i++){
			list.add(one.get(i));
		}
		for(int i = 0; i < two.size(); i++){
			list.add(two.get(i));
		}
		for(int i = 0; i < list.size(); i++){
			for(int k = 1 + i; k < list.size(); k++){
				if(list.get(i) == list.get(k)){
					list.remove(k);
					k--;
				}
			}
		}
		return list;
		
	}
	public static ArrayList<Double> getIntersection( ArrayList<Double> one, ArrayList<Double> two ){
		ArrayList<Double> nList = new ArrayList<Double>();
		
		for(int i = 0; i < one.size(); i++){
			for(int k = 0; k < two.size(); k++){
				if(one.get(i).equals(two.get(k))){
					if(!nList.contains(two.get(k))){
						nList.add(two.get(k));
					}
				}
			}
		}
		
		return nList;
	}
	public static ArrayList<String> getDifference( ArrayList<String> one, ArrayList<String> two ){
		ArrayList<String> nList = new ArrayList<String>();
		
		if(one.size() == 0){
			return two;
		}else if(two.size() == 0){
			return one;
		}
		
		for(int i = 0; i < one.size(); i++){
			for(int k = 0; k < two.size(); k++){
				if(!one.contains(two.get(k))){
					if(!nList.contains(two.get(k))){
						nList.add(two.get(k));
					}
				}
				if(!two.contains(one.get(i))){
					if(!nList.contains(one.get(i))){
						nList.add(one.get(i));
					}
				}
			}
		}
		return nList;
	}

}
