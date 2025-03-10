import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class GameScreenController implements Initializable {
	
	private ScreenState mScreenState;
	//UserProfile mCurrentUser;
	
	
	@FXML private TextArea boardArea;
	
	@FXML private Button pauseButton;
	@FXML private Button exitButton;

    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		boardArea.setEditable(false);
		boardArea.setFocusTraversable(false);
		
		pauseButton.setFocusTraversable(false);
		
		exitButton.setCancelButton(true);
	}
	
    public void setMenuState(ScreenState screenState) {
		mScreenState = screenState;
		//mCurrentUser = mScreenState.getProfileManager().getCurrentUserProfile();
		
		
	}
    
   
    
    @FXML protected void pauseButtonAction(ActionEvent event) throws IOException {
    	mScreenState.pauseGameAction();
    }
    
    @FXML protected void exitButtonAction(ActionEvent event) throws IOException {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Ending Game");
    	//alert.setHeaderText("Look, a Confirmation Dialog");
    	alert.setContentText("Are you sure you want to quit?");

    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == ButtonType.OK){
    		mScreenState.exitGameAction();
    	}

    }


	public EventHandler<KeyEvent> getOnKeyPressEventHandler() {	
		return new EventHandler<KeyEvent>() {
			public void handle(KeyEvent key) {
				if	(key.getCode() == KeyCode.UP) {
					System.out.println("PlayerMove: " + key.getCode().toString());
					// GameState calls movePlayer(Direction direction Up)
				}
				if	(key.getCode() == KeyCode.RIGHT) {
					System.out.println("PlayerMove: " + key.getCode().toString());
					// GameState calls movePlayer(Direction direction Right)
				}
				if	(key.getCode() == KeyCode.DOWN) {
					System.out.println("PlayerMove: " + key.getCode().toString());
					// GameState calls movePlayer(Direction direction Down)
				}
				if (key.getCode() == KeyCode.LEFT) {
					System.out.println("PlayerMove: " + key.getCode().toString());
					// GameState calls movePlayer(Direction direction Left)
				}
				
				if (key.getCode() == KeyCode.Q){
					// GameState calls placePoison()
				}

				if (key.getCode() == KeyCode.A){
					GameBoard gameBoard = new GameBoard();
					gameBoard.initGameBoard();
					boardArea.setText(gameBoard.displayBoard());
				}

			}
		};
	}
	


}
