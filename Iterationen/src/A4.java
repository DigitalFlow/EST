import java.util.ArrayList;
import java.util.Scanner;

public class A4 {
	public static void main(String[] args) {
		int first = 0;
		int second = 0;

		Scanner scanner = new Scanner(System.in);

		System.out.println("Bitte geben Sie die erste Zahl ein!");
		first = scanner.nextInt();

		System.out.println("Bitte geben Sie die zweite Zahl ein!");
		second = scanner.nextInt();

		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < Math.abs(second); i++) {
			list.add(Math.abs(first));
		}

		int result = 0;
		for (int value : list) {
			result += value;
		}

		if (first < 0 && second < 0) {
			System.out.println("Ergebnis: " + result);
		} else if (first < 0 ^ second < 0) {
			System.out.println("Ergebnis: " + (0 - result));
		} else {
			System.out.println("Ergebnis: " + result);
		}
	}
}