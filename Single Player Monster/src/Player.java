import javafx.scene.image.Image;

public class Player extends MoveableEntity {
	
	static final int MAX_POISON_PARCEL = 2;
		
	private int mNumPoison;
	private int mPoisonReset;
	private int mPoisonTimer;
	
	private Boolean mAwaitingPlacePoison;
	
	public Player(Image image, Image poisonedImage, int x, int y) {
		super(image, poisonedImage, x, y);
		
		mAwaitingPlacePoison = false;
		mNumPoison = 0;
		mPoisonReset = 0;
		mPoisonTimer = 0;
	}
	
	public void setAwaitingPlacePoison() { mAwaitingPlacePoison = true; }
	public Boolean awaitingPlacePoison() { return mAwaitingPlacePoison == true; }

	public Boolean canPlacePoison() {
		if (mNumPoison < MAX_POISON_PARCEL) {
			return true;
		}
		return false;
	}
	
	public int placePoison() {
		if (mNumPoison < MAX_POISON_PARCEL) {
			mAwaitingPlacePoison = false;
			mPoisonTimer += Poison.PLACED_DURATION;
			mPoisonReset++;
			return mNumPoison++;
		}
		assert(false);
		mAwaitingPlacePoison = false;
		return 0;
	}
	
	public void tickPoison() {
		if (mPoisonTimer > 0) {
			mPoisonTimer--;
			if (mPoisonTimer == (mPoisonReset-1)*Poison.PLACED_DURATION) {
				mPoisonReset--;
				mNumPoison--;
			}
		}
	}
}
