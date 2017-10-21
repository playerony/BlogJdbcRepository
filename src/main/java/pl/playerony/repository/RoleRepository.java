package pl.playerony.repository;

import java.util.List;

import pl.playerony.exception.DatabaseException;
import pl.playerony.exception.InputException;
import pl.playerony.model.impl.Role;

public interface RoleRepository {
	Role insertRole(Role newRole) throws DatabaseException, InputException;
	
	Boolean updateRole(Long id, Role role) throws DatabaseException, InputException;

	Role selectRoleById(Long id) throws DatabaseException;
	
	Role selectRoleByName(String name) throws DatabaseException;
	
	Boolean checkRoleByName(String name) throws DatabaseException;
	
	List<Role> selectRoles() throws DatabaseException;
	
	Boolean removeRole(Long id) throws DatabaseException;
}
