package banking;

import java.util.InputMismatchException;
import java.util.Scanner;

import game.Game3by3;

public class BankingSystemMain {	

	public static void main(String[] args) {		
		
		AccountManager manager = new AccountManager();
		AutoSaver as = new AutoSaver(manager);
		
		manager.loadInfo();			
		Scanner scanner = new Scanner(System.in);		
	
		while(true) {
			try {
				manager.showMenu();			
				int choice = scanner.nextInt();
				if(choice<1 || choice>7) {
					MenuSelectException e = new MenuSelectException();
					throw e;					
				}
				System.out.println();				
		
				switch(choice) {
				case ICustomDefine.MAKE:
					manager.addAccounts();					
					break;
				case ICustomDefine.DEPOSIT:
					manager.depositMoney();
					break;
				case ICustomDefine.WITHDRAW:
					manager.withdrawMoney();
					break;
				case ICustomDefine.INQUIRE:
					manager.showAccInfo();
					break;
				case ICustomDefine.GAME:
					new Game3by3().play();
					break;					
				case ICustomDefine.AUTOSAVE:
					manager.autoSave(as);					
					break;
				case ICustomDefine.EXIT:					
					System.out.println("프로그램을 종료합니다.");
					manager.saveInfo();					
					return;	
				}
			}
			catch(InputMismatchException e) {
				scanner.nextLine();
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
				System.out.println();
			}
			catch(MenuSelectException e) {
				scanner.nextLine();
				System.out.println(e.getMessage());
				System.out.println();
			}
			catch(Exception e) {
				scanner.nextLine();	
				System.out.println("알 수 없는 오류가 발생하였습니다.");
				System.out.println();
				e.printStackTrace();
			}						
		}		
	}
	
}