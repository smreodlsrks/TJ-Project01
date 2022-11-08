package shopping;

import java.sql.SQLException;

public class SelectShop extends Connect {
	
	public void execute() {
	
		try {
			String scan = scanValue("찾는 이름");			
			stmt = con.createStatement();
			
			String query = "select g_idx, goods_name, ltrim(to_char(goods_price, '999,999,000')),"
					+ " to_char(regidate, 'yyyy.mm.dd hh24:mi') from sh_goods where goods_name like '%" + scan + "%'";
			
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String price = rs.getString(3);
				String date = rs.getString(4);				
				
				System.out.printf("%s, %s, %s, %s\n", id, name, price, date);
			}
		}
		catch(SQLException e) {
			System.out.println("쿼리오류발생");
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();			
		}
		finally {
			close();
		}
	}

	public static void main(String[] args) {
		
		new SelectShop().execute();
	}

}
