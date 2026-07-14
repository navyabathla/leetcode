class Solution {

    private boolean canEatAll(int[] piles, int eatingSpeed, int totalHours) {

        long requiredHours = 0;

        for (int bananas : piles) {

            requiredHours += (bananas + eatingSpeed - 1) / eatingSpeed;

            if (requiredHours > totalHours) {
                return false;
            }
        }

        return true;
    }

    public int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = 0;

        for (int bananas : piles) {
            right = Math.max(right, bananas);
        }

        while (left < right) {

            int middle = left + (right - left) / 2;

            if (canEatAll(piles, middle, h)) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return left;
    }
}