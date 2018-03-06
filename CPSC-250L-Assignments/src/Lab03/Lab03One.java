package Lab03;

import java.util.Arrays;

public class Lab03One {
	
	public static void main(String[] args){
		Character[] array = new Character[] { '0', '0', '7', 'R', '2', 'D', '2' };
		Character[] nArray = getDigits(array);
		for(int i = 0; i< nArray.length; i++){
			System.out.println(nArray[i]);
		}
	}

	public static Double getMedian(Integer[] array){
		Double median = 0.0;
		Arrays.sort(array);
		if(array.length == 0){
			return median;
		}else if(array.length % 2 == 1){
			median = (double)(array[(array.length / 2 -1) + 1]);
			return median;
		}else {
			median = (double) (array[(array.length / 2-1)] + array[(array.length / 2)]);
			return median /2;
		}
	}
	
	public static Character[] getDigits(Character[] array){
		int count = 0;
		for(int i = 0; i < array.length; i++){
			if(Character.isDigit((char)array[i])){
				count++;
			}
		}
		Character[] nArray = new Character[count];
		int count2 = 0;
		for(int i = 0; i < array.length; i++){
			if(Character.isDigit((char)array[i])){
				nArray[count2] = array[i];
				count2++;
			}
		}
		
		return nArray;
	}
}
