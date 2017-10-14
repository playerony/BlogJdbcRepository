package pl.playerony.repository.impl;

import pl.playerony.exception.DatabaseException;
import pl.playerony.exception.InputException;
import pl.playerony.manager.SqlManager;
import pl.playerony.model.Role;
import pl.playerony.repository.RoleRepository;

public class RoleRepositoryImpl implements RoleRepository {
	private SqlManager sqlManager;
	
	public RoleRepositoryImpl() {
		sqlManager = new SqlManager();
	}
	
	@Override
	public Boolean insertRole(Role newRole) throws DatabaseException, InputException {
		String sql = "INSERT INTO roles(id, name) VALUES(?, ?)";
		
		Integer result = sqlManager.createQuery(sql)
								   .setParameter(newRole.getId().toString())
								   .setParameter(newRole.getName())
								   .executeQuery();
		
		return result > 0;
	}

	@Override
	public Boolean findRoleById(Long id) throws DatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeRole(Long id) throws DatabaseException {
		// TODO Auto-generated method stub
		
	}

}
