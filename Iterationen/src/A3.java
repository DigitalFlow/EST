import java.util.Scanner;


public class A3 {
	public static void main(String[] args) {
		long input = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Bitte geben Sie eine Zahl ein:");
		
		input = scanner.nextLong();
		
		while(input <= 0)
		{
			System.out.println("Bitte geben Sie eine positive Zahl größer Null ein:");
			input = scanner.nextLong();
		}
		
		boolean result = true;
		
		for(long l = 2; l*l <= input; l++){
			if(input % l == 0)
			{
				result = false;
				break;
			}
		}
		if(result)
		{
			System.out.println(input + " ist eine Primzahl!");
		}
		else
		{
			System.out.println("Ist keine Primzahl!");
		}
		
		scanner.close();
	}
}
