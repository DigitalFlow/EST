package Schule.Kram;

public class Girokonto extends Konto {
	public double dispot;
	
	public Girokonto() {
		System.out.println("Girokonto Konstruktor");
	}
	
	public Girokonto(String kontoNummer, double kontoStand, double dispotBetrag)
	{
		this();
		this.setkNr(kontoNummer);
		this.setkStand(kontoStand);
		this.setDispot(dispotBetrag);
	}
	
	public void setDispot(double value) {
		dispot = value;
	}
	
	public double getDispot() 
	{
		return dispot;
	}
	
	public void print()
	{
		System.out.println("Kontonummer: " + getkNr() + ", Kontostand: " + getkStand() + ", Dispo: " + getDispot());
	}

	@Override
	public String getKontoTyp() {
		return "Girokonto";
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
