class Solution {
    public int minimizeArrayValue(int[] nums) {
        int left = 0;
        int right = 0;

        for (int num : nums) {
            right = Math.max(right, num);
        }

        int result = right;

        while (left <= right) {

            int midMax = left + (right - left) / 2;

            if (isValid(nums, midMax)) {
                result = midMax;
                right = midMax - 1;
            } else {
                left = midMax + 1;
            }
        }

        return result;
    }
     private boolean isValid(int[] nums, int midMax) {
        int n = nums.length;

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
        }

        for (int i = 0; i < n - 1; i++) {

            if (arr[i] > midMax) {
                return false;
            }

            long buffer = (long) midMax - arr[i];

            arr[i + 1] = arr[i + 1] - buffer;
        }

        return arr[n - 1] <= midMax;
    }
}