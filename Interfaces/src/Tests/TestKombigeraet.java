package Tests;

import implementierungen.Kombigeraet;

import org.junit.Test;

public class TestKombigeraet {

	@Test
	public void TestSenden()
	{
		Kombigeraet Kombigeraet1 = new Kombigeraet();
		Kombigeraet Kombigeraet2 = new Kombigeraet();
		
		Kombigeraet1.senden("Dies ist ein Test");
		Kombigeraet2.senden("Dies ist ein Test");
	}
	
	@Test
	public void TestDrucken()
	{
		Kombigeraet Kombigeraet3 = new Kombigeraet();
		Kombigeraet Kombigeraet4 = new Kombigeraet();
		
		Kombigeraet3.drucken("Dies ist ein Test");
		Kombigeraet4.drucken("Dies ist ein Test");
	}
}
