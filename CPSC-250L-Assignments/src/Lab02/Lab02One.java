package Lab02;

import java.util.Arrays;

public class Lab02One {

	public static void main(String[] args) {
		int arrayInt[] = new int[]{80,100,80,92,95,87,82,76,45,76,80,70};
		
		System.out.println("array : " + arrayToString( arrayInt ));
		System.out.println("sum : " + arraySum( arrayInt ));
		System.out.println("average: " + arrayAverage( arrayInt ));
		Arrays.sort( arrayInt );
		System.out.println("sorted : " + arrayToString( arrayInt ));
	}
	
	public static String arrayToString(int[] array){
		String finalString = "[";
		for(int i = 0; i < array.length; i++){
			finalString += array[i] + ", ";
		}
		finalString += "]";
		return finalString;
	}
	
	public static int arraySum(int[] array){
		int sum = 0;
		for(int i = 0; i < array.length; i++){
			sum += array[i];
		}
		return sum;
	}
	
	public static double arrayAverage(int[] array){
		double ave = 0.0;
		int count = 0;
		for(int i = 0; i < array.length; i++){
			ave += array[i];
			count++;
		}
		return (ave / count);
	}

}
