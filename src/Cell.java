



public class Cell {
	
	CellState cellState;
	
	public Cell(CellState newCellState) {
		cellState = newCellState;
	}
	
	public CellState getCellState() {
		return cellState;
	}
	
	public void setCellState(CellState newCellState)
	{
		cellState = newCellState;
	}
	
	public char displayCellState()
	{
		return getCellStateCharacter(cellState);
	}
	
	public char getCellStateCharacter(CellState newCellState)
	{
		switch (newCellState)
		{
		case EMPTY:
			return ' ';
		case PLAYER:
			return '@';
		case MONSTER:
			return '&';
		case POISON:
			return '*';
		case BLOCKED:
			return '#';
		default:
			return ' ';
		}
		/*return ' ';*/
	}
}
