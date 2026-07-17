class Solution {
   private double possible(int[] dist, int speed) {

        double time = 0.0;
        int n = dist.length;

        for (int i = 0; i < n - 1; i++) {
            time += Math.ceil((double) dist[i] / speed);
        }

        time += (double) dist[n - 1] / speed;

        return time;
    }

    public int minSpeedOnTime(int[] dist, double hour) {

        int left = 1;
        int right = 10_000_000;

        int minSpeed = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (possible(dist, mid) <= hour) {
                minSpeed = mid;
                right = mid - 1;
            } else {
                left = mid + 1; // Need to increase the speed
            }
        }

        return minSpeed;
    }
}