class Solution {
    public int search(int[] nums, int target) {
        int arrayLength = nums.length;

        int pivotIndex = findPivot(nums, 0, arrayLength - 1);

        if (nums[pivotIndex] == target) {
            return pivotIndex;
        }

        int targetIndex = binarySearch(nums, pivotIndex + 1, arrayLength - 1, target);

        if (targetIndex != -1) {
            return targetIndex;
        }

        return binarySearch(nums, 0, pivotIndex - 1, target);

    }
    private int findPivot(int[] nums, int left, int right) {

        while (left < right) {

            int middle = left + (right - left) / 2;

            if (nums[middle] > nums[right]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return right;
    }

    private int binarySearch(int[] nums, int left, int right, int target) {

        while (left <= right) {

            int middle = left + (right - left) / 2;

            if (nums[middle] == target) {
                return middle;
            }

            if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return -1;
    }
}