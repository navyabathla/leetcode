class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Count frequency
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Min heap: [number, frequency]
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (int num : map.keySet()) {

            int freq = map.get(num);

            pq.offer(new int[]{num, freq});

            // Keep only k most frequent elements
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Build answer
        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll()[0];
        }

        return ans;
    }
}