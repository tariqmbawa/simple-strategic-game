
public class Player {
	
	static final int MAX_POISON_PARCEL = 2;
	private int posX; 
	private int posY;
	
	private int numPoison;
	
	public Player(int x, int y)
	{
		posX = x;
		posY = y;
		
		numPoison = MAX_POISON_PARCEL;
	}
	
	public void movePlayer(int deltaX, int deltaY)
	{
		posX += deltaX;
		posY += deltaY;
	}
	
	public Boolean placePoison() {
		if (numPoison > 0) {
			numPoison--;
			return true;
		}
		
		return false;
	}
	
	public int getX()
	{
		return posX;
	}
	
	public int getY()
	{
		return posY;
	}
}
