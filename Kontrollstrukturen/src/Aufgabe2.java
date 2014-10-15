import java.util.Scanner;


public class Aufgabe2 {
	public static void calculatePostageCosts(double sum){
		double endSum = 0;
		if(sum < 100)
		{
			endSum += 5.5;
		}else if(sum >= 100 && sum <= 200)
		{
			endSum += 3;
		}
		else
		{
			endSum = sum;
		}
		System.out.println("Your order will cost "+endSum+"$, shipping included.");
	}
	
	public static void main(String[] args) {
		Scanner Input = new Scanner(System.in);
		System.out.println("Please enter your invoice amount: ");
		double output = Input.nextDouble();
		calculatePostageCosts(output);
	}
}
