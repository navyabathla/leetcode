class Solution {
    private boolean isPossible(int[] weights, int days, int capacity) {

        int requiredDays = 1;
        int currWeight = 0;

        for (int weight : weights) {

            if (currWeight + weight <= capacity) {
                currWeight += weight;
            } else {
                requiredDays++;
                currWeight = weight;

                if (requiredDays > days) {
                    return false;
                }
            }
        }

        return true;
    }

    public int shipWithinDays(int[] weights, int days) {

        int left = 0;
        int right = 0;

        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }

        int answer = right;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (isPossible(weights, days, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}