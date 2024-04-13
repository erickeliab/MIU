//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Welcome, please enter L for License Plate validation, R to replace occurrences of 8 with eight, P for phone number validation: ");
        String option = scanner.nextLine();

        switch (option.toUpperCase()) {
            case "L":
                System.out.println("Enter the license plate number: ");
                String licensePlate = scanner.nextLine();
                if (licensePlate.matches("[A-Z]{2}\\d{4}[A-Z]{3}")) {
                    System.out.println("Valid License Plate Number");
                } else {
                    System.out.println("Invalid License Plate Number");
                }
                break;
            case "R":
                System.out.println("Enter a string with occurrences of 8: ");
                String strWith8 = scanner.nextLine();
                String replacedStr = strWith8.replaceAll("8", "eight");
                System.out.println("String after replacement: " + replacedStr);
                break;
            case "P":
                System.out.println("Enter the phone number: ");
                String phoneNumber = scanner.nextLine();
                if (phoneNumber.matches("\\d{3}-\\d{3}-\\d{4}")) {
                    System.out.println("Valid Phone Number");
                } else {
                    System.out.println("Invalid Phone Number");
                }
                break;
            default:
                System.out.println("Invalid option!");
        }
        scanner.close();
    }
}
