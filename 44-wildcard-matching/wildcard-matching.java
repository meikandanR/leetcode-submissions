class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        Boolean[][] dp = new Boolean[n][m];

        return solve(n-1,m-1,p,s,dp);
    }

    private boolean solve(int i,int j, String p, String s,Boolean[][] dp){

        if(i<0 && j<0) return true;
        if(i<0 && j>=0) return false;
        if(j<0 && i>=0) {
            for(int k = i; k>=0;k--){
                if(p.charAt(k) != '*'){
                    return false;
                }
            }
            return true;
        }
        if(dp[i][j] != null) return dp[i][j];

        if(s.charAt(j) == p.charAt(i) || p.charAt(i)=='?'){
            return dp[i][j]= solve(i-1,j-1,p,s,dp);
        }


        if(p.charAt(i)=='*'){
            return dp[i][j] =solve(i,j-1,p,s,dp) || solve(i-1,j,p,s,dp);
        }

        return false;
    }


}