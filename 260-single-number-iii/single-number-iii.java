class Solution {
    public int[] singleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ind = 0 ;
        int ans[] = new int[2];
        int i = 0 ;
        while(i<n){
            if(i+1 < n && nums[i] == nums[i+1]){
                i+=2;
            }else{
                ans[ind] = nums[i];
                i++;
                ind++;
            }
            if(ind == 2){
                break;
            }
        }
        return ans;
        
    }
}