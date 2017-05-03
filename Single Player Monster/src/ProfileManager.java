import java.util.ArrayList;

public class ProfileManager {
	UserProfile mCurrentUserProfile;
	ArrayList<UserProfile> userProfiles;
	
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
		return null;
	}

	public UserProfile validateLoginDetails(String username, String password) {
		// use getUserProfile instead of this
		// replace in JUnit tests
		
		if (username.equals("user") && password.equals("pass"))
			return new UserProfile("username", "password");
		
		return null;
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
}
