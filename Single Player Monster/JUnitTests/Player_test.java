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
		testPlayer = new Player(null, null, 0, 0);
	}
	
	@Test
	public void playerPositionChangesCorrectly()
	{
		assertEquals(testPlayer.getX(), 0);
		assertEquals(testPlayer.getY(), 0);
		testPlayer.setDirection(Direction.DOWN);
		testPlayer.moveToNextPosition();
		assertEquals(testPlayer.getX(), 0);
		assertEquals(testPlayer.getY(), 1);

	}
	
	@Test
	public void playerDropsTwoPoisonMaximum() {
		assertEquals(testPlayer.placePoison(), true);
		assertEquals(testPlayer.placePoison(), true);
		assertEquals(testPlayer.placePoison(), false);
	}
}
