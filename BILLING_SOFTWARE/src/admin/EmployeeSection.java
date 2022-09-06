package admin;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.HashSet;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dboperations.DBOperations;
import gettersetter.Adder;
import hashing.Hashing;
import implementors.Implementor;
import validator.EntryValidator;

class EmployeeSection extends Implementor implements ActionListener
{
	
	public EmployeeSection()
	{
		createFrame();
		Hashing hs = new Hashing("user_details");
	}
	JLabel jl11,jlc;
	JFrame jf;
	JButton jb8,jb9,jb10;
	JTextField jtf1,jtf2,jtf4,jtf6,jtf7;
	JPasswordField jtf3;
	JRadioButton jb51,jb52;
	JPanel jp2;
	ButtonGroup jb;
	JTable jt;
	
	
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
			
			JLabel jl0 = new JLabel("Employee Details");
			jl0.setFont(new Font("Arial",Font.BOLD,34));
			jl0.setForeground(Color.WHITE);
			jl0.setBounds(180,20,500,50);
			jp1.add(jl0);
			
			jp2 = new JPanel();
			jp2.setSize(600,700);
			jp2.setBounds(600,0,600,700);
			jp2.setBackground(Color.MAGENTA);
			jp2.setLayout(null);
			jf.add(jp2);
			
			JScrollPane js = new JScrollPane();
			js.setBounds(50,80,550,550);
			jp1.add(js);
			
			jt = DBOperations.userTableCreator("Employee");
			jt.addMouseListener(this);
			jt.setSize(500,600);
			jt.setBounds(50,80,550,600);
			jt.setDefaultEditor(Object.class, null);
			jt.setFocusable(false);
			jt.setCursor(new Cursor(Cursor.HAND_CURSOR));
			jt.setFont(new Font("Arial",Font.PLAIN,12));
			js.setViewportView(jt);
			
			
			//leftside done now right pane starts
			
			JLabel jl1 = new JLabel("Name");
			jp2.add(jl1);
			jl1.setForeground(Color.WHITE);
			jl1.setFont(new Font("Arial",Font.BOLD,22));
			jl1.setBounds(50,50,100,50);
			
			jtf1 = new JTextField();
			jp2.add(jtf1);
			jtf1.setFont(new Font("Arial",Font.PLAIN,16));
			jtf1.setBounds(225,50,300,50);
			
			JLabel jl2 = new JLabel("Email");
			jp2.add(jl2);
			jl2.setForeground(Color.WHITE);
			jl2.setFont(new Font("Arial",Font.BOLD,22));
			jl2.setBounds(50,120,100,50);
			
			jtf2 = new JTextField();
			jp2.add(jtf2);
			jtf2.setFont(new Font("Arial",Font.PLAIN,16));
			jtf2.setBounds(225,120,300,50);
			
			JLabel jl3 = new JLabel("Password");
			jp2.add(jl3);
			jl3.setForeground(Color.WHITE);
			jl3.setFont(new Font("Arial",Font.BOLD,22));
			jl3.setBounds(50,190,200,50);
			
			jtf3 = new JPasswordField();
			jtf3.setFont(new Font("Arial",Font.PLAIN,16));
			jp2.add(jtf3);
			jtf3.setBounds(225,190,300,50);
			
			JLabel jl4 = new JLabel("Age");
			jp2.add(jl4);
			jl4.setForeground(Color.WHITE);
			jl4.setFont(new Font("Arial",Font.BOLD,22));
			jl4.setBounds(50,260,100,50);
			
			jtf4 = new JTextField();
			jp2.add(jtf4);
			jtf4.setFont(new Font("Arial",Font.PLAIN,16));
			jtf4.setBounds(225,260,300,50);
			
			JLabel jl5 = new JLabel("Gender");
			jp2.add(jl5);
			jl5.setForeground(Color.WHITE);
			jl5.setFont(new Font("Arial",Font.BOLD,22));
			jl5.setBounds(50,330,100,50);
			
			jb = new ButtonGroup();
			
			jb51 = new JRadioButton("Male");
			jp2.add(jb51);
			jb51.setFocusPainted(false);
			jb51.setBackground(Color.MAGENTA);
			jb51.setCursor(new Cursor(Cursor.HAND_CURSOR));
			jb51.setForeground(Color.white);
			jb51.setFont(new Font("Arial",Font.BOLD,22));
			jb51.setBounds(225,330,100,50);
			jb52 = new JRadioButton("Female");
			jp2.add(jb52);
			jb52.setForeground(Color.WHITE);
			jb52.setCursor(new Cursor(Cursor.HAND_CURSOR));
			jb52.setFocusPainted(false);
			jb52.setBackground(Color.MAGENTA);
			jb52.setBounds(350,330,100,50);
			
			jb.add(jb51);
			jb.add(jb52);
			
			JLabel jl6 = new JLabel("Mobile");
			jp2.add(jl6);
			jb52.setFont(new Font("Arial",Font.BOLD,22));
			jl6.setForeground(Color.WHITE);
			jl6.setFont(new Font("Arial",Font.BOLD,22));
			jl6.setBounds(50,400,100,50);
			
