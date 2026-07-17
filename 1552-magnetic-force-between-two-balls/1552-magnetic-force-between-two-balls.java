class Solution {
   private boolean isPossible(int[] position, int m, int minDist) {

        int ballsPlaced = 1;
        int lastPosition = position[0];

        for (int i = 1; i < position.length; i++) {

            if (position[i] - lastPosition >= minDist) {
                ballsPlaced++;
                lastPosition = position[i];

                if (ballsPlaced >= m) {
                    return true;
                }
            }
        }

        return false;
    }

    public int maxDistance(int[] position, int m) {

        Arrays.sort(position);

        int left = 1;
        int right = position[position.length - 1] - position[0];

        int answer = 0;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (isPossible(position, m, mid)) {
                answer = mid;
                left = mid + 1;      // Try a larger minimum distance
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }
}