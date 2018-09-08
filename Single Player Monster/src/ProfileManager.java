import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProfileManager {
	UserProfile currentUser = null;
	static List<UserProfile> allUsers =  new ArrayList<>();
	static final File FILE_NAME = new File(System.getProperty("user.dir") + File.separator + "users.db");

	private void refresh() {
		System.out.print(FILE_NAME.getPath());
		try {
			if(!FILE_NAME.exists()) {
				FileOutputStream fos = new FileOutputStream(FILE_NAME);
				fos.close();
			} else {
				allUsers = load();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addUser(UserProfile user) {
		if(null != user) {
			UserProfile userProfile = findUser(user);
			if(userProfile == null) {
				user.setmUserId(allUsers.size() + 1);
				allUsers.add(user);
				persist();
			} else {
				throw new RuntimeException("User Already exists!");
			}
		}
	}

	public void deleteUser(UserProfile username) {
		if(null != username) {
			allUsers.remove(username);
			persist();
		}
	}
	
	private UserProfile findUser(UserProfile user) {
		if(allUsers.size() == 0) {
			refresh();
		}
		return allUsers.stream().filter( u -> u.getUserName()
                                                .equals(user.getUserName())
                                        ).findAny().orElse(null);
	}

	private final void persist() {
		try {
			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
			outputStream.writeObject(allUsers);
			outputStream.flush();
			outputStream.close();
			System.out.println("User.db updated.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		refresh();
	}

	public UserProfile validateLoginDetails(UserProfile user) {
		UserProfile userProfile = findUser(user);
		if(userProfile != null && userProfile.getPassword().equals(user.getPassword())) {
			return userProfile;
		}
		return null;
	}

	private final List<UserProfile> load() {
		try {
			FileInputStream fis = new FileInputStream(FILE_NAME);
			ObjectInputStream inputStream = new ObjectInputStream(fis);
			List<UserProfile> userProfiles = (ArrayList<UserProfile>) inputStream.readObject();
			inputStream.close();
			fis.close();
			return userProfiles;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void setCurrentUserProfile(UserProfile user) {
		currentUser = user;
	}

	public UserProfile getCurrentUserProfile() {
		return currentUser;
	}

	public static List<UserProfile> getAllUsers() {
		return allUsers;
	}
}
