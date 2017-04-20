
public class Score {
	private int value;
	private String username;
	
	public Score(String name, int value) {
		this.username = name;
		this.value = value;
	}
	
	public int getScore() {
		return value;
	}
	
	public String getName() {
		return username;
	}
}
