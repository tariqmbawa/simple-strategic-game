
public class UserProfile {
	private String mUsername;
	private String mPassword;
	
	public UserProfile(String username, String password) {
		mUsername = username;
		mPassword = password;
	}
	
	public String getPassword() {
		return mPassword;
	}
	private Boolean setPassword(String password) {
		if (password.length() > 4) { // move check to profile manager to check on input rather than on set // make this as assert(false)
			mPassword = password;
			return true;
		}
		
		return false;
	}
	
	public String getUserName() {
		return mUsername;
	}
	public Boolean setUsername(String username) {
		if (username.length() > 2) {
			mUsername = username;
			return true;
		}
		
		return false;
	}
	
	public String getHashPassword() {
		return mPassword.hashCode() + "";
	}
	
	
}
