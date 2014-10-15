import java.util.Scanner;

public class KlassenArbeitDurchschnitt {

	public static void main(String[] args) {
		int klassenStaerke = 0;

		Scanner scanner = new Scanner(System.in);

		do
		{
			System.out.println("Bitte geben Sie die Klassenstärke ein!");
			klassenStaerke = scanner.nextInt();
		}while(klassenStaerke <= 0);
		
		System.out.println("Bitte geben Sie nun der Reihe nach die Noten ein!");
		
		double[] noten = new double[klassenStaerke];
		
		double notenSumme = 0;
		
		for(int i = 0; i < noten.length; i++)
		{
			do
			{
				System.out.print("Schüler "+(i+1)+": ");
				noten[i] = scanner.nextDouble();
				System.out.println();
			}while(noten[i]>6 || noten[i]<1);
			notenSumme += noten[i];
		}
		
		System.out.println("Notenliste:");
		
		for(int i = 0; i < noten.length; i++)
		{
			System.out.println("Schüler "+(i+1)+": "+noten[i]);
		}
		System.out.println("\n\nDurchschnitt: "+notenSumme/noten.length);
		scanner.close();
	}
}
