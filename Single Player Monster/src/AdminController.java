import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;


public class AdminController implements Initializable {

    private ScreenState screenState;
    private  ProfileManager profileManager;
    @FXML private ListView allUsers;
    private ObservableList<UserProfile> items = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        items = FXCollections.observableArrayList (ProfileManager.getAllUsers());
        allUsers.setItems(items);
        allUsers.setMouseTransparent( false );
    }
    @FXML public void handleMouseClick(MouseEvent arg0) {
        System.out.println("clicked on " + allUsers.getSelectionModel().getSelectedItem());
    }
    
    @FXML
    protected  void deleteUser(ActionEvent event) {
        UserProfile userProfile = (UserProfile)allUsers.getSelectionModel().getSelectedItem();
        profileManager.deleteUser(userProfile);
        allUsers.getItems().remove(userProfile);
        allUsers.refresh();
    }

    @FXML protected void handleBack( ActionEvent event) {
        screenState.menuAction();
    }


    public ProfileManager getProfileManager() {
        return profileManager;
    }

    public void setProfileManager(ProfileManager profileManager) {
        this.profileManager = profileManager;
    }

    public ListView getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(ListView allUsers) {
        this.allUsers = allUsers;
    }

    public ScreenState getScreenState() {
        return screenState;
    }

    public void setScreenState(ScreenState screenState) {
        this.screenState = screenState;
    }
}
