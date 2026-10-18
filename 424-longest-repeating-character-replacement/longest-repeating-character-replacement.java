class Solution {
    public int characterReplacement(String s, int k) {

        int l = 0, r = 0 , maxLen = 0 , n = s.length(), maxfreq = 0;

        int hash[] = new int[26];

        while(r<n){
            hash[s.charAt(r)-'A']++;
            maxfreq = Math.max(maxfreq,hash[s.charAt(r)-'A']);
            
            int changes = (r-l+1) - maxfreq;

            if(changes>k){
                hash[s.charAt(l)-'A']--;
                maxfreq = 0;
                l++;
            }
            if(changes <=k){
                maxLen = Math.max(maxLen,r-l+1);
            }
            r++;
        }
        return maxLen;
        
    }
}