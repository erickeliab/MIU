package Threads3;

public class mainThreadClass {

    public static void main( String[] args ) {

        System.out.println("Inside main  ");   
        int i;
        for (i = 1; i <= 10; i++ )
        {
           PrimeThread p = new PrimeThread(i);
           p.start();
        }
        
        

        /*  First running of this program had the following output
        Inside main  
        Inside BEGINNING of 'run', of thread  1
        Inside BEGINNING of 'run', of thread  2
        Inside END of 'run', of thread  2
        Inside BEGINNING of 'run', of thread  3
        Inside BEGINNING of 'run', of thread  5
        Inside BEGINNING of 'run', of thread  7
        Inside BEGINNING of 'run', of thread  9
        Inside END of 'run', of thread  1
        Inside END of 'run', of thread  3
        Inside END of 'run', of thread  5
        Inside BEGINNING of 'run', of thread  4
        Inside BEGINNING of 'run', of thread  6
        Inside BEGINNING of 'run', of thread  8
        Inside BEGINNING of 'run', of thread  10
        Inside END of 'run', of thread  9
        Inside END of 'run', of thread  7
        Inside END of 'run', of thread  4
        Inside END of 'run', of thread  6
        Inside END of 'run', of thread  8
        Inside END of 'run', of thread  10
        */


        /*  Second running of this program had the following output

         Inside main  
Inside BEGINNING of 'run', of thread  1
Inside BEGINNING of 'run', of thread  2
Inside END of 'run', of thread  1
Inside END of 'run', of thread  2
Inside BEGINNING of 'run', of thread  3
Inside BEGINNING of 'run', of thread  8
Inside BEGINNING of 'run', of thread  6
Inside BEGINNING of 'run', of thread  7
Inside BEGINNING of 'run', of thread  9
Inside BEGINNING of 'run', of thread  5
Inside BEGINNING of 'run', of thread  10
Inside BEGINNING of 'run', of thread  4
Inside END of 'run', of thread  3
Inside END of 'run', of thread  8
Inside END of 'run', of thread  6
Inside END of 'run', of thread  7
Inside END of 'run', of thread  9
Inside END of 'run', of thread  5
Inside END of 'run', of thread  10
Inside END of 'run', of thread  4
         
         */



    }
}









