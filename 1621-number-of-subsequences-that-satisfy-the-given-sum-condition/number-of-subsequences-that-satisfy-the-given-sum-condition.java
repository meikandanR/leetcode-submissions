import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;
        int count = 0;

        // Current power = 2^(right - left)
        long power = 1;

        // Build powers as the left pointer moves.
        // This approach needs careful exponent tracking, so use
        // the standard O(n) powers array for the simplest solution.
        int[] pow = new int[nums.length];
        pow[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            pow[i] = (int) (2L * pow[i - 1] % MOD);
        }

        while (left <= right) {
            if ((long) nums[left] + nums[right] <= target) {
                count = (int) ((count + (long) pow[right - left]) % MOD);
                left++;
            } else {
                right--;
            }
        }

        return count;
    }
}