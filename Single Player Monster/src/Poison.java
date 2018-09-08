import javafx.scene.image.Image;

public class Poison extends Entity {
	public static int PLACED_DURATION = 19;
	
	int mDuration;
	
	public Poison(Image image, int x, int y) {
		super(image, x, y);
		mDuration = PLACED_DURATION;
	}
	
	public Boolean setPoison(int x, int y) {
		setX(x);
		setY(y);
		mDuration = 0;
		return true;
	}
	
	public Boolean tickIsExpired() {
		if (mDuration < PLACED_DURATION) {
			mDuration++;
			
			if (mDuration >= PLACED_DURATION)
				return true;
		}
		return false;
	}
	
	
}
