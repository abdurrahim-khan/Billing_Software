package admin;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

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

import dboperations.DBOperations;
import gettersetter.Adder;
import hashing.Hashing;
import implementors.Implementor;
import validator.EntryValidator;

class CustomerSection extends Implementor implements ActionListener 
{
	public CustomerSection()
	{
		createFrame();
		Hashing hs = new Hashing("user_details");
	}
	JLabel jl11,jlc;
	JFrame jf;
	JButton jb8,jb9,jb10;
	JTextField jtf1,jtf2,jtf6,jtf7;
	
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
			
			JLabel jl0 = new JLabel("Customer Details");
			jl0.setFont(new Font("Arial",Font.BOLD,38));
			jl0.setForeground(Color.WHITE);
			jl0.setBounds(180,40,500,50);
			jp1.add(jl0);
			
			jp2 = new JPanel();
			jp2.setSize(600,700);
			jp2.setBounds(600,0,600,700);
			jp2.setBackground(Color.MAGENTA);
			jp2.setLayout(null);
			jf.add(jp2);
			
			JScrollPane js = new JScrollPane();
			js.setBounds(50,120,550,560);
			jp1.add(js);
			
			jt = DBOperations.userTableCreator("Customer");
			jt.addMouseListener(this);
			jt.setSize(500,560);
			jt.setDefaultEditor(Object.class, null);
			jt.setBounds(50,120,550,560);
			jt.setForeground(Color.BLACK);
			jt.setFont(new Font("Arial",Font.PLAIN,14));
			js.setViewportView(jt);
			
			
			//leftside done now right pane starts
			
			JLabel jl1 = new JLabel("Name");
			jp2.add(jl1);
			jl1.setForeground(Color.WHITE);
			jl1.setFont(new Font("Arial",Font.BOLD,22));
			jl1.setBounds(50,120,100,50);
			
			jtf1 = new JTextField();
			jtf1.setEditable(false);
			jtf1.setFont(new Font("Arial",Font.PLAIN,20));
			jp2.add(jtf1);
			jtf1.setBounds(225,120,300,50);
			
			JLabel jl2 = new JLabel("Email");
			jp2.add(jl2);
			jl2.setForeground(Color.WHITE);
			jl2.setFont(new Font("Arial",Font.BOLD,22));
			jl2.setBounds(50,190,100,50);
			
			jtf2 = new JTextField();
			jtf2.setEditable(false);
			jtf2.setFont(new Font("Arial",Font.PLAIN,20));
			jp2.add(jtf2);
			jtf2.setBounds(225,190,300,50);
			
			
			
			
			JLabel jl5 = new JLabel("Gender");
			jp2.add(jl5);
			jl5.setForeground(Color.WHITE);
			jl5.setFont(new Font("Arial",Font.BOLD,22));
			jl5.setBounds(50,260,100,50);
			
			jb = new ButtonGroup();
			
			jb51 = new JRadioButton("Male");
			jb51.setEnabled(false);
			jb51.setFocusPainted(false);
			jp2.add(jb51);
			jb51.setBackground(Color.MAGENTA);
			jb51.setForeground(Color.white);
			jb51.setFont(new Font("Arial",Font.BOLD,22));
			jb51.setBounds(225,260,100,50);
			jb52 = new JRadioButton("Female");
			jb52.setFocusPainted(false);
			jb52.setEnabled(false);
			jp2.add(jb52);
			jb52.setForeground(Color.WHITE);
			jb52.setBackground(Color.MAGENTA);
			jb52.setBounds(350,260,100,50);
			
			jb.add(jb51);
			jb.add(jb52);
			
			JLabel jl6 = new JLabel("Mobile");
			jp2.add(jl6);
			jb52.setFont(new Font("Arial",Font.BOLD,22));
			jl6.setForeground(Color.WHITE);
			jl6.setFont(new Font("Arial",Font.BOLD,22));
			jl6.setBounds(50,330,100,50);
			
			jtf6 = new JTextField();
			jtf6.setEditable(false);
			jtf6.setFont(new Font("Arial",Font.PLAIN,20));
			jp2.add(jtf6);
			jtf6.setBounds(225,330,300,50);
			
