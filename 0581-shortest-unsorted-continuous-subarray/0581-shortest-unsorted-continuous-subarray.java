class Solution {
    public int findUnsortedSubarray(int[] nums) {

        int n = nums.length;

        int left = -1;
        int right = -1;

        // Find first position where order is broken
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                left = i;
                break;
            }
        }

        // Already sorted
        if (left == -1) {
            return 0;
        }

        // Find last position where order is broken
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] < nums[i - 1]) {
                right = i;
                break;
            }
        }

        // Find min and max in the unsorted portion
        int min = nums[left];
        int max = nums[left];

        for (int i = left; i <= right; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        // Expand left
        while (left > 0 && nums[left - 1] > min) {
            left--;
        }

        // Expand right
        while (right < n - 1 && nums[right + 1] < max) {
            right++;
        }

        return right - left + 1;
    }
}