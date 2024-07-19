public class IterativeFibonacci {
    public static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int prev1 = 1, prev2 = 0;
        for (int i = 2; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }

    public static void main(String[] args) {
        int n = 30;
        int result = fib(n);
        System.out.println("Fib(" + n + ") = " + result);
    }
}
