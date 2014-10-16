package Schule.Vererbung;

public class Pkw extends Fahrzeug{
	private String fahrzeugtyp = "Pkw";
	private String modellBezeichnung;
	
	public Pkw() {
		modellBezeichnung = EnterProperties("Please enter the model description: ");
	}
	
	public void print() {
		System.out.println("Hersteller: " + herstellerName + ", Preis: " + preis + ", Fahrzeugtyp: " + fahrzeugtyp + ", Modellbezeichnung: " + modellBezeichnung);
	}
}
