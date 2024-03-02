import java.time.LocalDate;

public class Secretary extends DeptEmployee{

    private double overtimeHours;
    Secretary(String name, LocalDate hiredate, double salary, double overtimeHours){

        super(name,hiredate,salary);
        this.overtimeHours = overtimeHours;
    }

    public double getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(double overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    @Override
    public double computeSalary(){

            return super.computeSalary() + (12 * overtimeHours);

    }
}
