import java.lang.Math;
public class Prog1 {

    public static void main(String[] args) {

        int x = RandomNumbers.getRandomInt(1,9);
        double result = Math.pow(Math.PI,x);


        int y = RandomNumbers.getRandomInt(3,14);
        double result2 = Math.pow(y,Math.PI);

        System.out.println(result);
        System.out.println(result2);

    }
}
