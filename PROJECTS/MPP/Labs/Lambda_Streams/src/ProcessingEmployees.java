
// Program 4: ProcessingEmployees.java
// Processing streams of Employee objects.
import java.util.Arrays;
import java.util.List;
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
        list.stream().forEach(System.out::println);   //A method reference.

        // To test Collectors.joining
        // Convert elements to strings and concatenate them, separated by commas
        String joined = list.stream()
                .map(Object::toString)  //  this DOES go to the overridden method  toString  inside Employee!!  Yes!!

                //  joining method needs Strings coming in.

                //.map(Employee::toString)  //  this also DOES work!!  Yes!!
                .collect(Collectors.joining(", "));

        System.out.println("\n\n" + joined);



    } // end main
} // end class ProcessingEmployees

