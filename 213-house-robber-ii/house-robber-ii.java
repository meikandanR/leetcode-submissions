class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0 ) return 0;
        if(nums.length == 1) return nums[0];
        int withoutFirst = robGivenRange(Arrays.copyOfRange(nums, 1, nums.length));
        int withoutLast = robGivenRange(Arrays.copyOfRange(nums, 0, nums.length-1));
        return Math.max(withoutFirst,withoutLast);

        
    }

    public int robGivenRange(int[] nums){
        int n = nums.length;
        int prev1 = nums[0];
        int prev2 = 0;

        for(int i = 1 ;i <n;i++){
            int take = nums[i] + prev2;
            int notTake =  0 + prev1;
            int curi = Math.max(take,notTake);
            prev2 = prev1;
            prev1 = curi;

        }
        return prev1;
    }
}