class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];      // start ascending
            }
            return b[1] - a[1];          // end descending
        });

        int count = 0;
        int maxRight = -1;

        for (int[] interval : intervals) {
            if (interval[1] > maxRight) {
                count++;
                maxRight = interval[1];
            }
            // else interval is covered
        }

        return count;
    }
}