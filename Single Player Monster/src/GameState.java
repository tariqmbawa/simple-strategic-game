import java.util.ArrayList;
import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;

public class GameState {
	private static int SCORE_TIME = 30;
	private static int NUM_MONSTERS = 2;
	private static int WIN_SCORE = 3;
	
	GameBoard mGameBoard;
	Player mPlayer;
	MonsterAI mMonsterAI;
	ArrayList<Monster> mMonsters;
	Block mBlock;
	ArrayList<Poison> mPoisons;
	ArrayList<MoveableEntity> mMoveables;
	int mDuration;
	long mElapsedTime;
	
	int mPlayerScore;
	int mMonsterScore;
	
	int mScoreTime;
	int mTimer;
	
	Boolean mPaused;
	
	GameScoreManager mGameScoreManager;
	GraphicsContext mGC;
	
	public GameState() {
		// set member variables
		mGameScoreManager = new GameScoreManager();
		mMonsters = new ArrayList<Monster>();
		mPoisons = new ArrayList<Poison>();
		mMoveables = new ArrayList<MoveableEntity>();
		mElapsedTime = 0;
		mPaused = false;
		
		mPlayerScore = 0;
		mMonsterScore = 0;
		
		mTimer = 0;
		mScoreTime = SCORE_TIME;
	}
	
	public void initGameState() {
		mGameBoard = new GameBoard();
		mGameBoard.initGameBoard();
		
		initEntities();
	}
	
	public void initEntities() {
		mPlayer = new Player(new Image("player.png"),new Image("poison_player.png"), 0, 0);
		mGameBoard.setEmptyImage(new Image("empty.png"));
		mBlock = new Block(new Image("block.png"), 0, 0);
		
		mPoisons.add(new Poison(new Image("poison.png"), 0, 0));
		mPoisons.add(new Poison(new Image("poison.png"), 0, 0));
		
		mMoveables.add(mPlayer);
		
		//mGameBoard.addEntityAtPosition(mPoisons.get(0), CellState.POISON, 0, 6);7, 8);
		//mGameBoard.addEntityAtPosition(mPoisons.get(1), CellState.POISON, 0, 5);
		
		loadLevel(getLevel(new Random(System.nanoTime()).nextInt(100)));//6));
	}
	
	private void loadLevel(String[] currentLevel) {
		int monsterCount = 0;

		for (int j = 0; j < GameBoard.BOARD_HEIGHT; ++j) {
			for (int i = 0; i < GameBoard.BOARD_WIDTH; ++i) {
				if (currentLevel[j].charAt(i) == '$') {
					mPlayer.setX(i);
					mPlayer.setY(j);
					
					mGameBoard.placeEntityAtPosition(mPlayer, CellState.PLAYER, mPlayer.getX(), mPlayer.getY());
				}
				else if (currentLevel[j].charAt(i) == '#') {
					mGameBoard.placeEntityAtPosition(mBlock, CellState.BLOCKED, i, j);
				}
				else if (currentLevel[j].charAt(i) == '@') {
					if (monsterCount%NUM_MONSTERS == 0) {
						if (mMonsters.size() <= monsterCount) {
							mMonsters.add(new Monster(new Image("monsterA.png"), new Image("poison_monsterA.png"), i, j));
							mMoveables.add(mMonsters.get(monsterCount));
						}
						mGameBoard.placeEntityAtPosition(mMonsters.get(monsterCount), CellState.MONSTER, i, j);
						monsterCount++;
					} else if (monsterCount%NUM_MONSTERS == 1) {
						if (mMonsters.size() <= monsterCount) {
							mMonsters.add(new Monster(new Image("monsterB.png"), new Image("poison_monsterB.png"), i, j));
							mMoveables.add(mMonsters.get(monsterCount));
						}
						mGameBoard.placeEntityAtPosition(mMonsters.get(monsterCount), CellState.MONSTER, i, j);
						monsterCount++;
					} else {
						assert(false);
					}
				}
			}
		}
		//mGameBoard.addEntityAtPosition(mPoisons.get(0), CellState.POISON, 0, 6);
		//mGameBoard.addEntityAtPosition(mPoisons.get(1), CellState.POISON, 0, 5);
	}
	
	private void unloadLevel() {
		mGameBoard.resetGameBoard();
	}
	
	public GameBoard getGameBoard() {
		return mGameBoard;
	}
	
	public void setGraphicsContext(GraphicsContext gc) {
		mGC = gc;
	}
	
	public String getScore() {
		return mPlayerScore + " : " + mMonsterScore;
	}
	
	public void movePlayer(Direction direction) {
		//System.out.println("Player Moved: ");
		mPlayer.setDirection(direction);
		mPlayer.setAwaitingMove();
	}
	
	public void placePoison() {
		//System.out.println("Poison Placed: ");
		CollisionType collision = mGameBoard.resolveCollision(mPlayer.getX(), mPlayer.getY(), mPlayer.nextX(), mPlayer.nextY());
		
		if (collision == CollisionType.NONE && mPlayer.canPlacePoison())
			mPlayer.setAwaitingPlacePoison();
	}
	
