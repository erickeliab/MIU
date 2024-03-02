import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Professor prof1 = new Professor("Erick", LocalDate.parse("2022-02-09"),400000,3);
        Professor prof2 = new Professor("Jane", LocalDate.parse("2001-11-03"),450000,5);
        Professor prof3 = new Professor("Peter", LocalDate.parse("2019-02-12"),510000,10);
        Secretary sec1 = new Secretary("Irene",LocalDate.parse("1999-04-23"),30000,12);
        Secretary sec2 = new Secretary("Irene",LocalDate.parse("2007-04-23"),26000,8);



    DeptEmployee[] employees = new DeptEmployee[5];
    employees[0] = prof1;
    employees[1] = prof2;
    employees[2] = prof3;
    employees[3] = sec1;
    employees[4] = sec2;

        Scanner sc = new Scanner(System.in);
        System.out.println("Do you wish to see sum of all Professors and Secretaries salaries ? : ");
        if (sc.nextLine().equals("Y")){
            double sum = 0;
            for (DeptEmployee employee : employees){
                sum+= employee.computeSalary();
            }

            System.out.println("The sum of salaries is : " + sum);
        }else System.out.println("You provided an invalid response, thanks");
    }
}