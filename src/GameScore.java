
public class GameScore {
	private int value;
	private String username;
	
	public GameScore(String name, int value) {
		this.username = name;
		this.value = value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	public int getValue() {
		return value;
	}

	public String getName() {
		return username;
	}
}
