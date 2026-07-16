class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, Integer> charToIndex = new HashMap<>();
        HashMap<String, Integer> wordToIndex = new HashMap<>();

        String[] words = s.split(" ");

        if (words.length != pattern.length())
            return false;

        for (int i = 0; i < pattern.length(); i++) {

            int charIndex = charToIndex.getOrDefault(pattern.charAt(i), 0);
            int wordIndex = wordToIndex.getOrDefault(words[i], 0);

            if (charIndex != wordIndex)
                return false;

            // Store i + 1 because default value is 0
            charToIndex.put(pattern.charAt(i), i + 1);
            wordToIndex.put(words[i], i + 1);
        }

        return true;
    }
}