public class RecursiveFibonacci {
    private static int recursiveCalls = 0;

    public static int fib(int n) {
        recursiveCalls++;
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        int n = 30;
        recursiveCalls = 0;
        int result = fib(n);
        System.out.println("Fib(" + n + ") = " + result);
        System.out.println("Number of recursive calls: " + recursiveCalls);
    }
}
