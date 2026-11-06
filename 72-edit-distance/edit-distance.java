class Solution {
    public int minDistance(String word1, String word2) {
        
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return solve(n-1,m-1,word1,word2,dp);
    }

    public int solve(int i , int j , String s1, String s2,int[][] dp){

        if(i<0) {
            return j+1; 
        }
        if(j<0){
            return i+1;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j)){
            return 0 + solve(i-1,j-1,s1,s2,dp);
        }
        int insert = 1 + solve(i,j-1,s1,s2,dp);
        int replace = 1 + solve(i-1,j-1,s1,s2,dp);
        int delete = 1 + solve(i-1,j,s1,s2,dp);
        return dp[i][j] = Math.min(insert, Math.min(replace,delete));
    }
}