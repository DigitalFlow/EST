import java.util.Scanner;

public class Tore {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int tore[];
		int anzahlSpiele = 0;
		int sum = 0;
		int medianTore = 0;

		System.out
				.println("Das Programm berechnet die mittlere Toranzahl...\n");

		do {
			System.out.print("Geben Sie die Anzahl der Spiele ein: ");
			anzahlSpiele = in.nextInt();
			
			if (anzahlSpiele == 0) {
				System.out.println("Anzahl der Spiele muss ungleich 0 sein!");
			}
		} while (anzahlSpiele == 0);

		tore = new int[anzahlSpiele];

		for (int i = 0; i < tore.length; i++) {
			boolean success = false;

			do {
				System.out.printf("Toranzahl %2d.tes Spiel: ", i + 1);

				try {
					tore[i] = in.nextInt();
					success = true;
				} catch (Exception e) {
					System.out
							.println("Eingabe fehlerhaft, bitte probieren Sie es erneut, nur Zahlen sind erlaubt!");
				}
			} while (!success);
		}

		in.close();

		for (int i = 0; i < tore.length; i++) {
			sum = sum + tore[i];
		}

		medianTore = sum / tore.length;
		System.out.println("Durchschnittlich erzielte Tore: " + medianTore);
	}

}
