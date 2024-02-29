import java.util.Arrays;
public class Prog6 {

    static int min (int[] arrayOfInts ) {

        int smallest = 0;
        for (int a : arrayOfInts){
            if (a < smallest) smallest = a;
        }
        return smallest;
    }
    public static void main(String[] args) {

        int[] sample = {2, -21, 3, 45, 0, 12, 18, 6, 3, 1, 0, -22};

        System.out.println(min(sample));
    }
}