			jtf6 = new JTextField();
			jp2.add(jtf6);
			jtf6.setFont(new Font("Arial",Font.PLAIN,16));
			jtf6.setBounds(225,400,300,50);
			
			JLabel jl7 = new JLabel("Address");
			jp2.add(jl7);
			jl7.setForeground(Color.WHITE);
			jl7.setFont(new Font("Arial",Font.BOLD,22));
			jl7.setBounds(50,470,100,50);
			
			jtf7 = new JTextField();
			jp2.add(jtf7);
			jtf7.setFont(new Font("Arial",Font.PLAIN,16));
			jtf7.setBounds(225,470,300,50);
			
			jlc = new JLabel("Clear Selection");
			jp2.add(jlc);
			jlc.setCursor(new Cursor(Cursor.HAND_CURSOR));
			jlc.setForeground(Color.WHITE);
			jlc.addMouseListener(this);
			jlc.setFont(new Font("Arial",Font.BOLD,34));
			jlc.setBounds(170,635,300,50);
			
			
			jb8 = new JButton("Add");
			jb8.setFocusPainted(false);
			jb8.setFont(new Font("Arial",Font.BOLD,30));
			jb8.addActionListener(this);
			jb8.setCursor(new Cursor(Cursor.HAND_CURSOR));
			jb8.setBackground(Color.white);
			jp2.add(jb8);
			jb8.setBounds(50,550,150,80);
			
			jb9 = new JButton("Delete");
			jb9.setFocusPainted(false);
			jb9.setCursor(new Cursor(Cursor.HAND_CURSOR));
			jb9.setEnabled(false);
			jb9.setFont(new Font("Arial",Font.BOLD,30));
			jb9.addActionListener(this);
			jb9.setBackground(Color.white);
			jp2.add(jb9);
			jb9.setBounds(212,550,150,80);
			
			
			jb10 = new JButton("Update");
			jb10.setFocusPainted(false);
			jb10.setCursor(new Cursor(Cursor.HAND_CURSOR));
			jb10.setEnabled(false);
			jb10.setFont(new Font("Arial",Font.BOLD,30));
			jb10.addActionListener(this);
			jb10.setBackground(Color.white);
			jp2.add(jb10);
			jb10.setBounds(375,550,150,80);
			
