public class BruteForceLCS {
    private static int recursiveCalls = 0;

    public static int lcs(String X, String Y, int m, int r) {
        recursiveCalls++;
        if (m == 0 || r == 0) return 0;
        if (X.charAt(m - 1) == Y.charAt(r - 1)) return 1 + lcs(X, Y, m - 1, r - 1);
        else return Math.max(lcs(X, Y, m - 1, r), lcs(X, Y, m, r - 1));
    }

    public static void main(String[] args) {
        String X = "ABCBDAB";
        String Y = "BDCAB";
        recursiveCalls = 0;
        int result = lcs(X, Y, X.length(), Y.length());
        System.out.println("LCS length = " + result);
        System.out.println("Number of recursive calls: " + recursiveCalls);
    }
}
