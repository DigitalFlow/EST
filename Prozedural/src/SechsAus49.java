import java.util.Scanner;

import QuickSort.QuickSort;

public class SechsAus49 {

	public static boolean contains(int wert, int[] zahlen) {
		boolean result = false;
		for (int i = 0; i < zahlen.length; i++) {
			if (zahlen[i] == wert) {
				result = true;
				break;
			}
		}
		return result;
	}
	
	public static void greeter()
	{
		System.out.println("*************************** Lottospiel ***************************");
		System.out.println("* Sie können einen Lottoschein für das Spiel 6 aus 49 ausfüllen. *");
		System.out.println("* Anschließend simuliert der Rechner die Ziehung der Lottozahlen *");
		System.out.println("* und ermittelt, wie viele Zahlen Sie richtig getippt haben.     *");
		System.out.println("******************************************************************");
	}

	public static int[] generateNumbers() {
		System.out.println("Ziehung der Lottozahlen gestartet:");
		int[] lottoZahlen = new int[7];
		for (int i = 0; i < lottoZahlen.length; i++) {
			int zufall = (int) (Math.random() * 50) + 1;
			if (contains(zufall, lottoZahlen)) {
				i--;
				continue;
			}
			lottoZahlen[i] = zufall;
		}
		System.out.print("Lottozahlen:\t");
		for (int i = 0; i < lottoZahlen.length-1; i++)
		{
			System.out.print(lottoZahlen[i]+"\t");
		}
		System.out.println("\nZusatzzahl:\t"+lottoZahlen[lottoZahlen.length-1]);
		System.out.println("Ziehung beendet.");
		return lottoZahlen;
	}

	public static int[] getGuesses() {
		int numberGuess = 0;
		int[] guesses = new int[6];
		boolean result;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Geben Sie jetzt ihre Zahlen ein:");
		
		int i = 1;
		do {
			System.out.print(i + ". Zahl:\t");
			numberGuess = scanner.nextInt();
			result = contains(numberGuess, guesses)
					|| (numberGuess > 49 || numberGuess < 1);
			if (result) {
				System.out
						.println("\nEingabe muss zwischen 1 und 49 liegen, Duplikate sind verboten!\nBitte Eingabe wiederholen!");
			} else {
				guesses[i-1] = numberGuess;
				i++;
			}
		} while (result || i < 7);
		
		System.out.println("\nFolgende Lottozahlen haben Sie getippt:");
		QuickSort.sort(guesses);
		for (int j : guesses) {
			System.out.print(j+"\t");
		}
		System.out.println();
		scanner.close();
		return guesses;
	}
	
	public static void compareGuessToResult(int[] guesses, int[] result)
	{
		System.out.println("Folgende Lottozahlen wurden gezogen:");
		int temp = result[result.length-1];
		result[result.length-1] = Integer.MAX_VALUE;
		QuickSort.sort(result);
		result[result.length-1] = temp;
		
		for(int j : result)
		{
			System.out.print(j+"\t");
		}
		
		int count = 0;
		for(int i : guesses)
		{
			if(contains(i, result))
			{
				count++;
			}
		}
		System.out.println("\nIhr Tipp enthält "+count+" Richtige.");
	}
	
	public static void main(String[] args) {
		greeter();
		int[] guesses = getGuesses();
		int[] result = generateNumbers();
		compareGuessToResult(guesses, result);
		System.out.println("Programmende");
	}
}
