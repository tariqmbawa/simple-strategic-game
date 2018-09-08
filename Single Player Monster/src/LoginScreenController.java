import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginScreenController implements Initializable {
	private ScreenState mScreenState;
	private ProfileManager mProfileManager;
	
	//@FXML private Button signinButton;
	
	@FXML private TextField usernameText;
	
	@FXML private PasswordField passwordText;
	
    @FXML private Text errorMessageText;
    
    @FXML private Text erText;
    
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		usernameText.setPromptText("Username");
		passwordText.setPromptText("********");
		
		
	}
    
    public void setMenuState(ScreenState screenState) {
		mScreenState = screenState;
    	mProfileManager = mScreenState.getProfileManager();
    	
    	/*mProfileManager.addUserProfile("", "");
    	mProfileManager.addUserProfile("user", "pass");
    	mProfileManager.addUserProfile("username1", "password1");
		mProfileManager.addUserProfile("username2", "password2");
		mProfileManager.addUserProfile("username3", "password3");*/
	}
    
    @FXML protected void handleLoginButtonAction(ActionEvent event) throws IOException {
    	UserProfile currentUser = mProfileManager.validateLoginDetails(new UserProfile(usernameText.getText(), passwordText.getText()));
    	System.out.println(usernameText.getText() + ", " + passwordText.getText());
    	if (currentUser != null)
    	{
    		mProfileManager.setCurrentUserProfile(currentUser);
    		mScreenState.loginAction();
    	}
    	else
    	{
    		errorMessageText.setText("Login details incorrect");
    		
    		/*for (int i = 0; i < mProfileManager.getNumberOfUsers(); ++i) {
    			System.out.println(mProfileManager.getUserProfileStringAtIndex(i));
    		}*/
    	}
    }
    
    
    @FXML protected void handleBack( ActionEvent event) {
		mScreenState.launchLoginScreen();
	}
	@FXML protected void handleRegister(ActionEvent event) throws IOException {
		mScreenState.launchRegisterScreen();
		System.out.print("Register User !!");
	}

	@FXML protected  void registerUser(ActionEvent event) {
		try {
			if(usernameText != null && passwordText != null ) {
				UserProfile newUser  = new UserProfile(usernameText.getText(), passwordText.getText());
				if(newUser.getUserName().equals("admin")) {
					newUser.setAdmin(true);
				}
				mProfileManager.addUser(newUser);
				mProfileManager.setCurrentUserProfile(newUser);
				mScreenState.loginAction();
			} else {
				errorMessageText.setText("Invalid data entered.");
			}
		} catch (Exception ex) {
			erText.setText(ex.getMessage());
		}
	}
	

	

}
























