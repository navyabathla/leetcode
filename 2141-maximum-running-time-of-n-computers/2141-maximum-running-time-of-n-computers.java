class Solution {
    private boolean isPossible(int[] batteries, int n, long time) {

        long totalPower = 0;

        for (int battery : batteries) {
            totalPower += Math.min((long) battery, time);
        }

        return totalPower >= time * n;
    }

    public long maxRunTime(int n, int[] batteries) {

        long totalCapacity = 0;

        for (int battery : batteries) {
            totalCapacity += battery;
        }

        long left = 0;
        long right = totalCapacity / n;

        long answer = 0;

        while (left <= right) {

            long mid = left + (right - left) / 2;

            if (isPossible(batteries, n, mid)) {
                answer = mid;
                left = mid + 1;     // Try a larger running time
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }
}