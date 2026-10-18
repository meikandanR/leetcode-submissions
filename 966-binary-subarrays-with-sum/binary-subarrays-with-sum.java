class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return findSubarray(nums, goal) - findSubarray(nums, goal-1);
    }

    public int findSubarray(int[] nums, int goal){
        if(goal<0) return 0;
        int count = 0;
        int n = nums.length;
        int l = 0 , r = 0 ;
        int sum = 0 ;
        while(r<n){
            sum += nums[r];
            while(sum>goal){
                sum-=nums[l];
                l++;
            }
            count += r - l + 1;
            r++;
        }
        return count;
    }
}