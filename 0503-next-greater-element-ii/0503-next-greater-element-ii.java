class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;

        int[] ans = new int[n];

        Arrays.fill(ans, -1);

        Stack<Integer> stack = new Stack<>();

        // Traverse array twice
        for (int i = 0; i < 2 * n; i++) {

            int index = i % n;

            // Find next greater element
            while (!stack.isEmpty()
                    && nums[stack.peek()] < nums[index]) {

                ans[stack.pop()] = nums[index];
            }

            // Only push during the first traversal
            if (i < n) {
                stack.push(index);
            }
        }

        return ans;
    }
}