package step8_03.atm_v3;


public class AccountManager {

	private AccountManager() {}
	private static AccountManager instance = new AccountManager();
	public static AccountManager getInstance() {
		return instance;
	}
	
	UserManager userManager = UserManager.getInstance();
	
	void createAccount() {
	}
	
	
	int showAccList(String msg) {
	}
	
	
	void income() {
	}
	
	
	void outcome() {
		
		
	}
	
	
	int checkAcc(String transAccount) {
		
	}
	
	
	int getAccIndex(int transUserIndex, String transAccount) {
		
	}
	
	
	void transfer() {
		
	}
	
	
	void lookupAcc() {
		userManager.userList[userManager.identifier].printOneUserAllAccounts();
	}

	
	void deleteAcc() {
		
	
	}
	
	
}
