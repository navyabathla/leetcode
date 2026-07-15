class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for (int number : nums1) {
            set1.add(number);
        }

        for (int number : nums2) {
            set2.add(number);
        }

        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();

        for (int number : set1) {
            if (!set2.contains(number)) {
                firstList.add(number);
            }
        }

        for (int number : set2) {
            if (!set1.contains(number)) {
                secondList.add(number);
            }
        }

        List<List<Integer>> answer = new ArrayList<>();

        answer.add(firstList);
        answer.add(secondList);

        return answer;
    }
}