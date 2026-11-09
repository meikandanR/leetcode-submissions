class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp [][] = new int[n][2];
        
        for(int[]  row : dp) Arrays.fill(row,-1);
        return solve(0,1,prices,n,dp);
        
    }

    private int solve(int i , int buy,int[] prices, int n,int[][]dp){
        if(i >= n ) return 0 ;
        if(dp[i][buy] != -1) return dp[i][buy];
        int profit = 0;

        if(buy==1){
            int buyy = -prices[i] + solve(i+1,0,prices,n,dp);
            int notBuy = 0 + solve(i+1,1,prices,n,dp);
            profit = Math.max(buyy,notBuy);
        }else{
            int sell = prices[i] + solve(i+2,1,prices,n,dp);
            int notSell = 0 + solve(i+1,0,prices,n,dp);
            profit = Math.max(sell,notSell);
        }
        return dp[i][buy] = profit;
    }
}
