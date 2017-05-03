import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HighScore_test {
	GameScoreManager gameScoreManager;
	
	@Before
	public void setHighScore() {
		gameScoreManager = new GameScoreManager();
	}
	
	@Test
	public void newHighscoreAddedForHigherScore() {
		 assertEquals(gameScoreManager.getHighestGameScore(), 0);
		 gameScoreManager.addScore(new GameScore("test", 2));
		 assertEquals(gameScoreManager.getHighestGameScore(), 2);
	}
	@Test
	public void newHighScoreNotAddedForHigherScore() {
		gameScoreManager.addScore(new GameScore("test", 2));
		assertEquals(gameScoreManager.getHighestGameScore(), 2);
		gameScoreManager.addScore(new GameScore("test", 1));
		assertEquals(gameScoreManager.getHighestGameScore(),2);
	}
}
