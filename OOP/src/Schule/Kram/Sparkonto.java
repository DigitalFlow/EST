package Schule.Kram;

public class Sparkonto extends Konto {
	public double zinsSatz;
	
	public Sparkonto() {
		System.out.println("Girokonto Konstruktor");
	}
	
	public Sparkonto(String kontoNummer, double kontoStand, double zins)
	{
		this();
		this.setkNr(kontoNummer);
		this.setkStand(kontoStand);
		this.setZinsSatz(zins);
	}
	
	public void setZinsSatz(double value) {
		zinsSatz = value;
	}
	
	public double getZinsSatz() 
	{
		return zinsSatz;
	}
	
	public void print()
	{
		System.out.println("Kontonummer: " + getkNr() + ", Kontostand: " + getkStand() + ", Zins: " + getZinsSatz());
	}

	@Override
	public String getKontoTyp() {
		return "Sparkonto";
	}

	@Override
	public boolean abheben(double betrag) {
		if(auszahlen(betrag))
		{
			return true;
		}
		return false;
	}
}
