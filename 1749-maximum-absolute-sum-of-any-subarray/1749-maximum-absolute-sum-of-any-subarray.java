class Solution {
    public int maxAbsoluteSum(int[] nums) {

        int maxEnding = nums[0];
        int minEnding = nums[0];

        int ans = Math.abs(nums[0]);

        for (int i = 1; i < nums.length; i++) {

            int curr = nums[i];

            int newMax = Math.max(
                    curr,
                    curr + maxEnding
            );

            int newMin = Math.min(
                    curr,
                    curr + minEnding
            );

            maxEnding = newMax;
            minEnding = newMin;

            ans = Math.max(
                    ans,
                    Math.max(Math.abs(maxEnding), Math.abs(minEnding))
            );
        }

        return ans;
    }
}