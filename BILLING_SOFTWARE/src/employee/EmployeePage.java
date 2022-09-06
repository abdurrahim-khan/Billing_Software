package employee;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import billingsoftware.ChangePassword;
import billingsoftware.LoginPage;
import implementors.Implementor;

public class EmployeePage extends Implementor implements ActionListener
{
	public JFrame jf;
	JPanel jp;
	JButton jb1;
	JButton jb2;
	public static JLabel jl = new JLabel("");
	JLabel jlb, jlh;
	public EmployeePage()
	{
		createFrame();
	}
	
	
	public void createFrame()
	{
		jf = new JFrame();
		jf.setSize(500,400);
		jf.setUndecorated(true);
		jf.setBounds(400,150,500,450);
		
		jp = new JPanel();
		jp.setSize(500,400);
		jp.setLayout(null);
		jp.setBackground(Color.MAGENTA);
		jf.add(jp);
		
		//jl = new JLabel("Welcome ");
		jl.setForeground(Color.WHITE);
		jl.setFont(new Font("Arial",Font.BOLD, 20));
		jl.setBounds(5,5,200,25);
		jp.add(jl);
		
		jlh = new JLabel("Employee Dashboard");
		jlh.setForeground(Color.WHITE);
		jlh.setFont(new Font("Arial",Font.BOLD,40));
		jlh.setBounds(40,-10,500,200);
		jp.add(jlh);
		
		jb1 = new JButton("Change Password");
		jb1.setFont(new Font("Arial",Font.BOLD, 28));
		jb1.setBounds(90,170,300,80);
		jb1.addActionListener(this);
		jb1.setFocusPainted(false);
		jb1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jb1.setBackground(Color.WHITE);
		jp.add(jb1);
		
		jb2 = new JButton("Start Billing");
		jb2.setBounds(90,300,300,80);
		jb2.setFont(new Font("Arial",Font.BOLD, 28));
		jb2.setBackground(Color.WHITE);
		jb2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jb2.setFocusPainted(false);
		jb2.addActionListener(this);
		jp.add(jb2);
		
		jlb = new JLabel("Logout");
		jlb.setForeground(Color.WHITE);
		jlb.setFont(new Font("Arial",Font.BOLD, 20));
		jlb.addMouseListener(this);
		jlb.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jlb.setBounds(420,10,200,25);
		jp.add(jlb);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == jb1)
		{
			ChangePassword cp = new ChangePassword();
			cp.user_type = "Employee";
			cp.jf.setVisible(true);
			this.jf.setVisible(false);
		}
		if(e.getSource() == jb2)
		{
			StartBilling sb = new StartBilling();
			sb.jf.setVisible(true);
			this.jf.setVisible(false);
		}
		
	}
	public void mouseEntered(MouseEvent e)
	{
		if(e.getSource()==jlb)
		{
			jlb.setForeground(Color.RED);
		}
	}
	public void mouseExited(MouseEvent e)
	{
		if(e.getSource()==jlb)
		{
			jlb.setForeground(Color.WHITE);
		}
	}
	public void mouseClicked(MouseEvent e)
	{
		if(e.getSource()==jlb)
		{
			LoginPage lp = new LoginPage();
			lp.jf.setVisible(true);
			this.jf.setVisible(false);
		}
	}
}
