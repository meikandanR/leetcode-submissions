import java.util.*;

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int m = costs.length, n = m / 2;
        int INF = Integer.MAX_VALUE / 2;
        int[][] dp = new int[m + 1][n + 1];
        for (int[] row : dp) Arrays.fill(row, INF);
        dp[0][0] = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= Math.min(i, n); j++) {
                // person i goes to B (at most n people can go to B)
                if (i - j <= n && dp[i - 1][j] != INF) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + costs[i - 1][1]);
                }
                // person i goes to A
                if (j > 0 && dp[i - 1][j - 1] != INF) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + costs[i - 1][0]);
                }
            }
        }
        return dp[m][n];
    }
}