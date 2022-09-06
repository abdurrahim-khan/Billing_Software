package dboperations;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.HashSet;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dbconnection.DBConnection;
import gettersetter.Adder;
import validator.EntryValidator;

public class DBOperations {
	public static Adder login(String email, String password)
	{
		boolean login_status = false;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Adder ad = null;
		try
		{
			con = DBConnection.getConnected();
			ps = con.prepareStatement("select * from user_details where email = ? and password = ?");
			ps.setString(1, email);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			if(rs.next())
			{
				ad = new Adder();
				ad.setName(rs.getString("name"));
				ad.setModule(rs.getString("module"));
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println("login dboper line 51");
			System.out.print(e);
		}
		finally
		{
			try
			{
				rs.close();
				ps.close();
				con.close();
			}
			catch(Exception e)
			{
				System.out.print(e);
			}
		}
		return ad;
	}
	public static JTable userTableCreator(String given_module)
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		JTable jt = null;
		
		try
		{
			con = DBConnection.getConnected();
			ps = con.prepareStatement("select * from user_details where module = ?");
			ps.setString(1, given_module);
			rs = ps.executeQuery();
			
			Object[] column = new Object[] {"S.No.","Name","Email","Mobile","Address"};
			
			DefaultTableModel model = new DefaultTableModel(column,0);
			jt = new JTable(model);
			int i =0;
			while(rs.next())
			{
				i++;
				String name = rs.getString("name");
				String email = rs.getString("email");
				String mobile = rs.getString("mobile");
				String address = rs.getString("address");
				Object[] row = new Object[] {i,name,email,mobile,address};
				model.addRow(row);
			}
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		finally
		{
			try
			{
				rs.close();
				ps.close();
				con.close();
			}
			catch(Exception e)
			{
				System.out.print(e);
			}
		}
		return jt;
	}
	public static boolean addNew(Adder ad, String table_name)
	{
		Connection con = null;
		PreparedStatement ps = null;
		boolean status = false;
		try
		{
			con = DBConnection.getConnected();
			if(table_name.equals("user_details"))
			{
				ps = con.prepareStatement("insert into user_details values(?,?,?,?,?,?,?,?)");
				ps.setString(1, ad.getName());
				ps.setString(2, ad.getEmail());
				ps.setString(3, ad.getPassword());
				ps.setString(4, ad.getAge());
				ps.setString(5, ad.getGender());
				ps.setString(6, ad.getMobile());
				ps.setString(7, ad.getAddress());
				ps.setString(8, ad.getModule());
			}
			else if(table_name.equals("item_details"))
			{
				ps = con.prepareStatement("insert into item_details values(?,?,?,?,?,?,?)");
				ps.setString(1, ad.getItemId());
				ps.setString(2, ad.getItemCategory());
				ps.setString(3, ad.getItemName());
				ps.setString(4, ad.getItemQuantity());
				ps.setString(5, ad.getItemPrice());
				ps.setString(6, ad.getItemDescription());
				FileInputStream fis = ad.getItemImage();
				ps.setBinaryStream(7, fis);
			}
			else if(table_name.equals("cart_details"))
			{
				ps = con.prepareStatement("insert into cart_details values(?,?,?,?,?)");
				ps.setString(1, ad.getItemName());
				ps.setString(2, ad.getItemPrice());
				ps.setString(3, ad.getItemQuantity());
				ps.setString(4, ad.getItemtotal());
				ps.setString(5, ad.getItemId());
			}
			
			
			int i = ps.executeUpdate();
			if(i > 0)
			{
				status = true;
			}
			else
			{
				status = false;
			}
			
		}
		catch(Exception e)
		{
			System.out.print("addnew first catch");
			System.out.print(e);
		}
		finally
		{
			try
			{
				ps.close();
				con.close();
			}
			catch(Exception e)
			{
				System.out.print("addnew second catch");
				System.out.print(e);
			}
		}
		return status;
	}
	
	public static Adder getDetails(String key, String table_name)
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Adder ad = null;
		
		try
		{
			con = DBConnection.getConnected();
			if(table_name.equals("user_details"))
			{
				ps = con.prepareStatement("select * from user_details where email = ?");
				ps.setString(1, key);
				rs = ps.executeQuery();
				
				
				if(rs.next())
				{
					ad = new Adder();
					ad.setName(rs.getString("name"));
					//System.out.println(ad.getName());
					ad.setEmail(rs.getString("email"));
					ad.setPassword(rs.getString("password"));
					ad.setAge(rs.getString("age"));
					ad.setGender(rs.getString("gender"));
					
					ad.setMobile(rs.getString("mobile"));
					ad.setAddress(rs.getString("address"));
					ad.setModule(rs.getString("module"));
				}
			}
			else if(table_name.equals("item_details"))
			{
				ps = con.prepareStatement("select * from item_details where item_id = ?");
				ps.setString(1, key);
                rs = ps.executeQuery();
				
				
				if(rs.next())
				{
					ad = new Adder();
					ad.setItemId(rs.getString("item_id"));
					ad.setItemName(rs.getString("item_name"));
					ad.setItemCategory(rs.getString("item_category"));
					ad.setItemQuantity(rs.getString("item_quantity"));
					ad.setItemPrice(rs.getString("item_price"));
					ad.setItemDescription(rs.getString("item_description"));
					
					/*InputStream is = rs.getBinaryStream("item_image");
					byte[] buffer = new byte[1024];
					File file = new File("image_file.png");
					FileOutputStream output = new FileOutputStream(file);
					while(is.read(buffer) > 0)
					{
						output.write(buffer);
					}*/
					byte[] img = rs.getBytes("item_image");
					ImageIcon imgicn = new ImageIcon(img);
					ad.setItemImageIcon(imgicn);
				} 
			}
			
			
			
			
			
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		finally
		{
			try
			{
				rs.close();
				ps.close();
				con.close();
				
			}
			catch(Exception e)
			{
				System.out.print(e);
			}
		}
		return ad;
	}
	public static boolean delete(String key, String table_name)
	{
		Connection con = null;
		PreparedStatement ps = null;
		boolean status = false;
		try
		{
			con = DBConnection.getConnected();
			if(table_name.equals("user_details"))
			{
				ps = con.prepareStatement("delete from user_details where email = ?");
				ps.setString(1, key);
			}
			else if(table_name.equals("item_details"))
			{
				ps = con.prepareStatement("delete from item_details where item_id = ?");
				ps.setString(1, key);
			}
			else if(table_name.equals("cart_details"))
			{
				ps = con.prepareStatement("delete from cart_details where item_id = ?");
				ps.setString(1, key);
			}
			
			int i = ps.executeUpdate();
			if(i > 0)
			{
				status = true;
			}
			else
			{
				status = false;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			try
			{
				ps.close();
				con.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		return status;
		
	}
	
	public static void initialiseHash(HashSet<String> hs, HashMap<String, Integer> hmitem,  HashMap<String, Integer> hmcart, String table_name)
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		if(table_name.equals("user_details"))
		{
			hs.clear();
		}
		else if(table_name.equals("item_details"))
		{
			hmitem.clear();
		}
		else if(table_name.equals("cart_details"))
		{
			hmcart.clear();
		}
		
		
		
		try
		{
			con = DBConnection.getConnected();
			if(table_name.equals("user_details"))
			{
				ps = con.prepareStatement("select email from user_details");
				rs = ps.executeQuery();
				while(rs.next())
				{
					hs.add(rs.getString("email"));
				}
			}
			else if(table_name.equals("item_details"))
			{
				ps = con.prepareStatement("select item_id, item_quantity from item_details");
				rs = ps.executeQuery();
				while(rs.next())
				{
					hmitem.put(rs.getString("item_id"), Integer.parseInt(rs.getString("item_quantity")));				
				}
			}
			else if(table_name.equals("cart_details"))
			{
				ps = con.prepareStatement("select item_id, quantity from cart_details");
				rs = ps.executeQuery();
				while(rs.next())
				{
					hmcart.put(rs.getString("item_id"), Integer.parseInt(rs.getString("quantity")));				
				}
			}
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		finally
		{
			try
			{
				rs.close();
				ps.close();
				con.close();
			}
			catch(Exception e)
			{
				System.out.print(e);
			}
		}
	}
	public static boolean update(Adder ad, String table_name)
	{
		boolean status = false;
		Connection con = null;
		PreparedStatement ps = null;
		try
		{
			con = DBConnection.getConnected();
			if(table_name.equals("user_details"))
			{
				ps = con.prepareStatement("update user_details set name = ?, age = ?, gender = ?, mobile = ?, address = ? where email = ?");
				ps.setString(1, ad.getName());
				ps.setString(2, ad.getAge());
				ps.setString(3, ad.getGender());
				ps.setString(4, ad.getMobile());
				ps.setString(5, ad.getAddress());
				ps.setString(6, ad.getEmail());
			}
			else if(table_name.equals("item_details"))
			{
				ps = con.prepareStatement("update item_details set item_name=?, item_category=?, item_quantity=?, item_price=?, item_description=?, item_image =? where item_id=?");
				ps.setString(1, ad.getItemName());
				ps.setString(2, ad.getItemCategory());
				ps.setString(3, ad.getItemQuantity());
				ps.setString(4, ad.getItemPrice());
				ps.setString(5, ad.getItemDescription());
				ps.setBinaryStream(6, ad.getItemImage());
				ps.setString(7, ad.getItemId());
			}
			else if(table_name.equals("cart_details"))
			{
				ps = con.prepareStatement("update cart_details set quantity = ?, total = ? where item_id = ?");
				ps.setString(1, ad.getItemQuantity() );
				ps.setString(2, ad.getItemtotal());
				ps.setString(3, ad.getItemId());
			}
			
			int i = ps.executeUpdate();
			if(i > 0)
			{
				status = true;
			}
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		finally
		{
			try
			{
				ps.close();
				con.close();
			}
			catch(Exception e)
			{
				System.out.print(e);
			}
		}
		return status;
	}
	public static int verifyPassword(String email,String old_password, String new_password)
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int i =0;
		try
		{
			con = DBConnection.getConnected();
			ps = con.prepareStatement("select * from user_details where email = ? and password = ?");
			ps.setString(1, email);
			ps.setString(2, old_password);
			rs = ps.executeQuery();
			EntryValidator validator = new EntryValidator();
			if(!rs.next())
			{
				i = 1;
			}
			else if(!validator.passwordValidator(new_password))
			{
				i =2;
			}
			else
			{
				i =0;
				ps = con.prepareStatement("update user_details set password = ? where email = ?");
				ps.setString(1, new_password);
				ps.setString(2, email);
				ps.executeUpdate();
			}
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		finally
		{
			try
			{
				if(rs != null)
				{
					rs.close();
				}
				
				ps.close();
				con.close();
			}
			catch(Exception e)
			{
				System.out.print(e);
			}
		}
		return i;
	}
	public static JTable itemTableCreator(String style)
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		JTable jt = null;
		try
		{
			con = DBConnection.getConnected();
			if(style.equals("whole_table"))
			{
				ps = con.prepareStatement("select * from item_details");
				rs = ps.executeQuery();
				Object[] column = new Object[] {"S.No","Item ID","Item Name", "Item Category"};
				DefaultTableModel model = new DefaultTableModel(column,0);	
				
				jt = new JTable(model);
				int i =0;
				while(rs.next())
				{
					i++;
					String id = rs.getString("item_id");
					String name = rs.getString("item_name");
					String category = rs.getString("item_category");
					
					Object[] row = new Object[] {i,id,name,category};
					model.addRow(row);
				}
			}
			else if(style.equals("out_of_stock"))
			{
				ps = con.prepareStatement("select * from item_details where length(item_quantity) < ?");
				ps.setString(1, "2");
				rs = ps.executeQuery();
				Object[] column = new Object[] {"S.No","Item ID","Item Name", "Item Category","Item Quantity","Item Price"};
				DefaultTableModel model = new DefaultTableModel(column,0);	
				jt = new JTable(model);
				int i =0;
				while(rs.next())
				{
					i++;
					String id = rs.getString("item_id");
					String name = rs.getString("item_name");
					String category = rs.getString("item_category");
					String quantity = rs.getString("item_quantity");
					String price = rs.getString("item_price");
					Object[] row = new Object[] {i,id,name,category,quantity,price};
					model.addRow(row);
				}
			}
		
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		finally
		{
			try
			{
				rs.close();
				ps.close();
				con.close();
			}
			catch(Exception e)
			{
				System.out.print(e);
			}
		}
		return jt;
	}
	public static boolean alterExisting(String itemid, String itemquantity, String table_name)
	{
		Connection con = null;
		PreparedStatement ps = null;
		boolean status = false;
		try
		{
			con = DBConnection.getConnected();
			if(table_name.equals("item_details"))
			{
				ps = con.prepareStatement("update item_details set item_quantity= ? where item_id= ? ");
				ps.setString(1, itemquantity);
				ps.setString(2, itemid);
			}
			else if(table_name.equals("cart_details"))
			{
				ps = con.prepareStatement("update cart_details set quantity = ? where item_id=?");
				ps.setString(1, itemquantity);
				ps.setString(2, itemid);
			}
			int i = ps.executeUpdate();
			if(i > 0)
			{
				status = true;
			}
			else 
			{
				status = false;
			}
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		finally
		{
			try
			{
				ps.close();
				con.close();
			}
			catch(Exception e)
			{
				System.out.print(e);
			}
		}
		System.out.print(status+"from dbo");
		return status;
		
	}
	public static JTable cartTableCreator()
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		JTable jt = null;
		try
		{
			con = DBConnection.getConnected();
			
				ps = con.prepareStatement("select * from cart_details");
				rs = ps.executeQuery();
				Object[] column = new Object[] {"S.No","Item ID","Item Name", "Item Price", "Item Quantity", "total"};
				DefaultTableModel model = new DefaultTableModel(column,0);	
				
				jt = new JTable(model);
				int i =0;
				while(rs.next())
				{
					i++;
					String itemid = rs.getString("item_id");
					String name = rs.getString("name");
					String price = rs.getString("price");
					String quantity = rs.getString("quantity");
					String total = Integer.parseInt(quantity) * Integer.parseInt(price) + "";
					
					Object[] row = new Object[] {i,itemid,name,price,quantity,total};
					model.addRow(row);
				}
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		finally
		{
			try
			{
				rs.close();
				ps.close();
				con.close();
			}
			catch(Exception e)
			{
				System.out.print(e);
			}
		}
		return jt;
	}
	public static String getGrandTotal()
	{
		int grandtotal =0;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try
		{
			con = DBConnection.getConnected();
			ps = con.prepareStatement("select total from cart_details");
			rs = ps.executeQuery();
			while(rs.next())
			{
				String str = rs.getString("total");
				grandtotal += Integer.parseInt(str);
			}
		}
		catch(Exception e)
		{
			System.out.println("first catch getgrandtotal dboperations  "+e);
		}
		finally
		{
			try
			{
				rs.close();
				ps.close();
				con.close();
			}
			catch(Exception e)
			{
				System.out.println("second catch getgrandtotal dboperations  "+e);
			}
		}
		return grandtotal+"";
		
	}
	public static void emptyCart(String style)
	{
		Connection con = null;
		PreparedStatement ps_cart = null;
		PreparedStatement ps_cartdelete = null;
		PreparedStatement ps_itemget = null;
		PreparedStatement ps_itemset = null;
		ResultSet rs_cart = null;
		ResultSet rs_item = null;
		try
		{
			con = DBConnection.getConnected();
			if(style.equals("changes_to_be_reflected"))
			{
				ps_cart = con.prepareStatement("select item_id, quantity from cart_details");
				rs_cart = ps_cart.executeQuery();
				while(rs_cart.next())
				{
					String item_id = rs_cart.getString("item_id");
					String item_quantity = rs_cart.getString("quantity");
					ps_itemget = con.prepareStatement("select item_quantity from item_details where item_id = ?");
					ps_itemget.setString(1, item_id);
					rs_item = ps_itemget.executeQuery();
					String existingquantity = "";
					if(rs_item.next())
					{
						existingquantity = rs_item.getString("item_quantity");
					}
					int newquantity = Integer.parseInt(existingquantity) - Integer.parseInt(item_quantity);
					ps_itemset = con.prepareStatement("update item_details set item_quantity = ? where item_id = ?");
					ps_itemset.setString(1, newquantity+"");
					ps_itemset.setString(2, item_id);
					ps_itemset.executeUpdate();
				}
			}
			ps_cartdelete = con.prepareStatement("delete from cart_details");
			ps_cartdelete.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		finally
		{
			try
			{
				if(style.equals("changes_to_be_reflected"))
				{
					rs_item.close();
					rs_cart.close();
					ps_cartdelete.close();
					ps_itemget.close();
					ps_itemset.close();
					ps_cart.close();
					con.close();
				}
				else
				{
					ps_cartdelete.close();
					con.close();
				}
				
				
			}
			catch(Exception e)
			{
				System.out.print(e);
			}
		}
	}
	
}
