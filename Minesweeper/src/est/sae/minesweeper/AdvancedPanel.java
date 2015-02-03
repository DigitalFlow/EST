package est.sae.minesweeper;

public class AdvancedPanel extends BasePanel{

	public static int MineCount = 40;
	private static int rows = 16;
	private static int cols = 16;
	
	public AdvancedPanel()
	{
		super(rows, cols, MineCount);
	}
	
}
