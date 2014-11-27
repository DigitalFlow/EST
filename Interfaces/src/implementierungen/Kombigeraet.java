package implementierungen;

import interfaces.Drucker;
import interfaces.Fax;

public class Kombigeraet implements Fax, Drucker {

	private static int anzahl = 0;
	private String geraeteId;
	
	public Kombigeraet()
	{
		anzahl++;
		geraeteId = "Kombigerät" + anzahl;
	}

	@Override
	public void senden(String text) {
		System.out.println("Absender ist: " + geraeteId);
		System.out.println("Das Senden wird simuliert");
		System.out.println(text);
	}

	@Override
	public void drucken(String text) {
		System.out.println("Drucker + " + geraeteId + " meldet sich");
		System.out.println("Das Drucken wird simuliert");
		System.out.println(text);
	}
	
}
