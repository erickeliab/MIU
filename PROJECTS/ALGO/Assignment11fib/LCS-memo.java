import java.util.HashMap;
import java.util.Map;

public class MemoizedLCS {
    private static int recursiveCalls = 0;
    private static Map<String, Integer> memo = new HashMap<>();

    public static int lcs(String X, String Y, int m, int r) {
        recursiveCalls++;
        if (m == 0 || r == 0) return 0;
        String key = m + "," + r;
        if (memo.containsKey(key)) return memo.get(key);
        int result;
        if (X.charAt(m - 1) == Y.charAt(r - 1)) result = 1 + lcs(X, Y, m - 1, r - 1);
        else result = Math.max(lcs(X, Y, m - 1, r), lcs(X, Y, m, r - 1));
        memo.put(key, result);
        return result;
    }

    public static void main(String[] args) {
        String X = "ABCBDAB";
        String Y = "BDCAB";
        recursiveCalls = 0;
        memo.clear();
        int result = lcs(X, Y, X.length(), Y.length());
        System.out.println("LCS length = " + result);
        System.out.println("Number of recursive calls: " + recursiveCalls);
    }
}
