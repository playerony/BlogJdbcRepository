package pl.playerony.repository.impl;

import pl.playerony.exception.DatabaseException;
import pl.playerony.exception.InputException;
import pl.playerony.manager.SqlManager;
import pl.playerony.model.impl.Role;
import pl.playerony.repository.RoleRepository;
import pl.playerony.util.SqlUtil;

public class RoleRepositoryImpl implements RoleRepository {
	private SqlManager sqlManager;
	private SqlUtil sqlUtil;
	
	public RoleRepositoryImpl() {
		sqlManager = new SqlManager();
		sqlUtil = new SqlUtil();
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
		if(!sqlUtil.checkId("roles", id))
			throw new DatabaseException("This id[" + id + "] dont exist in roles table");
		
		String sql = "SELECT * FROM roles "
				   + "WHERE id = ?";
		
		Role role = new Role(sqlManager.createQuery(sql)
									   .setParameter(id)
									   .getSingleValue());
		
		return role;
	}

	@Override
	public Boolean removeRole(Long id) throws DatabaseException {
		if(!sqlUtil.checkId("roles", id))
			throw new DatabaseException("This id[" + id + "] dont exist in roles table");
		
		String sql = "DELETE FROM roles "
				   + "	WHERE id = ?";
		
		Integer result = sqlManager.createQuery(sql)
				   				   .setParameter(id)
				                   .executeQuery();

		return result > 0;
	}

}
