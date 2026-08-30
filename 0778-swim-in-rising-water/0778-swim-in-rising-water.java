class Solution {

    public int swimInWater(int[][] grid) {

        int n = grid.length;

        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        // {cost, row, column}
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        dist[0][0] = grid[0][0];

        pq.add(new int[]{grid[0][0], 0, 0});

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int cost = current[0];
            int r = current[1];
            int c = current[2];

            // Ignore outdated entry
            if (cost > dist[r][c]) {
                continue;
            }

            // Destination reached
            if (r == n - 1 && c == n - 1) {
                return cost;
            }

            // Explore neighbors
            for (int[] dir : directions) {

                int nr = r + dir[0];
                int nc = c + dir[1];

                // Boundary check
                if (nr < 0 || nr >= n ||
                    nc < 0 || nc >= n) {
                    continue;
                }

                // Water level required for this path
                int newCost =
                    Math.max(cost, grid[nr][nc]);

                // Found a better path
                if (newCost < dist[nr][nc]) {

                    dist[nr][nc] = newCost;

                    pq.add(new int[]{
                        newCost,
                        nr,
                        nc
                    });
                }
            }
        }

        return -1;
    }
}