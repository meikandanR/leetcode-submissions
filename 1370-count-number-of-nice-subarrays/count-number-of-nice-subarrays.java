class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        for(int i = 0 ;i < nums.length;i++){
            if(nums[i]%2==1 ){
                nums[i] = 1;
            }else{
                nums[i] = 0;
            }
        }
        return findSubarray(nums, k) - findSubarray(nums, k-1);
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
