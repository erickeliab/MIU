import java.time.LocalDate;
import java.util.ArrayList;

public class Commissioned extends Employee{

    private double commission;
    private double baseSalary;

    private ArrayList<Order> orders;

    Commissioned(int empId, double commission, double baseSalary){
        super(empId);

        this.commission = commission;
        this.baseSalary = baseSalary;
        this.orders = new ArrayList<>();
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void addOrders(Order order) {

        this.orders.add(order);

    }

    public void setBaseSalary(double baseSalary) {

        this.baseSalary = baseSalary;

    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }


    @Override
    public double calcGrossPay(LocalDate dateRange) {
        double total_order_amount = 0;
        double commission_amount = 0;

        for (Order order: orders){

            if (order.getOrderDate().getMonth().compareTo(dateRange.getMonth()) == 0){
                total_order_amount += order.getOrderAmount();
            }

        }

        commission_amount = total_order_amount * (commission * 0.01);

        return baseSalary + commission_amount;

    }
}
