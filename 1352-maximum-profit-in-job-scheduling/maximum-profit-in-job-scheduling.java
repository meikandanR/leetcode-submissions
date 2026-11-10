class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        

        int n  = startTime.length;

        int[][] jobs = new int[n][3];

        for(int i = 0 ; i < n ; i++){
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        int[] dp = new int[n];
        Arrays.fill(dp,-1);

        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));

        return solve(0,jobs,n,dp);
    }

    public int solve(int i , int[][]jobs,int n,int dp[]){

        if(i == n ) return 0;
        if(dp[i]!= -1) return dp[i];

        int skip = 0 + solve(i+1,jobs,n,dp);
        int next = i + 1;

        while(next < n && jobs[next][0] < jobs[i][1]){
            next++;
        }
        int take = jobs[i][2] + solve(next,jobs,n,dp);

        return dp[i] = Math.max(skip,take);
    }
}