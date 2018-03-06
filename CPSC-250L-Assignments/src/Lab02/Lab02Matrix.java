package Lab02;

/**
 * Author: Walker Reynolds Version: 09/8/15
 * 
 */

public class Lab02Matrix {

	public static void switchRows(int[][] array) {
		int temp1 = 0;
		for (int i = 0; i < array.length / 2; i++) {
			for (int j = 0; j < array[0].length; j++) {
				temp1 = array[i][j];
				array[i][j] = array[array.length - i - 1][j];
				array[array.length - i - 1][j] = temp1;
			}

		}

	}

	/**
	 * 
	 * @param array
	 */
	public static void switchColumns(char[][] array) {

		char temp = 0;
		for (int i = 0; i < array.length; i++) {
			for (int k = 0; k < array[0].length / 2; k++) {
				temp = array[i][k];
				array[i][k] = array[i][(array[0].length - 1) - k];
				array[i][(array[0].length - 1) - k] = temp;
			}
		}

	}
}
