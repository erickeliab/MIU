package webshop;

public class Application {

	public static void main(String[] args) {
		ProductCatalog catalog = new ProductCatalog();
		catalog.addCategory("books", null);
		catalog.addCategory("electronics", null);
		catalog.addCategory("laptops", "electronics");
		catalog.addCategory("computers", "books");
		catalog.addCategory("adventure", "books");
		catalog.addCategory("programming", "computers");
		catalog.addCategory("databases", "computers");
		catalog.addProduct(new Product("Java in 24 hours", 231, 25.00), "programming");
		catalog.addProduct(new Product("Pyton programming", 631, 20.55), "programming");
		catalog.addProduct(new Product("Mongo DB", 426, 23.75), "databases");
		catalog.addProduct(new Product("MacBook Pro", 8876, 2500.00), "laptops");
		
		catalog.print();

	}

}
