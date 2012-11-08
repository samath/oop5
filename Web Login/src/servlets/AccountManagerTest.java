package servlets;

import static org.junit.Assert.*;
import org.junit.*;

public class AccountManagerTest {
	
	private AccountManager am;
	
	@Before
	public void setUp() {
		am = new AccountManager();
	}
	
	@Test
	public void testStartingNames() {
		assertTrue(am.checkUserExists("Patrick"));
		assertTrue(am.checkUserExists("Molly"));
		assertFalse(am.checkUserExists("Sam"));
	}
	
	@Test
	public void testStartingPasswords() {
		assertTrue(am.checkPassword("Patrick", "1234"));
		assertTrue(am.checkPassword("Molly", "FloPup"));
		assertFalse(am.checkPassword("Molly", "password"));
		assertFalse(am.checkPassword("Sam", "password"));
	}
	
	@Test
	public void testInsert() throws Exception {
		am.insertUser("Sam", "password");
		assertTrue(am.checkUserExists("Sam"));
		assertTrue(am.checkPassword("Sam", "password"));
		try {
			am.insertUser("Sam", "new");
			assert false : "should throw AccountExistsException";
		} catch (AccountExistsException e) { /* Expected */ }
		assertTrue(am.checkPassword("Sam", "password"));
	}

}
