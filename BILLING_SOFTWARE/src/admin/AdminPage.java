package admin;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import billingsoftware.ChangePassword;
import billingsoftware.LoginPage;
import implementors.Implementor;

public class AdminPage extends Implementor implements ActionListener
{
	public AdminPage()
	{
		createFrame();
	}
	public JFrame jf;
	JLabel jl5, jl0;
	public static JLabel jl = new JLabel("");
	JButton jb1,jb2,jb3,jb4, jb6, jb7;
	
	
	public void createFrame()
	{
		jf = new JFrame();
		jf.setUndecorated(true);
		jf.setSize(600,520);
		jf.setBounds(350,100,600,520);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel jp = new JPanel();
		jp.setSize(600,600);
		
		jp.setLayout(null);
		jf.add(jp);
		
		jl.setBounds(10,10,300,20);
		jl.setForeground(Color.WHITE);
		jl.setFont(new Font("Arial",Font.BOLD,18));
		jp.setBackground(Color.MAGENTA);
		jp.add(jl);
		
		jl0 = new JLabel("Admin Dashboard");
		jl0.setBounds(100,50,400,100);
		jl0.setForeground(Color.WHITE);
		jl0.setFont(new Font("Arial",Font.BOLD,46));
		jp.add(jl0);
		
		jb1 = new JButton("Employee Section");
		jb1.setFocusPainted(false);
		jb1.setBackground(Color.WHITE);
		jb1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jb1.setFont(new Font("Arial",Font.BOLD,18));
		jb1.addActionListener(this);
		jb1.setBounds(30,200,200,75);
		jp.add(jb1);
		
		jb2 = new JButton("Item Section");
		jb2.setFocusPainted(false);
		jb2.setBounds(30,300,200,75);
		jb2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jb2.setFont(new Font("Arial",Font.BOLD,18));
		jb2.setBackground(Color.WHITE);
		jb2.addActionListener(this);
		jp.add(jb2);
		
		jb3 = new JButton("Sales");
		jb3.setFocusPainted(false);
		jb3.setBounds(30,400,200,75);
		jb3.addActionListener(this);
		jb3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jb3.setFont(new Font("Arial",Font.BOLD,18));
		jb3.setBackground(Color.WHITE);
		jp.add(jb3);
		
		
		jl5 = new JLabel("Logout");
		jl5.setBounds(520,10,100,20);
		jl5.setForeground(Color.WHITE);
		jl5.addMouseListener(this);
		jl5.setFont(new Font("Arial",Font.BOLD,18));
		jl5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jp.add(jl5);
		
		jb6 = new JButton("Change Password");
		jb6.setFocusPainted(false);
		jb6.setBounds(350,200,200,75);
		jb6.addActionListener(this);
		jb6.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jb6.setFont(new Font("Arial",Font.BOLD,18));
		jb6.setBackground(Color.WHITE);
		jp.add(jb6);
		
		jb7 = new JButton("Customer Section");
		jb7.setFocusPainted(false);
		jb7.addActionListener(this);
		jb7.setBounds(350,300,200,75);
		jb7.setBackground(Color.WHITE);
		jb7.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jb7.setFont(new Font("Arial",Font.BOLD,18));
		jp.add(jb7);
		
		jb4 = new JButton("Out of stock");
		jb4.addActionListener(this);
		jb4.setBounds(350,400,200,75);
		jb4.setFocusPainted(false);
		jb4.setBackground(Color.WHITE);
		jb4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jb4.setFont(new Font("Arial",Font.BOLD,18));
		jp.add(jb4);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		LoginPage lp = new LoginPage();
		lp.jf.setVisible(true);
		jf.setVisible(false);
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		jl5.setForeground(Color.RED);
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		jl5.setForeground(Color.WHITE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jb1)
		{
			EmployeeSection emp = new EmployeeSection();
			emp.jf.setVisible(true);
			jf.setVisible(false);
		}
		if(e.getSource()==jb2)
		{
			ItemsSection itm = new ItemsSection();
			itm.jf.setVisible(true);
			this.jf.setVisible(false);
		}
		if(e.getSource()==jb3)
		{
			JOptionPane.showMessageDialog(jf, "Feature under construction\nYou will see it soon","Message",JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getSource()==jb4)
		{
			OutOfStock ots = new OutOfStock();
			ots.jf_frame.setVisible(true);
			this.jf.setVisible(false);
		}
		if(e.getSource() == jb7)
		{
			CustomerSection cust = new CustomerSection();
			cust.jf.setVisible(true);
			jf.setVisible(false);
		}
		if(e.getSource() == jb6)
		{
			ChangePassword cap = new ChangePassword();
			cap.user_type = "Admin";
			cap.jf.setVisible(true);
			this.jf.setVisible(false);
		}
	}
}
