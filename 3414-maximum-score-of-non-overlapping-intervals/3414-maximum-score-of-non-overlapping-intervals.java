import java.util.*;

class Solution {

    static class State {
        long score;
        List<Integer> indices;

        State(long score, List<Integer> indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        int[][] arr = new int[n][4];

        // Store: start, end, weight, originalIndex
        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }

        // Sort by start time
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        // next[i] = first interval with start > arr[i][1]
        int[] next = new int[n];

        for (int i = 0; i < n; i++) {
            next[i] = findNext(arr, i, arr[i][1]);
        }

        State[][] dp = new State[n + 1][5];

        // Base cases
        for (int i = 0; i <= n; i++) {
            dp[i][0] = new State(0, new ArrayList<>());
        }

        for (int k = 0; k <= 4; k++) {
            dp[n][k] = new State(0, new ArrayList<>());
        }

        // Build DP from right to left
        for (int i = n - 1; i >= 0; i--) {
            for (int k = 1; k <= 4; k++) {

                // Option 1: Skip
                State skip = dp[i + 1][k];

                // Option 2: Take
                State future = dp[next[i]][k - 1];

                List<Integer> chosen = new ArrayList<>(future.indices);
                chosen.add(arr[i][3]);
                Collections.sort(chosen);

                State take = new State(
                    arr[i][2] + future.score,
                    chosen
                );

                // Store the better state
                dp[i][k] = better(take, skip);
            }
        }

        List<Integer> answer = dp[0][4].indices;

        int[] result = new int[answer.size()];

        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }

    private int findNext(int[][] arr, int current, int end) {

        int left = current + 1;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid][0] > end) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private State better(State a, State b) {

        // Higher score wins
        if (a.score != b.score) {
            return a.score > b.score ? a : b;
        }

        // Same score -> lexicographically smaller indices win
        int size = Math.min(a.indices.size(), b.indices.size());

        for (int i = 0; i < size; i++) {
            int x = a.indices.get(i);
            int y = b.indices.get(i);

            if (x != y) {
                return x < y ? a : b;
            }
        }

        // If one is a prefix of the other, shorter is lexicographically smaller
        return a.indices.size() <= b.indices.size() ? a : b;
    }
}