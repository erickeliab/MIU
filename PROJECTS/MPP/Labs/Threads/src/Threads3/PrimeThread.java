package Threads3;

public class PrimeThread extends Thread {
    long threadNumber;
    PrimeThread(long threadnbr) {
    	 threadNumber = threadnbr;
    }

    public void run() {
 // compute primes larger than minPrime
    	
        System.out.println("Inside BEGINNING of 'run', of thread  " + threadNumber);      
        
        // Now, to take up some CPU time ...
        double temp = 10;
        double temp2;
        for (int i =0; i < 30000; i++)
        {
        	temp = temp + 0.1;
        	temp2 = temp / 4.6;    //  Wasting time.
        	temp = temp - 0.1;
        }
        
        
        System.out.println("Inside END of 'run', of thread  " + threadNumber);      
    	
         //  . . .
    }
}
