package est.sae.minesweeper;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class BasePanel extends JPanel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4542952501438397551L;
	private GridLayout _Layout;
	private MineButton[][] _Buttons;
	private ButtonActions _ButtonAction;
	protected int MineCount;
	protected int rows;
	protected int cols;
	private ArrayList<MineButton> _ButtonsFlagged;
	private ArrayList<MineButton> _ButtonsUnhidden;
	
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

	public int getRows() {
		return rows;
	}

	public int getCols() {
		return cols;
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
	
	public boolean ButtonWasUnhidden(MineButton button)
	{
		_ButtonsUnhidden.add(button);
		return CheckIfGameIsWon();
	}
	
	public boolean ButtonWasFlagged(MineButton button)
	{
		_ButtonsFlagged.add(button);
		return CheckIfGameIsWon();
	}
	
	public boolean CheckIfGameIsWon()
	{
		boolean flaggedAllMinesExclusively = true;
		
		for(MineButton button : _ButtonsFlagged)
		{
			if(button.getHiddenText() != "M")
			{
				flaggedAllMinesExclusively = false;
			}
		}
		
		if(flaggedAllMinesExclusively && _ButtonsUnhidden.size() + _ButtonsFlagged.size() == rows*cols)
		{
			return true;
		}
		
		return false;
	}
	
	public void GenerateField()
	{
		_Buttons = new MineButton[cols][rows];
		_ButtonsFlagged = new ArrayList<MineButton>();
		_ButtonsUnhidden = new ArrayList<MineButton>();
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

	public void ButtonWasUnflagged(MineButton buttonPressed) {
		_ButtonsFlagged.remove(buttonPressed);
	}

	public void UnveilAdjacentEmptyButtons(MineButton buttonPressed) {
		int buttonCol = 0;
		int buttonRow = 0;
		
		for(int col = 0; col < cols; col++)
		{
			for(int row = 0; row < rows; row++)
			{
				if(_Buttons[col][row] == buttonPressed)
				{
					buttonCol = col;
					buttonRow = row;
					break;
				}
			}
		}
		
		UnveilButtons(buttonCol, buttonRow);
	}
	
	public void UnveilButtons(int col, int row)
	{
		UnveilButton(col - 1, row - 1);
		UnveilButton(col, row - 1);
		UnveilButton(col + 1, row - 1); 
		UnveilButton(col - 1, row);
		UnveilButton(col + 1, row);
		UnveilButton(col - 1, row + 1); 
		UnveilButton(col, row + 1);
		UnveilButton(col + 1, row + 1);
	}

	private void UnveilButton(int col, int row) {
		if(col >= 0 && col < cols && row >= 0 && row < rows)
		{
			MineButton button = _Buttons[col][row];
			
			if(!button.isEnabled())
			{
				return;
			}
			
			if(button.getText().equals("F"))
			{
				BaseWindow frame = (BaseWindow) SwingUtilities.getRoot(this);
				frame.RaiseCounter();
			}
			
			_ButtonsUnhidden.add(button);
			
			button.setText(button.getHiddenText());
			button.setEnabled(false);
			
			if(button.getText().equals("0"))
			{
				UnveilButtons(col, row);
			}
		}
	}

}