	public void update() {
		//System.out.println("GameState Updated: ");
		mTimer++;
		if (mTimer >= mScoreTime) {
			mPlayerScore++;
			if (mPlayerScore > WIN_SCORE) {
				//unloadLevel();
				System.out.println("End of Game: Player Wins");
			}
			mTimer = 0;
		}
		
		mPlayer.tickPoison();
		
		for (Poison poison : mPoisons) {
			// if tickIsExpired returns true we remove the poison from the gameBoard
			if (poison.tickIsExpired()) {
				mGameBoard.removeEntityAtPosition(poison.getX(), poison.getY());
			}
		}
		
		if (mPlayer.awaitingPlacePoison()) {
			int poisonIndex = mPlayer.placePoison();
			System.out.println("Poison Index: " + poisonIndex);
			mGameBoard.placeEntityAtPosition(mPoisons.get(poisonIndex), CellState.POISON, mPlayer.nextX(), mPlayer.nextY());
			mPoisons.get(poisonIndex).setPoison(mPlayer.nextX(), mPlayer.nextY());
		}
		
		for (Monster monster : mMonsters) {
			if (monster.moveRandom(new Random(System.nanoTime()).nextInt(4))) {
				monster.setAwaitingMove();
			}
		}
		
		// get time elapsed
		// if time unit has changed enough check collisions
		//System.out.println("Player Updated: ");
		for (MoveableEntity entity : mMoveables) {
			entity.tickState();
			
			if (entity.awaitingMove()) {
				int x = entity.getX();
				int y = entity.getY();
				int nextX = entity.nextX();
				int nextY = entity.nextY();

				if (entity.canMove() && mGameBoard.canMove(nextX, nextY)) {
					CollisionType collision = mGameBoard.resolveCollision(x, y, nextX, nextY);
					
					switch (collision) {
					case NONE:
						mGameBoard.moveEntity(x, y, entity.nextX(), entity.nextY());
						entity.moveToNextPosition();
						break;
					case BLOCKED:
						// do nothing
						break;
					case SCORE:
						mGameBoard.moveEntity(x, y, entity.nextX(), entity.nextY());
						entity.moveToNextPosition();
						// add score
						// reset player or reset game
						mMonsterScore++;
						unloadLevel();
						if (mMonsterScore > WIN_SCORE) {
							System.out.println("End of Game: Monster Wins");
						}
						loadLevel(getLevel(new Random(System.nanoTime()).nextInt(100)));//6));
						break;
					case POISON:
						mGameBoard.moveEntity(x, y, entity.nextX(), entity.nextY());
						entity.addPoisonEffect();
						entity.moveToNextPosition();
						
						break;
					default:
						assert(false);
					}
				}
			}
		}


		
		// update AI choice of move direction
		
		// increment poison timers
		
		// check if poisons should be removed or if effects should be reset
		
		// increment gameTimer
		
		// check if game has reached the duration limit and end the game
		
		// save to gameScoreManager with a copy to user profile 
	}
	
	public void updateDisplay() {
		//System.out.println("Display Updated: ");
		for (int i = 0; i < GameBoard.BOARD_WIDTH; ++i) {
			for (int j = 0; j < GameBoard.BOARD_HEIGHT; ++j) {
				int x = i*Cell.DIMENSIONS;
				int y = j*Cell.DIMENSIONS;
				Entity entity = mGameBoard.getEntityAtIndex(i, j);
				mGC.save();
				if (entity != null) {
					Rotate r = new Rotate(entity.getRotation(), x+Cell.DIMENSIONS/2, y+Cell.DIMENSIONS/2);
					mGC.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
				}
				mGC.drawImage(mGameBoard.getEntityImageAtIndex(i, j), x, y);
				mGC.restore();
			}
		}
	}
	
	public void updatePaths() {
		System.out.println("Paths Updated: ");
		// update AI to changes in position to change or update paths
	}

	private String[] getLevel(int levelNumber) {
		ArrayList<String[]> levels = new ArrayList<String[]>();
		levels.add(new String[] {	"$====#====",
									"=====#==@=",
									"=====#====",
								    "=====#====",
								    "####===###",
								    "=====#====",
								    "=====#====",
								    "=====#====",
								    "=@===#====",
								    "=====#===="});
		
		levels.add(new String[] {	"=====#====",
								    "=====#==@=",
								    "====$#====",
								    "=##==###==",
								    "==========",
								    "=##==#====",
								    "==#==####=",
								    "==#====#==",
								    "=@#===#===",
								    "=========="});
		
		levels.add(new String[] {	"==========",
								    "=====@====",
								    "==========",
								    "=##==###==",
								    "$=========",
								    "=##=======",
								    "=====####=",
								    "==#====#==",
								    "======@===",
								    "=========="});
		
		levels.add(new String[] {	"######====",
								    "#====#==##",
								    "=====#====",
								    "====$===##",
								    "==#####===",
								    "===@==@===",
								    "===####===",
								    "==========",
								    "========##",
								    "========##"});
		
		levels.add(new String[] {	"######===@",
								    "#===@#==##",
								    "##===#===#",
								    "===#====##",
								    "=######===",
								    "=#======##",
								    "===####===",
								    "=#========",
								    "=#=#=##=##",
								    "===#==$=##"});
		
		levels.add(new String[] {	"=====##=##",
								    "=##==##=@#",
								    "=========#",
								    "=##==###==",
								    "=====#====",
								    "=##==#$===",
								    "=====####=",
								    "==#=======",
								    "=@###=#===",
								    "=========="});
		
		levels.add(new String[] {	"#========#",
								    "=#===@==#=",
								    "==#====#==",
								    "===#==#===",
								    "=====#===$",
								    "===#======",
								    "===#==#===",
								    "==#====#==",
								    "=#===@==#=",
								    "#========#"});
		
		levelNumber = levelNumber%(levels.size()+1);
		System.out.println("Random: " + levelNumber);
		
		if (levelNumber < 0 || levelNumber >= levels.size()) {
			return levels.get(0);
		} else
			return levels.get(levelNumber);
	}
}




















