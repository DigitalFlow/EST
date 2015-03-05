
public abstract class Gehoelz {
	
	private String art;
	private int pflanzJahr;
	private float preis;
		
	public String getArt() {
		return art;
	}
	public void setArt(String art) {
		this.art = art;
	}
	public int getPflanzJahr() {
		return pflanzJahr;
	}
	public void setPflanzJahr(int pflanzJahr) {
		this.pflanzJahr = pflanzJahr;
	}
	public float getPreis() {
		return preis;
	}
	public void setPreis(float preis) {
		this.preis = preis;
	}
	
	public String getInfo()
	{
		return "Art: " + art + ", Pflanzjahr: " + pflanzJahr + ", Preis: " + preis; 
	}
}
