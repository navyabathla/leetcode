class Solution {
    public boolean search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int middle = left + (right - left) / 2;

            if (nums[middle] == target) {
                return true;
            }

            // Cannot determine sorted half due to duplicates
            if (nums[left] == nums[middle] &&
                nums[middle] == nums[right]) {

                left++;
                right--;
            }

            // Left half is sorted
            else if (nums[left] <= nums[middle]) {

                if (nums[left] <= target &&
                    target < nums[middle]) {

                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }

            // Right half is sorted
            else {

                if (nums[middle] < target &&
                    target <= nums[right]) {

                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }

        return false;
    }
}