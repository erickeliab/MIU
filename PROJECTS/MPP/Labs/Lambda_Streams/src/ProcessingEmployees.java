
// Program 4: ProcessingEmployees.java
// Processing streams of Employee objects.
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

//        1)  Count the number of last names that begin with the letter  ‘B’.  Print out this number.

        long numberOfLastNames = list.stream().filter(e -> e.getLastName().startsWith("B")).count();
        System.out.println("01. The number of last names that begin with \'B\' is:" + numberOfLastNames);

//        2)  Print out all of the Employee objects whose last name begins with the letter  ‘B’  in sorted order.
        System.out.println("02. The names starting with later \'B\' are:" );
        list.stream().filter(em -> em.getLastName().startsWith("B")).forEach(System.out::println);

//        3)  Print out all of the Employee objects whose last name begins with the letter  ‘B’  and change their first name and last name to be All capital letters.
        System.out.println("03. The objects of names starting with later \'B\' capitalized are:" );
        list.stream().filter(e -> e.getLastName().startsWith("B")).
                map(e -> {
                    e.setFirstName(e.getFirstName().toUpperCase());
                    e.setLastName(e.getLastName().toUpperCase());
                    return e;
                }).forEach(System.out::println);

//        4)  Print out All of the employee objects, but if the last name begins with the letter  ‘B’,  then capitalize all the letters in the last name.
        System.out.println("04. Employee objects, but if the last name begins with the letter  ‘B’,  then capitalize:" );
        //        4.1)  Use the  Collectors.joining  method to print out All Employee objects.  (See my  presentation file  ‘Do_Last_This_Was_Lesson 9_Streams_E.docx’.)

        System.out.println("First Approach:");
        String str = list.stream().
                map(e -> {
                    if (e.getLastName().startsWith("B")){
                        e.setLastName(e.getLastName().toUpperCase());
                    }
                    return e.toString();
                }).collect(Collectors.joining());

        System.out.println(str);


        System.out.println("Second Approach:");
        //        4.2)  Use the  Collectors.joining  method to print out All Employee objects, and separate    each one with a delimeter of  “---\n---“.

        String str1 = list.stream().
                map(e -> {
                    if (e.getLastName().startsWith("B")){
                        e.setLastName(e.getLastName().toUpperCase());
                    }
                    return e.toString();
                }).collect(Collectors.joining("---\\n---"));

        System.out.println(str1);


//        Employee objects’ last names, whose last name begins with the letter  ‘I’  in sorted order, and get rid of all the duplicates

        System.out.println("Employee objects’ last names, whose last name begins with the letter  \'I\' without repeatition :");
        list.stream().filter(e -> e.getLastName().startsWith("I")).map(e ->e.getLastName()).distinct().sorted().forEach(System.out::println);

//        6)  Print out the average of all the salaries.
        System.out.println("6)  Print out the average of all the salaries.");

        Double avg = list.stream().mapToDouble(e -> e.getSalary()).average().orElse(0);
        System.out.println("The average Salary is :"+ avg);

//      7)  Use the  ‘reduce’  method to print out the total salary of all employees.
        Double sum = list.stream().mapToDouble(e -> e.getSalary()).reduce(0,(x,y) -> x + y);
        System.out.println("The sum of the salaries is :"+ sum);


//        8)  Print out only the first names of all the employees.  Use the  ‘map’  method to accomplish this.
        System.out.println("8)  Print out only the first names of all the employees.");
        list.stream().map(e -> e.getFirstName()).forEach(System.out::println);

        //        9)  Create an infinite stream of even numbers (0, 2, 4, …) and then, eventually print out only the first 20 even numbers from this stream.
        System.out.println("Series of Even Numbers:");
        Stream.iterate(0, n -> n + 2)
                .limit(20)
                .forEach(System.out::println);


    } // end main

} // end class ProcessingEmployees

