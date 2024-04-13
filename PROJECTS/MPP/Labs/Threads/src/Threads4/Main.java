package Threads4;

public class Main {
    public static void main(String[] args) {


        System.out.println("Inside main  ");

        int numberOfThreds = 5;

        long limit = 1000000/numberOfThreds;

        for (int i = 1; i <= numberOfThreds; i++){
            ComputePrimes p = new ComputePrimes(((i-1)*limit)+1,i*limit);
            p.start();
        }

    }


}