package Tests;

import implementierungen.Laserdrucker;

import org.junit.Test;

public class TestLaserDrucker {
	@Test
	public void TestDrucken()
	{
		Laserdrucker Laserdrucker1 = new Laserdrucker();
		Laserdrucker Laserdrucker2 = new Laserdrucker();
		
		Laserdrucker1.drucken("Dies ist ein Test");
		Laserdrucker2.drucken("Dies ist ein Test");
	}
}
