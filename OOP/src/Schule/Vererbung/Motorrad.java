package Schule.Vererbung;

public class Motorrad extends Fahrzeug{
	private String fahrzeugtyp = "Motorrad";
	
	public void print() {
		System.out.println("Hersteller: " + herstellerName + ", Preis: " + preis + ", Fahrzeugtyp: " + fahrzeugtyp);
	}
}
