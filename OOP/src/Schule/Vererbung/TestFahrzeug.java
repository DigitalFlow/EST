package Schule.Vererbung;

import java.util.ArrayList;

public class TestFahrzeug {

	public static void main(String[] args) {
		ArrayList<Fahrzeug> fahrzeuge = new ArrayList<Fahrzeug>();
		float summe = 0;
		
		for(int i = 0; i < 3; i++)
		{
			Motorrad motorrad = new Motorrad();
			Pkw pkw = new Pkw();
			
			fahrzeuge.add(motorrad);
			fahrzeuge.add(pkw);
			
			summe += motorrad.preis + pkw.preis;
		}
		
		for(Fahrzeug fzg : fahrzeuge){
			fzg.print();
		}
		
		System.out.println(summe);
	}
}
