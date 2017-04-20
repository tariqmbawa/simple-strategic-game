import static org.junit.Assert.*;

import java.util.EventObject;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProfileManager_test {
	ProfileManager testProfileManager;
	UserProfile testUserProfile;
	
	@Before
	public void newUserProfile() {
		testUserProfile = new UserProfile("name", "password");
		testProfileManager = new ProfileManager();
	}
	
	@Test
	public void uesrProfileSetCorrectly() {
		assertNull(testProfileManager.getCurrentUserProfile());
		testProfileManager.setCurrentUserProfile(testUserProfile);
		assertNotNull(testProfileManager.getCurrentUserProfile());
	}
}
