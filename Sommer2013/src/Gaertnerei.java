import java.util.ArrayList;


public class Gaertnerei {
	
	private ArrayList<Gehoelz> gehoelze;
	
	public boolean einkaufen(Gehoelz gehoelz)
	{
		return gehoelze.add(gehoelz);
	}
	
	public Gehoelz verkaufen(String art, int pflanzjahr)
	{
		for(int i = 0; i < gehoelze.size(); i++)
		{
			Gehoelz gehoelz = gehoelze.get(i);
			
			if(gehoelz.getArt().equals(art) && gehoelz.getPflanzJahr() == pflanzjahr)
			{
				return gehoelze.remove(i);
			}
		}
		return null;
	}
	
	public ArrayList<Gehoelz> getWoodByLimit(int price)
	{
		ArrayList<Gehoelz> matches = new ArrayList<Gehoelz>();
		
		for(Gehoelz gehoelz : gehoelze)
		{
			if(gehoelz.getPreis() < price)
			{
				matches.add(gehoelz);
			}
		}
		
		return matches;
	}
}
