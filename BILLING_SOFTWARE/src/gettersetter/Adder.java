package gettersetter;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.swing.ImageIcon;

public class Adder 
{
	
	//attributes for user_details table in database
	private String name;
	private String email;
	private String password;
	private String age;
	private String gender;
	private String mobile;
	private String address;
	private String module;
	
	
	//attributes for item_details table in database
	private String item_id;
	private String item_category;
	private String item_name;
	private String item_quantity;
	private String item_price;
	private String item_desc;
	private File item_imagefile;
	private FileInputStream fileinputstream;
	private ImageIcon item_imageicon;
	
	//attributes for cart_details table in database
	private String item_total;
	
	//functions for user_details table in database
	public String getName()
	{
		return name;
	}
	public String getEmail()
	{
		return email;
	}
	public String getPassword()
	{
		return password;
	}
	public String getAge()
	{
		return age;
	}
	public String getGender()
	{
		return gender;
	}
	public String getMobile()
	{
		return mobile;
	}
	public String getAddress()
	{
		return address;
	}
	public String getModule()
	{
		return module;
	}
	
	//functions for item_details table in database
	public String getItemId()
	{
		return item_id;
	}
	public String getItemCategory()
	{
		return item_category;
	}
	public String getItemName()
	{
		return item_name;
	}
	public String getItemQuantity()
	{
		return item_quantity;
	}
	public String getItemPrice()
	{
		return item_price;
	}
	public String getItemDescription()
	{
		return item_desc;
	}
	public String getItemtotal()
	{
		return item_total;
	}
	public File getItemImageFile()
	{
		return item_imagefile;
	}
	public FileInputStream getItemImage()
	{
		return fileinputstream;
	}
	public ImageIcon getItemImageIcon()
	{
		return item_imageicon;
	}
	
	//functions for user_details table in database
	public void setName(String name)
	{
		this.name = name;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public void setAge(String age)
	{
		this.age = age;
	}
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public void setModule(String module)
	{
		this.module = module;
	}
	//functions for item_details table in database
	public void setItemId(String item_id)
	{
		this.item_id = item_id;
	}
	public void setItemCategory(String item_category)
	{
		this.item_category = item_category;
	}
	public void setItemName(String item_name)
	{
		this.item_name = item_name;
	}
	public void setItemQuantity(String item_quantity)
	{
		this.item_quantity = item_quantity;
	}
	public void setItemPrice(String item_price)
	{
		this.item_price = item_price;
	}
	public void setItemDescription(String item_desc)
	{
		this.item_desc = item_desc;
	}
	public void setItemTotal(String item_total)
	{
		this.item_total = item_total;
	}
	public void setItemImage(FileInputStream fileinputstream)
	{
		this.fileinputstream = fileinputstream;
	}
	public void setItemImageFile(File item_imagefile)
	{
		this.item_imagefile = item_imagefile;
	}
	public void setItemImageIcon(ImageIcon item_imageicon)
	{
		this.item_imageicon = item_imageicon;
	}
}
