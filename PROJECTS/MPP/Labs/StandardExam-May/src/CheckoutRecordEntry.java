import java.time.LocalDate;
import java.util.Objects;

public class CheckoutRecordEntry {

    private LocalDate checkoutDate;
    private LocalDate dueDate;

    private LendingItem lendingItem;
    private ItemType itemType;

    CheckoutRecordEntry(LendingItem lendingItem, LocalDate checkoutDate, LocalDate dueDate, ItemType itemType){
        this.lendingItem = lendingItem;
        this.checkoutDate = checkoutDate;
        this.dueDate = dueDate;
        this.itemType = itemType;
    }


    public ItemType getItemType() {
        return itemType;
    }

    public void setCheckoutDate(LocalDate checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LendingItem getLendingItem() {
        return lendingItem;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public void setLendingItem(LendingItem lendingItem) {
        this.lendingItem = lendingItem;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CheckoutRecordEntry that)) return false;
        return Objects.equals(getCheckoutDate(), that.getCheckoutDate()) && Objects.equals(getDueDate(), that.getDueDate()) && Objects.equals(getLendingItem(), that.getLendingItem()) && getItemType() == that.getItemType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCheckoutDate(), getDueDate(), getLendingItem(), getItemType());
    }
}
