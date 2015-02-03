package est.sae.minesweeper;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class BaseWindow extends JFrame{
	
	private JLabel _MinesFound = new JLabel("0", SwingConstants.CENTER);
	private JLabel _Counter = new JLabel("0", SwingConstants.CENTER);
	private JPanel _InfoPanel = new JPanel();
	private BasePanel _FieldPanel = new ProfessionalPanel();
	private BorderLayout _WindowLayout = new BorderLayout();
	private BorderLayout _InfoLayout = new BorderLayout();
	private Dimension _WindowSize = new Dimension(500, 600);
	private JLabel _State = new JLabel("Kein Spiel");
		
	public BaseWindow()
	{
		// Call parent class for setting window name
		super("Minesweeper");

		// Set initial window size and layout
		this.setSize(_WindowSize);
		this.setLayout(_WindowLayout);
		
		// Formatting InfoPanel, used for displaying mines left and used time
		_InfoPanel.setLayout(_InfoLayout);
		_InfoPanel.setBorder(BorderFactory.createLoweredBevelBorder());
	
		_MinesFound.setPreferredSize(new Dimension(200, 100));
		_Counter.setPreferredSize(new Dimension(200, 100));
				
		_MinesFound.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		_Counter.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		_InfoPanel.add(_MinesFound, BorderLayout.LINE_START);
		_InfoPanel.add(_Counter, BorderLayout.LINE_END);
		this.add(_InfoPanel, BorderLayout.PAGE_START);
		
		// Formatting FieldPanel, used for displaying mine fields
		_FieldPanel.setBorder(BorderFactory.createLoweredBevelBorder());
		
		this.add(_FieldPanel, BorderLayout.CENTER);
		
		_State.setPreferredSize(new Dimension(this.getWidth(), 20));
		this.add(_State, BorderLayout.SOUTH);
		
		// Pack Frame to set window size to be big enough to set all components to their preferred size
		this.pack();
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		BaseWindow base = new BaseWindow();
		base.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
