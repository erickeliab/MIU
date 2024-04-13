import java.util.Scanner;
import java.util.regex.*;

public class Level2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Welcome, please enter L for License Plate validation, R to replace occurrences of 8 with eight, P for phone number validation: ");
        String option = scanner.nextLine();

        switch (option.toUpperCase()) {
            case "L":
                System.out.println("Enter the license plate number: ");
                String licensePlate = scanner.nextLine();
                if (validateLicensePlate(licensePlate)) {
                    System.out.println("Valid License Plate Number");
                } else {
                    System.out.println("Invalid License Plate Number");
                }
                break;
            case "R":
                System.out.println("Enter a string with occurrences of 8: ");
                String strWith8 = scanner.nextLine();
                String replacedStr = replace8WithEight(strWith8);
                System.out.println("String after replacement: " + replacedStr);
                break;
            case "P":
                System.out.println("Enter the phone number: ");
                String phoneNumber = scanner.nextLine();
                if (validatePhoneNumber(phoneNumber)) {
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


    public static boolean validateLicensePlate(String licensePlate) {
        Pattern pattern = Pattern.compile("[A-Z]{2}\\d{4}[A-Z]{3}");
        Matcher matcher = pattern.matcher(licensePlate);
        return matcher.matches();
    }


    public static String replace8WithEight(String input) {
        Pattern pattern = Pattern.compile("8");
        Matcher matcher = pattern.matcher(input);
        return matcher.replaceAll("eight");
    }


    public static boolean validatePhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
