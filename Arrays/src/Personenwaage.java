
public class Personenwaage {

	public static double mittelwert(double[] werte)
	{
		double mittelwert = 0;
		for(int i = 0; i < werte.length; i++)
		{
			mittelwert += werte[i];
		}
		return mittelwert/werte.length;
	}
	
	public static double standardabweichung(double mittel, double[] werte)
	{
		double result = 0;
		for(int i = 0; i < werte.length; i++)
		{
			result += Math.pow(werte[i], 2)-werte.length*Math.pow(mittel, 2);
		}
		
		return Math.sqrt((1/(werte.length-1))*result);
	}
	
	public static void main(String[] args) {
		int n = (int)(Math.random()*101);
		double[] messwerte = new double[n];
		
		for(int i = 0; i < n; i++)
		{
			messwerte[i] = (Math.random()*9)+46;
			System.out.println((i+1)+". Messwert: "+messwerte[i]);
		}
		double mittel = mittelwert(messwerte);
		
		System.out.println("Mittelwert: " + mittel);
		
		double standard = standardabweichung(mittel, messwerte);
		System.out.println("Standardabweichung: "+standard);
	}
	
}
