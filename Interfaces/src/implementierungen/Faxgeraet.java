package implementierungen;

import interfaces.Fax;

public class Faxgeraet implements Fax {
	
	private static int anzahl = 0;
	private String geraeteId;
	
	public Faxgeraet()
	{
		anzahl++;
		geraeteId = "Fax" + anzahl;
	}

	@Override
	public void senden(String text) {
		System.out.println("Absender ist: " + geraeteId);
		System.out.println("Das Senden wird simuliert");
		System.out.println(text);
	}
	
	
	
}
