package shopping;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Connect {	
		
	public Connection con;
	public PreparedStatement psmt; 
	public Statement stmt;         
	public CallableStatement csmt;  
	public ResultSet rs;		
		
	public Connect() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "education", "1234");
		}
		catch(ClassNotFoundException e) {
			System.out.println("1");
			e.printStackTrace();
			}		
		catch(Exception e) {
			System.out.println("2");
			e.printStackTrace();
			}
	}	
	
	public void execute() {}		
		
	public void close() {
		try {			
			if(con!=null) con.close();
			if(psmt!=null) psmt.close();
			if(rs!=null) rs.close();			
			if(stmt!=null) stmt.close();
			if(csmt!=null) csmt.close();			
		}
		catch(Exception e) {
			System.out.println("3");
			e.printStackTrace();
		}
	}	
		
	public String scanValue(String title) {
			
		Scanner scan = new Scanner(System.in);
		System.out.print(title +"을(를) 입력(exit->종료) : ");
		String inputStr = scan.nextLine();
		if(inputStr.equalsIgnoreCase("EXIT")) {
			System.out.println("프로그램을 종료합니다.");
			close();
			System.exit(0);
		}		
		return inputStr;			
	}
	
	public static void main(String[] args) {
		new Connect();
	}
}
