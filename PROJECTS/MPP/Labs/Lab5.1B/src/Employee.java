import java.time.LocalDate;
import java.util.ArrayList;


public abstract class Employee {

    private int empId;
    private ArrayList<Paycheck> paychecks;

    Employee(int empId){
        this.empId = empId;
        this.paychecks = new ArrayList<>();
    }

    public void print(){

        System.out.println("Employee with id" + empId);

        for (Paycheck paycheck: paychecks){
            paycheck.print();
        }

    }

    public Paycheck calcCompansation(int month, int year){

        LocalDate dateRange = LocalDate.of(year, month, LocalDate.now().getDayOfMonth());
        double grossPayAmount = this.calcGrossPay(dateRange);
        double fica = grossPayAmount * 0.23;
        double state = grossPayAmount * 0.05;
        double local = grossPayAmount * 0.01;
        double medicare = grossPayAmount * 0.03;
        double social = grossPayAmount * 0.075;

        Paycheck paycheck = new Paycheck(grossPayAmount,fica, state, local, medicare,social, dateRange, this);
        paychecks.add(paycheck);
        return paycheck;
    }



    public abstract double calcGrossPay(LocalDate dateRange);
}
