class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;

        for (int i = 0; i < 32; i++) {

            int mask = 1 << i;
            int countOne = 0;

            for (int num : nums) {
                if ((num & mask) != 0) {
                    countOne++;
                }
            }

            if (countOne % 3 == 1) {
                result |= mask;
            }
        }

        return result;
    }
}