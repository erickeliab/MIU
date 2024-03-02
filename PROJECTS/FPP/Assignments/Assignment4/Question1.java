package Assignment4;
//Write a method to display the digits of a given integer value n in reverse order.
public class Question1 {

    private static void displayReverse(int number){

        // base case
        if (number <= 0) {
            return;
        }

        int remaining = number / 10;
        int remainder = number % 10;

        System.out.println(remainder);

        displayReverse(remaining);

    }

    public static void main(String[] args) {
        displayReverse(3450);
    }
}
