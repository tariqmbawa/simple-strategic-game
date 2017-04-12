
public class Player {
	
	private int posX;
	private int posY;
	
	public Player(int x, int y)
	{
		posX = x;
		posY = y;
	}
	
	public void movePlayer(int deltaX, int deltaY)
	{
		posX += deltaX;
		posY += deltaY;
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
