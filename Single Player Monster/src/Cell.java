import java.util.ArrayList;

import javafx.scene.image.Image;

public class Cell {
	static final int DIMENSIONS = 32;
	
	Entity mEntity;
	CellState mCellState;
	ArrayList<Cell> mBoarderCells;
	
	Boolean mGraphFlag;
	
	public Cell() {
		mEntity = null;
		mCellState = CellState.EMPTY;
		mBoarderCells = new ArrayList<Cell>();
		
		mGraphFlag = false;
	}
	
	public Boolean isNullEntity() {
		if (mEntity == null)
			return true;
		
		return false;
	}
	
	public int sizeBoarderCells() { return mBoarderCells.size(); }
	public Cell getBoarderCell(int index) { return mBoarderCells.get(index); }
	public void setFlag(Boolean set) { mGraphFlag = true; }
	public Boolean flagSet() { return mGraphFlag; }
	
	public void addBoarderCell(Cell cell) {
		mBoarderCells.add(cell);
	}
	
	public Entity getEntity() {
		return mEntity;
	}
	
	public CellState getCellState() {
		return mCellState;
	}
	
	public void setCellState(Entity entity, CellState cellState) {
		mEntity = entity;
		mCellState = cellState;
	}
	
	public Image getEntityImage() {
		return mEntity.getImage();
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
	}
}
