import java.util.Scanner;

public class Aufgabe3 {

	public static double childMoney(double income, int childNum) {
		int childMoney = 0;

		if (income < 45000) {
			for (int i = childNum; i > 0; i--) {
				if (i >= 4) {
					childMoney += 240;
				} else if (i == 3) {
					childMoney += 220;
				} else if (i == 2) {
					childMoney += 130;
				} else if (i == 1) {
					childMoney += 70;
				}
			}
		} else {
			for (int i = childNum; i > 0; i--) {
				if (i >= 4) {
					childMoney += 240;
				} else if (i == 3) {
					childMoney += 220;
				} else if (i == 2) {
					childMoney += 130;
				} else if (i == 1) {
					childMoney += 70;
				}
			}
		}
		return childMoney;
	}

	public static void main(String[] args) {
		Scanner Input = new Scanner(System.in);
		System.out.println("Please enter how many children you have: ");
		int childNum = Input.nextInt();
		System.out.println("Please enter your income in D$: ");
		double income = Input.nextDouble();
		double result = childMoney(income, childNum);
		System.out.println(result);
	}
}
