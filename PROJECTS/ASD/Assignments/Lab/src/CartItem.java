public class CartItem {
    private String cartItemId;
    private Book book;
    private int quantity;

    // Constructor, getters, and setters

    public CartItem(String cartItemId, Book book, int quantity) {
        this.cartItemId = cartItemId;
        this.book = book;
        this.quantity = quantity;
    }

    public String getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(String cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
