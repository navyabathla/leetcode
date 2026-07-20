class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();

        // Count frequency
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // Min Heap
        PriorityQueue<Map.Entry<String, Integer>> pq =
                new PriorityQueue<>((a, b) -> {
                    if (!a.getValue().equals(b.getValue())) {
                        return a.getValue() - b.getValue();   // Smaller frequency first
                    }
                    return b.getKey().compareTo(a.getKey());  // Lexicographically larger first
                });

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(entry);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        LinkedList<String> result = new LinkedList<>();

        while (!pq.isEmpty()) {
            result.addFirst(pq.poll().getKey());
        }

        return result;
    }
}