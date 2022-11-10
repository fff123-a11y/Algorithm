package Shibing;

public class Code01_KeysKeyboard {

    public static int MaxA(int n) {
        int[] dp = new int[n];
        for (int i = 1; i < 6 && i < n; i++) {
            dp[i] = i + 1;
        }
        for (int i = 6; i < n; i++) {
            dp[i] = Math.max(Math.max(dp[i - 3] * 2, dp[i - 4] * 3), Math.max(dp[i - 5] * 4, dp[i - 6] * 5));
        }
        return dp[n - 1];
    }
}
