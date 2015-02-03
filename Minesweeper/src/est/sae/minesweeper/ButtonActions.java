package est.sae.minesweeper;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ButtonActions implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		MineButton buttonPressed = (MineButton)e.getSource();
		BaseWindow frame = (BaseWindow) SwingUtilities.getRoot(buttonPressed);
		
		if(SwingUtilities.isLeftMouseButton(e))
		{
			if(buttonPressed.getText() == "F")
			{
				frame.RaiseCounter();
			}
				
			buttonPressed.setText(buttonPressed.getHiddenText());
			buttonPressed.setEnabled(false);
			
			if(buttonPressed.getHiddenText() == "M")
			{
				frame.LostGame();
			}
			
			buttonPressed.repaint();
		}
		else
		{
			if(buttonPressed.getText() != "F")
			{
				buttonPressed.setText("F");
				frame.LowerCounter();
			}
			else
			{
				buttonPressed.setText("");
				frame.RaiseCounter();
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