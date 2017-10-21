package pl.playerony.repository.impl;

import java.util.List;

import pl.playerony.exception.DatabaseException;
import pl.playerony.exception.InputException;
import pl.playerony.manager.SqlManager;
import pl.playerony.model.impl.Role;
import pl.playerony.model.validation.RoleValidate;
import pl.playerony.repository.RoleRepository;
import pl.playerony.util.SqlUtil;
import pl.playerony.util.converter.ConvertList;

public class RoleRepositoryImpl implements RoleRepository {
	private SqlManager sqlManager;
	private SqlUtil sqlUtil;
	
	public RoleRepositoryImpl() {
		sqlManager = new SqlManager();
		sqlUtil = new SqlUtil();
	}
	
	@Override
	public Role insertRole(Role newRole) throws DatabaseException, InputException {
		if(sqlUtil.checkStringValue("roles", "name", newRole.getName()))
			throw new DatabaseException("This name of role[" + newRole.getName() + "] already exist in roles table");
		
		RoleValidate.checkRole(newRole);
		
		String sql = "INSERT INTO "
				   + " roles (id, name) "
				   + " VALUES(?, ?)";
		
		Long result = sqlManager.createQuery(sql)
								.setParameter(newRole.getId())
								.setParameter(newRole.getName())
								.executeQueryWithGenereateKey();
		
		newRole.setId(result);
		
		return newRole;
	}
	
	@Override
	public Boolean updateRole(Long id, Role role) throws DatabaseException, InputException {
		if(!sqlUtil.checkId("roles", id))
			throw new DatabaseException("This id[" + id + "] doesnt exist in roles table");
					
		if(sqlUtil.checkStringValue("roles", "name", role.getName()))
			throw new DatabaseException("This name of role[" + role.getName() + "] already exist in roles table");
		
		RoleValidate.checkRole(role);
		
		String sql = "UPDATE roles "
				   + "	SET name = ?, "
				   + " WHERE id = ?";
		
		Integer result = sqlManager.createQuery(sql)
								   .setParameter(role.getName())
								   .setParameter(id)
								   .executeQuery();
		
		return result > 0;
	}
		
	@Override
	public Role selectRoleById(Long id) throws DatabaseException {
		if(!sqlUtil.checkId("roles", id))
			throw new DatabaseException("This id[" + id + "] doesnt exist in roles table");
		
		String sql = "SELECT * "
				   + "  FROM roles "
				   + " WHERE id = ?";
		
		Role role = new Role(sqlManager.createQuery(sql)
									   .setParameter(id)
									   .getSingleValue());
		
		return role;
	}
	
	@Override
	public Role selectRoleByName(String name) throws DatabaseException {
		if(!sqlUtil.checkStringValue("roles", "name", name))
			throw new DatabaseException("This name of role[" + name + "] doesnt exist in roles table");
		
		String sql = "SELECT * "
				   + "  FROM roles "
				   + " WHERE name = ?";
		
		Role role = new Role(sqlManager.createQuery(sql)
									   .setParameter(name)
									   .getSingleValue());
		
		return role;
	}
	
	@Override
	public Boolean checkRoleByName(String name) throws DatabaseException {
		String sql = "SELECT * "
				   + "	FROM roles "
				   + " WHERE name = ?";
		
		Boolean result = sqlManager.createQuery(sql)
									   .setParameter(name)
									   .isExist();
		
		return result;
	}
	
	@Override
	public List<Role> selectRoles() throws DatabaseException {
		String sql = "SELECT * "
				   + "	FROM roles";
		
		List<Role> roles = ConvertList.castObjectArrayToRoleList(sqlManager.createQuery(sql)
															               .getExecuteList());
		
		return roles;
	}

	@Override
	public Boolean removeRole(Long id) throws DatabaseException {
		if(!sqlUtil.checkId("roles", id))
			throw new DatabaseException("This id[" + id + "] doesnt exist in roles table");
		
		String sql = "DELETE FROM roles "
				   + "	WHERE id = ?";
		
		Integer result = sqlManager.createQuery(sql)
				   				   .setParameter(id)
				                   .executeQuery();

		return result > 0;
	}

}
