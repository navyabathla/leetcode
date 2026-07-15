class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
         HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for (int number : nums1) {
            frequencyMap.put(number,
                    frequencyMap.getOrDefault(number, 0) + 1);
        }

        ArrayList<Integer> intersection = new ArrayList<>();

        for (int number : nums2) {

            if (frequencyMap.getOrDefault(number, 0) > 0) {

                intersection.add(number);
                frequencyMap.put(number, frequencyMap.get(number) - 1);
            }
        }

        int[] result = new int[intersection.size()];

        for (int i = 0; i < intersection.size(); i++) {
            result[i] = intersection.get(i);
        }

        return result;
    }
}