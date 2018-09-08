import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

public class GameScreenController implements Initializable {
	
	private ScreenState mScreenState;
	private GameState mGameState;
	//UserProfile mCurrentUser;
	
	//@FXML private TextArea boardArea;
	@FXML private Canvas boardCanvas;
	private GraphicsContext gc;
	
	@FXML private Button pauseButton;
	@FXML private Button exitButton;
	@FXML private Label scoreValue;
	
	private Timeline timeline0_5FPS;
	private Timeline timeline4FPS;
	Boolean paused;

    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//boardArea.setEditable(false);
		//boardArea.setFocusTraversable(false);
		pauseButton.setFocusTraversable(false);
		exitButton.setCancelButton(true);
		
		mGameState = new GameState();
		
	}
	
    public void setMenuState(ScreenState screenState) {
		mScreenState = screenState;
		mScreenState.setGameState(mGameState);
		
		//mCurrentUser = mScreenState.getProfileManager().getCurrentUserProfile();
		gc = boardCanvas.getGraphicsContext2D();
		
		mGameState.setGraphicsContext(gc);
		//mGameState.setPlayerImage(new Image("player.png"));
		
		
		timeline0_5FPS = new Timeline();
		timeline0_5FPS.setCycleCount(Timeline.INDEFINITE);
		//final long startTime = System.currentTimeMillis();
		KeyFrame kf0_5FPS = new KeyFrame(Duration.seconds(2),//(0.034), for 30FPS, 0.017 for 60FPS
				new EventHandler<ActionEvent>() {
	           		public void handle(ActionEvent event) {
	           			mGameState.updatePaths();
	           			System.out.println("Update Paths: ");
		            }
		        });
		timeline0_5FPS.getKeyFrames().add(kf0_5FPS);
		timeline0_5FPS.play();
		
		timeline4FPS = new Timeline();
		timeline4FPS.setCycleCount(Timeline.INDEFINITE);
		KeyFrame kf2FPS = new KeyFrame(Duration.seconds(0.25),// updates every quarter-second //(0.034), for 30FPS, 0.017 for 60FPS
				new EventHandler<ActionEvent>() {
	           		public void handle(ActionEvent event) {
	           			mGameState.update();
	           			mGameState.updateDisplay();
	           			scoreValue.setText(mGameState.getScore());
		            }
		        });
		timeline4FPS.getKeyFrames().add(kf2FPS);
		timeline4FPS.play();
		
		paused = false;
	}
      
    
    @FXML protected void pauseButtonAction(ActionEvent event) throws IOException {
    	if (paused) {
    		timeline0_5FPS.play();
    		timeline4FPS.play();
    		pauseButton.setText("Pause");
    		paused = false;
    	}
    	else {
    		timeline0_5FPS.pause();
    		timeline4FPS.pause();
    		pauseButton.setText(" Play ");
    		paused = true;
    	}
    }
    
    @FXML protected void exitButtonAction(ActionEvent event) throws IOException {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Ending Game");
    	//alert.setHeaderText("Look, a Confirmation Dialog");
    	alert.setContentText("Are you sure you want to quit?");
    	
    	timeline0_5FPS.pause();
    	timeline4FPS.pause();
    	paused = true;
    	
    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == ButtonType.OK){
    		mScreenState.exitGameAction();
    	}
    	else {
    		timeline0_5FPS.play();
    		timeline4FPS.play();
    		paused = false;
    	}
    }

	public EventHandler<KeyEvent> getOnKeyPressEventHandler() {	
		return new EventHandler<KeyEvent>() {
			public void handle(KeyEvent key) {
				if (paused == false) {
					if	(key.getCode() == KeyCode.UP) {
						//System.out.println("PlayerMove: " + key.getCode().toString());
						mGameState.movePlayer(Direction.UP);
						// GameState calls movePlayer(Direction direction Up)
					}
					if	(key.getCode() == KeyCode.RIGHT) {
						//System.out.println("PlayerMove: " + key.getCode().toString());
						mGameState.movePlayer(Direction.RIGHT);
						// GameState calls movePlayer(Direction direction Right)
					}
					if	(key.getCode() == KeyCode.DOWN) {
						//System.out.println("PlayerMove: " + key.getCode().toString());
						mGameState.movePlayer(Direction.DOWN);
						// GameState calls movePlayer(Direction direction Down)
					}
					if (key.getCode() == KeyCode.LEFT) {
						mGameState.movePlayer(Direction.LEFT);
						// GameState calls movePlayer(Direction direction Left)
					}
					
					if (key.getCode() == KeyCode.Q){
						// GameState calls placePoison()
						mGameState.placePoison();
					}
				}

				/*if (key.getCode() == KeyCode.A){
					GameBoard gameBoard = new GameBoard();
					gameBoard.initGameBoard();
					boardArea.setText(gameBoard.displayBoard());
				}*/

			}
		};
	}
	


}
