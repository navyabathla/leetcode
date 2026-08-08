class Solution {
    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int[] last = new int[m];

        // last[j] = position in word1 where we can match
        // word2[j] while matching word2[j...m-1]
        // from right to left.
        Arrays.fill(last, -1);

        int i = n - 1;
        int j = m - 1;

        while (i >= 0 && j >= 0) {

            if (word1.charAt(i) == word2.charAt(j)) {
                last[j] = i;
                j--;
            }

            i--;
        }

        int[] ans = new int[m];

        boolean canSkip = true;

        i = 0;
        j = 0;

        while (i < n && j < m) {

            // Case 1: exact match
            if (word1.charAt(i) == word2.charAt(j)) {

                ans[j] = i;
                j++;

            }

            // Case 2: use our one mismatch
            else if (canSkip &&
                     (j == m - 1 || i < last[j + 1])) {

                ans[j] = i;
                j++;

                canSkip = false;
            }

            i++;
        }

        if (j != m) {
            return new int[0];
        }

        return ans;
    }
}