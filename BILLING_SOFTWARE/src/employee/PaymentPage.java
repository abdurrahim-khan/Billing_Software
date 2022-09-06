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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dboperations.DBOperations;
import implementors.Implementor;
import validator.EntryValidator;

class PaymentPage extends Implementor implements ActionListener
{
	JFrame jf;
	JPanel jp;
	JLabel jl0, jl1,jl2,jl3,jl4, jl5,jlb;
	JButton jb1, jb2, jb3;
	JTextField jtf1;
	
	String grand_total;
	public PaymentPage(String grand_total)
	{
		createFrame();
		this.grand_total = grand_total;
		jl2.setText(grand_total);
	}
	public void createFrame()
	{
		jf = new JFrame();
		jf.setSize(600,500);
		jf.setUndecorated(true);
		jf.setBounds(460,130,600,500);
		
		jp = new JPanel();
		jf.add(jp);
		jp.setLayout(null);
		jp.setBackground(Color.MAGENTA);
		
		jl0 = new JLabel("Payment Page");
		jl0.setBounds(110,5,400,75);
		jl0.setFont(new Font("Arial",Font.BOLD,52));
		jl0.setForeground(Color.WHITE);
		jp.add(jl0);
		
		jl1 = new JLabel("Amount due");
		jl1.setBounds(40,120,200,50);
		jl1.setFont(new Font("Arial",Font.BOLD,28));
		jl1.setForeground(Color.WHITE);
		jp.add(jl1);
		
		jl2 = new JLabel(grand_total);
		jl2.setBounds(360,118,200,50);
		jl2.setFont(new Font("Arial",Font.BOLD,32));
		jl2.setForeground(Color.WHITE);
		jp.add(jl2);
		
		jl3 = new JLabel("Tendered Amount");
		jl3.setBounds(36,180,300,50);
		jl3.setFont(new Font("Arial",Font.BOLD,28));
		jl3.setForeground(Color.WHITE);
		jp.add(jl3);
		
		jtf1 = new JTextField();
		jtf1.setBounds(355,185,190,40);
		jtf1.setFont(new Font("Arial",Font.BOLD,32));
		jp.add(jtf1);
		
		jl4 = new JLabel("Return Amount");
		jl4.setBounds(40,240,250,50);
		jl4.setFont(new Font("Arial",Font.BOLD,28));
		jl4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jl4.addMouseListener(this);
		jl4.setForeground(Color.WHITE);
		jp.add(jl4);
		
		jl5 = new JLabel("0");
		jl5.setBounds(360,240,200,50);
		jl5.setFont(new Font("Arial",Font.BOLD,32));
		jl5.setForeground(Color.WHITE);
		jp.add(jl5);
		
		jb1 = new JButton("Finish");
		jb1.setBounds(60,330,200,75);
		jb1.setFocusPainted(false);
		jb1.setBackground(Color.WHITE);
		jb1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jb1.setFont(new Font("Arial",Font.BOLD,36));
		jb1.addActionListener(this);
		jp.add(jb1);
		

		jb2 = new JButton("Abort");
		jb2.setBounds(320,330,200,75);
		jb2.setFocusPainted(false);
		jb2.setBackground(Color.WHITE);
		jb2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jb2.setFont(new Font("Arial",Font.BOLD,36));
		jb2.addActionListener(this);
		jp.add(jb2);
		
		jlb = new JLabel("Back");
		jlb.setBounds(5,5,50,25);
		jlb.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jlb.setFont(new Font("Arial",Font.BOLD,18));
		jlb.addMouseListener(this);
		jlb.setForeground(Color.WHITE);
		jp.add(jlb);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jb2)
		{
			DBOperations.emptyCart("changes_not_to_be_reflected");
			EmployeePage emp = new EmployeePage();
			emp.jf.setVisible(true);
			this.jf.setVisible(false);
		}
		if(e.getSource() == jb1)
		{
			DBOperations.emptyCart("changes_to_be_reflected");
			EmployeePage emp = new EmployeePage();
			emp.jf.setVisible(true);
			this.jf.setVisible(false);
		}
	}
	public void mouseEntered(MouseEvent e)
	{
		if(e.getSource()==jlb)
		{
			jlb.setForeground(Color.RED);
		}
		if(e.getSource()==jl4)
		{
			jl4.setForeground(Color.RED);
		}
	}
	public void mouseExited(MouseEvent e)
	{
		if(e.getSource()==jlb)
		{
			jlb.setForeground(Color.WHITE);
		}
		if(e.getSource()==jl4)
		{
			jl4.setForeground(Color.WHITE);
		}
	}
	public void mouseClicked(MouseEvent e)
	{
		if(e.getSource()==jlb)
		{
			 AddCustomerPage acp = new AddCustomerPage();
			 acp.jf.setVisible(true);
			 this.jf.setVisible(false);
		}
		if(e.getSource()==jl4)
		{
			  EntryValidator validator = new EntryValidator();
			  boolean isvalid = validator.itempriceValidator(jtf1.getText());
			  if(!isvalid)
			  {
				  JOptionPane.showMessageDialog(jp, "Invalid Amount Tendered","Error",JOptionPane.ERROR_MESSAGE);
				  jtf1.setText(null);
			  }
			  else
			  {
				  int return_amount = Integer.parseInt(jtf1.getText()) - Integer.parseInt(jl2.getText());
				  if(return_amount < 0)
				  {
					  int num = Math.abs(return_amount);
					  String msg = num+" Rupees more needs to be paid";
					  JOptionPane.showMessageDialog(jp, msg,"Error",JOptionPane.ERROR_MESSAGE);
					  jtf1.setText(null);
				  }
				  else
				  {
					  jl5.setText(return_amount+"");
				  }
			  }
			  
			  
		}
	}
}
