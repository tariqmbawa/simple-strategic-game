import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.net.URL;
import java.util.ResourceBundle;


public class AdminMainMenuController implements Initializable {
    private final double MINIMUM_WINDOW_WIDTH = 800.0;
    private final double MINIMUM_WINDOW_HEIGHT = 500.0;
    
    private ScreenState screenState;
    private  ProfileManager profileManager;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    @FXML
    public void handleQuit(ActionEvent event) {
        System.exit(0);
    }
    
    @FXML
    public void handleGameSettings(ActionEvent event) {
        
    }
    
    @FXML
    public void handleViewPlayers(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml_layout/admin_screen.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, MINIMUM_WINDOW_WIDTH, MINIMUM_WINDOW_HEIGHT);
            screenState.getmStage().setScene(scene);
            AdminController controller = loader.getController();
            controller.setProfileManager(getProfileManager());
            controller.setScreenState(screenState);
        } catch (Exception e) {
            e.printStackTrace();
            
        }
       
    }

    public ScreenState getScreenState() {
        return screenState;
    }

    public void setScreenState(ScreenState screenState) {
        this.screenState = screenState;
    }

    public ProfileManager getProfileManager() {
        return profileManager;
    }

    public void setProfileManager(ProfileManager profileManager) {
        this.profileManager = profileManager;
    }
}
