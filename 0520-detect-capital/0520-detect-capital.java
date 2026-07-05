class Solution {
    public boolean detectCapitalUse(String word) {
        int countCapitals = 0;

        for (char ch : word.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                countCapitals++;
            }
        }

        if (countCapitals == 0) {
            return true;
        }

        if (countCapitals == word.length()) {
            return true;
        }

        if (countCapitals == 1 && Character.isUpperCase(word.charAt(0))) {
            return true;
        }

        return false;
    }
}