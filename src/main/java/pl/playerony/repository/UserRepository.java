package pl.playerony.repository;

import java.util.List;

import pl.playerony.exception.DatabaseException;
import pl.playerony.exception.InputException;
import pl.playerony.model.User;

public interface UserRepository {
	User insertUser(User newUser) throws DatabaseException, InputException;
	
	User updateUser(Long id, User user) throws DatabaseException, InputException;
	
	User findUserById(Long id) throws DatabaseException;
	
	List<User> findUsers() throws DatabaseException;
	
	void removeUser(Long id) throws DatabaseException;
}