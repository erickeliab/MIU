package Threads6;

import java.util.List;

public class ComputePrimes extends Thread {

    private long primeNumberLimit;
    private long minimum;
    private List<Long> primeNumbers;

    ComputePrimes(long minimum, long primeNumberLimit, List<Long> primeNumbers) {
        this.minimum = minimum;
        this.primeNumberLimit = primeNumberLimit;
        this.primeNumbers = primeNumbers;
    }

    @Override
    public void run() {
        for (long i = minimum; i <= primeNumberLimit; i++) {
            if (isPrime(i)) {

                primeNumbers.add(i);
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


        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }


        for (int i = 5; i* i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }
}
