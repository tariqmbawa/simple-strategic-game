import javafx.scene.image.Image;

public class GameBoard {
	static final int BOARD_WIDTH = 10;
	static final int BOARD_HEIGHT = 10;
	
	Cell[][] boardCells;
	int width;
	int height;
	
	static Image mEmptyImage;
	
	public GameBoard() {
		boardCells = new Cell[BOARD_WIDTH][BOARD_HEIGHT];
		
		width = BOARD_WIDTH;
		height = BOARD_HEIGHT;
	}
	
	public void initGameBoard() {
		for (int i = 0; i < height; ++i) {
			for (int j = 0; j < width; ++j) {
				boardCells[j][i] = new Cell();
			}
		}
		
		// corner cells
		//top-left
		boardCells[0][0].addBoarderCell(boardCells[1][0]); // right
		boardCells[0][0].addBoarderCell(boardCells[0][1]); // down
		//top-right
		boardCells[BOARD_WIDTH-1][0].addBoarderCell(boardCells[BOARD_WIDTH-1-1][0]); // left
		boardCells[BOARD_WIDTH-1][0].addBoarderCell(boardCells[BOARD_WIDTH-1][1]); // down
		//bottom-right
		boardCells[BOARD_WIDTH-1][BOARD_HEIGHT-1].addBoarderCell(boardCells[BOARD_WIDTH-1][BOARD_HEIGHT-1-1]); // up
		boardCells[BOARD_WIDTH-1][BOARD_HEIGHT-1].addBoarderCell(boardCells[BOARD_WIDTH-1-1][BOARD_HEIGHT-1]); // left
		//bottom-left
		boardCells[0][BOARD_HEIGHT-1].addBoarderCell(boardCells[0][BOARD_HEIGHT-1-1]); // up
		boardCells[0][BOARD_HEIGHT-1].addBoarderCell(boardCells[1][BOARD_HEIGHT-1]); // right
		
		//top row
		for (int j = 1; j < BOARD_WIDTH-1; ++j) {
			boardCells[j][0].addBoarderCell(boardCells[j-1][0]); // left
			boardCells[j][0].addBoarderCell(boardCells[j+1][0]); // right
			boardCells[j][0].addBoarderCell(boardCells[j][1]); // down
		}
		//bottom row
		for (int j = 1; j < BOARD_WIDTH-1; ++j) {
			boardCells[j][BOARD_HEIGHT-1].addBoarderCell(boardCells[j-1][BOARD_HEIGHT-1]); // left
			boardCells[j][BOARD_HEIGHT-1].addBoarderCell(boardCells[j+1][BOARD_HEIGHT-1]); // right
			boardCells[j][BOARD_HEIGHT-1].addBoarderCell(boardCells[j][BOARD_HEIGHT-1-1]); // up
		}
		//left column
		for (int i = 1; i < BOARD_HEIGHT-1; ++i) {
			boardCells[0][i].addBoarderCell(boardCells[0][i-1]); // up
			boardCells[0][i].addBoarderCell(boardCells[0][i+1]); // down
			boardCells[0][i].addBoarderCell(boardCells[1][i]); // right
		}
		//right column
		for (int i = 1; i < BOARD_HEIGHT-1; ++i) {
			boardCells[BOARD_WIDTH-1][i].addBoarderCell(boardCells[BOARD_WIDTH-1][i-1]); // up
			boardCells[BOARD_WIDTH-1][i].addBoarderCell(boardCells[BOARD_WIDTH-1][i+1]); // down
			boardCells[BOARD_WIDTH-1][i].addBoarderCell(boardCells[BOARD_WIDTH-1-1][i]); // left
		}
		
		for (int i = 1; i < BOARD_HEIGHT-1; ++i) {
			for (int j = 1; j < BOARD_WIDTH-1; ++j) {
				boardCells[j][i].addBoarderCell(boardCells[j][i-1]); // up
				boardCells[j][i].addBoarderCell(boardCells[j+1][i]); // right
				boardCells[j][i].addBoarderCell(boardCells[j][i+1]); // down
				boardCells[j][i].addBoarderCell(boardCells[j-1][i]); // left
			}
		}
	}
	
	public void setEmptyImage(Image image) {
		mEmptyImage = image;
	}
	
	public Entity getEntityAtIndex(int x, int y) {
		assert(x >= 0 && x < BOARD_WIDTH && y >= 0 && y < BOARD_HEIGHT);
		return boardCells[x][y].getEntity();
	}
	
