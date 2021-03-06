package Schule.Kram;

public class Test {
	
	public static void main(String[] args) {
		Konto meinKonto;
		
		meinKonto = new Girokonto();
		
		Konto deinKonto = new Girokonto();
		
		meinKonto.setkNr("12345678");
		meinKonto.setkStand(150.2);
		
		deinKonto.setkNr("87654321");
		deinKonto.setkStand(2000.0);
		
		
		System.out.printf("%8.2f EUR\n", meinKonto.getkStand());
		System.out.printf("%8.2f EUR\n", deinKonto.getkStand());
		System.out.println(Konto.getAnzahl());
		
		System.out.println(deinKonto.auszahlen(2500));
		
		meinKonto.print();
		
		Girokonto meinGiro = new Girokonto();
		meinGiro.setkNr("123");
		meinGiro.setkStand(10000000);
		meinGiro.setDispot(-500);
		meinGiro.print();
		
		Konto k = meinGiro;
		Girokonto castedGiro = (Girokonto) k;
		castedGiro.print();
	}
	
}