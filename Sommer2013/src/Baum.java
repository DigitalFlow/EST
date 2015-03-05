
public class Baum extends Gehoelz{

	private int maxHoehe;

	public int getMaxHoehe() {
		return maxHoehe;
	}

	public void setMaxHoehe(int maxHoehe) {
		this.maxHoehe = maxHoehe;
	}
	
	public String getInfo()
	{
		return super.getInfo() + ", MaxHoehe: " + maxHoehe;
	}
	
}
