
// Program 4: ProcessingEmployees.java
// Processing streams of Employee objects.
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProcessingEmployees
{
    public static void main(String[] args)
    {
        // initialize array of Employees
        Employee[] employees = {
                new Employee("Jason", "Red", 5000, "IT"),
                new Employee("Ashley", "Green", 7600, "IT"),
                new Employee("Matthew", "Indigo", 3587.5, "Sales"),
                new Employee("James", "Indigo", 4700.77, "Marketing"),
                new Employee("Luke", "Indigo", 6200, "IT"),
                new Employee("Jason", "Blue", 3200, "Sales"),
                new Employee("Wendy", "Brown", 4236.4, "Marketing")};

        // get List view of the Employees
        List<Employee> list = Arrays.asList(employees);

        // display all Employees
        System.out.println("Complete Employee list:");
        list.stream().forEach(System.out::println);
        //A method reference.

        // To test Collectors.joining
        // Convert elements to strings and concatenate them, separated by commas
        String joined = list.stream()
                .map(Object::toString)  //  this DOES go to the overridden method  toString  inside Employee!!  Yes!!

                //  joining method needs Strings coming in.

                //.map(Employee::toString)  //  this also DOES work!!  Yes!!
                .collect(Collectors.joining(", "));

        System.out.println("\n\n" + joined);
//        a)  Print out each department and the average salary for the department.

        Map<String, Double> averageSalaryByDepartment = list.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));

        System.out.println("\nAverage Salary by Department:");
        averageSalaryByDepartment.forEach((department, averageSalary) ->
                System.out.println(department + ": " + averageSalary));

//        b)  Print out each department and the maximum salary for the department.

        Map<String, Double> maxSalaryByDepartment = list.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
                                opt -> opt.map(Employee::getSalary).orElse(0.0))));

        System.out.println("\nMaximum Salary by Department:");
        maxSalaryByDepartment.forEach((department, maxSalary) ->
                System.out.println(department + ": " + maxSalary));


//        c)  Print out each department and all of the employees who work at that department.

        Map<String, List<Employee>> employeesByDepartment = list.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        System.out.println("\nEmployees by Department:");
        employeesByDepartment.forEach((department, emp) -> {
            System.out.println(department + ":");
            emp.forEach(System.out::println);
        });

    } // end main
} // end class ProcessingEmployees

