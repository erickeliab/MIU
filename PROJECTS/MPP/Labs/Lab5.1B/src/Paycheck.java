import java.time.LocalDate;

public final class Paycheck {

private double grossPay;

private double fica;
private double state;
private double local;

private double medicare;

private double socialSecurity;

private LocalDate DateRange;

private String payPeriod;

private Employee employee;

 Paycheck(double grossPay, double fica, double state, double local, double medicare, double socialSecurity, LocalDate dateRange, Employee employee){

    this.grossPay = grossPay;
    this.DateRange = dateRange;
    this.fica = fica;
    this.local = local;
    this.medicare = medicare;
    this.state = state;
    this.socialSecurity = socialSecurity;
    this.payPeriod = DateRange.toString();
    this.employee = employee;

}

public void print(){

    System.out.printf("Paycheck for date %s, NetPay is $%,.2f", this.payPeriod, this.getNetPay());
    System.out.println();

}

public double getNetPay(){
     double contributions = fica + state + local + medicare + socialSecurity;
    return grossPay - contributions;
}

    public double getFica() {
        return fica;
    }

    public Employee getEmployee() {
        return employee;
    }

    public double getGrossPay() {
        return grossPay;
    }

    public double getLocal() {
        return local;
    }

    public LocalDate getDateRange() {
        return DateRange;
    }

    public double getState() {
        return state;
    }

    public double getMedicare() {
        return medicare;
    }

    public double getSocialSecurity() {
        return socialSecurity;
    }

    public String getPayPeriod() {
        return payPeriod;
    }


}
