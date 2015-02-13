package dbconsole;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import framesystem.FrameSystemController;




public class MySQL extends Frame implements ActionListener, WindowListener {
	
	private TextField text1 = new TextField("",10);
	private TextField text2 = new TextField("",10);
	private Button button1  = new Button("Arm_Strength");
	
	//JDBCドライバの登録
	String driver;
	//データベースの指定
	String server, dbname, url, user, password;
	Connection con;
	Statement stmt;
	ResultSet rs;
	
	
	

	public MySQL(FrameSystemController controller) {
		addWindowListener(this);
		setTitle("Chocolate_Ranking");
		setLayout(new FlowLayout(FlowLayout.CENTER));
		add(text1);
		add(text2);
		button1.addActionListener(this);
		this.driver = "org.gjt.mm.mysql.Driver";
		this.server = "j11000.sangi01.net";
		this.dbname = "50316022";
		this.url = "jdbc:mysql://"+server+"/"+dbname+"? useUnicode=true&characterEncoding=UTF-8";
		this.user = "50316022";
		this.password = "50316022";
		try {
			this.con = DriverManager.getConnection(url,user,password);
			this.stmt = con.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	try{
			Class.forName(driver);
	}catch (ClassNotFoundException e1){
			//TODO AUTO-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void close(){
		
		try {
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ResultSet selectAll(){
		String sql = "SELECT * FROM Love_You_Chocolate";
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public void setBounds(int i, int j, int k, int l) {
	
		// TODO Auto-generated method stub
	}
	public void setVisible(boolean b){
		// TODO Auto-generated method stub
	}
	@Override
	public void actionPerformed(ActionEvent e){
		// TODO Auto-generated method stub
		if(e.getSource() == button1){
			System.out.println(""+rs);
		}
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}

		
	