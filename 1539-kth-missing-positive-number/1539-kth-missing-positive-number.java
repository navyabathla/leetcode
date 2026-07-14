class Solution {
    public int findKthPositive(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int middle = left + (right - left) / 2;

            int missingNumbers = arr[middle] - (middle + 1);

            if (missingNumbers < k) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return left + k;
    }
}