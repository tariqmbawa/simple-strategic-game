import java.util.ArrayList;

public class ProfileManager {
	UserProfile mCurrentUserProfile;
	ArrayList<UserProfile> userProfiles;
	
	public ProfileManager() {
		mCurrentUserProfile = null;
		userProfiles = new ArrayList<UserProfile>();
	}
	
	public Boolean addUserProfile(String username, String password) { // can call this multiple times when program is initialised to set mock user profile data
		userProfiles.add(new UserProfile(username, password));
		return true;
	}
	
	public Boolean removeUserProfile(UserProfile userProfile) {
		return userProfiles.remove(userProfile);
	}
	
	public UserProfile getUserProfile(String username, String password) {
		// for loop compare argument with userProfiles at each index
		// return the UserProfile if the username and password match
		// return null if not found
		
		for (int i = 0; i < userProfiles.size(); ++i) {
			if (userProfiles.get(i).getUserName().equals(username))
				return userProfiles.get(i);
		}
			
			
		return null;
	}
	
	public int getNumberOfUsers() {
		return userProfiles.size();
	}
	
	public String getUserProfileStringAtIndex(int index) {
		return userProfiles.get(index).toString();
	}

	public UserProfile validateLoginDetails(String username, String password) {
		// check length maybe
		
		return getUserProfile(username, password);
		
		/*if (username.equals("user") && password.equals("pass"))
			return new UserProfile("username", "password");
		
		return null;*/
	}
	
	public void setCurrentUserProfile(UserProfile userProfile) {
		mCurrentUserProfile = userProfile;
	}
	public UserProfile getCurrentUserProfile() {
		return mCurrentUserProfile;
	}
	
	public String toString() {
		return "";
	}
	
	public Boolean writeUserProfilesToFile(String fileName) {
		// for all UserProfiles in ArrayList, add to file
		return false;
	}
	
	public Boolean readUserProfilesFromFile(String fileName) {
		// for all UserProfiles in file, add to ArrayList
		return false;
	}
}
