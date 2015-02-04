package est.sae.minesweeper;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import est.sae.minesweeper.ButtonActions.actionTaken;

public class BaseWindow extends JFrame implements ActionListener {
	
	private JLabel _MinesLeft = new JLabel("0", SwingConstants.CENTER);
	private JLabel _Counter = new JLabel("0", SwingConstants.CENTER);
	private JPanel _InfoPanel = new JPanel();
	private JMenuBar _MenuBar = new JMenuBar();
	private JMenu _FileMenu = new JMenu("File");
	private JMenuItem _ChooseDifficulty = new JMenuItem("Choose Difficulty");
	private JMenuItem _RestartGame = new JMenuItem("Restart Game");
	private BasePanel _FieldPanel = new ProfessionalPanel();
	private BorderLayout _WindowLayout = new BorderLayout();
	private BorderLayout _InfoLayout = new BorderLayout();
	private Dimension _WindowSize = new Dimension(500, 600);
	private JLabel _State = new JLabel();
	private Timer timer = new Timer(1000, this);
	private long startTime;
		
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
	
		_MinesLeft.setPreferredSize(new Dimension(200, 100));
		_Counter.setPreferredSize(new Dimension(200, 100));
				
		_MinesLeft.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		_Counter.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		_InfoPanel.add(_MinesLeft, BorderLayout.LINE_START);
		_InfoPanel.add(_Counter, BorderLayout.LINE_END);
		this.add(_InfoPanel, BorderLayout.PAGE_START);
				
		_State.setPreferredSize(new Dimension(this.getWidth(), 20));
		this.add(_State, BorderLayout.SOUTH);
		
		this.setJMenuBar(_MenuBar);
		StartGame();
	}
	
	private void InitializeFieldPanel() {
		// Formatting FieldPanel, used for displaying mine fields
		_FieldPanel.setBorder(BorderFactory.createLoweredBevelBorder());
		this.add(_FieldPanel, BorderLayout.CENTER);
	}

	public void SetStartTime()
	{
		startTime = System.currentTimeMillis();
	}
	
	public void InitializeMineCounter()
	{
		_MinesLeft.setText(String.valueOf(_FieldPanel.getMineCount()));
	}
	
	public void StartGame()
	{
		BuildMenu();
		InitializeFieldPanel();
		InitializeMineCounter();
		_FieldPanel.RegenerateField();
		SetStartTime();
		_State.setText("Spiel läuft");
		
		// Pack Frame to set window size to be big enough to set all components to their preferred size
		this.pack();
		this.setVisible(true);
		SetStartTime();
		timer.start();
	}
	
	public void LowerCounter()
	{
		_MinesLeft.setText(String.valueOf(Integer.parseInt(_MinesLeft.getText()) - 1));
	}
	
	public void RaiseCounter()
	{
		_MinesLeft.setText(String.valueOf(Integer.parseInt(_MinesLeft.getText()) + 1));
	}
	
	public static void main(String[] args) {
		BaseWindow base = new BaseWindow();
		base.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void BuildMenu()
	{
		_RestartGame.addActionListener(this);
		_ChooseDifficulty.addActionListener(this);
		_FileMenu.add(_RestartGame);
		_FileMenu.add(_ChooseDifficulty);
		_MenuBar.add(_FileMenu);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == timer)
		{
			_Counter.setText(String.valueOf((System.currentTimeMillis() - startTime)/1000));
		}
		else if(e.getSource() == _RestartGame)
		{
			StartGame();
		}
		else if(e.getSource() == _ChooseDifficulty)
		{
			this.remove(_FieldPanel);
			_FieldPanel = new BeginnerPanel();
			StartGame();
		}
	}
	
	public void HaltGame()
	{
		timer.stop();
		_FieldPanel.DisableAllButtons();
	}
	
	public void LostGame()
	{
		HaltGame();
		_State.setText("Leider verloren!");
	}

	public void WinGame()
	{
		HaltGame();
		_State.setText("Gewonnen!");
	}

	public void ButtonActionOccured(MineButton buttonPressed, actionTaken pressed) {
		boolean gameWon = false;
		
		switch(pressed)
		{
			case PRESSED:
				gameWon = _FieldPanel.ButtonWasUnhidden(buttonPressed);
				break;
			case FLAGGED:
				gameWon = _FieldPanel.ButtonWasFlagged(buttonPressed);
				break;
			case UNFLAGGED:
				_FieldPanel.ButtonWasUnflagged(buttonPressed);
		}
		
		if(gameWon)
		{
			WinGame();
		}
	}
}
