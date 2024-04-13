import java.util.List;

public class Admin {

    public static double computeUpdatedBalanceSum(List<Employee> employees){
        double total = 0;

        for (Employee employee: employees){
            total += employee.computeUpdatedBalanceSum();
        }

        return total;
    }

}
