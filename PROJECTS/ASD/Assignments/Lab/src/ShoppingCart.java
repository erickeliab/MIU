import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private String cartId;
    private List<CartItem> items;

    // Constructor, getters, and setters

    public ShoppingCart(String cartId) {
        this.cartId = cartId;
        this.items = new ArrayList<>();
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public void addBook(Book book, int quantity) {
        for (CartItem item : items) {
            if (item.getBook().getBookId().equals(book.getBookId())) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        items.add(new CartItem(cartId + "-" + book.getBookId(), book, quantity));
    }

    public void removeBook(String bookId) {
        items.removeIf(item -> item.getBook().getBookId().equals(bookId));
    }

    public void updateQuantity(String bookId, int quantity) {
        for (CartItem item : items) {
            if (item.getBook().getBookId().equals(bookId)) {
                item.setQuantity(quantity);
                return;
            }
        }
    }
}
