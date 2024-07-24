public class Book {
    private String bookId;
    private String title;
    private String author;
    private float price;
    private int stockQuantity;

    // Constructor, getters, and setters

    public Book(String bookId, String title, String author, float price, int stockQuantity) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
