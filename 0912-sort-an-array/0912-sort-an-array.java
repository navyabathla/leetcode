class Solution {
    public int[] sortArray(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int[] count = new int[max - min + 1];

        for (int num : nums) {
            count[num - min]++;
        }

        int index = 0;

        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0) {
                nums[index++] = i + min;
            }
        }

        return nums;
    }
}