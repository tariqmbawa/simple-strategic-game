import java.time.LocalDateTime;

public class GameTime {
	static final int MINS_PER_HOUR = 60;
	static final int SECS_PER_MIN = 60;
	
	LocalDateTime startTime;
	
	public GameTime() {
		startTime = LocalDateTime.now();
	}
	
	public void resetTimeUnit() {
		startTime = LocalDateTime.now();
	}
	
	public int getSecondsElapsed() {
		LocalDateTime nowTime = LocalDateTime.now();
		
		int hoursChange = nowTime.getHour() - startTime.getHour();
		int minutesChange = nowTime.getMinute() - startTime.getMinute();
		int secondsChange = nowTime.getSecond() - startTime.getSecond();
		
		return (hoursChange * MINS_PER_HOUR + minutesChange) * SECS_PER_MIN + secondsChange;
	}
	
}
