class Solution {
    public String removeStars(String s) {
        char[] result = new char[s.length()];
        int j = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '*') {
                j--;
            } else {
                result[j++] = s.charAt(i);
            }
        }

        return new String(result, 0, j);
    }
}