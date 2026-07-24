class Solution {
    public List<Integer> findAnagrams(String s, String p) {
         List<Integer> result = new ArrayList<>();

        int[] freq = new int[26];

        int m = s.length();
        int n = p.length();

        if (n > m)
            return result;

        // Store frequency of characters in p
        for (char ch : p.toCharArray()) {
            freq[ch - 'a']++;
        }

        int i = 0;

        for (int j = 0; j < m; j++) {
            freq[s.charAt(j) - 'a']--;

            if (j - i + 1 == n) {

                if (isZero(freq)) {
                    result.add(i);
                }

                freq[s.charAt(i) - 'a']++;
                i++;
            }
        }

        return result;
    }

    private boolean isZero(int[] freq) {
        for (int count : freq) {
            if (count != 0)
                return false;
        }
        return true;
    }
}