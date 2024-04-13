package Threads4;

public class ComputePrimes extends Thread {

    private long primeNumberLimit;
    private long minimum;

    ComputePrimes(long minimum,long primeNumberLimit){
        this.minimum = minimum;
        this.primeNumberLimit = primeNumberLimit;

    }

    @Override
    public void run() {

        for (long i = minimum; i <= primeNumberLimit; i++){
            if (isPrime(i)){

                System.out.println(i);

            }

        }

    }

    private static boolean isPrime(long num) {
        if (num <= 1) {
            return false;
        }
        if (num <= 3) {
            return true;
        }

        // Check if num is divisible by 2 or 3
        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }

        // Iterate over potential factors starting from 5 up to the square root of num
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }

}
