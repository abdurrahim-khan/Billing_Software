package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EntryValidator {
		private Pattern name;
		private Pattern email;
		private Pattern password;
		private Pattern age;
		private Pattern mobile;
		private Pattern address;
		
		private Pattern itemid;
		private Pattern itemname;
		private Pattern itemquantity;
		private Pattern itemprice;
		private Pattern itemdesc;
		
		private Matcher matcher;
		
		String name_pattern =  "^[A-Za-z ]{3,30}$";
		String email_pattern = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
		String password_pattern = "^[A-Za-z0-9 ]{4,16}$";
		String age_pattern = "^[0-9]{1,2}$";
		String mobile_pattern = "^[0-9]{10}$";
		String address_pattern = "^[A-Za-z0-9 ]{5,50}$";
		
		String itemid_pattern = "^[0-9]{4}$";
		String itemname_pattern = "^[A-Za-z ]{3,30}$";
		String itemquantity_pattern = "^[0-9]{1,4}$";
		String itemprice_pattern = "^[0-9]{1,10}$";
		String itemdesc_pattern = "^[A-Za-z0-9 ]{5,3000}$";
		
		public EntryValidator()
		{
			name = Pattern.compile(name_pattern);
			email = Pattern.compile(email_pattern);
			password = Pattern.compile(password_pattern);
			age = Pattern.compile(age_pattern);
			mobile = Pattern.compile(mobile_pattern);
			address = Pattern.compile(address_pattern);
			
			itemid = Pattern.compile(itemid_pattern);
			itemname = Pattern.compile(itemname_pattern);
			itemquantity = Pattern.compile(itemquantity_pattern);
			itemprice = Pattern.compile(itemprice_pattern);
			itemdesc = Pattern.compile(itemdesc_pattern);
	
		}
		public boolean nameValidator(String user_name)
		{
			matcher = name.matcher(user_name);
			return matcher.matches();
		}
		public boolean emailValidator(String user_email)
		{
			matcher = email.matcher(user_email);
			return matcher.matches();
		}
		
		public boolean passwordValidator(String user_password)
		{
			matcher = password.matcher(user_password);
			return matcher.matches();
		}
		public boolean ageValidator(String user_age)
		{
			matcher = age.matcher(user_age);
			return matcher.matches();
		}
		public boolean mobileValidator(String user_mobile)
		{
			matcher = mobile.matcher(user_mobile);
			return matcher.matches();
		}
		public boolean addressValidator(String user_address)
		{
			matcher = address.matcher(user_address);
			return matcher.matches();
		}
		//functions for validating item_details database
		public boolean itemidValidator(String item_id)
		{
			matcher = itemid.matcher(item_id);
			return matcher.matches();
		}
		public boolean itemnameValidator(String item_name)
		{
			matcher = itemname.matcher(item_name);
			return matcher.matches();
		}
		public boolean itempriceValidator(String item_price)
		{
			matcher = itemprice.matcher(item_price);
			return matcher.matches();
		}
		public boolean itemquantityValidator(String item_quantity)
		{
			matcher = itemquantity.matcher(item_quantity);
			return matcher.matches();
		}
		public boolean itemdescValidator(String item_desc)
		{
			matcher = itemdesc.matcher(item_desc);
			return matcher.matches();
		}
		
}
