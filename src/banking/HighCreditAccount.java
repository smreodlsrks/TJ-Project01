package banking;

public class HighCreditAccount extends Account {
	
	int interest;
	String grade;
	
	public HighCreditAccount
	(String account, String name, int balance, int interest, String grade) {
		super(account, name, balance);
		this.interest = interest;
		this.grade = grade;
	}
	
	public int deposit(int deposit) {
		if(grade.equalsIgnoreCase("A"))
			return balance + (int)(balance * interest * 0.01) + (int)(balance * ICustomDefine.A * 0.01) + deposit;
		else if(grade.equalsIgnoreCase("B"))
			return balance + (int)(balance * interest * 0.01) + (int)(balance * ICustomDefine.B * 0.01) + deposit;
		else if(grade.equalsIgnoreCase("C"))
			return balance + (int)(balance * interest * 0.01) + (int)(balance * ICustomDefine.C * 0.01) + deposit;
		else
			return 0;
	}
	
	public int withdraw(int withdraw) {
		return balance - withdraw;
	}
	
	public void showAccInfo() {
		super.showAccInfo();
		System.out.print(" , 기본이자 : " + interest + " %");
		System.out.print(" , 신용등급 : " + grade.toUpperCase());
		System.out.println();
	}
	
	public String toString() {
		return super.toString() + ", 기본이자 : " + interest + " %, 등급 : " + grade.toUpperCase();
	}
}

