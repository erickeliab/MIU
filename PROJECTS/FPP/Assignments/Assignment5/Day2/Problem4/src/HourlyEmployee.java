public class HourlyEmployee extends Employee{


    private double wage;
    private double hours;

    HourlyEmployee(String firstname, String lastname,String socialSecurityNumber, double wage, double hours){

        super(firstname,lastname,socialSecurityNumber);
        this.wage = wage;
        this.hours = hours;

    }

    public double getHours() {
        return hours;
    }

    public double getWage() {
        return wage;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    @Override
    double getPayment() {
        return wage * hours;
    }

    public String toString() {
        return super.toString() + "\b , wage : " + wage + ", hours : " + hours + "]";
    }
}
