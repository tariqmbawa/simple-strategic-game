import static org.junit.Assert.*;

import org.junit.Test;

public class GameBoard_test {
	Cell testCell = new Cell();
	
	
	@Test
	 public void testCellNotNull()
	 {
		assertNotNull(testCell);
	 }
	
	@Test
	public void cellCharacterReturnsEmptyState()
	{
		assertEquals(testCell.getCellStateCharacter(CellState.EMPTY), ' ');
	}

	@Test
	public void cellCharacterReturnsMonsterState()
	{
		assertEquals(testCell.getCellStateCharacter(CellState.MONSTER), '&');
		
	}
	@Test
	public void cellCharacterReturnsPlayerState()
	{
		assertEquals(testCell.getCellStateCharacter(CellState.PLAYER), '@');
		
	}
	@Test
	public void cellCharacterReturnsPoisonState()
	{
		assertEquals(testCell.getCellStateCharacter(CellState.POISON), '*');
		
	}
	@Test
	public void cellCharacterReturnsBlockedState()
	{
		assertEquals(testCell.getCellStateCharacter(CellState.BLOCKED), '#');
	}
	
}
