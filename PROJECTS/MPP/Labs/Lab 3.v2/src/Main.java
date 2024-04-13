import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {




        ArrayList<ICarrier> carriers = new ArrayList<>();
        carriers.add(new UPS());
        carriers.add(new FedEx());
        carriers.add(new USMail());

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of packages: ");
        int numPackages = Integer.parseInt(scanner.nextLine());

        List<Package> packages = new ArrayList<>();
        for (int i = 0; i < numPackages; i++) {
            System.out.println("Enter details for package " + (i + 1) + ":");
            System.out.print("Description: ");
            String description = scanner.nextLine();
            System.out.print("Weight: ");
            double weight = Double.parseDouble(scanner.nextLine());
            System.out.print("Zone: eg IA, MT, OR, CA, TX, UT, FL, MA, OH, NY: ");
            String zone = scanner.nextLine();

            packages.add(new Package(description, weight, zone, carriers));
        }



        System.out.println("Package\tCost\tCarrier");
        for (Package p : packages) {
            double cost = p.calculateCost();
            System.out.println(p.getDescription() + "\t$" + String.format("%.2f", cost) + "\t" + p.getCarrier().getCarrierName());
        }

        scanner.close();
    }
}
