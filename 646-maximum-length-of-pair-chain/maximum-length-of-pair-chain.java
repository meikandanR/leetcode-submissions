class Solution {
    public int findLongestChain(int[][] pairs) {


        int n = pairs.length;

        Arrays.sort(pairs,(a,b)->{
            return a[0] - b[0];
        });
        for(int[] row :pairs){
            System.out.println(Arrays.toString(row));
        }
        int[][] dp = new int[n][n+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(0,-1,n,pairs,dp);
    }

    private int solve(int i,int previ, int n, int[][]pairs,int[][]dp){

        if(i == n ) return 0;
        if(dp[i][previ+1] != -1) return dp[i][previ+1];
        int notPick = 0 + solve(i+1,previ,n,pairs,dp);
        int pick = 0 ;
        if(previ==-1 || pairs[i][0] > pairs[previ][1]){
            pick = 1 + solve(i+1,i,n,pairs,dp);
        }
        return dp[i][previ+1] = Math.max(pick,notPick);

    }
}
