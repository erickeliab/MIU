package application;


public class Book {
    private int productNumber;
    private String name;
    private double price;

	public Book(int productNumber, String name, double price) {
		this.productNumber = productNumber;
		this.name = name;
		this.price = price;
	}

	public int getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book{" +
				"productNumber=" + productNumber +
				", name='" + name + '\'' +
				", price=" + price +
				'}';
	}
}
