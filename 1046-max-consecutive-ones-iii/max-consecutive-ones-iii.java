class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int count0s = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {

            if (nums[right] == 0) {
                count0s++;
            }

            while (count0s > k) {
                if (nums[left] == 0) {
                    count0s--;
                }
                left++;
            }

            int len = right - left + 1;
            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }
}