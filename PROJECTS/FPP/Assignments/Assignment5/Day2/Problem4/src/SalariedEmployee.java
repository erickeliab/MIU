public class SalariedEmployee extends Employee{

    private double weeklySalary;

    SalariedEmployee(String firstname, String lastname,String socialSecurityNumber, double weeklySalary){

        super(firstname,lastname,socialSecurityNumber);

        this.weeklySalary = weeklySalary;

    }

    public double getWeeklySalary() {
        return weeklySalary;
    }

    public void setWeeklySalary(double weeklySalary) {
        this.weeklySalary = weeklySalary;
    }

    public double getPayment(){

        return weeklySalary;

    }

    public String toString() {
        return super.toString() + "\b , Weekly Salary : " + weeklySalary + "]";
    }
}