			jl11 = new JLabel("Back");
			jp2.add(jl11);
			jl11.setForeground(Color.WHITE);
			jl11.setCursor(new Cursor(Cursor.HAND_CURSOR));
			jl11.addMouseListener(this);
			jl11.setFont(new Font("Arial",Font.BOLD,20));
			jl11.setBounds(540,667,65,20);
			
			
		}
		public void mouseClicked(MouseEvent e)
		{
			if(e.getSource() == jl11)
			{
				AdminPage adm = new AdminPage();
				adm.jf.setVisible(true);
				jf.setVisible(false);
			}
			if(e.getSource()==jlc)
			{
				jtf1.setText(null);
				jtf2.setText(null);
				jtf2.setEditable(true);
				jtf3.setText(null);
				jtf3.setEditable(true);
				jtf4.setText(null);
				jb.clearSelection();
				jtf6.setText(null);
				jtf7.setText(null);
				
				jb8.setEnabled(true);
				jb9.setEnabled(false);
				jb10.setEnabled(false);
			}
			if(e.getSource()==jt)
			{
				
				int rownum = jt.getSelectedRow();
				
				String email = (String) jt.getValueAt(rownum, 2);
				Adder details = DBOperations.getDetails(email,"user_details");
				jtf1.setText(details.getName());
				jtf2.setText(details.getEmail());
				jtf2.setEditable(false);
				jtf3.setText(details.getPassword());
				jtf3.setEditable(false);
				jtf4.setText(details.getAge());
				String gender = details.getGender();
				if(gender.equals("Male"))
				{
					jb51.setSelected(true);
				}
				else
				{
					jb52.setSelected(true);
				}
				jtf6.setText(details.getMobile());
				jtf7.setText(details.getAddress());
				
				jb8.setEnabled(false);
				jb9.setEnabled(true);
				jb10.setEnabled(true);
			}
			
		}	
		public void mouseEntered(MouseEvent e)
		{
			if(e.getSource() == jl11)
			{
				jl11.setForeground(Color.RED);
			}
			if(e.getSource() == jlc)
			{
				jlc.setForeground(Color.RED);
			}
		}
		public void mouseExited(MouseEvent e)
		{
			if(e.getSource() == jl11)
			{
				jl11.setForeground(Color.WHITE);
			}
			if(e.getSource() == jlc)
			{
				jlc.setForeground(Color.WHITE);
			}
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == jb8)
			{
				
				String name = jtf1.getText();
				String email = jtf2.getText();
				char[] ch = jtf3.getPassword();
				String password = String.valueOf(ch);
				String age = jtf4.getText();
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
				String address = jtf7.getText();
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
				else if(!validator.passwordValidator(password))
				{
					JOptionPane.showMessageDialog(jp2,"Invalid Password \n Password can contain only alphanumeric characters and can only be between 4 and 16 characters long","Error",JOptionPane.ERROR_MESSAGE);
					jtf3.setText(null);
				}
				else if(!validator.ageValidator(age))
				{
					JOptionPane.showMessageDialog(jp2,"Invalid age","Error",JOptionPane.ERROR_MESSAGE);
					jtf4.setText(null);
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
					jtf6.setText(null);
				}
				else
				{
					if(!(Hashing.isUserPresent(email)))
					{
					    Hashing.addUser(email);
						Adder ad = new Adder();
						ad.setName(name);
						ad.setEmail(email);
						ad.setPassword(password);
						ad.setAge(age);
						ad.setGender(gender);
						ad.setMobile(mobile);
						ad.setAddress(address);
						ad.setModule("Employee");
						
						boolean status = DBOperations.addNew(ad, "user_details");
						if(status)
						{
							JOptionPane.showMessageDialog(jp2,"employee added","Successful",JOptionPane.INFORMATION_MESSAGE);
							jtf1.setText(null);
							jtf2.setText(null);
							jtf3.setText(null);
							jtf4.setText(null);
							jb.clearSelection();
							jtf6.setText(null);
							jtf7.setText(null);
							EmployeeSection empl = new EmployeeSection();
							empl.jf.setVisible(true);
							this.jf.setVisible(false);
						}
						else
						{
							JOptionPane.showMessageDialog(jp2,"Some Error Occured","Error",JOptionPane.ERROR_MESSAGE);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(jp2,"Employee already exists","Error",JOptionPane.ERROR_MESSAGE);
						jtf1.setText(null);
						jtf2.setText(null);
						jtf3.setText(null);
						jtf4.setText(null);
						jb.clearSelection();
						jtf6.setText(null);
						jtf7.setText(null);
					}
				}
			}
			
			if(e.getSource() == jb9)
			{
				    boolean status = false;
					
					
					
						status = DBOperations.delete(jtf2.getText(), "user_details");
						if(status)
						{
							JOptionPane.showMessageDialog(jp2, "Employee deleted successfully","Success",JOptionPane.INFORMATION_MESSAGE);
							jtf1.setText(null);
							jtf2.setText(null);
							jtf3.setText(null);
							jtf4.setText(null);
							jb.clearSelection();
							jtf6.setText(null);
							jtf7.setText(null);
							
							EmployeeSection emp = new EmployeeSection();
							emp.jf.setVisible(true);
							jf.setVisible(false);
						}
						else
						{
							JOptionPane.showMessageDialog(jp2, "Some error occured","Error",JOptionPane.ERROR_MESSAGE);
						}
					
					/*else
					{
						JOptionPane.showMessageDialog(jp2, "Select an employee","Error",JOptionPane.ERROR_MESSAGE);
						jtf1.setText(null);
						jtf2.setText(null);
						jtf3.setText(null);
						jtf4.setText(null);
						jb.clearSelection();
						jtf6.setText(null);
						jtf7.setText(null);
						
					}*/
			}
			if(e.getSource() == jb10)
			{
				/*if(!jt.isColumnSelected(0))
				{
					JOptionPane.showMessageDialog(jp2, "Select an employee","Some error occured",JOptionPane.ERROR_MESSAGE);
					jtf1.setText(null);
					jtf2.setText(null);
					jtf3.setText(null);
					jtf4.setText(null);
					jb.clearSelection();
					jtf6.setText(null);
					jtf7.setText(null);
				}*/
				
					String name = jtf1.getText();
					String age = jtf4.getText();
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
					String address = jtf7.getText();
					EntryValidator validator = new EntryValidator();
					if(!validator.nameValidator(name))
					{
						JOptionPane.showMessageDialog(jp2,"Invalid name","Error",JOptionPane.ERROR_MESSAGE);
						jtf1.setText(null);
					}
					
					else if(!validator.ageValidator(age))
					{
						JOptionPane.showMessageDialog(jp2,"Invalid age","Error",JOptionPane.ERROR_MESSAGE);
						jtf4.setText(null);
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
						jtf7.setText(null);
					}
					else
					{
						    
							Adder ad = new Adder();
							ad.setName(name);
							ad.setEmail(jtf2.getText());
							
							ad.setAge(age);
							ad.setGender(gender);
							ad.setMobile(mobile);
							ad.setAddress(address);
							
							
							boolean status = DBOperations.update(ad,"user_details");
							if(status)
							{
								JOptionPane.showMessageDialog(jp2,"Employee updated successfully","Success",JOptionPane.INFORMATION_MESSAGE);
								jtf1.setText(null);
								jtf2.setText(null);
								jtf3.setText(null);
								jtf4.setText(null);
								jb.clearSelection();
								jtf6.setText(null);
								jtf7.setText(null);
								EmployeeSection empl = new EmployeeSection();
								empl.jf.setVisible(true);
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