			JLabel jl7 = new JLabel("Address");
			jp2.add(jl7);
			jl7.setForeground(Color.WHITE);
			jl7.setFont(new Font("Arial",Font.BOLD,22));
			jl7.setBounds(50,400,100,50);
			
			jtf7 = new JTextField();
			jtf7.setEditable(false);
			jtf7.setFont(new Font("Arial",Font.PLAIN,20));
			jp2.add(jtf7);
			jtf7.setBounds(225,400,300,50);
			
			
			
			jb9 = new JButton("Delete");
			jb9.setFocusPainted(false);
			jb9.setFont(new Font("Arial",Font.BOLD,32));
			jb9.setCursor(new Cursor(Cursor.HAND_CURSOR));
			jb9.addActionListener(this);
			jb9.setBackground(Color.white);
			jp2.add(jb9);
			jb9.setEnabled(false);
			jb9.setBounds(205,575,200,75);
			
			jlc = new JLabel("Clear Selection");
			jlc.setFont(new Font("Arial",Font.BOLD,36));
			jlc.setForeground(Color.WHITE);
			jlc.setCursor(new Cursor(Cursor.HAND_CURSOR));
			jlc.addMouseListener(this);
			jlc.setBackground(Color.white);
			jp2.add(jlc);
			jlc.setBounds(170,480,300,75);
			
						
			jl11 = new JLabel("Back");
			jp2.add(jl11);
			jl11.setForeground(Color.WHITE);
			jl11.setCursor(new Cursor(Cursor.HAND_CURSOR));
			jl11.addMouseListener(this);
			jl11.setFont(new Font("Arial",Font.BOLD,20));
			jl11.setBounds(540,670,65,20);
		}
		public void mouseClicked(MouseEvent e)
		{
			if(e.getSource() == jl11)
			{
				AdminPage adm = new AdminPage();
				adm.jf.setVisible(true);
				jf.setVisible(false);
			}
			if(e.getSource() == jlc)
			{
				jtf1.setText(null);
				jtf2.setText(null);
				jb.clearSelection();
				jtf6.setText(null);
				jtf7.setText(null);
				jb9.setEnabled(false);
				
			}
			if(e.getSource()==jt)
			{
				
				int rownum = jt.getSelectedRow();
				
				String email = (String) jt.getValueAt(rownum, 2);
				Adder details = DBOperations.getDetails(email,"user_details");
				jtf1.setText(details.getName());
				jtf2.setText(details.getEmail());
				String gender = details.getGender();
				if(gender.equals("Male"))
				{
					jb51.setSelected(true);
					jb51.setEnabled(true);
					jb52.setEnabled(false);
					
				}
				else
				{
					jb52.setSelected(true);
					jb52.setEnabled(true);
					jb51.setEnabled(false);
				}
				jtf6.setText(details.getMobile());
				jtf7.setText(details.getAddress());
				
				jb9.setEnabled(true);
			}
			
		}	
		public void mouseEntered(MouseEvent e)
		{
			if(e.getSource() == jl11)
			{
				jl11.setForeground(Color.RED);
			}
			if(e.getSource()==jlc)
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
			if(e.getSource()==jlc)
			{
				jlc.setForeground(Color.WHITE);
			}
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
						
			if(e.getSource() == jb9)
			{
				    boolean status = false;
				   
				    	status = DBOperations.delete(jtf2.getText(), "user_details");
						if(status)
						{
							JOptionPane.showMessageDialog(jp2, "Customer deleted successfully","Success",JOptionPane.INFORMATION_MESSAGE);
							
							jtf1.setText(null);
							jtf2.setText(null);
							jb.clearSelection();
							jtf6.setText(null);
							jtf7.setText(null);
							
							CustomerSection custom = new CustomerSection();
							custom.jf.setVisible(true);
							this.jf.setVisible(false);
						}
						else
						{
							JOptionPane.showMessageDialog(jp2, "Some error occured","Error",JOptionPane.ERROR_MESSAGE);
						}
			}
	}
		
}
