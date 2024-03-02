package Assignment4;

// Write a method to compute the sum of all elements of the array arr, of size n.

public class Question3 {

    private static int sumOfElements(int[] arr, int n) {

        if (n <= 0) {
            return 0;
        }

        if (n == 1) {
            return arr[0];
        }
        int sum = arr[n - 1] + sumOfElements(arr, n - 1);
        return sum;

    }

    public static void main(String[] args) {

        int[] array = {1, 2, 4, 5, 6, 7};

        System.out.println("The sum of elements is: " + sumOfElements(array, array.length));
    }
}
