class Solution {
    public int leastInterval(char[] tasks, int n) {

        // Count frequency of each task
        int[] freq = new int[26];

        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Max Heap
        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder());

        // Add frequencies
        for (int f : freq) {
            if (f > 0) {
                pq.offer(f);
            }
        }

        int time = 0;

        while (!pq.isEmpty()) {

            // We can process at most n + 1 tasks in one cycle
            int cycle = n + 1;
            List<Integer> remaining = new ArrayList<>();

            // Pick the most frequent tasks
            while (cycle > 0 && !pq.isEmpty()) {

                int f = pq.poll();

                f--;

                if (f > 0) {
                    remaining.add(f);
                }

                time++;
                cycle--;
            }

            // Put remaining frequencies back
            for (int f : remaining) {
                pq.offer(f);
            }

            // If tasks are still left, we need idle time
            if (!pq.isEmpty()) {
                time += cycle;
            }
        }

        return time;
    }
}