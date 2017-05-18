
public class GameBoard {
	static final int BOARD_WIDTH = 10;
	static final int BOARD_HEIGHT = 10;
	
	Cell[][] boardCells;
	int width;
	int height;
	
	public GameBoard() {
		boardCells = new Cell[BOARD_WIDTH][BOARD_HEIGHT];
		
		width = BOARD_WIDTH;
		height = BOARD_HEIGHT;
	}
	
	public void initGameBoard() {
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
	
	/*// called from initialiseGameBoard
	private void addCell(EntityType entityType, int x, int y) {
		// get information related to the entityType, imageFile reference
		// add ImageView for entityType at position x, y
		
		
		// set visible in Controller to display/update ImageViews
		
	}*/
	
	public String displayBoard() {
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
	
	Boolean canMove(int x, int y, int newX, int newY) {
		// checks if the new x and y are accessible. It is not blocked, monster, player and not out-of-bounds 
		
		return true;
	}
	
	Boolean moveEntity(int x, int y, int newX, int newY) {
		// sets entity reference and type to the new cell
		// sets the current cell to EMPTY
		
		return true;
	}
	
	Boolean addEntityAtPosition(Entity entity, CellState cellState, int x, int y) {
		// checks the cell is empty
		// sets the cell to the entity reference and cellState
		
		return true;
	}
	
	Boolean removeEntityAtPosition(int x, int y) {
		// sets the cell at position x and y to EMPTY
		return true;
	}
	
	Path getPath(int startX, int startY, int endX, int endY) {
		// check if start and end are not the same
		// using dijkstra or DFS or BFS to find possible path
		// return path. Does not have to be shortest
		// return random path or null if inaccessible
		
		return new Path();
	}
	
	
}
