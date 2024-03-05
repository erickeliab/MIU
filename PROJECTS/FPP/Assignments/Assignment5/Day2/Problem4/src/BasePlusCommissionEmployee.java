public class BasePlusCommissionEmployee extends CommissionEmployee {

    private double baseSalary;

    BasePlusCommissionEmployee(String firstname, String lastname, String socialSecurityNumber, double baseSalary, double grossSales, double commissionRate){

        super(firstname, lastname ,socialSecurityNumber, grossSales, commissionRate);

        this.baseSalary = baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }


    @Override
    public double getPayment() {
        return super.getPayment();
    }

    public String toString() {
        return super.toString() + "\b , Base Salary : " + baseSalary + "]";
    }
}
