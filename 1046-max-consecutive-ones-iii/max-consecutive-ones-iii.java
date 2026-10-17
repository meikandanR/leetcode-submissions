class Solution {
    public int longestOnes(int[] nums, int k) {
        

        int maxLen = 0, l =0, r =0, zero = 0, n =nums.length;
        while(r<n){

             if(nums[r] == 0) zero++;
             if(zero>k){
                if(nums[l]==0){
                    zero--;
                }
                l++; 
             }
             if(zero<=k){
                int len = r-l+1;
                maxLen = Math.max(len,maxLen);
             }
             r++;
        }
        return maxLen;
    }
}