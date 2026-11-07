class Solution {
    public int maxProfit(int[] prices) {
        // Code here
        int n = prices.length;
        int mini = prices[0];
        int maxProfit = 0 ;
        
        for(int i = 1 ; i < n ; i++){
            int cost  = prices[i] - mini;
            maxProfit = Math.max(cost,maxProfit);
            mini  = Math.min(mini,prices[i]);
        }
        return maxProfit;
    }
}