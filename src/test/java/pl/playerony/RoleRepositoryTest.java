package pl.playerony;

import org.junit.Before;
import org.junit.Test;

import pl.playerony.exception.DatabaseException;
import pl.playerony.exception.InputException;
import pl.playerony.model.Role;
import pl.playerony.repository.RoleRepository;
import pl.playerony.repository.impl.RoleRepositoryImpl;

public class RoleRepositoryTest {
	private RoleRepository roleRepository;
	
	@Before
	public void initialize() {
		roleRepository = new RoleRepositoryImpl();
	}
	
	@Test
	public void testInsertRole() {
		Role role = new Role("ADMIN");
		
		try {
			roleRepository.insertRole(role);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
