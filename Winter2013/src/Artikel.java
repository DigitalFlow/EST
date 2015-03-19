
public class Artikel {
	private int bestand;
	private double preis;
	
	public int getBestand() {
		return bestand;
	}

	public void setBestand(int bestand) {
		this.bestand = bestand;
	}

	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}

	public Artikel() {
		
	}
	
	public void kaufen(int menge) {
		  bestand += menge;
	}
}
