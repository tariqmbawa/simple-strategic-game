import java.io.Serializable;

public class UserProfile implements Serializable {
	private int mUserId;
	private String mUsername;
	private String mPassword;
	private boolean isAdmin;
	
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

	public int getmUserId() {
		return mUserId;
	}

	public void setmUserId(int mUserId) {
		this.mUserId = mUserId;
	}

	public String getHashPassword() {
		return mPassword.hashCode() + "";
	}
	
	public String toString() {
		return mUsername;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean admin) {
		isAdmin = admin;
	}

}
