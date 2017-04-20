
public class UserProfile {
	private String mUsername;
	private String mPassword;
	
	public UserProfile(String aUsername, String aPassword) {
		mUsername = aUsername;
		mPassword = aPassword;
	}
	
	public String getPassword() {
		return mPassword;
	}
	private void setPassword(String aPassword) {
		mPassword = aPassword;
	}
	
	public String getUserName() {
		return mUsername;
	}
	public Boolean setUsername(String aUsername) {
		if (aUsername.length() > 2) {
			mUsername = aUsername;
			return true;
		}
		
		return false;
	}
	
	public String getHashPassword() {
		return mPassword.hashCode() + "";
	}
	
	
}
