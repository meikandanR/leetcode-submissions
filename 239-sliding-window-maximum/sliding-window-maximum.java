class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
         int n = nums.length;
         ArrayList<Integer> al = new ArrayList<>();
        
         Deque<Integer> dq = new ArrayDeque<>();

         for(int i =0; i < n;i++ ){
            if( !dq.isEmpty() && dq.getFirst()==i-k) dq.removeFirst();
            while(!dq.isEmpty() && nums[dq.getLast()]<=nums[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);
            if(i>=k-1) al.add(nums[dq.getFirst()]);

         }

        int ans[] = new int[al.size()];
        for (int i = 0; i < al.size(); i++) {
            ans[i] = al.get(i);
        }
        return ans;
        
    }
}