package est.sae.minesweeper;

import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.ArrayList;

import javax.swing.JFrame;

import est.sae.minesweeper.ButtonActions.actionTaken;

public class BaseWindow extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 149684488393599155L;
	private final String _HighScorePath = System.getProperty("user.dir") + "\\MineSweeperHighscores";
	private JLabel _MinesLeft = new JLabel("0", SwingConstants.CENTER);
	private JLabel _Counter = new JLabel("0", SwingConstants.CENTER);
	private JPanel _InfoPanel = new JPanel();
	private JMenuBar _MenuBar = new JMenuBar();
	private JMenu _FileMenu = new JMenu("File");
	private JMenu _HighscoreMenu = new JMenu("Highscores");
	private JMenuItem _ChooseDifficulty = new JMenuItem("Choose Difficulty");
	private JMenuItem _RestartGame = new JMenuItem("Restart Game");
	private JMenuItem _LoadGame = new JMenuItem("Load Game");
	private JMenuItem _SaveGame = new JMenuItem("Save Game");
	private JMenuItem _ShowHighscore = new JMenuItem("Show Highscores");
	private JMenuItem _DeleteHighscore = new JMenuItem("Delete Highscores");
	private BasePanel _FieldPanel = new BeginnerPanel();
	private BorderLayout _WindowLayout = new BorderLayout();
	private BorderLayout _InfoLayout = new BorderLayout();
	private Dimension _WindowSize = new Dimension(500, 600);
	private JLabel _State = new JLabel();
	private Timer _Timer = new Timer(1000, this);
	private static enum _Difficulty {Beginner, Advanced, Professional};
	private ArrayList<HighScore> _HighScores;
		
	public BaseWindow()
	{
		// Call parent class for setting window name
		super("Minesweeper");
		FormatUI();
		StartGame();
	}
	
	private void FormatUI() {
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
				BuildMenu();
				this.setJMenuBar(_MenuBar);
	}

	private void InitializeFieldPanel() {
		// Formatting FieldPanel, used for displaying mine fields
		_FieldPanel.setBorder(BorderFactory.createLoweredBevelBorder());
		this.add(_FieldPanel, BorderLayout.CENTER);
	}
	
	public void InitializeMineCounter()
	{
		_MinesLeft.setText(String.valueOf(_FieldPanel.getMineCount()));
	}
	
	public void StartGame()
	{
		InitializeFieldPanel();
		InitializeMineCounter();
		_FieldPanel.RegenerateField();
		_State.setText("Spiel läuft");
		_Counter.setText("0");
		
		
		// Pack Frame to set window size to be big enough to set all components to their preferred size
		this.pack();
		this.setVisible(true);
		_Timer.start();
	}
	
	public void StartSaveGame()
	{
		InitializeFieldPanel();
		_State.setText("Spiel läuft");
		
		// Pack Frame to set window size to be big enough to set all components to their preferred size
		this.pack();
		this.setVisible(true);
		
		_Timer.start();
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
		_RestartGame.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_F2, ActionEvent.ALT_MASK));
		_ChooseDifficulty.addActionListener(this);
		_ChooseDifficulty.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_F3, ActionEvent.ALT_MASK));
		_LoadGame.addActionListener(this);
		_LoadGame.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_F4, ActionEvent.ALT_MASK));
		_SaveGame.addActionListener(this);
		_SaveGame.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_F5, ActionEvent.ALT_MASK));
		_ShowHighscore.addActionListener(this);
		_DeleteHighscore.addActionListener(this);
		_FileMenu.add(_RestartGame);
		_FileMenu.add(_ChooseDifficulty);
		_FileMenu.add(_LoadGame);
		_FileMenu.add(_SaveGame);
		_HighscoreMenu.add(_ShowHighscore);
		_HighscoreMenu.add(_DeleteHighscore);
		_MenuBar.add(_FileMenu);
		_MenuBar.add(_HighscoreMenu);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == _Timer)
		{
			_Counter.setText(String.valueOf(Integer.valueOf(_Counter.getText()) + 1));
		}
		else if(e.getSource() == _RestartGame)
		{
			StartGame();
		}
		else if(e.getSource() == _ChooseDifficulty)
		{
			DisplayDifficultyDialog();
		}
		else if(e.getSource() == _LoadGame)
		{
			LoadGame();
		}
		else if(e.getSource() == _SaveGame)
		{
			SaveGame();	
		}
		else if(e.getSource() == _ShowHighscore)
		{
			ShowHighscore();
		}
		else if(e.getSource() == _DeleteHighscore)
		{
			DeleteHighscore();
		}
	}
	
	private void ShowHighscore() {
		LoadHighScore();
		
		String scores = "Player Name" + "\t\t" + "Difficulty" + "\t\t" + "Time Needed" + "\t\t" + "Score" + "\n";
		
		for(HighScore score : _HighScores)
		{
			scores += score.getPlayerName() + "\t\t" + score.getDifficulty() + "\t\t" + score.getTimeNeeded() + "\t\t" + score.getScore() + "\n";
		}
		
		JOptionPane.showMessageDialog(this, new JTextArea(scores));
	}
	
	private void DeleteHighscore() {
		File highScore = new File(_HighScorePath);
		
		if(highScore.exists())
		{
			highScore.delete();
		}
	}

	private void CreateHighscoreEntry() {
		File highScore = new File(_HighScorePath);
		
		if(highScore.exists())
		{
			LoadHighScore();
		}

		String difficulty = ""; 
			
		if(_FieldPanel instanceof BeginnerPanel)
		{
			difficulty = _Difficulty.Beginner.name();
		}
		else if(_FieldPanel instanceof AdvancedPanel)
		{
			difficulty = _Difficulty.Advanced.name();
		}
		else if(_FieldPanel instanceof ProfessionalPanel)
		{
			difficulty = _Difficulty.Professional.name();
		}
		
		String playerName = JOptionPane.showInputDialog(this, "Please enter your Name for your highscore entry!", "Annonymous");
		
		if(playerName == null)
		{
			playerName = "Annonymous";
		}
		
		_HighScores = HighScore.AddNewEntry(_HighScores, playerName, difficulty, _FieldPanel.getRows(), _FieldPanel.getCols(), Integer.valueOf(_Counter.getText()));
		SaveHighScores();
	
	}
	
	private void LoadHighScore() {
		Object tempObj = null;
		
		File score = new File(_HighScorePath);
		
		if(!score.exists())
		{
			_HighScores = new ArrayList<HighScore>();
			return;
		}
		
		try
		{
			FileInputStream fileIn = new FileInputStream(score);
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			tempObj = objectIn.readObject();
			objectIn.close();
			fileIn.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		if(tempObj instanceof ArrayList<?>)
		{
			_HighScores = (ArrayList<HighScore>) tempObj;
		}
	}

	private void SaveHighScores() {
		try
		{
			FileOutputStream fileOut = new FileOutputStream(_HighScorePath);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(_HighScores);
			objectOut.flush();
			objectOut.close();
			fileOut.flush();
			fileOut.close();
			objectOut = null;
			fileOut = null;
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}

	private void LoadGame() {
		JFileChooser saveFileChooser = new JFileChooser(); 	
		saveFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int status = saveFileChooser.showOpenDialog(this);
		
		if(status == 1)
		{
			return;
		}
		
		String filePath = saveFileChooser.getSelectedFile().getAbsolutePath();
		
		JPanel tempInfoPanel = null;
		BasePanel tempFieldPanel = null;
		JLabel tempCounter = null;
		JLabel tempMines = null;
		
		try
		{
			FileInputStream fileIn = new FileInputStream(filePath);
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			tempInfoPanel = (JPanel) objectIn.readObject();
			tempFieldPanel = (BasePanel) objectIn.readObject();
			tempCounter = (JLabel) objectIn.readObject();
			tempMines = (JLabel) objectIn.readObject();
			objectIn.close();
			fileIn.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

		_Timer.stop();
		this.remove(_InfoPanel);
		this.remove(_FieldPanel);
		_InfoPanel = tempInfoPanel;
		_FieldPanel = tempFieldPanel;
		_Counter = tempCounter;
		_MinesLeft = tempMines;
		FormatUI();
		StartSaveGame();
				
		_InfoPanel.repaint();
		_FieldPanel.repaint();
		this.pack();
		this.repaint();
	}

	public void SaveGame()
	{
		JFileChooser saveFileChooser = new JFileChooser(); 	
		saveFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int status = saveFileChooser.showOpenDialog(this);
		
		if(status == 1)
		{
			return;
		}
		
		String filePath = saveFileChooser.getSelectedFile().getAbsolutePath();
		filePath += "\\Test.txt";
		
		try
		{
			FileOutputStream fileOut = new FileOutputStream(filePath);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(_InfoPanel);
			objectOut.writeObject(_FieldPanel);
			objectOut.writeObject(_Counter);
			objectOut.writeObject(_MinesLeft);
			objectOut.close();
			fileOut.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	public void DisplayDifficultyDialog()
	{
		int n = JOptionPane.showOptionDialog(this,
				"Please choose the difficulty you want to play.",
				"Choose difficulty",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,	
				_Difficulty.values(),
				_Difficulty.Beginner);
		
		switch (n)
		{
			case JOptionPane.YES_OPTION:
				SetDifficulty(_Difficulty.Beginner);
				break;
			case JOptionPane.NO_OPTION:
				SetDifficulty(_Difficulty.Advanced);
				break;
			case JOptionPane.CANCEL_OPTION:
				SetDifficulty(_Difficulty.Professional);
				break;
		}
	}
	
	public void SetDifficulty(_Difficulty difficulty)
	{
		this.remove(_FieldPanel);
		
		switch (difficulty)
		{
			case Beginner:
				_FieldPanel = new BeginnerPanel();
				break;
			case Advanced:
				_FieldPanel = new AdvancedPanel();
				break;
			case Professional:
				_FieldPanel = new ProfessionalPanel();
				break;
		}
		
		StartGame();
	}
	
	public void HaltGame()
	{
		_Timer.stop();
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
		CreateHighscoreEntry();
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

	public void EmptyButtonPressed(MineButton buttonPressed) {
		_FieldPanel.UnveilAdjacentEmptyButtons(buttonPressed);		
	}

}
