package Threads6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Inside main");

        int numberOfThreads = 10;
        long limit = 1000000 / numberOfThreads;

        List<Long> primeNumbers = Collections.synchronizedList(new ArrayList<>());

        for (int i = 1; i <= numberOfThreads; i++) {
            ComputePrimes p = new ComputePrimes((i - 1) * limit + 1, i * limit, primeNumbers);
            p.start();
        }

        // Wait for all threads to finish
        try {
            Thread.sleep(5000); // Adjust the sleep time as needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Sort the list of prime numbers
        Collections.sort(primeNumbers);

        // Print the sorted prime numbers
        System.out.println("Sorted Prime Numbers:");
        for (Long prime : primeNumbers) {
            System.out.println(prime);
        }
    }
}
