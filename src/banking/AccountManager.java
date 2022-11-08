package banking;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

class AccountManager {
	
	public HashSet<Account> Accounts = new HashSet<Account>();		
	Scanner scanner = new Scanner(System.in);	
	
	public void showMenu() {
		System.out.println("================ Menu ================");
		System.out.print("1. 계좌 개설");
		System.out.print("  2. 입    금");
		System.out.println("  3. 출    금");
		System.out.print("4. 계좌정보 출력");
		System.out.println("  5. 3by3 게  임");
		System.out.print("6. 자동저장옵션 설정");
		System.out.println("  7. 프로그램 종료");
		System.out.print("선택 : ");		
	}
	
	public void addAccounts() {		
		
		try {		
			System.out.println("**********신규계좌 개설**********");
			System.out.println("------------계좌선택-------------");
			System.out.print("1. 보통 계좌");
			System.out.println("    2. 신용신뢰 계좌");
			System.out.print("선택 : ");
			int choice = scanner.nextInt();		
			scanner.nextLine();
			if(choice==1) {
				System.out.print("계좌번호 : ");
				String account = scanner.nextLine();				
				System.out.print("고객이름 : ");
				String name = scanner.nextLine();			
				System.out.print("잔    고 : ");
				int balance = scanner.nextInt();
				if(balance<0) {
					MenuSelectException e = new MenuSelectException();
					throw e;
				}
				scanner.nextLine();
				System.out.print("기본이자율 (정수형태로 입력) : ");
				int interest = scanner.nextInt();
				scanner.nextLine();			
				NormalAccount NA = new NormalAccount(account, name, balance, interest); 
				if(Accounts.add(NA)) 
					Accounts.add(NA);
				else {
					System.out.printf("중복계좌가 발견되었습니다. 덮어쓸까요? (Y OR N) : ");
					String YN = scanner.nextLine();
					if(YN.equalsIgnoreCase("Y")) {
						Accounts.remove(NA);
						Accounts.add(NA);
						System.out.println("계좌 개설이 완료되었습니다.");
						System.out.println();
					}
					else if(YN.equalsIgnoreCase("N")) {
						System.out.println("덮어쓰지 않습니다. 기존의 계좌 정보를 유지합니다.");
						System.out.println();
						return;
					}
					else {
						System.out.println("잘못 입력하였습니다. 기존의 계좌 정보를 유지합니다.");
						System.out.println();
						return;
					}
				}			
			}
			if(choice==2) {
				System.out.print("계좌번호 : ");
				String account = scanner.nextLine();
				System.out.print("고객이름 : ");
				String name = scanner.nextLine();			
				System.out.print("잔    고 : ");
				int balance = scanner.nextInt();
				if(balance<0) {
					MenuSelectException e = new MenuSelectException();
					throw e;
				}
				scanner.nextLine();
				System.out.print("기본이자율 (정수형태로 입력) : ");			
				int interest = scanner.nextInt();			
				scanner.nextLine();			
				System.out.print("신용등급 (A,B,C등급) : ");
				String grade = scanner.nextLine();					
				HighCreditAccount HA = new HighCreditAccount(account, name, balance, interest, grade);	
				if(Accounts.add(HA))
					Accounts.add(HA);
				else {
					System.out.printf("중복계좌가 발견되었습니다. 덮어쓸까요? (Y OR N) : ");
					String YN = scanner.nextLine();
					if(YN.equalsIgnoreCase("Y")) {
						Accounts.remove(HA);
						Accounts.add(HA);
						System.out.println("계좌 개설이 완료되었습니다.");
						System.out.println();
					}
					else if(YN.equalsIgnoreCase("N")) {
						System.out.println("덮어쓰지 않습니다. 기존의 계좌 정보를 유지합니다.");
						System.out.println();
						return;
					}
					else {
						System.out.println("잘못 입력하였습니다. 기존의 계좌 정보를 유지하고 메뉴로 돌아갑니다.");
						System.out.println();
						return;
					}
				}
			}
		}
		catch(MenuSelectException e) {
			System.out.println("마이너스 통장은 개설할 수 없습니다.");
		}
		catch(Exception e) {
			System.out.println("알 수 없는 오류가 발생하였습니다.");
		}
	}
	
