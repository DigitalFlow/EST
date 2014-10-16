package Schule.Vererbung;

public class Buch {
	private int AnzahlAusleihen;
	private int AnzahlSeiten;
	private String Author;
	private int Status;
	private int QualitativerZustand;
	private String Titel;
	
	public Buch()
	{
		
	}
	
	public void anKundenAusleihen(int value) throws Exception {
		throw new Exception("Does not have to be implemented in this task");
	}

	public void ausWartungZurueckErhalten(int value) throws Exception {
		throw new Exception("Does not have to be implemented in this task");
	}
	
	private void StatusSetzen(int value) throws Exception {
		throw new Exception("Does not have to be implemented in this task");
	}
	
	public boolean vonKundenZurueckErhalten(int value) throws Exception {
		throw new Exception("Does not have to be implemented in this task");
	}
	
	public void zurWartungGeben() {
		if(Status != 2)
		{
			Status = 4;
		}
	}
}
