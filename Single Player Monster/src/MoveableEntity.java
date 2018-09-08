import javafx.scene.image.Image;

public class MoveableEntity extends Entity {
	static int POISON_DURATION = 20;
	
	private int mNextPosX; 
	private int mNextPosY;

	private Direction mDirection;
	private Boolean mAwaitingMove;
	
	private Image mPoisonedImage;
	
	int poisonUnit; // represents how many frames to skip
	int poisonLevel;
	int poisonDuration;
	
	public MoveableEntity(Image image, Image poisonedImage, int x, int y) {
		super(image, x, y);
		poisonUnit = 0;
		mNextPosX = 0;
		mNextPosY = 0;
		
		mDirection = Direction.UP;
		mAwaitingMove = false;
		
		mPoisonedImage = poisonedImage;
		
		poisonUnit = 0;
		poisonLevel = 0;
		poisonDuration = 0;
	}
	
	public Boolean canMove() {
		if (poisonUnit <= 0) {
			poisonUnit = poisonLevel;
			return true;
		}
		
		poisonUnit--;
		return false;
	}
	
	public void moveToNextPosition() {
		setX(nextX());
		setY(nextY());
		mAwaitingMove = false;
	}
	
	public void setAwaitingMove() { mAwaitingMove = true; }
	public Boolean awaitingMove() { return mAwaitingMove; }
	public void cancelMove() { mAwaitingMove = false;}
	
	public void addPoisonEffect() {
		poisonLevel++;
		poisonUnit = poisonLevel;
		poisonDuration += POISON_DURATION;
		setImage(mPoisonedImage);
	}
	
	public void tickState() {
		if (poisonDuration > 0) {
			poisonDuration--;
			if (poisonDuration == (poisonLevel-1)*POISON_DURATION) {
				poisonLevel--;
			}
			if (poisonDuration == 0)
				setImage(getImage());
		}
	}
	
	public int nextX() { 
		if (mDirection == Direction.LEFT) {
			setRotation(270);
			return getX() - 1;
		}
		if (mDirection == Direction.RIGHT) {
			setRotation(90);
			return getX() + 1;
		}
		
		return getX();
	}
	public int nextY() { 
		if (mDirection == Direction.UP) {
			setRotation(0);
			return getY() - 1;
		}
		if (mDirection == Direction.DOWN) {
			setRotation(180);
			return getY() + 1;
		}
		
		return getY();
	}
	
	public Direction getDirection() { return mDirection; }
	public void setDirection(Direction direction) { mDirection = direction; }
	
}
