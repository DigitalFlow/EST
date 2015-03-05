
public class Strauch extends Gehoelz{
	
	private boolean istGiftig;

	public boolean isIstGiftig() {
		return istGiftig;
	}

	public void setIstGiftig(boolean istGiftig) {
		this.istGiftig = istGiftig;
	}

	public String getInfo()
	{
		return super.getInfo() + ", IstGiftig: " + istGiftig;
	}
}
