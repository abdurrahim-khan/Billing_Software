package employee;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


import dboperations.DBOperations;
import gettersetter.Adder;
import hashing.Hashing;
import implementors.Implementor;
import validator.EntryValidator;

class AddCustomerPage extends Implementor implements ActionListener 
{
	
	JLabel jl11, jl12, jl_total, jl_grandtotal;
	JFrame jf;
	JButton jb8,jb9,jb10;
	JTextField jtf1,jtf2,jtf4,jtf6;
	JComboBox jtf7;
	JPasswordField jtf3;
	JRadioButton jb51,jb52;
	JPanel jp2;
	ButtonGroup jb;
	JTable jt;
	String[] arr = {"Select Payment Mode","Cash","Debit Card","Credit Card","Online Banking","UPI"};
	
	public AddCustomerPage()
	{
		createFrame();
		String grandtotal = DBOperations.getGrandTotal();
		jl_total.setText(grandtotal);
		Hashing hs = new Hashing("user_details");
	}
	
	
		void createFrame()
		{
			
			jf = new JFrame();
			jf.setUndecorated(true);
			jf.setSize(1200,700);
			jf.setBounds(70,10,1200,700);
			jf.setLayout(null);
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JPanel jp1 = new JPanel();
			jp1.setSize(600,700);
			jp1.setBackground(Color.MAGENTA);
			jp1.setBounds(0,0,600,700);
			jp1.setLayout(null);
			jf.add(jp1);
			
			JLabel jl0 = new JLabel("Cart");
			jl0.setFont(new Font("Arial",Font.BOLD,28));
			jl0.setForeground(Color.WHITE);
			jl0.setBounds(280,35,500,50);
			jp1.add(jl0);
			
			jp2 = new JPanel();
			jp2.setSize(600,700);
			jp2.setBounds(600,0,600,700);
			jp2.setBackground(Color.MAGENTA);
			jp2.setLayout(null);
			jf.add(jp2);
			
			JScrollPane js = new JScrollPane();
			js.setBounds(50,80,550,470);
			jp1.add(js);
			
			jt = DBOperations.cartTableCreator();
			jt.addMouseListener(this);
			jt.setDefaultEditor(Object.class, null);
			jt.setForeground(Color.BLACK);
			jt.setFont(new Font("Arial",Font.PLAIN,12));
			js.setViewportView(jt);
			
			
			//leftside done now right pane starts
			
			
			jl_grandtotal = new JLabel("Grand Total =");
			jl_grandtotal.setBounds(60,560,250,100);
			jl_grandtotal.setFont(new Font("Arial",Font.BOLD,38));
			jl_grandtotal.setForeground(Color.WHITE);
			jp1.add(jl_grandtotal);
			
			jl_total = new JLabel("0");
			jl_total.setBounds(320,560,300,100);
			jl_total.setFont(new Font("Arial",Font.BOLD,38));
			jl_total.setForeground(Color.WHITE);
			jp1.add(jl_total);
			
			JLabel jlh = new JLabel("Customer Details");
			jp2.add(jlh);
			jlh.setForeground(Color.WHITE);
			jlh.setFont(new Font("Arial",Font.BOLD,42));
			jlh.setBounds(130,-10,600,100);
			
			
			JLabel jl1 = new JLabel("Name");
			jp2.add(jl1);
			jl1.setForeground(Color.WHITE);
			jl1.setFont(new Font("Arial",Font.BOLD,22));
			jl1.setBounds(50,80,100,50);
			
			jtf1 = new JTextField();
			jp2.add(jtf1);
			jtf1.setFont(new Font("Arial",Font.PLAIN,18));
			jtf1.setBounds(225,80,300,50);
			
			JLabel jl2 = new JLabel("Email");
			jp2.add(jl2);
			jl2.setForeground(Color.WHITE);
			jl2.setFont(new Font("Arial",Font.BOLD,22));
			jl2.setBounds(50,160,100,50);
			
			jtf2 = new JTextField();
			jp2.add(jtf2);
			jtf2.setFont(new Font("Arial",Font.PLAIN,18));
			jtf2.setBounds(225,160,300,50);
			
			
			
			
			
			JLabel jl5 = new JLabel("Gender");
			jp2.add(jl5);
			jl5.setForeground(Color.WHITE);
			jl5.setFont(new Font("Arial",Font.BOLD,22));
			jl5.setBounds(50,230,100,50);
			
			jb = new ButtonGroup();
			
			jb51 = new JRadioButton("Male");
			jp2.add(jb51);
			jb51.setBackground(Color.MAGENTA);
			jb51.setFocusPainted(false);
			jb51.setForeground(Color.white);
			jb51.setCursor(new Cursor(Cursor.HAND_CURSOR));
			jb51.setFont(new Font("Arial",Font.BOLD,22));
			jb51.setBounds(225,230,100,50);
			jb52 = new JRadioButton("Female");
			jp2.add(jb52);
			jb52.setForeground(Color.WHITE);
			jb52.setFont(new Font("Arial",Font.BOLD,22));
			jb52.setFocusPainted(false);
			jb52.setCursor(new Cursor(Cursor.HAND_CURSOR));
			jb52.setBackground(Color.MAGENTA);
			jb52.setBounds(350,230,100,50);
			
			jb.add(jb51);
			jb.add(jb52);
			
			JLabel jl6 = new JLabel("Mobile");
			jp2.add(jl6);
			jl6.setFont(new Font("Arial",Font.BOLD,22));
			jl6.setForeground(Color.WHITE);
			jl6.setFont(new Font("Arial",Font.BOLD,22));
			jl6.setBounds(50,300,100,50);
			
			jtf6 = new JTextField();
			jp2.add(jtf6);
			jtf6.setFont(new Font("Arial",Font.PLAIN,18));
			jtf6.setBounds(225,300,300,50);
			
			JLabel jl4 = new JLabel("Address");
			jp2.add(jl4);
			jl4.setFont(new Font("Arial",Font.BOLD,22));
			jl4.setForeground(Color.WHITE);
			jl4.setFont(new Font("Arial",Font.BOLD,22));
			jl4.setBounds(50,380,100,50);
			
			jtf4 = new JTextField();
			jp2.add(jtf4);
			jtf4.setFont(new Font("Arial",Font.PLAIN,18));
			jtf4.setBounds(225,380,300,50);
			
			JLabel jl7 = new JLabel("Payment Mode");
			jp2.add(jl7);
			jl7.setForeground(Color.WHITE);
			jl7.setFont(new Font("Arial",Font.BOLD,22));
			jl7.setBounds(50,460,200,50);
			
			jtf7 = new JComboBox(arr);
			jp2.add(jtf7);
			jtf7.setCursor(new Cursor(Cursor.HAND_CURSOR));
			jtf7.setFont(new Font("Arial",Font.PLAIN,18));
			jtf7.setFocusable(false);
			jtf7.setBackground(Color.WHITE);
			
			jtf7.setBounds(225,460,300,50);
			
			
			
			jb9 = new JButton("Proceed to payment");
			jb9.setCursor(new Cursor(Cursor.HAND_CURSOR));
			jb9.setFocusPainted(false);
			jb9.setFont(new Font("Arial",Font.BOLD,30));
			jb9.addActionListener(this);
			jb9.setBackground(Color.white);
			jp2.add(jb9);
			jb9.setBounds(90,560,350,80);
			
			
			
			
			jl11 = new JLabel("Back");
			jp1.add(jl11);
			jl11.setForeground(Color.WHITE);
			jl11.setCursor(new Cursor(Cursor.HAND_CURSOR));
			jl11.addMouseListener(this);
			jl11.setFont(new Font("Arial",Font.BOLD,20));
			jl11.setBounds(5,5,65,20);
			
			jl12 = new JLabel("Abort");
			jp2.add(jl12);
			jl12.setForeground(Color.WHITE);
			jl12.setCursor(new Cursor(Cursor.HAND_CURSOR));
			jl12.addMouseListener(this);
			jl12.setFont(new Font("Arial",Font.BOLD,20));
			jl12.setBounds(525,5,65,20);
			
			
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jb9)
		{
			String name = jtf1.getText();
			String email = jtf2.getText();
			
			String gender = "";
			if(jb51.isSelected())
			{
				gender = jb51.getText();
			}
			else
			{
				gender = jb52.getText();
			}
			String mobile = jtf6.getText();
			String address = jtf4.getText();
			
			EntryValidator validator = new EntryValidator();
			if(!validator.nameValidator(name))
			{
				JOptionPane.showMessageDialog(jp2,"Invalid name","Error",JOptionPane.ERROR_MESSAGE);
				jtf1.setText(null);
			}
			else if(!validator.emailValidator(email))
			{
				JOptionPane.showMessageDialog(jp2,"Invalid email","Error",JOptionPane.ERROR_MESSAGE);
				jtf2.setText(null);
			}
			
			
			else if((!jb51.isSelected()) && (!jb52.isSelected()))
			{
				JOptionPane.showMessageDialog(jp2,"Select gender","Error",JOptionPane.ERROR_MESSAGE);
				
			}
			else if(!validator.mobileValidator(mobile))
			{
				JOptionPane.showMessageDialog(jp2,"Invalid mobile number","Error",JOptionPane.ERROR_MESSAGE);
				jtf6.setText(null);
			}
			else if(!validator.addressValidator(address))
			{
				JOptionPane.showMessageDialog(jp2,"Invalid address","Error",JOptionPane.ERROR_MESSAGE);
				jtf4.setText(null);
			}
			else if(jtf7.getSelectedItem().equals(arr[0]))
			{
				JOptionPane.showMessageDialog(jp2,"Select Payment Mode","Error",JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				int i = JOptionPane.showConfirmDialog(jp2, "Are you sure to proceed to payment","Confirm Choice", JOptionPane.YES_NO_OPTION);
				if(i == 0)
				{
					boolean status = false;
					Adder ad = new Adder();
					ad.setName(name);
					ad.setEmail(email);
					ad.setPassword(null);
					ad.setAge(null);
					ad.setGender(gender);
					ad.setMobile(mobile);
					ad.setAddress(address);
					ad.setModule("Customer");
					boolean ispresent = Hashing.isUserPresent(email);
					if(ispresent)
					{
						status = DBOperations.update(ad, "user_details");
					}
					else
					{
						Hashing.addUser(email);
						status = DBOperations.addNew(ad, "user_details");
					}
					
						
						if(status)
						{
							
							jtf1.setText(null);
							jtf2.setText(null);
							jtf4.setText(null);
							jb.clearSelection();
							jtf6.setText(null);
							jtf7.setSelectedItem(arr[0]);
							PaymentPage pp = new PaymentPage(jl_total.getText());
							pp.jf.setVisible(true);
							this.jf.setVisible(false);
						}
						else
						{
							JOptionPane.showMessageDialog(jp2,"Some Error Occured","Error",JOptionPane.ERROR_MESSAGE);
						}
				}
				
			}
		}
		
	}
	public void mouseEntered(MouseEvent e)
	{
		if(e.getSource()==jl11)
		{
			jl11.setForeground(Color.RED);
		}
		if(e.getSource()==jl12)
		{
			jl12.setForeground(Color.RED);
		}
	}
	public void mouseExited(MouseEvent e)
	{
		if(e.getSource() == jl11)
		{
			jl11.setForeground(Color.WHITE);
		}
		if(e.getSource() == jl12)
		{
			jl12.setForeground(Color.WHITE);
		}
	}
	public void mouseClicked(MouseEvent e)
	{
		if(e.getSource() == jl11)
		{
			StartBilling sb = new StartBilling();
			sb.jf.setVisible(true);
			this.jf.setVisible(false);
		}
		if(e.getSource() == jl12)
		{
			DBOperations.emptyCart("changes_not_to_be_reflected");
			EmployeePage emp = new EmployeePage();
			emp.jf.setVisible(true);
			this.jf.setVisible(false);
		}
	}

}
