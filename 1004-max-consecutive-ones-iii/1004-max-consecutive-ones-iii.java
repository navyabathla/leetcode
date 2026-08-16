class Solution {
    public int longestOnes(int[] nums, int k) {

        int left = 0;
        int zeros = 0;
        int ans = 0;

        for (int right = 0; right < nums.length; right++) {

            // Add nums[right] to the window
            if (nums[right] == 0) {
                zeros++;
            }

            // Window is invalid
            while (zeros > k) {

                if (nums[left] == 0) {
                    zeros--;
                }

                left++;
            }

            // Window is valid
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}