package services;

import services.data.UserData;

public interface AuthenticationService {
	void registerUser(UserData user, String password);
	void loginUser(String login, String password);
}
