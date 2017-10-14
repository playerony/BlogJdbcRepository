package pl.playerony.repository;

import pl.playerony.exception.DatabaseException;
import pl.playerony.exception.InputException;
import pl.playerony.model.Role;

public interface RoleRepository {
	Boolean insertRole(Role newRole) throws DatabaseException, InputException;

	Boolean findRoleById(Long id) throws DatabaseException;
	
	void removeRole(Long id) throws DatabaseException;
}
