
public class Poison extends Entity {
	int elapsedTimeUnit;
	int endTimeUnit;
	Boolean affectingEntity;
	
	Boolean setPoison(int startTime, int duration) {
		// set necessary values
		return true;
	}
	
	Boolean removePoison() {
		// remove as the poison has been picked up or time duration has elapsed
		
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
	
	void update(int timeUnitDelta) {
		// add time to elapsed
		// check if hit endTimeUnits
		// remove if hit endTime
	}
	
	
}
