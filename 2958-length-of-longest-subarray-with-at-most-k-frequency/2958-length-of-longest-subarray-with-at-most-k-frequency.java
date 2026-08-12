class Solution {
    public int maxSubarrayLength(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {

            // Add current element
            int num = nums[right];
            map.put(num, map.getOrDefault(num, 0) + 1);

            // Shrink window if frequency exceeds k
            while (map.get(num) > k) {
                int leftNum = nums[left];

                map.put(leftNum, map.get(leftNum) - 1);

                left++;
            }

            // Current valid window length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}