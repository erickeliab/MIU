import java.util.HashMap;
import java.util.Map;

public class MemoizedFibonacci {
    private static int recursiveCalls = 0;
    private static Map<Integer, Integer> memo = new HashMap<>();

    public static int fib(int n) {
        recursiveCalls++;
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (memo.containsKey(n)) return memo.get(n);
        int result = fib(n - 1) + fib(n - 2);
        memo.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        int n = 30;
        recursiveCalls = 0;
        memo.clear();
        int result = fib(n);
        System.out.println("Fib(" + n + ") = " + result);
        System.out.println("Number of recursive calls: " + recursiveCalls);
    }
}
