package Schule.Kram;

public abstract class Konto {
	private String kNr;
	private double kStand;
	private static long anzahl = 0;
	
	public static long getAnzahl() {
		return anzahl;
	}
	
	public abstract String getKontoTyp();
	
	public abstract boolean abheben(double betrag);

	public Konto() 
	{
		System.out.println("Konto Konstruktor");
		kStand = 0;
		kNr = "Noch nicht festgelegt!";
		anzahl++;
	}
	
	public void print() 
	{
		System.out.println("Kontonummer: " + getkNr() + ", Kontostand: " + getkStand());
	}
	
	public Konto(String kNr, double kStand)
	{
		this();
		setkStand(kStand);
		setkNr(kNr);
	}
	
	public Konto(String kNr, String kStand)
	{
		this();
		setkStand(kStand);
		setkNr(kNr);
	}
	
	public String getkNr() {
		return kNr;
	}
	
	public void setkNr(String kNr) {
		this.kNr = kNr;
	}
	
	public double getkStand() {
		return kStand;
	}
	
	public void setkStand(double kStand) {
		this.kStand = kStand;
	}
	
	public void setAll(String kNr, double kStand) {
		setkNr(kNr);
		setkStand(kStand);
	}
	
	public void setkStand(String kStand) {
		double parsed = Double.parseDouble(kStand);
		setkStand(parsed);
	}
	
	public void setAll(String kNr, String kStand) {
		double parsed = Double.parseDouble(kStand);
		setAll(kNr, parsed);
	}
	
	public boolean einzahlen(double betrag)
	{
		if(betrag <= 0)
		{
			return false;
		}
		setkStand(kStand + betrag);
		return true;
	}
	
	public boolean auszahlen(double betrag)
	{
		if(betrag <= 0 || kStand - betrag < 0)
		{
			return false;
		}
		setkStand(kStand - betrag);
		return true;
	}
	
	public boolean ueberweisen(double betrag, Konto empfaenger)
	{
		if(auszahlen(betrag) == true)
		{
			empfaenger.einzahlen(betrag);
			return true;
		}
		return false;
	}
}