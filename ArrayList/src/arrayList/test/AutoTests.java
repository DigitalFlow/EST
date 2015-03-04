package arrayList.test;

import java.util.ArrayList;

import junit.framework.Assert;
import est.Car.Auto;
import est.Car.AutoListe;

import org.junit.Test;

public class AutoTests {
	
	@Test
	public void CreateCars()
	{
		Auto cabrio = new Auto("Weiﬂ", 54, "Polo");
		Auto limousine1 = new Auto("Silber", 54, "Golf");
		Auto limousine2 = new Auto("Schwarz", 54, "Passat");
		
		Assert.assertEquals("Weiﬂ", cabrio.getFarbe());
		Assert.assertEquals("Silber", limousine1.getFarbe());
		Assert.assertEquals("Schwarz", limousine2.getFarbe());
	}
	
	@Test
	public void CreateArrayList()
	{
		Auto cabrio = new Auto("Weiﬂ", 54, "Polo");
		Auto limousine1 = new Auto("Silber", 54, "Golf");
		Auto limousine2 = new Auto("Schwarz", 54, "Passat");
		
		ArrayList<Auto> autoListe = new ArrayList<Auto>();
		
		AutoListe.listeErweitern(autoListe, cabrio);
		AutoListe.listeErweitern(autoListe, limousine1);
		AutoListe.listeErweitern(autoListe, limousine2);
		
		Assert.assertEquals(cabrio, autoListe.get(0));
		Assert.assertEquals(limousine1, autoListe.get(1));
		Assert.assertEquals(limousine2, autoListe.get(2));
	}
	
	@Test
	public void createLimousineList()
	{
		Auto cabrio = new Auto("Weiﬂ", 54, "Cabrio");
		Auto limousine1 = new Auto("Silber", 54, "Limousine");
		Auto van = new Auto("Schwarz", 54, "Van");
		
		ArrayList<Auto> autoListe = new ArrayList<Auto>();
		
		AutoListe.listeErweitern(autoListe, cabrio);
		AutoListe.listeErweitern(autoListe, limousine1);
		AutoListe.listeErweitern(autoListe, van);
		
		AutoListe.neueListeGenerieren(autoListe, "Limousine");
		
		Assert.assertEquals("Limousine", autoListe.get(0).getArt());
		Assert.assertEquals("Limousine", autoListe.get(1).getArt());
		Assert.assertEquals("Limousine", autoListe.get(2).getArt());
	}
	
	@Test
	public void PrintArrayList()
	{
		Auto cabrio = new Auto("Weiﬂ", 54, "Polo");
		Auto limousine1 = new Auto("Silber", 54, "Golf");
		Auto limousine2 = new Auto("Schwarz", 54, "Passat");
		
		ArrayList<Auto> autoListe = new ArrayList<Auto>();
		
		AutoListe.listeErweitern(autoListe, cabrio);
		AutoListe.listeErweitern(autoListe, limousine1);
		AutoListe.listeErweitern(autoListe, limousine2);
		
		AutoListe.listeAusgeben(autoListe);
	}
}
