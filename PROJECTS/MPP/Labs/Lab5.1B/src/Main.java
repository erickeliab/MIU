import java.time.LocalDate;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();

        Employee e1 = new Hourly(1,2000,8);
        employees.add(e1);
        Employee e2 = new Hourly(2,2000,8);
        employees.add(e2);
        Employee e3 = new Hourly(3,2000,8);
        employees.add(e3);


        Employee e4 = new Salaried(4,100000);
        Employee e5 = new Salaried(5,100000);
        Employee e6 = new Salaried(6,100000);
        employees.add(e4);
        employees.add(e5);
        employees.add(e6);

        Employee e7 = new Commissioned(7,20,2000);
        Employee e8 = new Commissioned(8,20,5000);
        Employee e9 = new Commissioned(9,20,2000);

        employees.add(e7);
        employees.add(e8);
        employees.add(e9);

        Order o1 = new Order(1,2000,LocalDate.of(2024,03,07),(Commissioned) e7);
        Order o2 = new Order(2,3000,LocalDate.of(2024,02,07),(Commissioned) e8);
        Order o3 = new Order(3,4000,LocalDate.of(2024,03,07),(Commissioned) e9);

        Order o4 = new Order(4,7000,LocalDate.of(2024,03,07),(Commissioned) e9);
        Order o5 = new Order(5,6000,LocalDate.of(2024,02,07),(Commissioned) e7);
        Order o6 = new Order(6,5000,LocalDate.of(2024,03,07),(Commissioned) e8);

        for (Employee employee:employees){

            employee.calcCompansation(03,2024);
            employee.print();

        }

    }
}