package shopping;

import java.util.Scanner;

public class InsertShop extends Connect {	
	
	public void execute() {
		
		try {			
			Scanner scan = new Scanner(System.in);
			String query = "insert into sh_goods values (seq_total_idx.nextval, ?, ?, sysdate, ?)";		
			psmt = con.prepareStatement(query);
						
			psmt.setString(1, scanValue("상품명"));
			psmt.setString(2, scanValue("상품가격"));
			// 1.귀금속 2.가전제품 3.도서 4.의류
			psmt.setString(3, scanValue("상품코드"));			
			
			int affected = psmt.executeUpdate();
			System.out.println(affected + "행이 입력되었습니다.");
		}
		catch(Exception e) {
			System.out.println("4");
			e.printStackTrace();
		}
		finally {
			close();
		}
	}	
	
	public static void main(String[] args) {
		
		new InsertShop().execute();		
	}

}
