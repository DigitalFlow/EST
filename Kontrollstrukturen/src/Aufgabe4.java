import java.util.Scanner;

public class Aufgabe4 {

	public static void choosePackaging(double kg, double length, double width,
			double height) {
		if (length <= 75 && width <= 75 && height <= 75
				&& (length + width + height) < 150 && kg <= 20) {
			System.out.println("Send via Post");
		}
		else if((length*width*height)<=200000 && kg < 300){
			System.out.println("Send via Train");
		}else{
			System.out.println("Send via Spedition");
		}
	}

	public static void main(String[] args) {
		Scanner Input = new Scanner(System.in);
		System.out
				.println("Please enter how many kg your package weighs: ");
		double kg = Input.nextDouble();
		System.out.println("Please enter the length of your package (cm): ");
		double length = Input.nextDouble();
		System.out.println("Please enter the width of your package (cm): ");
		double width = Input.nextDouble();
		System.out.println("Please enter the height of your package (cm): ");
		double height = Input.nextDouble();
		choosePackaging(kg, length, width, height);
	}
}
