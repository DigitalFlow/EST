
public class Verkaeufer {
	
	private Artikel[] sortiment;
	
	public Verkaeufer() {
		sortiment = new Artikel[100];
		
		for(Artikel artikel : sortiment)
		{
			artikel = new Artikel();
		}
	}
	
	public double getPreis(int pos) {
		if(pos >= 0 && pos < sortiment.length) {
			return sortiment[pos].getPreis();
		}
		throw new IndexOutOfBoundsException();
	}
	
	public void setPreis(int pos, double price) {
		if(pos >= 0 && pos < sortiment.length) {
			sortiment[pos].setPreis(price);
		}
		throw new IndexOutOfBoundsException();
	}
	
	public void kaufen(int pos, int amount) {
		if(pos >= 0 && pos < sortiment.length) {
			Artikel artikel = sortiment[pos]; 
			artikel.setBestand(artikel.getBestand() + amount);
		}
		throw new IndexOutOfBoundsException();
	}
	
	public void rabatt(int border, int amount) {
		if(amount < 0 || amount > 100) {
			throw new IllegalArgumentException();			
		}
		
		for(Artikel artikel : sortiment) {
			if(artikel.getBestand() > border) {
				artikel.setPreis(artikel.getPreis()*(1-amount));
			}
		}
	}
	
	public void erweitereSortiment(int amount) {
		if(amount < 1) {
			throw new IllegalArgumentException();
		}
			
		Artikel[] neuesSortiment = new Artikel[sortiment.length + amount];
		
		for(int i = 0; i < neuesSortiment.length; i++) {
			if(i < sortiment.length)
			{
				neuesSortiment[i] = sortiment[i];
			}
			else 
			{
				neuesSortiment[i] = new Artikel();
			}
		}
		
		sortiment = neuesSortiment;
	}
	
}
