package Lab03;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author Walker
 * @version 9/15/15
 *
 */

public class Lab03Three {

	public static void main(String[] args) {
		String[]          values = { "Cars: My best friend's girl", "Jesse & Joy: Chocolate", "Queen: We will rock you", "Rush: YYZ" }; 
		ArrayList<String> list   = new ArrayList<String>( Arrays.asList( values ));
		int[] nums = getLetters(list);
		
		for(int i = 0; i < nums.length; i++){
			System.out.print(nums[i]);
		}
	}
	
	public static int[] getLetters(ArrayList<String> list){
		int[] nums = new int[26];
		for(int i = 0; i < nums.length; i++){
			nums[i] = 0;
		}
		
		for(int i = 0; i < list.size(); i++){
			for(int k = 1; k <= list.get(i).length(); k++){
				if(list.get(i).substring(k-1, k).equalsIgnoreCase("a")){
					nums[0] += 1;
				}else if(list.get(i).substring(k-1, k).equalsIgnoreCase("b")){
					nums[1] += 1;
				}else if(list.get(i).substring(k-1, k).equalsIgnoreCase("c")){
					nums[2] += 1;
				}else if(list.get(i).substring(k-1, k).equalsIgnoreCase("d")){
					nums[3] += 1;
				}else if(list.get(i).substring(k-1, k).equalsIgnoreCase("e")){
					nums[4] += 1;
				}else if(list.get(i).substring(k-1, k).equalsIgnoreCase("f")){
					nums[5] += 1;
				}else if(list.get(i).substring(k-1, k).equalsIgnoreCase("g")){
					nums[6] += 1;
				}else if(list.get(i).substring(k-1, k).equalsIgnoreCase("h")){
					nums[7] += 1;
				}else if(list.get(i).substring(k-1, k).equalsIgnoreCase("i")){
					nums[8] += 1;
				}else if(list.get(i).substring(k-1, k).equalsIgnoreCase("j")){
					nums[9] += 1;
				}else if(list.get(i).substring(k-1, k).equalsIgnoreCase("k")){
					nums[10] += 1;
				}else if(list.get(i).substring(k-1, k).equalsIgnoreCase("l")){
					nums[11] += 1;
				}else if(list.get(i).substring(k-1, k).equalsIgnoreCase("m")){
					nums[12] += 1;
				}else if(list.get(i).substring(k-1, k).equalsIgnoreCase("n")){
					nums[13] += 1;
				}else if(list.get(i).substring(k-1, k).equalsIgnoreCase("o")){
					nums[14] += 1;
				}else if(list.get(i).substring(k-1, k).equalsIgnoreCase("p")){
					nums[15] += 1;
				}else if(list.get(i).substring(k-1, k).equalsIgnoreCase("q")){
					nums[16] += 1;
				}else if(list.get(i).substring(k-1, k).equalsIgnoreCase("r")){
					nums[17] += 1;
				}else if(list.get(i).substring(k-1, k).equalsIgnoreCase("s")){
					nums[18] += 1;
				}else if(list.get(i).substring(k-1, k).equalsIgnoreCase("t")){
					nums[19] += 1;
				}else if(list.get(i).substring(k-1, k).equalsIgnoreCase("u")){
					nums[20] += 1;
				}else if(list.get(i).substring(k-1, k).equalsIgnoreCase("v")){
					nums[21] += 1;
				}else if(list.get(i).substring(k-1, k).equalsIgnoreCase("w")){
					nums[22] += 1;
				}else if(list.get(i).substring(k-1, k).equalsIgnoreCase("x")){
					nums[23] += 1;
				}else if(list.get(i).substring(k-1, k).equalsIgnoreCase("y")){
					nums[24] += 1;
				}else if(list.get(i).substring(k-1, k).equalsIgnoreCase("z")){
					nums[25] += 1;
				}
			}
		}
		
		
		
		return nums;
	}

}
