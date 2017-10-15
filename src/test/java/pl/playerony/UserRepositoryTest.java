package pl.playerony;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import pl.playerony.exception.DatabaseException;
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
	public void testSelectUsers() {
		try {
			List<User> users = userRepository.findUsers();
			
			users.forEach(e -> System.out.println(e.toString()));
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
