package shopping;

import java.sql.Types;

public class DeleteShop extends Connect {
	
	public void execute() {
		try {
			csmt = con.prepareCall("{call ShopDeleteGoods(?,?)}");
			csmt.setString(1, scanValue("삭제할 상품번호"));
			csmt.registerOutParameter(2, Types.NUMERIC);
			csmt.execute();
			System.out.print("실행결과 : "+ csmt.getString(2) +"개 행을 삭제하였습니다.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}

	public static void main(String[] args) {
		
		new DeleteShop().execute();
	}

}
