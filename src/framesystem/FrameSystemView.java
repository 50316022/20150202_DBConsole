package framesystem;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.text.DefaultCaret;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import dbconsole.MySQL;
public class FrameSystemView extends Frame implements ActionListener,WindowListener
{

	private Button button1 = new Button("Let's_Muscle!!");
	CardLayout cardlayout;
	Panel panel;
	Panel btnpanel;
	int ave;
	
	
	public FrameSystemView(FrameSystemController controller) {
		//TODO Auto-generated construct stub
		panel = new Panel();
		btnpanel = new Panel();
		addWindowListener(this);
		setTitle("Powerful_Animals");
		cardlayout = new CardLayout();
		setLayout(cardlayout);
		btnpanel.add(button1,BorderLayout.CENTER);
		add(btnpanel);
		add(panel);
		button1.addActionListener(this);
	}

	

	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==button1){
			int rgs,lgs;
			String name,rank;
			ResultSet rs;
			MySQL mysql = new MySQL(null);
			rs = mysql.selectAll();
			DefaultCategoryDataset data = new DefaultCategoryDataset();
			try{
				panel.add(new Label("DataBase Loaded"));
				while(rs.next()){
					ave = 0;
					name = rs.getString("name");
					rgs = rs.getInt("R_Grip_Strength");
					lgs = rs.getInt("L_Grip_Strength");
					rank = rs.getString("Rank");
					ave = (rgs+lgs)/2;
					data.addValue(ave,name,""+name);
					panel.add(new Label("Name:"+name+"	R_Grip_Strength:"+rgs+"	L_Grip_Strength:"+lgs+"	Rank:"+rank));
				}
					
			}catch(SQLException et){
			}
			JFreeChart chart = ChartFactory.createBarChart("Grip_strength",
					"name",
					"Grip_Strength_Average",
					data,
					PlotOrientation.VERTICAL,
					true,
					false,
					false);
			ChartPanel cpanel = new ChartPanel(chart);
			panel.add(cpanel);
			cardlayout.next(this);
		}
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
		//TODO Auto-generated method stub
		
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		//TODO Auto-generated method stub
		System.exit(0);
		
	}
	
	@Override
	public void windowClosed(WindowEvent e) {
		//TODO Auto-generated method stub
		
	}
	
	@Override
	public void windowIconified(WindowEvent e) {
		//TODO Auto-generated method stub
	}
	
	@Override
	public void windowActivated(WindowEvent e) {
		//TODO Auto-generated method stub
	}
	
	@Override
	public void windowDeactivated(WindowEvent e) {
		//TODO Auto-generated method stub
	}



	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
