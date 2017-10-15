package pl.playerony.model.validation;

import pl.playerony.exception.InputException;
import pl.playerony.model.impl.User;

public class UserValidate {
	public static void checkLogin(String login) throws InputException {
		if(!Validate.checkNumbersInString(login))
			throw new InputException("Wrong marks in login");
		
		if(login.length() < 2)
			throw new InputException("Login is too short (Min length is 2)");
		
		if(login.length() > 20)
			throw new InputException("Login is too long (Max length is 20)");
	}
	
	public static void checkPassword(String password) throws InputException {
		if(password.length() < 5)
			throw new InputException("Password is too short (Min length is 5)");
		
		if(password.length() > 80)
			throw new InputException("Password is too long (Max length is 80)");
	}
	
	public static void checkUser(User user) throws InputException{
		checkLogin(user.getLogin());
		checkPassword(user.getPassword());
	}
}
