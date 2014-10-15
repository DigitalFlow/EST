package BubbleSort;

import General.*;

public class BubbleSort {

	public static void sort(int[] input) {
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input.length-i; j++) {
				if(j+1 >= input.length)
				{
					break;
				}
				if (input[j+1] < input[j]) {
					Utils.swap(j, j + 1, input);
				}
			}
		}
	}

}
