package billingsoftware;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import admin.AdminPage;
import dbconnection.DBConnection;
import dboperations.DBOperations;
import employee.EmployeePage;
import gettersetter.Adder;
import implementors.Implementor;

public class LoginPage extends Implementor implements ActionListener {
	JButton jb;
	public JFrame jf;
	JTextField jtf1;
	JPasswordField jtf2;
	JPanel jp; 
	
	JLabel jl3;
	public LoginPage()
	{
		createFrame();
	}
   void createFrame()
   {
	   jf = new JFrame();
	   jf.setUndecorated(true);
	   jf.setBounds(400, 150, 500, 430);
	   jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   jf.setLayout(null);
	   jf.setResizable(false);
	   jp = new JPanel();
	   jp.setSize(500,500);
	   jp.setLayout(null);
	   jf.add(jp);
	   jp.setBackground(Color.MAGENTA);
	   Font f = new Font("Arial",Font.BOLD,20);
	   
	   JLabel jl0 =  new JLabel("Login Here");
	   jl0.setForeground(Color.WHITE);
	   jl0.setBounds(150, 10, 300, 75);
	   jl0.setFont(new Font("Arial",Font.BOLD,34));
	   jp.add(jl0);
	   
	   JLabel jl1 =  new JLabel("Email");
	   jl1.setForeground(Color.WHITE);
	   jl1.setBounds(50, 100, 100, 50);
	   jl1.setFont(f);
	   jp.add(jl1);
	   jtf1 = new JTextField();
	   jtf1.setBounds(150,100,250,50);
	   jtf1.setFont(new Font("Arial", Font.PLAIN, 15));
	   jp.add(jtf1);
	   
	   JLabel jl2 =  new JLabel("Password");
	   jl2.setForeground(Color.WHITE);
	   jl2.setBounds(50, 200, 100, 50);
	   jl2.setFont(f);
	   jp.add(jl2);
	   jtf2 = new JPasswordField();
	   jtf2.setBounds(150,200,250,50);
	   jtf2.setFont(new Font("Arial",Font.PLAIN,15));
	   jp.add(jtf2);
	   
	   jb = new JButton("Login");
	   jb.setFocusPainted(false);
	   jb.setBackground(Color.WHITE);
	   jb.setCursor(new Cursor(Cursor.HAND_CURSOR));
	   jb.setFont(new Font("Arial",Font.BOLD,26));
	   jb.setBounds(150, 300, 200, 75);
	   
	   jb.addActionListener(this);
	   jp.add(jb);
	   
	   jl3 = new JLabel("Exit");
	   jl3.setBounds(440,395,60,25);
	   jl3.setFont(new Font("Arial",Font.BOLD,24));
	   jl3.setCursor(new Cursor(Cursor.HAND_CURSOR));
	   jl3.setForeground(Color.WHITE);
	   jl3.addMouseListener(this);
	   jp.add(jl3);
	   
   }

@Override
public void actionPerformed(ActionEvent e) 
{
	// TODO Auto-generated method stub
	if(e.getSource()==jb)
	{
		String str1 = jtf1.getText();
		char[] arr = jtf2.getPassword();
		String str2 = "";
		for(char ch : arr)
		{
			str2 = str2+ch;
		}
		Adder ad = DBOperations.login(str1, str2);;
		
		
		if(ad == null)
		{
			JOptionPane.showMessageDialog(jp, "User not found","Error in login", JOptionPane.ERROR_MESSAGE);
			jtf1.setText(null);
			jtf2.setText(null);
		}
		else if(ad.getModule().equals("Admin"))
		{
			AdminPage adm = new AdminPage();
			AdminPage.jl.setText("Welcome Admin - "+ad.getName());
			adm.jf.setVisible(true);
			jf.setVisible(false);
		}
		else if(ad.getModule().equals("Employee"))
		{
			EmployeePage emp = new EmployeePage();
			EmployeePage.jl.setText("Welcome "+ad.getName());
			emp.jf.setVisible(true);
			this.jf.setVisible(false);
		}
		
	}
}
public void mouseEntered(MouseEvent e)
	{
		if(e.getSource() == jl3)
		{
			jl3.setForeground(Color.RED);
		}
		
	}
public void mouseExited(MouseEvent e)
	{
		if(e.getSource()==jl3)
		{
			jl3.setForeground(Color.WHITE);
		}
		
	}
public void mouseClicked(MouseEvent e) 
	{
		if(e.getSource()==jl3)
		{
			System.exit(0);
		}
		
	}

}
