package Schule.Polymorphie;

public class Person implements Comparable<Person> {
	
	protected String nachname;
	protected String vorname;
	
	public Person() 
	{
		
	}
	
	public Person(String vorname, String nachname)
	{
		setVorname(vorname);
		setNachname(nachname);
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	
	public void print()
	{
		System.out.println("Nachname: " + nachname + ", Vorname: " + vorname);
	}

	@Override
	public int compareTo(Person person) {
		int comparison = nachname.compareTo(person.nachname);
		
		if(comparison == 0)
		{
			return vorname.compareTo(person.vorname); 
		}
		return comparison;
	}
}
