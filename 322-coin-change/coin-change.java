class Solution {
    public int coinChange(int[] coins, int amount) {

        int n = coins.length;

        int[][] dp = new int[n][amount+1];
        for(int []row : dp){
            Arrays.fill(row,-1);
        }
        int ans = solve(n - 1, coins, amount,dp);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int solve(int i, int[] coins, int amount,int[][] dp) {

        if (amount == 0) {
            return 0;
        }

        if (i == 0) {
            return amount % coins[i] == 0
                    ? amount / coins[i]
                    : Integer.MAX_VALUE;
        }

        if(dp[i][amount]!=-1) return dp[i][amount];

        int notTake = solve(i - 1, coins, amount,dp);

        int take = Integer.MAX_VALUE;

        if (coins[i] <= amount) {
            int result = solve(i, coins, amount - coins[i],dp);

            if (result != Integer.MAX_VALUE) {
                take = 1 + result;
            }
        }

        return dp[i][amount] = Math.min(notTake, take);
    }
}