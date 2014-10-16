package Schule.Vererbung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fahrzeug {
	protected float preis;
	protected String herstellerName;
	protected static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public Fahrzeug()
	{
		herstellerName = EnterProperties("Please enter the name of the maker: ");	
		try
		{
			preis = Float.parseFloat(EnterProperties("Please enter the price of the vehicle: "));
		}
		catch(Exception ex)
		{
			preis = 0;
		}
	}

	protected String EnterProperties(String message)
	{
		try {
			System.out.print(message);
			String input = reader.readLine();
			return input;
		} catch (IOException e) {
			return null;
		}
	}
	
	public float getPreis() {
		return preis;
	}
	
	public void print() {
		System.out.println("Hersteller: " + herstellerName + ", Preis: " + preis);
	}
	
}