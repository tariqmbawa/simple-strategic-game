import javafx.scene.image.Image;

public abstract class Entity {
	private int mPosX; 
	private int mPosY;
	private int mRotation;
	
	private Image mPlayerImage;

	public Entity(Image image, int x, int y) {
		mPosX = x;
		mPosY = y;
		mRotation = 0;
		
		mPlayerImage = image;
	}
	
	public Image getImage() { return mPlayerImage; }
	public void setImage(Image image) { mPlayerImage = image; }
	
	public int getX() { return mPosX; }	
	public int getY() { return mPosY; }
	public void setX(int x) { mPosX = x; }	
	public void setY(int y) { mPosY = y; }
	
	public int getRotation() { return mRotation; }
	public void setRotation(int rotation) { mRotation = rotation; }
	
	Boolean spawn(int x, int y, int speed) {
		// bounds check x and y should have been done in gameState vs. gameBoard
		// set entity x y speed
		return true;
	}
	
	Boolean canMove(int x, int y, int newX, int newY){
		//Check if there are any obstacles in the new x and y
		// that prevent the entity from moving to it
		
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
	
	Boolean startEffect(int startTime, int duration) {
		// set elapsedTime to 0 and set affectingEntity boolean
		
		return true;
	}
	
	Boolean endEffect() {
		// effect time is up remove poison
		return true;
	}
}






























