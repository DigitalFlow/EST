import java.util.Scanner;

public class A5 {

	private static void limitBiggerZero(int limit) {
		int i;
		int result = 0;
		for (i = 1; result <= limit; i++) {
			result += i;
		}
		i--;
		System.out
				.println("Es wurden " + i + " Durchläufe benötigt: " + result);
	}

	private static void limitNotZero(int limit) {
		int i;
		int result = 1;
		int sign = -1;

		for (i = 1; result <= limit; i++) {
			result += i * sign;
			sign *= -1;
		}
		System.out
				.println("Es wurden " + i + " Durchläufe benötigt: " + result);
	}

	public static void main(String[] args) {
		int limit = 0;
		int method = 0;

		Scanner scanner = new Scanner(System.in);

		System.out.println("Bitte geben Sie einen Grenzwert ein!");

		for (int i = 1; limit == 0 || limit < 0; i++) {
			if (i > 1) {
				System.out
						.println("Bitte geben Sie einen Grenzwert größer Null ein!");
			}
			limit = scanner.nextInt();
		}

		System.out
				.println("Für Methode 1 geben Sie die 1 ein, für Methode 2 die 2:");

		method = scanner.nextInt();

		if (method != 1 && method != 2) {
			method = scanner.nextInt();
		}

		if (method == 1) {
			limitBiggerZero(limit);
		} else {
			limitNotZero(limit);
		}
		scanner.close();
	}
}
