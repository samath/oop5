package servlets;

public class Product {
	
	private final String id;
	private final String name;
	private final String file;
	private final double price;
	
	public Product(String id, String name, String file, double price) {
		this.id = id;
		this.name = name;
		this.file = file;
		this.price = price;
	}
	
	public String getID() { return id; }
	public String getName() { return name; }
	public String getFile() { return file; }
	public double getPrice() { return price; }

}
