import java.util.Scanner;

public class MyMethods {
	public static void berechnung() {
		meldung("******************* Maximum *****************************\n");
		meldung("*                                                       *\n");
		meldung("* Das Programm liest zwei Integerwerte von der Tastatur *\n");
		meldung("* ein und ermittelt das Maximum der beiden Zahlen.      *\n");
		meldung("*                                                       *\n");
		meldung("*********************************************************\n");
	}

	public static void meldung(String text) {
		System.out.print(text);
	}

	public static int berechneMaximum(int ersteZahl, int zweiteZahl) {
		return ersteZahl > zweiteZahl ? ersteZahl : zweiteZahl;
	}
	
	public static int berechneMinimum(int ersteZahl, int zweiteZahl) {
		return ersteZahl < zweiteZahl ? ersteZahl : zweiteZahl;
	}

	public static int liesZahl() {
		Scanner scanner = new Scanner(System.in);
		meldung("Geben Sie eine Zahl ein: ");
		int a = scanner.nextInt();

		//scanner.close();

		return a;
	}

	public static int liesZahl(int vergleich) {
		boolean result;
		int b;
		do {
			b = liesZahl();
			result = (b == vergleich);
			if(result)
			{
				meldung("Die zweite Zahl muss eine andere als die erste sein!");
			}
		} while (result);
		return b;
	}
	
	public static void zeigeFeldelemente(int[] werte)
	{
		System.out.println("\nFeldinhalte:");
		for(int i = 0; i < werte.length; i++)
		{
			System.out.println(" feld["+i+"] = "+werte[i]);
		}
	}
}
