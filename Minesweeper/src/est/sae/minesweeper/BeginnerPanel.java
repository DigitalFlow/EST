package est.sae.minesweeper;

public class BeginnerPanel extends BasePanel{
	
	public static int MineCount = 10;
	private static int rows = 8;
	private static int cols = 8;
	
	public BeginnerPanel()
	{
		super(rows, cols, MineCount);
	}
	
}
