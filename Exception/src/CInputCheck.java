import java.util.Scanner;

public class CInputCheck {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		boolean success = false;

		do {
			try {
				int zahl = ReadIn(in);
				System.out.println("Die Zahl lautet: " + zahl);
				success = true;
			} catch (Exception e) {
				System.out
						.println("Zahl war nicht zwischen 0 und 255, bitte Eingabe wiederholen!");
			} 
		} while (!success);
		
		in.close();
	}

	private static int ReadIn(Scanner in) throws CPruefeZahlException {
		int zahl = -1;

		do {
			System.out.print("Eingabe einer Zahl zwischen 0 und 255: ");
			zahl = in.nextInt();

			if (zahl < 0 || zahl > 255) {
				throw new CPruefeZahlException();
			}
		} while (zahl < 0 || zahl > 255);

		return zahl;
	}
}
