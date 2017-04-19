
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
	private void setUsername(String aUsername) {
		mUsername = aUsername;
	}
	
	public String getHashPassword() {
		return mPassword.hashCode() + "";
	}
	
	
}
