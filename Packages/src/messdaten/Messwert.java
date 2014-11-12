package messdaten;

import java.util.GregorianCalendar;

class Messwert {
	
	private static int anzahlMesswerte = 0;
	private double wert;
	private GregorianCalendar messDatum;
	private int messwertID;
	
	public Messwert()
	{
		anzahlMesswerte++;
		messwertID = anzahlMesswerte;
	}
	
	public Messwert(double wert, GregorianCalendar messDatum)
	{
		this.wert = wert;
		this.messDatum = messDatum;
	}
	
	public double getWert() {
		return wert;
	}
	public GregorianCalendar getMessDatum() {
		return messDatum;
	}
	public int getMesswertID() {
		return messwertID;
	}
}
