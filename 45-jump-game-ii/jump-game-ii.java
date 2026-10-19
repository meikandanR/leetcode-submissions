class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        int totaljumps = 0 ;
        int lastIndx = 0;
        int coverage = 0;
        int destination = n - 1;
        for(int i =0; i<n; i++){
            coverage = Math.max(coverage, i+nums[i]);
            if(i == lastIndx){
                lastIndx = coverage;
                totaljumps++;
                if(coverage>=destination){
                    return totaljumps;
                }
            }
        }
        return totaljumps;
    }
}