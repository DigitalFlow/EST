
public class LottoZahlen {
	
	public static boolean contains(int wert, int[] zahlen)
	{
		boolean result = false;
		for(int i = 0; i < zahlen.length; i++)
		{
			if(zahlen[i] == wert)
			{
				result = true;
				break;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] lottoZahlen = new int[7];		
		for(int i = 0; i < lottoZahlen.length; i++)
		{
			int zufall = (int)(Math.random()*50)+1;
			if(contains(zufall, lottoZahlen))
			{
				i--;
				continue;
			}
			lottoZahlen[i] = zufall;
			System.out.println((i+1)+". Zufallszahl: "+zufall);
		}
	}
}
