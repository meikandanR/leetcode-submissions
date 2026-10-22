class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int subset = 1<<nums.length;

        List<List<Integer>> ans = new ArrayList<>();
        for(int num = 0 ; num< subset ; num++){
            List<Integer> list= new ArrayList<>();
            for(int i =0; i  <  nums.length ;i++){
                if((num & (1<<i))!=0){
                    list.add(nums[i]);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}