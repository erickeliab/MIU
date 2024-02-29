public class Prog4 {

    public static void main(String[] args) {
        float num1 = 1.27f;
        float num2 = 3.881f;
        float num3 = 9.6f;

        int sum = (int) (num1 + num2 + num3);
        int sum2 =  Math.round(num1) + Math.round(num2) + Math.round(num2);

        System.out.println(sum);
        System.out.println(sum2);

    }
}
