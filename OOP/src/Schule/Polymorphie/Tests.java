package Schule.Polymorphie;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {
	
	@Test
	public void TestSort()
	{
		Person[] personen = new Person[5];
		
		Person randy = new Person("Randy", "Marsh");
		Person gerald = new Person("Gerald", "Broflovsky");
		Person eric = new Person("Eric", "Cartman");
		Student stan = new Student("Stan", "Marsh", 123);
		Student kyle = new Student("Kyle", "Broflovsky", 321);
		
		personen[0] = randy;
		personen[1] = gerald;
		personen[2] = eric;
		personen[3] = stan;
		personen[4] = kyle;
		
		System.out.println("Before sort");
		
		Utility.print(personen);
		
		Utility.sortByName(personen);
		
		assertEquals(gerald, personen[0]);
		assertEquals(kyle, personen[1]);
		assertEquals(eric, personen[2]);
		assertEquals(randy, personen[3]);
		assertEquals(stan, personen[4]);
		
		System.out.println("\n\nAfter sort");
		
		Utility.print(personen);
	}
}
