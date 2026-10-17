class Solution {
    public int lengthOfLongestSubstring(String s) {

        int l = 0 , r = 0, maxlen = 0;
        int n = s.length();
        int map [] = new int[256];
        for(int i = 0; i< map.length; i++){
            map[i] = -1;
        }

        while(r<n){

            if(map[s.charAt(r)] !=-1){
                if(map[s.charAt(r)] >= l){
                    l = map[s.charAt(r)] + 1;  
                }
            }
            map[s.charAt(r)] = r;
            int len = r - l +1;
            maxlen = Math.max(len,maxlen );
            r++;
        }
        return maxlen;

    }
}