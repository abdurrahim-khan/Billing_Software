package admin;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import dboperations.DBOperations;
import gettersetter.Adder;
import implementors.Implementor;

class OutOfStock extends Implementor 
{
	
	JFrame jf_frame;
	JPanel jp_panel;
	JLabel jl_back,jl_print,jl_icon, jl_header;
	JTable jt_itemtable;
	JScrollPane js_scrollpane;
	JTextArea jtxt_textarea;
	
	
	
	public OutOfStock()
	{
		createFrame();
	}
	
	public void createFrame()
	{
		jf_frame = new JFrame();
		jf_frame.setSize(1200,700);
		jf_frame.setUndecorated(true);
		jf_frame.setBounds(80,20,1200,700);
		jf_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jp_panel = new JPanel();
		jp_panel.setLayout(null);
		jp_panel.setBackground(Color.MAGENTA);
		jf_frame.add(jp_panel);
		
		js_scrollpane = new JScrollPane();
		js_scrollpane.setBounds(80,100,600,500);
		jp_panel.add(js_scrollpane);
		
		jt_itemtable = DBOperations.itemTableCreator("out_of_stock");
		jt_itemtable.addMouseListener(this);
		jt_itemtable.setDefaultEditor(Object.class, null);
		js_scrollpane.add(jt_itemtable);
		js_scrollpane.setViewportView(jt_itemtable);
		
		jl_icon = new JLabel("");
		jl_icon.setBounds(800,100,270,270);
		jl_icon.setIcon(new ImageIcon("C:\\Users\\micro\\Desktop\\mydefaultimg.png"));
		jp_panel.add(jl_icon);
		
		jtxt_textarea = new JTextArea("Item Description....");
		jtxt_textarea.setBounds(800,400,290,195);
		jtxt_textarea.setLineWrap(true);
		jtxt_textarea.setWrapStyleWord(true);
		jtxt_textarea.setEditable(false);
		jtxt_textarea.setFont(new Font("Arial",Font.PLAIN,18));
		jp_panel.add(jtxt_textarea);
		
		jl_print = new JLabel("Print");
		jl_print.setBounds(1130,5,45,25);
		jl_print.addMouseListener(this);
		jl_print.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jl_print.setFont(new Font("Arial",Font.BOLD,20));
		jl_print.setForeground(Color.WHITE);;
		jp_panel.add(jl_print);
		
		jl_back = new JLabel("Back");
		jl_back.setBounds(5,5,65,25);
		jl_back.addMouseListener(this);
		jl_back.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jl_back.setFont(new Font("Arial",Font.BOLD,20));
		jl_back.setForeground(Color.WHITE);;
		jp_panel.add(jl_back);
		
		jl_header = new JLabel("Items Out Of Stock");
		jl_header.setFont(new Font("Arial",Font.BOLD,60));
		jl_header.setForeground(Color.WHITE);
		jl_header.setBounds(120,2,800,100);
		jp_panel.add(jl_header);
	}
	public void mouseEntered(MouseEvent e)
	{
		if(e.getSource() == jl_back)
		{
			jl_back.setForeground(Color.red);
		}
		if(e.getSource() == jl_print)
		{
			jl_print.setForeground(Color.red);
		}
	}
	public void mouseExited(MouseEvent e)
	{
		if(e.getSource() == jl_back)
		{
			jl_back.setForeground(Color.WHITE);
		}
		if(e.getSource() == jl_print)
		{
			jl_print.setForeground(Color.WHITE);
		}
	}
	public void mouseClicked(MouseEvent e)
	{
		if(e.getSource()==jl_back)
		{
			AdminPage adm = new AdminPage();
			adm.jf.setVisible(true);
			this.jf_frame.setVisible(false);
		}
		if(e.getSource()==jl_print)
		{
			JOptionPane.showMessageDialog(jp_panel, "This feature is under construction \n You will see it soon","Message",JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getSource()==jt_itemtable)
		{
			int rownum = jt_itemtable.getSelectedRow();
			String item_id = (String) jt_itemtable.getValueAt(rownum, 1);
			Adder details = DBOperations.getDetails(item_id, "item_details");
			jtxt_textarea.setText(details.getItemDescription());
			
			ImageIcon imgicn = details.getItemImageIcon();
			Image img = imgicn.getImage();
			Image scaledimg = img.getScaledInstance(jl_icon.getWidth(), jl_icon.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon finalicon = new ImageIcon(scaledimg);
			jl_icon.setIcon(finalicon);
		}
		
	}
	
}
