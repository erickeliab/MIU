import java.util.ArrayList;

public class CheckoutRecord {

    private ArrayList<CheckoutRecordEntry> checkoutRecordList;


    CheckoutRecord(){
        this.checkoutRecordList = new ArrayList<>();
    }

    public ArrayList<CheckoutRecordEntry> getCheckoutRecordList() {
        return checkoutRecordList;
    }

    public void setCheckoutRecordList(ArrayList<CheckoutRecordEntry> checkoutRecordList) {
        this.checkoutRecordList = checkoutRecordList;
    }

    public void addCheckoutEntry(CheckoutRecordEntry checkoutRecordEntry){
        checkoutRecordList.add(checkoutRecordEntry);
    }
}
