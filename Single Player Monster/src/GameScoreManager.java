import java.util.ArrayList;

public class GameScoreManager {
	private ArrayList<GameScore> scores;
	
	public GameScoreManager() {

	}
	
	public GameScore getHighestGameScore() {
		return scores.get(0);
	}
	
	public Boolean addScore(GameScore newScore) {
		for (int i = 0; i < scores.size(); i++) {
			if (scores.get(i).getValue() <= newScore.getValue()) {
				scores.add(i, newScore);
				return true;
			}
		}
		
		scores.add(newScore);
		
		return true;
	}
	
	public Boolean removeScore(GameScore gameScore) {
		return scores.remove(gameScore);
	}
	
	public String toString() {
		String returnString = "";
		GameScore score;
		
		for (int i = 0; i < scores.size(); ++i) {
			score = scores.get(i);
			returnString += score.getName() + "\n" + score.getValue() + "\n";
		}
		
		return returnString; 
	}
}
