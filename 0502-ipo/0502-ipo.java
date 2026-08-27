class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        // Min Heap: [capital required, profit]
        PriorityQueue<int[]> minHeap =
            new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Max Heap: profit
        PriorityQueue<Integer> maxHeap =
            new PriorityQueue<>(Collections.reverseOrder());

        // Put all projects into min heap
        for (int i = 0; i < profits.length; i++) {
            minHeap.offer(new int[]{capital[i], profits[i]});
        }

        // Select at most k projects
        for (int i = 0; i < k; i++) {

            // Move all projects we can currently afford
            while (!minHeap.isEmpty() &&
                   minHeap.peek()[0] <= w) {

                int[] project = minHeap.poll();

                maxHeap.offer(project[1]);
            }

            // No affordable project
            if (maxHeap.isEmpty()) {
                break;
            }

            // Choose the most profitable affordable project
            w += maxHeap.poll();
        }

        return w;
    }
}