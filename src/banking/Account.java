package banking;

import java.io.Serializable;

abstract class Account implements Serializable, ICustomDefine {
	
	String account;
	String name;
	int balance;	
	
	public Account(String account, String name, int balance) {
		this.account = account;
		this.name = name;
		this.balance = balance;
	}
	
	public int deposit(int deposit) {
		return 0;
	}
	
	public int withdraw(int withdraw) {
		return 0;
	}
	
	public void showAccInfo() {
		System.out.println("----------------------------------------------------------------------------------");
		System.out.print("계좌번호 : " + account);
		System.out.print(" , 고객이름 : " + name);
		System.out.print(" , 잔  고 : " + balance);				
	}
	
	public int hashCode() {
		return account.hashCode();
	}
	
	public boolean equals(Object obj) {
		
		Account accounts = (Account) obj;
		if(account.equals(accounts.account))
			return true;
		else
			return false;
	}
	
	public String toString() {
		return "계좌번호 : " + account + ", 고객이름 : " + name + ", 잔  고 : " + balance;
	}
}	