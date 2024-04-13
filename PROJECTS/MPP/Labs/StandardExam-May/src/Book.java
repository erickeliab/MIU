import java.util.Objects;

public class Book extends LendingItem{

    private String isbn;
    private String title;

    private String outhorFirstname;
    private String outhorLastname;

    Book(String isbn, String title, String outhorFirstname, String outhorLastname, int copies){
        super(copies);
        this.isbn = isbn;
        this.title = title;
        this.outhorFirstname = outhorFirstname;
        this.outhorLastname = outhorLastname;

    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOuthorFirstname() {
        return outhorFirstname;
    }

    public void setOuthorFirstname(String outhorFirstname) {
        this.outhorFirstname = outhorFirstname;
    }

    public String getOuthorLastname() {
        return outhorLastname;
    }

    public void setOuthorLastname(String outhorLastname) {
        this.outhorLastname = outhorLastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return Objects.equals(getIsbn(), book.getIsbn()) && Objects.equals(getTitle(), book.getTitle()) && Objects.equals(getOuthorFirstname(), book.getOuthorFirstname()) && Objects.equals(getOuthorLastname(), book.getOuthorLastname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIsbn(), getTitle(), getOuthorFirstname(), getOuthorLastname());
    }
}
