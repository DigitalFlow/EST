import java.util.Scanner;
import java.text.DecimalFormat;

public class Kopierkosten {

	public static void costs(double fixCosts, int freeCopies,
			double pricePerCopy) {
		DecimalFormat format = new DecimalFormat("0.00");
		System.out
				.println("Kopienanzahl\t\tGesamtkosten in Euro\t\tKosten/Kopie in Euro");

		for (int i = 500; i <= 8000; i += 500) {
			double overallCosts = 0;
			if (i < freeCopies) {
				overallCosts = fixCosts;
			} else {
				overallCosts = fixCosts + (i - freeCopies) * pricePerCopy;
			}
			System.out.println("  " + i + "\t\t\t\t"
					+ format.format(overallCosts) + "\t\t\t\t"
					+ format.format(overallCosts / i));
		}
	}
	
	private static double readFixCosts()
	{
		System.out.print("Fixkosten in Euro:\t\t");
		Scanner scanner = new Scanner(System.in);
		double result = scanner.nextDouble();
		return result;
	}
	
	private static int readFreeCopies()
	{
		System.out.print("Anzahl Freikopien:\t\t");
		Scanner scanner = new Scanner(System.in);
		int result = scanner.nextInt();
		return result;
	}
	
	private static double readPricePerCopy()
	{
		System.out.print("Preis/Kopie in Euro:\t\t");
		Scanner scanner = new Scanner(System.in);
		double result = scanner.nextDouble();
		scanner.close();
		return result;
	}

	public static void main(String[] args) {
		double fixCosts = 0;
		int freeCopies = 0;
		double pricePerCopy = 0;
		
		System.out.println("****************** Kosten für Kopiergeräte ******************");
		
		fixCosts = readFixCosts();
		freeCopies = readFreeCopies();
		pricePerCopy = readPricePerCopy();
		
		costs(fixCosts * 1.19, freeCopies, pricePerCopy * 1.19);
		System.out.println("\nProgrammende Kopierkosten");
	}
	
//	boolean read = true;
//	
//	System.out
//			.println("****************** Kosten für Kopiergeräte ******************");
//
//	do{
//		try{
//			read = true;
//			fixCosts = readFixCosts();
//		}catch(Exception e){
//			read = false;
//		}
//	}while(read == false);
//
//	read = true;
//	
//	do{
//		try{
//			freeCopies = readFreeCopies();
//		}catch(Exception e){
//			read = false;
//		}
//	}while(read == false );
//	
//	read = true;
//
//	do{
//		try{
//			pricePerCopy = readPricePerCopy();
//		}catch(Exception e){
//			read = false;
//		}
//	}while(read == false);
}
