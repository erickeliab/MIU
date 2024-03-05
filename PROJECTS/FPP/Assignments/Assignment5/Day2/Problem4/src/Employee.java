public abstract class Employee {

    private String firstName;
    private String lastName;
    private String socialSecurityNumber;

    abstract double getPayment();

    Employee(String firstName, String lastname, String socialSecurityNumber){
        this.firstName = firstName;
        this.lastName = lastname;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public String toString(){

        return "[Firstname : "+firstName+" ,Lastname : " + lastName + ", Social Security Number:  " + socialSecurityNumber + "]";
    }
}
