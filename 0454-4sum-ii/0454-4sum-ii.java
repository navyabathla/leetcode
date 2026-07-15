class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> pairSumFrequency = new HashMap<>();

        // Store all possible sums of nums1 and nums2
        for (int firstNumber : nums1) {

            for (int secondNumber : nums2) {

                int pairSum = firstNumber + secondNumber;

                pairSumFrequency.put(
                        pairSum,
                        pairSumFrequency.getOrDefault(pairSum, 0) + 1
                );
            }
        }

        int tupleCount = 0;

        // Find complementary sums from nums3 and nums4
        for (int thirdNumber : nums3) {

            for (int fourthNumber : nums4) {

                int currentSum = thirdNumber + fourthNumber;

                tupleCount += pairSumFrequency.getOrDefault(-currentSum, 0);
            }
        }

        return tupleCount;
    }
}