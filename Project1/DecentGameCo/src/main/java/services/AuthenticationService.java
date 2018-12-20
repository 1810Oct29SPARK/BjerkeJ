package services;

import beans.Credentials;
import beans.User;

public class AuthenticationService {

	public AuthenticationService() {
	}

	public User isValidUser(Credentials credentials) {
		User u = null;
		String username = credentials.getUsername();
		String password = credentials.getPassword();
		//take credentials and return user to which they belong if it exists
		if(username != null && password != null) {
			if(username.equals("JerBjer") && password.equals("12345")) {
				u = new User(10061, username, "Jeremy", "Bjerke", "jerCEO@company.com");
			}
		}
		return null;
	}
	
}
