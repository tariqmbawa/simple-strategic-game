
public class ProfileManager {
	UserProfile mCurrentUserProfile;

	public UserProfile validateLoginDetails(String username, String password) {
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
}
