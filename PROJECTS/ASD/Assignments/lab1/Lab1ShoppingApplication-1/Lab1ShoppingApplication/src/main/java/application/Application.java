package application;

public class Application {

	public static void main(String[] args) {
		Book book1 = new Book(123,"Book1",25.50);
		Book book2 = new Book(124,"Book2",20.50);
		Book book3 = new Book(125,"Book3",13.75);

		ShoppingService shoppingService = new ShoppingService();
		shoppingService.createCart(1);
		shoppingService.addToCart(1, book1,4);
		shoppingService.addToCart(1, book2,2);
		shoppingService.changeQuantity(1, 124,6);
		shoppingService.addToCart(1, book1,1);

		ShoppingCart cart = shoppingService.getCart(1);
		System.out.println(cart);
	}

}
