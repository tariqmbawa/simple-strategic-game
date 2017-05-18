
abstract class Moveable extends Entity {
	int speedUnit; // move time units
	
	Boolean canMove(int x, int y, int newX, int newY){
		//Check if there are any obstacles in the new x and y
		// that prevent the entity from moving to it
		
		return true;
	}
	
	abstract Boolean move(int x, int y, int newX, int newY);
	
	Boolean startPoison(int startTimeUnit) {
		// halve speed
		// set start time
		
		return true;
	}
	
	Boolean endPoison(int endTimeUnit) {
		// double speed
		
		return true;
	}
	
	Boolean startEffect(int startTime, int duration) {
		// set elapsedTime to 0 and set affectingEntity boolean
		
		return true;
	}
	
	Boolean endEffect() {
		// effect time is up remove poison
		return true;
	}
	
	@Override
	void update(int timeUnitDelta) {
		
	}
}
