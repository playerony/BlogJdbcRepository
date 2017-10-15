package pl.playerony.repository.impl;

import java.util.List;

import pl.playerony.exception.DatabaseException;
import pl.playerony.exception.InputException;
import pl.playerony.manager.SqlManager;
import pl.playerony.model.impl.User;
import pl.playerony.model.validation.UserValidate;
import pl.playerony.repository.UserRepository;
import pl.playerony.util.SqlUtil;
import pl.playerony.util.converter.ConvertList;

public class UserRepositoryImpl implements UserRepository {
	private SqlManager sqlManager;
	private SqlUtil sqlUtil;
	
	public UserRepositoryImpl() {
		sqlManager = new SqlManager();
		sqlUtil = new SqlUtil();
	}
	
	@Override
	public Boolean insertUser(User newUser) throws DatabaseException, InputException {
		if(!sqlUtil.checkId("roles", newUser.getRoleId()))
			throw new DatabaseException("This roleId[" + newUser.getRoleId() + "] dont exist in roles table");
		
		UserValidate.checkUser(newUser);
		
		String sql = "INSERT INTO "
				   + "	users(id, login, password, roleId) "
				   + " VALUES(?, ?, ?, ?)";
		
		Integer result = sqlManager.createQuery(sql)
								   .setParameter(newUser.getId())
								   .setParameter(newUser.getLogin())
								   .setParameter(newUser.getPassword())
								   .setParameter(newUser.getRoleId())
								   .executeQuery();
		
		return result > 0;
	}

	@Override
	public Boolean updateUser(Long id, User user) throws DatabaseException, InputException {
		if(!sqlUtil.checkId("users", id))
			throw new DatabaseException("This id[" + id + "] dont exist in users table");
		
		if(!sqlUtil.checkId("roles", user.getRoleId()))
			throw new DatabaseException("This roleId[" + user.getRoleId() + "] dont exist in roles table");
		
		UserValidate.checkUser(user);
		
		String sql = "UPDATE users "
				   + "	SET login = ?, "
				   + "		password = ? "
				   + "		roleId = ? "
				   + " WHERE id = ?";
		
		Integer result = sqlManager.createQuery(sql)
								   .setParameter(user.getLogin())
								   .setParameter(user.getPassword())
								   .setParameter(user.getRoleId())
								   .setParameter(id)
								   .executeQuery();
		
		return result > 0;
	}

	@Override
	public User findUserById(Long id) throws DatabaseException {
		if(!sqlUtil.checkId("users", id))
			throw new DatabaseException("This id[" + id + "] dont exist in users table");
		
		String sql = "SELECT * "
				   + "	FROM users "
				   + " WHERE id = ?";
		
		User user = new User(sqlManager.createQuery(sql)
									   .setParameter(id)
									   .getSingleValue());
		
		return user;
	}

	@Override
	public List<User> findUsers() throws DatabaseException {
		String sql = "SELECT * "
				   + "	FROM users";
		
		List<User> users = ConvertList.castListOfObjectsToUsers(sqlManager.createQuery(sql)
															              .getExecuteList());
		
		return users;
	}

	@Override
	public Boolean removeUser(Long id) throws DatabaseException {
		if(!sqlUtil.checkId("users", id))
			throw new DatabaseException("This id[" + id + "] dont exist in users table");
		
		String sql = "DELETE FROM users "
				   + "	WHERE id = ?";
		
		Integer result = sqlManager.createQuery(sql)
				   				   .setParameter(id)
				                   .executeQuery();

		return result > 0;
	}

}
