import java.util.Scanner;

public class PrimzahlenReihe {

	// public static int[] sieb(int startWert, int anzahl) {
	// boolean[] isPrim = new boolean[1000];
	// int[] primZahlen = new int[anzahl];
	// int k = 0;
	// int counter = 1;
	//
	// for (int i = 2; i < isPrim.length; i++) {
	// isPrim[i-2] = false;
	// }
	//
	// for (int i = 2; i < isPrim.length; i++) {
	// if (!isPrim[i-2]) {
	// for (int j = i*counter; j < isPrim.length; j=++counter*i) {
	// isPrim[j-2] = true;
	// }
	// counter = 1;
	// }
	// }
	//
	// k=0;
	//
	// for(int i = 2; i < isPrim.length; i++)
	// {
	// if(!isPrim[i-2] && i >= startWert)
	// {
	// primZahlen[k++] = i;
	// }
	// if(k >= anzahl)
	// {
	// break;
	// }
	// }
	//
	// return primZahlen;
	// }

	public static boolean isPrim(int input) {
		boolean result = true;

		for (long l = 2; l * l <= input; l++) {
			if (input % l == 0) {
				result = false;
				break;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int startWert = 0;
		int anzahl = 0;

		Scanner Input = new Scanner(System.in);
		System.out.print("Bitte geben Sie einen Startwert ein: ");
		startWert = Input.nextInt();
		System.out
				.println("\nBitte geben Sie die gewünschte Anzahl Primzahlen ein: ");
		anzahl = Input.nextInt();
		System.out.println("\n");

		int k = 0;

		for (int i = startWert; k < anzahl; i++) {
			if (isPrim(i)) {
				System.out.println(i);
				k++;
			}
		}
	}

}
