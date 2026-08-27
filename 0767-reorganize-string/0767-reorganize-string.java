class Solution {
    public String reorganizeString(String s) {

        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.offer(new int[]{i, freq[i]});
            }
        }

        StringBuilder ans = new StringBuilder();

        while (pq.size() >= 2) {

            int[] first = pq.poll();
            int[] second = pq.poll();

            // Use two different characters
            ans.append((char) ('a' + first[0]));
            ans.append((char) ('a' + second[0]));

            first[1]--;
            second[1]--;

            if (first[1] > 0) {
                pq.offer(first);
            }

            if (second[1] > 0) {
                pq.offer(second);
            }
        }

        // One character remains
        if (!pq.isEmpty()) {

            int[] last = pq.poll();

            if (last[1] > 1) {
                return "";
            }

            ans.append((char) ('a' + last[0]));
        }

        return ans.toString();
    }
}