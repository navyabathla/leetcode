class Solution {
    public boolean makeEqual(String[] words) {
        int n = words.length;

        int[] count = new int[26];

        for (String word : words) {
            for (char ch : word.toCharArray()) {
                count[ch - 'a']++;
            }
        }

        return Arrays.stream(count).allMatch(c -> c % n == 0);

    }
}