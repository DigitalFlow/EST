package temperaturmessung;

import messdaten.Messreihe;

public class TemperaturMessreihe extends Messreihe{
	
	private String temperaturEinheit;
	
	public TemperaturMessreihe(int arrayLength, String temperaturEinheit) {
		super(arrayLength);
		this.temperaturEinheit = temperaturEinheit;
	}
	
	public void print()
	{
		System.out.println("Verwendete Temperatureinheit: " + temperaturEinheit);
		super.print();
	}
	
	public static double CelsiusToFahrehnheit(double wert)
	{
		return (wert * 1.8) + 32;
	}
}
