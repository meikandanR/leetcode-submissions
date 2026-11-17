class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int n = intervals.length;
        int i =0;
        while(i<n && intervals[i][1] < newInterval[0]){
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(intervals[i][0]);
            list.add(intervals[i][1]);
            ans.add(list);
            i++;
        }

        while(i<n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        ArrayList<Integer> newIn = new ArrayList<>();
        newIn.add(newInterval[0]);
        newIn.add(newInterval[1]);
        ans.add(newIn);

        // list.add(newInterval[1]);

        while(i<n){
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(intervals[i][0]);
            list.add(intervals[i][1]);
            ans.add(list);
            i++;
        }

        int sizee = ans.size();
        int res[][]= new int[sizee][2];

        for(int j =0;j<sizee;j++){

            res[j][0] = ans.get(j).get(0);
            res[j][1] = ans.get(j).get(1);
        }

        return res;

    }
}