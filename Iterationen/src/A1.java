import java.util.ArrayList;
import java.util.Scanner;


public class A1 {
	
	
	public static void main(String[] args) {
		ArrayList<Float> list = new ArrayList<Float>();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Bitte geben Sie die zu addierenden Gleitkommazahlen ein und beenden Sie die Eingabe mittels 0:");
		
		float insert = scanner.nextFloat();
		
		while(insert != 0){
			list.add(insert);
			insert = scanner.nextFloat();
		}
		scanner.close();
		
		float result = 0;
		for (Float value : list) {
			result += value;
		}
		
		System.out.println(result+", Durchschnitt: " +result/list.size());
	}
}
