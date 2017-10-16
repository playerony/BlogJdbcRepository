package pl.playerony;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import pl.playerony.exception.DatabaseException;
import pl.playerony.exception.InputException;
import pl.playerony.model.impl.User;
import pl.playerony.repository.UserRepository;
import pl.playerony.repository.impl.UserRepositoryImpl;

public class UserRepositoryTest {
	private UserRepository userRepository;
	
	@Before
	public void initialize() {
		userRepository = new UserRepositoryImpl();
	}
	
	@Test
	public void testInsertUser() {
		User user = new User("admin", "admin", 1L);
		
		try {
			userRepository.insertUser(user); 
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUpdateUser() {
		User user = new User("admin1", "admin1", 1L);
		
		try {
			userRepository.updateUser(1L, user);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSelectUser() {
		try {
			User user = userRepository.findUserById(1L);
			
			System.out.println(user.toString());
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSelectUsers() {
		try {
			List<User> users = userRepository.findUsers();
			
			users.forEach(e -> System.out.println(e.toString()));
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testRemoveUser() {
		try {
			userRepository.removeUser(2L);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
