package banking;

import java.io.FileWriter;
import java.io.PrintWriter;

class AutoSaver extends Thread {
	
	AccountManager am;
		
	public AutoSaver(AccountManager am) {
		this.am = am;
	}

	public void save() {
		try {			
			PrintWriter out = new PrintWriter(new FileWriter("src/banking/AutoSaveAccount.txt"));
			for(Account acc : am.Accounts) {				
				out.println(acc);		
			}		
			out.println();
			out.close();
		}
		catch(Exception e) {}
	}
	
	public void run() {		
		while(true) {
			try {
				save();
				sleep(5000);				
//				System.out.println("자동저장이 실행중입니다..");			
			}					
			catch(InterruptedException e) {
				System.out.println("자동저장을 종료합니다.");
				return;
			}
			catch(Exception e) {
				System.out.println("알 수 없는 오류가 발생하였습니다.");		
				e.printStackTrace();
			}
		}
	}
}
