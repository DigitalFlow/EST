package Tests;

import org.junit.*;

import implementierungen.Faxgeraet;


public class TestFaxgeraet {

	@Test
	public void TestDrucken()
	{
		Faxgeraet Fax1 = new Faxgeraet();
		Faxgeraet Fax2 = new Faxgeraet();
		
		Fax1.senden("Dies ist ein Test");
		Fax2.senden("Dies ist ein Test");
	}
	
}
