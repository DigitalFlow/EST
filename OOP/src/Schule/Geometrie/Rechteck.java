package Schule.Geometrie;

public class Rechteck {
	private double seiteA;
	private double seiteB;
	private static int AnzahlRechtecke;
	
	public Rechteck()
	{
		AnzahlRechtecke++;
	}
	
	public double getSeiteA() {
		return seiteA;
	}

	public void setSeiteA(double seiteA) {
		this.seiteA = seiteA;
	}

	public double getSeiteB() {
		return seiteB;
	}
	
	public void setSeiteA(String seiteA) {
		double parsedA = Double.parseDouble(seiteA);
		setSeiteA(parsedA);
	}

	public void setSeiteB(String seiteB) {
		double parsedB = Double.parseDouble(seiteB);
		setSeiteB(parsedB);
	}
	
	public void setSeiteB(double seiteB) {
		this.seiteB = seiteB;
	}
	
	public void setSeiteAB(double a, double b)
	{
		setSeiteA(a);
		setSeiteB(b);
	}
	
	public void setSeiteAB(String a, String b)
	{
		setSeiteA(a);
		setSeiteB(b);
	}

	public Rechteck(double a, double b) 
	{
		this();
		seiteA = a;
		seiteB = b;
	}
	
	public Rechteck(String a, String b) 
	{
		this();
		setSeiteA(a);
		setSeiteB(b);
	}
	
	public double getFlaeche()
	{
		return seiteA * seiteB;
	}
	
	public double getUmfang()
	{
		return 2*seiteA + 2*seiteB;
	}
	
	public double getDiagonale()
	{
		return Math.sqrt(2) * seiteA; 
	}
	
	public boolean isQuadrat()
	{
		return seiteA == seiteB;
	}
	
	public String toString()
	{
		return "Seite A: " + seiteA + ", SeiteB: " + seiteB;
	}
	
	public static int getAnzahlRechteck()
	{
		return AnzahlRechtecke;
	}
}
