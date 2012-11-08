package servlets;

import java.util.HashMap;
import java.util.Map;

public class AccountManager {
	
	Map<String, String> accounts;
	
	public AccountManager() {
		accounts = new HashMap<String, String>();
		insertInitialAccounts();
	}
	
	private void insertInitialAccounts() {
		accounts.put("Patrick", "1234");
		accounts.put("Molly", "FloPup");
	}
	
	public void insertUser(String name, String password) throws AccountExistsException {
		if(accounts.get(name) != null) 
			throw new AccountExistsException(name);
		accounts.put(name, password);
	}
	
	public boolean checkUserExists(String name) {
		return accounts.get(name) != null;
	}
	
	public boolean checkPassword(String name, String password) {
		String pwd = accounts.get(name);
		return pwd != null && accounts.get(name).equals(password);
	}

}
