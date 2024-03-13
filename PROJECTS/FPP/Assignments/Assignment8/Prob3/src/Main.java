import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Marketing> marketingList = new ArrayList<>();

        // Adding objects to the Marketing
        marketingList.add(new Marketing("John", "Product A", 1500));
        marketingList.add(new Marketing("Alice", "Product B", 800));
        marketingList.add(new Marketing("Bob", "Product C", 1200));

        // Removing an object from Marketing
        marketingList.remove(1);

        // Printing the size of the list
        System.out.println("Size of the list: " + marketingList.size());

        // Printing the contents of the list
        System.out.println("Contents of the list:");
        for (Marketing marketing : marketingList) {
            System.out.println(marketing);
        }

        // Sorting the list in natural order for the field salesamount
        marketingList.sort(Comparator.comparingDouble(Marketing::getSalesAmount));

        // Sorting the list in natural order using employeename for sales amount more than $1000
        List<Marketing> filteredList = listMoreThan1000(marketingList);
        filteredList.sort(Comparator.comparing(Marketing::getEmployeeName));

        // Printing the sorted list
        System.out.println("Sorted list by sales amount:");
        for (Marketing marketing : marketingList) {
            System.out.println(marketing);
        }

        // Printing the sorted list by employee name
        System.out.println("Sorted list by employee name:");
        for (Marketing marketing : filteredList) {
            System.out.println(marketing);
        }
    }

    public static List<Marketing> listMoreThan1000(List<Marketing> list) {
        List<Marketing> result = new ArrayList<>();
        for (Marketing marketing : list) {
            if (marketing.getSalesAmount() > 1000) {
                result.add(marketing);
            }
        }
        return result;
    }
}
