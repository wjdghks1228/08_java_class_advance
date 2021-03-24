package step8_01.atm_v1;

import java.util.Scanner;

public class UserManager {

	Scanner scan = new Scanner(System.in);
	// User 라는 클래스 배열 생성
	User[] user = null;
	// User Count 0
	int userCount = 0;

	void printAllUser() {
		for (int i = 0; i < userCount; i++) {
			if (userCount != 0) {
				user[i].printAccount();
			}
		}
	}

	// 유저 추가
	void addUser() {
		// [ 객체생성 ]
		if (userCount == 0) { // 유저가 0 명일때
			user = new User[1];
		} else { // 유저가 1 명 이상일때
			User temp[] = user;
			User user[] = new User[userCount + 1];
			for (int i = 0; i < userCount; i++) {
				user[i] = temp[i];
			}
			temp = null;
		}

		// [ user추가 시작]
		System.out.println("[가입절차] ID를 입력하세요 : ");
		String id = scan.next();

		// 아이디 중복확인
		boolean isDuple = false;
		for (int i = 0; i < userCount; i++) {
			if (user[i].id.equals(id)) {
				isDuple = true; // 중복이면 isDuple : true
			}
		}

		// 중복이 아닐때 : isDuple = false일때
		if (isDuple != true) { // !isDuple
			user[userCount].id = id;
			System.out.println("[메세지] ID : " + id + "님 성공적으로 가입이 이루어졌습니다.");
			// 고객 증가
			userCount++;
		} else {
			System.out.println("**************************************************");
			System.out.println("[메세지] 중복된 ID검출 다시 시도해주시기 바랍니다.");
			System.out.println("**************************************************");
		}
	}

	User getUser(int idx) {
		return user[idx];
	}
	//로그인 기능
	int logUser() {
		int identifier = -1 ;
		System.out.println("[로그인] ID를 입력하세요 : ");
		String name = scan.next();
		//아이디 확인 후 identifier = 해당 index
		for(int i = 0 ; i < userCount ; i++) {
			if(name.equals(user[i].id)) {
				identifier = i;
			}
		}
		if(identifier == -1) {
			System.out.println("************************************************************");
			System.out.println("[메세지] 해당 ID 가 존재하지 않습니다. 다시 시도해주세요.");
			System.out.println("************************************************************");
		}
		else {
			System.out.println("[로그인 성공] "+ user[identifier].id + "님 로그인 하셨습니다.");
		}
		return identifier;
	}

	void leave() {
		int identifier = -1;
		System.out.println("[로그아웃] ID 를 입력하세요 : ");
		String name = scan.next();
		//탈퇴아이디 확인
		for(int i = 0; i < userCount ; i++) {
			if(name.equals(user[i].id)) {
				identifier = i;
			}
		}
		if(identifier == -1) {
			System.out.println("************************************************************");
			System.out.println("[메세지] 해당 ID 가 존재하지 않습니다. 다시 시도해주세요.");
			System.out.println("************************************************************");
		}
		else {
			System.out.println("[탈퇴성공]" + user[identifier].id + " 님 탈퇴 하셨습니다.");
		}
		//user 최신화
		User temp[] = user;
		user = new User[userCount-1];
		for(int i = 0 ; i< identifier; i++) {
			user[i] = temp[i];
		}
		for(int i = identifier; i< userCount - 1; i++) {
			user[i] = temp[i + 1];
		}
		userCount --;
	}
}
