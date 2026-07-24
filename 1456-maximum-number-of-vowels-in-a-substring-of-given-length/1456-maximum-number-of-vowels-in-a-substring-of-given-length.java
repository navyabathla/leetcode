class Solution {
        private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i'
            || ch == 'o' || ch == 'u';
    }

    public int maxVowels(String s, int k) {

        int count = 0;
        int maxVowels = 0;

        int left = 0;

        for (int right = 0; right < s.length(); right++) {

            if (isVowel(s.charAt(right))) {
                count++;
            }

            if (right - left + 1 == k) {

                maxVowels = Math.max(maxVowels, count);

                // Cannot do better than k
                if (maxVowels == k) {
                    return k;
                }

                if (isVowel(s.charAt(left))) {
                    count--;
                }

                left++;
            }
        }

        return maxVowels;
    }
}