public class LibraryMember {

    private String memberId;
    private String firstName;
    private String lastName;

    private String phone;

    private CheckoutRecord checkoutRecord;

    LibraryMember(String memberId, String firstName, String lastName, String phone){
        this.firstName = firstName;
        this.lastName = lastName;
        this.memberId = memberId;
        this.phone = phone;
        this.checkoutRecord = new CheckoutRecord();
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setCheckoutRecord(CheckoutRecord checkoutRecord) {
        this.checkoutRecord = checkoutRecord;
    }

    public CheckoutRecord getCheckoutRecord() {
        return checkoutRecord;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
}
