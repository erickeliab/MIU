import java.util.Objects;

public class Staff extends Person{

    private double Salary;

    Staff(String Name, String Phone, int Age, double Salary){
        super(Name,Phone,Age);
        this.Salary = Salary;
    }

    public double getTotalSalary() {
        return Salary;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Staff staff)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(getTotalSalary(), staff.getTotalSalary()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getTotalSalary());
    }
}
