
public class HighScore {
	private int highest;
	
	public HighScore() {
		highest = 0;
	}
	
	public int getHighest() {
		return highest;
	}
	
	public Boolean addScore(int newScore) {
		if (newScore > highest) {
			highest = newScore;
			return true;
		}

		return false;
	}
}
