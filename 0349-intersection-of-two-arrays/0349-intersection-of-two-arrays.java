class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
         HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> intersection = new HashSet<>();

        for (int number : nums1) {
            set.add(number);
        }

        for (int number : nums2) {
            if (set.contains(number)) {
                intersection.add(number);
            }
        }

        int[] result = new int[intersection.size()];
        int index = 0;

        for (int number : intersection) {
            result[index++] = number;
        }

        return result;
    }
}