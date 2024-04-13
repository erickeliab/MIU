import java.time.LocalDate;

public class Salaried extends Employee{

    private double salary;

    Salaried(int empId, double salary){
        super(empId);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    @Override
    public double calcGrossPay(LocalDate dateRange) {
        return salary;
    }
}
