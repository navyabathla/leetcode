class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> firstOccurrence = new HashMap<>();

        firstOccurrence.put(0, -1);

        int runningSum = 0;
        int maximumLength = 0;

        for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {

            if (nums[currentIndex] == 0) {
                runningSum--;
            } else {
                runningSum++;
            }

            if (firstOccurrence.containsKey(runningSum)) {

                int previousIndex = firstOccurrence.get(runningSum);

                maximumLength = Math.max(maximumLength,
                        currentIndex - previousIndex);

            } else {

                firstOccurrence.put(runningSum, currentIndex);
            }
        }

        return maximumLength;
    }
}