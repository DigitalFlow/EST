package InsertionSort;
import General.*;

public class InsertionSort {

	public static void sort(int[] input)
	{
		for(int i = 0; i < input.length; i++)
		{
			for(int j = i+1; j < input.length; j++)
			{
				int x = 0;
				while(i-x >= 0 && input[j] < input[i-(x++)]){
					Utils.swap(i, j, input);
				}
			}
		}
	}
	
}
