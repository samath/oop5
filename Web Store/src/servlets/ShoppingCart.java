package servlets;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
	
	private Map<String, CartItem> cart = new HashMap<String, CartItem>();
	
	public CartItem getCartItem(String id) { return cart.get(id); }
	
	public Collection<String> getAllIDs() { return cart.keySet(); }
	
	public void addProduct(Product p) { 
		if(cart.containsKey(p.getID())) { getCartItem(p.getID()).incrementQuantity(); }
		else { cart.put(p.getID(), new CartItem(p)); }
	}
	
	public void updateQuantity(String id, int newQuantity) {
		if(newQuantity <= 0) cart.remove(id);
		else {
			CartItem item;
			if((item = cart.get(id)) != null) item.setQuantity(newQuantity);
		}
	}
	
	public double totalCost() {
		double cost = 0;
		for(CartItem item : cart.values()) {
			cost += item.getPrice() * item.getQuantity();
		}
		return cost;
	}
	

}
