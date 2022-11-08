package shopping;

import java.sql.Types;

public class UpdateShop extends Connect {
	
	public void execute() {
		
		try {
			csmt = con.prepareCall("{call ShopUpdateGoods(?, ?, ?, ?, ?)}");
			csmt.setString(1, scanValue("상품명"));
			csmt.setString(2, scanValue("상품가격"));
			csmt.setString(3, scanValue("상품번호"));
			csmt.setString(4, scanValue("상품 일련번호"));
			csmt.registerOutParameter(5, Types.NUMERIC);
			csmt.execute();
			System.out.print("실행결과 : "+ csmt.getString(5)+"개 행이 수정되었습니다.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}		
	}

	public static void main(String[] args) {
		
		new UpdateShop().execute();
	}
}