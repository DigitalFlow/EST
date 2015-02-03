package est.sae.minesweeper;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BasePanel extends JPanel{

	private GridLayout _Layout;
	private ArrayList<JButton> _Buttons = new ArrayList<JButton>();
	
	public BasePanel(int rows, int cols, int mines)
	{		
		_Layout = new GridLayout(rows, cols);
		this.setLayout(_Layout);
		
		for(int i = 0; i < rows * cols; i++)
		{
			JButton button = new JButton();
			button.setPreferredSize(new Dimension(50, 50));
			_Buttons.add(button);
		}
		
		Random achmedTheDeadTerrorist = new Random();
		int buttonCount = _Buttons.size();
		int minesPlanted = 0;
		
		while(minesPlanted < mines)
		{
			int mineSpot = achmedTheDeadTerrorist.nextInt(buttonCount);
			
			if(_Buttons.get(mineSpot).getText() == "")
			{
				_Buttons.get(mineSpot).setText("BOMB");
				minesPlanted++;
			}
		}
		
		AddButtons(_Buttons);
		
	}
	
	private void AddButtons(ArrayList<JButton> buttons)
	{
		int listSize = buttons.size();
		
		for(int i = 0; i < listSize; i++)
		{
			this.add(buttons.get(i));
		}
	}
}