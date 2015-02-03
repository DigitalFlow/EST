package est.sae.minesweeper;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BasePanel extends JPanel{

	private GridLayout _Layout;
	private JButton[][] _Buttons;
	protected int MineCount;
	protected int rows;
	protected int cols;
	
	public BasePanel(int cols, int rows, int mines)
	{		
		this.rows = rows;
		this.cols = cols;
		MineCount = mines;
		_Buttons = new JButton[cols][rows];
		
		_Layout = new GridLayout(cols, rows);
		this.setLayout(_Layout);
		
		InitializeButtons();
		PlantMines();
		CalculateButtonNames();
	}
	
	private void CalculateButtonNames() {
		
		for(int col = 0; col < cols; col++)
		{
			for(int row = 0; row < rows; row++)
			{
				if(IsButtonBomb(col, row))
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
						value = CheckForBomb(col + 1, row) + CheckForBomb(col + 1, row + 1) + CheckForBomb(col, row +1);
					}
					// Button is on the lower left
					else if(row == rows - 1)
					{
						value = CheckForBomb(col, row - 1) + CheckForBomb(col + 1, row - 1) + CheckForBomb(col + 1, row);
					}
					// Button is on the left
					else
					{
						value = CheckForBomb(col + 1, row) + CheckForBomb(col + 1, row + 1) + CheckForBomb(col, row + 1) 
								+ CheckForBomb(col + 1, row - 1) + CheckForBomb(col, row - 1);
					}
				}
				// Rightmost column
				else if(col == cols - 1)
				{
					// Button is on the upper right
					if(row == 0)
					{
						value = CheckForBomb(col - 1, row) + CheckForBomb(col - 1, row + 1) + CheckForBomb(col, row + 1);
					}
					// Button is on the lower right
					else if(row == rows - 1)
					{
						value = CheckForBomb(col, row - 1) + CheckForBomb(col - 1, row - 1) + CheckForBomb(col - 1, row);
					}
					// Button is on the right
					else
					{
						value = CheckForBomb(col, row - 1) + CheckForBomb(col - 1, row - 1) + CheckForBomb(col - 1, row) 
								+ CheckForBomb(col - 1, row + 1) + CheckForBomb(col, row + 1);
					}
				}
				// Top column
				else if(row == 0)
				{
					value = CheckForBomb(col - 1, row) + CheckForBomb(col - 1, row + 1) + CheckForBomb(col, row + 1) 
							+ CheckForBomb(col + 1, row + 1) + CheckForBomb(col + 1, row);
				}
				// Bottom column
				else if(row == rows - 1)
				{
					value = CheckForBomb(col - 1, row) + CheckForBomb(col - 1, row - 1) + CheckForBomb(col, row - 1) 
							+ CheckForBomb(col + 1, row - 1) + CheckForBomb(col + 1, row);
				}
				// Button is not on any border
				else
				{
					value = CheckForBomb(col - 1, row - 1) + CheckForBomb(col, row - 1) + CheckForBomb(col + 1, row - 1) 
							+ CheckForBomb(col - 1, row) + CheckForBomb(col + 1, row) + CheckForBomb(col - 1, row + 1) 
							+ CheckForBomb(col, row + 1) + CheckForBomb(col + 1, row + 1);
				}
				
				_Buttons[col][row].setText(String.valueOf(value));
			}
		}
	}

	private boolean IsButtonBomb(int col, int row) {
		return CheckForBomb(col, row) == 1 ? true : false;
	}

	// Zero based positions
	private int CheckForBomb(int col, int row) {
		JButton button = _Buttons[col][row];
		
		if(button != null)
		{
			if(button.getText() == "BOMB")
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
				JButton button = new JButton();
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
			
			JButton button = _Buttons[mineCol][mineRow]; 
			
			if(button != null && button.getText() == "")
			{
				button.setText("BOMB");
				minesPlanted++;
			}
		}
	}

}