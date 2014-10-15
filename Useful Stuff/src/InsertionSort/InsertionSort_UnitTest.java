package InsertionSort;

import java.util.Arrays;
import General.*;

import org.junit.Assert;
import org.junit.Test;

public class InsertionSort_UnitTest {
	
	@Test
	public void test_if_sort_works()
	{
		int first = (int)(Math.random()*50);
		int second = (int)(Math.random()*50);
		int third = (int)(Math.random()*50);
		int fourtht = (int)(Math.random()*50);
		int fifth = (int)(Math.random()*50);
		
		int[] testNumbers = {first, second, third, fourtht, fifth};
		int[] sortRight = {first, second, third, fourtht, fifth};
		InsertionSort.sort(testNumbers);
		Arrays.sort(sortRight);
		
		Assert.assertArrayEquals(sortRight, testNumbers);
	}
	
	@Test
	public void test_if_swap_works()
	{
		int[] testArray = {1, 2, 3, 4};
		Utils.swap(0, 3, testArray);
		int[] desired = {4, 2, 3, 1};
		Assert.assertArrayEquals(desired, testArray);
	}
}
