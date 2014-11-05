package Schule.Polymorphie;

import java.util.Arrays;

public class Utility {
	
	public static void sortByName(Person[] personen)
	{
		Arrays.sort(personen);
	}
	
	public static void print(Person[] personen)
	{
		for(Person person : personen)
		{
			person.print();
		}
	}
	
}
