class Solution {

    public String stoneGameIII(int[] stoneValue) {

        int n = stoneValue.length;

        int[] dp = new int[4];

        for (int i = n - 1; i >= 0; i--) {

            int best = Integer.MIN_VALUE;
            int sum = 0;

            for (int k = 0; k < 3 && i + k < n; k++) {

                sum += stoneValue[i + k];

                best = Math.max(best, sum - dp[(i + k + 1) % 4]);
            }

            dp[i % 4] = best;
        }

        int diff = dp[0];

        if (diff > 0)
            return "Alice";
        if (diff < 0)
            return "Bob";

        return "Tie";
    }
}