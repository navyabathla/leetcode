class Solution {
    public int maxProduct(int[] nums) {

        int maxEnding = nums[0];
        int minEnding = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int curr = nums[i];

            int oldMax = maxEnding;
            int oldMin = minEnding;

            maxEnding = Math.max(curr,
                    Math.max(curr * oldMax, curr * oldMin));

            minEnding = Math.min(curr,
                    Math.min(curr * oldMax, curr * oldMin));

            ans = Math.max(ans, maxEnding);
        }

        return ans;
    }
}