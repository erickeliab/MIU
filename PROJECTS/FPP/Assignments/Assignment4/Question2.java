
//. Write a method to count the number of digits in an integer value n. Assume that n is
//nonnegative and represented in base ten

public class Question2 {

    private static int countDigits(int number){

        if (number < 10){
            return 1;
        }

        return 1 + countDigits(number / 10);
    }

    public static void main(String[] args) {

        System.out.println("Number of digits is:" + countDigits(298355));
    }
}
