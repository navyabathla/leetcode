class Solution {

    private int[][] dp;
    private int[] suffix;
    private int n;

    public int stoneGameII(int[] piles) {

        n = piles.length;

        suffix = new int[n + 1];

        // suffix[i] = sum of piles from i to n-1
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        dp = new int[n][n + 1];

        return dfs(piles, 0, 1);
    }

    private int dfs(int[] piles, int index, int M) {

        // Can take all remaining piles
        if (index >= n) {
            return 0;
        }

        if (2 * M >= n - index) {
            return suffix[index];
        }

        if (dp[index][M] != 0) {
            return dp[index][M];
        }

        int best = 0;

        int taken = 0;

        for (int X = 1; X <= 2 * M && index + X <= n; X++) {

            taken += piles[index + X - 1];

            int opponent = dfs(
                piles,
                index + X,
                Math.max(M, X)
            );

            int current = suffix[index] - opponent;

            best = Math.max(best, current);
        }

        dp[index][M] = best;

        return best;
    }
}