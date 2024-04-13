package Threads1;

public class PrimeThread extends Thread {
    long minPrime;
    PrimeThread(long minPrime) {
        this.minPrime = minPrime;
    }

    public void run() {
 // compute primes larger than minPrime
    	
        System.out.println("Inside run  ");      
    	
         //  . . .
    }
}
