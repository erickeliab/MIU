import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Company company = new Company("Company A");

//        Department d1 = new Department("HR","Iowa",company);
//        Department d2 = new Department("Finance","Chicago",company);


        Department d3 = new Department("Sales", "Iowa", company);
        Department d4 = new Department("Marketing", "Chicago", company);
        Department d5 = new Department("Executive", "NewYork", company);

//        Position p1 = new Position("HR Manager","Manages all the human resource staff",d1);
//        Position p2 = new Position("HR Officer","Dealing with human resource files",d1);
//        Position p3 = new Position("HR Intern","Working on low level HR tasks",d1);
//
//        Position p4 = new Position("Finance Manager","Supervise all finance operations",d2);
//        Position p5 = new Position("Finance Officer","Dealing with monthly finance reports",d2);
//        Position p6 = new Position("Finance Intern","Handles daily finance transactions",d2);


        Position s1 = new Position("Head of Sales", "Supervise all finance operations", d3);
        Position s2 = new Position("Sales Officer", "Dealing with monthly finance reports", d3);
        Position s3 = new Position("Sales Intern", "Handles daily finance transactions", d3);

        Position m1 = new Position("Head Of Marketing", "Supervise all finance operations", d4);
        Position m2 = new Position("Marketing Officer", "Dealing with monthly finance reports", d4);
        Position m3 = new Position("Marketing Intern", "Handles daily finance transactions", d4);

        Position m4 = new Position("CEO", "Handles all company operations", d5);
        m4.setManager(true);

        s2.setSuperior(s1);
        s3.setSuperior(s2);
        m2.setSuperior(m1);

        Employee tom = new Employee(123, "tom", "E", "Mgongo", LocalDate.of(1990, 11, 19), "1232", 12000, s3);
        Employee stan = new Employee(643, "stan", "H", "Roberts", LocalDate.of(1999, 7, 26), "1232", 12000, s2);
        Employee sue = new Employee(580, "sue", "R", "Maxwell", LocalDate.of(2003, 9, 12), "1232", 12000, s3);
        Employee marc = new Employee(432, "marc", "C", "Peter", LocalDate.of(1985, 1, 5), "1232", 12000, s3);
        Employee bill = new Employee(974, "bill", "E", "David", LocalDate.of(1997, 12, 8), "1232", 12000, s3);
        Employee peter = new Employee(123, "peter", "E", "Mgongo", LocalDate.of(1990, 11, 19), "1232", 12000, s2);
        Employee dan = new Employee(643, "dan", "H", "Roberts", LocalDate.of(1999, 7, 26), "1232", 12000, s3);
        Employee ron = new Employee(580, "ron", "R", "Maxwell", LocalDate.of(2003, 9, 12), "1232", 12000, s1);
        Employee anne = new Employee(432, "anne", "C", "Peter", LocalDate.of(1985, 1, 5), "1232", 12000, m1);
        Employee gary = new Employee(974, "gary", "E", "David", LocalDate.of(1997, 12, 8), "1232", 12000, m2);
        Employee Lyle = new Employee(974, "Lyle", "E", "David", LocalDate.of(1997, 12, 8), "1232", 300000, m4);



//        Employee erick = new Employee(123,"Erick","E","Mgongo", LocalDate.of(1990,11,19),"1232",12000,p1);
//        Employee john = new Employee(643,"John","H","Roberts", LocalDate.of(1999,7,26),"1232",12000,p2);
//        Employee jane = new Employee(580,"Jane","R","Maxwell", LocalDate.of(2003,9,12),"1232",12000,p3);
//        Employee jackson = new Employee(432,"Jackson","C","Peter", LocalDate.of(1985,1,5),"1232",12000,p4);
//        Employee julieth = new Employee(974,"Julieth","E","David", LocalDate.of(1997,12,8),"1232",12000,p5);


//        company.print();
//
//        System.out.println("The total Salary of Company is " + company.getSalary());

//        Setting up hierarchy


        company.printReportingHierarchy();


}


}