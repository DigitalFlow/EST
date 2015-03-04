package est.Car;

public class Auto {

	protected String farbe;
	protected int leistung;
	protected String art;

	public Auto(String farbe, int leistung, String art)
	{
		this.farbe = farbe;
		this.leistung = leistung;
		this.art = art;
	}
	
	public String toString()
	{
		return "Art: " + art + ", Leistung: " + leistung + ", Farbe: " + farbe;
	}

	public String getFarbe() {
		return farbe;
	}

	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}

	public int getLeistung() {
		return leistung;
	}

	public void setLeistung(int leistung) {
		this.leistung = leistung;
	}

	public String getArt() {
		return art;
	}

	public void setArt(String art) {
		this.art = art;
	}

}
