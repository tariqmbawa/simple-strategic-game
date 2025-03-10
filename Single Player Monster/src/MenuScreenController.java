import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

public class MenuScreenController implements Initializable {
	private ScreenState mScreenState;
	UserProfile mCurrentUser;
	
	@FXML private Text usernameText;
	
	@FXML private Button logoutButton;
	
    @FXML private Text errorMessageText;
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		logoutButton.setCancelButton(true);
	}
	
    public void setMenuState(ScreenState screenState) {
		mScreenState = screenState;
		mCurrentUser = mScreenState.getProfileManager().getCurrentUserProfile();
		
		usernameText.setText(mCurrentUser.getUserName());
	}
    
    @FXML protected void handleLogoutButtonAction(ActionEvent event) throws IOException {
		mScreenState.logoutAction();
    }
    
    @FXML protected void newGameButtonAction(ActionEvent event) throws IOException {
    	mScreenState.startGameAction();
    
    }
    
    @FXML protected void highScoresButtonAction(ActionEvent event) throws IOException {
        
    }

}