class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixSumFrequency = new HashMap<>();

        prefixSumFrequency.put(0, 1);

        int currentSum = 0;
        int subarrayCount = 0;

        for (int number : nums) {

            currentSum += number;

            if (prefixSumFrequency.containsKey(currentSum - k)) {
                subarrayCount += prefixSumFrequency.get(currentSum - k);
            }

            prefixSumFrequency.put(
                    currentSum,
                    prefixSumFrequency.getOrDefault(currentSum, 0) + 1
            );
        }

        return subarrayCount;

    }
}