package General;

public class Utils {
	
	public static void swap(int first, int second, int[] input)
	{
		int temp = input[second];
		input[second] = input[first];
		input[first] = temp;
	}
	
}
