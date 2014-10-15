package QuickSort;
import General.*;

public class QuickSort {
	
	public static void sort(int[] input)
	{
		qs(0, input.length-1, input);
	}
	
	private static void qs(int l, int r, int[] input)
	{
		if(l < r)
		{
			int i = l+1;
			int j = r;
			int p = input[l];
			
			while(i <= j)
			{
				while(i <= j && input[i] <= p)
				{
					i++;
				}
				while(i <= j && input[j] > p)
				{
					j--;
				}
				if(i < j)
				{
					Utils.swap(i, j, input);
				}
			}
			if(l < j)
			{
				Utils.swap(l, j, input);
				qs(l, j-1, input);
			}
			if(j < r)
			{
				qs(j+1, r, input);
			}
		}
	}
	
}
