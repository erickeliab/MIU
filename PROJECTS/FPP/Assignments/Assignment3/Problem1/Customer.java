public class Customer {

    private String firstName;
    private String lastName;
    private String socSecurityNum;

    private Address billingAddress;

    private Address shippingAddress;


    Customer(String firstname, String lastname, String socSecurityNum){

        this.firstName = firstname;
        this.lastName = lastname;
        this.socSecurityNum = socSecurityNum;
    }

    public String getFirstname() {
        return firstName;
    }

    public void setFirstname(String firstname) {
        this.firstName = firstname;
    }

    public String getLastname() {
        return lastName;
    }

    public void setLastname(String lastname) {
        this.lastName = lastname;
    }

    public String getSocSecurityNum() {
        return socSecurityNum;
    }

    public void setSocSecurityNum(String socSecurityNum) {
        this.socSecurityNum = socSecurityNum;
    }
    public void setBillingAddress(String street, String city, String state, String zip) {

        this.billingAddress = new Address(street,city,state,zip);

    }
    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setShippingAddress(String street, String city, String state, String zip) {
        this.shippingAddress = new Address(street,city,state,zip);
    }


    public Address getShippingAddress() {
        return shippingAddress;
    }



    public String toString() {
        return "[" + firstName + ", " + lastName + ", " + "ssn: " + socSecurityNum
                + "]";
    }


}
