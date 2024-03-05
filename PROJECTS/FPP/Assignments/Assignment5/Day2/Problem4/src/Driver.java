public class Driver {


    private static double calculateTotal(Employee[] employees){
        double sum = 0.0;
        for (Employee employee : employees){
            sum += employee.getPayment();
            System.out.println(employee.toString());
        }

        return sum;
    }

    public static void main(String[] args) {

        Employee[] employees = {
                new CommissionEmployee("Erick","Emmanuel","123",4600,20),
                new BasePlusCommissionEmployee("Michael","Jackson","345",4000,500,30),
                new HourlyEmployee("Billy","Jean","889",300,7),
                new SalariedEmployee("Abigail", "Chams","443",450),
                new HourlyEmployee("Joseph","Sikora","160",460,5)
        };

        System.out.println("The total salaries for all employees is : " + calculateTotal(employees));
    }
}
