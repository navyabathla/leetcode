class Solution {

    public int findCheapestPrice(
            int n,
            int[][] flights,
            int src,
            int dst,
            int k) {

        int INF = Integer.MAX_VALUE;

        int[] dist = new int[n];

        Arrays.fill(dist, INF);

        dist[src] = 0;

        // At most k stops = k + 1 flights
        for (int i = 0; i <= k; i++) {

            int[] temp = dist.clone();

            for (int[] flight : flights) {

                int u = flight[0];
                int v = flight[1];
                int price = flight[2];

                if (dist[u] != INF) {

                    temp[v] = Math.min(
                        temp[v],
                        dist[u] + price
                    );
                }
            }

            dist = temp;
        }

        return dist[dst] == INF ? -1 : dist[dst];
    }
}