	public void depositMoney() {		
					
		System.out.println("*** 입   금 ***");
		System.out.println("계좌번호와 입금할 금액을 입력하세요.");
		System.out.print("계좌번호 : ");
		try {
			String account = scanner.nextLine();
			for(Account acc : Accounts) {
				if(account.equals(acc.account)) {
					System.out.print("입금액 : ");
					int deposit = scanner.nextInt();
					scanner.nextLine();	
					if(deposit<0) {
						System.out.println("마이너스 금액은 입금할 수 없습니다. 다시 시도해주세요.");
						return;
					}
					if(deposit%500!=0) {
						System.out.println("입금은 500원 단위로만 입금할 수 있습니다. 다시 시도해주세요.");
						return;
					}						
					acc.balance = acc.deposit(deposit);
					System.out.println("입금이 완료되었습니다.");
					return;
				}								
			}
			System.out.println("해당 계좌는 존재하지 않는 계좌입니다.");
			System.out.println();	
		}
		catch(InputMismatchException e) {
		System.out.println("잘못 입력하셨습니다. 메뉴로 돌아갑니다.");
		}
	}
	
	
	public void withdrawMoney() {		

		System.out.println("*** 출   금 ***");
		System.out.println("계좌번호와 출금할 금액을 입력하세요.");
		System.out.print("계좌번호 : ");		
		String account = scanner.nextLine();		
		
		for(Account acc : Accounts) {
			if(account.equals(acc.account)) {
				System.out.print("출금액 : ");
				int withdraw = scanner.nextInt();
				scanner.nextLine();
				if(withdraw<0) {
					System.out.println("마이너스 금액은 출금할 수 없습니다. 다시 시도해주세요.");
					return;
				}
				if(withdraw%1000!=0) {
					System.out.println("출금은 1000원 단위로만 출금할 수 있습니다. 다시 시도해주세요.");
					return;
				}
				if(withdraw > acc.balance) {
					System.out.println("잔고가 부족합니다. 금액전체를 출금할까요?");
					System.out.print("(Y : 금액전체 출금처리, N : 출금요청 취소) : ");
					String YN = scanner.nextLine();					
					if(YN.equalsIgnoreCase("Y")) {
						acc.balance -= acc.balance;
						System.out.println("출금이 완료되었습니다.");						
						return;
					}
					else if(YN.equalsIgnoreCase("N")) {
						System.out.println("출금을 취소합니다.");
						return;
					}
					else {
						System.out.println("잘못 입력하셨습니다. 출금요청을 취소합니다.");
						return;
					}
				}
				acc.balance = acc.withdraw(withdraw);
				System.out.println("출금이 완료되었습니다.");
				return;
			}					
		}
		System.out.println("해당 계좌는 존재하지 않는 계좌입니다.");
		System.out.println();
	}

	public void showAccInfo() {
		for(Account acc : Accounts)
			acc.showAccInfo();
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("전체계좌 정보출력이 완료되었습니다.");
		System.out.println();		
	}
	
	public void loadInfo() {
		try {
			ObjectInputStream in = new ObjectInputStream(
					new FileInputStream("src/banking/AccountInfo.obj")
					);
			while(true) {
				Account acc = (Account)in.readObject();				
				Accounts.add(acc);				
			}			
		}		
		catch(FileNotFoundException e) {}
		catch(Exception e) {}
	}
	
	public void saveInfo() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream("src/banking/AccountInfo.obj")
					);
			for(Account acc : Accounts) {
				out.writeObject(acc);
			}			
		}		
		catch(FileNotFoundException e) {
			System.out.println("파일이 없습니다.");			
		}
		catch(Exception e) {
			System.out.println("알 수 없는 오류가 발생하였습니다.");		
			e.printStackTrace();
		}
	}
	
	public void autoSave(AutoSaver as) {				
		
		System.out.println("자동저장 옵션을 설정합니다.");
		if(Thread.activeCount()==1) {
			System.out.println("현재 자동저장 옵션을 사용하고 있지 않습니다.");
		}
		else if(Thread.activeCount()==2) {
			System.out.println("현재 자동저장 옵션을 사용하고 있습니다.");
		}
		System.out.print("자동저장 On(1), Off(2) : ");
		String select = scanner.nextLine();
		if(select.equals("1") && Thread.activeCount()==1) {
			System.out.println("자동저장 기능을 사용합니다.");
			as.setDaemon(true);
			as.start();			
		}
		else if(select.equals("1") && Thread.activeCount()==2) {
			System.err.println("이미 자동저장이 실행중입니다.");
			return;
		}
		else if(select.equals("2")) {
			System.out.println("자동저장을 사용하지 않습니다.");
			as.interrupt();
		}
		else {
			System.out.println("잘못 입력하셨습니다. 메뉴로 돌아갑니다.");
			return;
		}
	}
}
