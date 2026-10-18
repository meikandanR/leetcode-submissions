class Solution {
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(s);
        Arrays.sort(g);
        int l= 0;
        int r = 0;
        int m = s.length;
        int n = g.length;

        while(l<m &&  r <n){
            if(g[r] <= s[l]){
                r++;
            }
            l++;
        }
        return r;
        
    }
}