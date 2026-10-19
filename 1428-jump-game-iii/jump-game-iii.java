class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        Queue<Integer> q = new LinkedList<>();
        int [] vis = new int[arr.length];

        q.add(start);

        while(!q.isEmpty()){

            int idx = q.poll();
            if(vis[idx] == 0){
            if(arr[idx] == 0) return true;

            if(idx + arr[idx] < n) q.add(idx + arr[idx]);

            if(idx - arr[idx] >= 0) q.add(idx - arr[idx]);
            
            vis[idx] = 1;
            }

        }
        return false;
        
    }
}