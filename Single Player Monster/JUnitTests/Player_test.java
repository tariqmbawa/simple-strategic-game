import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Player_test {
	Player testPlayer;
	
	@Before
	public void setPlayerPosition()
	{
		testPlayer = new Player(0, 0);
	}
	
	@Test
	public void playerPositionChangesCorrectly()
	{
		assertEquals(testPlayer.getX(), 0);
		assertEquals(testPlayer.getY(), 0);
		testPlayer.movePlayer(2, 1);
		assertEquals(testPlayer.getX(), 2);
		assertEquals(testPlayer.getY(), 1);

	}
}
