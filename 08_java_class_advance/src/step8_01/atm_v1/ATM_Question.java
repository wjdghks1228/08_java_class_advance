package step8_01.atm_v1;

import java.util.Random;
import java.util.Scanner;

public class ATM_Question {

	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	UserManager userManager = new UserManager();
	int identifier = -1;

	void printMainMenu() {

		while (true) {

			System.out.println("\n[ MEGA ATM ]");
			System.out.print("[1.로그인] [2.로그아웃] [3.회원가입] [4.회원탈퇴] [0.종료] : ");
			int sel = scan.nextInt();

			if (sel == 1)
				login();
			else if (sel == 2)
				logout();
			else if (sel == 3)
				join();
			else if (sel == 4)
				leave();
			else if (sel == 0) {
				System.out.println("[메시지] 프로그램을 종료합니다.");
				break;
			}

		}

	}

	void login() {

		identifier = userManager.logUser();

		if (identifier != -1) {
			printAccountMenu();
		} else {
			System.out.println("[메세지] 로그인실패.");
		}

	}

	void join() {

		userManager.addUser();

	}

	void logout() {

		if (identifier == -1) {
			System.out.println("[메시지] 로그인을 하신 후 이용하실 수 있습니다.");
		} else {
			identifier = -1;
			System.out.println("[메시지] 로그아웃 되었습니다.");
		}

	}

	void leave() {

		userManager.leave();

	}

	void printAccountMenu() {

		while (true) {
			System.out.print("[1.계좌생성] [2.계좌삭제] [3.조회] [0.로그아웃] : ");
			int sel = scan.nextInt();
			String makeAccount = Integer.toString(ran.nextInt(90001) + 10000);
			if (sel == 1) {

				// 만약 현재 계좌가 아무것도 없을떄
				if (userManager.user[identifier].accCount == 0) {
					// Account 객체 하나 생성
					userManager.user[identifier].acc = new Account[1];
					userManager.user[identifier].acc[0] = new Account();
					// 랜덤 계좌생성후 대입
					userManager.user[identifier].acc[0].number = makeAccount;
					System.out.println(userManager.user[identifier].id + "님 새로운 계좌 " + "[" + userManager.user[identifier].acc[0].number + "] 가 생성되었습니다." );
					
					userManager.user[identifier].accCount++;
				}
				else if(userManager.user[identifier].accCount != 0) {
					int tempAccCount = userManager.user[identifier].accCount;
					Account[] temp = userManager.user[identifier].acc;
					userManager.user[identifier].acc = new Account[tempAccCount + 1];
					for(int i = 0 ; i < tempAccCount; i++) {
						userManager.user[identifier].acc[i] = temp[i];
					}
					userManager.user[identifier].acc[tempAccCount] = new Account();
					userManager.user[identifier].acc[tempAccCount].number = makeAccount;
					System.out.println(userManager.user[identifier].id + "님 새로운 계좌 " + "[" + userManager.user[identifier].acc[tempAccCount].number + "] 가 생성되었습니다." );
					
					
					userManager.user[identifier].accCount++;
					
					System.out.println();
					System.out.println();
				}
			} else if (sel == 2) {
				if (userManager.user[identifier].accCount == 0) {
					System.out.println("삭제하실 계좌가 없습니다.");
				} else if (userManager.user[identifier].accCount > 0) {
					// 현재 있는 계좌 출력
					System.out.println("[" + userManager.user[identifier].accCount + " 개의 계좌 보유]");
					for (int i = 0; i < userManager.user[identifier].accCount; i++) {
						System.out.println(userManager.user[identifier].acc[i].number);
					}
					System.out.println("삭제하실 계좌를 입력하세요 : ");
					String delAccount = scan.next();
					int delIdx = -1;
					// 삭제할 계좌 인덱스찾기
					for (int i = 0; i < userManager.user[identifier].accCount; i++) {
						if (userManager.user[identifier].acc[i].number.equals(delAccount)) {
							delIdx = i;
						}
					}
					if (delIdx == -1) {
						System.out.println("삭제 계좌 오류");
					} else if (delIdx != -1) {
						// 삭제 프로세스
						Account temp[] = userManager.user[identifier].acc;
						userManager.user[identifier].acc = new Account[userManager.user[identifier].accCount - 1];

						// 객체 대입
						for (int i = 0; i < delIdx; i++) {
							userManager.user[identifier].acc[i] = temp[i];
						}
						for (int i = delIdx; i < userManager.user[identifier].accCount - 1; i++) {
							userManager.user[identifier].acc[i] = temp[i + 1];
						}
						System.out.println("==============================================================");
						System.out.println("[삭제처리완료]");
						System.out.println("==============================================================");
						System.out.println();
						System.out.println();
					}
					userManager.user[identifier].accCount --;
				}
			} else if (sel == 3) {
				System.out.println("==============================================================");
				System.out.println("[계좌조희]");
				System.out.println("==============================================================");
				if(userManager.user[identifier].accCount == 0) {
					System.out.println("[메세지] 조회할 계좌가 없습니다.");
					System.out.println();
				}
				else if(userManager.user[identifier].accCount > 0) {
					userManager.user[identifier].printAccount();
					System.out.println();
					System.out.println("==============================================================");
					System.out.println("[계좌조희완료]");
					System.out.println("==============================================================");
					System.out.println();
					System.out.println();
				}
			} 
			else if (sel == 0) {
				logout();
				break;
			} // 구현해 보시오.
		}

	}
}
