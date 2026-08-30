class Solution {

    static class Pair {
        int node;
        int time;

        Pair(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {

        // Build adjacency list
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // Directed graph
        for (int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new Pair(v, w));
        }

        // Shortest distances
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Min heap
        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(a.time, b.time));

        dist[k] = 0;
        pq.add(new Pair(k, 0));

        // Dijkstra
        while (!pq.isEmpty()) {

            Pair current = pq.poll();

            int node = current.node;
            int currentTime = current.time;

            // Ignore outdated entry
            if (currentTime > dist[node]) {
                continue;
            }

            for (Pair next : adj.get(node)) {

                int neighbor = next.node;
                int weight = next.time;

                int newTime = currentTime + weight;

                if (newTime < dist[neighbor]) {

                    dist[neighbor] = newTime;

                    pq.add(new Pair(neighbor, newTime));
                }
            }
        }

        // Find the time when the last node receives the signal
        int answer = 0;

        for (int i = 1; i <= n; i++) {

            // Some node never received the signal
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            answer = Math.max(answer, dist[i]);
        }

        return answer;
    }
}