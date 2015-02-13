package dbconsole;


import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConsole_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		
		
	int rgs,lgs;
		String name,rank;
		ResultSet rs;
		MySQL mysql = new MySQL(null);
		rs = mysql.selectAll();
		
		
				
			
		

		try {
			while(rs.next()){
				name = rs.getString("name");
				rgs = rs.getInt("R_Grip_Strength");
				lgs = rs.getInt("L_Grip_Strength");
				rank = rs.getString("Rank");
					System.out.println("NAME:"+name);
					System.out.println("Right_Grip_Strength:"+rgs);
					System.out.println("Left_Grip_Strength:"+lgs);
					System.out.println("Rank:"+rank);
					
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

