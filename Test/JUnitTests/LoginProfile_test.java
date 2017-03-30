import static org.junit.Assert.*;

import java.util.EventObject;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoginProfile_test {
	UserProfile testUserProfile;
	
	// executed before each test, is used to prepare the test environment
	// read input, initialise classes
	@Before
	public void createNewUserProfile() {
		testUserProfile = new UserProfile("user name", "exPassword");
	}
	
	// Fails if method takes longer that 100 milliseconds
	@Test(timeout=100)
	public void userPasswordHashCorrect() {
		
		// assertTrue(testUserProfile.getText().isEmpty());
		assertEquals(testUserProfile.getHashPassword(), "762431598");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// executed after each test, used to clean up the test environment
	// delete temporary data, restore defaults, close streams
	@After
	public void cleanUpUserProfile() {

	}
	
	// This method is executed once, before the start of all tests.
	// It is used to perform time intensive activities, for example, to connect to a database.
	// Methods marked with this annotation need to be defined as static to work with JUnit.
	@BeforeClass
	public static void createDatabaseConnection() {
		
	}
	
	// This method is executed once, after all tests have been finished.
	// It is used to perform clean-up activities, for example, to disconnect from a database.
	// Methods annotated with this annotation need to be defined as static to work with JUnit.
	@AfterClass
	public static void closeDatabaseConnection() {
		
	}
	
	/** Test Types
	 * 
	fail(message);
	// Let the method fail. Might be used to check that a certain part of the
	// code is not reached or to have a failing test before the test code is implemented. 
	// The message parameter is optional.
	
	assertTrue([message,] boolean condition);
	// Checks that the boolean condition is true.
	
	assertFalse([message,] boolean condition);
	// Checks that the boolean condition is false.
	
	assertEquals([message,] expected, actual);
	// Tests that two values are the same. Note: for arrays the reference is checked not the content of the arrays.
	
	assertEquals([message,] expected, actual, tolerance);
	// Test that float or double values match. The tolerance is the number of decimals which must be the same.
	
	assertNull([message,] object);
	// Checks that the object is null.
	
	assertNotNull([message,] object);
	// Checks that the object is not null.
	
	assertSame([message,] expected, actual);
	// Checks that both variables refer to the same object.
	
	assertNotSame([message,] expected, actual);
	// Checks that both variables refer to different objects.
	**/
}
