package employee;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.xml.validation.Validator;


import dboperations.DBOperations;
import gettersetter.Adder;
import hashing.Hashing;
import implementors.Implementor;
import validator.EntryValidator;

class StartBilling extends Implementor implements ActionListener 
{

	
	JFrame jf;
	JLabel jl0,jl01, jbk,jlh1,jlh2, jl1, jl2, jl3, jl4;
	JButton jb1,jb2,jb3, jb4, jb5, jb6;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5;
	
	JTextArea jtf6;
	JPanel jp1,jp2;
	
	JTable jt;
	
	
	public StartBilling()
	{
		createFrame();
		Hashing hashing = new Hashing("cart_details");
		String grandtotal = DBOperations.getGrandTotal();
		jl2.setText(grandtotal);
		if(grandtotal.equals("0"))
		{
			jb6.setEnabled(false);
		}
		else
		{
			jb6.setEnabled(true);
		}
	}
	
	public void createFrame()
	{
		
		jf = new JFrame();
		jf.setSize(1600,800);
		jf.setBounds(-8,0,1600,800);
		jf.setLayout(null);
		jf.setUndecorated(true);
		
		jp1 = new JPanel();
		jp1.setSize(500,800);
		
		jp1.setBounds(0,0,500,800);
		
		jp1.setLayout(null);
		jp1.setBackground(Color.MAGENTA);
		jf.add(jp1);
		
		jp2 = new JPanel();
		jp2.setSize(1100,800);
		jp2.setBounds(500,0,1100,800);
		jp2.setLayout(null);
		jp2.setBackground(Color.MAGENTA);
		jf.add(jp2);
		
		JScrollPane js = new JScrollPane();
		js.setBounds(30,90,460,540);
		jp1.add(js);
		
		jt = DBOperations.cartTableCreator();
		jt.addMouseListener(this);
		jt.setDefaultEditor(Object.class, null);
		js.add(jt);
		jt.setBackground(Color.WHITE);
		js.setViewportView(jt);
		
		//left side done
		
		jl1 = new JLabel("Grand Total =");
		jl1.setBounds(40,650,250,100);
		jl1.setFont(new Font("Arial",Font.BOLD,38));
		jl1.setForeground(Color.WHITE);
		jp1.add(jl1);
		
		jl2 = new JLabel("0");
		jl2.setBounds(300,650,300,100);
		jl2.setFont(new Font("Arial",Font.BOLD,38));
		jl2.setForeground(Color.WHITE);
		jp1.add(jl2);
		
		jl3 = new JLabel("Total =");
		jl3.setBounds(130,650,200,100);
		jl3.setFont(new Font("Arial",Font.BOLD,38));
		jl3.setForeground(Color.WHITE);
		jp2.add(jl3);
		
		jl4 = new JLabel("0");
		jl4.setBounds(270,650,300,100);
		jl4.setFont(new Font("Arial",Font.BOLD,38));
		jl4.setForeground(Color.WHITE);
		jp2.add(jl4);
		
		
		jlh1 = new JLabel("Cart");
		jlh1.setFont(new Font("Arial",Font.BOLD,32));
		jlh1.setForeground(Color.WHITE);
		jlh1.setBounds(220,-35,500,200);
		jp1.add(jlh1);
		jlh2 = new JLabel("Billing Section");
		jlh2.setFont(new Font("Arial",Font.BOLD,55));
		jlh2.setForeground(Color.WHITE);
		jlh2.setBounds(50,-55,500,200);
		jp2.add(jlh2);
		
		
		jl0 = new JLabel("Back");
		jl0.setFont(new Font("Arial",Font.BOLD,20));
		jl0.setForeground(Color.WHITE);
		jl0.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jl0.addMouseListener(this);
		jl0.setBounds(10,10,50,25);
		jp1.add(jl0);
		
		jl01 = new JLabel("Abort");
		jl01.setFont(new Font("Arial",Font.BOLD,20));
		jl01.setForeground(Color.WHITE);
		jl01.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jl01.addMouseListener(this);
		jl01.setBounds(815,5,100,25);
		jp2.add(jl01);
		
		
		JLabel jl1 = new JLabel("Item ID");
		jl1.setFont(new Font("Arial", Font.BOLD,22));
		jl1.setForeground(Color.WHITE);
		jl1.setBounds(20,90,100,50);
		jp2.add(jl1);
		
		jtf1 = new JTextField();
		jtf1.setBounds(210,90,170,50);
		jtf1.setFont(new Font("Arial",Font.PLAIN,16));
		jp2.add(jtf1);
		
		jb4 = new JButton("Clear");
		jb4.setBounds(400,90,110,50);
		jb4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jb4.setFocusPainted(false);
		jb4.setFont(new Font("Arial", Font.BOLD, 26));
		jb4.addMouseListener(this);
		jb4.addActionListener(this);
		jb4.setBackground(Color.WHITE);
		jp2.add(jb4);
		
		JLabel jl2 = new JLabel("Item Category");
		jl2.setFont(new Font("Arial", Font.BOLD,22));
		
		jl2.setForeground(Color.WHITE);
		jl2.setBounds(20,330,200,50);
		jp2.add(jl2);
		
		jtf2 = new JTextField();
		jtf2.setFont(new Font("Arial",Font.PLAIN,16));
		jtf2.setEditable(false);
		jtf2.setBackground(Color.WHITE);
		jtf2.setBounds(210,330,300,50);
		jp2.add(jtf2);
		
		JLabel jl3 = new JLabel("Item Name");
		jl3.setFont(new Font("Arial", Font.BOLD,22));
		jl3.setForeground(Color.WHITE);
		jl3.setBounds(20,250,200,50);
		jp2.add(jl3);
		
		jtf3 = new JTextField();
		jtf3.setFont(new Font("Arial",Font.PLAIN,16));
		jtf3.setBackground(Color.WHITE);
		jtf3.setEditable(false);
		jtf3.setBounds(210,250,300,50);
		jp2.add(jtf3);
		
		JLabel jl4 = new JLabel("Item Quantity");
		jl4.setFont(new Font("Arial", Font.BOLD,22));
		jl4.setForeground(Color.WHITE);
		jl4.setBounds(20,170,200,50 );  
		jp2.add(jl4);
		
		jtf4 = new JTextField("1");
		jtf4.setFont(new Font("Arial",Font.PLAIN,16));
		jtf4.setBounds(210,170,170,50);   
		jp2.add(jtf4);
		
		jb5 = new JButton("Fetch");
		jb5.setBounds(400,170,110,50);
		jb5.setFont(new Font("Arial", Font.BOLD, 26));
		jb5.setFocusPainted(false);
		jb5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jb5.addActionListener(this);
		jb5.setBackground(Color.WHITE);
		jp2.add(jb5);
		
		JLabel jl5 = new JLabel("Item Price");
		jl5.setFont(new Font("Arial", Font.BOLD,22));
		jl5.setForeground(Color.WHITE);
		jl5.setBounds(20,410,200,50);
		jp2.add(jl5);
		
		jtf5 = new JTextField();
		jtf5.setFont(new Font("Arial",Font.PLAIN,16));
		jtf5.setEditable(false);
		jtf5.setBackground(Color.WHITE);
		jtf5.setBounds(210,410,300,50);
		jp2.add(jtf5);
		
		JLabel jl6 = new JLabel("Item Description");
		jl6.setFont(new Font("Arial", Font.BOLD,22));
		jl6.setForeground(Color.WHITE);
		jl6.setBounds(20,520,200,50);
		jp2.add(jl6);
		
		jtf6 = new JTextArea();
		jtf6.setFont(new Font("Arial",Font.PLAIN,16));
		jtf6.setEditable(false);
		jtf6.setLineWrap(true);
		jtf6.setWrapStyleWord(true);
		jtf6.setBackground(Color.WHITE);
		jtf6.setBounds(210,490,300,135);
		jp2.add(jtf6);
		
		
		jbk = new JLabel("");
		jbk.setIcon(new ImageIcon("C:\\Users\\micro\\Desktop\\mydefaultimg.png"));
		jbk.setBounds(542,90,270,250);
		jbk.addMouseListener(this);
		jp2.add(jbk);
		
		jb1 = new JButton("Add To Cart");
		jb1.setBackground(Color.WHITE);
		jb1.setFocusPainted(false);
		jb1.setFont(new Font("Arial", Font.BOLD,26));
		jb1.setBounds(595,360,200,75);
		jb1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jb1.addActionListener(this);
		jp2.add(jb1);
		
		jb2 = new JButton("Delete");
		jb2.setEnabled(false);
		jb2.setFont(new Font("Arial", Font.BOLD,26));
		jb2.setFocusPainted(false);
		jb2.setBackground(Color.WHITE);
		jb2.setBounds(595,455,200,75);
		jb2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jb2.addActionListener(this);
		jp2.add(jb2);
		
		jb3 = new JButton("Update");
		jb3.setEnabled(false);
		jb3.setFont(new Font("Arial", Font.BOLD,26));
		jb3.setBackground(Color.WHITE);
		jb3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jb3.setFocusPainted(false);
		jb3.setBounds(595,550,200,75);
		jb3.addActionListener(this);
		jp2.add(jb3);
		
		jb6 = new JButton("Checkout");
		jb6.setFont(new Font("Arial", Font.BOLD,26));
		jb6.setBackground(Color.WHITE);
		jb6.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jb6.setEnabled(false);
		jb6.setFocusPainted(false);
		jb6.setBounds(595,650,200,75);
		jb6.addActionListener(this);
		jp2.add(jb6);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1)
		{
			if(jtf3.getText().equals(""))
			{
				JOptionPane.showMessageDialog(jp2, "Please fetch an item first","Error",JOptionPane.ERROR_MESSAGE);
				jtf1.setText(null);
				jtf4.setText("1");
			}
			else
			{
					boolean status = false;
					if(Hashing.isCartItemPresent(jtf1.getText()))
					{
						int existingquantity = Hashing.getCartItemQuantity(jtf1.getText());
						int finalquantity = existingquantity + Integer.parseInt(jtf4.getText());
						status = DBOperations.alterExisting(jtf1.getText(),finalquantity+"", "cart_details");
						System.out.print(status);
					}
					else
					{
						Adder ad = new Adder();
						ad.setItemId(jtf1.getText());
						
						ad.setItemName(jtf3.getText());
						ad.setItemQuantity(jtf4.getText());
						ad.setItemPrice(jtf5.getText());
						
						int total = Integer.parseInt(jtf5.getText()) * Integer.parseInt(jtf4.getText());
						ad.setItemTotal(total+"");
						
						status = DBOperations.addNew(ad, "cart_details");
						
					}
					
					if(status)
					{
						JOptionPane.showMessageDialog(jp2, "Item added to cart successfully","Success",JOptionPane.INFORMATION_MESSAGE);
						jtf1.setText(null);
						jtf2.setText(null);
						jtf3.setText(null);
						jtf4.setText(null);
						jtf5.setText(null);
						jtf6.setText(null);
						jbk.setIcon(new ImageIcon("C:\\Users\\micro\\Desktop\\mydefaultimg.png"));
						jl4.setText("0");
						
						StartBilling sb = new StartBilling();
						sb.jf.setVisible(true);
						this.jf.setVisible(false);
								
					}
					else
					{
						JOptionPane.showMessageDialog(jp2, "Some error occured","Error",JOptionPane.ERROR_MESSAGE);
					}
				
			   }
				
			}
		if(e.getSource() == jb4)
		{
			jtf1.setText(null);
			jtf2.setText(null);
			jtf3.setText(null);
			jtf4.setText("1");
			jtf5.setText(null);
			jtf6.setText(null);
			jbk.setIcon(new ImageIcon("C:\\Users\\micro\\Desktop\\mydefaultimg.png"));
			jl4.setText("0");
			
			jb1.setEnabled(true);
			jb2.setEnabled(false);
			jb3.setEnabled(false);
		}
		if(e.getSource() == jb5)
		{
			String itemid = jtf1.getText();
			//System.out.println(itemid);
			EntryValidator validator = new EntryValidator();
			boolean isvalid = validator.itemidValidator(itemid);
			//System.out.println(isvalid);
			if(!isvalid)
			{
				JOptionPane.showMessageDialog(jp2, "Invalid Item ID","Error", JOptionPane.ERROR_MESSAGE);
				jtf1.setText(null);
				jtf4.setText("1");
			}
			else if(jtf4.getText().length() == 0)
			{
				JOptionPane.showMessageDialog(jp2, "Quantity field cannot be empty","Error", JOptionPane.ERROR_MESSAGE);
			}
			else if(jtf4.getText().equals("0"))
			{
				JOptionPane.showMessageDialog(jp2, "Quantity cannot be zero","Error", JOptionPane.ERROR_MESSAGE);
				jtf4.setText("1");
			}
			else
			{
				//fetch details from item_details table
				Adder details = DBOperations.getDetails(itemid, "item_details");
				if(details == null)
				{
					JOptionPane.showMessageDialog(jp2, "Item does not exist","Error", JOptionPane.ERROR_MESSAGE);
					jtf1.setText(null);
					jtf4.setText("1");
				}
				else
				{
					jtf1.setEditable(false);
					//jtf2.setEditable(true);
					jtf2.setText(details.getItemCategory());
					//jtf2.setEditable(false);;
					//jtf3.setEditable(true);
					jtf3.setText(details.getItemName());
					//jtf3.setEditable(false);
					//jtf5.setEditable(true);
					jtf5.setText(details.getItemPrice());
					//jtf5.setEditable(false);
					//jtf6.setEditable(true);
					jtf6.setText(details.getItemDescription());
					//jtf6.setEditable(false);
					
					ImageIcon imgicn = details.getItemImageIcon();
					Image img = imgicn.getImage();
					Image scaledimg = img.getScaledInstance(jbk.getWidth(), jbk.getHeight(), Image.SCALE_SMOOTH);
					ImageIcon finalicon = new ImageIcon(scaledimg);
					jbk.setIcon(finalicon);
					
					int total = Integer.parseInt(details.getItemPrice()) * Integer.parseInt(jtf4.getText());
					jl4.setText(total+"");
				}
				
			}
		}
		if(e.getSource()==jb2)
		{
			boolean status = DBOperations.delete(jtf1.getText(), "cart_details");
			if(status)
			{
				JOptionPane.showMessageDialog(jp2, "Item deleted from cart successfully","Success",JOptionPane.INFORMATION_MESSAGE);
				jtf1.setText(null);
				jtf2.setText(null);
				jtf3.setText(null);
				jtf4.setText("1");
				jtf5.setText(null);
				jtf6.setText(null);
				jbk.setIcon(new ImageIcon("C:\\Users\\micro\\Desktop\\mydefaultimg.png"));
				jl4.setText("0");
				
				StartBilling sb = new StartBilling();
				sb.jf.setVisible(true);
				this.jf.setVisible(false);
						
				
			}
			else
			{
				JOptionPane.showMessageDialog(jp2, "Some error occured","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource() == jb3)
		{
			
					boolean status = false;
					
					
						Adder ad = new Adder();
						ad.setItemId(jtf1.getText());
						ad.setItemQuantity(jtf4.getText());
						int total = Integer.parseInt(jtf5.getText()) * Integer.parseInt(jtf4.getText());
						ad.setItemTotal(total+"");
						
						
						status = DBOperations.update(ad, "cart_details");
					
					if(status)
					{
						JOptionPane.showMessageDialog(jp2, "Cart updated successfully","Success",JOptionPane.INFORMATION_MESSAGE);
						jtf1.setText(null);
						jtf2.setText(null);
						jtf3.setText(null);
						jtf4.setText("1");
						jtf5.setText(null);
						jtf6.setText(null);
						jbk.setIcon(new ImageIcon("C:\\Users\\micro\\Desktop\\mydefaultimg.png"));
						jl4.setText("0");
						
						jb1.setEnabled(true);
						jb2.setEnabled(false);
						jb3.setEnabled(false);
						
						
						StartBilling sb = new StartBilling();
						sb.jf.setVisible(true);
						this.jf.setVisible(false);
								
					}
					else
					{
						JOptionPane.showMessageDialog(jp2, "Some error occured","Error",JOptionPane.ERROR_MESSAGE);
					}
		}
		if(e.getSource() == jb6)
		{
			AddCustomerPage acp = new AddCustomerPage();
			acp.jf.setVisible(true);
			this.jf.setVisible(false);
		}
	}
	
	public void mouseEntered(MouseEvent e)
	{
		if(e.getSource() == jl0)
		{
			jl0.setForeground(Color.RED);
		}
		if(e.getSource() == jl01)
		{
			jl01.setForeground(Color.RED);
		}
		if(e.getSource() == jb4)
		{
			
			jb4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
	}
	public void mouseExited(MouseEvent e)
	{
		if(e.getSource() == jl0)
		{
			jl0.setForeground(Color.WHITE);
		}
		if(e.getSource() == jl01)
		{
			jl01.setForeground(Color.WHITE);
		}
		if(e.getSource() == jb4)
		{
			
			jb4.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
	}
	public void mouseClicked(MouseEvent e)
	{
		if(e.getSource() == jl0)
		{
			EmployeePage emp = new EmployeePage();
			emp.jf.setVisible(true);
			this.jf.setVisible(false);
		}
		if(e.getSource() == jl01)
		{
			DBOperations.emptyCart("changes_not_to_be_reflected");
			EmployeePage emp = new EmployeePage();
			emp.jf.setVisible(true);
			this.jf.setVisible(false);
		}
		if(e.getSource()==jt)
		{
			int rownum = jt.getSelectedRow();
			String item_id = (String) jt.getValueAt(rownum, 1);
			System.out.println(item_id);
			Adder details = DBOperations.getDetails(item_id, "item_details");
			System.out.println(details);
			jtf1.setText(details.getItemId());
			jtf1.setEditable(false);
			
			jtf2.setText(details.getItemCategory());
			jtf3.setText(details.getItemName());
			
			String quant = (String) jt.getValueAt(rownum, 4);
			jtf4.setText(quant);
			
			jtf5.setText(details.getItemPrice());
			jtf6.setText(details.getItemDescription());
			
			int total = Integer.parseInt(jtf5.getText()) * Integer.parseInt(jtf4.getText());
			jl4.setText(total+"");
			
			
			
			ImageIcon imgicn = details.getItemImageIcon();
			Image img = imgicn.getImage();
			Image scaledimg = img.getScaledInstance(jbk.getWidth(), jbk.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon finalicon = new ImageIcon(scaledimg);
			jbk.setIcon(finalicon);
			
			jb1.setEnabled(false);
			jb2.setEnabled(true);
			jb3.setEnabled(true);
		}
		
		
	}
}
