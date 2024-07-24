public class ShoppingCartService {
    private ShoppingCartDAO shoppingCartDAO;

    public ShoppingCartService(ShoppingCartDAO shoppingCartDAO) {
        this.shoppingCartDAO = shoppingCartDAO;
    }

    public void addBookToCart(String cartId, Book book, int quantity) {
        ShoppingCart cart = shoppingCartDAO.findCartById(cartId);
        if (cart == null) {
            cart = new ShoppingCart(cartId);
        }
        cart.addBook(book, quantity);
        shoppingCartDAO.saveCart(cart);
    }

    public void removeBookFromCart(String cartId, String bookId) {
        ShoppingCart cart = shoppingCartDAO.findCartById(cartId);
        if (cart != null) {
            cart.removeBook(bookId);
            shoppingCartDAO.saveCart(cart);
        }
    }

    public void updateBookQuantityInCart(String cartId, String bookId, int quantity) {
        ShoppingCart cart = shoppingCartDAO.findCartById(cartId);
        if (cart != null) {
            cart.updateQuantity(bookId, quantity);
            shoppingCartDAO.saveCart(cart);
        }
    }

    public ShoppingCart getShoppingCart(String cartId) {
        return shoppingCartDAO.findCartById(cartId);
    }
}
