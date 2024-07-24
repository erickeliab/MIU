import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ShoppingCartDAO shoppingCartDAO = new ShoppingCartDAO();
        ShoppingCartService shoppingCartService = new ShoppingCartService(shoppingCartDAO);

        Scanner scanner = new Scanner(System.in);
        String cartId = "cart1"; // Assume a single cart for simplicity

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add book to shopping cart");
            System.out.println("2. Remove book from shopping cart");
            System.out.println("3. Update quantity of a book in shopping cart");
            System.out.println("4. Retrieve shopping cart");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book ID: ");
                    String bookId = scanner.nextLine();
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book price: ");
                    float price = scanner.nextFloat();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Book book = new Book(bookId, title, author, price, 0);
                    shoppingCartService.addBookToCart(cartId, book, quantity);
                    System.out.println("Book added to cart.");
                    break;
                case 2:
                    System.out.print("Enter book ID to remove: ");
                    bookId = scanner.nextLine();
                    shoppingCartService.removeBookFromCart(cartId, bookId);
                    System.out.println("Book removed from cart.");
                    break;
                case 3:
                    System.out.print("Enter book ID: ");
                    bookId = scanner.nextLine();
                    System.out.print("Enter new quantity: ");
                    quantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    shoppingCartService.updateBookQuantityInCart(cartId, bookId, quantity);
                    System.out.println("Book quantity updated.");
                    break;
                case 4:
                    ShoppingCart cart = shoppingCartService.getShoppingCart(cartId);
                    if (cart != null && !cart.getItems().isEmpty()) {
                        System.out.println("Shopping cart contents:");
                        for (CartItem item : cart.getItems()) {
                            System.out.println("Book: " + item.getBook().getTitle() +
                                    ", Quantity: " + item.getQuantity());
                        }
                    } else {
                        System.out.println("Shopping cart is empty.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
