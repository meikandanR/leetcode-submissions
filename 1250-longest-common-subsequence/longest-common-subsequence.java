class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int[n+1][m+1];
        // for(int[] row :dp){
        //     Arrays.fill(row,-1);
        // }

        // Tabulation
        // for(int i = 0 ; i < n; i++){
        //     dp[i][0] = 0;
        // }
        // for(int j = 0 ; j <m; j++){
        //     dp[0][j] = 0;
        // }

        // for(int i  =1; i<=n ; i++){
        //     for(int  j = 1; j <=m ;  j++){
        //         // if(dp[i][j]!=-1){
        //         //     return dp[i][j];
        //         // }
        //         if(text1.charAt(i-1) == text2.charAt(j-1)){
        //             dp[i][j] = 1+ dp[i-1][j-1];
        //         }else{
        //         dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
        //         }
        //     }

        // }

        // return dp[n][m];
        // return solve(n,m,text1,text2,dp);
        return solve(text1,text2);
    }


    // Recursion and memoization
    public int solve(int i,int j , String s1, String s2,int[][]dp){
        if(i==0 || j == 0){
            return  0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s1.charAt(i-1) == s2.charAt(j-1)){
            return dp[i][j] = 1+ solve(i-1,j-1,s1,s2,dp);
        }

        return dp[i][j] = Math.max(solve(i-1,j,s1,s2,dp),solve(i,j-1,s1,s2,dp));
    }

    // Space Optimization
    public int solve(String text1,String text2){

        int n = text1.length();
        int m = text2.length();

        int [] prev = new int[m+1];
        int [] cur = new int[m+1];
        for(int j = 0 ; j < m ; j++) prev[j] =0;

        for(int i  = 1; i <=n;i++){
            for(int j = 1; j <= m ; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    cur[j]= 1+ prev[j-1];
                }else{
                    cur[j] = Math.max(prev[j],cur[j-1]);
                }
            }
            prev = cur.clone();
        }
        return prev[m];
    }
}