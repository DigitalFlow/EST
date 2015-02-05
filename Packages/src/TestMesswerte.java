import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import org.junit.*;

import temperaturmessung.TemperaturMessreihe;

public class TestMesswerte {
	
	@SuppressWarnings("deprecation")
	@Test
	public void Test_Messreihenerstellung()
	{
		//Messreihe für 5 Messwerte erstellen
		TemperaturMessreihe messreihe = new TemperaturMessreihe(5, "Celsius");
		
		//Daten erstellen
		GregorianCalendar datum1 = new GregorianCalendar(2014, 11, 13, 13, 0);
		GregorianCalendar datum2 = new GregorianCalendar(2014, 11, 13, 14, 0);
		GregorianCalendar datum3 = new GregorianCalendar(2014, 11, 13, 15, 0);
		GregorianCalendar datum4 = new GregorianCalendar(2014, 11, 13, 16, 0);
		GregorianCalendar datum5 = new GregorianCalendar(2014, 11, 13, 17, 0);
		
		//Werte hinzufügen
		messreihe.addMesswert(1.0, datum1);
		messreihe.addMesswert(2.0, datum2);
		messreihe.addMesswert(3.0, datum3);
		messreihe.addMesswert(4.0, datum4);
		messreihe.addMesswert(5.0, datum5);
		
		//Assert
		try {
			assertEquals(33.8, TemperaturMessreihe.CelsiusToFahrehnheit(messreihe.getMesswert(datum1)), 0);
			assertEquals(35.6, TemperaturMessreihe.CelsiusToFahrehnheit(messreihe.getMesswert(datum2)), 0);
			assertEquals(37.4, TemperaturMessreihe.CelsiusToFahrehnheit(messreihe.getMesswert(datum3)), 0);
			assertEquals(39.2, TemperaturMessreihe.CelsiusToFahrehnheit(messreihe.getMesswert(datum4)), 0);
			assertEquals(41.0, TemperaturMessreihe.CelsiusToFahrehnheit(messreihe.getMesswert(datum5)), 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		messreihe.print();
	}
	
}
