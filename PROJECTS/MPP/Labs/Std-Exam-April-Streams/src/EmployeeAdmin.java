import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeAdmin {

    // returns a list of social security numbers, sorted in ascending order,
    // that belong to an Employee in the input table but that are not on the
    // socSecNums input list
    public static List<String> prepareSsnReport(HashMap<String, Employee> table, List<String> socSecNums) {
        return table.keySet().stream()
                .filter(ssn -> !socSecNums.contains(ssn))
                .sorted()
                .collect(Collectors.toList());
    }

    // return a list of Employees whose social security number is on the input list socSecNums
    // and whose salary is >80000; the return list does not need to be sorted
    public static List<Employee> prepareEmpReport(HashMap<String, Employee> table, List<String> socSecNums) {
        return table.values().stream()
                .filter(emp -> socSecNums.contains(emp.getSsn()) && emp.getSalary() > 80000)
                .collect(Collectors.toList());
    }
}
