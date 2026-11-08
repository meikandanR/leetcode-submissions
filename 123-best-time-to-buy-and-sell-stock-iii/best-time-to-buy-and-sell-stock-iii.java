class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        int cap = 2;

        int dp[][][] = new int[n][2][3];
        for(int[][] row: dp){
            for(int [] r: row){
                Arrays.fill(r,-1);
            }
        }

        return solve(0, 1,prices,cap,n,dp);
    }

    private int solve(int i , int buy, int prices[],int cap,int n,int dp[][][] ){

        if( i == n ) return 0;
        if( cap == 0 ) return 0;
        if(dp[i][buy][cap] != -1) return dp[i][buy][cap];
        int profit = 0 ;
        if(buy == 1){
            int buyy = -prices[i] + solve(i+1,0,prices,cap,n,dp);
            int notbuy = 0 + solve(i+1,1,prices,cap,n,dp);
            profit = Math.max(buyy,notbuy);
        }else{

            int sell = prices[i] + solve(i+1,1,prices,cap-1,n,dp);
            int notSell = 0 + solve(i+1,0,prices,cap,n,dp);
            profit = Math.max(sell,notSell);
        }

        return dp[i][buy][cap] = profit;
    }
}