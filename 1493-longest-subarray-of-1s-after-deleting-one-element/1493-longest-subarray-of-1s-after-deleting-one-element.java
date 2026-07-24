class Solution {
    public int longestSubarray(int[] nums) {
        
        int left = 0;
        int right = 0;

        int lastZeroIndex = -1;
        int maxLength = 0;

        while (right < nums.length) {

            if (nums[right] == 0) {
                left = lastZeroIndex + 1;
                lastZeroIndex = right;
            }

            maxLength = Math.max(maxLength, right - left);
            right++;
        }

        return maxLength;
    }
}