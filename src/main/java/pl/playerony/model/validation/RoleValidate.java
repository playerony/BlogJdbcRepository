package pl.playerony.model.validation;

import pl.playerony.exception.InputException;
import pl.playerony.model.impl.Role;

public class RoleValidate {
	public static void checkRoleName(String name) throws InputException {
		if(!Validate.checkNumbersInString(name))
			throw new InputException("Wrong marks in role name");
		
		if(name.length() < 2)
			throw new InputException("Role name is too short (Min length is 2)");
		
		if(name.length() > 30)
			throw new InputException("Role name is too long (Max length is 30)");
	}
	
	public static void checkRole(Role role) throws InputException{
		checkRoleName(role.getName());
	}
}
