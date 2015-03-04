package est.Car;

import java.util.ArrayList;

public class AutoListe {
		
	public static void listeErweitern(ArrayList<Auto> autos, Auto auto)
	{
		autos.add(auto);
	}
	
	public static void listeAusgeben(ArrayList<Auto> autos)
	{
		System.out.println(autos);
	}
	
	public static void neueListeGenerieren(ArrayList<Auto> autos, String fahrzeugArt)
	{
		for(Auto auto : autos)
		{
			auto.setArt(fahrzeugArt);
		}
	}
	
	public static int size(ArrayList<Auto> autos)
	{
		return autos.size();
	}
	
	public static int indexOf(ArrayList<Auto> autos, Auto auto)
	{
		return autos.indexOf(auto);
	}
	
	public static Boolean contains(ArrayList<Auto> autos, Auto auto)
	{
		return autos.contains(auto);
	} 
	
	public static Boolean remove(ArrayList<Auto> autos, Auto auto)
	{
		return autos.remove(auto);
	} 
	
	public static Auto get(ArrayList<Auto> autos, int position)
	{
		return autos.get(position);
	} 
}
