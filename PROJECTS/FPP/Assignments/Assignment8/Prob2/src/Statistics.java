import java.util.*;
public class Statistics {
	public static double computeSumOfSalaries(List<EmployeeData> aList) {
	double sum = 0.0;
	for (EmployeeData employee : aList) {
		sum += employee.getSalary();
	}
	return sum;
	}
}
