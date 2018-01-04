package pl.playerony.repository;

import java.util.List;

import pl.playerony.exception.DatabaseException;
import pl.playerony.exception.InputException;
import pl.playerony.model.impl.User;

public interface UserRepository {
	User insertUser(User newUser) throws DatabaseException, InputException;
	
	Boolean updateUser(Long id, User user) throws DatabaseException, InputException;
	
	User selectUserById(Long id) throws DatabaseException;
	
	User selectUserByLogin(String login) throws DatabaseException;
	
	List<User> selectUsers() throws DatabaseException;
	
	Boolean removeUser(Long id) throws DatabaseException;
}
