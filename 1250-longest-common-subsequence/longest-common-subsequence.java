
import java.util.*;

class Solution {

    public int longestCommonSubsequence(String text1, String text2) {

        int n = text1.length();
        int m = text2.length();

        // 1. Recursion
        // return recursion(n, m, text1, text2);

        // 2. Memoization
        // int[][] dp = new int[n + 1][m + 1];
        // for (int[] row : dp) {
        //     Arrays.fill(row, -1);
        // }
        // return memoization(n, m, text1, text2, dp);

        // 3. Tabulation
        // return tabulation(text1, text2);

        // 4. Space Optimization
        return spaceOptimization(text1, text2);
    }


    // 1. Recursion
    public int recursion(int i, int j, String s1, String s2) {

        if (i == 0 || j == 0) {
            return 0;
        }

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            return 1 + recursion(i - 1, j - 1, s1, s2);
        }

        return Math.max(
            recursion(i - 1, j, s1, s2),
            recursion(i, j - 1, s1, s2)
        );
    }


    // 2. Memoization
    public int memoization(int i, int j, String s1,
                           String s2, int[][] dp) {

        if (i == 0 || j == 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            return dp[i][j] = 1 +
                memoization(i - 1, j - 1, s1, s2, dp);
        }

        return dp[i][j] = Math.max(
            memoization(i - 1, j, s1, s2, dp),
            memoization(i, j - 1, s1, s2, dp)
        );
    }


    // 3. Tabulation
    public int tabulation(String text1, String text2) {

        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n + 1][m + 1];

        // Base cases: first row and first column are already 0

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {

                    dp[i][j] = 1 + dp[i - 1][j - 1];

                } else {

                    dp[i][j] = Math.max(
                        dp[i - 1][j],
                        dp[i][j - 1]
                    );
                }
            }
        }

        return dp[n][m];
    }


    // 4. Space Optimization
    public int spaceOptimization(String text1, String text2) {

        int n = text1.length();
        int m = text2.length();

        int[] prev = new int[m + 1];
        int[] cur = new int[m + 1];

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= m; j++) {

                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {

                    cur[j] = 1 + prev[j - 1];

                } else {

                    cur[j] = Math.max(prev[j], cur[j - 1]);
                }
            }

            prev = cur.clone();
        }

        return prev[m];
    }
}
