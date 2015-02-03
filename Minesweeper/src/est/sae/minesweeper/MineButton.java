package est.sae.minesweeper;

import javax.swing.JButton;

public class MineButton extends JButton {

	private String hiddenText = "";
	
	public MineButton()
	{
		
	}

	public String getHiddenText() {
		return hiddenText;
	}

	public void setHiddenText(String hiddenText) {
		this.hiddenText = hiddenText;
	}
	
}
