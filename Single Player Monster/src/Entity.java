
public abstract class Entity {
	
	
	Boolean spawn(int x, int y, int speed) {
		// bounds check x and y should have been done in gameState vs. gameBoard
		// set entity x y speed
		return true;
	}
	
	abstract void update(int timeUnitDelta);
	
}
