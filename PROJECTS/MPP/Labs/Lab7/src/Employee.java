import java.time.LocalDate;
import java.util.Objects;

public class Employee {

    private int employeeId;
    private String firstName, middleInitial, lastName, SSN;
    private LocalDate birthDate;
    private double salary;

    private Position position;

    Employee(int employeeId, String firstName, String middleInitial, String lastName, LocalDate birthDate, String SSN, double salary, Position position){
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.SSN = SSN;
        this.salary = salary;
        this.position = position;
        position.setEmployee(this);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void print(){

        System.out.println("        Employee no "+ employeeId + ",names "+ firstName + " " + middleInitial + " " + lastName + " , SSN => "+ SSN + ", paid "+ salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", middleInitial='" + middleInitial + '\'' +
                ", lastName='" + lastName + '\'' +
                ", SSN='" + SSN + '\'' +
                ", birthDate=" + birthDate +
                ", salary=" + salary +
                ", position=" + position +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return getEmployeeId() == employee.getEmployeeId() && Double.compare(getSalary(), employee.getSalary()) == 0 && Objects.equals(getFirstName(), employee.getFirstName()) && Objects.equals(getMiddleInitial(), employee.getMiddleInitial()) && Objects.equals(getLastName(), employee.getLastName()) && Objects.equals(getSSN(), employee.getSSN()) && Objects.equals(getBirthDate(), employee.getBirthDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeId(), getFirstName(), getMiddleInitial(), getLastName(), getSSN(), getBirthDate(), getSalary(), getPosition());
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Employee copy = (Employee) super.clone();
        copy.position = (Position) position.clone();

        return copy;
    }
}
