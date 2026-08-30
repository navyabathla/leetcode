class Solution {

    public boolean isBipartite(int[][] graph) {

        int n = graph.length;

        // -1 = uncolored
        //  0 = color 0
        //  1 = color 1
        int[] color = new int[n];

        Arrays.fill(color, -1);

        // Graph can have multiple components
        for (int i = 0; i < n; i++) {

            if (color[i] != -1) {
                continue;
            }

            Queue<Integer> queue = new LinkedList<>();

            color[i] = 0;
            queue.add(i);

            while (!queue.isEmpty()) {

                int node = queue.poll();

                for (int neighbor : graph[node]) {

                    // Neighbor not colored yet
                    if (color[neighbor] == -1) {

                        color[neighbor] = 1 - color[node];

                        queue.add(neighbor);
                    }

                    // Neighbor already has same color
                    else if (color[neighbor] == color[node]) {

                        return false;
                    }
                }
            }
        }

        return true;
    }
}