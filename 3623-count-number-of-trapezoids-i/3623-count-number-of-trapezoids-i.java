import java.util.*;

class Solution {
    public int countTrapezoids(int[][] points) {

        final int MOD = 1_000_000_007;

        HashMap<Integer, Long> map = new HashMap<>();

        // Count points having the same y-coordinate
        for (int[] point : points) {
            int y = point[1];
            map.put(y, map.getOrDefault(y, 0L) + 1);
        }

        long answer = 0;
        long previousPairs = 0;

        // Process each horizontal level
        for (long count : map.values()) {

            if (count < 2) {
                continue;
            }

            // Number of ways to choose 2 points on this y-level
            long currentPairs = count * (count - 1) / 2;

            // Pair this level with all previous levels
            answer = (answer + previousPairs * currentPairs) % MOD;

            // Add current level's pairs
            previousPairs = (previousPairs + currentPairs) % MOD;
        }

        return (int) answer;
    }
}