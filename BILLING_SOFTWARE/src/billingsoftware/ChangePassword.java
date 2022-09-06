package billingsoftware;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class ChangePassword implements ActionListener
{
	public ChangePassword()
	{
		createFrame();
	}
	public String user_type = "";
	public JFrame jf;
	JPanel jp;
	JButton jb1, jb2;
	JTextField jtf1;
	JPasswordField  jtf2, jtf3, jtf4;
	void createFrame()
	{
		jf = new JFrame();
		jf.setUndecorated(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(575,700);
		jf.setBounds(400,30,575,700);
		jp = new JPanel();
		jp.setSize(575,700);
		jf.add(jp);
		jp.setBackground(Color.MAGENTA);
		jp.setLayout(null);
		
		JLabel jl0 = new JLabel("Change Password");
		jl0.setFont(new Font("Arial",Font.BOLD,34));
		jl0.setForeground(Color.WHITE);
		
		jp.add(jl0);
		jl0.setBounds(150,20,400,50);
		
		JLabel jl1 = new JLabel("Email");
		jl1.setForeground(Color.WHITE);
		jl1.setFont(new Font("Arial",Font.BOLD,20));
		jp.add(jl1);
		jl1.setBounds(40,100,200,50);
		
		jtf1 = new JTextField();
		jtf1.setFont(new Font("Arial",Font.PLAIN,18));
		jp.add(jtf1);
		jtf1.setBounds(220,100,300,50);
		
		JLabel jl2 = new JLabel("Old Password");
		jl2.setForeground(Color.WHITE);
		jl2.setFont(new Font("Arial",Font.BOLD,20));
		jp.add(jl2);
		jl2.setBounds(40,200,200,50);
		
		jtf2 = new JPasswordField();
		jtf2.setFont(new Font("Arial",Font.PLAIN,18));
		jp.add(jtf2);
		jtf2.setBounds(220,200,300,50);
		
		JLabel jl3 = new JLabel("New Password");
		jl3.setForeground(Color.WHITE);
		jl3.setFont(new Font("Arial",Font.BOLD,20));
		jp.add(jl3);
		jl3.setBounds(40,300,200,50);
		
		jtf3 = new JPasswordField();
		jtf3.setFont(new Font("Arial",Font.PLAIN,18));
		jp.add(jtf3);
		jtf3.setBounds(220,300,300,50);
		
		JLabel jl4 = new JLabel("Confirm");
		jl4.setForeground(Color.WHITE);
		jl4.setFont(new Font("Arial",Font.BOLD,20));
		jp.add(jl4);
		jl4.setBounds(40,390,200,50);
		
		JLabel jl5 = new JLabel("New Password");
		jl5.setForeground(Color.WHITE);
		jl5.setFont(new Font("Arial",Font.BOLD,20));
		jp.add(jl5);
		jl5.setBounds(40,415,200,50);
		
		jtf4 = new JPasswordField();
		jtf4.setFont(new Font("Arial",Font.PLAIN,18));
		jp.add(jtf4);
		jtf4.setBounds(220,400,300,50);
		
		jb1 = new JButton("Update");
		jb1.setFocusPainted(false);
		jb1.setFont(new Font("Arial",Font.BOLD,34));
		jb1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jb1.setBackground(Color.WHITE);
		jp.add(jb1);
		jb1.setBounds(40,550,200,100);
		jb1.addActionListener(this);
		
		jb2 = new JButton("Cancel");
		jb2.setFocusPainted(false);
		jb2.setFont(new Font("Arial",Font.BOLD,34));
		jb2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jb2.setBackground(Color.WHITE);
		jp.add(jb2);
		jb2.setBounds(320,550,200,100);
		jb2.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jb1)
		{
			if(jtf1.getText().equals(null) || jtf2.getPassword().length==0 || jtf3.getPassword().length==0 || jtf4.getPassword().length==0)
			{
				JOptionPane.showMessageDialog(jp, "Fill all the fields","Error",JOptionPane.ERROR_MESSAGE);
			}
			else if(!(String.valueOf(jtf3.getPassword()).equals(String.valueOf(jtf4.getPassword()))))
			{
				JOptionPane.showMessageDialog(jp, "Passwords don't match","Error",JOptionPane.ERROR_MESSAGE);
				jtf3.setText(null);
				jtf4.setText(null);
			}
			else
			{
				int i = DBOperations.verifyPassword(jtf1.getText(), String.valueOf(jtf2.getPassword()), String.valueOf(jtf3.getPassword()));
				if(i == 0)
				{
					JOptionPane.showMessageDialog(jp, "Password updated");
					if(user_type.equals("Admin"))
					{
						AdminPage ad = new AdminPage();
						ad.jf.setVisible(true);
					}
					else if(user_type.equals("Employee"))
					{
						EmployeePage emp = new EmployeePage();
						emp.jf.setVisible(true);
					}
					
					this.jf.setVisible(false);
				}
				else if(i == 1)
				{
					JOptionPane.showMessageDialog(jp, "Invalid credentials","Error",JOptionPane.ERROR_MESSAGE);
					jtf1.setText(null);
					jtf2.setText(null);
					jtf3.setText(null);
					jtf4.setText(null);
				}
				else if(i == 2)
				{
					JOptionPane.showMessageDialog(jp, "Invalid password \n Only alphanumeric characters allowed between length of 4 and 16 characters","Error",JOptionPane.ERROR_MESSAGE);
					jtf3.setText(null);
					jtf4.setText(null);				
				}
			}
		}
		if(e.getSource() == jb2)
		{
			if(user_type.equals("Admin"))
			{
				AdminPage ad = new AdminPage();
				ad.jf.setVisible(true);
			}
			else if(user_type.equals("Employee"))
			{
				EmployeePage emp = new EmployeePage();
				emp.jf.setVisible(true);
			}
			
			this.jf.setVisible(false);
		}
	}
}

