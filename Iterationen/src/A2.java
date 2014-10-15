import java.util.Scanner;

public class A2 {
	public static void main(String[] args) {
		int lowerLimit = 0;
		int upperLimit = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Bitte geben Sie das untere Limit ein:\t\t");
		lowerLimit = scanner.nextInt();
		
		System.out.println("Bitte geben Sie das obere Limit ein:\t\t");
		int temp = scanner.nextInt();
		
		while(temp <= lowerLimit)
		{
			System.out.println("Das obere Limit muss größer als das untere sein!");
			temp = scanner.nextInt();
		}
		
		upperLimit = temp;
		
		for(int i = lowerLimit; i <= upperLimit; i++)
		{
			if(i % 2 != 0)
			{
				System.out.println("Ungerade: "+i);
			}
		}
		
		scanner.close();
	}
}
