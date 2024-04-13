import java.util.Objects;

public class CD extends LendingItem{

    private String productid;

    private String title;
    private String company;

    CD(String productid, String title, String company, int copies){
        super(copies);
        this.productid = productid;
        this.title = title;
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CD cd)) return false;
        return Objects.equals(getProductid(), cd.getProductid()) && Objects.equals(getTitle(), cd.getTitle()) && Objects.equals(getCompany(), cd.getCompany());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductid(), getTitle(), getCompany());
    }
}
