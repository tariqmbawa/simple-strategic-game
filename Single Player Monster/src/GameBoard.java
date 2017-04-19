
public class GameBoard {
	static final int BOARD_WIDTH = 10;
	static final int BOARD_HEIGHT = 10;
	
	Cell[][] boardCells;
	int width;
	int height;
	
	public GameBoard()
	{
		boardCells = new Cell[BOARD_WIDTH][BOARD_HEIGHT];
		
		width = BOARD_WIDTH;
		height = BOARD_HEIGHT;
	}
	
	public void initGameBoard()
	{
		for (int i = 0; i < height; ++i)
		{
			for (int j = 0; j < width; ++j)
			{
				boardCells[j][i] = new Cell(CellState.EMPTY);
			}
		}
		
		boardCells[0][0].setCellState(CellState.PLAYER);
		
		boardCells[2][4].setCellState(CellState.MONSTER);
		boardCells[2][6].setCellState(CellState.MONSTER);
		
		boardCells[7][8].setCellState(CellState.POISON);
		
		boardCells[5][0].setCellState(CellState.BLOCKED);
		boardCells[5][1].setCellState(CellState.BLOCKED);
		boardCells[5][2].setCellState(CellState.BLOCKED);
		boardCells[5][3].setCellState(CellState.BLOCKED);
		
	}
	
	public String displayBoard()
	{
		String output = "";
		output +="| |";
		for (int i = 0; i < width; ++i)
		{
			output +=i + "|";
		}
		output +="\n";
		
		for (int j = 0; j < height; ++j)
		{
			output +="|" + j + "|";
			for (int k = 0; k < width; ++k)
			{
				output +=boardCells[k][j].displayCellState() + "|";
			}
			output +="\n";
		
		}
		
		return output;
	}
}
