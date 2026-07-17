class Solution {
    public String maximumOddBinaryNumber(String s) {
        int n = s.length();

        // Initialize result string with '0' of length n
        StringBuilder result = new StringBuilder();
        for (int k = 0; k < n; k++) {
            result.append('0');
        }

        int countOnes = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                countOnes++;
            }
        }


        int j = 0;

        while (countOnes > 1) {
            result.setCharAt(j, '1');
            j++;

            countOnes--;
        }

        result.setCharAt(n - 1, '1');
        return result.toString();
    }
}