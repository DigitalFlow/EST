package est.sae.minesweeper;

public class ProfessionalPanel extends BasePanel{

	public static int MineCount = 99;
	private static int rows = 10;
	private static int cols = 30;
	
	public ProfessionalPanel()
	{
		super(rows, cols, MineCount);
	}
	
}
