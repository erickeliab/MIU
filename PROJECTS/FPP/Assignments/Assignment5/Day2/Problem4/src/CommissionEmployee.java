public class CommissionEmployee extends Employee {

    private double grossSales;
    private double commissionRate;

    CommissionEmployee(String firstname, String lastname,String socialSecurityNumber, double grossSales, double commissionRate){

        super(firstname,lastname,socialSecurityNumber);
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
    }

    public double getGrossSales() {
        return grossSales;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setGrossSales(double grossSales) {
        this.grossSales = grossSales;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public double getPayment(){

        return grossSales * commissionRate;
    }

    @Override
    public String toString() {
        return super.toString() + "\b Gross Sales : " + grossSales + " Commission Rate: " + commissionRate + "]";
    }
}
