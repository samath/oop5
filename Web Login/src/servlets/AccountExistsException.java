package servlets;

public class AccountExistsException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public final String accountName;
	
	public AccountExistsException(String accountName) {
		super();
		this.accountName = accountName;
	}

}
