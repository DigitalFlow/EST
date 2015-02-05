package est.sae.minesweeper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class HighScore implements Serializable, Comparable<HighScore>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2802502503987846117L;
	private String _PlayerName;
	private int _TimeNeeded;
	private String _Difficulty;
	private static ArrayList<HighScore> _Ranking = new ArrayList<HighScore>();;
	private int _Score;
	
	private HighScore(String playerName, String difficulty, int rows, int cols, int timeNeeded) 
	{
		
		int difficultyMultiplier = 0;
		
		switch(difficulty)
		{
		case "Beginner":
			difficultyMultiplier = 1;
			break;
		case "Advanced":
			difficultyMultiplier = 3;
			break;
		case "Professional":
			difficultyMultiplier = 5;
			break;
		}
		
		_PlayerName = playerName;
		_Difficulty = difficulty;
		_Score = rows * cols * (1000 / timeNeeded) * 1000 * difficultyMultiplier;
		_TimeNeeded = timeNeeded;
	}
	
	public static ArrayList<HighScore> AddNewEntry(ArrayList<HighScore> scores, String playerName, String difficulty, int rows, int cols, int timeNeeded)
	{		
		if(scores != null)
		{
			_Ranking = scores;
		}
		
		HighScore entry = new HighScore(playerName, difficulty, rows, cols, timeNeeded);
		
		_Ranking.add(entry);
		Collections.sort(_Ranking);
		TruncateHighScore();
		
		return _Ranking;
	}
	
	public static void TruncateHighScore()
	{
		if(_Ranking != null && _Ranking.size() > 10)
		{
			for(int i = 10; i < _Ranking.size(); i++)
			{
				_Ranking.remove(i);
			}
		}
	}
	
	public String getPlayerName() {
		return _PlayerName;
	}
	
	public void setPlayerName(String _PlayerName) {
		this._PlayerName = _PlayerName;
	}
	
	public String getDifficulty() {
		return _Difficulty;
	}
	
	public void setDifficulty(String _Difficulty) {
		this._Difficulty = _Difficulty;
	}
		
	public int getScore() {
		return _Score;
	}
	
	public void setScore(int _Score) {
		this._Score = _Score;
	}

	public int getTimeNeeded() {
		return _TimeNeeded;
	}

	public void setTimeNeeded(int _TimeNeeded) {
		this._TimeNeeded = _TimeNeeded;
	}

	@Override
	public int compareTo(HighScore high) {
		if(high == null)
		{
			return 1;
		}
		else
		{
			return Integer.compare(high._Score, this._Score);
		}
	}
	
}
