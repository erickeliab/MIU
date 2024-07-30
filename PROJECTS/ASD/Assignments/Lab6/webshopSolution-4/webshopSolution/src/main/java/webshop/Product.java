package webshop;

public class Product extends CategoryItem {
	private int productNumber;
	private double price;

	public Product(String name, int productNumber, double price) {
		super(name);
		this.productNumber = productNumber;
		this.price = price;
	}

	public int getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	protected void print() {
		System.out
				.println("Product [productNumber=" + productNumber + ", price=" + price + ", name =" + getName() + "]");

	}

	public String getType() {
		return "Product";
	}
}
