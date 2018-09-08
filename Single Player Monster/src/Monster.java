import javafx.scene.image.Image;

public class Monster extends MoveableEntity {
	static int NUM_DIRECTIONS = 4;
	
	public Monster(Image image, Image poisonedImage, int x, int y) {
		super(image, poisonedImage, x, y);
		// TODO Auto-generated constructor stub
	}

	public void update(int timeUnitDelta) {

	}
	
	public Boolean moveRandom(int direction) {
		if (direction%NUM_DIRECTIONS == 0)
			setDirection(Direction.UP);
		if (direction%NUM_DIRECTIONS == 1)
			setDirection(Direction.RIGHT);
		if (direction%NUM_DIRECTIONS == 2)
			setDirection(Direction.DOWN);
		if (direction%NUM_DIRECTIONS == 3)
			setDirection(Direction.LEFT);
		return true;
	}
}
