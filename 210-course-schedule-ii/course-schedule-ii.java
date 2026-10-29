class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        // form graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ;i < numCourses ; i ++){
            adj.add(new ArrayList<>());
        }

        for(int i  = 0 ; i < prerequisites.length; i ++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] indegree = new int[numCourses];

        for(int i  = 0 ; i < numCourses ; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();

        for(int i  = 0 ; i < numCourses ; i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        ArrayList<Integer> topo = new ArrayList<>();

    
        while(!q.isEmpty()){
            int node = q.poll();
            topo.add(node);   
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        if(topo.size() == numCourses){
            int[] ans = new int[numCourses];
            for(int i = 0;i<ans.length;i++){
                ans[i]= topo.get(i);
            }
            return ans;
        }

        return new int[0];
    }
}