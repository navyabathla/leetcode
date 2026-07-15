class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
         HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for (int number : nums1) {
            set1.add(number);
        }

        for (int number : nums2) {
            set2.add(number);
        }

        int countInNums1 = 0;
        int countInNums2 = 0;

        for (int number : nums1) {
            if (set2.contains(number)) {
                countInNums1++;
            }
        }

        for (int number : nums2) {
            if (set1.contains(number)) {
                countInNums2++;
            }
        }

        return new int[]{countInNums1, countInNums2};
    }
}