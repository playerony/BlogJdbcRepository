package pl.playerony;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import pl.playerony.exception.DatabaseException;
import pl.playerony.exception.InputException;
import pl.playerony.model.impl.Role;
import pl.playerony.repository.RoleRepository;
import pl.playerony.repository.impl.RoleRepositoryImpl;

public class RoleRepositoryTest {
	private RoleRepository roleRepository;
	
	@Before
	public void initialize() {
		roleRepository = new RoleRepositoryImpl();
	}
	
//	@Test
//	public void testInsertRole() {
//		Role role = new Role("TESTNAME");
//		
//		try {
//			Role r = roleRepository.insertRole(role);
//			System.out.println(r.toString());
//		} catch (DatabaseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InputException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testUpdateRole() {
//		Role role = new Role("xd");
//		
//		try {
//			roleRepository.updateRole(4L, role);
//		} catch (DatabaseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InputException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testSelectRoleById() {
//		try {
//			Role role = roleRepository.selectRoleById(1L);
//			
//			System.out.println(role.toString());
//		} catch (DatabaseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	@Test
	public void testSelectRoleByName() {
		try {
			Role role = roleRepository.selectRoleByName("ADMIN1");
			
			System.out.println(role.toString());
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	@Test
//	public void testSelectRoles() {
//		try {
//			List<Role> roles = roleRepository.selectRoles();
//			
//			roles.forEach(e -> System.out.println(e.toString()));
//		} catch (DatabaseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
//	@Test
//	public void testRemoveRole() {
//		try {
//			roleRepository.removeRole(4L);
//		} catch (DatabaseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
}
