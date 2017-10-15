package pl.playerony.repository;

import pl.playerony.exception.DatabaseException;
import pl.playerony.exception.InputException;
import pl.playerony.model.impl.Role;

public interface RoleRepository {
	Boolean insertRole(Role newRole) throws DatabaseException, InputException;

	Role findRoleById(Long id) throws DatabaseException;
	
	Boolean removeRole(Long id) throws DatabaseException;
}
