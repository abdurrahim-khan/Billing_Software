package hashing;

import java.util.HashMap;
import java.util.HashSet;

import dboperations.DBOperations;

public class Hashing 
{
	public static HashSet<String> hs_user =  new HashSet<>();
	public static HashMap<String,Integer> hm_item = new HashMap<String, Integer>();
	public static HashMap<String,Integer> hm_cart = new HashMap<String, Integer>();
	public Hashing(String table_name)
	{
			DBOperations.initialiseHash(hs_user,hm_item,hm_cart,table_name);
	}
	public static boolean isUserPresent(String email)
	{
		return hs_user.contains(email);
	}
	public static void addUser(String email)
	{
		hs_user.add(email);
	}
	
	public static boolean isItemPresent(String item_id)
	{
		return hm_item.containsKey(item_id);
	}
	public static void addItem(String item_id, String item_quantity)
	{
		hm_item.put(item_id, Integer.parseInt(item_quantity));
	}
	public static int getItemQuantity(String item_id)
	{
		return hm_item.get(item_id);
	}
	
	public static boolean isCartItemPresent(String item_id)
	{
		return hm_cart.containsKey(item_id);
	}
	public static void addCartItem(String item_id, String item_quantity)
	{
		hm_cart.put(item_id, Integer.parseInt(item_quantity));
	}
	public static int getCartItemQuantity(String item_id)
	{
		return hm_cart.get(item_id);
	}
	
}
