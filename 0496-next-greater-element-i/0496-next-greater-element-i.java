class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> stack = new Stack<>();

        HashMap<Integer, Integer> map = new HashMap<>();

        // Process nums2
        for (int num : nums2) {

            // Current number is greater than stack top
            // So current number is the answer for stack top
            while (!stack.isEmpty() && stack.peek() < num) {

                int smaller = stack.pop();

                map.put(smaller, num);
            }

            // We haven't found the greater element for num yet
            stack.push(num);
        }

        // Whatever remains has no greater element
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        // Build answer for nums1
        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
}