class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int k = strs[0].length();

        int count = 0;

        // Traverse each column
        for (int i = 0; i < k; i++) {

            // Compare characters in the current column
            for (int j = 1; j < n; j++) {
                if (strs[j].charAt(i) < strs[j - 1].charAt(i)) {
                    count++;
                    break; // No need to check this column further
                }
            }
        }

        return count;
    }
}