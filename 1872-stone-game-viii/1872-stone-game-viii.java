class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;

        // Prefix sums
        int[] prefix = new int[n];

        prefix[0] = stones[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + stones[i];
        }

        // Best score difference starting from the last possible state
        int best = prefix[n - 1];

        // Work backwards
        for (int i = n - 2; i >= 1; i--) {
            best = Math.max(best, prefix[i] - best);
        }

        return best;
    }
}