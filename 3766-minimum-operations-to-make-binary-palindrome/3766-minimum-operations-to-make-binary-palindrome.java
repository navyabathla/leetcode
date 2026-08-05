class Solution {

    public int[] minOperations(int[] nums) {

        List<Integer> palindromes = new ArrayList<>();

        for (int i = 1; i < (1 << 14); i++) {
            if (isBinaryPalindrome(i)) {
                palindromes.add(i);
            }
        }

        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            int x = nums[i];

            int index = Collections.binarySearch(palindromes, x);

            if (index >= 0) {
                ans[i] = 0;
            } else {

                index = -index - 1;

                int best = Integer.MAX_VALUE;

                if (index < palindromes.size()) {
                    best = palindromes.get(index) - x;
                }

                if (index > 0) {
                    best = Math.min(best, x - palindromes.get(index - 1));
                }

                ans[i] = best;
            }
        }

        return ans;
    }

    private boolean isBinaryPalindrome(int x) {

        String s = Integer.toBinaryString(x);

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}