	public Image getEntityImageAtIndex(int x, int y) {
		assert(x >= 0 && x < BOARD_WIDTH && y >= 0 && y < BOARD_HEIGHT);
		
		if (boardCells[x][y].isNullEntity())
			return mEmptyImage;
		
		return boardCells[x][y].getEntityImage();
	}
	
	public Cell getCellAtIndex(int x, int y) {
		if (x < 0 && x >= BOARD_WIDTH && y < 0 && y >= BOARD_HEIGHT)
			return null;
		return boardCells[x][y];
	}
	
	public CellState getCellStateAtIndex(int x, int y) {
		assert(x >= 0 && x < BOARD_WIDTH && y >= 0 && y < BOARD_HEIGHT);
		
		return boardCells[x][y].getCellState();
	}
	
	Boolean canMove(int nextX, int nextY)
	{
		// checks if the new x and y are accessible. It is not blocked, monster, player and not out-of-bounds 
		if (nextX < 0 || nextX >= BOARD_WIDTH || nextY < 0 || nextY >= BOARD_HEIGHT)
			return false;
		
		if (boardCells[nextX][nextY].getCellState() == CellState.BLOCKED)
			return false;
		
		return true;
	}
	
	public CollisionType resolvePath(int x, int y, int nextX, int nextY) {
		if (nextX < 0 || nextX >= BOARD_WIDTH || nextY < 0 || nextY >= BOARD_HEIGHT)
			return CollisionType.BLOCKED;
		
		CellState endCell = getCellStateAtIndex(nextX, nextY);
		if (endCell == CellState.BLOCKED)
			return CollisionType.BLOCKED;
		
		return CollisionType.NONE;
	}
	
	public CollisionType resolveCollision(int x, int y, int nextX, int nextY) {
		CellState startCell = getCellStateAtIndex(x, y);
		CellState endCell = getCellStateAtIndex(nextX, nextY);
		
		if (nextX < 0 || nextX >= BOARD_WIDTH || nextY < 0 || nextY >= BOARD_HEIGHT)
			return CollisionType.BLOCKED;
		
		if (endCell == CellState.BLOCKED)
			return CollisionType.BLOCKED;
		
		if (endCell == CellState.EMPTY)
			return CollisionType.NONE;
		
		if (endCell == CellState.POISON)
			return CollisionType.POISON;

		if (startCell == CellState.PLAYER) {
			if (endCell == CellState.MONSTER)
				return CollisionType.SCORE;
		}

		if (startCell == CellState.MONSTER)
		{
			if (endCell == CellState.PLAYER)
				return CollisionType.SCORE;
			else if (endCell == CellState.MONSTER)
				return CollisionType.BLOCKED;
		}
		
		return CollisionType.NONE;
	}
	
	Boolean moveEntity(int x, int y, int nextX, int nextY) {
		// sets entity reference and type to the new cell
		// sets the current cell to EMPTY
		boardCells[nextX][nextY].setCellState(boardCells[x][y].getEntity(), boardCells[x][y].getCellState());
		boardCells[x][y].setCellState(null, CellState.EMPTY);
		return true;
	}
	
	Boolean placeEntityAtPosition(Entity entity, CellState cellState, int x, int y) {
		// checks the cell is empty
		// sets the cell to the entity reference and cellState
		if (x < 0 || x >= BOARD_WIDTH || y < 0 || y >= BOARD_HEIGHT)
			return false;
		
		boardCells[x][y].setCellState(entity, cellState);
		
		return true;
	}
	
	Boolean removeEntityAtPosition(int x, int y) {
		// sets the cell at position x and y to EMPTY
		boardCells[x][y].setCellState(null, CellState.EMPTY);
		boardCells[x][y].setFlag(false);
		return true;
	}
	
	public void resetGameBoard() {
		for (int i = 0; i < BOARD_WIDTH; ++i) {
			for (int j = 0; j < BOARD_HEIGHT; ++j) {
				removeEntityAtPosition(i, j);
			}
		}
	}
	
	Graph getPath(int startX, int startY, int endX, int endY) {
		// check if start and end are not the same
		// using dijkstra or DFS or BFS to find possible path
		// return path. Does not have to be shortest
		// return random path or null if inaccessible
		
		return new Graph();
	}
	
	
}
