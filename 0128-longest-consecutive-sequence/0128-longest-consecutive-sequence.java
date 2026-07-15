class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> uniqueNumbers = new HashSet<>();

        for (int number : nums) {
            uniqueNumbers.add(number);
        }

        int longestSequenceLength = 0;

        for (int number : uniqueNumbers) {

            // Start only if this is the beginning of a sequence
            if (!uniqueNumbers.contains(number - 1)) {

                int currentNumber = number;
                int currentSequenceLength = 1;

                while (uniqueNumbers.contains(currentNumber + 1)) {
                    currentNumber++;
                    currentSequenceLength++;
                }

                longestSequenceLength = Math.max(longestSequenceLength,
                                                 currentSequenceLength);
            }
        }

        return longestSequenceLength;

    }
}