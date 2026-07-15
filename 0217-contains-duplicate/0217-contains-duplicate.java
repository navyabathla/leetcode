class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> uniqueNumbers = new HashSet<>();

        for (int number : nums) {

            if (uniqueNumbers.contains(number)) {
                return true;
            }

            uniqueNumbers.add(number);
        }

        return false;
    }
}