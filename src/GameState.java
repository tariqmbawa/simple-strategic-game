
public class GameState {
	GameBoard gameBoard;
	Player player;
	MonsterAI monsterAI;
	Monster[] monsters;
	int duration;
	
	GameScoreManager gameScoreManager;
	
	public GameState() {
		// set member variables
	}
	
	public void movePlayer() {
		// check if Player canMove, if time units have elapsed so they can move
		// get player position
		// get player direction
		// check if empty at position in front of the player
		// call move on Player
		// call moveEntity on Board for Player position
	}
	
	public void placePoison() {
		// check if Player has poison ie. canPlacePoison()
		// get Player position
		// get Player direction
		// check if empty at the position in front of the player
		// call placePoison for the Player
		// place the poison on the board
	}
	
	public void update() {
		// get time elapsed
		// if time unit has changed enough check collisions
		// update AI to changes in position to change or update paths
		// update AI choice of move direction
		// increment poison timers
		// check if poisons should be removed or if effects should be reset
		// increment gameTimer
		// check if game has reached the duration limit and end the game
		// save to gameScoreManager with a copy to user profile 
	}
}
