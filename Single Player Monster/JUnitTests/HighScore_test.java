import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HighScore_test {
	HighScore highscore;
	
	@Before
	public void setHighScore() {
		highscore = new HighScore();
	}
	
	@Test
	public void newHighscoreAddedForHigherScore() {
		 assertEquals(highscore.getHighest(), 0);
		 highscore.addScore(2);
		 assertEquals(highscore.getHighest(), 2);
	}
	@Test
	public void newHighScoreNotAddedForHigherScore() {
		highscore.addScore(2);
		assertEquals(highscore.getHighest(), 2);
		highscore.addScore(1);
		assertEquals(highscore.getHighest(),2);
	}
}
