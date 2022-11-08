package banking;

public class NormalAccount extends Account {
	
	int interest;
	
	public NormalAccount(String account, String name, int balance, int interest) {
		super(account, name, balance);
		this.interest = interest;
	}
	
	public void showAccInfo() {
		super.showAccInfo();
		System.out.print(" , 기본이자 : " + interest + " %");
		System.out.println();
	}
	
	public int deposit(int deposit) {
		return balance + (int)(balance * interest * 0.01) + deposit; 
	}
	
	public int withdraw(int withdraw) {
		return balance - withdraw;
	}
	
	public String toString() {
		return super.toString() + ", 기본이자 : " + interest + " %";
	}
}
