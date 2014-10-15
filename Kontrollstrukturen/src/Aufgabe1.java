import java.util.Scanner;

public class Aufgabe1 {

	public static void calculateGasUsage()
	{
		double km = 0;
		double usedGasAll = 0;
		
		Scanner Input = new Scanner(System.in);
		System.out.println("Please enter, how many km you drove: ");
		km = Input.nextDouble();
		System.out.println("Please enter, how much gas was used: ");
		usedGasAll = Input.nextDouble();
		
		if(km >= 0)
		{
			double usage = usedGasAll / km * 100;
			System.out.println("You needed "+usage+" l gasoline for "+km+"km.");
		}
		else
		{
			System.out.println("You have to drive a distance to calculate the usage!");
		}
	}
	
	public static void main(String[] args) {
		calculateGasUsage();
	}
	
}
