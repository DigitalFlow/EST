package est.sae.minesweeper;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

public class BasePanel extends JPanel{

	private GridLayout _Layout;
	private MineButton[][] _Buttons;
	private ButtonActions _ButtonAction;
	protected int MineCount;
	protected int rows;
	protected int cols;
	
	public BasePanel(int cols, int rows, int mines)
	{		
		this.rows = rows;
		this.cols = cols;
		MineCount = mines;
		_ButtonAction = new ButtonActions();
		
		_Layout = new GridLayout(cols, rows);
		this.setLayout(_Layout);
		GenerateField();
	}
	
	private void CalculateButtonNames() {
		
		for(int col = 0; col < cols; col++)
		{
			for(int row = 0; row < rows; row++)
			{
				if(IsButtonMine(col, row))
				{
					continue;
				}
				
				int value = 0;
				
				// Leftmost column
				if(col == 0)
				{
					// Button is on the upper left
					if(row == 0)
					{
						value = CheckForMine(col + 1, row) + CheckForMine(col + 1, row + 1) + CheckForMine(col, row +1);
					}
					// Button is on the lower left
					else if(row == rows - 1)
					{
						value = CheckForMine(col, row - 1) + CheckForMine(col + 1, row - 1) + CheckForMine(col + 1, row);
					}
					// Button is on the left
					else
					{
						value = CheckForMine(col + 1, row) + CheckForMine(col + 1, row + 1) + CheckForMine(col, row + 1) 
								+ CheckForMine(col + 1, row - 1) + CheckForMine(col, row - 1);
					}
				}
				// Rightmost column
				else if(col == cols - 1)
				{
					// Button is on the upper right
					if(row == 0)
					{
						value = CheckForMine(col - 1, row) + CheckForMine(col - 1, row + 1) + CheckForMine(col, row + 1);
					}
					// Button is on the lower right
					else if(row == rows - 1)
					{
						value = CheckForMine(col, row - 1) + CheckForMine(col - 1, row - 1) + CheckForMine(col - 1, row);
					}
					// Button is on the right
					else
					{
						value = CheckForMine(col, row - 1) + CheckForMine(col - 1, row - 1) + CheckForMine(col - 1, row) 
								+ CheckForMine(col - 1, row + 1) + CheckForMine(col, row + 1);
					}
				}
				// Top column
				else if(row == 0)
				{
					value = CheckForMine(col - 1, row) + CheckForMine(col - 1, row + 1) + CheckForMine(col, row + 1) 
							+ CheckForMine(col + 1, row + 1) + CheckForMine(col + 1, row);
				}
				// Bottom column
				else if(row == rows - 1)
				{
					value = CheckForMine(col - 1, row) + CheckForMine(col - 1, row - 1) + CheckForMine(col, row - 1) 
							+ CheckForMine(col + 1, row - 1) + CheckForMine(col + 1, row);
				}
				// Button is not on any border
				else
				{
					value = CheckForMine(col - 1, row - 1) + CheckForMine(col, row - 1) + CheckForMine(col + 1, row - 1) 
							+ CheckForMine(col - 1, row) + CheckForMine(col + 1, row) + CheckForMine(col - 1, row + 1) 
							+ CheckForMine(col, row + 1) + CheckForMine(col + 1, row + 1);
				}
				
				_Buttons[col][row].setHiddenText(String.valueOf(value));
			}
		}
	}

	private boolean IsButtonMine(int col, int row) {
		return CheckForMine(col, row) == 1 ? true : false;
	}

	// Zero based positions
	private int CheckForMine(int col, int row) {
		MineButton button = _Buttons[col][row];
		
		if(button != null)
		{
			if(button.getHiddenText() == "M")
			{
				return 1;
			}
		}
		
		return 0;
	}

	public int getMineCount() {
		return MineCount;
	}
	
	private void InitializeButtons() {
		
		for(int col = 0; col < cols; col++)
		{
			for(int row = 0; row < rows; row++)
			{
				MineButton button = new MineButton();
				button.addMouseListener(_ButtonAction);
				button.setPreferredSize(new Dimension(50, 50));
				_Buttons[col][row] = button;
				this.add(button);
			}
		}
	
	}
	
	private void PlantMines()
	{
		Random achmedTheDeadTerrorist = new Random();
		int minesPlanted = 0;
		
		while(minesPlanted < MineCount)
		{
			int mineCol = achmedTheDeadTerrorist.nextInt(cols);
			int mineRow = achmedTheDeadTerrorist.nextInt(rows);
			
			MineButton button = _Buttons[mineCol][mineRow]; 
			
			if(button != null && button.getHiddenText() == "")
			{
				button.setHiddenText("M");
				minesPlanted++;
			}
		}
	}
	
	public void RegenerateField()
	{
		this.removeAll();
		GenerateField();
		this.repaint();
	}
	
	public void GenerateField()
	{
		_Buttons = new MineButton[cols][rows];
		InitializeButtons();
		PlantMines();
		CalculateButtonNames();
	}
	
	public void DisableAllButtons()
	{
		for(int col = 0; col < cols; col++)
		{
			for(int row = 0; row < rows; row++)
			{
				MineButton currentButton = _Buttons[col][row];
				currentButton.setEnabled(false);
				currentButton.setText(currentButton.getHiddenText());
			}
		}
	}

}