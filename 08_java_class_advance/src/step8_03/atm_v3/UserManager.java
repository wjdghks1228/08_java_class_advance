package step8_03.atm_v3;

public class UserManager {
	
	private UserManager () {}
	}
	
	User[] userList;
	int identifier = -1;
	
	
	void printAllUserInfo() {
		
	}
	
	
	void setDummy() {
		
	}

	
	int checkId(String id) {
		
	}
	
	
	void joinUser() {
		
		
	}
	
	
	void leaveUser() {
	}
	
	
	void loginUser() {
		
	}
	
	
	void logoutUser() {
		identifier = -1;
		System.out.println("[메세지]로그아웃되었습니다.\n");
	}
	
	
	void afterloginMenu() {
		
		while (true) {
			
			System.out.println("[" + userList[identifier].id + "님, 로그인]");
			System.out.println("[1]계좌생성 [2]입금하기 [3]출금하기 [4]이체하기 [5]계좌조회 "
					+ "[6]계좌삭제 [7]회원탈퇴 [0]뒤로가기");
			System.out.print("메뉴를 선택하세요 : ");
			int choice = ATM.scan.nextInt();
			
			if (choice == 1)  {
				AccountManager.getInstance().createAccount(); 
			}
			else if (choice == 2) {
				AccountManager.getInstance().income(); 
			}
			else if (choice == 3) {
				AccountManager.getInstance().outcome();
			}
			else if (choice == 4) {
				AccountManager.getInstance().transfer(); 
			}
			else if (choice == 5) {
				AccountManager.getInstance().lookupAcc(); 
			}
			else if (choice == 6) {
				AccountManager.getInstance().deleteAcc(); 
			}
			else if (choice == 7) {
				leaveUser();
				break;
			}
			else if (choice == 0) {
				logoutUser();
				break; 
			}
			
		}
		
	}
}









