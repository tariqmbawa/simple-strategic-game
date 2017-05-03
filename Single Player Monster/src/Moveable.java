
public class Moveable extends Entity {
	int speedUnit; // move time units
	
	Boolean canMove(int x, int y, int newX, int newY) {
		// check if not disabled or time units still waiting
		
		return true;
	}
	
	Boolean move(int x, int y, int newX, int newY) {
		// set entity's position to newX and newY
		// reset wait unit time
		
		return true;
	}
	
	Boolean startPoison(int startTimeUnit) {
		// halve speed
		// set start time
		
		return true;
	}
	
	Boolean endPoison(int endTimeUnit) {
		// double speed
		
		return true;
	}
	
	@Override
	void update(int timeUnitDelta) {
		
	}
}
