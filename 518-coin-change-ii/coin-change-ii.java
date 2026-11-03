class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return fun(n-1,coins,amount,dp);
        
    }

    public int fun(int ind,int[]coins,int amount,int[][] dp){

        if(ind == 0 ){
            return (amount % coins[0] == 0)?1 :0;
        }
        if(dp[ind][amount]!=-1) return dp[ind][amount];
        int take = 0;
        if(coins[ind] <= amount){
            take = fun(ind,coins,amount-coins[ind],dp);
        }
        int notTake = fun(ind-1,coins,amount,dp);
        return dp[ind][amount] = take + notTake;
    }
}