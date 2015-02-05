package implementierungen;

import interfaces.Drucker;

public class Laserdrucker implements Drucker {
	private static int anzahl = 0;
	private String geraeteId;
	
	public Laserdrucker()
	{
		anzahl++;
		geraeteId = "Drucker" + anzahl;
	}

	@Override
	public void drucken(String text) {
		System.out.println("Drucker + " + geraeteId + " meldet sich");
		System.out.println("Das Drucken wird simuliert");
		System.out.println(text);
	}
}
