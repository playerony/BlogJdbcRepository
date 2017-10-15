package pl.playerony.repository.impl;

import pl.playerony.exception.DatabaseException;
import pl.playerony.exception.InputException;
import pl.playerony.manager.SqlManager;
import pl.playerony.model.impl.Role;
import pl.playerony.repository.RoleRepository;

public class RoleRepositoryImpl implements RoleRepository {
	private SqlManager sqlManager;
	
	public RoleRepositoryImpl() {
		sqlManager = new SqlManager();
	}
	
	@Override
	public Boolean insertRole(Role newRole) throws DatabaseException, InputException {
		String sql = "INSERT INTO "
				   + "	roles(id, name) "
				   + " VALUES(?, ?)";
		
		Integer result = sqlManager.createQuery(sql)
								   .setParameter(newRole.getId())
								   .setParameter(newRole.getName())
								   .executeQuery();
		
		return result > 0;
	}

	@Override
	public Role findRoleById(Long id) throws DatabaseException {
		String sql = "SELECT * FROM roles "
				   + "WHERE id = ?";
		
		Role role = new Role(sqlManager.createQuery(sql)
									   .setParameter(id)
									   .getSingleValue());
		
		return role;
	}

	@Override
	public Boolean removeRole(Long id) throws DatabaseException {
		String sql = "DELETE FROM roles "
				   + "	WHERE id = ?";
		
		Integer result = sqlManager.createQuery(sql)
				   				   .setParameter(id)
				                   .executeQuery();

		return result > 0;
	}

}
