package dbconsole;


import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConsole_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		
		
	int Amount,Age;
		String Name;
		ResultSet rs;
		MySQL mysql = new MySQL(null);
		rs = mysql.selectAll();
		
		
				
			
		

		try {
			while(rs.next()){
				Name = rs.getString("Name");
				Amount = rs.getInt("Amount of chocolates");
				Age = rs.getInt("Age");
				
					System.out.println("NAME:"+Name);
					System.out.println("Age:"+Age);
					System.out.println("Amount of chocolates:"+Amount);
					
					
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

