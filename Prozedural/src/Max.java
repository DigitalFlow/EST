
public class Max {
	
	public static void beschreibung()
	{
		MyMethods.meldung("******************* Maximum *****************************\n");
		MyMethods.meldung("*                                                       *\n");
		MyMethods.meldung("* Das Programm liest zwei Integerwerte von der Tastatur *\n");
		MyMethods.meldung("* ein und ermittelt das Maximum der beiden Zahlen.      *\n");
		MyMethods.meldung("*                                                       *\n");
		MyMethods.meldung("*********************************************************\n");
	}
	
	public static void main(String[] args) {
		beschreibung();	
		int a = MyMethods.liesZahl();
		int b = MyMethods.liesZahl(a);
		
		int[] zahlen = new int[2];
		
		zahlen[0] = MyMethods.berechneMaximum(a, b);
		zahlen[1] = MyMethods.berechneMinimum(a, b);
		
		MyMethods.zeigeFeldelemente(zahlen);
	
		System.out.println("\nProgrammende Maximum.");
	}
}
