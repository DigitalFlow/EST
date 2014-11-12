package messdaten;

import java.util.GregorianCalendar;

class Messreihe {

	protected Messwert[] messwerte;
	
	public Messreihe(int arrayLength)
	{
		messwerte = new Messwert[arrayLength];
	}
	
	public void addMesswert(double wert, GregorianCalendar messDatum)
	{
		for(int i = 0; i < messwerte.length; i++)
		{
			if(messwerte[i] == null)
			{
				messwerte[i] = new Messwert(wert, messDatum);
				break;
			}
		}
	}
	
	public double getMesswert(GregorianCalendar messDatum) throws Exception
	{
		for(int i = 0; i < messwerte.length; i++)
		{
			if(messwerte[i] != null && messwerte[i].getMessDatum() == messDatum)
			{
				return messwerte[i].getWert();
			}
		}
		throw new Exception("Did not find value for date!");
	}
	
	public void print()
	{
		for(Messwert m : messwerte)
		{
			
		}
	}
	
}
