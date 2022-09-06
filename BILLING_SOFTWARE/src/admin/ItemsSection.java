package admin;
import java.io.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;



import dboperations.DBOperations;
import gettersetter.Adder;
import hashing.Hashing;
import implementors.Implementor;
import validator.EntryValidator;

class ItemsSection extends Implementor implements ActionListener 
{
	
	JFrame jf;
	JLabel jl0, jlc, jbk,jlh1,jlh2;
	JButton jb1,jb2,jb3;
	JTextField jtf1,jtf3,jtf4,jtf5;
	JComboBox jtf2;
	JTextArea jtf6;
	JPanel jp1,jp2;
	File file;
	FileInputStream fileinputstream;
	JTable jt;
	String[] arr = {"Select Category","Dress","Grocery","Utensil","Household item","Appliances","Electronics","Computer"};
	public ItemsSection()
	{
		createFrame();
		Hashing hashing = new Hashing("item_details");
		file = new File("C:\\Users\\micro\\Desktop\\mydefaultimg.png");
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
		js.setBounds(30,130,460,540);
		jp1.add(js);
		
		jt = DBOperations.itemTableCreator("whole_table");
		jt.addMouseListener(this);
		jt.setDefaultEditor(Object.class, null);
		js.add(jt);
		jt.setBackground(Color.WHITE);
		js.setViewportView(jt);
		
		//left side done
		
		jlh1 = new JLabel("Items");
		jlh1.setFont(new Font("Arial",Font.BOLD,60));
		jlh1.setForeground(Color.WHITE);
		jlh1.setBounds(330,-30,500,200);
		jp1.add(jlh1);
		jlh2 = new JLabel("Section");
		jlh2.setFont(new Font("Arial",Font.BOLD,60));
		jlh2.setForeground(Color.WHITE);
		jlh2.setBounds(30,-30,500,200);
		jp2.add(jlh2);
		
		
		jl0 = new JLabel("Back");
		jl0.setFont(new Font("Arial",Font.BOLD,20));
		jl0.setForeground(Color.WHITE);
		jl0.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jl0.addMouseListener(this);
		jl0.setBounds(10,10,50,25);
		jp1.add(jl0);
		
		
		JLabel jl1 = new JLabel("Item ID");
		jl1.setFont(new Font("Arial", Font.BOLD,22));
		jl1.setForeground(Color.WHITE);
		jl1.setBounds(20,130,200,50);
		jp2.add(jl1);
		
		jtf1 = new JTextField();
		jtf1.setBounds(210,130,300,50);
		jtf1.setFont(new Font("Arial",Font.PLAIN,16));
		jp2.add(jtf1);
		
		JLabel jl2 = new JLabel("Item Category");
		jl2.setFont(new Font("Arial", Font.BOLD,22));
		jl2.setForeground(Color.WHITE);
		jl2.setBounds(20,210,200,50);
		jp2.add(jl2);
		
		jtf2 = new JComboBox(arr);
		jtf2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jtf2.setFont(new Font("Arial",Font.PLAIN,16));
		jtf2.setBackground(Color.WHITE);
		jtf2.setBounds(210,210,300,50);
		jp2.add(jtf2);
		
		JLabel jl3 = new JLabel("Item Name");
		jl3.setFont(new Font("Arial", Font.BOLD,22));
		jl3.setForeground(Color.WHITE);
		jl3.setBounds(20,290,200,50);
		jp2.add(jl3);
		
		jtf3 = new JTextField();
		jtf3.setFont(new Font("Arial",Font.PLAIN,16));
		jtf3.setBounds(210,290,300,50);
		jp2.add(jtf3);
		
		JLabel jl4 = new JLabel("Item Quantity");
		jl4.setFont(new Font("Arial", Font.BOLD,22));
		jl4.setForeground(Color.WHITE);
		jl4.setBounds(20,370,200,50);
		jp2.add(jl4);
		
		jtf4 = new JTextField();
		jtf4.setFont(new Font("Arial",Font.PLAIN,16));
		jtf4.setBounds(210,370,300,50);
		jp2.add(jtf4);
		
		JLabel jl5 = new JLabel("Item Price");
		jl5.setFont(new Font("Arial", Font.BOLD,22));
		jl5.setForeground(Color.WHITE);
		jl5.setBounds(20,450,200,50);
		jp2.add(jl5);
		
		jtf5 = new JTextField();
		jtf5.setFont(new Font("Arial",Font.PLAIN,16));
		jtf5.setBounds(210,450,300,50);
		jp2.add(jtf5);
		
		JLabel jl6 = new JLabel("Item Description");
		jl6.setFont(new Font("Arial", Font.BOLD,22));
		jl6.setForeground(Color.WHITE);
		jl6.setBounds(20,570,200,50);
		jp2.add(jl6);
		
		jtf6 = new JTextArea();
		jtf6.setFont(new Font("Arial",Font.PLAIN,16));
		jtf6.setLineWrap(true);
		jtf6.setWrapStyleWord(true);
		jtf6.setBounds(210,530,300,135);
		jp2.add(jtf6);
		
		jlc = new JLabel("Clear Selection");
		jlc.setFont(new Font("Arial",Font.BOLD,36));
		jlc.setForeground(Color.WHITE);
		jlc.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jlc.addMouseListener(this);
		jlc.setBackground(Color.white);
		jp2.add(jlc);
		jlc.setBounds(170,680,300,75);
		
		
		jbk = new JLabel("");
		jbk.setIcon(new ImageIcon("C:\\Users\\micro\\Desktop\\mydefaultimg.png"));
		jbk.setBounds(542,130,270,250);
		jbk.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jbk.addMouseListener(this);
		jp2.add(jbk);
		
		jb1 = new JButton("Add");
		jb1.setBackground(Color.WHITE);
		jb1.setFocusPainted(false);
		jb1.setEnabled(true);
		jb1.setFont(new Font("Arial", Font.BOLD,26));
		jb1.setBounds(595,400,200,75);
		jb1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jb1.addActionListener(this);
		jp2.add(jb1);
		
		jb2 = new JButton("Delete");
		jb2.setFont(new Font("Arial", Font.BOLD,26));
		jb2.setFocusPainted(false);
		jb2.setEnabled(false);
		jb2.setBackground(Color.WHITE);
		jb2.setBounds(595,495,200,75);
		jb2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jb2.addActionListener(this);
		jp2.add(jb2);
		
		jb3 = new JButton("Update");
		jb3.setFont(new Font("Arial", Font.BOLD,26));
		jb3.setBackground(Color.WHITE);
		jb3.setEnabled(false);
		jb3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jb3.setFocusPainted(false);
		jb3.setBounds(595,590,200,75);
		jb3.addActionListener(this);
		jp2.add(jb3);
		
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String item_id = jtf1.getText();
		String item_category = (String) jtf2.getSelectedItem();
		String item_name = jtf3.getText();
		String item_quantity = jtf4.getText();
		String item_price = jtf5.getText();
		String item_desc = jtf6.getText();
		
		if(e.getSource()==jb3)
		{
			
			
				
				try 
				{
					fileinputstream = new FileInputStream(file);
				} 
				catch (Exception exc) 
				{
					System.out.print(exc);
				} 
				
				
				
				
				
				
				
				EntryValidator validator = new EntryValidator();
				
				if(item_category.equals(arr[0]))
				{
					JOptionPane.showMessageDialog(jp2, "Please select item category","error",JOptionPane.ERROR_MESSAGE);
					
				}
				else if(!validator.itemnameValidator(item_name))
				{
					JOptionPane.showMessageDialog(jp2, "Invalid item name","Error",JOptionPane.ERROR_MESSAGE);
					jtf3.setText(null);
				}
				else if(!validator.itemquantityValidator(item_quantity))
				{
					JOptionPane.showMessageDialog(jp2, "Invalid item quantity", "Error", JOptionPane.ERROR_MESSAGE);
					jtf4.setText(null);
				}
				else if(!validator.itempriceValidator(item_price))
				{
					JOptionPane.showMessageDialog(jp2, "Invalid item price","Error",JOptionPane.ERROR_MESSAGE);
					jtf5.setText(null);
				}
				else if(!validator.itemdescValidator(item_desc))
				{
					JOptionPane.showMessageDialog(jp2, "Invalid item description","Error",JOptionPane.ERROR_MESSAGE);
					jtf6.setText(null);
				}
				
				else
				{
					
					boolean status = false;
					
					
						Adder ad = new Adder();
						ad.setItemId(item_id);
						ad.setItemCategory(item_category);
						ad.setItemName(item_name);
						ad.setItemQuantity(item_quantity);
						ad.setItemPrice(item_price);
						ad.setItemDescription(item_desc);
						
						//extracting image from jlabel and converting it to a fileinputstream --- starts from below
						
						ImageIcon ic = (ImageIcon) jbk.getIcon();
						Image img = ic.getImage();
						
						BufferedImage bufimg = new BufferedImage(img.getWidth(null),img.getHeight(null),BufferedImage.TYPE_INT_RGB);
						Graphics bg = bufimg.getGraphics();
						bg.drawImage(img, 0, 0, null);
						bg.dispose();
						
						
						
					      ByteArrayOutputStream bos = new ByteArrayOutputStream();
					      try
					      {
							ImageIO.write(bufimg, "jpg", bos );
						  } 
					      catch (IOException e1)
					      {
							// TODO Auto-generated catch block
					    	  System.out.println("  line 337   ");
							e1.printStackTrace();
						  }
					      byte [] data = bos.toByteArray();
					      File outputFile = new File("image.png");

					      try ( FileOutputStream outputStream = new FileOutputStream(outputFile); ) 
					      {
					          outputStream.write(data); 

					      }
					      catch (Exception ex) 
					      {
					    	  System.out.println("  line 50   ");
					          ex.printStackTrace();
					      }
						FileInputStream fis = null;
					      try 
					      {
							fis = new FileInputStream(outputFile);
						  }
					      catch (FileNotFoundException e1) 
					      {
							
							e1.printStackTrace();
						  }
						
					     // now that the imageicon from jlabel has been converted to fileinputstream ,,,we will send it to databae
						ad.setItemImage(fis);
						
						
						status = DBOperations.update(ad, "item_details");
					
					if(status)
					{
						JOptionPane.showMessageDialog(jp2, "Item updated successfully","Success",JOptionPane.INFORMATION_MESSAGE);
						jtf1.setText(null);
						jtf2.setSelectedItem(arr[0]);
						jtf3.setText(null);
						jtf4.setText(null);
						jtf5.setText(null);
						jtf6.setText(null);
						jbk.setIcon(new ImageIcon("C:\\Users\\micro\\Desktop\\mydefaultimg.png"));
						
						ItemsSection itm = new ItemsSection();
						itm.jf.setVisible(true);
						this.jf.setVisible(false);
								
					}
					else
					{
						JOptionPane.showMessageDialog(jp2, "Some error occured","Error",JOptionPane.ERROR_MESSAGE);
					}
				}
						
			
		}
		if(e.getSource()==jb1)
		{
			
				try 
				{
					fileinputstream = new FileInputStream(file);
				} 
				catch (Exception exc) 
				{
					System.out.print(exc);
				} 
				
				
				
				
				EntryValidator validator = new EntryValidator();
				if(!validator.itemidValidator(item_id))
				{
					JOptionPane.showMessageDialog(jp2,"Invalid item ID \n Only numeric upto 4 characters allowed","Error",JOptionPane.ERROR_MESSAGE);
					jtf1.setText(null);
				}
				else if(item_category.equals(arr[0]))
				{
					JOptionPane.showMessageDialog(jp2, "Please select item category","error",JOptionPane.ERROR_MESSAGE);
					
				}
				else if(!validator.itemnameValidator(item_name))
				{
					JOptionPane.showMessageDialog(jp2, "Invalid item name","Error",JOptionPane.ERROR_MESSAGE);
					jtf3.setText(null);
				}
				else if(!validator.itemquantityValidator(item_quantity))
				{
					JOptionPane.showMessageDialog(jp2, "Invalid item quantity", "Error", JOptionPane.ERROR_MESSAGE);
					jtf4.setText(null);
				}
				else if(!validator.itempriceValidator(item_price))
				{
					JOptionPane.showMessageDialog(jp2, "Invalid item price","Error",JOptionPane.ERROR_MESSAGE);
					jtf5.setText(null);
				}
				else if(!validator.itemdescValidator(item_desc))
				{
					JOptionPane.showMessageDialog(jp2, "Invalid item description","Error",JOptionPane.ERROR_MESSAGE);
					jtf6.setText(null);
				}
				/*else if(check_if_image == null)
				{
					JOptionPane.showMessageDialog(jp2, "Please select an image file","Error",JOptionPane.ERROR_MESSAGE);
					jbk.setIcon(new ImageIcon("C:\\Users\\micro\\Desktop\\mydefaultimg.png"));
				}*/
				
				else
				{
					
					boolean status = false;
					if(Hashing.isItemPresent(item_id))
					{
						int existingquantity = Hashing.getItemQuantity(item_id);
						int finalquantity = existingquantity + Integer.parseInt(item_quantity);
						status = DBOperations.alterExisting(item_id,finalquantity+"", "item_details");
					}
					else
					{
						Adder ad = new Adder();
						ad.setItemId(item_id);
						ad.setItemCategory(item_category);
						ad.setItemName(item_name);
						ad.setItemQuantity(item_quantity);
						ad.setItemPrice(item_price);
						ad.setItemDescription(item_desc);
						ad.setItemImage(fileinputstream);
						status = DBOperations.addNew(ad, "item_details");
						
					}
					if(status)
					{
						JOptionPane.showMessageDialog(jp2, "Item added successfully","Success",JOptionPane.INFORMATION_MESSAGE);
						jtf1.setText(null);
						jtf2.setSelectedItem(arr[0]);
						jtf3.setText(null);
						jtf4.setText(null);
						jtf5.setText(null);
						jtf6.setText(null);
						jbk.setIcon(new ImageIcon("C:\\Users\\micro\\Desktop\\mydefaultimg.png"));
						
						ItemsSection itm = new ItemsSection();
						itm.jf.setVisible(true);
						this.jf.setVisible(false);
								
					}
					else
					{
						JOptionPane.showMessageDialog(jp2, "Some error occured","Error",JOptionPane.ERROR_MESSAGE);
					}
				}
			
				
			}
			
			
					
		
		if(e.getSource() == jb2)
		{
			
			
				boolean status = DBOperations.delete(item_id, "item_details");
				if(status)
				{
					JOptionPane.showMessageDialog(jp2, "Item deleted successfully","Success",JOptionPane.INFORMATION_MESSAGE);
					jtf1.setText(null);
					jtf2.setSelectedItem(arr[0]);
					jtf3.setText(null);
					jtf4.setText(null);
					jtf5.setText(null);
					jtf6.setText(null);
					jbk.setIcon(new ImageIcon("C:\\Users\\micro\\Desktop\\mydefaultimg.png"));
					
					ItemsSection itm = new ItemsSection();
					itm.jf.setVisible(true);
					this.jf.setVisible(false);
							
					
				}
				else
				{
					JOptionPane.showMessageDialog(jp2, "Some error occured","Error",JOptionPane.ERROR_MESSAGE);
				}
			
		}
		
	}
	public void mouseEntered(MouseEvent e)
	{
		if(e.getSource()==jl0)
		{
			jl0.setForeground(Color.RED);
		}
		if(e.getSource()==jlc)
		{
			jlc.setForeground(Color.RED);
		}
	}
	public void mouseExited(MouseEvent e)
	{
		if(e.getSource()==jl0)
		{
			jl0.setForeground(Color.WHITE);
		}
		if(e.getSource()==jlc)
		{
			jlc.setForeground(Color.WHITE);
		}
	}
	public void mouseClicked(MouseEvent e)
	{
		if(e.getSource()==jl0)
		{
			AdminPage adm = new AdminPage();
			adm.jf.setVisible(true);
			this.jf.setVisible(false);
		}
		if(e.getSource()==jlc)
		{
			jtf1.setText(null);
			jtf2.setSelectedItem(arr[0]);
			jtf3.setText(null);
			jtf4.setText(null);
			jtf5.setText(null);
			jtf6.setText(null);
			jbk.setIcon(new ImageIcon("C:\\Users\\micro\\Desktop\\mydefaultimg.png"));
			
			jb1.setEnabled(true);
			jb2.setEnabled(false);
			jb3.setEnabled(false);
			jtf1.setEditable(true);
		}
		if(e.getSource() == jbk)
		{
			JFileChooser filechooser = new JFileChooser();
			int i = filechooser.showOpenDialog(jp2);
			if(i==0)
			{
				file = filechooser.getSelectedFile();
				String file_path = file.getAbsolutePath();
				
				BufferedImage bufimg = null;
				Image finalimg = null;
				try
				{
					bufimg = ImageIO.read(new File(file_path));
					finalimg = bufimg.getScaledInstance(jbk.getWidth(), jbk.getHeight(), Image.SCALE_SMOOTH);
				}
				catch(Exception ex)
				{
					System.out.println("  line 590   ");
					System.out.print(ex);
				}
				
				jbk.setIcon(new ImageIcon(finalimg));
			}
		}
		if(e.getSource()==jt)
		{
			int rownum = jt.getSelectedRow();
			String item_id = (String) jt.getValueAt(rownum, 1);
			Adder details = DBOperations.getDetails(item_id, "item_details");
			jtf1.setText(details.getItemId());
			jtf1.setEditable(false);
			jtf2.setSelectedItem(details.getItemCategory());
			jtf3.setText(details.getItemName());
			jtf4.setText(details.getItemQuantity());
			jtf5.setText(details.getItemPrice());
			jtf6.setText(details.getItemDescription());
			
			
			
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

