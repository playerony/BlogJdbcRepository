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
	
//	@Test
//	public void testInsertUser() {
//		User user = new User("user", "user", 2L);
//		
//		try {
//			userRepository.insertUser(user); 
//		} catch (DatabaseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InputException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	@Test
	public void testUpdateUser() {
		User user = new User(2L, "user", "user", 2L);
		
		try {
			userRepository.updateUser(user.getId(), user);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	@Test
//	public void testSelectUserById() {
//		try {
//			User user = userRepository.selectUserById(1L);
//			
//			System.out.println("Selected user by id: " + user.toString());
//		} catch (DatabaseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
//	@Test
//	public void testSelectUserByLogin() {
//		try {
//			User user = userRepository.selectUserByLogin("admin");
//			
//			if(user != null)
//				System.out.println("Selected user by login: " + user.toString());
//			else
//				System.out.println("Użytkownik nie istnieje");
//		} catch (DatabaseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
//	@Test
//	public void testSelectUsers() {
//		try {
//			List<User> users = userRepository.selectUsers();
//			
//			if(users != null)
//				users.forEach(e -> System.out.println(e.toString()));
//			else
//				System.out.println("There arent any user");
//		} catch (DatabaseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
//	@Test
//	public void testRemoveUser() {
//		try {
//			userRepository.removeUser(3L);
//		} catch (DatabaseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
}
