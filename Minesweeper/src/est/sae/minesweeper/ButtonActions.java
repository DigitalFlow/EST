package est.sae.minesweeper;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ButtonActions implements MouseListener, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4452420546314918200L;

	public static enum actionTaken { PRESSED, FLAGGED, UNFLAGGED }; 
	
	@Override
	public void mouseClicked(MouseEvent e) {
		MineButton buttonPressed = (MineButton)e.getSource();
		BaseWindow frame = (BaseWindow) SwingUtilities.getRoot(buttonPressed);
		
		if(!buttonPressed.isEnabled())
		{
			return;
		}
		
		if(SwingUtilities.isLeftMouseButton(e))
		{
			if(buttonPressed.getText() == "F")
			{
				frame.RaiseCounter();
			}
				
			buttonPressed.setText(buttonPressed.getHiddenText());
			buttonPressed.setEnabled(false);
			
			if(buttonPressed.getHiddenText().equals("M"))
			{
				frame.LostGame();
				return;
			}
			else if(buttonPressed.getHiddenText().equals("0"))
			{
				frame.EmptyButtonPressed(buttonPressed);
			}
			
			frame.ButtonActionOccured(buttonPressed, actionTaken.PRESSED);
			buttonPressed.repaint();
		}
		else
		{
			if(buttonPressed.getText() != "F")
			{
				buttonPressed.setText("F");
				frame.LowerCounter();
				frame.ButtonActionOccured(buttonPressed, actionTaken.FLAGGED);
			}
			else
			{
				buttonPressed.setText("");
				frame.RaiseCounter();
				frame.ButtonActionOccured(buttonPressed, actionTaken.UNFLAGGED);
			}
			
			buttonPressed.repaint();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

}
