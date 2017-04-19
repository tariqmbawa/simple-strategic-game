import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class GameScreenController implements Initializable {
private ScreenState mScreenState;
UserProfile mCurrentUser;
	
	
	
	@FXML private TextArea boardArea;
	
	
	
    
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}
	
    public void setMenuState(ScreenState screenState) {
		mScreenState = screenState;
		mCurrentUser = mScreenState.getProfileManager().getCurrentUserProfile();
		
		
	}
    
   
    
    @FXML protected void pauseButtonAction(ActionEvent event) throws IOException {
    	mScreenState.pauseGameAction();
    }
    
    @FXML protected void exitButtonAction(ActionEvent event) throws IOException {
        mScreenState.exitGameAction();
    }

	
	public EventHandler<KeyEvent> getOnKeyPressEventHandler() {	
		return new EventHandler<KeyEvent>() {
			public void handle(KeyEvent key) {
				if (key.getCode() == KeyCode.LEFT ||
					key.getCode() == KeyCode.UP ||
					key.getCode() == KeyCode.RIGHT ||
					key.getCode() == KeyCode.DOWN)
					System.out.println("Key Pressed: " + key.getCode().toString());
				
				if (key.getCode() == KeyCode.ENTER){
					GameBoard gameBoard = new GameBoard();
					gameBoard.initGameBoard();
					boardArea.setText(gameBoard.displayBoard());
				}
					
			}
		};
	}
	


}
