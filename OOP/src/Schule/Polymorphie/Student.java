package Schule.Polymorphie;

public class Student extends Person
{
	
	protected int matrikelnummer;
	
	public Student()
	{
		
	}
	
	public Student(String vorname, String nachname, int matrikelnummer)
	{
		super(vorname, nachname);
		setMatrikelnummer(matrikelnummer);
	}
	
	public void print()
	{
		System.out.println("Nachname: " + nachname + ", Vorname: " + vorname + ", Matrikelnummer: " + matrikelnummer);
	}

	public int getMatrikelnummer() {
		return matrikelnummer;
	}

	public void setMatrikelnummer(int matrikelnummer) {
		this.matrikelnummer = matrikelnummer;
	}
}
