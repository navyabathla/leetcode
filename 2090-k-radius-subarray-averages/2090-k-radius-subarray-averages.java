class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;

        if (k == 0)
            return nums;

        int[] result = new int[n];
        Arrays.fill(result, -1);

        if (n < 2 * k + 1)
            return result;

        long windowSum = 0;

        int left = 0;
        int right = 2 * k;
        int index = k;

        // Calculate sum of the first window
        for (int i = left; i <= right; i++) {
            windowSum += nums[i];
        }

        result[index] = (int) (windowSum / (2 * k + 1));

        index++;
        right++;

        // Slide the window
        while (right < n) {

            windowSum = windowSum - nums[left] + nums[right];

            result[index] = (int) (windowSum / (2 * k + 1));

            left++;
            right++;
            index++;
        }

        return result;
    }
}