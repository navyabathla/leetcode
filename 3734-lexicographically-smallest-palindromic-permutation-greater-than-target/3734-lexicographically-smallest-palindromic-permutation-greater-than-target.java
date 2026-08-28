class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();

        // Frequency of characters
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Check whether palindrome is possible
        int odd = 0;
        char middle = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                odd++;
                middle = (char) ('a' + i);
            }
        }

        if (odd > 1) {
            return "";
        }

        // Characters available for the left half
        int[] half = new int[26];

        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
        }

        int halfLen = n / 2;

        StringBuilder left = new StringBuilder();

        for (int pos = 0; pos < halfLen; pos++) {

            // Try smallest possible character
            for (int c = 0; c < 26; c++) {

                if (half[c] == 0) {
                    continue;
                }

                // Choose this character
                half[c]--;
                left.append((char) ('a' + c));

                // Can we complete it to something > target?
                if (canMakeGreater(left, half, middle, target)) {
                    break;
                }

                // Undo
                left.deleteCharAt(left.length() - 1);
                half[c]++;
            }

            // No character worked
            if (left.length() != pos + 1) {
                return "";
            }
        }

        // Construct final palindrome
        String leftPart = left.toString();

        StringBuilder ans = new StringBuilder();
        ans.append(leftPart);

        if (n % 2 == 1) {
            ans.append(middle);
        }

        ans.append(new StringBuilder(leftPart).reverse());

        String result = ans.toString();

        return result.compareTo(target) > 0 ? result : "";
    }

    private boolean canMakeGreater(
            StringBuilder left,
            int[] half,
            char middle,
            String target) {

        int n = target.length();

        // Complete the remaining left half using
        // the largest possible characters.
        StringBuilder candidateLeft = new StringBuilder(left);

        for (int c = 25; c >= 0; c--) {
            for (int k = 0; k < half[c]; k++) {
                candidateLeft.append((char) ('a' + c));
            }
        }

        // Build palindrome
        StringBuilder candidate = new StringBuilder();

        candidate.append(candidateLeft);

        if (n % 2 == 1) {
            candidate.append(middle);
        }

        candidate.append(
            new StringBuilder(candidateLeft).reverse()
        );

        return candidate.toString().compareTo(target) > 0;
    }
}