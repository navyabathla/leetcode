class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int number : nums) {

            if (count == 0) {
                candidate = number;
            }

            if (number == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;

    }
}