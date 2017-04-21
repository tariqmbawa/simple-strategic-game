
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class ScreenState extends Application {
	private final double MINIMUM_WINDOW_WIDTH = 800.0;
    private final double MINIMUM_WINDOW_HEIGHT = 500.0;
	
	private Stage mStage;
    private ProfileManager mProfileManager;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
    public void start(Stage stage) {  
		try {
			mProfileManager = new ProfileManager();
			
			mStage = stage;
			mStage.setTitle("Single Player Monster");
			mStage.setMinWidth(MINIMUM_WINDOW_WIDTH);
			mStage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
	        launchLoginScreen();
	        mStage.show();
	        
		} catch (Exception ex) {
			Logger.getLogger(ScreenState.class.getName()).log(Level.SEVERE, null, ex);
			
		}
    }
	
	public ProfileManager getProfileManager() {
		return mProfileManager;
	}
	
	public void logoutAction() {
		/** TODO: Clear current UserProfile, save any data **/
		mProfileManager.setCurrentUserProfile(null);
		launchLoginScreen();
	}
	
	public void loginAction() {
		/** TODO: call init and load level **/
		launchMenuScreen();
	}
	
	public void startGameAction() {
		/** TODO: call init and load level **/
		launchGameScreen();
	}
	
	public void pauseGameAction() {
		/** TODO: call init and load level **/
	
	}
	
	public void exitGameAction() {
		/** TODO: call init and load level **/
		launchMenuScreen();
	}
	
	private void launchLoginScreen() {
		try {
			FXMLLoader loader = new FXMLLoader(
					getClass().getResource("fxml_layout/login_screen_layout.fxml")
			);
			
			Parent root = loader.load();
			Scene scene = new Scene(root, MINIMUM_WINDOW_WIDTH, MINIMUM_WINDOW_HEIGHT);
			mStage.setScene(scene);
			
			LoginScreenController loginScreenController = loader.getController();
			loginScreenController.setMenuState(this);
			
		} catch (Exception ex) {
			Logger.getLogger(ScreenState.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	private void launchMenuScreen() {
		try {
			FXMLLoader loader = new FXMLLoader(
					getClass().getResource("fxml_layout/menu_screen_layout.fxml")
			);
			
			Parent root = loader.load();
			Scene scene = new Scene(root, MINIMUM_WINDOW_WIDTH, MINIMUM_WINDOW_HEIGHT);
			mStage.setScene(scene);
			
			MenuScreenController menuScreenController = loader.getController();
			menuScreenController.setMenuState(this);
			
		} catch (Exception ex) {
			Logger.getLogger(ScreenState.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	


	private void launchGameScreen() {
		try {
			FXMLLoader loader = new FXMLLoader(
					getClass().getResource("fxml_layout/game_screen_layout.fxml")
			);
			
			Parent root = loader.load();
			Scene scene = new Scene(root, MINIMUM_WINDOW_WIDTH, MINIMUM_WINDOW_HEIGHT);
			mStage.setScene(scene);
			
			GameScreenController gameScreenController = loader.getController();
			gameScreenController.setMenuState(this);
			
			root.setOnKeyPressed(gameScreenController.getOnKeyPressEventHandler());
			
		} catch (Exception ex) {
			Logger.getLogger(ScreenState.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
