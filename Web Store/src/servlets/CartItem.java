package servlets;

public class CartItem {
	private Product product;
	private int quantity;
	
	public CartItem(Product product) {
		this.product = product;
		this.quantity = 1;
	}
	
	public Product getProduct() { return product; }
	public void setProduct(Product product) { this.product = product; }
	public int getQuantity() { return quantity; }
	public void setQuantity(int quantity) {	this.quantity = quantity; }
	public void incrementQuantity() { this.quantity++; }
	
	public String getID() { return product.getID(); }
	public String getName() { return product.getName(); }	
	public double getPrice() { return product.getPrice(); }

}
